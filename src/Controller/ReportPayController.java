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

public class ReportPayController implements JoMVC, ActionListener, ItemListener, MouseListener {

    private final ReportPayView view;
    private final FinancialModel model;
    private List<FinancialModel> listFinancials = new ArrayList<>();
    private PnLoading loading = new PnLoading();
    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();
    private MyFormat format = new MyFormat();
    private FinancialService financialService = new FinancialService();
    private int row = 1;

    public ReportPayController(ReportPayView view, FinancialModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showYear(new YearService().getYearAll());
        view.getCbYear().setSelectedIndex(new YearService().getYearAll().size() - 1);
        view.showClassRoom(new RegisterService().getRegisterAllByYearID(view.getCbYear().getKeyInt()));
        view.ExportEnable();
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
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtnShow())) {
            listFinancials.clear();
            listFinancials = financialService.getStudentRegistered(view.getCbClassRoom().getKeyInt());
            view.showReportPay(listFinancials);
            view.ExportEnable();
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

    private void ExportData() {
        loading.setTitle("ກຳລັງສ້າງ Excel ການຄ້າງຄ່າຮຽນຫ້ອງ: " + view.getClassName());
        Thread thread = new Thread(() -> {
            try {
                JoFileSystem fileSystem = new JoFileSystem();
                String genfileName = "Export" + new MyFormat().getTime(new Date(), "-HH-mm-ss") + ".xls";
                String csvFile = fileSystem.getUserPath() + "/Downloads/" + genfileName;
                String[] columns = {
                    "ລຳດັບ",
                    "ຫ້ອງຮຽນ",
                    "ຊື່ ແລະ ນາມສະກຸນນັກຮຽນ",
                    "ຄ້າງເດືອນ",
                    "ຄ່າອາຫານຄ້າງເດືອນ",};
                JoSheet sheet = new JoSheet(csvFile, view.getExportName(), columns);
                GlobalDataModel.rootView.setView(loading);
                MonthCaculator mc = new MonthCaculator();
                listFinancials.forEach(data -> {
                    StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                    FinancialModel fm = financialService.getFinancialCalculator(data.getRegisterID(), data.getStudentID());
                    String findMissingMonth = mc.getMissingMonth(fm.getFinancialMonth());
                    List<Integer> months = mc.getToArray();
                    mc.getMissingMonth(fm.getFoodMonth());
                    List<Integer> foodmonths = mc.getToArray();
                    if (view.getMonth() == 0) {
                        sheet.addRow(row++,
                                row - 1,
                                view.getClassName(),
                                studentModel.getFullName(),
                                findMissingMonth,
                                foodmonths.toString()
                        );
                    } else {
                        List<Integer> disPayMonths = view.filterMonths(months, view.getMonth());
                        List<Integer> disPayFoodMonths = view.filterMonths(foodmonths, view.getMonth());
                        if (!disPayMonths.isEmpty()) {
                            sheet.addRow(row++,
                                    row - 1,
                                    view.getClassName(),
                                    studentModel.getFullName(),
                                    disPayMonths.toString(),
                                    disPayFoodMonths.toString()
                            );
                        }
                    }
                    loading.StartProgress(listFinancials.size(), 100);
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
                GlobalDataModel.rootView.setView(view);
            }
        });
        thread.start();
    }

}
