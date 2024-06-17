package Controller;

import App.AppFinancial;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Log.JoLoger;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.JoSheet;
import Utility.MonthCaculator;
import Utility.MyFormat;
import View.PnLoading;
import View.ReportFoodView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReportFoodController implements JoMVC, ActionListener, ItemListener, MouseListener {

    private ReportFoodView view;
    private List<FinancialModel> listFinancials = new ArrayList<>();
    private PnLoading loading = new PnLoading();
    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();
    private MyFormat format = new MyFormat();
    MonthCaculator monthCaculator = new MonthCaculator();
    private int row = 1;

    public ReportFoodController(ReportFoodView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showYear(new YearService().getYearAll());
        showClassRoom();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getCbYear().addItemListener(this);
        view.getBtnShow().addActionListener(this);
        view.getBtnExport().addActionListener(this);
        view.getTb_data().addMouseListener(this);
    }

    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean emptyData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtnShow())) {
            FinancialService financialService = new FinancialService();
            int registerID = view.getCbClassRoom().getKeyInt();
            List<FinancialModel> students = financialService.getStudentRegistered(registerID);
            if (view.getMonth() == 0) {
                List<FinancialModel> foodpayments = new ArrayList<>();
                for (FinancialModel student : students) {
                    FinancialModel data = financialService.getReportFoodPaymentWithAllMonth(registerID, student.getStudentID());
                    String parsemonth = monthCaculator.getFormatAllMonthToArray(data.getFoodMonth()).toString();
                    if (!parsemonth.equals("[]")) {
                        data.setFoodMonth(monthCaculator.getArrangeMonth(parsemonth));
                        foodpayments.add(data);
                    }
                }
                view.showFood(foodpayments);
                createListExport(foodpayments);
            } else {
                List<FinancialModel> foodpayments = financialService.getReportFoodPaymentWithMonth(registerID, view.getMonth() + "");
                view.showFood(foodpayments);
                createListExport(foodpayments);
            }
        } else if (event.isEvent(view.getBtnExport())) {
            ExportData();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getCbYear())) {
            showClassRoom();
        }
    }

    private void showClassRoom() {
        RegisterService registerService = new RegisterService();
        int yearD = view.getCbYear().getKeyInt();
        view.showClassRoom(registerService.getRegisterAllByYearID(yearD));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                int studentID = view.getTb_data().getIntValue(3);
                int registerID = view.getTb_data().getIntValue(2);
                RegisterModel registerModel = new RegisterService().getRegisterById(registerID);
                StudentModel studentModel = new StudentService().getStudentById(studentID);
                AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    int amount = 0;

    private void createListExport(List<FinancialModel> reportUserFinancial) {
        FinancialService financialService = new FinancialService();
        listFinancials.clear();
        amount = 0;
        switch (view.getMonth()) {
            case 0:
                reportUserFinancial.forEach(data -> {
                    FinancialModel financialModel = financialService.getFinancialCalculator(data.getRegisterID(), data.getStudentID());
                    if (financialModel.getFoodMoney() > 0) {
                        int[] findMissingMonth = monthCaculator.parseMonth(financialModel.getFoodMonth());
                        String strmonth = Arrays.toString(findMissingMonth);
                        financialModel.setFoodMonth(monthCaculator.getArrangeMonth(strmonth));
                        addReportFood(financialModel);
                    }
                });
                view.setAmount(amount);
                break;
            case 13:
                reportUserFinancial.forEach(data -> {
                    List<Integer> months = monthCaculator.StringToArray(data.getFoodMonth());
                    boolean isMonth = months.contains(0); // 0 ແມ່ນບໍ່ເລືອກເດືອນໃດເລີຍ StringToArray ຖ້າບໍ່ເດືອນເປັນ [] ຈະສົ່ງຄ່າເປັນ 0
                    if (isMonth) {
                        addReportFood(data);
                    }
                });
                view.setAmount(amount);
                break;
            default:
                reportUserFinancial.forEach(data -> {
                    System.out.println(data.getFoodMonth());
                    List<Integer> months = monthCaculator.StringToArray(data.getFoodMonth());
                    boolean isMonth = months.contains(view.getMonth());
                    if (isMonth) {
                        addReportFood(data);
                    }
                });
                view.setAmount(amount);
                break;
        }

    }

    private void addReportFood(FinancialModel model) {
        listFinancials.add(model);
        amount += model.getFoodMoney();
    }

    private void ExportData() {
        view.getBtnExport().setEnabled(false);
        Thread thread = new Thread(() -> {
            try {
                JoFileSystem fileSystem = new JoFileSystem();
                String genfileName = "Export" + new MyFormat().getTime(new Date(), "-HH-mm-ss") + ".xls";
                String csvFile = fileSystem.getUserPath() + "/Downloads/" + genfileName;
                String[] columns = {
                    "ລຳດັບ",
                    "ຫ້ອງຮຽນ",
                    "ລະຫັດນັກຮຽນ",
                    "ຊື່ ແລະ ນາມສະກຸນນັກຮຽນ",
                    "ຄ່າອາຫານ",
                    "ຈ່າຍເດືອນ",
                    "ຜູ້ລົງບັນຊີ",
                    "ໝາຍເຫດ"
                };
                JoSheet sheet = new JoSheet(csvFile, view.getExportName(), columns);
                GlobalDataModel.rootView.setView(loading);
                listFinancials.forEach(data -> {
                    if (data.getFoodMoney() > 0) {
                        UserModel userModel = userService.getUserById(data.getUserID());
                        StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                        if (view.getMonth() == 0) {
                            sheet.addRow(row++,
                                    row - 1,
                                    view.getClassName(),
                                    studentModel.getStudentNo(),
                                    studentModel.getFullName(),
                                    format.formatMoney(data.getFoodMoney()),
                                    data.getFoodMonth(),
                                    userModel.getFullName(),
                                    data.getFinancialComment()
                            );
                        } else {
                            sheet.addRow(row++,
                                    row - 1,
                                    view.getClassName(),
                                    studentModel.getStudentNo(),
                                    studentModel.getFullName(),
                                    format.formatMoney(data.getFoodMoney()),
                                    view.getMonth() == 13 ? 0 : view.getMonth(),
                                    userModel.getFullName(),
                                    data.getFinancialComment()
                            );
                        }
                        loading.StartProgress(listFinancials.size(), 100);
                    }
                });
                sheet.getCreateSheet();
                fileSystem.OpenFile(csvFile);
            } catch (Exception e) {
                e.printStackTrace();
                JoAlert.Error(e, this);
                JoLoger.saveLog(e, this);
            } finally {
                loading.close();
                row = 1;
                view.ExportEnable();
                GlobalDataModel.rootView.setView(view);
            }
        });
        thread.start();
    }

}
