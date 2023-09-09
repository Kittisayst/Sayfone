package Controller;

import App.About;
import App.AppAbsent;
import App.AppClass;
import App.AppDashboard;
import App.AppFinancialRoom;
import App.AppRegister;
import App.AppReportFinacial;
import App.AppReportFood;
import App.AppReportUserFinancial;
import App.AppSetting;
import App.AppStudent;
import App.AppSubject;
import App.AppTeacher;
import App.AppTeacherRank;
import App.AppTutorial;
import App.AppUser;
import App.AppWithdraw;
import App.ReportPayApp;
import Model.UserModel;
import DAOSevervice.TeacherService;
import DAOSevervice.UserService;
import Model.GobalData;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import View.HomeView;
import View.PrinterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class HomeController implements JoMVC, ActionListener, MouseListener {

    private final HomeView view;
    private final UserModel userModel;

    public HomeController(UserService userService, HomeView view, UserModel userModel) {
        this.view = view;
        this.userModel = userModel;
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
        view.setVisible(true);
        GobalData.UserID = userModel.getUserID();
        view.getLblVersion().setText(new About().getVersion());
        JoFileSystem fileSystem = new JoFileSystem();
        String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
        view.showBandLogo(new ImageIcon(logo));
        TeacherService teacherService = new TeacherService();
        view.showUserName(teacherService.getTeacherById(userModel.getTeacherID()));
        AppDashboard dashboard = new AppDashboard();
        //============ Hind Module ===================
        view.getBtnSubject().setVisible(false);
        view.getBtnSubjectTeacher().setVisible(false);
    }

    @Override
    public final void AddEvent() {
        view.getBtn_home().addActionListener(this);
        view.getBtn_teacher().addActionListener(this);
        view.getBtn_Menu().addActionListener(this);
        view.getBtn_Student().addActionListener(this);
        view.getBtnSubject().addActionListener(this);
        view.getBtnClass().addActionListener(this);
        view.getBtnAbsent().addActionListener(this);
        view.getBtn_Register().addActionListener(this);
        view.getBtnFinancial().addActionListener(this);
        view.getBtnReportFinancial().addActionListener(this);
        view.getLblTutorial().addMouseListener(this);
        view.getBtnTeacherRank().addActionListener(this);
        view.getBtnReportPay().addActionListener(this);
        view.getBtnUser().addActionListener(this);
        view.getBtnInfo().addActionListener(this);
        view.getBtnPrinter().addActionListener(this);
        view.getBtnWithdraw().addActionListener(this);
        view.getBtnFood().addActionListener(this);
        view.getBtnReportUserFinancial().addActionListener(this);
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
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_home())) {  // ============== ໜ້າຫຼັ້ກ
            AppDashboard dashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtn_teacher())) {  // ======== ຈັດການຂໍ້ມູນ
            AppTeacher appTeacher = new AppTeacher();
        } else if (event.isEvent(view.getBtn_Menu())) {
            view.getPn_Menu().setVisible(!view.getPn_Menu().isVisible());
        } else if (event.isEvent(view.getBtn_Student())) {
            AppStudent appStudent = new AppStudent();
        } else if (event.isEvent(view.getBtnSubject())) {
            AppSubject appSubject = new AppSubject();
        } else if (event.isEvent(view.getBtnUser())) {
            AppUser user = new AppUser();
            user.Open();
        }else if (event.isEvent(view.getBtnClass())) {
            AppClass appClass = new AppClass();
            appClass.Open();
        }  else if (event.isEvent(view.getBtn_Register())) { // ======== ການຮຽນການສອນ
            AppRegister appRegister = new AppRegister();
            appRegister.OpenRegister();
        } else if (event.isEvent(view.getBtnFinancial())) {
            AppFinancialRoom app = new AppFinancialRoom();
            app.open();
        }else if (event.isEvent(view.getBtnAbsent())) {
            AppAbsent absent = new AppAbsent();
            absent.Open();
        }  else if (event.isEvent(view.getBtnReportFinancial())) { // ===== ລາຍງານຂໍ້ມູນ
            AppReportFinacial appReportFinacial = new AppReportFinacial();  
        }else if (event.isEvent(view.getBtnReportUserFinancial())) {
            AppReportUserFinancial userFinancial = new AppReportUserFinancial();
            userFinancial.OPen();
        } else if (event.isEvent(view.getBtnFood())) {
            AppReportFood reportFood = new AppReportFood();
            reportFood.open();
        }  else if (event.isEvent(view.getBtnTeacherRank())) {
            AppTeacherRank appTeacherRank = new AppTeacherRank();
        } else if (event.isEvent(view.getBtnReportPay())) {
            ReportPayApp reportPayApp = new ReportPayApp();
            reportPayApp.Running();
        }else if (event.isEvent(view.getBtnWithdraw())) {
            AppWithdraw appWithdraw = new AppWithdraw();
            appWithdraw.Open();
        }  else if (event.isEvent(view.getBtnInfo())) {   // ============ ຕັ້ງຄ່າ
            AppSetting app = new AppSetting();
            app.Open();
        } else if (event.isEvent(view.getBtnPrinter())) {
            HomeView.MyRouter.setRouter(new PrinterView("ຕັ້ງຄ່າປີ້ນເຕີ"));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getLblTutorial())) {
            AppTutorial tutorial = new AppTutorial();
            tutorial.OpentTutorail();
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
