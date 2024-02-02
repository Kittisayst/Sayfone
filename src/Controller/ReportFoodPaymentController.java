package Controller;

import DAOSevervice.FoodPaymentService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Log.JoLoger;
import Model.FoodPaymentModel;
import Model.GlobalDataModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.JoSheet;
import Utility.MonthCaculator;
import Utility.MyFormat;
import View.PnLoading;
import View.ReportFoodPaymentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;

public class ReportFoodPaymentController implements JoMVC, ActionListener, ItemListener {

    private ReportFoodPaymentView view;
    private PnLoading loading = new PnLoading();
    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();
    private MyFormat format = new MyFormat();
    private int row = 1;

    public ReportFoodPaymentController(ReportFoodPaymentView view) {
        this.view = view;
        loading.setTitle("ກຳລັງສ້າງ Excel");
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
        view.getBtnShow().addActionListener(this);
        view.getBtnExport().addActionListener(this);
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
            int registerID = view.getCbClassRoom().getKeyInt();
            FoodPaymentService paymentService = new FoodPaymentService();
            List<FoodPaymentModel> models = paymentService.getByRegisterID(registerID);
            view.showFood(models);
        } else if (event.isEvent(view.getBtnExport())) {
            int registerID = view.getCbClassRoom().getKeyInt();
            FoodPaymentService paymentService = new FoodPaymentService();
            List<FoodPaymentModel> models = paymentService.getByRegisterID(registerID);
            ExportData(models);
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

    private void ExportData(List<FoodPaymentModel> models) {
        view.getBtnExport().setEnabled(false);
        MonthCaculator mc = new MonthCaculator();
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
                    "ເດືອນ",
                    "ຜູ້ລົງບັນຊີ",
                    "ໝາຍເຫດ"
                };
                JoSheet sheet = new JoSheet(csvFile, view.getExportName(), columns);
                GlobalDataModel.rootView.setView(loading);
                models.forEach(data -> {
                    UserModel userModel = userService.getUserById(data.getUserID());
                    StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                    if (view.getMonth() == 0) {
                        sheet.addRow(row++,
                                row - 1,
                                view.getClassName(),
                                studentModel.getStudentNo(),
                                studentModel.getFullName(),
                                format.formatMoney(data.getPrice()),
                                data.getMonths(),
                                userModel.getFullName(),
                                data.getComment()
                        );
                    } else {
                        List<Integer> months = mc.StringToArray(data.getMonths());
                        boolean isMonth = months.contains(view.getMonth());
                        if (isMonth) {
                            sheet.addRow(row++,
                                    row - 1,
                                    view.getClassName(),
                                    studentModel.getStudentNo(),
                                    studentModel.getFullName(),
                                    format.formatMoney(data.getPrice()),
                                    data.getMonths(),
                                    userModel.getFullName(),
                                    data.getComment()
                            );
                        }
                    }
                    loading.StartProgress(models.size(), 100);
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
