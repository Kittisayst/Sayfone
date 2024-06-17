package Controller;

import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Log.JoLoger;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.JoSheet;
import Utility.MonthCaculator;
import Utility.MyFormat;
import View.ReportPaymentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportPaymentController implements JoMVC, ActionListener, ItemListener, MouseListener {

    private final ReportPaymentView view;
    private List<FinancialModel> reportData = new ArrayList<>();

    public ReportPaymentController(ReportPaymentView view) {
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
//        view.getTb_data().addMouseListener(this);
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
            showReport();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void showClassRoom() {
        RegisterService registerService = new RegisterService();
        int yearD = view.getCbYear().getKeyInt();
        view.showClassRoom(registerService.getRegisterAllByYearID(yearD));
    }

    int amount = 0;
    int money = 0;
    int transfer = 0;
    int food = 0;
    int discount = 0;
    int overpay = 0;

    private void showReport() {
        reportData = new ArrayList<>();
        resetMoney();
        FinancialService financialService = new FinancialService();
        MonthCaculator mc = new MonthCaculator();
        int registerID = view.getCbClassRoom().getKeyInt();
        switch (view.getMonth()) {
            case 0:
                List<FinancialModel> financialModels = financialService.getStudentRegistered(registerID);
                for (FinancialModel financialModel : financialModels) {
                     FinancialModel data = financialService.getReportPaymentWithAllMonth(registerID, financialModel.getStudentID());
                     String parsemonth = mc.ToArrayMonth(data.getFinancialMonth()).toString();
                     data.setFinancialMonth(mc.getArrangeMonth(parsemonth));
                     reportData.add(data);
                     sumMoney(data.getMoney(), data.getTransferMoney(), data.getFoodMoney(), data.getDiscount(), data.getOvertimePay());
                }
                view.showReport(reportData);
                break;
            default:
                List<FinancialModel> models = financialService.getReportPaymentWithMonth(registerID, view.getMonth() + "");
                models.forEach(data -> {
                    reportData.add(data);
                    sumMoney(data.getMoney(), data.getTransferMoney(), data.getFoodMoney(), data.getDiscount(), data.getOvertimePay());
                });
                view.showReport(reportData);
                break;
        }

    }

    private void resetMoney() {
        amount = 0;
        money = 0;
        transfer = 0;
        food = 0;
        discount = 0;
        overpay = 0;
    }

    private void sumMoney(int summoney, int sumtransfer, int sumfood, int sumdiscount, int sumoverpay) {
        amount = 0;
        money += summoney;
        transfer += sumtransfer;
        food += sumfood;
        discount += sumdiscount;
        overpay += sumoverpay;
        amount = money + transfer + food + discount + overpay;
        view.setAmount(money, transfer, food, discount, overpay, amount);
    }

    int row = 1;

    private void ExportData() {
        UserService userService = new UserService();
        StudentService studentService = new StudentService();
        MyFormat format = new MyFormat();
        view.getLoading().setTitle("ກຳລັງສ້າງ Excel ລາຍງານການຈ່າຍຄ່າຮຽນ");
        Thread thread = new Thread(() -> {
            try {
                JoFileSystem fileSystem = new JoFileSystem();
                String genfileName = "ລາຍງານຈ່າຍຄ່າຮຽນ " + view.getClassName() + "" + new MyFormat().getTime(new Date(), "-HH-mm-ss") + ".xls";
                String csvFile = fileSystem.getUserPath() + "/Downloads/" + genfileName;
                String[] columns = {
                    "ລຳດັບ",
                    "ເລກທີບິນ",
                    "ຫ້ອງຮຽນ",
                    "ຊື່ ແລະ ນາມສະກຸນນັກຮຽນ",
                    "ເງິນສົດ",
                    "ເງິນໂອນ",
                    "ສ່ວນຫຼຸດ",
                    "ຈ່າຍຊ້າ",
                    "ຄ່າອາຫານ",
                    "ຈ່າຍເດືອນ",
                    "ເດືອນອາຫານ",
                    "ວັນທີລົງບັນຊີ",
                    "ໝາຍເຫດ",
                    "ຜູ້ລົງບັນຊີ"
                };
                JoSheet sheet = new JoSheet(csvFile, view.getCbClassRoom().getSelectedItem().toString(), columns);
                GlobalDataModel.rootView.setView(view.getLoading());
                reportData.forEach(data -> {
                    UserModel userModel = userService.getUserById(data.getUserID());
                    StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                    sheet.addRow(row++,
                            row - 1,
                            data.getFinancialIID(),
                            view.getClassName(),
                            studentModel.getFullName(),
                            format.formatMoney(data.getMoney()),
                            format.formatMoney(data.getTransferMoney()),
                            format.formatMoney(data.getDiscount()),
                            format.formatMoney(data.getOvertimePay()),
                            format.formatMoney(data.getFoodMoney()),
                            data.getFinancialMonth(),
                            data.getFoodMonth(),
                            format.getDate(data.getFinancialDate()),
                            data.getFinancialComment(),
                            userModel.getFullName()
                    );
                    view.getLoading().StartProgress(reportData.size(), 100);
                });
                sheet.getCreateSheet();
                fileSystem.OpenFile(csvFile);
            } catch (Exception e) {
                e.printStackTrace();
                JoAlert.Error(e, this);
                JoLoger.saveLog(e, this);
            } finally {
                view.getLoading().close();
                row = 1;
                GlobalDataModel.rootView.setView(view);
            }
        });
        thread.start();
    }

    private void updateFoodMoney(FinancialModel financialModel) {
        for (FinancialModel item : reportData) {
            if (item.equals(financialModel)) {
                item.setFoodMoney(financialModel.getFoodMoney());
                item.setFoodMonth(financialModel.getFoodMonth());
            }
        }
    }

}
