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
import DAOSevervice.ProvinceService;
import DAOSevervice.StudentService;
import Model.BrotherAndSisterModel;
import Tools.JoDataTable;
import java.util.List;

public class StudentHistoryView extends javax.swing.JPanel {

    public StudentHistoryView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void showHistory(StudentHistoryModel model) {
        txt_FamiltyID.setText(model.getFamilyID());
        txt_peopleID.setText(model.getPeopleID());
        txt_passportID.setText(model.getPassportID());
        rd_BloodGroupA.setSelected(model.getBloodGroup() == 0);
        rd_BloodGroupB.setSelected(model.getBloodGroup() == 1);
        rd_BloodGroupAB.setSelected(model.getBloodGroup() == 2);
        rd_BloodGroupO.setSelected(model.getBloodGroup() == 3);
        txt_Higth.setText("" + model.getHigth());
        txt_Weight.setText("" + model.getWeight());
        rd_DiverCategoryCar.setSelected(model.getDiverCategory() == 0);
        rd_DiverCategoryMotobike.setSelected(model.getDiverCategory() == 1);
        rd_DiverCategoryOther.setSelected(model.getDiverCategory() == 2);
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
        txt_MotherPlace.setText(model.getMotherJob());
        txt_MotherTel.setText(model.getMotherTel());
    }

    //Location
    public void showProvince(List<ProvinceModel> model) {
        model.forEach(data -> {
            cb_province.JoAddModel("" + data.getProvinceID(), data.getProvinceName());
        });
    }

    public void showProvinceNow(List<ProvinceModel> model) {
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
            ProvinceService provinceService = new ProvinceService();
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
        models.forEach(data -> {
            tb_BrotherAndSister.AddJoModel(new Object[]{
                tb_BrotherAndSister.autoNumber(),
                data.getBsID(),
                data.getStudentBSID(),
                data.getStudentNo(),
                data.getFullName(),
                new FinancialService().getLastClass(data.getStudentBSID()),
            });
        });
        JoDataTable dataTable = new JoDataTable(pnDataTable);
        dataTable.showDataTableAll();
        dataTable.setHiddenColumns(1);
        dataTable.setHiddenColumns(2);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
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
        joLable8 = new Components.JoLable();
        rd_DiverCategoryMotobike = new Component.JoRadioButton();
        rd_DiverCategoryCar = new Component.JoRadioButton();
        rd_DiverCategoryOther = new Component.JoRadioButton();
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
                                    .addComponent(txt_MotherPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(joLable23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MotherTel, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
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
                .addContainerGap(163, Short.MAX_VALUE))
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

        joLable8.setText("ປະເພດຍານພາຫະນະ");

        buttonGroup2.add(rd_DiverCategoryMotobike);
        rd_DiverCategoryMotobike.setText("ລົດຈັກ");

        buttonGroup2.add(rd_DiverCategoryCar);
        rd_DiverCategoryCar.setText("ລົດໃຫຍ່");

        buttonGroup2.add(rd_DiverCategoryOther);
        rd_DiverCategoryOther.setText("ອື່່ນໆ");

        joLable9.setText("ຊື່ ແລະ ນາມສະກຸນ ອ້າຍນ້ອງ");

        txt_SiblingName.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ ຜົວ/ເມຍ");

        joLable10.setText("ອາຍຸ");

        txt_SiblingAge.setNumberOnly(true);
        txt_SiblingAge.setPlaceholder("ປີ");

        joLable11.setText("ເບີໂທ");

        txt_SiblingTel.setNumberOnly(true);
        txt_SiblingTel.setPlaceholder("ເບີໂທ");

        txt_SiblingJob.setPlaceholder("ອາຊີບ");

        joLable12.setText("ອາຊີບ");

        txt_SiblingPlace.setPlaceholder("ບ່ອນປະຈຳການ");

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
                    .addComponent(joLable8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(rd_DiverCategoryMotobike, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(rd_DiverCategoryCar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(rd_DiverCategoryOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_SiblingTel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(joLable11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_SiblingJob, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(joLable12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_SiblingPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(joLable13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_SiblingName, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                    .addComponent(joLable9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txt_SiblingAge, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
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
                .addComponent(joLable8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_DiverCategoryMotobike, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_DiverCategoryCar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_DiverCategoryOther, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joLable9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_SiblingName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SiblingAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SiblingTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SiblingJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addComponent(joLable13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SiblingPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(237, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(joPanelTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(joPanelTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(238, Short.MAX_VALUE))
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
                .addContainerGap(244, Short.MAX_VALUE))
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
                .addComponent(TapHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoTabbed TapHistory;
    private Components.JoButtonIconfont btnAddBS;
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
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
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
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable joLable8;
    private Components.JoLable joLable9;
    private Component.JoPanelTitle joPanelTitle1;
    private Component.JoPanelTitle joPanelTitle2;
    private Component.JoPanelTitle joPanelTitle4;
    private Component.JoPanelTitle joPanelTitle5;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pnDataTable;
    private Component.JoRadioButton rd_BloodGroupA;
    private Component.JoRadioButton rd_BloodGroupAB;
    private Component.JoRadioButton rd_BloodGroupB;
    private Component.JoRadioButton rd_BloodGroupO;
    private Component.JoRadioButton rd_DiverCategoryCar;
    private Component.JoRadioButton rd_DiverCategoryMotobike;
    private Component.JoRadioButton rd_DiverCategoryOther;
    private Components.JoTable tb_BrotherAndSister;
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
    // End of variables declaration//GEN-END:variables
}
