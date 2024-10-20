package Controller;

import App.AppFinancial;
import App.AppFinancialRoom;
import App.AppRegister;
import App.AppStudent;
import App.AppTeacher;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.TeacherService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import View.DasboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DasboardController implements JoMVC, MouseListener, ActionListener, KeyListener {

    private final DasboardView view;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final FinancialService financialService;
    private final RegisterService registerService;

    public DasboardController(DasboardView view) {
        this.view = view;
        studentService = new StudentService();
        teacherService = new TeacherService();
        financialService = new FinancialService();
        registerService = new RegisterService();
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
//        GlobalDataModel.rootView.setView(view);
        view.ShowStudentCount(financialService.getCountStudentNew(), financialService.getCountOldStudent());
        view.ShowTeacherCount(teacherService.getTeacherCount());
        view.showFinalcailCount(financialService.getCountFinancial());
        view.showRegisterCount(registerService.getCountRegister());
        view.showClassRoom(GlobalDataModel.registerModels);
        view.showYear();
    }

    @Override
    public final void AddEvent() {
        view.getDs_Student().getLbl_more().addMouseListener(this);
        view.getDs_Teacher().getLbl_more().addMouseListener(this);
        view.getDs_Financail().getLbl_more().addMouseListener(this);
        view.getDs_ClassRoom().getLbl_more().addMouseListener(this);
        view.getTbData().addMouseListener(this);
        view.getBtnSearch().addActionListener(this);
        view.getTxtSearch().addKeyListener(this);
    }

    public void UpdateView() {
        view.ShowStudentCount(financialService.getCountStudentNew(), financialService.getCountOldStudent());
        view.ShowTeacherCount(teacherService.getTeacherCount());
        view.showFinalcailCount(financialService.getCountFinancial());
        view.showRegisterCount(registerService.getCountRegister());
        view.showClassRoom(GlobalDataModel.registerModels);

//        view.getTbData().addMouseListener(this);
//        view.getDs_Student().getLbl_more().addMouseListener(this);
//        view.getDs_Teacher().getLbl_more().addMouseListener(this);
//        view.getDs_Financail().getLbl_more().addMouseListener(this);
//        view.getDs_ClassRoom().getLbl_more().addMouseListener(this);
//        view.getBtnSearch().addActionListener(this);
    }

    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean emptyData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getDs_Student().getLbl_more())) {
            AppStudent appStudent = new AppStudent();
        } else if (event.isEvent(view.getDs_Teacher().getLbl_more())) {
            AppTeacher appTeacher = new AppTeacher();
        } else if (event.isEvent(view.getDs_Financail().getLbl_more())) {
            AppFinancialRoom room = new AppFinancialRoom();
            room.open();
        } else if (event.isEvent(view.getDs_ClassRoom().getLbl_more())) {
            AppRegister appRegister = new AppRegister();
            appRegister.OpenRegister();
        } else if (event.isEvent(view.getTbData())) {
            if (e.getClickCount() == 2) {
                registerStudent();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtnSearch())) {
            view.showTableData(new StudentService().getSearchStudentDashboard(view.getTxtSearch().getText()));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTxtSearch())) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                view.showTableData(new StudentService().getSearchStudentDashboard(view.getTxtSearch().getText()));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void registerStudent() {
        JoAlert alert = new JoAlert();
        int yearID = view.getYearID();
        int financialID = view.getFinancialID();
        if (financialID > 0) {
            FinancialModel financialModel = financialService.getFinancialById(financialID);
            int registerID = financialModel.getRegisterID();
            RegisterModel registerModel = registerService.getRegisterById(registerID);
            int regisYearID = registerModel.getYearID();
            if (regisYearID == yearID) {
                    StudentModel studentModel = studentService.getStudentById(financialModel.getStudentID());
                    AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
            } else {
                alert.setButtonOption(new String[]{"ເລືອນຫ້ອງຮຽນ", "ຍົກເລີກ"});
                int conff = alert.messages("ລົງທະບຽນ", "ນັກຮຽນຍັງບໍ່ທັນໄດ້ລົງທະບຽນໃນສົກຮຽນ " + view.getYear(), JoAlert.Icons.warning);
                if (conff == 0) {
                    AppFinancialRoom financialRoom = new AppFinancialRoom();
                    financialRoom.open();
                }
            }
        } else {
            alert.setButtonOption(new String[]{"ເລືອນຫ້ອງຮຽນ", "ຍົກເລີກ"});
            int conff = alert.messages("ລົງທະບຽນ", "ນັກຮຽນຍັງບໍ່ທັນໄດ້ລົງທະບຽນ ຕ້ອງການເລືອກຫ້ອງລົງທະບຽນຫຼືບໍ່", JoAlert.Icons.warning);
            if (conff == 0) {
                AppFinancialRoom financialRoom = new AppFinancialRoom();
                financialRoom.open();
            }
        }
    }

}
