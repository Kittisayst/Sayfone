package Controller;

import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.JoSheet;
import Utility.MyFormat;
import View.ReportUserClassRoomMoneyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportUserClassRoomMoneyController implements JoMVC, ActionListener, ItemListener {

    ReportUserClassRoomMoneyView view;
    private FinancialService service;
    private List<FinancialModel> financialModels = new ArrayList<>();
    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();

    public ReportUserClassRoomMoneyController(ReportUserClassRoomMoneyView view) {
        this.view = view;
        service = new FinancialService();
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showUsers(new UserService().getUserAll());
        view.showYear(new YearService().getYearAll());
        showClassRoom();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getCbYear().addItemListener(this);
        view.getBtnsearch().addActionListener(this);
        view.getBtnPrint().addActionListener(this);
    }

    private void showClassRoom() {
        RegisterService registerService = new RegisterService();
        int yearD = view.getyearID();
        view.showClassRoom(registerService.getRegisterAllByYearID(yearD));
        view.EnableSearch();
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
        if (event.isEvent(view.getBtnsearch())) {
            financialModels.clear();
            financialModels = service.getReportUserClassMoney(view.getRegisterID(), view.getUserID());
            view.showFinancailUserClassMoney(financialModels);
        } else if (event.isEvent(view.getBtnPrint())) {
            CreateExport();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getCbYear())) {
            showClassRoom();
        }
    }

    int row = 1;

    private void CreateExport() {
        MyFormat format = new MyFormat();
        Thread thread = new Thread(() -> {
            view.getLoading().setTitle("ກຳລັງສ້າງ Excel ການຈ່າຍຄ່າຮຽນ");
            try {
                JoFileSystem fileSystem = new JoFileSystem();
                String genfileName = "Export" + new MyFormat().getTime(new Date(), "-HH-mm-ss") + ".xls";
                String csvFile = fileSystem.getUserPath() + "/Downloads/" + genfileName;
                String[] columns = {
                    "ລຳດັບ",
                    "ເລກທີບິນ",
                    "ຫ້ອງຮຽນ",
                    "ລະຫັດນັກຮຽນ",
                    "ຊື່ ແລະ ນາມສະກຸນນັກຮຽນ",
                    "ເງິນສົດ",
                    "ເງິນໂອນ",
                    "ຄ່າອາຫານ",
                    "ສ່ວນຫຼຸດ",
                    "ຈ່າຍຊ້າ",
                    "ເດືອນ",
                    "ໝາຍເຫດ",
                    "ຜູ້ອານຸມັດ",
                    "ຜູ້ລົງບັນຊີ"
                };
                JoSheet sheet = new JoSheet(csvFile, view.getClassName(), columns);
                GlobalDataModel.rootView.setView(view.getLoading());
                financialModels.forEach(data -> {
                    UserModel userModel = userService.getUserById(data.getUserID());
                    UserModel authenuserModel = userService.getUserById(data.getAuthenUserID());
                    StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                    sheet.addRow(row++,
                            row - 1,
                            data.getFinancialIID(),
                            view.getClassName(),
                            studentModel.getStudentNo(),
                            studentModel.getFullName(),
                            format.formatMoney(data.getMoney()),
                            format.formatMoney(data.getTransferMoney()),
                            format.formatMoney(data.getFoodMoney()),
                            format.formatMoney(data.getDiscount()),
                            format.formatMoney(data.getOvertimePay()),
                            data.getFinancialMonth(),
                            data.getFinancialComment(),
                            data.getAuthenUserID() > 0 ? authenuserModel.getFullName() : "",
                            userModel.getFullName()
                    );
                     view.getLoading().StartProgress(financialModels.size(), 100);
                });
                sheet.getCreateSheet();
                fileSystem.OpenFile(csvFile);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                view.getLoading().close();
                row = 1;
                GlobalDataModel.rootView.setView(view);
            }
        });
        thread.start();
    }

}
