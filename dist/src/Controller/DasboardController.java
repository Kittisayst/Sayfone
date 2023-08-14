package Controller;

import App.AppFinancialRoom;
import App.AppRegister;
import App.AppStudent;
import App.AppTeacher;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.TeacherService;
import Tools.JoHookEvent;
import View.DasboardView;
import View.HomeView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DasboardController implements JoMVC, MouseListener {

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
        registerService  = new RegisterService();
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
        HomeView.MyRouter.setRouter(view);
        view.ShowStudentCount(studentService.getStudentCount());
        view.ShowTeacherCount(teacherService.getTeacherCount());
        view.showFinalcailCount(financialService.getCountFinancial());
        view.showRegisterCount(registerService.getCountRegister());
    }

    @Override
    public final void AddEvent() {
        view.getDs_Student().getLbl_more().addMouseListener(this);
        view.getDs_Teacher().getLbl_more().addMouseListener(this);
        view.getDs_Financail().getLbl_more().addMouseListener(this);
        view.getDs_ClassRoom().getLbl_more().addMouseListener(this);
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
        }else if (event.isEvent(view.getDs_Financail().getLbl_more())) {
            AppFinancialRoom room = new AppFinancialRoom();
            room.open();
        }else if (event.isEvent(view.getDs_ClassRoom().getLbl_more())) {
            AppRegister appRegister = new AppRegister();
            appRegister.OpenRegister();
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

}
