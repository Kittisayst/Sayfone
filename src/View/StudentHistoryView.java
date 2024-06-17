package View;

import Component.JoRadioButton;
import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTabbed;
import Components.JoTable;
import Components.JoTextField;
import Model.DistrictModel;
import Model.ProvinceModel;
import Model.StudentHistoryModel;
import Model.StudentAddressModel;
import DAOSevervice.DistrictService;
import DAOSevervice.FinancialService;
import Model.BrotherAndSisterModel;
import Model.GlobalDataModel;
import Model.StudentFileModel;
import Tools.JoDataTable;
import Utility.MyPopup;
import java.awt.BorderLayout;
import java.util.List;

public class StudentHistoryView extends javax.swing.JPanel {

    private PnLoading loading = new PnLoading();
    private MyPopup popupFile = new MyPopup();

    public StudentHistoryView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void setProvinDistrictDefault() {
        cb_province.setSelectValue("" + 10);
        cb_provinceNow.setSelectValue("" + 10);
        showDistrict(new DistrictService().getProvinceById(10));
        showDistrictNow(new DistrictService().getProvinceById(10));
        cb_district.setSelectValue("" + 86);
        cb_districtNow.setSelectValue("" + 86);
    }

    public void showHistory(StudentHistoryModel model) {
        txt_FamiltyID.setText(model.getFamilyID());
        txt_peopleID.setText(model.getPeopleID());
        txt_passportID.setText(model.getPassportID());
        txt_Higth.setText("" + model.getHigth());
        txt_Weight.setText("" + model.getWeight());
        txt_SiblingName.setText(model.getSiblingName());
        txt_SiblingAge.setText("" + model.getSiblingAge());
        txt_SiblingJob.setText(model.getSiblingJob());
        txt_SiblingPlace.setText(model.getSiblingPlace());
        txt_SiblingTel.setText(model.getSiblingTel());
        txt_fatherName.setText(model.getFatherName());
        txt_fatherAge.setText("" + model.getFatherAge());
        txt_fatherJob.setText(model.getFatherJob());
        txt_fatherPlace.setText(model.getFatherPlace());
        txt_fatherTel.setText(model.getFatherTel());
        txt_MotherName.setText(model.getMotherName());
        txt_MotherAge.setText("" + model.getMotherAge());
        txt_MotherJob.setText(model.getMotherJob());
        txt_MotherPlace.setText(model.getMotherPlace());
        txt_MotherTel.setText(model.getMotherTel());
        setBloodGroup(model.getBloodGroup());
        setCar(model.getDiverCategory());
        parent1.setParent(model.getParent1());
        parent2.setParent(model.getParent2());
    }

    public int getBloodGroup() {
        if (rd_BloodGroupA.isSelected()) {
            return 0;
        } else if (rd_BloodGroupB.isSelected()) {
            return 1;
        } else if (rd_BloodGroupAB.isSelected()) {
            return 2;
        } else {
            return 3;
        }
    }

    private void setBloodGroup(int value) {
        rd_BloodGroupA.setSelected(value == 0);
        rd_BloodGroupB.setSelected(value == 1);
        rd_BloodGroupAB.setSelected(value == 2);
        rd_BloodGroupO.setSelected(value == 3);
    }

    public int getCar() {
        if (rd_DiverCategoryCar.isSelected()) {
            return 0;
        } else if (rd_DiverCategoryMotobike.isSelected()) {
            return 1;
        } else {
            return 2;
        }
    }

    private void setCar(int value) {
        rd_DiverCategoryCar.setSelected(value == 0);
        rd_DiverCategoryMotobike.setSelected(value == 1);
        rd_DiverCategoryOther.setSelected(value == 2);
    }

    public String getParent1() {
        return parent1.getParentName();
    }

    public String getParent2() {
        return parent2.getParentName();
    }

    //Location
    public void showProvince(List<ProvinceModel> model) {
        cb_province.JoClearData();
        model.forEach(data -> {
            cb_province.JoAddModel("" + data.getProvinceID(), data.getProvinceName());
        });
    }

    public void showProvinceNow(List<ProvinceModel> model) {
        cb_provinceNow.JoClearData();
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

    public void showStudnetAddress(StudentAddressModel model) throws Exception {
        if (model.getAddressID() != 0) {
            DistrictService districtService = new DistrictService();
            int ProvinceID = districtService.getDistrictById(model.getDistrictID()).getProvinceID();
            int ProvinceNowID = districtService.getDistrictById(model.getDistrictNowID()).getProvinceID();
            cb_province.setSelectValue("" + ProvinceID);
            cb_provinceNow.setSelectValue("" + ProvinceNowID);
            showDistrict(districtService.getProvinceById(ProvinceID));
            showDistrictNow(districtService.getProvinceById(ProvinceNowID));
            cb_district.setSelectValue("" + model.getDistrictID());
            cb_districtNow.setSelectValue("" + model.getDistrictNowID());
            txt_village.setText(model.getVillage());
            txt_villageNow.setText(model.getVillageNow());
        }
    }

    public void showBorderAndSister(List<BrotherAndSisterModel> models) {
        tb_BrotherAndSister.JoClearModel();
        models.forEach(data -> {
            tb_BrotherAndSister.AddJoModel(new Object[]{
                tb_BrotherAndSister.autoNumber(),
                data.getBsID(),
                data.getStudentBSID(),
                data.getStudentNo(),
                data.getFullName(),
                new FinancialService().getLastClass(data.getStudentBSID()),});
        });
        JoDataTable dataTable = new JoDataTable(pnDataTable);
        dataTable.showDataTableAll();
        dataTable.setHiddenColumns(1);
        dataTable.setHiddenColumns(2);
    }

    public void showFile(List<StudentFileModel> models) {
        tbFile.JoClearModel();
        Thread thread = new Thread(() -> {
            loading.setTitle("ໂຫຼດຂໍ້ມູນເອກະສານ");
            GlobalDataModel.rootView.setView(loading);
            try {
                models.forEach(data -> {
                    tbFile.AddJoModel(new Object[]{tbFile.autoNumber(), data.getFileID(), data.getStudentID(), data.getComment(), data.getSaveDate(), data.getFileName()});
                    loading.StartProgress(models.size(), 100);
                });
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                GlobalDataModel.rootView.setView(this);
                loading.close();
                updateTableFile();
            }
        });
        thread.start();
    }

    private void updateTableFile() {
        pnFileData.removeAll();
        pnFileData.add(jScrollPane2, BorderLayout.CENTER);
        JoDataTable dataTable = new JoDataTable(pnFileData);
        dataTable.setHiddenColumns(1);
        dataTable.setHiddenColumns(5);
        dataTable.showDataTableAll();
        txtfileName.setText("");
        txtComment.setText("");
    }

    public void showFileData(StudentFileModel model) {
        txtfileName.setText(model.getFileName());
        txtComment.setText(model.getComment());
    }

    //====== Getter =========
    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTabbed getTapHistory() {
        return TapHistory;
    }

    //======== History =============
    public JoTextField getTxt_FamiltyID() {
        return txt_FamiltyID;
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

    public JoTextField getTxt_Higth() {
        return txt_Higth;
    }

    public JoTextField getTxt_Weight() {
        return txt_Weight;
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

    public JoTextField getTxt_SiblingAge() {
        return txt_SiblingAge;
    }

    public JoTextField getTxt_SiblingJob() {
        return txt_SiblingJob;
    }

    public JoTextField getTxt_SiblingName() {
        return txt_SiblingName;
    }

    public JoTextField getTxt_SiblingPlace() {
        return txt_SiblingPlace;
    }

    public JoTextField getTxt_SiblingTel() {
        return txt_SiblingTel;
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

    public JoButtonIconfont getBtn_saveHistory() {
        return btn_saveHistory;
    }

    //===== Location =======
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

    public JoTextField getTxt_village() {
        return txt_village;
    }

    public JoTextField getTxt_villageNow() {
        return txt_villageNow;
    }

    public JoButtonIconfont getBtn_saveLocation() {
        return btn_saveLocation;
    }
    //ອ້າຍນ້ອງ

    public JoButtonIconfont getBtnAddBS() {
        return btnAddBS;
    }

    public JoTable getTb_BrotherAndSister() {
        return tb_BrotherAndSister;
    }

    //========Uploadfile ========
    public String getComment() {
        return txtComment.getText();
    }

    public JoButtonIconfont getBtnSaveFile() {
        return btnSaveFile;
    }

    public JoButtonIconfont getBtnUpload() {
        return btnUpload;
    }

    public JoTable getTbFile() {
        return tbFile;
    }

    public void setFileName(String path) {
        txtfileName.setText(path);
    }

    public int getFileID() {
        return tbFile.getIntValue(1);
    }

    public MyPopup getPopupFile() {
        return popupFile;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        modelLiquid1 = new ClassUI.ModelLiquid();
        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        TapHistory = new Components.JoTabbed();
        jPanel1 = new javax.swing.JPanel();
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
        joLable31 = new Components.JoLable();
        parent1 = new Component.ParentComponent();
        joLable32 = new Components.JoLable();
        parent2 = new Component.ParentComponent();
        joLable33 = new Components.JoLable();
        btn_saveHistory = new Components.JoButtonIconfont();
        joPanelTitle2 = new Component.JoPanelTitle();
        txt_FamiltyID = new Components.JoTextField();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        txt_peopleID = new Components.JoTextField();
        joLable3 = new Components.JoLable();
        txt_passportID = new Components.JoTextField();
        joLable4 = new Components.JoLable();
        joLable8 = new Components.JoLable();
        joLable9 = new Components.JoLable();
        txt_SiblingName = new Components.JoTextField();
        joLable10 = new Components.JoLable();
        txt_SiblingAge = new Components.JoTextField();
        joLable11 = new Components.JoLable();
        txt_SiblingTel = new Components.JoTextField();
        txt_SiblingJob = new Components.JoTextField();
        joLable12 = new Components.JoLable();
        txt_SiblingPlace = new Components.JoTextField();
        joLable13 = new Components.JoLable();
        jPanel11 = new javax.swing.JPanel();
        rd_BloodGroupA = new Component.JoRadioButton();
        rd_BloodGroupB = new Component.JoRadioButton();
        rd_BloodGroupAB = new Component.JoRadioButton();
        rd_BloodGroupO = new Component.JoRadioButton();
        jPanel13 = new javax.swing.JPanel();
        rd_DiverCategoryMotobike = new Component.JoRadioButton();
        rd_DiverCategoryCar = new Component.JoRadioButton();
        rd_DiverCategoryOther = new Component.JoRadioButton();
        joLable34 = new Components.JoLable();
        jPanel12 = new javax.swing.JPanel();
        joLable5 = new Components.JoLable();
        txt_Higth = new Components.JoTextField();
        joLable6 = new Components.JoLable();
        txt_Weight = new Components.JoTextField();
        joLable35 = new Components.JoLable();
        jPanel2 = new javax.swing.JPanel();
        joPanelTitle4 = new Component.JoPanelTitle();
        cb_province = new Components.JoCombobox();
        cb_district = new Components.JoCombobox();
        joLable24 = new Components.JoLable();
        joLable25 = new Components.JoLable();
        txt_village = new Components.JoTextField();
        joLable26 = new Components.JoLable();
        joPanelTitle5 = new Component.JoPanelTitle();
        cb_provinceNow = new Components.JoCombobox();
        cb_districtNow = new Components.JoCombobox();
        joLable27 = new Components.JoLable();
        joLable28 = new Components.JoLable();
        txt_villageNow = new Components.JoTextField();
        joLable29 = new Components.JoLable();
        jPanel14 = new javax.swing.JPanel();
        btn_saveLocation = new Components.JoButtonIconfont();
        jPanel6 = new javax.swing.JPanel();
        pnDataTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_BrotherAndSister = new Components.JoTable();
        jPanel8 = new javax.swing.JPanel();
        btnAddBS = new Components.JoButtonIconfont();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        joLable7 = new Components.JoLable();
        joLable30 = new Components.JoLable();
        jPanel10 = new javax.swing.JPanel();
        txtfileName = new Components.JoTextField();
        btnUpload = new Components.JoButtonIconfont();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComment = new Components.JoTextArea();
        btnSaveFile = new Components.JoButtonIconfont();
        pnFileData = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbFile = new Components.JoTable();
        jPanel15 = new javax.swing.JPanel();

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
        Pn_Navigation.add(jPanel5);

        TapHistory.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N

        joPanelTitle1.setBackground(new java.awt.Color(204, 204, 204));
        joPanelTitle1.setJoTitle("ຂໍ້ມູນຄອບຄົວ");
        joPanelTitle1.setOpaque(false);
        joPanelTitle1.setLayout(new java.awt.GridBagLayout());

        joLable14.setText("ປະເພດຜູ້ປົກຄອງ  ຜູ້ປົກຄອງ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 4, 0);
        joPanelTitle1.add(joLable14, gridBagConstraints);

        txt_fatherName.setMinimumSize(new java.awt.Dimension(200, 45));
        txt_fatherName.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        joPanelTitle1.add(txt_fatherName, gridBagConstraints);

        joLable15.setText("ອາຍຸ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(joLable15, gridBagConstraints);

        txt_fatherAge.setMinimumSize(new java.awt.Dimension(200, 45));
        txt_fatherAge.setNumberOnly(true);
        txt_fatherAge.setPlaceholder("ປີ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(txt_fatherAge, gridBagConstraints);

        txt_fatherJob.setMinimumSize(new java.awt.Dimension(200, 45));
        txt_fatherJob.setPlaceholder("ອາຊີບ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        joPanelTitle1.add(txt_fatherJob, gridBagConstraints);

        joLable16.setText("ອາຊີບ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 2, 0);
        joPanelTitle1.add(joLable16, gridBagConstraints);

        txt_fatherTel.setMinimumSize(new java.awt.Dimension(200, 40));
        txt_fatherTel.setNumberOnly(true);
        txt_fatherTel.setPlaceholder("ເບີໂທ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(txt_fatherTel, gridBagConstraints);

        joLable17.setText("ເບີໂທ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 2, 0);
        joPanelTitle1.add(joLable17, gridBagConstraints);

        txt_fatherPlace.setMinimumSize(new java.awt.Dimension(200, 45));
        txt_fatherPlace.setPlaceholder("ປ່ອນປະຈຳການ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(txt_fatherPlace, gridBagConstraints);

        joLable22.setText("ປ່ອນປະຈຳການ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 2, 0);
        joPanelTitle1.add(joLable22, gridBagConstraints);

        joLable18.setText("ຊື່ ແລະ ນາມສະກຸນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 4, 0);
        joPanelTitle1.add(joLable18, gridBagConstraints);

        txt_MotherName.setMinimumSize(new java.awt.Dimension(200, 45));
        txt_MotherName.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        joPanelTitle1.add(txt_MotherName, gridBagConstraints);

        joLable19.setText("ອາຍຸ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 4, 0);
        joPanelTitle1.add(joLable19, gridBagConstraints);

        txt_MotherAge.setMinimumSize(new java.awt.Dimension(200, 45));
        txt_MotherAge.setNumberOnly(true);
        txt_MotherAge.setPlaceholder("ປີ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(txt_MotherAge, gridBagConstraints);

        joLable20.setText("ອາຊີບ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 2, 0);
        joPanelTitle1.add(joLable20, gridBagConstraints);

        txt_MotherJob.setMinimumSize(new java.awt.Dimension(200, 45));
        txt_MotherJob.setPlaceholder("ອາຊີບ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        joPanelTitle1.add(txt_MotherJob, gridBagConstraints);

        joLable23.setText("ປ່ອນປະຈຳການ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 2, 0);
        joPanelTitle1.add(joLable23, gridBagConstraints);

        txt_MotherPlace.setMinimumSize(new java.awt.Dimension(200, 45));
        txt_MotherPlace.setPlaceholder("ປ່ອນປະຈຳການ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(txt_MotherPlace, gridBagConstraints);

        joLable21.setText("ເບີໂທ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 2, 0);
        joPanelTitle1.add(joLable21, gridBagConstraints);

        txt_MotherTel.setMinimumSize(new java.awt.Dimension(200, 40));
        txt_MotherTel.setNumberOnly(true);
        txt_MotherTel.setPlaceholder("ເບີໂທ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(txt_MotherTel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        joPanelTitle1.add(joLable31, gridBagConstraints);

        parent1.setMaximumSize(new java.awt.Dimension(200, 45));
        parent1.setMinimumSize(new java.awt.Dimension(200, 45));
        parent1.setPreferredSize(new java.awt.Dimension(200, 45));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(parent1, gridBagConstraints);

        joLable32.setText("ຊື່ ແລະ ນາມສະກຸນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        joPanelTitle1.add(joLable32, gridBagConstraints);

        parent2.setMinimumSize(new java.awt.Dimension(200, 40));
        parent2.setPreferredSize(new java.awt.Dimension(200, 45));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(parent2, gridBagConstraints);

        joLable33.setText("ປະເພດຜູ້ປົກຄອງ  ຜູ້ປົກຄອງ");
        joLable33.setMinimumSize(new java.awt.Dimension(100, 19));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        joPanelTitle1.add(joLable33, gridBagConstraints);

        btn_saveHistory.setText("ບັກທຶກປະຫວັດຫຍໍ້");
        btn_saveHistory.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_saveHistory.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btn_saveHistory.setPreferredSize(new java.awt.Dimension(400, 41));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 0, 0);
        joPanelTitle1.add(btn_saveHistory, gridBagConstraints);

        joPanelTitle2.setBackground(new java.awt.Color(204, 204, 204));
        joPanelTitle2.setJoTitle("ຂໍ້ມູນສ່ວນຕົວ");
        joPanelTitle2.setOpaque(false);
        joPanelTitle2.setLayout(new java.awt.GridBagLayout());

        txt_FamiltyID.setMinimumSize(new java.awt.Dimension(200, 40));
        txt_FamiltyID.setPlaceholder("ເລກສຳມະໂນຄົວ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(txt_FamiltyID, gridBagConstraints);

        joLable1.setText("ເລກສຳມະໂນຄົວ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(joLable1, gridBagConstraints);

        joLable2.setText("ເລກບັດປະຈຳຕົວ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 0);
        joPanelTitle2.add(joLable2, gridBagConstraints);

        txt_peopleID.setMinimumSize(new java.awt.Dimension(100, 40));
        txt_peopleID.setPlaceholder("ເລກບັດປະຈຳຕົວ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 0);
        joPanelTitle2.add(txt_peopleID, gridBagConstraints);

        joLable3.setText("ເລກພາດສະປອດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 0);
        joPanelTitle2.add(joLable3, gridBagConstraints);

        txt_passportID.setMinimumSize(new java.awt.Dimension(100, 40));
        txt_passportID.setPlaceholder("ເລກພາດສະປອດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 0);
        joPanelTitle2.add(txt_passportID, gridBagConstraints);

        joLable4.setText("ກຸບເລືອດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(joLable4, gridBagConstraints);

        joLable8.setText("ປະເພດຍານພາຫະນະ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 0);
        joPanelTitle2.add(joLable8, gridBagConstraints);

        joLable9.setText("ຊື່ ແລະ ນາມສະກຸນ ອ້າຍນ້ອງ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(joLable9, gridBagConstraints);

        txt_SiblingName.setMinimumSize(new java.awt.Dimension(100, 40));
        txt_SiblingName.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ ອ້າຍນ້ອງ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(txt_SiblingName, gridBagConstraints);

        joLable10.setText("ອາຍຸ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 0);
        joPanelTitle2.add(joLable10, gridBagConstraints);

        txt_SiblingAge.setMinimumSize(new java.awt.Dimension(100, 40));
        txt_SiblingAge.setNumberOnly(true);
        txt_SiblingAge.setPlaceholder("ປີ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 0);
        joPanelTitle2.add(txt_SiblingAge, gridBagConstraints);

        joLable11.setText("ເບີໂທ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(joLable11, gridBagConstraints);

        txt_SiblingTel.setMinimumSize(new java.awt.Dimension(100, 40));
        txt_SiblingTel.setNumberOnly(true);
        txt_SiblingTel.setPlaceholder("ເບີໂທ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(txt_SiblingTel, gridBagConstraints);

        txt_SiblingJob.setMinimumSize(new java.awt.Dimension(100, 40));
        txt_SiblingJob.setPlaceholder("ອາຊີບ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 0);
        joPanelTitle2.add(txt_SiblingJob, gridBagConstraints);

        joLable12.setText("ອາຊີບ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 0);
        joPanelTitle2.add(joLable12, gridBagConstraints);

        txt_SiblingPlace.setMinimumSize(new java.awt.Dimension(200, 40));
        txt_SiblingPlace.setPlaceholder("ບ່ອນປະຈຳການ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(txt_SiblingPlace, gridBagConstraints);

        joLable13.setText("ບ່ອນປະຈຳການ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 9, 5, 0);
        joPanelTitle2.add(joLable13, gridBagConstraints);

        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(10, 35));

        buttonGroup1.add(rd_BloodGroupA);
        rd_BloodGroupA.setText("ກຸບ A");
        jPanel11.add(rd_BloodGroupA);

        buttonGroup1.add(rd_BloodGroupB);
        rd_BloodGroupB.setText("ກຸບ B");
        jPanel11.add(rd_BloodGroupB);

        buttonGroup1.add(rd_BloodGroupAB);
        rd_BloodGroupAB.setText("ກຸບ AB");
        jPanel11.add(rd_BloodGroupAB);

        buttonGroup1.add(rd_BloodGroupO);
        rd_BloodGroupO.setText("ກຸບ O");
        jPanel11.add(rd_BloodGroupO);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(jPanel11, gridBagConstraints);

        jPanel13.setOpaque(false);
        jPanel13.setPreferredSize(new java.awt.Dimension(10, 35));

        buttonGroup2.add(rd_DiverCategoryMotobike);
        rd_DiverCategoryMotobike.setText("ລົດຈັກ");
        jPanel13.add(rd_DiverCategoryMotobike);

        buttonGroup2.add(rd_DiverCategoryCar);
        rd_DiverCategoryCar.setText("ລົດໃຫຍ່");
        jPanel13.add(rd_DiverCategoryCar);

        buttonGroup2.add(rd_DiverCategoryOther);
        rd_DiverCategoryOther.setText("ອື່່ນໆ");
        jPanel13.add(rd_DiverCategoryOther);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 8, 5, 0);
        joPanelTitle2.add(jPanel13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanelTitle2.add(joLable34, gridBagConstraints);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridBagLayout());

        joLable5.setText("ສ່ວນສູງ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel12.add(joLable5, gridBagConstraints);

        txt_Higth.setMinimumSize(new java.awt.Dimension(100, 40));
        txt_Higth.setNumberOnly(true);
        txt_Higth.setPlaceholder("CM");
        txt_Higth.setPreferredSize(new java.awt.Dimension(100, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel12.add(txt_Higth, gridBagConstraints);

        joLable6.setText("ນ້ຳໜັກ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel12.add(joLable6, gridBagConstraints);

        txt_Weight.setMinimumSize(new java.awt.Dimension(100, 40));
        txt_Weight.setNumberOnly(true);
        txt_Weight.setPlaceholder("KG");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel12.add(txt_Weight, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel12.add(joLable35, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        joPanelTitle2.add(jPanel12, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joPanelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joPanelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        TapHistory.addTab("ປະຫວັດຫຍໍ້", jPanel1);

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

        btn_saveLocation.setText("ບັນທຶກທີ່ຢູ່");
        btn_saveLocation.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_saveLocation.setPreferredSize(new java.awt.Dimension(165, 41));
        jPanel14.add(btn_saveLocation);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(joPanelTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(joPanelTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(joPanelTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joPanelTitle5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        TapHistory.addTab("ທີ່ຢູ່", jPanel2);

        pnDataTable.setLayout(new java.awt.BorderLayout());

        tb_BrotherAndSister.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "BSID", "studentID", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ", "ຂະແໜງ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_BrotherAndSister);

        pnDataTable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAddBS.setText("ເພີ້ມອ້າຍນ້ອງ");
        jPanel8.add(btnAddBS);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDataTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDataTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        TapHistory.addTab("ພີ່ນ້ອງ", jPanel6);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel9.setMaximumSize(new java.awt.Dimension(800, 300));
        jPanel9.setMinimumSize(new java.awt.Dimension(800, 300));
        jPanel9.setPreferredSize(new java.awt.Dimension(800, 300));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        joLable7.setText("ໄຟລ໌ເອກະສານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel9.add(joLable7, gridBagConstraints);

        joLable30.setText("ລາຍລະອຽດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel9.add(joLable30, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridBagLayout());

        txtfileName.setEditable(false);
        txtfileName.setMaximumSize(new java.awt.Dimension(100, 100));
        txtfileName.setMinimumSize(new java.awt.Dimension(500, 21));
        txtfileName.setPlaceholder("ໄຟລ໌ເອກະສານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel10.add(txtfileName, gridBagConstraints);

        btnUpload.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLOUD_UPLOAD);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel10.add(btnUpload, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        jPanel9.add(jPanel10, gridBagConstraints);

        txtComment.setColumns(20);
        txtComment.setRows(5);
        txtComment.setMaximumSize(new java.awt.Dimension(100, 100));
        jScrollPane4.setViewportView(txtComment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel9.add(jScrollPane4, gridBagConstraints);

        btnSaveFile.setText("ບັນທຶກ");
        btnSaveFile.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        jPanel9.add(btnSaveFile, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel7.add(jPanel9, gridBagConstraints);

        pnFileData.setLayout(new java.awt.BorderLayout());

        tbFile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "FileID", "StudentID", "ລາຍລະອຽດ", "ວັນທີ", "FileName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFile.setMaximumSize(new java.awt.Dimension(800, 0));
        jScrollPane2.setViewportView(tbFile);

        pnFileData.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(pnFileData, gridBagConstraints);

        TapHistory.addTab("ເອກະສານນັກຮຽນ", jPanel7);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1233, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        TapHistory.addTab("ຮູ້ຈັກໂຮງຮຽນສາຍຝົນ", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TapHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TapHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoTabbed TapHistory;
    private Components.JoButtonIconfont btnAddBS;
    private Components.JoButtonIconfont btnSaveFile;
    private Components.JoButtonIconfont btnUpload;
    private Components.JoButtonIconfont btn_back;
    private Components.JoButtonIconfont btn_saveHistory;
    private Components.JoButtonIconfont btn_saveLocation;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private Components.JoCombobox cb_district;
    private Components.JoCombobox cb_districtNow;
    private Components.JoCombobox cb_province;
    private Components.JoCombobox cb_provinceNow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
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
    private Components.JoLable joLable4;
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
    private ClassUI.ModelLiquid modelLiquid1;
    private Component.ParentComponent parent1;
    private Component.ParentComponent parent2;
    private javax.swing.JPanel pnDataTable;
    private javax.swing.JPanel pnFileData;
    private Component.JoRadioButton rd_BloodGroupA;
    private Component.JoRadioButton rd_BloodGroupAB;
    private Component.JoRadioButton rd_BloodGroupB;
    private Component.JoRadioButton rd_BloodGroupO;
    private Component.JoRadioButton rd_DiverCategoryCar;
    private Component.JoRadioButton rd_DiverCategoryMotobike;
    private Component.JoRadioButton rd_DiverCategoryOther;
    private Components.JoTable tbFile;
    private Components.JoTable tb_BrotherAndSister;
    private Components.JoTextArea txtComment;
    private Components.JoTextField txt_FamiltyID;
    private Components.JoTextField txt_Higth;
    private Components.JoTextField txt_MotherAge;
    private Components.JoTextField txt_MotherJob;
    private Components.JoTextField txt_MotherName;
    private Components.JoTextField txt_MotherPlace;
    private Components.JoTextField txt_MotherTel;
    private Components.JoTextField txt_SiblingAge;
    private Components.JoTextField txt_SiblingJob;
    private Components.JoTextField txt_SiblingName;
    private Components.JoTextField txt_SiblingPlace;
    private Components.JoTextField txt_SiblingTel;
    private Components.JoTextField txt_Weight;
    private Components.JoTextField txt_fatherAge;
    private Components.JoTextField txt_fatherJob;
    private Components.JoTextField txt_fatherName;
    private Components.JoTextField txt_fatherPlace;
    private Components.JoTextField txt_fatherTel;
    private Components.JoTextField txt_passportID;
    private Components.JoTextField txt_peopleID;
    private Components.JoTextField txt_village;
    private Components.JoTextField txt_villageNow;
    private Components.JoTextField txtfileName;
    // End of variables declaration//GEN-END:variables

}
