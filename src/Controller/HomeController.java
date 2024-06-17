package Controller;

import App.About;
import App.AppAbsent;
import App.AppBackup;
import App.AppClass;
import App.AppDocument;
import App.AppFinancialRoom;
import App.AppPermission;
import App.AppRegister;
import App.AppReportDiscount;
import App.AppReportFinacial;
import App.AppReportFood;
import App.AppReportParentJob;
import App.AppReportPayment;
import App.AppReportStudent;
import App.AppReportStudentState;
import App.AppReportTeacherMoney;
import App.AppReportUserClassMoney;
import App.AppReportUserFinancial;
import App.AppSetting;
import App.AppStudent;
import App.AppSubject;
import App.AppTeacher;
import App.AppTeacherRank;
import App.AppTutorial;
import App.AppUser;
import App.AppWithdraw;
import App.AppReportPayLateApp;
import App.AppReportPayLateFoodApp;
import Component.DialogSettingPayment;
import Model.UserModel;
import DAOSevervice.TeacherService;
import DAOSevervice.UserService;
import Model.GlobalDataModel;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import View.HomeView;
import View.PrinterView;
import View.TimingView;
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
        view.getBtnFoodPayment().setVisible(false);
    }

    @Override
    public final void Start() {
        view.setVisible(true);
        view.setLblVersion(new About().getVersion());
        JoFileSystem fileSystem = new JoFileSystem();
        String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
        view.showBandLogo(new ImageIcon(logo));
        TeacherService teacherService = new TeacherService();
        view.showUserName(teacherService.getTeacherById(userModel.getTeacherID()));
        view.setView(GlobalDataModel.dasboardView);
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
        view.getBtnReportUserClassMoney().addActionListener(this);
        view.getLblTutorial().addMouseListener(this);
        view.getBtnTeacherRank().addActionListener(this);
        view.getBtnReportPay().addActionListener(this);
        view.getBtnUser().addActionListener(this);
        view.getBtnInfo().addActionListener(this);
        view.getBtnWithdraw().addActionListener(this);
        view.getBtnFood().addActionListener(this);
        view.getBtnReportUserFinancial().addActionListener(this);
        view.getBtnReportStudent().addActionListener(this);
        view.getBtnReportDiscount().addActionListener(this);
        view.getBtnReportTeacherMoney().addActionListener(this);
        view.getBtnPermission().addActionListener(this);
        view.getBtnPrinter().addActionListener(this);
        view.getBtnBackup().addActionListener(this);
        view.getBtnReportStudentState().addActionListener(this);
        view.getBtnReportPayment().addActionListener(this);
        view.getBtnTiming().addActionListener(this);
        view.getBtnFoodPayment().addActionListener(this);
        view.getBtnDocument().addActionListener(this);
        view.getBtnPaymentSetting().addActionListener(this);
        view.getBtnPayRateFood().addActionListener(this);
        view.getBtnReportParentJob().addActionListener(this);
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
            GlobalDataModel.rootView.showDashbord();
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
        } else if (event.isEvent(view.getBtnClass())) {
            AppClass appClass = new AppClass();
            appClass.Open();
        } else if (event.isEvent(view.getBtnPermission())) {
            AppPermission permission = new AppPermission();
            permission.Open();
        } else if (event.isEvent(view.getBtn_Register())) { // ======== ການຮຽນການສອນ
            AppRegister appRegister = new AppRegister();
            appRegister.OpenRegister();
        } else if (event.isEvent(view.getBtnFinancial())) {
            AppFinancialRoom app = new AppFinancialRoom();
            app.open();
        } else if (event.isEvent(view.getBtnAbsent())) {
            AppAbsent absent = new AppAbsent();
            absent.Open();
        }else if (event.isEvent(view.getBtnDocument())) {
            AppDocument doc = new AppDocument();
            doc.Open();
        }  else if (event.isEvent(view.getBtnReportFinancial())) { // ===== ລາຍງານຂໍ້ມູນ
            AppReportFinacial appReportFinacial = new AppReportFinacial();
        } else if (event.isEvent(view.getBtnReportPayment())) {
            AppReportPayment appReportPayment = new AppReportPayment();
            appReportPayment.Open();
        } else if (event.isEvent(view.getBtnReportUserClassMoney())) {
            AppReportUserClassMoney classMoney = new AppReportUserClassMoney();
            classMoney.Open();
        } else if (event.isEvent(view.getBtnReportUserFinancial())) {
            AppReportUserFinancial userFinancial = new AppReportUserFinancial();
            userFinancial.OPen();
        } else if (event.isEvent(view.getBtnFood())) {
            AppReportFood reportFood = new AppReportFood();
            reportFood.open();
        } else if (event.isEvent(view.getBtnFoodPayment())) {
//            AppReportFoodPayment foodPayment = new AppReportFoodPayment();
//            foodPayment.Open();
        } else if (event.isEvent(view.getBtnTeacherRank())) {
            AppTeacherRank appTeacherRank = new AppTeacherRank();
        } else if (event.isEvent(view.getBtnReportPay())) {
            AppReportPayLateApp reportPayApp = new AppReportPayLateApp();
            reportPayApp.Running();
        }else if (event.isEvent(view.getBtnPayRateFood())) {
            AppReportPayLateFoodApp app = new AppReportPayLateFoodApp();
            app.Running();
        }  else if (event.isEvent(view.getBtnWithdraw())) {
            AppWithdraw appWithdraw = new AppWithdraw();
            appWithdraw.Open();
        } else if (event.isEvent(view.getBtnReportStudent())) {
            AppReportStudent reportStudent = new AppReportStudent();
            reportStudent.Open();
        } else if (event.isEvent(view.getBtnReportDiscount())) {
            AppReportDiscount reportDiscount = new AppReportDiscount();
            reportDiscount.Open();
        } else if (event.isEvent(view.getBtnReportTeacherMoney())) {
            AppReportTeacherMoney reportTeacherMoney = new AppReportTeacherMoney();
            reportTeacherMoney.Open();
        }else if (event.isEvent(view.getBtnReportParentJob())) {
            AppReportParentJob job = new AppReportParentJob();
            job.Open();
        }  else if (event.isEvent(view.getBtnReportStudentState())) {
            AppReportStudentState studentState = new AppReportStudentState();
            studentState.Open();
        } else if (event.isEvent(view.getBtnInfo())) {   // ============ ຕັ້ງຄ່າ
            AppSetting app = new AppSetting();
            app.Open();
        } else if (event.isEvent(view.getBtnPrinter())) {
            GlobalDataModel.rootView.setView(new PrinterView("ຕັ້ງຄ່າປີ້ນເຕີ"));
        } else if (event.isEvent(view.getBtnBackup())) {
            AppBackup backup = new AppBackup();
            backup.Open();
        } else if (event.isEvent(view.getBtnTiming())) {
            TimingView timingView = new TimingView("ຕັ້ງເວລາເປີດປິດຈ່າຍຄ່າຮຽນ");
            GlobalDataModel.rootView.setView(timingView);
        }else if (event.isEvent(view.getBtnPaymentSetting())) {
            DialogSettingPayment payment = new DialogSettingPayment(view, true);
            payment.setVisible(true);
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
