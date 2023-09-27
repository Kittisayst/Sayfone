package Controller;

import App.AppStudentData;
import App.AppStudentHistory;
import Component.DialogBrotherAndSister;
import DAOSevervice.BroderSisterService;
import Model.StudentHistoryModel;
import Model.StudentAddressModel;
import DAOSevervice.DistrictService;
import DAOSevervice.EthnicService;
import DAOSevervice.NationalityService;
import DAOSevervice.ProvinceService;
import DAOSevervice.ReligionService;
import DAOSevervice.StudentAddressService;
import DAOSevervice.StudentHistoryService;
import DAOSevervice.StudentService;
import Model.BrotherAndSisterModel;
import Model.GlobalDataModel;
import Model.StudentModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Tools.JoIconFont;
import Utility.MyPopup;
import View.StudentHistoryView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;

public class StudentHistoryController implements JoMVC, ActionListener, MouseListener, ItemListener {

    private final StudentHistoryView view;
    private final StudentHistoryModel model;
    private final StudentHistoryService historyService;
    private final ProvinceService provinceService;
    private final DistrictService districtService;
    private final StudentAddressService addressService;
    private final int studentID;
    private final StudentAddressModel addressModel;
    private final int TapIndex;
    private MyPopup popup;

    public StudentHistoryController(StudentHistoryView view, StudentHistoryModel model, int StudentID, int TapIndex) {
        this.view = view;
        this.model = model;
        studentID = StudentID;
        this.TapIndex = TapIndex;
        historyService = new StudentHistoryService();
        provinceService = new ProvinceService();
        districtService = new DistrictService();
        addressService = new StudentAddressService();
        addressModel = addressService.getStudentLocationByStudentID(StudentID);
        popup = new MyPopup();
        popup.getItemshow().setText("ສະແດງຂໍ້ມູນ");
        popup.getItemEdit().setText("ເພີ່ມອ້າຍນ້ອງ");
        popup.getItemEdit().setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.ADD, 25, Color.BLUE));
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
        try {
            view.getTapHistory().setSelectedIndex(TapIndex);
            GlobalDataModel.rootView.setView(view);
            view.showProvince(provinceService.getAllProvince());
            view.showProvinceNow(provinceService.getAllProvince());
            int provinceID = view.getCb_province().getKeyInt();
            int provinceNowID = view.getCb_provinceNow().getKeyInt();
            view.showDistrict(districtService.getProvinceById(provinceID));
            view.showDistrictNow(districtService.getProvinceById(provinceNowID));
            view.showHistory(model);
            view.showStudnetAddress(addressService.getStudentLocationByStudentID(studentID));
            BrotherAndSisterController brotherAndSisterController = new BrotherAndSisterController(view, studentID);
            brotherAndSisterController.Start();
            brotherAndSisterController.AddEvent();
        } catch (Exception ex) {
            Logger.getLogger(StudentHistoryController.class.getName()).log(Level.SEVERE, null, ex);
            JoAlert.Error(ex, this);
        }
    }

    @Override
    public final void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_saveHistory().addActionListener(this);
        view.getBtn_saveLocation().addActionListener(this);
        view.getCb_province().addItemListener(this);
        view.getCb_provinceNow().addItemListener(this);
        view.getTb_BrotherAndSister().addMouseListener(this);
        popup.addActionListener(this);
    }

    @Override
    public void Create() {
        model.setHistroyID(0);
        model.setStudentID(studentID);
        model.setFamilyID(view.getTxt_FamiltyID().getText());
        model.setPeopleID(view.getTxt_peopleID().getText());
        model.setPassportID(view.getTxt_passportID().getText());
        model.setSiblingName(view.getTxt_SiblingName().getText());
        model.setSiblingAge(view.getTxt_SiblingAge().getNumber());
        model.setSiblingJob(view.getTxt_SiblingJob().getText());
        model.setSiblingPlace(view.getTxt_SiblingPlace().getText());
        model.setSiblingTel(view.getTxt_SiblingTel().getText());
        model.setHigth(view.getTxt_Higth().getNumber());
        model.setWeight(view.getTxt_Weight().getNumber());
        model.setFatherName(view.getTxt_fatherName().getText());
        model.setFatherAge(view.getTxt_fatherAge().getNumber());
        model.setFatherJob(view.getTxt_fatherJob().getText());
        model.setFatherPlace(view.getTxt_fatherPlace().getText());
        model.setFatherTel(view.getTxt_fatherTel().getText());
        model.setMotherName(view.getTxt_MotherName().getText());
        model.setMotherAge(view.getTxt_MotherAge().getNumber());
        model.setMotherJob(view.getTxt_MotherJob().getText());
        model.setMotherPlace(view.getTxt_MotherPlace().getText());
        model.setMotherTel(view.getTxt_MotherTel().getText());
        if (view.getRd_BloodGroupA().isSelected()) {
            model.setBloodGroup(0);
        } else if (view.getRd_BloodGroupB().isSelected()) {
            model.setBloodGroup(1);
        } else if (view.getRd_BloodGroupAB().isSelected()) {
            model.setBloodGroup(3);
        } else {
            model.setBloodGroup(4);
        }
        if (view.getRd_DiverCategoryCar().isSelected()) {
            model.setDiverCategory(0);
        } else if (view.getRd_DiverCategoryMotobike().isSelected()) {
            model.setDiverCategory(1);
        } else {
            model.setDiverCategory(2);
        }
        int respon = historyService.CreaterStudentHistory(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppStudentHistory appStudentHistory = new AppStudentHistory(studentID, 0);
        }
    }

    private void CreateAddress() {
        addressModel.setAddressID(0);
        addressModel.setStudentID(studentID);
        addressModel.setDistrictID(view.getCb_district().getKeyInt());
        addressModel.setDistrictNowID(view.getCb_districtNow().getKeyInt());
        addressModel.setVillage(view.getTxt_village().getText());
        addressModel.setVillageNow(view.getTxt_villageNow().getText());
        int respon = addressService.CreaterStudentLocation(addressModel);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppStudentHistory appStudentHistory = new AppStudentHistory(studentID, 1);
        }
    }

    @Override
    public void Update() {
        model.setFamilyID(view.getTxt_FamiltyID().getText());
        model.setPeopleID(view.getTxt_peopleID().getText());
        model.setPassportID(view.getTxt_passportID().getText());
        model.setSiblingName(view.getTxt_SiblingName().getText());
        model.setSiblingAge(view.getTxt_SiblingAge().getNumber());
        model.setSiblingJob(view.getTxt_SiblingJob().getText());
        model.setSiblingPlace(view.getTxt_SiblingPlace().getText());
        model.setSiblingTel(view.getTxt_SiblingTel().getText());
        model.setHigth(view.getTxt_Higth().getNumber());
        model.setWeight(view.getTxt_Weight().getNumber());
        model.setFatherName(view.getTxt_fatherName().getText());
        model.setFatherAge(view.getTxt_fatherAge().getNumber());
        model.setFatherJob(view.getTxt_fatherJob().getText());
        model.setFatherPlace(view.getTxt_fatherPlace().getText());
        model.setFatherTel(view.getTxt_fatherTel().getText());
        model.setMotherName(view.getTxt_MotherName().getText());
        model.setMotherAge(view.getTxt_MotherAge().getNumber());
        model.setMotherJob(view.getTxt_MotherJob().getText());
        model.setMotherPlace(view.getTxt_MotherPlace().getText());
        model.setMotherTel(view.getTxt_MotherTel().getText());
        if (view.getRd_BloodGroupA().isSelected()) {
            model.setBloodGroup(0);
        } else if (view.getRd_BloodGroupB().isSelected()) {
            model.setBloodGroup(1);
        } else if (view.getRd_BloodGroupAB().isSelected()) {
            model.setBloodGroup(3);
        } else {
            model.setBloodGroup(4);
        }
        if (view.getRd_DiverCategoryCar().isSelected()) {
            model.setDiverCategory(0);
        } else if (view.getRd_DiverCategoryMotobike().isSelected()) {
            model.setDiverCategory(1);
        } else {
            model.setDiverCategory(2);
        }
        int respon = historyService.UpdateStudentHistory(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppStudentHistory appStudentHistory = new AppStudentHistory(studentID, 0);
        }
    }

    private void UpdateAddress() {
        System.out.println(addressModel);
        addressModel.setDistrictID(view.getCb_district().getKeyInt());
        addressModel.setDistrictNowID(view.getCb_districtNow().getKeyInt());
        addressModel.setVillage(view.getTxt_village().getText());
        addressModel.setVillageNow(view.getTxt_villageNow().getText());
        int respon = addressService.UpdateStudentLocation(addressModel);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppStudentHistory appStudentHistory = new AppStudentHistory(studentID, 1);
        }
    }

    @Override
    public void Delete() {

    }

    public void DeleteAddress() {

    }

    @Override
    public boolean emptyData() {
        return false;
    }

    private boolean emptyAddress() {
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppStudentData appStudentData = new AppStudentData(studentID);
        } else if (event.isEvent(view.getBtn_saveHistory())) {
            if (model.getHistroyID() == 0) {
                Create();
            } else {
                Update();
            }
        } else if (event.isEvent(view.getBtn_saveLocation())) {
            StudentAddressModel locationModel = addressModel;
            if (locationModel.getAddressID() == 0) {
                CreateAddress();
            } else {
                UpdateAddress();
            }
        } else if (event.isEvent(popup.getItemshow())) {
            int stID = view.getTb_BrotherAndSister().getIntValue(2);
            StudentService studentService = new StudentService();
            StudentModel model = studentService.getStudentById(stID);
            String NationalyName = new NationalityService().getNationalityById(model.getNationalityID()).getNationalityName();
            String ReligionName = new ReligionService().getReligionModelById(model.getReligionID()).getReligionName();
            String EthnicName = new EthnicService().getEthnicById(model.getEthnicID()).getEthnicName();
            String[] students = new String[]{
                "ລະຫັດນັກຮຽນ: " + model.getStudentNo() + "   ຊື່ ແລະ ນາມສະກຸນ: " + model.getFullName(),
                "ຊື່ ແລະ ນາມສະກຸນ (ອັງກິດ): " + model.getStudentENG() + "   ຊື່ຫຼີ້ນ: " + model.getNickName(),
                "ວັນເດືອນປີເກີດ: " + model.getDateofBirth() + "   ອ້າຍນ້ອງທັງໝົດ: " + model.getSibling(),
                "ໂຮງຮຽນທີ່ຜ່ານມາລ່າສຸດ: " + model.getPreschool() + "   ຄວາມສາມາດພິເສດ: " + model.getTalent(),
                "ວັນທີ່ເລີ່ມຮຽນ: " + model.getDateStart() + "   ວັນທີ່ອອກຮຽນ: " + model.getDateStop(),
                "ສະຖານະນັກຮຽນ: " + model.getStatusName() + "   ສຸກຂະພາບ: " + model.getHealthName(),
                "ສັກຢາກັນພະຍາດ: " + model.getVucinStateName() + "   ພິການ: " + model.getDisabled() + "   ອະນຸຍາດ ໃຫ້ກັບເຮືອນຕອນທ່ຽງ " + model.getGohomeName(),
                "ສັນຊາດ: " + NationalyName + "   ສາດສະໜາ: " + ReligionName + "   ຊົນເຜົ່າ: " + EthnicName,};
            JoAlert alert = new JoAlert();
            alert.messages("ຂໍ້ມູນນັກຮຽນ", students, JoAlert.Icons.info);
        } else if (event.isEvent(popup.getItemEdit())) {
            DialogBrotherAndSister dialogBrotherAndSister = new DialogBrotherAndSister(GlobalDataModel.rootView, true, studentID);
            dialogBrotherAndSister.setVisible(true);
        } else if (event.isEvent(popup.getItemDelete())) {
            JoAlert alert = new JoAlert();
            if (alert.JoSubmitDelete()) {
                int bsID = view.getTb_BrotherAndSister().getIntValue(1);
                BroderSisterService service = new BroderSisterService();
                service.DeleteBrotherAndSister(new BrotherAndSisterModel(bsID, 0, 0));
                AppStudentHistory appStudentHistory = new AppStudentHistory(studentID, 2);
            }
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
        if (event.isEvent(view.getTb_BrotherAndSister())) {
            popup.ShowPopup(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getCb_province())) {
            int provinceID = view.getCb_province().getKeyInt();
            view.showDistrict(districtService.getProvinceById(provinceID));
        } else if (event.isEvent(view.getCb_provinceNow())) {
            int provinceNowID = view.getCb_provinceNow().getKeyInt();
            view.showDistrictNow(districtService.getProvinceById(provinceNowID));
        }
    }

}
