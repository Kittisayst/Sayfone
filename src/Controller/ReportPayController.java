package Controller;

import App.AppDashboard;
import App.AppFinancial;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Log.JoLoger;
import Model.FinancialModel;
import Model.RegisterModel;
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
import View.ReportPayView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SwingUtilities;

public class ReportPayController implements JoMVC, ActionListener, ItemListener, MouseListener {

    private final ReportPayView view;
    private final FinancialModel model;
    private List<FinancialModel> listFinancials = new ArrayList<>();
    private PnLoading loading = new PnLoading();
    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();
    private MyFormat format = new MyFormat();
    MonthCaculator monthCaculator = new MonthCaculator();
    private int row = 1;

    public ReportPayController(ReportPayView view, FinancialModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showYear(new YearService().getYearAll());
        view.getCbYear().setSelectedIndex(new YearService().getYearAll().size() - 1);
        view.showClassRoom(new RegisterService().getRegisterAllByYearID(view.getCbYear().getKeyInt()));
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnShow().addActionListener(this);
        view.getCbYear().addItemListener(this);
        view.getTb_data().addMouseListener(this);
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
            AppDashboard dashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtnShow())) {
            FinancialService financialService = new FinancialService();
            view.showReportPay(financialService.getStudentRegistered(view.getCbClassRoom().getKeyInt()));
            createListExport(financialService.getStudentRegistered(view.getCbClassRoom().getKeyInt()));
        } else if (event.isEvent(view.getBtnExport())) {
            ExportData();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getCbYear())) {
            view.showClassRoom(new RegisterService().getRegisterAllByYearID(view.getCbYear().getKeyInt()));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                RegisterModel registerModel = new RegisterService().getRegisterById(view.getCbClassRoom().getKeyInt());
                StudentModel studentModel = new StudentService().getStudentById(view.getTb_data().getIntValue(2));
                AppFinancial app = new AppFinancial(registerModel, studentModel);
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

    private void createListExport(List<FinancialModel> reportUserFinancial) {
        listFinancials.clear();
        reportUserFinancial.forEach(data -> {
            listFinancials.add(data);
        });
        view.ExportEnable();
    }

    private void ExportData() {
        Thread thread = new Thread(() -> {
            try {
                JoFileSystem fileSystem = new JoFileSystem();
                String genfileName = "Export" + new MyFormat().getTime(new Date(), "-HH-mm-ss") + ".xls";
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
                    "ເດືອນ",
                    "ວັນທີລົງບັນຊີ",
                    "ໝາຍເຫດ",
                    "ຜູ້ລົງບັນຊີ"
                };
                JoSheet sheet = new JoSheet(csvFile, view.getExportName(), columns);
                HomeView.MyRouter.setRouter(loading);
                listFinancials.forEach(data -> {
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
                            monthCaculator.getMissingMonth(data.getFinancialMonth()),
                            format.getDate(data.getFinancialDate()),
                            data.getFinancialComment(),
                            userModel.getFullName()
                    );
                    int progress = (int) ((double) row / listFinancials.size() * 100);
                    SwingUtilities.invokeLater(() -> {
                        loading.setValue(progress);
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                sheet.getCreateSheet();
            } catch (Exception e) {
                e.printStackTrace();
                JoAlert.Error(e, this);
                JoLoger.saveLog(e, this);
            } finally {
                row = 1;
                HomeView.MyRouter.setRouter(view);
            }
        });
        thread.start();
    }

}
