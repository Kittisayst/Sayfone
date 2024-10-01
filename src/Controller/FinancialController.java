package Controller;

import App.AppFinancial;
import App.AppFinancailStudent;
import Component.DialogFinancialTransfer;
import Component.DialogWithdraw;
import DAOSevervice.FileTransferService;
import DAOSevervice.FinancialService;
import DAOSevervice.SayfoneService;
import DAOSevervice.StudentHistoryService;
import DAOSevervice.UserService;
import Database.JoConnect;
import Log.JoLoger;
import Model.FinancialModel;
import Model.RegisterModel;
import Model.FileTranferModel;
import Model.GlobalDataModel;
import Model.SayfoneModel;
import Model.StudentHistoryModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Tools.JoIconFont;
import Utility.JoJasperPrinter;
import Utility.MyFormat;
import Utility.MyPopup;
import Component.AuthenPopUp;
import Component.DialogTransferImage;
import Model.settingPaymentModel;
import Utility.JoSheet;
import View.FinancialView;
import View.PnLoading;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import theme.JoTheme;
import theme.MyColor;

public class FinancialController implements JoMVC, ActionListener, MouseListener, KeyListener {

    private final FinancialView view;
    private final StudentModel studentModel;
    private final RegisterModel registerModel;
    private UserModel userAuthen = new UserModel();
    private FileTranferModel fileTranferModel = new FileTranferModel();
    private final MyPopup popup;
    private FinancialModel financialModel = new FinancialModel();
    HashMap<Integer, String> months = new HashMap<>();
    private final MyFormat mf = new MyFormat();
    FinancialService service = new FinancialService();
    FileTransferService transferService = new FileTransferService();
    private PnLoading loading = new PnLoading();
    MyFormat format = new MyFormat();

    public FinancialController(FinancialView view, StudentModel studentModel, RegisterModel registerModel) {
        this.view = view;
        this.studentModel = studentModel;
        this.registerModel = registerModel;
        popup = new MyPopup();
        popup.getItemshow().setText("ປີ້ນບິນ");
        popup.getItemshow().setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.PRINT, 25, JoTheme.Primary));
        popup.addMenuItem("ຂໍ້ມູນການໂອນ", GoogleMaterialDesignIcons.CLOUD_UPLOAD, MyColor.yellow700);
        popup.addMenuItem("ຖອນເງິນ", GoogleMaterialDesignIcons.SWAP_HORIZ, MyColor.cyan500);
        popup.addMenuItem("ຮູບບິນໂອນເງິນ", GoogleMaterialDesignIcons.COLLECTIONS, MyColor.lime600);
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        financialModel = new FinancialModel();
        view.getFinancialMonths().setSelectCurentMonth(); //ສະແດງເດືອນປະຈຸບັນ
        view.getFoodMonths().setSelectCurentMonth();
        StudentHistoryModel historyModel = new StudentHistoryService().getStudentHistoryByStudentID(studentModel.getStudentID()); //ດຶງປະຫວັດນັກຮຽນ
        view.showParent(historyModel); //ສະແດງປະຫວັດນັກຮຽນ
        List<FinancialModel> models = new FinancialService().getFinancialByStudentID(registerModel.getRegisterID(), studentModel.getStudentID()); //ດຶງຂໍ້ມູນການລົງທະບຽນ
        view.showFinancial(models); // ສະແດງຂໍ້ມູນລົງທະບຽນ
        view.setButtonState();

    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getCkDiscount().addActionListener(this);
        view.getBtnAddTransfer().addActionListener(this);
        view.getBtnSave().addActionListener(this);
        view.getBtnRefresh().addActionListener(this);
        view.getTb_data().addMouseListener(this);
        view.getTxtMoney().addKeyListener(this);
        view.getTxtTransferMoney().addKeyListener(this);
        view.getBtnExport().addActionListener(this);
        popup.addActionListener(this);
    }

    @Override
    public void Create() {
        view.getBtnSave().setEnabled(false);
        try {
            if (!view.TransferMoneyEmpty()) {
                int conf = getAlertSave("ບັນທຶກຂໍ້ມູນ");
                if (conf == 0) {
                    SaveTransferMoney();
                }
            } else {
                int conf = getAlertSave("ບັນທຶກຂໍ້ມູນ");
                if (conf == 0) {
                    SaveMoney();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            view.getBtnSave().setEnabled(true);
        }
    }

    private void SaveMoney() {
        financialModel = FinancialViewData(0);
        int state = service.Creater(financialModel);
        if (state > 0) {
            view.Message("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນຈ່າຍຄ່າຮຽນສຳເລັດ", JoAlert.Icons.success);
            AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
        } else {
            view.Message("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນຈ່າຍຄ່າຮຽນຜິດພາດ", JoAlert.Icons.error);
        }
    }

    private void SaveTransferMoney() {
        if (fileTranferModel.getFile() != null) {
            financialModel = FinancialViewData(0);
            int state = service.Creater(financialModel);
            if (state > 0) {
                fileTranferModel.setFinancialID(service.getMaxFinancialID());
                int tranState = transferService.Creater(fileTranferModel);
                if (tranState > 0) {
                    view.Message("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນຈ່າຍຄ່າຮຽນສຳເລັດ", JoAlert.Icons.success);
                    AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
                } else {
                    view.Message("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນການໂອນຜິດພາດ", JoAlert.Icons.error);
                }
            } else {
                view.Message("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນຈ່າຍຄ່າຮຽນຜິດພາດ", JoAlert.Icons.error);
            }
        } else {
            view.Message("ຂໍ້ມູນການໂອນ", "ກະລຸນາປ້ອນຂໍ້ມູນການໂອນ", JoAlert.Icons.warning);
        }
    }

    //ແກ້ໄຂໄດ້ສະເພາະຜູ້ລົງບັນຊີ
    private boolean isUserUpdate(int UserID) {
        if (GlobalDataModel.userModel.getUserID() == UserID) {
            return true;
        } else {
            JoAlert alert = new JoAlert();
            alert.messages("ແກ້ໄຂ", "ແກ້ໄຂສະເພາະຜູ້ລົງບັນຊີ", JoAlert.Icons.warning);
            return false;
        }
    }

    @Override
    public void Update() {
        view.getBtnSave().setEnabled(false);
        try {
            if (userAuthen.getUserID() > 0) {
                if (!view.getTransferMoneyZero()) {
                    int conf = getAlertSave("ແກ້ໄຂຂໍ້ມູນ");
                    if (conf == 0) {
                        UpdateTransfer();
                    }
                } else {
                    int conf = getAlertSave("ແກ້ໄຂຂໍ້ມູນ");
                    if (conf == 0) {
                        UpdateMoney();
                    }
                }
            } else {
                new JoAlert().messages("ຜູ້ອານຸມັດ", "ບໍ່ມີຂໍ້ມູນຜູ້ອານຸມັດ", JoAlert.Icons.info);
            }
        } catch (Exception e) {
            System.err.println(e);
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            view.setButtonTextState("ບັນທຶກການຈ່າຍຄ້າຮຽນ");
            view.getBtnSave().setEnabled(true);
        }
    }

    private void UpdateMoney() {
        FinancialModel model = FinancialViewData(0);
        model.setFinancialIID(financialModel.getFinancialIID());
        int state = service.Update(model);
        if (state > 0) {
            view.Message("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນຈ່າຍຄ່າຮຽນສຳເລັດ", JoAlert.Icons.success);
            AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
        } else {
            view.Message("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນຈ່າຍຄ່າຮຽນຜິດພາດ", JoAlert.Icons.error);
        }
    }

    private void UpdateTransfer() {
        if (fileTranferModel.getFileName() != null) {
            if (fileTranferModel.getFileTranferID() == 0) {
                CreateTransfer();
                System.out.println("CreateTransfer");
            } else {
                updateTransferOnly();
                System.out.println("updateTransferOnly");
            }
        } else {
            view.Message("ຂໍ້ມູນການໂອນ", "ກະລຸນາປ້ອນຂໍ້ມູນການໂອນ", JoAlert.Icons.warning);
        }
    }

    private void CreateTransfer() {
        FinancialModel model = FinancialViewData(0);
        model.setFinancialIID(financialModel.getFinancialIID());
        int state = service.Update(model);
        if (state > 0) {
            fileTranferModel.setFinancialID(model.getFinancialIID());
            int tState = transferService.Creater(fileTranferModel);
            if (tState > 0) {
                view.Message("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນຈ່າຍຄ່າຮຽນສຳເລັດ", JoAlert.Icons.success);
                AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
            } else {
                view.Message("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນຈ່າຍຄ່າຮຽນເງິນໂອນຜິດພາດ", JoAlert.Icons.error);
            }
        } else {
            view.Message("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນຈ່າຍຄ່າຮຽນຜິດພາດ", JoAlert.Icons.error);
        }
    }

    private void updateTransferOnly() {
        FinancialModel model = FinancialViewData(0);
        model.setFinancialIID(financialModel.getFinancialIID());
        int state = service.Update(model);
        if (state > 0) {
            int tState = transferService.Update(fileTranferModel);
            if (tState > 0) {
                view.Message("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນຈ່າຍຄ່າຮຽນສຳເລັດ", JoAlert.Icons.success);
                AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
            } else {
                view.Message("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນຈ່າຍຄ່າຮຽນເງິນໂອນຜິດພາດ", JoAlert.Icons.error);
            }
        } else {
            view.Message("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນຈ່າຍຄ່າຮຽນຜິດພາດ", JoAlert.Icons.error);
        }
    }

    @Override
    public void Delete() {
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            service.Delete(financialModel);
            if (fileTranferModel.getFileTranferID() != 0) {
                transferService.Delete(fileTranferModel);
            }
            AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
        }
    }

    @Override
    public boolean emptyData() {
        return view.getCkDiscount().isSelected() ? view.getTxtDiscount().TextEmpty() || view.getTxtMoney().TextEmpty() : view.getTxtMoney().TextEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) { // ກັບຄືນ
            AppFinancailStudent app = new AppFinancailStudent(registerModel);
        } else if (event.isEvent(view.getBtnRefresh())) {
            view.getTxtTransferMoney().setText("");
        } else if (event.isEvent(view.getCkDiscount())) { //ເລືອກສ່ວນຫຼຸດ
            settingPaymentModel pm = settingPaymentModel.toAttay(GlobalDataModel.settingModel.getValue());
            if (pm.isDiscount()) {
                view.getTxtDiscount().setEnabled(view.getCkDiscount().isSelected());
                view.getTxtDiscount().requestFocus();
            } else {
                AuthenPopUp popUp = new AuthenPopUp(GlobalDataModel.rootView, true);
                popUp.setVisible(true);
                userAuthen = popUp.getUserModel();
                if (userAuthen.getUserID() != 0) {
                    view.getCkDiscount().setSelected(true);
                    view.EnableDisCount(userAuthen);
                } else {
                    view.getCkDiscount().setSelected(false);
                    view.EnableDisCount(userAuthen);
                }
            }
        } else if (event.isEvent(view.getBtnAddTransfer())) { // ກົດປຸ່ມເພີ່ມຮູບການໂອນ
            DialogFinancialTransfer dialog = new DialogFinancialTransfer(GlobalDataModel.rootView, true, fileTranferModel);
            dialog.setVisible(true);
            fileTranferModel = dialog.getTranferModel();
        } else if (event.isEvent(view.getBtnSave())) {  // ກົດປຸ່ມບັນທຶກ
            if (financialModel.getFinancialIID() == 0) {
                if (view.MoneyEmpty() && view.TransferMoneyEmpty()) {
                    view.Message("ກວດສອບຂໍ້ມູນ", "ຂໍ້ມູນບໍ່ຄົບຖວນກະລຸນາກວດສອບ", JoAlert.Icons.warning);
                    view.getTxtMoney().requestFocus();
                } else {
                    if (view.FoodMoney()) {
                        view.Message("ກວດສອບຂໍ້ມູນ", "ກະລຸນາເລືອກເດືອນໃນການຈາຍຄ່າອາຫານ", JoAlert.Icons.warning);
                    } else {
                        settingPaymentModel pm = settingPaymentModel.toAttay(GlobalDataModel.settingModel.getValue());
                        //ເປີດວົງເງິນສ່ວນຫຼຸດ
                        if (pm.isDiscount()) {
                            if (new MyFormat().unFormatMoney(view.getTxtDiscount().getText()) > pm.getMoney()) {
                                AuthenPopUp popUp = new AuthenPopUp(GlobalDataModel.rootView, true);
                                popUp.setVisible(true);
                                userAuthen = popUp.getUserModel();
                                if (userAuthen.getUserID() != 0) { //ລະຫັດຖືກ
                                    chekPaymentSettingOverpay(); //ກວດສອບຈ່າຍຊ້າ - ບັນທຶກ
                                } else { //ລະຫັດຜິດ
                                    view.getCkDiscount().setSelected(false);
                                    view.EnableDisCount(userAuthen);
                                }
                            } else {
                                chekPaymentSettingOverpay();
                            }
                        } else { //ເປີດຈ່າຍຊ້າ
                            chekPaymentSettingOverpay();
                        }
                    }
                }
            } else {
                if (view.MoneyEmpty() && view.TransferMoneyEmpty()) {
                    view.Message("ກວດສອບຂໍ້ມູນ", "ຂໍ້ມູນບໍຄົບຖວນກະລຸນາກວດສອບ", JoAlert.Icons.warning);
                    view.getTxtMoney().requestFocus();
                } else {
                    if (view.FoodMoney()) {
                        view.Message("ກວດສອບຂໍ້ມູນ", "ກະລຸນາເລືອກເດືອນໃນການຈາຍຄ່າອາຫານ", JoAlert.Icons.warning);
                    } else {
                        if (isUserUpdate(financialModel.getUserID())) {
                            Update();
                        }
                    }
                }
            }
        } else if (event.isEvent(popup.getItemshow())) { //ເມນູສະແດງ
            Printer();
        } else if (event.isEvent(popup.getItemEdit())) { //ເມນູແກ້ໄຂ
            AuthenPopUp popUp = new AuthenPopUp(GlobalDataModel.rootView, true);
            popUp.setVisible(true);
            userAuthen = popUp.getUserModel();
            if (userAuthen.getUserID() != 0) { // ກວດສອບວ່າລະຫັດຢືກຢັນການແກ້ໄຂຖືກຫຼືບໍ່
                showEdit(); // ສະແດງຂໍ້ມູນການແກ້ໄຂ
                view.getCkDiscount().setSelected(true);
                view.EnableDisCount(userAuthen); // ສະແດງຂໍ້ມູນຜູ້ອານຸມັດ
            } else {
                view.getCkDiscount().setSelected(false);
            }
        } else if (event.isEvent(popup.getItemDelete())) { //ເມນູລົບ
            AuthenPopUp popUp = new AuthenPopUp(GlobalDataModel.rootView, true);
            popUp.setVisible(true);
            userAuthen = popUp.getUserModel();
            if (userAuthen.getUserID() != 0) {
                showEdit();
                Delete();
            }
        } else if (event.isEvent(popup.getMenuItem(3))) { // ຂໍ້ມູນການໂອນ
            DialogTransfer();
        } else if (event.isEvent(popup.getMenuItem(4))) {// ຖອນເງິນ
            AuthenPopUp popUp = new AuthenPopUp(GlobalDataModel.rootView, true);
            popUp.setVisible(true);
            userAuthen = popUp.getUserModel();
            if (userAuthen.getUserID() != 0) {
                FinancialModel fm = new FinancialService().getFinancialById(view.getTb_data().getIntValue(1));
                DialogWithdraw dialogWithdraw = new DialogWithdraw(GlobalDataModel.rootView, true, fm, view);
                dialogWithdraw.setUserAuthen(userAuthen);
                dialogWithdraw.setVisible(true);
            }
        } else if (event.isEvent(popup.getMenuItem(5))) {
            showTransferImage();
        } else if (event.isEvent(view.getBtnExport())) {
            List<FinancialModel> models = new FinancialService().getFinancialByStudentID(registerModel.getRegisterID(), studentModel.getStudentID()); //ດຶງຂໍ້ມູນການລົງທະບຽນ
            Export(models);
        }
    }

    private void chekPaymentSettingOverpay() {
        settingPaymentModel pm = settingPaymentModel.toAttay(GlobalDataModel.settingModel.getValue());
        if (pm.isOverpary()) { //ກວດສອບຈ່າຍຊ້າ
            if (repayCheck(view.getFinancialMonths().getMonths())) {
                if (view.getTxtOverPay().TextEmpty()) {
                    Create();
                }
            } else {
                if (isPayFood()) {
                    Create();
                }
            }
        } else {
            if (isPayFood()) {
                Create();
            }
        }
    }

    private boolean isPayFood() {
        if (!view.getFoodMonths().getMonths().equals("[]")) { //ກວດສອບເລືອກເດືອນ
            if (view.getFoodMoney() == 0) { //ບໍ່ປ້ອນເງິນ
                view.Message("ກວດສອບ", "ກະລຸນາປ້ອນເງິນຄ່າອາຫານ", JoAlert.Icons.warning);
                return false;
            } else {
                return true;
            }
        } else { //ບໍ່ເລືອກມີການຈ່າຍຄ່າອາຫານ
            return true;
        }
    }

    private FinancialModel FinancialViewData(int ID) {
        return new FinancialModel(
                0,
                registerModel.getRegisterID(),
                studentModel.getStudentID(),
                view.getMoney(),
                view.getTransferMoney(),
                mf.getSQLDate(new Date()),
                view.getFinancialMonths().getMonths(),
                view.getFoodMonths().getMonths(),
                view.getComment(),
                userAuthen.getUserID(),
                view.getDiscount(),
                view.getOverPay(),
                GlobalDataModel.userModel.getUserID(),
                view.getFoodMoney(),
                true);
    }

    private void showEdit() {
        //ລາງຂໍ້ມູນເມື່ອເລືອກການແກ້ໄຂຫຼາຍຄັ້ງ
        if (financialModel.getFinancialIID() != 0) {
            view.getFinancialMonths().clearMonths();
            view.getFoodMonths().clearMonths();
        }
        // ດຶງຂໍ້ມູນການຈ່າຍເງິນ
        view.setButtonTextState("ແກ້ໄຂການຈ່າຍຄ້າຮຽນ");
        FinancialService financialService = new FinancialService();
        financialModel = financialService.getFinancialById(view.getTb_data().getIntValue(1));
        // =================== ສະແດງຂໍ້ມູນການລົງທະບຽນເພື່ອແກ້ໄຂໄປທີ view =================
        view.showFinacial(financialModel);
        view.setButtonState();
        fileTranferModel = new FileTransferService().getFileTranferByFinancialID(financialModel.getFinancialIID()); //ດຶງຂໍ້ມູນເອກະສານການໂອນ
        // ສະແດງການເລືອກເດືອນ
        view.getFinancialMonths().setEditSelectMonth(financialModel.getFinancialMonth());
        view.getFoodMonths().setEditSelectMonth(financialModel.getFoodMonth());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                FinancialService financialService = new FinancialService();
                financialModel = financialService.getFinancialById(view.getTb_data().getIntValue(1));
            }
        }
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

    public UserModel getUserAuthen() {
        return userAuthen;
    }

    private void Printer() {
        JoFileSystem fileSystem = new JoFileSystem();
        String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
        FinancialService financialService = new FinancialService();
        financialModel = financialService.getFinancialById(view.getTb_data().getIntValue(1));
        //ດຶງຂໍ້ມູນໂຮງຮຽນ
        SayfoneService sayfoneService = new SayfoneService();
        SayfoneModel model = sayfoneService.getById(1);
        //ດຶງຂໍ້ມູນຜູ້ໃຊ້ງານ
        UserService userService = new UserService();
        UserModel userModel = userService.getUserById(financialModel.getAuthenUserID());
        String authName = userModel.getUserID() == 0 ? "" : userModel.getUserName();
        System.out.println(authName);
        //ດຶງຂໍ້ມູນຜູ້ປີ້ນ
        String teacherLogin = GlobalDataModel.userModel.getFullName().toString();
        try {
            if (financialModel.getFinancialIID() != 0) {
                Map parameter = new HashMap();
                parameter.put("financiaID", financialModel.getFinancialIID());
                parameter.put("LogoPath", logo);
                parameter.put("School", model.getSchool());
                parameter.put("English", model.getEnglish());
                parameter.put("Contact", model.getContact());
                parameter.put("Detail", model.getDetail());
                parameter.put("UserAuthen", authName);
                parameter.put("UserPrint", "( " + teacherLogin + " )");
                JasperPrint print = JasperFillManager.fillReport("sayfoneBill.jasper", parameter, new JoConnect().getConnectionDefault());
                if (GlobalDataModel.printerBillState) {
                    new JoJasperPrinter(print).print();
                } else {
                    JasperViewer showReport = new JasperViewer(print, false);
                    showReport.setTitle("sayfoneBill");
                    showReport.setVisible(true);
                }
            }
        } catch (JRException err) {
            err.printStackTrace();
            JoLoger.saveLog(err, logo);
        } finally {
            financialModel = new FinancialModel();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTxtMoney())) {
            view.setButtonState();
        } else if (event.isEvent(view.getTxtTransferMoney())) {
            view.setButtonState();
        }
    }

    private void showTransferImage() {
        try {
            FileTransferService fileTransferService = new FileTransferService();
            FileTranferModel ftm = fileTransferService.getFileTranferByFinancialID(view.getTb_data().getIntValue(1));
            JoAlert alert = new JoAlert();
            if (ftm.getFileTranferID() == 0) {
                alert.messages("ຮູບບິນການໂອນ", "ບໍ່ມີຮູບການໂອນ", JoAlert.Icons.warning);
            } else {
                DialogTransferImage dialog = new DialogTransferImage(GlobalDataModel.rootView, true, ftm.getImageIcon());
                dialog.setVisible(true);
            }
            System.out.println(ftm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DialogTransfer() {
        try {
            FinancialService financialService = new FinancialService();
            financialModel = financialService.getFinancialById(view.getTb_data().getIntValue(1));
            fileTranferModel = new FileTransferService().getFileTranferByFinancialID(financialModel.getFinancialIID()); //ດຶງຂໍ້ມູນເອກະສານການໂອນ
            DialogFinancialTransfer dialog = new DialogFinancialTransfer(GlobalDataModel.rootView, true, fileTranferModel);
            dialog.setVisible(true);
            fileTranferModel = dialog.getTranferModel();
            transferService = new FileTransferService();
            JoAlert alert = new JoAlert();
            if (dialog.isSubmit()) { // ກວດສອບວ່າມີການກົດບັນທຶກຫຼືບໍ່
                if (fileTranferModel.getFileTranferID() == 0) { // ກວດສອບມີການບັນທຶກເອກະສານເງິນໂອນຫຼືບໍ່
                    // ບັນທຶກຂໍ້ມູນການໂອນໃໝ່
                    fileTranferModel.setFinancialID(financialModel.getFinancialIID());
                    alert.JoSubmit(transferService.Creater(fileTranferModel), JoAlert.INSERT);
                } else {
                    // ແກ້ໄຂຂໍ້ມູນການໂອນໃໝ່
                    if (fileTranferModel.getFileTranferID() != 0) {
                        alert.JoSubmit(transferService.Update(fileTranferModel), JoAlert.UPDATE);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            financialModel = new FinancialModel();
            fileTranferModel = new FileTranferModel();
        }
    }

    private int getAlertSave(String title) {
        JoAlert alert = new JoAlert();
        String[] buttontext = {title, "ຍົກເລີກ"};
        alert.setButtonOption(buttontext);
        FinancialModel fm = FinancialViewData(0);
        MyFormat format = new MyFormat();
        String[] message = {
            "ເດືອນຄ່າຮຽນ: " + fm.getFinancialMonth(),
            "ເດືອນຄ່າອາຫານ: " + fm.getFoodMonth(),
            "ເງິນສົດ: " + format.formatMoney(fm.getMoney()) + " ₭",
            "ເງິນໂອນ: " + format.formatMoney(fm.getTransferMoney()) + " ₭",
            "ຄ່າອາຫານ: " + format.formatMoney(fm.getFoodMoney()) + " ₭",
            "ສ່ວນຫຼຸບ: " + format.formatMoney(fm.getDiscount()) + " ₭",
            "ຄ່າຈ່າຍຊ້າ: " + format.formatMoney(fm.getOvertimePay()) + " ₭",
            "ໝາຍເຫດ: " + fm.getFinancialComment()};
        return alert.messages(title, message, JoAlert.Icons.info);
    }

    int row = 1;
    int sumMoney = 0;
    int sumMoneyTransfer = 0;
    int sumMoneyFood = 0;
    int sumDiscount = 0;
    int sumOverplay = 0;

    private void Export(List<FinancialModel> models) {
        view.getBtnExport().setEnabled(false);
        loading.setTitle("ສົ່ງອອກ ການຈ່າຍຄ່າຮຽນ " + studentModel.getFullName());
        Thread thread = new Thread(() -> {
            try {
                JoFileSystem fileSystem = new JoFileSystem();
                String genfileName = "Export ຈ່າຍຄ່າຮຽນ" + studentModel.getFullName() + new MyFormat().getTime(new Date(), "-HH-mm-ss") + ".xls";
                String csvFile = fileSystem.getUserPath() + "/Downloads/" + genfileName;
                String[] columns = {
                    "ລຳດັບ",
                    "ເລກທີບິນ",
                    "ວັນທີເດືອນປີ",
                    "ຈຳນວນເງິນສົດ",
                    "ຈຳນວນເງິນໂອນ",
                    "ເດືອນຄ່າຮຽນ",
                    "ເງິນຄ່າອາຫານ",
                    "ເດືອນຄ່າອາຫານ",
                    "ສ່ວນຫຼຸດ",
                    "ຈ່າຍຊ້າ",
                    "ໝາຍເຫດ",
                    "ຜູ້ລົງບັນຊີ"
                };
                JoSheet sheet = new JoSheet(csvFile, studentModel.getFullName().toString(), columns);
                GlobalDataModel.rootView.setView(loading);
                UserService userService = new UserService();
                models.forEach(data -> {
                    UserModel um = userService.getUserById(data.getUserID());
                    String money = format.formatMoney(data.getMoney());
                    String transfer = format.formatMoney(data.getTransferMoney());
                    sumMoney += data.getMoney();
                    sumMoneyTransfer += data.getTransferMoney();
                    sumMoneyFood += data.getFoodMoney();
                    sumDiscount += data.getDiscount();
                    sumOverplay += data.getOvertimePay();
                    sheet.addRow(
                            row++,
                            row - 1,
                            data.getFinancialIID(),
                            format.getDate(data.getFinancialDate()),
                            money,
                            transfer,
                            data.getFinancialMonth(),
                            format.formatMoney(data.getFoodMoney()),
                            data.getFoodMonth(),
                            data.getDiscount(),
                            data.getOvertimePay(),
                            data.getFinancialComment(),
                            um.getFullName()
                    );
                    loading.StartProgress(models.size(), 100);
                });
                sheet.addRow(
                        row++,
                        "",
                        "",
                        "",
                        format.formatMoney(sumMoney),
                        format.formatMoney(sumMoneyTransfer),
                        "",
                        format.formatMoney(sumMoneyFood),
                        "",
                        format.formatMoney(sumDiscount),
                        format.formatMoney(sumOverplay),
                        "",
                        ""
                );
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

    private boolean repayCheck(String months) {
        if (months.equals("[]")) {
            return false;
        } else {
            LocalDate currentDate = LocalDate.now();
            int monthNow = currentDate.getMonthValue();
            for (Integer month : setMonth(months)) {
                if (month < monthNow) {
                    return true;
                }
            }
            return false;
        }
    }

    private List<Integer> setMonth(String strmonth) {
        List<Integer> listMonth = new ArrayList<>();
        String convert = strmonth.substring(1, strmonth.length() - 1);
        String[] strArray = convert.split(", ");
        for (String strArray1 : strArray) {
            listMonth.add(Integer.valueOf(strArray1));
        }
        return listMonth;
    }

}
