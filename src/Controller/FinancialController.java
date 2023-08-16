package Controller;

import App.AppFinancial;
import App.AppHome;
import App.AppFinancailStudent;
import Component.TransFerDialog;
import DAOSevervice.FileTransferService;
import DAOSevervice.FinancialService;
import DAOSevervice.SayfoneService;
import DAOSevervice.StudentHistoryService;
import DAOSevervice.UserService;
import Database.JoConnect;
import Log.JoLoger;
import Model.FinancialModel;
import Model.CreateRegisterModel;
import Model.FileTranferModel;
import Model.GlobalDataModel;
import Model.GobalData;
import Model.SayfoneModel;
import Model.StudentHistoryModel;
import Model.StudentModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.JoJasperPrinter;
import Utility.MyFormat;
import Utility.MyPopup;
import View.AuthenPopUp;
import View.FinancialView;
import View.HomeView;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import theme.MyColor;

public class FinancialController implements JoMVC, ActionListener, MouseListener {

    private FinancialView view;
    private StudentModel studentModel;
    private CreateRegisterModel registerModel;
    private UserModel userAuthen = new UserModel();
    private FileTranferModel fileTranferModel = new FileTranferModel();
    private MyPopup popup;
    private FinancialModel financialModel = new FinancialModel();
    HashMap<Integer, String> months = new HashMap<>();
    private MyFormat mf = new MyFormat();

    public FinancialController(FinancialView view, StudentModel studentModel, CreateRegisterModel registerModel) {
        this.view = view;
        this.studentModel = studentModel;
        this.registerModel = registerModel;
        popup = new MyPopup();
        popup.getItemshow().setText("ປີ້ນບິນ");
        popup.addMenuItem("ຂໍ້ມູນການໂອນ", GoogleMaterialDesignIcons.CLOUD_UPLOAD,MyColor.yellow700);
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showCurentMonth(); //ສະແດງເດືອນປະຈຸບັນ
        StudentHistoryModel historyModel = new StudentHistoryService().getStudentHistoryByStudentID(studentModel.getStudentID()); //ດຶງປະຫວັດນັກຮຽນ
        view.showParent(historyModel); //ສະແດງປະຫວັດນັກຮຽນ
        List<FinancialModel> models = new FinancialService().getFinancialByStudentID(registerModel.getRegisterID(), studentModel.getStudentID()); //ດຶງຂໍ້ມູນການລົງທະບຽນ
        view.showFinancial(models); // ສະແດງຂໍ້ມູນລົງທະບຽນ
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getCkDiscount().addActionListener(this);
        view.getBtnAddTransfer().addActionListener(this);
        view.getBtnSave().addActionListener(this);
        view.getTb_data().addMouseListener(this);
        popup.addActionListener(this);
        //ເຫດການຂອງເດືອນ
        Component[] components = view.getPnShowMonth().getComponents();
        for (int i = 0; i < components.length; i++) {
            JCheckBox ck = (JCheckBox) components[i];
            final int key = i;
            ck.addActionListener((ActionEvent e) -> {
                if (ck.isSelected()) {
                    months.put(key, key + 1 + "");
                } else {
                    months.remove(key);
                }
                view.showSelectMonth(months);
            });
        }
    }

    private JCheckBox getCheckbox(int index) {
        return (JCheckBox) view.getPnShowMonth().getComponent(index);
    }

    private String convertMonth(HashMap<Integer, String> months) {
        Collection<String> values = months.values();
// Convert the collection to a string array
        String[] valuesArray = values.toArray(String[]::new);
        return Arrays.toString(valuesArray);
    }

    @Override
    public void Create() {
        FinancialService service = new FinancialService();
        FileTransferService transferService = new FileTransferService();
        JoAlert alert = new JoAlert();
        if (view.getTxtTransferMoney().getText().equals("")) {  //ກວດສອບຈຳນວນເງິນໂອນວ່າງ
            if (view.getTxtMoney().TextEmpty()) {  //ກວດສອບຈຳນວນເງິນວ່າງ
                boolean issave = alert.JoSubmit(service.Creater(saveData()), JoAlert.INSERT);
                if (issave) {
                    AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
                }
            }
        } else {
            if (fileTranferModel.getFile() == null) {   // ກວດສອບປ້ອນຂໍ້ມູນການໂອນໃຫ້ຄົວຖ້ວນ
                new JoAlert().messages("ຂໍ້ມູນບໍ່ຄົບ", "ກະລຸນາປ້ອນຂໍ້ມູນການໂອນ " + fileTranferModel.getFile(), JoAlert.Icons.warning);
            } else {
                boolean issave = alert.JoSubmit(service.Creater(saveData()), JoAlert.INSERT);
                if (issave) {
                    fileTranferModel.setFinancialID(service.getMaxFinancialID());
                    transferService.Creater(fileTranferModel);
                    AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
                }
            }
        }

    }

    private FinancialModel saveData() {
        return new FinancialModel(
                0,
                registerModel.getRegisterID(),
                studentModel.getStudentID(),
                (int) mf.unFormatMoney(view.getTxtMoney().getText()),
                (int) mf.unFormatMoney(view.getTxtTransferMoney().getText()),
                mf.getSQLDate(new Date()),
                convertMonth(months),
                view.getTxtComment().getText(),
                userAuthen.getUserID(),
                (int) mf.unFormatMoney(view.getTxtDiscount().getText()),
                (int) mf.unFormatMoney(view.getTxtOverPay().getText()),
                GobalData.UserID);
    }

    private void updateData() {
        financialModel.setMoney((int) mf.unFormatMoney(view.getTxtMoney().getText()));
        financialModel.setTransferMoney((int) mf.unFormatMoney(view.getTxtTransferMoney().getText()));
        financialModel.setFinancialDate(mf.getSQLDate(new Date()));
        financialModel.setFinancialMonth(convertMonth(months));
        financialModel.setFinancialComment(view.getTxtComment().getText());
        financialModel.setAuthenUserID(userAuthen.getUserID());
        financialModel.setDiscount((int) mf.unFormatMoney(view.getTxtDiscount().getText()));
        financialModel.setOvertimePay((int) mf.unFormatMoney(view.getTxtOverPay().getText()));
        financialModel.setUserID(GobalData.UserID);
    }

    @Override
    public void Update() {
        FinancialService service = new FinancialService();
        FileTransferService transferService = new FileTransferService();
        JoAlert alert = new JoAlert();
        if (!view.getTxtTransferMoney().getText().equals("0")) { //ກວດສອບຕ້ອງບັນທຶກການໂອນຫຼືບໍ່
            updateData(); // ຈັດເກັບຂໍ້ມູນໂອນຈາກ View
            if (fileTranferModel.getFileTranferID() == 0) { // ກວດສອບມີການບັນທຶກເອກະສານເງິນໂອນຫຼືບໍ່
                // ບັນທຶກຂໍ້ມູນການໂອນໃໝ່
                fileTranferModel.setFinancialID(financialModel.getFinancialIID());
                service.Update(financialModel);
                alert.JoSubmit(transferService.Creater(fileTranferModel), JoAlert.INSERT);
            } else {
                // ແກ້ໄຂຂໍ້ມູນການໂອນໃໝ່
                service.Update(financialModel);
                if (fileTranferModel.getFileTranferID() != 0) {
                    alert.JoSubmit(transferService.Update(fileTranferModel), JoAlert.UPDATE);
                }
            }
        } else {   // ບັນທຶກສະເພາະເງິນສົດ
            if (view.getTxtMoney().TextEmpty()) {
                updateData(); // ຈັດເກັບຂໍ້ມູນໂອນຈາກ View
                service.Update(financialModel);
                if (fileTranferModel.getFileTranferID() != 0) {
                    alert.JoSubmit(transferService.Update(fileTranferModel), JoAlert.UPDATE);
                }
            }
        }
        AppFinancial appFinancial = new AppFinancial(registerModel, studentModel);
    }

    @Override
    public void Delete() {
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            FinancialService service = new FinancialService();
            FileTransferService transferService = new FileTransferService();
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
        } else if (event.isEvent(view.getCkDiscount())) { //ເລືອກສ່ວນຫຼຸດ
            AuthenPopUp popUp = new AuthenPopUp(AppHome.viewParent, true);
            popUp.setVisible(true);
            userAuthen = popUp.getUserModel();
            if (userAuthen.getUserID() != 0) {
                view.getCkDiscount().setSelected(true);
                view.EnableDisCount(userAuthen);
            } else {
                view.getCkDiscount().setSelected(false);
                view.EnableDisCount(userAuthen);
            }
        } else if (event.isEvent(view.getBtnAddTransfer())) { // ກົດປຸ່ມເພີ່ມເອກະສານການໂອນ
            TransFerDialog dialog = new TransFerDialog(AppHome.viewParent, true, fileTranferModel);
            dialog.setVisible(true);
            fileTranferModel = dialog.getTranferModel();
            System.out.println(fileTranferModel);
        } else if (event.isEvent(view.getBtnSave())) {  // ກົດປຸ່ມບັນທຶກ
            if (financialModel.getFinancialIID() == 0) {
                Create();
            } else {
                Update();
            }
        } else if (event.isEvent(popup.getItemshow())) { //ເມນູສະແດງ
            Printer();
        } else if (event.isEvent(popup.getItemEdit())) { //ເມນູແກ້ໄຂ
            AuthenPopUp popUp = new AuthenPopUp(AppHome.viewParent, true);
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
            AuthenPopUp popUp = new AuthenPopUp(AppHome.viewParent, true);
            popUp.setVisible(true);
            userAuthen = popUp.getUserModel();
            if (userAuthen.getUserID() != 0) {
                showEdit();
                Delete();
            }
        } else if (event.isEvent(popup.getMenuItem(3))) { // ຂໍ້ມູນການໂອນຍ້ອນຫຼັງ
            FinancialService financialService = new FinancialService();
            financialModel = financialService.getFinancialById(view.getTb_data().getIntValue(1));
            fileTranferModel = new FileTransferService().getFileTranferByFinancialID(financialModel.getFinancialIID()); //ດຶງຂໍ້ມູນເອກະສານການໂອນ
            TransFerDialog dialog = new TransFerDialog(AppHome.viewParent, true, fileTranferModel);
            dialog.setVisible(true);
            fileTranferModel = dialog.getTranferModel();
            FileTransferService transferService = new FileTransferService();
            JoAlert alert = new JoAlert();
            if (dialog.isSubmit()) { // ຫວດສອບວ່າມີການກົດບັນທຶກຫຼືບໍ່
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
        }
    }

    private void showEdit() {
        //ລ້າງຂໍ້ມູນຂອງເດືອນເກົ່າທີ່ແກ້ໄຂ
        if (financialModel.getFinancialIID() != 0) {
            view.setSelectMonth(financialModel);
            months.clear();
        }
        FinancialService financialService = new FinancialService();
        financialModel = financialService.getFinancialById(view.getTb_data().getIntValue(1));
        view.showFinacial(financialModel); //ສະແດງຂໍ້ມູນການລົງທະບຽນເພື່ອແກ້ໄຂໄປທີ view
        fileTranferModel = new FileTransferService().getFileTranferByFinancialID(financialModel.getFinancialIID()); //ດຶງຂໍ້ມູນເອກະສານການໂອນ
        // ສະແດງການເລືອກເດືອນ
        String monstr = financialModel.getFinancialMonth();
        boolean isMonth = !monstr.equals("[]");
        String[] arr = monstr.substring(1, monstr.length() - 1).split(", ");
        if (isMonth) {
            if (arr.length > 0) {
                for (String mon : arr) {
                    getCheckbox(Integer.parseInt(mon) - 1).setSelected(false);
                    getCheckbox(Integer.parseInt(mon) - 1).doClick();
                }
            }
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
        SayfoneService service = new SayfoneService();
        SayfoneModel model = service.getById(1);
        //ດຶງຂໍ້ມູນຜູ້ໃຊ້ງານ
        UserService userService = new UserService();
        UserModel userModel = userService.getUserById(financialModel.getAuthenUserID());
        String authName = userModel.getUserID() == 0 ? "" : userModel.getFullName().toString();
        //ດຶງຂໍ້ມູນຜູ້ປີ້ນ
        String teacherLogin = GlobalDataModel.globalUsermodel.getFullName().toString();
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
        } catch (Exception err) {
            err.printStackTrace();
            JoLoger.saveLog(err, logo);
        }
    }

    private String Charchecked(boolean isCheck) {
        return isCheck ? "☑" : "☐";
    }

}
