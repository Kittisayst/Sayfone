package View;

import Component.JoRadioButton;
import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoDateChooser;
import Components.JoScrollBar;
import Components.JoTabbed;
import Components.JoTable;
import Components.JoTextArea;
import Components.JoTextField;
import Model.TeacherExperienceModel;
import Model.DistrictModel;
import Model.ProvinceModel;
import Model.TeacherEducationModel;
import Model.TeacherFileModel;
import Model.TeacherHistoryModel;
import Model.TeacherAddressModel;
import DAOSevervice.DistrictService;
import Tools.JoDataTable;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;

public class TeacherHistoryView extends javax.swing.JPanel {

    public TeacherHistoryView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        JoScrollBar joScrollBar = new JoScrollBar(jScrollPane1);
    }

    public void showHistory(TeacherHistoryModel model) {
        txt_FamiltyID.setText(model.getFamilyID());
        txt_peopleID.setText(model.getPeopleID());
        txt_passportID.setText(model.getPassportID());
        rd_BloodGroupA.setSelected(model.getBloodGroup() == 0);
        rd_BloodGroupB.setSelected(model.getBloodGroup() == 1);
        rd_BloodGroupAB.setSelected(model.getBloodGroup() == 2);
        rd_BloodGroupO.setSelected(model.getBloodGroup() == 3);
        txt_Higth.setText("" + model.getHigth());
        txt_Weight.setText("" + model.getWeight());
        txt_DiverID.setText(model.getDiverID());
        rd_DiverCategoryCar.setSelected(model.getDiverCategory() == 0);
        rd_DiverCategoryMotobike.setSelected(model.getDiverCategory() == 1);
        rd_DiverCategoryOther.setSelected(model.getDiverCategory() == 2);
        txt_SpouseName.setText(model.getSpouseName());
        txt_SpouseAge.setText("" + model.getSpouseAge());
        txt_SpouseJob.setText(model.getSpouseJob());
        txt_SpousePlace.setText(model.getSpousePlace());
        txt_SpouseTel.setText(model.getSpouseTel());
        txt_fatherName.setText(model.getFatherName());
        txt_fatherAge.setText("" + model.getFatherAge());
        txt_fatherJob.setText(model.getFatherJob());
        txt_fatherPlace.setText(model.getFatherPlace());
        txt_fatherTel.setText(model.getFatherTel());
        txt_MotherName.setText(model.getMotherName());
        txt_MotherAge.setText("" + model.getMotherAge());
        txt_MotherJob.setText(model.getMotherJob());
        txt_MotherPlace.setText(model.getMotherJob());
        txt_MotherTel.setText(model.getMotherTel());
    }

    //Location
    public void showProvince(List<ProvinceModel> model) {
        cb_province.JoClearData();
        model.forEach(data -> {
            cb_province.JoAddModel("" + data.getProvinceID(), data.getProvinceName());
        });
    }

    public void showProvinceNow(List<ProvinceModel> model) {
        cb_districtNow.JoClearData();
        model.forEach(data -> {
            cb_provinceNow.JoAddModel("" + data.getProvinceID(), data.getProvinceName());
        });
    }

    public void showDistrict(List<DistrictModel> models) {
        cb_district.JoClearData();
        models.forEach(data -> {
            cb_district.JoAddModel("" + data.getDistrictID(), data.getDistrictName());
        });
    }

    public void showDistrictNow(List<DistrictModel> models) {
        cb_districtNow.JoClearData();
        models.forEach(data -> {
            cb_districtNow.JoAddModel("" + data.getDistrictID(), data.getDistrictName());
        });
    }

    public void showTeacherLoaction(TeacherAddressModel model) throws Exception {
        if (model.getAddressID() != 0) {
            DistrictService ds = new DistrictService();
            int DistrictID = model.getDistrictID();
            int DistrictNowID = model.getDistrictNowID();
            int ProvinceID = ds.getDistrictById(DistrictID).getProvinceID();
            int ProvinceNowID = ds.getDistrictById(DistrictNowID).getProvinceID();

            cb_province.setSelectValue("" + ProvinceID);
            cb_provinceNow.setSelectValue("" + ProvinceNowID);
            showDistrict(ds.getProvinceById(ProvinceID));
            showDistrictNow(ds.getProvinceById(ProvinceNowID));
            cb_district.setSelectValue("" + DistrictID);
            cb_districtNow.setSelectValue("" + DistrictNowID);
            txt_village.setText(model.getVillage());
            txt_villageNow.setText(model.getVillageNow());
        }
    }

    public void showExperiences(List<TeacherExperienceModel> model) {
        tb_Experience.JoClearModel();
        model.forEach(data -> {
            tb_Experience.AddJoModel(new Object[]{
                tb_Experience.autoNumber(),
                data.getExperienceID(),
                data.getExperienceName(),
                data.getExperiencePlace(),
                data.getExperienceInfo()});
        });
        JoDataTable dataTable = new JoDataTable(pn_Experience);
        dataTable.showDataTableAll();
    }

    public void showExperience(TeacherExperienceModel model) {
        txt_experience.setText(model.getExperienceName());
        txt_experiencePlace.setText(model.getExperiencePlace());
        txt_ExperienceInfo.setText(model.getExperienceInfo());
        dt_ExperienceDateStart.setDateData(model.getExperienceDateStart());
        dt_ExperienceDateStop.setDateData(model.getExperienceDateStop());
    }

    public void showEducations(List<TeacherEducationModel> models) {
        tb_education.JoClearModel();
        models.forEach(data -> {
            tb_education.AddJoModel(new Object[]{
                tb_education.autoNumber(),
                data.getTeacherEducationID(),
                data.getMajorName(),
                data.getEducationName(data.getEducationCat()),
                data.getInstitutionName(),
                data.getGraduatDate()});
        });
        JoDataTable dataTable = new JoDataTable(pn_Education);
        dataTable.setHiddenColumns(1);
        dataTable.showDataTableAll();
    }

    public void ClearEducation() {
        txt_major.setText("");
        txt_school.setText("");
        rd_Middle.setSelected(true);
        dt_graduation.setDateData(new Date());
    }

    public void showEducation(TeacherEducationModel model) {
        txt_major.setText(model.getMajorName());
        txt_school.setText(model.getInstitutionName());
        rd_Middle.setSelected(model.getEducationCat() == 0);
        rd_High.setSelected(model.getEducationCat() == 1);
        rd_Bachelor.setSelected(model.getEducationCat() == 2);
        rd_Master.setSelected(model.getEducationCat() == 3);
        rd_PhD.setSelected(model.getEducationCat() == 4);
        dt_graduation.setDateData(model.getGraduatDate());
    }

    // ========= File ===========
    public void showFiles(List<TeacherFileModel> models) {
        tb_TeacherFile.JoClearModel();
        models.forEach(data -> {
            tb_TeacherFile.AddJoModel(new Object[]{tb_TeacherFile.autoNumber(), data.getFileID(), data.getFlieName(), data.getComments()});
        });
        JoDataTable dataTable = new JoDataTable(pn_dataFile);
        dataTable.setHiddenColumns(1);
        dataTable.showDataTableAll();
    }

    //========== Getter =================
    public void showFile(TeacherFileModel model) {
        txt_TeacherFileName.setText(model.getFlieName());
        txtFileComment.setText(model.getComments());
    }

    public void clearSelect() {
        tb_TeacherFile.clearSelection();
    }

    //Location
    public JoButtonIconfont getBtn_saveLocation() {
        return btn_saveLocation;
    }

    public JoTextField getTxt_village() {
        return txt_village;
    }

    public JoTextField getTxt_villageNow() {
        return txt_villageNow;
    }

    // Education
    public JoButtonIconfont getBtn_SaveEducation() {
        return btn_SaveEducation;
    }

    public JoTextField getTxt_major() {
        return txt_major;
    }

    public JoTextField getTxt_school() {
        return txt_school;
    }

    public JoDateChooser getDt_graduation() {
        return dt_graduation;
    }

    public JoRadioButton getRd_Bachelor() {
        return rd_Bachelor;
    }

    public JoRadioButton getRd_High() {
        return rd_High;
    }

    public JoRadioButton getRd_Master() {
        return rd_Master;
    }

    public JoRadioButton getRd_Middle() {
        return rd_Middle;
    }

    public JoRadioButton getRd_PhD() {
        return rd_PhD;
    }

    public JoTable getTb_education() {
        return tb_education;
    }

    // ========= Getter ============
    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTabbed getTab_History() {
        return Tab_History;
    }

    public JoCombobox getCb_district() {
        return cb_district;
    }

    public JoCombobox getCb_districtNow() {
        return cb_districtNow;
    }

    public JoCombobox getCb_province() {
        return cb_province;
    }

    public JoCombobox getCb_provinceNow() {
        return cb_provinceNow;
    }
    //======= History =======

    public JoButtonIconfont getBtn_saveHistory() {
        return btn_saveHistory;
    }

    public JoTextField getTxt_FamiltyID() {
        return txt_FamiltyID;
    }

    public JoTextField getTxt_Higth() {
        return txt_Higth;
    }

    public JoTextField getTxt_MotherAge() {
        return txt_MotherAge;
    }

    public JoTextField getTxt_MotherJob() {
        return txt_MotherJob;
    }

    public JoTextField getTxt_MotherName() {
        return txt_MotherName;
    }

    public JoTextField getTxt_MotherPlace() {
        return txt_MotherPlace;
    }

    public JoTextField getTxt_MotherTel() {
        return txt_MotherTel;
    }

    public JoTextField getTxt_SpouseAge() {
        return txt_SpouseAge;
    }

    public JoTextField getTxt_SpouseJob() {
        return txt_SpouseJob;
    }

    public JoTextField getTxt_SpouseName() {
        return txt_SpouseName;
    }

    public JoTextField getTxt_SpousePlace() {
        return txt_SpousePlace;
    }

    public JoTextField getTxt_SpouseTel() {
        return txt_SpouseTel;
    }

    public JoTextField getTxt_Weight() {
        return txt_Weight;
    }

    public JoTextField getTxt_fatherAge() {
        return txt_fatherAge;
    }

    public JoTextField getTxt_fatherJob() {
        return txt_fatherJob;
    }

    public JoTextField getTxt_fatherName() {
        return txt_fatherName;
    }

    public JoTextField getTxt_fatherPlace() {
        return txt_fatherPlace;
    }

    public JoTextField getTxt_fatherTel() {
        return txt_fatherTel;
    }

    public JoTextField getTxt_passportID() {
        return txt_passportID;
    }

    public JoTextField getTxt_peopleID() {
        return txt_peopleID;
    }

    public JoRadioButton getRd_BloodGroupA() {
        return rd_BloodGroupA;
    }

    public JoRadioButton getRd_BloodGroupAB() {
        return rd_BloodGroupAB;
    }

    public JoRadioButton getRd_BloodGroupB() {
        return rd_BloodGroupB;
    }

    public JoRadioButton getRd_BloodGroupO() {
        return rd_BloodGroupO;
    }

    public JoRadioButton getRd_DiverCategoryCar() {
        return rd_DiverCategoryCar;
    }

    public JoRadioButton getRd_DiverCategoryMotobike() {
        return rd_DiverCategoryMotobike;
    }

    public JoRadioButton getRd_DiverCategoryOther() {
        return rd_DiverCategoryOther;
    }

    public JoTextField getTxt_DiverID() {
        return txt_DiverID;
    }

    //========= Experience =========
    public JoTable getTb_Experience() {
        return tb_Experience;
    }

    public JoButtonIconfont getBtn_SaveExperience() {
        return btn_SaveExperience;
    }

    public JoTextArea getTxt_ExperienceInfo() {
        return txt_ExperienceInfo;
    }

    public JoTextField getTxt_experience() {
        return txt_experience;
    }

    public JoTextField getTxt_experiencePlace() {
        return txt_experiencePlace;
    }

    public JoDateChooser getDt_ExperienceDateStart() {
        return dt_ExperienceDateStart;
    }

    public JoDateChooser getDt_ExperienceDateStop() {
        return dt_ExperienceDateStop;
    }

    //======== FIle ========
    public JoButtonIconfont getBtn_uploadFile() {
        return btn_uploadFile;
    }

    public JoTextField getTxt_TeacherFileName() {
        return txt_TeacherFileName;
    }

    public JoTable getTb_TeacherFile() {
        return tb_TeacherFile;
    }

    public JoButtonIconfont getBtn_SaveFile() {
        return btn_SaveFile;
    }

    public JPanel getPn_dataFile() {
        return pn_dataFile;
    }

    public String getTxtFileComment() {
        return txtFileComment.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Tab_History = new Components.JoTabbed();
        pn_history = new javax.swing.JPanel();
        joPanelTitle1 = new Component.JoPanelTitle();
        joLable14 = new Components.JoLable();
        txt_fatherName = new Components.JoTextField();
        joLable15 = new Components.JoLable();
        txt_fatherAge = new Components.JoTextField();
        txt_fatherJob = new Components.JoTextField();
        joLable16 = new Components.JoLable();
        txt_fatherTel = new Components.JoTextField();
        joLable17 = new Components.JoLable();
        txt_fatherPlace = new Components.JoTextField();
        joLable22 = new Components.JoLable();
        joLable18 = new Components.JoLable();
        txt_MotherName = new Components.JoTextField();
        joLable19 = new Components.JoLable();
        txt_MotherAge = new Components.JoTextField();
        joLable20 = new Components.JoLable();
        txt_MotherJob = new Components.JoTextField();
        joLable23 = new Components.JoLable();
        txt_MotherPlace = new Components.JoTextField();
        joLable21 = new Components.JoLable();
        txt_MotherTel = new Components.JoTextField();
        jPanel11 = new javax.swing.JPanel();
        btn_saveHistory = new Components.JoButtonIconfont();
        joPanelTitle2 = new Component.JoPanelTitle();
        txt_FamiltyID = new Components.JoTextField();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        txt_peopleID = new Components.JoTextField();
        joLable3 = new Components.JoLable();
        txt_passportID = new Components.JoTextField();
        joLable4 = new Components.JoLable();
        rd_BloodGroupA = new Component.JoRadioButton();
        rd_BloodGroupB = new Component.JoRadioButton();
        rd_BloodGroupAB = new Component.JoRadioButton();
        rd_BloodGroupO = new Component.JoRadioButton();
        joLable5 = new Components.JoLable();
        joLable6 = new Components.JoLable();
        txt_Higth = new Components.JoTextField();
        txt_Weight = new Components.JoTextField();
        jPanel12 = new javax.swing.JPanel();
        joLable7 = new Components.JoLable();
        txt_DiverID = new Components.JoTextField();
        joLable8 = new Components.JoLable();
        rd_DiverCategoryMotobike = new Component.JoRadioButton();
        rd_DiverCategoryCar = new Component.JoRadioButton();
        rd_DiverCategoryOther = new Component.JoRadioButton();
        joLable9 = new Components.JoLable();
        txt_SpouseName = new Components.JoTextField();
        joLable10 = new Components.JoLable();
        txt_SpouseAge = new Components.JoTextField();
        joLable11 = new Components.JoLable();
        txt_SpouseTel = new Components.JoTextField();
        txt_SpouseJob = new Components.JoTextField();
        joLable12 = new Components.JoLable();
        txt_SpousePlace = new Components.JoTextField();
        joLable13 = new Components.JoLable();
        pn_location = new javax.swing.JPanel();
        joPanelTitle4 = new Component.JoPanelTitle();
        cb_province = new Components.JoCombobox();
        cb_district = new Components.JoCombobox();
        joLable24 = new Components.JoLable();
        joLable25 = new Components.JoLable();
        txt_village = new Components.JoTextField();
        joLable26 = new Components.JoLable();
        jPanel14 = new javax.swing.JPanel();
        btn_saveLocation = new Components.JoButtonIconfont();
        joPanelTitle5 = new Component.JoPanelTitle();
        cb_provinceNow = new Components.JoCombobox();
        cb_districtNow = new Components.JoCombobox();
        joLable27 = new Components.JoLable();
        joLable28 = new Components.JoLable();
        txt_villageNow = new Components.JoTextField();
        joLable29 = new Components.JoLable();
        pn_education = new javax.swing.JPanel();
        pn_Education = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_education = new Components.JoTable();
        jPanel16 = new javax.swing.JPanel();
        joLable30 = new Components.JoLable();
        txt_major = new Components.JoTextField();
        joLable31 = new Components.JoLable();
        rd_Middle = new Component.JoRadioButton();
        rd_High = new Component.JoRadioButton();
        rd_Bachelor = new Component.JoRadioButton();
        rd_Master = new Component.JoRadioButton();
        rd_PhD = new Component.JoRadioButton();
        joLable32 = new Components.JoLable();
        txt_school = new Components.JoTextField();
        joLable33 = new Components.JoLable();
        dt_graduation = new Components.JoDateChooser();
        jPanel17 = new javax.swing.JPanel();
        btn_SaveEducation = new Components.JoButtonIconfont();
        pn_work = new javax.swing.JPanel();
        pn_Experience = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_Experience = new Components.JoTable();
        jPanel18 = new javax.swing.JPanel();
        joLable34 = new Components.JoLable();
        txt_experience = new Components.JoTextField();
        txt_experiencePlace = new Components.JoTextField();
        joLable35 = new Components.JoLable();
        joLable36 = new Components.JoLable();
        dt_ExperienceDateStart = new Components.JoDateChooser();
        joLable37 = new Components.JoLable();
        dt_ExperienceDateStop = new Components.JoDateChooser();
        joLable38 = new Components.JoLable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_ExperienceInfo = new Components.JoTextArea();
        jPanel20 = new javax.swing.JPanel();
        btn_SaveExperience = new Components.JoButtonIconfont();
        pn_file = new javax.swing.JPanel();
        pn_dataFile = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_TeacherFile = new Components.JoTable();
        jPanel22 = new javax.swing.JPanel();
        joLable39 = new Components.JoLable();
        btn_SaveFile = new Components.JoButtonIconfont();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtFileComment = new Components.JoTextArea();
        jPanel6 = new javax.swing.JPanel();
        txt_TeacherFileName = new Components.JoTextField();
        btn_uploadFile = new Components.JoButtonIconfont();
        joLable40 = new Components.JoLable();

        Pn_Navigation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Pn_Navigation.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btn_back.setText("ກັບຄືນ");
        btn_back.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ARROW_BACK);
        jPanel3.add(btn_back);

        Pn_Navigation.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        lbl_title.setText("Title");
        lbl_title.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel4.add(lbl_title);

        Pn_Navigation.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7);

        Pn_Navigation.add(jPanel5);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Tab_History.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        Tab_History.setPreferredSize(new java.awt.Dimension(800, 633));

        joPanelTitle1.setBackground(new java.awt.Color(204, 204, 204));
        joPanelTitle1.setJoTitle("ຂໍ້ມູນຄອບຄົວ");
        joPanelTitle1.setOpaque(false);

        joLable14.setText("ຊື່ພໍ່");

        txt_fatherName.setPlaceholder("ຊື່ພໍ່");

        joLable15.setText("ອາຍຸ");

        txt_fatherAge.setNumberOnly(true);
        txt_fatherAge.setPlaceholder("ປີ");

        txt_fatherJob.setPlaceholder("ອາຊີບ");

        joLable16.setText("ອາຊີບ");

        txt_fatherTel.setNumberOnly(true);
        txt_fatherTel.setPlaceholder("ເບີໂທ");

        joLable17.setText("ເບີໂທ");

        txt_fatherPlace.setPlaceholder("ປ່ອນປະຈຳການ");

        joLable22.setText("ປ່ອນປະຈຳການ");

        joLable18.setText("ຊື່ແມ່");

        txt_MotherName.setPlaceholder("ຊື່ແມ່");

        joLable19.setText("ອາຍຸ");

        txt_MotherAge.setNumberOnly(true);
        txt_MotherAge.setPlaceholder("ປີ");

        joLable20.setText("ອາຊີບ");

        txt_MotherJob.setPlaceholder("ອາຊີບ");

        joLable23.setText("ປ່ອນປະຈຳການ");

        txt_MotherPlace.setPlaceholder("ປ່ອນປະຈຳການ");

        joLable21.setText("ເບີໂທ");

        txt_MotherTel.setNumberOnly(true);
        txt_MotherTel.setPlaceholder("ເບີໂທ");

        btn_saveHistory.setText("ບັກທຶກປະຫວັດຫຍໍ້");
        btn_saveHistory.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_saveHistory.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        jPanel11.add(btn_saveHistory);

        javax.swing.GroupLayout joPanelTitle1Layout = new javax.swing.GroupLayout(joPanelTitle1);
        joPanelTitle1.setLayout(joPanelTitle1Layout);
        joPanelTitle1Layout.setHorizontalGroup(
            joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_fatherName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(joLable14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_fatherAge, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(joLable15, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                .addGap(10, 10, 10))
                            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_fatherPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(joLable22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fatherTel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_fatherJob, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, joPanelTitle1Layout.createSequentialGroup()
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_MotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(joLable18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_MotherAge, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(joLable19, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_MotherPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(joLable23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MotherTel, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(joLable21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_MotherJob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        joPanelTitle1Layout.setVerticalGroup(
            joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joLable15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joLable16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_fatherAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fatherJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addComponent(joLable14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addComponent(joLable17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fatherTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addComponent(joLable22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fatherPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joLable19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joLable20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_MotherAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_MotherJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addComponent(joLable18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_MotherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addComponent(joLable21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_MotherTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addComponent(joLable23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_MotherPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        joPanelTitle2.setBackground(new java.awt.Color(204, 204, 204));
        joPanelTitle2.setJoTitle("ຂໍ້ມູນສ່ວນຕົວ");
        joPanelTitle2.setOpaque(false);

        txt_FamiltyID.setPlaceholder("ເລກສຳມະໂນຄົວ");

        joLable1.setText("ເລກສຳມະໂນຄົວ");

        joLable2.setText("ເລກບັດປະຈຳຕົວ");

        txt_peopleID.setPlaceholder("ເລກບັດປະຈຳຕົວ");

        joLable3.setText("ເລກພາດສະປອດ");

        txt_passportID.setPlaceholder("ເລກພາດສະປອດ");

        joLable4.setText("ກຸບເລືອດ");

        buttonGroup1.add(rd_BloodGroupA);
        rd_BloodGroupA.setText("ກຸບ A");

        buttonGroup1.add(rd_BloodGroupB);
        rd_BloodGroupB.setText("ກຸບ B");

        buttonGroup1.add(rd_BloodGroupAB);
        rd_BloodGroupAB.setText("ກຸບ AB");

        buttonGroup1.add(rd_BloodGroupO);
        rd_BloodGroupO.setText("ກຸບ O");

        joLable5.setText("ສ່ວນສູງ");

        joLable6.setText("ນ້ຳໜັກ");

        txt_Higth.setNumberOnly(true);
        txt_Higth.setPlaceholder("CM");

        txt_Weight.setNumberOnly(true);
        txt_Weight.setPlaceholder("KG");

        jPanel12.setOpaque(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        joLable7.setText("ເລກໃບຂັບຂີ່");

        txt_DiverID.setPlaceholder("ເລກໃບຂັບຂີ່");

        joLable8.setText("ປະເພດຍານພາຫະນະ");

        buttonGroup2.add(rd_DiverCategoryMotobike);
        rd_DiverCategoryMotobike.setText("ລົດຈັກ");

        buttonGroup2.add(rd_DiverCategoryCar);
        rd_DiverCategoryCar.setText("ລົດໃຫຍ່");

        buttonGroup2.add(rd_DiverCategoryOther);
        rd_DiverCategoryOther.setText("ອື່່ນໆ");

        joLable9.setText("ຊື່ ແລະ ນາມສະກຸນ ຜົວ/ເມຍ");

        txt_SpouseName.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ ຜົວ/ເມຍ");

        joLable10.setText("ອາຍຸ");

        txt_SpouseAge.setNumberOnly(true);
        txt_SpouseAge.setPlaceholder("ປີ");

        joLable11.setText("ເບີໂທ");

        txt_SpouseTel.setNumberOnly(true);
        txt_SpouseTel.setPlaceholder("ເບີໂທ");

        txt_SpouseJob.setPlaceholder("ອາຊີບ");

        joLable12.setText("ອາຊີບ");

        txt_SpousePlace.setPlaceholder("ບ່ອນປະຈຳການ");

        joLable13.setText("ບ່ອນປະຈຳການ");

        javax.swing.GroupLayout joPanelTitle2Layout = new javax.swing.GroupLayout(joPanelTitle2);
        joPanelTitle2.setLayout(joPanelTitle2Layout);
        joPanelTitle2Layout.setHorizontalGroup(
            joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_FamiltyID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txt_peopleID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(joLable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_passportID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(joLable4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addComponent(rd_BloodGroupA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(rd_BloodGroupB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(rd_BloodGroupAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(rd_BloodGroupO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Higth, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(joLable5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(joLable6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_DiverID, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(joLable7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joLable8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addComponent(rd_DiverCategoryMotobike, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(rd_DiverCategoryCar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(rd_DiverCategoryOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_SpouseTel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(joLable11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_SpouseJob, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(joLable12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_SpousePlace, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(joLable13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_SpouseName, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                    .addComponent(joLable9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txt_SpouseAge, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                    .addComponent(joLable10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1)))
                .addGap(3, 3, 3))
        );
        joPanelTitle2Layout.setVerticalGroup(
            joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_passportID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_peopleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_FamiltyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joLable5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joLable6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_BloodGroupAB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rd_BloodGroupA, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rd_BloodGroupB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rd_BloodGroupO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Higth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joLable7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_DiverID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_DiverCategoryMotobike, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_DiverCategoryCar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_DiverCategoryOther, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joLable9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_SpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SpouseAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SpouseTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SpouseJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SpousePlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_historyLayout = new javax.swing.GroupLayout(pn_history);
        pn_history.setLayout(pn_historyLayout);
        pn_historyLayout.setHorizontalGroup(
            pn_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_historyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joPanelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_historyLayout.setVerticalGroup(
            pn_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_historyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joPanelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        Tab_History.addTab("ປະຫວັດຫຍໍ້", pn_history);

        joPanelTitle4.setJoTitle("ສະຖານທີ່ເກີດ");
        joPanelTitle4.setPreferredSize(new java.awt.Dimension(300, 300));

        joLable24.setText("ແຂວງ");

        joLable25.setText("ເມືອງ");

        txt_village.setPlaceholder("ບ້ານ");

        joLable26.setText("ບ້ານ");

        javax.swing.GroupLayout joPanelTitle4Layout = new javax.swing.GroupLayout(joPanelTitle4);
        joPanelTitle4.setLayout(joPanelTitle4Layout);
        joPanelTitle4Layout.setHorizontalGroup(
            joPanelTitle4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_province, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_district, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_village, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(joLable26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        joPanelTitle4Layout.setVerticalGroup(
            joPanelTitle4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joLable24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_province, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joLable25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_district, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joLable26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_village, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btn_saveLocation.setText("ບັນທຶກທີ່ຢູ່");
        btn_saveLocation.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_saveLocation.setPreferredSize(new java.awt.Dimension(165, 41));
        jPanel14.add(btn_saveLocation);

        joPanelTitle5.setJoTitle("ບ່ອນຢູ່ປະຈຸບັນ");
        joPanelTitle5.setPreferredSize(new java.awt.Dimension(300, 300));

        joLable27.setText("ແຂວງ");

        joLable28.setText("ເມືອງ");

        txt_villageNow.setPlaceholder("ບ້ານ");

        joLable29.setText("ບ້ານ");

        javax.swing.GroupLayout joPanelTitle5Layout = new javax.swing.GroupLayout(joPanelTitle5);
        joPanelTitle5.setLayout(joPanelTitle5Layout);
        joPanelTitle5Layout.setHorizontalGroup(
            joPanelTitle5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_provinceNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_districtNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_villageNow, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(joLable29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        joPanelTitle5Layout.setVerticalGroup(
            joPanelTitle5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joLable27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_provinceNow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joLable28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_districtNow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joLable29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_villageNow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_locationLayout = new javax.swing.GroupLayout(pn_location);
        pn_location.setLayout(pn_locationLayout);
        pn_locationLayout.setHorizontalGroup(
            pn_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_locationLayout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addGroup(pn_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pn_locationLayout.createSequentialGroup()
                        .addComponent(joPanelTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(joPanelTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        pn_locationLayout.setVerticalGroup(
            pn_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_locationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(joPanelTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joPanelTitle5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        Tab_History.addTab("ທີ່ຢູ່", pn_location);

        pn_Education.setLayout(new java.awt.BorderLayout());

        tb_education.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ສາຂາວິຊາ", "ວຸດທິການສຶກສາ", "ສະຖາບັນ"
            }
        ));
        jScrollPane2.setViewportView(tb_education);

        pn_Education.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        joLable30.setText("ສາຂາວິຊາ");

        txt_major.setPlaceholder("ສາຂາວິຊາ");

        joLable31.setText("ວູດທິການສຶກສາ");

        buttonGroup3.add(rd_Middle);
        rd_Middle.setSelected(true);
        rd_Middle.setText("ຊັ້ນກາງ");

        buttonGroup3.add(rd_High);
        rd_High.setText("ຊັ້ນສູງ");

        buttonGroup3.add(rd_Bachelor);
        rd_Bachelor.setText("ປະລິນຍາຕີ");

        buttonGroup3.add(rd_Master);
        rd_Master.setText("ປະລິນຍາໂທ");

        buttonGroup3.add(rd_PhD);
        rd_PhD.setText("ປະລິນຍາເອກ");

        joLable32.setText("ຊື່ສະຖາບັນ");

        txt_school.setPlaceholder("ຊື່ສະຖາບັນ");

        joLable33.setText("ວັນທີຮຽນຈົບ");

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        btn_SaveEducation.setText("ບັນທຶກການສຶກສາ");
        btn_SaveEducation.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel17.add(btn_SaveEducation);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_major, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(joLable30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_school, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable32, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joLable31, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(rd_Middle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_High, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_Bachelor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_Master, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_PhD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(joLable33, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(dt_graduation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(joLable32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_school, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(joLable30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_major, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joLable31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rd_Bachelor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rd_High, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rd_Middle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rd_Master, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rd_PhD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dt_graduation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_educationLayout = new javax.swing.GroupLayout(pn_education);
        pn_education.setLayout(pn_educationLayout);
        pn_educationLayout.setHorizontalGroup(
            pn_educationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_educationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_educationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_Education, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_educationLayout.setVerticalGroup(
            pn_educationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_educationLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Education, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
        );

        Tab_History.addTab("ການສຶກສາ", pn_education);

        pn_Experience.setLayout(new java.awt.BorderLayout());

        tb_Experience.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ປະສົບການ", "ສະຖານທີ່", "ລາຍລະອຽດ"
            }
        ));
        jScrollPane3.setViewportView(tb_Experience);

        pn_Experience.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        joLable34.setText("ປະສົບການ");

        txt_experience.setPlaceholder("ປະສົບການ");

        txt_experiencePlace.setPlaceholder("ສະຖານທີ່");

        joLable35.setText("ສະຖານທີ່");

        joLable36.setText("ເລີ່ມວັນທີ່");

        joLable37.setText("ສິ້ນສຸດ");

        joLable38.setText("ລາຍລະອຽດ");

        jScrollPane4.setViewportView(txt_ExperienceInfo);

        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        btn_SaveExperience.setText("ບັນທຶກປະສົບການ");
        btn_SaveExperience.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel20.add(btn_SaveExperience);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(joLable34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_experience, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dt_ExperienceDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable36, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_experiencePlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable35, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dt_ExperienceDateStop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable37, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable38, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(joLable34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_experience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(joLable37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dt_ExperienceDateStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(joLable35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_experiencePlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joLable36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joLable38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dt_ExperienceDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout pn_workLayout = new javax.swing.GroupLayout(pn_work);
        pn_work.setLayout(pn_workLayout);
        pn_workLayout.setHorizontalGroup(
            pn_workLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_workLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_workLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_Experience, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_workLayout.setVerticalGroup(
            pn_workLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_workLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Experience, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tab_History.addTab("ປະສົບການ", pn_work);

        pn_dataFile.setLayout(new java.awt.BorderLayout());

        tb_TeacherFile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ຊື່ເອກະສານ", "ລາຍລະອຽດ"
            }
        ));
        jScrollPane5.setViewportView(tb_TeacherFile);

        pn_dataFile.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel22.setMaximumSize(new java.awt.Dimension(500, 2147483647));
        jPanel22.setPreferredSize(new java.awt.Dimension(500, 78));
        jPanel22.setLayout(new java.awt.GridBagLayout());

        joLable39.setText("ຫົວຂໍ້່ເອກະສານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel22.add(joLable39, gridBagConstraints);

        btn_SaveFile.setText("ບັນທຶກເອກະສານ");
        btn_SaveFile.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel22.add(btn_SaveFile, gridBagConstraints);

        txtFileComment.setColumns(20);
        txtFileComment.setRows(5);
        jScrollPane6.setViewportView(txtFileComment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel22.add(jScrollPane6, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        txt_TeacherFileName.setPlaceholder("ຫົວຂໍ້່ເອກະສານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        jPanel6.add(txt_TeacherFileName, gridBagConstraints);

        btn_uploadFile.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLOUD_UPLOAD);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel6.add(btn_uploadFile, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel22.add(jPanel6, gridBagConstraints);

        joLable40.setText("ລາຍລະອຽດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel22.add(joLable40, gridBagConstraints);

        javax.swing.GroupLayout pn_fileLayout = new javax.swing.GroupLayout(pn_file);
        pn_file.setLayout(pn_fileLayout);
        pn_fileLayout.setHorizontalGroup(
            pn_fileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_fileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_fileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_dataFile, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pn_fileLayout.setVerticalGroup(
            pn_fileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_fileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_dataFile, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tab_History.addTab("ເອກະສານ", pn_file);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tab_History, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tab_History, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1207, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoTabbed Tab_History;
    private Components.JoButtonIconfont btn_SaveEducation;
    private Components.JoButtonIconfont btn_SaveExperience;
    private Components.JoButtonIconfont btn_SaveFile;
    private Components.JoButtonIconfont btn_back;
    private Components.JoButtonIconfont btn_saveHistory;
    private Components.JoButtonIconfont btn_saveLocation;
    private Components.JoButtonIconfont btn_uploadFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private Components.JoCombobox cb_district;
    private Components.JoCombobox cb_districtNow;
    private Components.JoCombobox cb_province;
    private Components.JoCombobox cb_provinceNow;
    private Components.JoDateChooser dt_ExperienceDateStart;
    private Components.JoDateChooser dt_ExperienceDateStop;
    private Components.JoDateChooser dt_graduation;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private Components.JoLable joLable1;
    private Components.JoLable joLable10;
    private Components.JoLable joLable11;
    private Components.JoLable joLable12;
    private Components.JoLable joLable13;
    private Components.JoLable joLable14;
    private Components.JoLable joLable15;
    private Components.JoLable joLable16;
    private Components.JoLable joLable17;
    private Components.JoLable joLable18;
    private Components.JoLable joLable19;
    private Components.JoLable joLable2;
    private Components.JoLable joLable20;
    private Components.JoLable joLable21;
    private Components.JoLable joLable22;
    private Components.JoLable joLable23;
    private Components.JoLable joLable24;
    private Components.JoLable joLable25;
    private Components.JoLable joLable26;
    private Components.JoLable joLable27;
    private Components.JoLable joLable28;
    private Components.JoLable joLable29;
    private Components.JoLable joLable3;
    private Components.JoLable joLable30;
    private Components.JoLable joLable31;
    private Components.JoLable joLable32;
    private Components.JoLable joLable33;
    private Components.JoLable joLable34;
    private Components.JoLable joLable35;
    private Components.JoLable joLable36;
    private Components.JoLable joLable37;
    private Components.JoLable joLable38;
    private Components.JoLable joLable39;
    private Components.JoLable joLable4;
    private Components.JoLable joLable40;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable joLable7;
    private Components.JoLable joLable8;
    private Components.JoLable joLable9;
    private Component.JoPanelTitle joPanelTitle1;
    private Component.JoPanelTitle joPanelTitle2;
    private Component.JoPanelTitle joPanelTitle4;
    private Component.JoPanelTitle joPanelTitle5;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Education;
    private javax.swing.JPanel pn_Experience;
    private javax.swing.JPanel pn_dataFile;
    private javax.swing.JPanel pn_education;
    private javax.swing.JPanel pn_file;
    private javax.swing.JPanel pn_history;
    private javax.swing.JPanel pn_location;
    private javax.swing.JPanel pn_work;
    private Component.JoRadioButton rd_Bachelor;
    private Component.JoRadioButton rd_BloodGroupA;
    private Component.JoRadioButton rd_BloodGroupAB;
    private Component.JoRadioButton rd_BloodGroupB;
    private Component.JoRadioButton rd_BloodGroupO;
    private Component.JoRadioButton rd_DiverCategoryCar;
    private Component.JoRadioButton rd_DiverCategoryMotobike;
    private Component.JoRadioButton rd_DiverCategoryOther;
    private Component.JoRadioButton rd_High;
    private Component.JoRadioButton rd_Master;
    private Component.JoRadioButton rd_Middle;
    private Component.JoRadioButton rd_PhD;
    private Components.JoTable tb_Experience;
    private Components.JoTable tb_TeacherFile;
    private Components.JoTable tb_education;
    private Components.JoTextArea txtFileComment;
    private Components.JoTextField txt_DiverID;
    private Components.JoTextArea txt_ExperienceInfo;
    private Components.JoTextField txt_FamiltyID;
    private Components.JoTextField txt_Higth;
    private Components.JoTextField txt_MotherAge;
    private Components.JoTextField txt_MotherJob;
    private Components.JoTextField txt_MotherName;
    private Components.JoTextField txt_MotherPlace;
    private Components.JoTextField txt_MotherTel;
    private Components.JoTextField txt_SpouseAge;
    private Components.JoTextField txt_SpouseJob;
    private Components.JoTextField txt_SpouseName;
    private Components.JoTextField txt_SpousePlace;
    private Components.JoTextField txt_SpouseTel;
    private Components.JoTextField txt_TeacherFileName;
    private Components.JoTextField txt_Weight;
    private Components.JoTextField txt_experience;
    private Components.JoTextField txt_experiencePlace;
    private Components.JoTextField txt_fatherAge;
    private Components.JoTextField txt_fatherJob;
    private Components.JoTextField txt_fatherName;
    private Components.JoTextField txt_fatherPlace;
    private Components.JoTextField txt_fatherTel;
    private Components.JoTextField txt_major;
    private Components.JoTextField txt_passportID;
    private Components.JoTextField txt_peopleID;
    private Components.JoTextField txt_school;
    private Components.JoTextField txt_village;
    private Components.JoTextField txt_villageNow;
    // End of variables declaration//GEN-END:variables

    public void ClearExperience() {
        txt_ExperienceInfo.setText("");
        txt_experience.setText("");
        txt_experiencePlace.setText("");
        dt_ExperienceDateStart.setDateData(new Date());
        dt_ExperienceDateStop.setDateData(new Date());
    }

    public void ClearFile() {
        txt_TeacherFileName.setText(null);
    }

}
