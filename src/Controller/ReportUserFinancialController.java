package Controller;

import App.AppFinancial;
import Component.DialogTransferImage;
import DAOSevervice.FileTransferService;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Log.JoLoger;
import Model.FileTranferModel;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Tools.JoIconFont;
import Utility.JoSheet;
import Utility.MyFormat;
import Utility.MyPopup;
import View.PnLoading;
import View.ReportUserFainancialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.MyColor;

public class ReportUserFinancialController implements JoMVC, ActionListener, MouseListener {

    private final ReportUserFainancialView view;
    private MyPopup popup;
    private FinancialService service;
    private List<FinancialModel> listFinancials = new ArrayList<>();
    private PnLoading loading = new PnLoading();
    private RegisterService registerService = new RegisterService();
    private StudentService studentService = new StudentService();
    private MyFormat format = new MyFormat();

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
        GlobalDataModel.rootView.setView(view);
        view.showYear(new YearService().getYearAll());
        view.showUser(new UserService().getUserAll());
        view.setDateNow();
        view.ExportEnable();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnShow().addActionListener(this);
        view.getTb_data().addMouseListener(this);
        view.getBtnExport().addActionListener(this);
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
            GlobalDataModel.rootView.showDashbord();
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
        } else if (event.isEvent(view.getBtnExport())) {
            ExportData();
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
        createListExport(service.getReportUserFinancial(yearID, UserID, dateStart, dateEnd));
        view.ExportEnable();
    }

    int amountMoney = 0;
    int amountTransfer = 0;

    private void createListExport(List<FinancialModel> reportUserFinancial) {
        listFinancials.clear();
        amountMoney = 0;
        amountTransfer = 0;
        reportUserFinancial.forEach(data -> {
            listFinancials.add(data);
            amountMoney += data.getMoney();
            amountTransfer += data.getTransferMoney();
        });
        view.ExportEnable();
        view.setAMountMoney(amountMoney, amountTransfer);
    }

    private int row = 1;

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
                GlobalDataModel.rootView.setView(loading);
                listFinancials.forEach(data -> {
                    RegisterModel registerModel = registerService.getRegisterById(data.getRegisterID());
                    StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                    sheet.addRow(row++,
                            row - 1,
                            data.getFinancialIID(),
                            registerModel.getClassRoomName(),
                            studentModel.getFullName(),
                            format.formatMoney(data.getMoney()),
                            format.formatMoney(data.getTransferMoney()),
                            format.formatMoney(data.getDiscount()),
                            format.formatMoney(data.getOvertimePay()),
                            format.formatMoney(data.getFoodMoney()),
                            data.getFinancialMonth(),
                            format.getDate(data.getFinancialDate()),
                            data.getFinancialComment(),
                            view.getCbUser().getValue()
                    );
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

    private void showDialogFinancial(FinancialModel model) {
        studentService = new StudentService();
        registerService = new RegisterService();
        RegisterModel registerModel = registerService.getRegisterById(model.getRegisterID());
        StudentModel studentModel = studentService.getStudentById(model.getStudentID());
        String userName = view.getCbUser().getValue();
        UserService userService = new UserService();
        UserModel userModel = userService.getUserById(model.getAuthenUserID());
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
        DialogTransferImage transferImage = new DialogTransferImage(GlobalDataModel.rootView, true, fileTranferModel.getImageIcon());
        transferImage.setVisible(true);
    }

}
