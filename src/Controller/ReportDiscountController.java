package Controller;

import App.AppDashboard;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Log.JoLoger;
import Model.FinancialModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.JoSheet;
import Utility.MonthCaculator;
import Utility.MyFormat;
import View.HomeView;
import View.PnLoading;
import View.ReportDiscountView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SwingUtilities;

public class ReportDiscountController implements JoMVC, ActionListener, ItemListener {

    private ReportDiscountView view;
    private List<FinancialModel> listFinancials = new ArrayList<>();
    private PnLoading loading = new PnLoading();
    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();
    private MyFormat format = new MyFormat();
    MonthCaculator monthCaculator = new MonthCaculator();
    private int amount = 0;
    private int row = 1;

    public ReportDiscountController(ReportDiscountView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
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

    private void showClassRoom() {
        RegisterService registerService = new RegisterService();
        int yearD = view.getCbYear().getKeyInt();
        view.showClassRoom(registerService.getRegisterAllByYearID(yearD));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            HomeView.MyRouter.setRouter(AppDashboard.dasboardView);
        } else if (event.isEvent(view.getBtnShow())) {
            FinancialService service = new FinancialService();
            int registerID = view.getCbClassRoom().getKeyInt();
            view.showDiscount(service.getStudentRegistered(registerID));
            createListExport(service.getStudentRegistered(registerID));
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

    private void createListExport(List<FinancialModel> reportUserFinancial) {
        listFinancials.clear();
        amount = 0;
        reportUserFinancial.forEach(data -> {
            listFinancials.add(data);
            amount += data.getDiscount();
        });
        view.ExportEnable();
        view.setAmount(amount);
    }

    private void ExportData() {
        Thread thread = new Thread(() -> {
            try {
                JoFileSystem fileSystem = new JoFileSystem();
                String genfileName = "Export ສ່ວນຫຼຸດ" + new MyFormat().getTime(new Date(), "-HH-mm-ss") + ".xls";
                String csvFile = fileSystem.getUserPath() + "/Downloads/" + genfileName;
                String[] columns = {
                    "ລຳດັບ",
                    "ຫ້ອງຮຽນ",
                    "ລະຫັດນັກຮຽນ",
                    "ຊື່ ແລະ ນາມສະກຸນນັກຮຽນ",
                    "ສ່ວນຫຼຸດ",
                    "ເດືອນ",
                    "ຜູ້ລົງບັນຊີ"
                };
                JoSheet sheet = new JoSheet(csvFile, view.getExportName(), columns);
                HomeView.MyRouter.setRouter(view.getPnLoading());
                listFinancials.forEach(data -> {
                    if (data.getDiscount() > 0) {
                        view.getPnLoading().startState();
                        UserModel userModel = userService.getUserById(data.getUserID());
                        StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                        int num = view.getPnLoading().getState();
                        sheet.addRow(num,
                                num - 1,
                                view.getClassName(),
                                studentModel.getStudentNo(),
                                studentModel.getFullName(),
                                format.formatMoney(data.getDiscount()),
                                data.getFinancialMonth(),
                                userModel.getFullName()
                        );
                        SwingUtilities.invokeLater(() -> {
                            view.getPnLoading().StartProgress(listFinancials.size());
                        });
                        view.getPnLoading().setSleep(100);
                    }
                });
                sheet.getCreateSheet();
            } catch (Exception e) {
                e.printStackTrace();
                JoAlert.Error(e, this);
                JoLoger.saveLog(e, this);
            } finally {
                view.ExportEnable();
                HomeView.MyRouter.setRouter(view);
                view.getPnLoading().close();
            }
        });
        thread.start();
    }

}
