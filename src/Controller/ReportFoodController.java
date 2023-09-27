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
import java.util.Date;
import java.util.List;
import javax.swing.SwingUtilities;

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
            FinancialService service = new FinancialService();
            int registerID = view.getCbClassRoom().getKeyInt();
            view.showFood(service.getStudentRegistered(registerID));
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
        listFinancials.clear();
        amount = 0;
        reportUserFinancial.forEach(data -> {
            listFinancials.add(data);
            amount += data.getFoodMoney();
        });
        view.ExportEnable();
        view.setAmount(amount);
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
                    "ເດືອນ",
                    "ຜູ້ລົງບັນຊີ"
                };
                JoSheet sheet = new JoSheet(csvFile, view.getExportName(), columns);
                GlobalDataModel.rootView.setView(loading);
                listFinancials.forEach(data -> {
                    if (data.getFoodMoney() > 0) {
                        UserModel userModel = userService.getUserById(data.getUserID());
                        StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                        sheet.addRow(row++,
                                row - 1,
                                view.getClassName(),
                                studentModel.getStudentNo(),
                                studentModel.getFullName(),
                                format.formatMoney(data.getFoodMoney()),
                                data.getFinancialMonth(),
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
                    }
                });
                sheet.getCreateSheet();
            } catch (Exception e) {
                e.printStackTrace();
                JoAlert.Error(e, this);
                JoLoger.saveLog(e, this);
            } finally {
                row = 1;
                view.ExportEnable();
                GlobalDataModel.rootView.setView(view);
            }
        });
        thread.start();
    }

}
