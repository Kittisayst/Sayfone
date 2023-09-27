package Controller;

import App.AppTeacherData;
import App.AppTeacherHistory;
import Model.TeacherAddressModel;
import DAOSevervice.TeacherAddressService;
import Model.TeacherEducationModel;
import Model.TeacherExperienceModel;
import Model.TeacherFileModel;
import Model.TeacherHistoryModel;
import Model.TeacherModel;
import DAOSevervice.DistrictService;
import DAOSevervice.ProvinceService;
import DAOSevervice.TeacherEducationService;
import DAOSevervice.TeacherExperienceService;
import DAOSevervice.TeacherFileService;
import DAOSevervice.TeacherHistoryService;
import DAOSevervice.TeacherService;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoFilechooser;
import Tools.JoHookEvent;
import Utility.MyPopup;
import View.TeacherHistoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TeacherHistoryController implements JoMVC, ActionListener, ChangeListener, ItemListener, MouseListener {

    private final TeacherHistoryView view;
    private final TeacherHistoryModel historyModel;
    private final int TeacherID;
    //========== Address ==========
    private final TeacherAddressService addressService;
    private final ProvinceService provinceService;
    private final DistrictService districtService;
    //============ Educatio =========
    private final MyPopup EducationPopup;
    private final TeacherEducationService educationService;
    private TeacherEducationModel educationModel;
    //============ Experience ========
    private TeacherExperienceModel experienceModel;
    private final MyPopup ExperiencePopup;
    private final TeacherExperienceService experienceService;
    //============ File =============
    private TeacherFileModel fileModel;
    private final JoFilechooser filechooser;
    private final MyPopup FilePopup;
    private boolean open = false;
    private final TeacherFileService fileService;

    public TeacherHistoryController(TeacherHistoryView view, TeacherHistoryModel historyModel, int TeacherID, int TapIndex) {
        this.view = view;
        this.historyModel = historyModel;
        this.TeacherID = TeacherID;
        Start();
        AddEvent();
        //===========Address==========
        addressService = new TeacherAddressService();
        provinceService = new ProvinceService();
        districtService = new DistrictService();
        AddEventAddress();
        //========== Education ===========
        educationService = new TeacherEducationService();
        educationModel = new TeacherEducationModel();
        EducationPopup = new MyPopup();
        addEventEducation();
        //========== Eperience =========
        experienceModel = new TeacherExperienceModel();
        ExperiencePopup = new MyPopup();
        experienceService = new TeacherExperienceService();
        AddEventExperience();
        //======== File=======
        fileModel = new TeacherFileModel();
        FilePopup = new MyPopup();
        filechooser = new JoFilechooser();
        fileService = new TeacherFileService();
        AddEventFile();
        ///======== SELECT Tap ==========
        view.getTab_History().setSelectedIndex(TapIndex);
    }

    @Override
    public final void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showHistory(historyModel);
    }

    private void StartAddress() {
        try {
            view.showProvince(provinceService.getAllProvince());
            view.showProvinceNow(provinceService.getAllProvince());
            view.showDistrict(districtService.getProvinceById(view.getCb_province().getKeyInt()));
            view.showDistrictNow(districtService.getProvinceById(view.getCb_provinceNow().getKeyInt()));
            //show Filter
            view.showTeacherLoaction(addressService.getTeacherAddressById(TeacherID));
        } catch (Exception ex) {
            Logger.getLogger(TeacherHistoryController.class
                    .getName()).log(Level.SEVERE, null, ex);
            JoAlert.Error(ex, this);
        }
    }

    private void StartEducation() {
        view.showEducations(educationService.getALLByTeacherID(TeacherID));
    }

    private void StartExperience() {
        view.showExperiences(experienceService.getAllExperienceByTeacherID(TeacherID));
    }

    private void StartFile() {
        view.showFiles(fileService.getAllTeacherFileByTeacherID(TeacherID));
    }

    //=========== Events ===========
    @Override
    public final void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_saveHistory().addActionListener(this);
        view.getTab_History().addChangeListener(this);
    }

    private void AddEventAddress() {
        view.getCb_province().addItemListener(this);
        view.getCb_provinceNow().addItemListener(this);
        view.getBtn_saveLocation().addActionListener(this);
        view.getTab_History().addChangeListener(this);
    }

    private void AddEventExperience() {
        view.getBtn_SaveExperience().addActionListener(this);
        view.getTb_Experience().addMouseListener(this);
        ExperiencePopup.addActionListener(this);
    }

    private void AddEventFile() {
        FilePopup.addActionListener(this);
        view.getBtn_uploadFile().addActionListener(this);
        view.getTb_TeacherFile().addMouseListener(this);
        view.getBtn_SaveFile().addActionListener(this);
        view.getTb_TeacherFile().addMouseListener(this);
    }

    @Override
    public void Create() {
        historyModel.setTeacherHostoryID(0);
        historyModel.setTeacherID(TeacherID);
        historyModel.setFamilyID(view.getTxt_FamiltyID().getText());
        historyModel.setPeopleID(view.getTxt_peopleID().getText());
        historyModel.setPassportID(view.getTxt_passportID().getText());
        historyModel.setSpouseName(view.getTxt_SpouseName().getText());
        historyModel.setSpouseAge(view.getTxt_SpouseAge().getNumber());
        historyModel.setSpouseJob(view.getTxt_SpouseJob().getText());
        historyModel.setSpousePlace(view.getTxt_SpousePlace().getText());
        historyModel.setSpouseTel(view.getTxt_SpouseTel().getText());
        historyModel.setFatherName(view.getTxt_fatherName().getText());
        historyModel.setFatherAge(view.getTxt_fatherAge().getNumber());
        historyModel.setFatherJob(view.getTxt_fatherJob().getText());
        historyModel.setFatherPlace(view.getTxt_fatherPlace().getText());
        historyModel.setFatherTel(view.getTxt_fatherTel().getText());
        historyModel.setMotherName(view.getTxt_MotherName().getText());
        historyModel.setMotherAge(view.getTxt_MotherAge().getNumber());
        historyModel.setMotherJob(view.getTxt_MotherJob().getText());
        historyModel.setMotherPlace(view.getTxt_MotherPlace().getText());
        historyModel.setMotherTel(view.getTxt_MotherTel().getText());
        if (view.getRd_BloodGroupA().isSelected()) {
            historyModel.setBloodGroup(0);
        } else if (view.getRd_BloodGroupB().isSelected()) {
            historyModel.setBloodGroup(1);
        } else if (view.getRd_BloodGroupAB().isSelected()) {
            historyModel.setBloodGroup(2);
        } else {
            historyModel.setBloodGroup(3);
        }
        if (view.getRd_DiverCategoryCar().isSelected()) {
            historyModel.setDiverCategory(0);
        } else if (view.getRd_DiverCategoryMotobike().isSelected()) {
            historyModel.setDiverCategory(1);
        } else {
            historyModel.setDiverCategory(2);
        }
        historyModel.setDiverID(view.getTxt_DiverID().getText());
        historyModel.setHigth(view.getTxt_Higth().getNumber());
        historyModel.setWeight(view.getTxt_Weight().getNumber());
        JoAlert alert = new JoAlert();
        TeacherHistoryService service = new TeacherHistoryService();
        if (alert.JoSubmit(service.CreaterTeacherHistory(historyModel), JoAlert.INSERT)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 0);
        }
    }

    private void CreateAddress() {
        TeacherAddressModel model = new TeacherAddressModel();
        model.setAddressID(0);
        model.setDistrictID(view.getCb_district().getKeyInt());
        model.setDistrictNowID(view.getCb_districtNow().getKeyInt());
        model.setTeacherID(TeacherID);
        model.setVillage(view.getTxt_village().getText());
        model.setVillageNow(view.getTxt_villageNow().getText());
        int respon = addressService.CreaterTeacherAddress(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 1);
        }
    }

    private void CreateEducation() {
        educationModel = new TeacherEducationModel();
        educationModel.setTeacherEducationID(0);
        educationModel.setTeacherID(TeacherID);
        if (view.getRd_Middle().isSelected()) {
            educationModel.setEducationCat(0);
        } else if (view.getRd_High().isSelected()) {
            educationModel.setEducationCat(1);
        } else if (view.getRd_Bachelor().isSelected()) {
            educationModel.setEducationCat(2);
        } else if (view.getRd_Master().isSelected()) {
            educationModel.setEducationCat(3);
        } else {
            educationModel.setEducationCat(4);
        }
        educationModel.setMajorName(view.getTxt_major().getText());
        educationModel.setInstitutionName(view.getTxt_school().getText());
        educationModel.setGraduatDate(view.getDt_graduation().getSQLDate());
        int respon = educationService.CreaterTeacherEducation(educationModel);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 2);
        }
    }

    private void CreateExperience() {
        experienceModel = new TeacherExperienceModel();
        experienceModel.setExperienceID(0);
        experienceModel.setTeacherID(TeacherID);
        experienceModel.setExperienceName(view.getTxt_experience().getText());
        experienceModel.setExperiencePlace(view.getTxt_experiencePlace().getText());
        experienceModel.setExperienceInfo(view.getTxt_ExperienceInfo().getText());
        experienceModel.setExperienceDateStart(view.getDt_ExperienceDateStart().getSQLDate());
        experienceModel.setExperienceDateStop(view.getDt_ExperienceDateStop().getSQLDate());
        int respon = experienceService.CreaterExperience(experienceModel);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 3);
        }
    }

    private void CreateTeacherFile() {
        fileModel = new TeacherFileModel();
        fileModel.setTeacherFileID(0);
        fileModel.setTeacherID(TeacherID);
        fileModel.setFlieName(filechooser.getSelectedFile().getAbsolutePath());
        fileModel.setLocalFile(filechooser.getSelectedFile());
        fileModel.setComments(view.getTxt_TeacherFileName().getText());
        int respon = fileService.CreaterTeacherFile(fileModel);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 4);
        }
    }

    //============== Update ==========
    @Override
    public void Update() {
        historyModel.setTeacherID(TeacherID);
        historyModel.setFamilyID(view.getTxt_FamiltyID().getText());
        historyModel.setPeopleID(view.getTxt_peopleID().getText());
        historyModel.setPassportID(view.getTxt_passportID().getText());
        historyModel.setSpouseName(view.getTxt_SpouseName().getText());
        historyModel.setSpouseAge(view.getTxt_SpouseAge().getNumber());
        historyModel.setSpouseJob(view.getTxt_SpouseJob().getText());
        historyModel.setSpousePlace(view.getTxt_SpousePlace().getText());
        historyModel.setSpouseTel(view.getTxt_SpouseTel().getText());
        historyModel.setFatherName(view.getTxt_fatherName().getText());
        historyModel.setFatherAge(view.getTxt_fatherAge().getNumber());
        historyModel.setFatherJob(view.getTxt_fatherJob().getText());
        historyModel.setFatherPlace(view.getTxt_fatherPlace().getText());
        historyModel.setFatherTel(view.getTxt_fatherTel().getText());
        historyModel.setMotherName(view.getTxt_MotherName().getText());
        historyModel.setMotherAge(view.getTxt_MotherAge().getNumber());
        historyModel.setMotherJob(view.getTxt_MotherJob().getText());
        historyModel.setMotherPlace(view.getTxt_MotherPlace().getText());
        historyModel.setMotherTel(view.getTxt_MotherTel().getText());
        if (view.getRd_BloodGroupA().isSelected()) {
            historyModel.setBloodGroup(0);
        } else if (view.getRd_BloodGroupB().isSelected()) {
            historyModel.setBloodGroup(1);
        } else if (view.getRd_BloodGroupAB().isSelected()) {
            historyModel.setBloodGroup(2);
        } else {
            historyModel.setBloodGroup(3);
        }
        if (view.getRd_DiverCategoryCar().isSelected()) {
            historyModel.setDiverCategory(0);
        } else if (view.getRd_DiverCategoryMotobike().isSelected()) {
            historyModel.setDiverCategory(1);
        } else {
            historyModel.setDiverCategory(2);
        }
        historyModel.setDiverID(view.getTxt_DiverID().getText());
        historyModel.setHigth(view.getTxt_Higth().getNumber());
        historyModel.setWeight(view.getTxt_Weight().getNumber());
        JoAlert alert = new JoAlert();
        TeacherHistoryService service = new TeacherHistoryService();
        if (alert.JoSubmit(service.UpdateTeacherHistory(historyModel), JoAlert.UPDATE)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 0);
        }
    }

    private void UpdateAddress() {
        TeacherAddressModel model = new TeacherAddressModel();
        model.setDistrictID(view.getCb_district().getKeyInt());
        model.setDistrictNowID(view.getCb_districtNow().getKeyInt());
        model.setTeacherID(TeacherID);
        model.setVillage(view.getTxt_village().getText());
        model.setVillageNow(view.getTxt_villageNow().getText());
        JoAlert alert = new JoAlert();
        int respon = addressService.UpdateTeacherAddress(model);
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 1);
        }
    }

    private void UpdateEducation() {
        educationModel.setTeacherID(TeacherID);
        if (view.getRd_Middle().isSelected()) {
            educationModel.setEducationCat(0);
        } else if (view.getRd_High().isSelected()) {
            educationModel.setEducationCat(1);
        } else if (view.getRd_Bachelor().isSelected()) {
            educationModel.setEducationCat(2);
        } else if (view.getRd_Master().isSelected()) {
            educationModel.setEducationCat(3);
        } else {
            educationModel.setEducationCat(4);
        }
        educationModel.setMajorName(view.getTxt_major().getText());
        educationModel.setInstitutionName(view.getTxt_school().getText());
        educationModel.setGraduatDate(view.getDt_graduation().getSQLDate());
        int respon = educationService.UpdateTeacherEducation(educationModel);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 2);
        }
    }

    private void UpdateExperience() {
        int ExperienceID = view.getTb_Experience().getIntValue(1);
        experienceModel.setExperienceID(ExperienceID);
        experienceModel.setExperienceName(view.getTxt_experience().getText());
        experienceModel.setExperiencePlace(view.getTxt_experiencePlace().getText());
        experienceModel.setExperienceInfo(view.getTxt_ExperienceInfo().getText());
        experienceModel.setExperienceDateStart(view.getDt_ExperienceDateStart().getSQLDate());
        experienceModel.setExperienceDateStop(view.getDt_ExperienceDateStop().getSQLDate());
        int respon = experienceService.UpdateExperience(experienceModel);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 3);
        }
    }

    private void UpdateFile() {
        fileModel.setTeacherID(TeacherID);
        if (open) {
            fileModel.setFlieName(filechooser.getSelectedFile().getAbsolutePath());
        } else {
            fileModel.setFlieName(fileModel.getFlieName());
        }
        fileModel.setLocalFile(filechooser.getSelectedFile());
        fileModel.setComments(view.getTxt_TeacherFileName().getText());
        int respon = fileService.UpdateTeacherFile(fileModel);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 4);
        }
    }

    //========= Delete ==============
    @Override
    public void Delete() {

    }

    private void DeleteAddress() {

    }

    private void DeleteEducation() {
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            int educationID = view.getTb_education().getIntValue(1);
            educationModel = educationService.getTeacherEducationById(educationID);
            educationService.DeleteTeacherEducation(educationModel);
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 2);
        }
    }

    private void DeleteExperience() {
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            int experienceID = view.getTb_Experience().getIntValue(1);
            experienceModel = experienceService.getExperienceById(experienceID);
            experienceService.DeleteExperience(experienceModel);
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 3);
        }
    }

    private void DeleteFile() {
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            int FileID = view.getTb_TeacherFile().getIntValue(1);
            fileModel = fileService.getTeacherFileById(FileID);
            fileService.DeleteTeacherFile(fileModel);
            AppTeacherHistory history = new AppTeacherHistory(new TeacherService().getTeacherById(TeacherID), 4);
        }
    }

    @Override
    public boolean emptyData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean EmptyEducation() {
        return view.getTxt_major().TextEmpty() && view.getTxt_school().TextEmpty() && view.getDt_graduation().DateEmpty();
    }

    private boolean EmptyExperience() {
        return view.getTxt_experience().TextEmpty() && view.getTxt_experiencePlace().TextEmpty()
                && view.getDt_ExperienceDateStart().DateEmpty() && view.getDt_ExperienceDateStop().DateEmpty();
    }

    private boolean EmptyFile() {
        return view.getTxt_TeacherFileName().TextEmpty() && notFile();
    }

    private boolean notFile() {
        if (!open) {
            JoAlert alert = new JoAlert();
            alert.messages("ຂໍ້ມູນບໍ່ສົມບູນ", "ກະລຸນາເລືອກໄຟລ໌ທີ່ຕ້ອງການບັນທຶກ!", JoAlert.Icons.info);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HistoryactionActionPerformed(e);
        AddressactionActionPerformed(e);
        EducationActionPerformed(e);
        ExperienceActionPerformed(e);
        FlieActionActionPerformed(e);
    }

    private void HistoryactionActionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            TeacherModel model = new TeacherService().getTeacherById(TeacherID);
            AppTeacherData appTeacherData = new AppTeacherData(model);
        } else if (event.isEvent(view.getBtn_saveHistory())) {
            if (historyModel.getTeacherHostoryID() == 0) {
                Create();
            } else {
                Update();
            }
        }
    }

    private void EducationActionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_SaveEducation())) {
            if (educationModel.getTeacherEducationID() == 0) {
                if (EmptyEducation()) {
                    CreateEducation();
                }
            } else {
                if (EmptyEducation()) {
                    UpdateEducation();
                }
            }
        } else if (event.isEvent(EducationPopup.getItemshow())) {

        } else if (event.isEvent(EducationPopup.getItemEdit())) {
            int EducationID = view.getTb_education().getIntValue(1);
            educationModel = educationService.getTeacherEducationById(EducationID);
            view.showEducation(educationModel);
        } else if (event.isEvent(EducationPopup.getItemDelete())) {
            DeleteEducation();
        }
    }

    private void ExperienceActionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_SaveExperience())) {
            if (experienceModel.getExperienceID() == 0) {
                if (EmptyExperience()) {
                    CreateExperience();
                }
            } else {
                if (EmptyExperience()) {
                    UpdateExperience();
                }
            }
        } else if (event.isEvent(ExperiencePopup.getItemshow())) {

        } else if (event.isEvent(ExperiencePopup.getItemEdit())) {
            int ExpericeID = view.getTb_Experience().getIntValue(1);
            experienceModel = experienceService.getExperienceById(ExpericeID);
            view.showExperience(experienceModel);
        } else if (event.isEvent(ExperiencePopup.getItemDelete())) {
            DeleteExperience();
        }
    }

    private void FlieActionActionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_SaveFile())) {
            if (fileModel.getTeacherFileID() == 0) {
                if (EmptyFile()) {
                    CreateTeacherFile();
                }
            } else {
                UpdateFile();
            }
        } else if (event.isEvent(view.getBtn_uploadFile())) {
            System.out.println("OK");
            filechooser.addFilter("PDF", "pdf");
            open = filechooser.showOpenDialog(null);
            if (open) {
                view.getTxt_TeacherFileName().setText(filechooser.getSelectedFile().getAbsolutePath());
            }
        } else if (event.isEvent(FilePopup.getItemshow())) {
            int FileID = view.getTb_TeacherFile().getIntValue(1);
            fileModel = fileService.getTeacherFileById(FileID);
            fileService.CreatePDF(fileModel);
        } else if (event.isEvent(FilePopup.getItemEdit())) {
            int FileID = view.getTb_TeacherFile().getIntValue(1);
            fileModel = fileService.getTeacherFileById(FileID);
            view.showFile(fileModel);
        } else if (event.isEvent(FilePopup.getItemDelete())) {
            DeleteFile();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTab_History())) {
            switch (view.getTab_History().getSelectedIndex()) {
                case 0:
                    //ປະຫວັດຫຍໍ້
                    break;
                case 1:
                    //ທີ່ຢູ່
                    StartAddress();
                    break;
                case 2:
                    //ການສຶກສາ
                    StartEducation();
                    break;
                case 3:
                    //ປະສົບການ
                    StartExperience();
                    break;
                case 4:
                    //ເອກະສານ
                    StartFile();
                    break;
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        AdderessitemStateChanged(e);
    }

    private void AdderessitemStateChanged(ItemEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getCb_province())) {
            view.showDistrict(districtService.getProvinceById(view.getCb_province().getKeyInt()));
        } else if (event.isEvent(view.getCb_provinceNow())) {
            view.showDistrictNow(districtService.getProvinceById(view.getCb_provinceNow().getKeyInt()));
        }
    }

    private void AddressactionActionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_saveLocation())) {
            if (addressService.getTeacherAddressById(TeacherID).getAddressID() == 0) {
                CreateAddress();
            } else {
                UpdateAddress();
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
        EducationMouseReleased(e);
        ExperienceMouseReleased(e);
        FileMouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void ExperienceMouseReleased(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_Experience())) {
            ExperiencePopup.ShowPopup(e);
        }
    }

    private void addEventEducation() {
        view.getBtn_SaveEducation().addActionListener(this);
        EducationPopup.addActionListener(this);
        view.getTb_education().addMouseListener(this);
        view.getTab_History().addChangeListener(this);
    }

    private void EducationMouseReleased(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_education())) {
            EducationPopup.ShowPopup(e);
        }
    }

    private void FileMouseReleased(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_TeacherFile())) {
            FilePopup.ShowPopup(e);
        }
    }

}
