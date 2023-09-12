package Controller;

import App.AppDashboard;
import App.AppFinancial;
import App.AppHome;
import Component.DialogTransferImage;
import DAOSevervice.FileTransferService;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Model.FileTranferModel;
import Model.FinancialModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Tools.JoIconFont;
import Utility.MyFormat;
import Utility.MyPopup;
import View.HomeView;
import View.ReportUserFainancialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.MyColor;

public class ReportUserFinancialController implements JoMVC, ActionListener, MouseListener {

    private final ReportUserFainancialView view;
    private MyPopup popup;
    private FinancialService service;

    public ReportUserFinancialController(ReportUserFainancialView view) {
        this.view = view;
        popup = new MyPopup();
        service = new FinancialService();
        popup.getItemshow().setText("ສະແດງລາຍລະອຽດ");
        popup.getItemEdit().setText("ສະແດງຮູບເງິນໂອນ");
        popup.getItemEdit().setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.COLLECTIONS, 20, MyColor.cyan700));
        popup.getItemDelete().setText("ສະແດງຈ່າຍຄ່າຮຽນ");
        popup.getItemDelete().setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.MONETIZATION_ON, 20, MyColor.lightGreen700));
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showYear(new YearService().getYearAll());
        view.showUser(new UserService().getUserAll());
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnShow().addActionListener(this);
        view.getTb_data().addMouseListener(this);
        popup.addActionListener(this);
    }

    @Override
    public void Create() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Delete() {

    }

    @Override
    public boolean emptyData() {
        return view.getDtStart().DateEmpty() && view.getDtEnd().DateEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppDashboard dashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtnShow())) {
            if (emptyData()) {
                showReport();
            }
        } else if (event.isEvent(popup.getItemshow())) {
            int financialID = view.getTb_data().getIntValue(1);
            showDialogFinancial(service.getFinancialById(financialID));
        } else if (event.isEvent(popup.getItemEdit())) {
            int financialID = view.getTb_data().getIntValue(1);
            FileTransferService fileTransferService = new FileTransferService();
            FileTranferModel fileTranferModel = fileTransferService.getFileTranferByFinancialID(financialID);
            showImageTransfer(fileTranferModel);
        } else if (event.isEvent(popup.getItemDelete())) {
            int financialID = view.getTb_data().getIntValue(1);
            FinancialModel financialModel = service.getFinancialById(financialID);
            RegisterModel registerModel = new RegisterService().getRegisterById(financialModel.getRegisterID());
            StudentModel studentModel = new StudentService().getStudentById(financialModel.getStudentID());
            AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            popup.ShowPopup(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void showReport() {
        int yearID = view.getCbYear().getKeyInt();
        int UserID = view.getCbUser().getKeyInt();
        String dateStart = view.getDtStart().getDateSQL();
        String dateEnd = view.getDtEnd().getDateSQL();
        view.showUserFinancial(service.getReportUserFinancial(yearID, UserID, dateStart, dateEnd));
    }

    private void showDialogFinancial(FinancialModel model) {
        StudentService studentService = new StudentService();
        RegisterService registerService = new RegisterService();
        RegisterModel registerModel = registerService.getRegisterById(model.getRegisterID());
        StudentModel studentModel = studentService.getStudentById(model.getStudentID());
        String userName = view.getCbUser().getValue();
        UserService userService = new UserService();
        UserModel userModel = userService.getUserById(model.getAuthenUserID());
        MyFormat format = new MyFormat();
        String[] students = new String[]{
            "ເລກທີ: " + model.getFinancialIID() + "   ຊື່ ແລະ ນາມສະກຸນນັກຮຽນ: " + studentModel.getFullName(),
            "ຫ້ອງຮຽນ " + registerModel.getClassRoomName() + "   ວັນທີເດືອນປີ: " + format.getDate(model.getFinancialDate()),
            "ຈຳນວນເງິນສົດ: " + format.formatMoney(model.getMoney()) + "   ຈຳນວນເງິນໂອນ: " + format.formatMoney(model.getTransferMoney()),
            "ຄ່າອາຫານ: " + format.formatMoney(model.getFoodMoney()) + "   ຈ່າຍປະຈຳເດືອນ: " + model.getFinancialMonth(),
            "ສ່ວນຫຼຸດ: " + format.formatMoney(model.getDiscount()) + "   ຄ່າຈ່າຍຊ້າ: " + format.formatMoney(model.getOvertimePay()),
            "ຜູ້ລົງບັນຊີ: " + userName + "   ຜູ້ອານຸມັດ: " + userModel.getFullName(),
            "ໝາຍເຫດ: " + model.getFinancialComment()};
        JoAlert alert = new JoAlert();
        alert.messages("ຂໍ້ມູນການຈ່າຍຄ່າຮຽນ", students, JoAlert.Icons.info);
    }

    private void showImageTransfer(FileTranferModel fileTranferModel) {
        DialogTransferImage transferImage = new DialogTransferImage(AppHome.viewParent, true, fileTranferModel.getImageIcon());
        transferImage.setVisible(true);
    }

}
