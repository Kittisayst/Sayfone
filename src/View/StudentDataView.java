package View;

import Component.JoRadioButton;
import Components.JoButtonIconfont;
import Components.JoCheckBox;
import Components.JoCombobox;
import Components.JoDateChooser;
import Components.JoImageAvatar;
import Components.JoLableIcon;
import Components.JoTextField;
import Model.EthnicModel;
import Model.NationalityModel;
import Model.ReligionModel;
import Model.StudentModel;
import Tools.JoIconTransparent;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;

public class StudentDataView extends javax.swing.JPanel {

    public StudentDataView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        JoIconTransparent joIconTransparent = new JoIconTransparent(lbl_AddImage, new Color(153, 153, 153));
    }

    public void showAvatar(ImageIcon icon) {
        img_avatar.setIcon(icon);
    }

    public void showStudent(StudentModel model) {
        img_avatar.setIcon(model.getAvatar());
        txt_StudentNo.setText(model.getStudentNo());
        txt_name.setText(model.getStudentName());
        txt_nameENG.setText(model.getStudentENG());
        txt_nickName.setText(model.getNickName());
        txt_Sibling.setText("" + model.getSibling());
        txt_Preschool.setText(model.getPreschool());
        txt_Talent.setText(model.getTalent());
        txt_Disabled.setText(model.getDisabled());
        dt_dfb.setDateData(model.getDateofBirth());
        dt_dateStart.setDateData(model.getDateStart());
        dt_DateStop.setDateData(model.getDateStop());
        rd_male.setSelected(model.getGender() == 1);
        rd_female.setSelected(model.getGender() == 0);
        ck_GoHomeYes.setSelected(model.getGoHome() == 1);
        ck_GoHomeNo.setSelected(model.getGoHome() == 0);
        rd_Studying.setSelected(model.getStatus() == 0);
        rd_StudyDrop.setSelected(model.getStatus() == 1);
        rd_StudyStop.setSelected(model.getStatus() == 2);
        rd_Strong.setSelected(model.getHealth() == 1);
        rd_Weakness.setSelected(model.getHealth() == 0);
        rd_VaccinStateYes.setSelected(model.getVaccinState() == 1);
        rd_VaccinStateNo.setSelected(model.getVaccinState() == 0);
        cb_ethnic.setSelectValue("" + model.getEthnicID());
        cb_nationality.setSelectValue("" + model.getNationalityID());
        cb_religion.setSelectValue("" + model.getReligionID());
        showButtunState(true);
    }

    public void showNationality(List<NationalityModel> models) {
        models.forEach(data -> {
            cb_nationality.JoAddModel("" + data.getNationalityID(), data.getNationalityName());
        });
    }

    public void showReligion(List<ReligionModel> classModels) {
        classModels.forEach(data -> {
            cb_religion.JoAddModel("" + data.getReligionID(), data.getReligionName());
        });
    }

    public void showEthnic(List<EthnicModel> ethnicModels) {
        ethnicModels.forEach(data -> {
            cb_ethnic.JoAddModel("" + data.getEthnicID(), data.getEthnicName());
        });
    }

    public void showButtunState(boolean state) {
        btn_History.setEnabled(state);
        btn_Vaccine.setEnabled(state);
        btn_delete.setEnabled(state);
        btn_BrotherSister.setEnabled(state);
    }

    //====== Getter ===========
    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtn_delete() {
        return btn_delete;
    }

    public JoImageAvatar getImg_avatar() {
        return img_avatar;
    }

    public JoLableIcon getLbl_AddImage() {
        return lbl_AddImage;
    }

    public JoButtonIconfont getBtn_History() {
        return btn_History;
    }

    public JoButtonIconfont getBtn_Vaccine() {
        return btn_Vaccine;
    }

    public JoButtonIconfont getBtn_Save() {
        return btn_Save;
    }

    public JoCombobox getCb_ethnic() {
        return cb_ethnic;
    }

    public JoCombobox getCb_nationality() {
        return cb_nationality;
    }

    public JoCombobox getCb_religion() {
        return cb_religion;
    }

    public JoCheckBox getCk_GoHomeNo() {
        return ck_GoHomeNo;
    }

    public JoCheckBox getCk_GoHomeYes() {
        return ck_GoHomeYes;
    }

    public JoDateChooser getDt_DateStop() {
        return dt_DateStop;
    }

    public JoDateChooser getDt_dateStart() {
        return dt_dateStart;
    }

    public JoDateChooser getDt_dfb() {
        return dt_dfb;
    }

    public JoRadioButton getRd_Strong() {
        return rd_Strong;
    }

    public JoRadioButton getRd_StudyDrop() {
        return rd_StudyDrop;
    }

    public JoRadioButton getRd_StudyStop() {
        return rd_StudyStop;
    }

    public JoRadioButton getRd_Studying() {
        return rd_Studying;
    }

    public JoRadioButton getRd_VaccinStateNo() {
        return rd_VaccinStateNo;
    }

    public JoRadioButton getRd_VaccinStateYes() {
        return rd_VaccinStateYes;
    }

    public JoRadioButton getRd_Weakness() {
        return rd_Weakness;
    }

    public JoRadioButton getRd_female() {
        return rd_female;
    }

    public JoRadioButton getRd_male() {
        return rd_male;
    }

    public JoTextField getTxt_Disabled() {
        return txt_Disabled;
    }

    public JoTextField getTxt_Preschool() {
        return txt_Preschool;
    }

    public JoTextField getTxt_Sibling() {
        return txt_Sibling;
    }

    public JoTextField getTxt_StudentNo() {
        return txt_StudentNo;
    }

    public JoTextField getTxt_Talent() {
        return txt_Talent;
    }

    public JoTextField getTxt_name() {
        return txt_name;
    }

    public JoTextField getTxt_nameENG() {
        return txt_nameENG;
    }

    public JoTextField getTxt_nickName() {
        return txt_nickName;
    }

    public JoButtonIconfont getBtn_BrotherSister() {
        return btn_BrotherSister;
    }

    public int getStudentState() {
        if (rd_Studying.isSelected()) {
            return 0;
        } else if (rd_StudyDrop.isSelected()) {
            return 1;
        } else if (rd_StudyStop.isSelected()) {
            return 2;
        } else {
            return -1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        PNStudent1 = new Components.JoPanel();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        dt_dfb = new Components.JoDateChooser();
        jPanel6 = new javax.swing.JPanel();
        lbl_AddImage = new Components.JoLableIcon();
        img_avatar = new Components.JoImageAvatar();
        joLable14 = new Components.JoLable();
        txt_nickName = new Components.JoTextField();
        joPanelTitle4 = new Component.JoPanelTitle();
        btn_History = new Components.JoButtonIconfont();
        btn_Vaccine = new Components.JoButtonIconfont();
        btn_BrotherSister = new Components.JoButtonIconfont();
        joLable20 = new Components.JoLable();
        jPanel1 = new javax.swing.JPanel();
        rd_male = new Component.JoRadioButton();
        rd_female = new Component.JoRadioButton();
        jPanel2 = new javax.swing.JPanel();
        ck_GoHomeYes = new Components.JoCheckBox();
        ck_GoHomeNo = new Components.JoCheckBox();
        jPanel8 = new javax.swing.JPanel();
        PNStudent2 = new Components.JoPanel();
        joPanelTitle1 = new Component.JoPanelTitle();
        joLable4 = new Components.JoLable();
        txt_StudentNo = new Components.JoTextField();
        joLable5 = new Components.JoLable();
        txt_name = new Components.JoTextField();
        joLable6 = new Components.JoLable();
        txt_nameENG = new Components.JoTextField();
        joLable7 = new Components.JoLable();
        txt_Sibling = new Components.JoTextField();
        joLable8 = new Components.JoLable();
        txt_Preschool = new Components.JoTextField();
        joLable9 = new Components.JoLable();
        txt_Talent = new Components.JoTextField();
        joPanelTitle2 = new Component.JoPanelTitle();
        joLable11 = new Components.JoLable();
        dt_dateStart = new Components.JoDateChooser();
        joLable12 = new Components.JoLable();
        dt_DateStop = new Components.JoDateChooser();
        joLable3 = new Components.JoLable();
        rd_Studying = new Component.JoRadioButton();
        rd_StudyDrop = new Component.JoRadioButton();
        rd_StudyStop = new Component.JoRadioButton();
        joLable13 = new Components.JoLable();
        rd_Strong = new Component.JoRadioButton();
        rd_Weakness = new Component.JoRadioButton();
        joLable18 = new Components.JoLable();
        txt_Disabled = new Components.JoTextField();
        joLable19 = new Components.JoLable();
        rd_VaccinStateYes = new Component.JoRadioButton();
        rd_VaccinStateNo = new Component.JoRadioButton();
        joPanelTitle3 = new Component.JoPanelTitle();
        joLable15 = new Components.JoLable();
        cb_nationality = new Components.JoCombobox();
        joLable16 = new Components.JoLable();
        joLable17 = new Components.JoLable();
        cb_religion = new Components.JoCombobox();
        cb_ethnic = new Components.JoCombobox();
        jPanel7 = new javax.swing.JPanel();
        btn_Save = new Components.JoButtonIconfont();
        btn_delete = new Components.JoButtonIconfont();

        setLayout(new java.awt.GridBagLayout());

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(Pn_Navigation, gridBagConstraints);

        PNStudent1.setJoPrimaryColor(new java.awt.Color(249, 249, 249));
        PNStudent1.setJoSecondaryColor(new java.awt.Color(249, 249, 249));
        PNStudent1.setMaximumSize(new java.awt.Dimension(400, 150));
        PNStudent1.setMinimumSize(new java.awt.Dimension(300, 150));
        PNStudent1.setPreferredSize(new java.awt.Dimension(300, 150));
        PNStudent1.setLayout(new java.awt.GridBagLayout());

        joLable1.setText("ວັນເດືອນປີເກີດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        PNStudent1.add(joLable1, gridBagConstraints);

        joLable2.setText("ເພດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        PNStudent1.add(joLable2, gridBagConstraints);

        dt_dfb.setMinimumSize(new java.awt.Dimension(240, 40));
        dt_dfb.setPlaceholder("ວັນເດືອນປີເກີດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        PNStudent1.add(dt_dfb, gridBagConstraints);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_AddImage.setJoIconColor(new java.awt.Color(153, 153, 153));
        lbl_AddImage.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CAMERA_ALT);
        jPanel6.add(lbl_AddImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 90, -1, -1));

        img_avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/sticon.png"))); // NOI18N
        jPanel6.add(img_avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 11, 100, 100));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        PNStudent1.add(jPanel6, gridBagConstraints);

        joLable14.setText("ຊື່ຫຼີ້ນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        PNStudent1.add(joLable14, gridBagConstraints);

        txt_nickName.setPlaceholder("ຊື່ຫຼີ້ນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        PNStudent1.add(txt_nickName, gridBagConstraints);

        joPanelTitle4.setJoTitle("ຂໍ້ມູນທີ່ກ່ຽວຂ້ອງ");
        joPanelTitle4.setOpaque(false);

        btn_History.setText("ປະຫວັດຫຍໍ້ / ທີ່ຢູ່");
        btn_History.setEnabled(false);
        btn_History.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_History.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT);

        btn_Vaccine.setText("ຮັບວັກຊີນ");
        btn_Vaccine.setEnabled(false);
        btn_Vaccine.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Vaccine.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_HOSPITAL);

        btn_BrotherSister.setText("ອ້າຍນ້ອງ");
        btn_BrotherSister.setEnabled(false);
        btn_BrotherSister.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_BrotherSister.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);

        javax.swing.GroupLayout joPanelTitle4Layout = new javax.swing.GroupLayout(joPanelTitle4);
        joPanelTitle4.setLayout(joPanelTitle4Layout);
        joPanelTitle4Layout.setHorizontalGroup(
            joPanelTitle4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_History, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
            .addComponent(btn_BrotherSister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        joPanelTitle4Layout.setVerticalGroup(
            joPanelTitle4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btn_History, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_BrotherSister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        PNStudent1.add(joPanelTitle4, gridBagConstraints);

        joLable20.setText("ອະນຸຍາດ ໃຫ້ກັບເຮືອນຕອນທ່ຽງ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        PNStudent1.add(joLable20, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(204, 0, 102));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        buttonGroup2.add(rd_male);
        rd_male.setSelected(true);
        rd_male.setText("ຊາຍ");
        jPanel1.add(rd_male);

        buttonGroup2.add(rd_female);
        rd_female.setText("ຍິງ");
        jPanel1.add(rd_female);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        PNStudent1.add(jPanel1, gridBagConstraints);

        jPanel2.setOpaque(false);

        buttonGroup1.add(ck_GoHomeYes);
        ck_GoHomeYes.setForeground(new java.awt.Color(0, 102, 51));
        ck_GoHomeYes.setSelected(true);
        ck_GoHomeYes.setText("ໄດ້ຮັບອານຸຍາດ");
        jPanel2.add(ck_GoHomeYes);

        buttonGroup1.add(ck_GoHomeNo);
        ck_GoHomeNo.setForeground(new java.awt.Color(204, 51, 0));
        ck_GoHomeNo.setText("ບໍ່ໄດ້ຮັບອານຸຍາດ");
        jPanel2.add(ck_GoHomeNo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        PNStudent1.add(jPanel2, gridBagConstraints);

        jPanel8.setOpaque(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        PNStudent1.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(PNStudent1, gridBagConstraints);

        PNStudent2.setJoPrimaryColor(new java.awt.Color(249, 249, 249));
        PNStudent2.setJoSecondaryColor(new java.awt.Color(249, 249, 249));
        PNStudent2.setLayout(new java.awt.GridBagLayout());

        joPanelTitle1.setJoTitle("ຂໍ້ມູນພື້ນຖານ");
        joPanelTitle1.setOpaque(false);

        joLable4.setText("ລະຫັດນັກສຶກສາ");

        txt_StudentNo.setPlaceholder("ລະຫັດນັກສຶກສາ");

        joLable5.setText("ຊື່ ແລະ ນາມສະກຸນ");

        txt_name.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ");

        joLable6.setText("ຊື່ ແລະ ນາມສະກຸນ (ອັງກິດ)");

        txt_nameENG.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ (ອັງກິດ)");

        joLable7.setText("ອ້າຍນ້ອງທັງໝົດ");

        txt_Sibling.setNumberOnly(true);
        txt_Sibling.setPlaceholder("ຈຳນວນ");

        joLable8.setText("ໂຮງຮຽນທີ່ຜ່ານມາລ່າສຸດ");

        txt_Preschool.setPlaceholder("ໂຮງຮຽນທີ່ຜ່ານມາລ່າສຸດ");

        joLable9.setText("ຄວາມສາມາດພິເສດ");

        txt_Talent.setPlaceholder("ຄວາມສາມາດພິເສດ");

        javax.swing.GroupLayout joPanelTitle1Layout = new javax.swing.GroupLayout(joPanelTitle1);
        joPanelTitle1.setLayout(joPanelTitle1Layout);
        joPanelTitle1Layout.setHorizontalGroup(
            joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_StudentNo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable4, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nameENG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(joLable7, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(txt_Sibling, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Preschool, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                            .addComponent(joLable8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joLable9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Talent, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))))
                .addContainerGap())
        );
        joPanelTitle1Layout.setVerticalGroup(
            joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addComponent(joLable6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nameENG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(joPanelTitle1Layout.createSequentialGroup()
                            .addComponent(joLable5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(joPanelTitle1Layout.createSequentialGroup()
                            .addComponent(joLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_StudentNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_Sibling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Preschool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Talent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        PNStudent2.add(joPanelTitle1, gridBagConstraints);

        joPanelTitle2.setJoTitle("ຂໍ້ມູນນັກຮຽນ");
        joPanelTitle2.setOpaque(false);

        joLable11.setText("ວັນທີ່ເລີ່ມຮຽນ");

        dt_dateStart.setPlaceholder("ວັນທີ່ເລີ່ມຮຽນ");

        joLable12.setText("ວັນທີ່ອອກຮຽນ");

        dt_DateStop.setPlaceholder("ວັນທີ່ອອກຮຽນ");

        joLable3.setText("ສະຖານະນັກຮຽນ");

        buttonGroup3.add(rd_Studying);
        rd_Studying.setForeground(new java.awt.Color(0, 153, 51));
        rd_Studying.setSelected(true);
        rd_Studying.setText("ຮຽນຢູ່");
        rd_Studying.setMinimumSize(new java.awt.Dimension(65, 29));
        rd_Studying.setPreferredSize(new java.awt.Dimension(80, 40));

        buttonGroup3.add(rd_StudyDrop);
        rd_StudyDrop.setForeground(new java.awt.Color(255, 204, 0));
        rd_StudyDrop.setText("ພັກຮຽນ");
        rd_StudyDrop.setMinimumSize(new java.awt.Dimension(65, 29));
        rd_StudyDrop.setPreferredSize(new java.awt.Dimension(80, 40));

        buttonGroup3.add(rd_StudyStop);
        rd_StudyStop.setForeground(new java.awt.Color(255, 51, 0));
        rd_StudyStop.setText("ປະລະການຮຽນ");
        rd_StudyStop.setMinimumSize(new java.awt.Dimension(65, 29));
        rd_StudyStop.setPreferredSize(new java.awt.Dimension(80, 40));

        joLable13.setText("ສຸກຂະພາບ");

        buttonGroup4.add(rd_Strong);
        rd_Strong.setForeground(new java.awt.Color(51, 0, 204));
        rd_Strong.setSelected(true);
        rd_Strong.setText("ແຂງແຮງ");
        rd_Strong.setMinimumSize(new java.awt.Dimension(65, 29));
        rd_Strong.setPreferredSize(new java.awt.Dimension(80, 40));

        buttonGroup4.add(rd_Weakness);
        rd_Weakness.setForeground(new java.awt.Color(0, 204, 204));
        rd_Weakness.setText("ອ່ອນເພຍ");
        rd_Weakness.setPreferredSize(new java.awt.Dimension(80, 40));

        joLable18.setText("ພິການ");

        txt_Disabled.setPlaceholder("ພິການ");

        joLable19.setText("ສັກຢາກັນພະຍາດ");

        buttonGroup5.add(rd_VaccinStateYes);
        rd_VaccinStateYes.setForeground(new java.awt.Color(0, 0, 153));
        rd_VaccinStateYes.setSelected(true);
        rd_VaccinStateYes.setText("ຄົບຖ້ວນ");
        rd_VaccinStateYes.setPreferredSize(new java.awt.Dimension(80, 40));

        buttonGroup5.add(rd_VaccinStateNo);
        rd_VaccinStateNo.setForeground(new java.awt.Color(255, 204, 0));
        rd_VaccinStateNo.setText("ບໍ່ຄົບ");
        rd_VaccinStateNo.setPreferredSize(new java.awt.Dimension(80, 40));

        javax.swing.GroupLayout joPanelTitle2Layout = new javax.swing.GroupLayout(joPanelTitle2);
        joPanelTitle2.setLayout(joPanelTitle2Layout);
        joPanelTitle2Layout.setHorizontalGroup(
            joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(joLable11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dt_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(joLable12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dt_DateStop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addComponent(rd_Studying, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_StudyDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_StudyStop, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addComponent(rd_Strong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_Weakness, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(joLable13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addComponent(rd_VaccinStateYes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rd_VaccinStateNo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(joLable19, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joLable18, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(txt_Disabled, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        joPanelTitle2Layout.setVerticalGroup(
            joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dt_DateStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joLable18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rd_Weakness, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rd_VaccinStateYes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rd_VaccinStateNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_Disabled, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_Strong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_StudyStop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rd_Studying, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rd_StudyDrop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        PNStudent2.add(joPanelTitle2, gridBagConstraints);

        joPanelTitle3.setJoTitle("ຂໍ້ມູນສັນຊາດ-ສາດສະໜາ");
        joPanelTitle3.setOpaque(false);

        joLable15.setText("ສັນຊາດ");

        joLable16.setText("ສາດສະໜາ");

        joLable17.setText("ຊົນເຜົ່າ");

        javax.swing.GroupLayout joPanelTitle3Layout = new javax.swing.GroupLayout(joPanelTitle3);
        joPanelTitle3.setLayout(joPanelTitle3Layout);
        joPanelTitle3Layout.setHorizontalGroup(
            joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_nationality, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_religion, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_ethnic, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap())
        );
        joPanelTitle3Layout.setVerticalGroup(
            joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joLable15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cb_nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_religion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_ethnic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        PNStudent2.add(joPanelTitle3, gridBagConstraints);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        btn_Save.setText("ບັນທຶກຂໍ້ມຸນນັກຮຽນ");
        btn_Save.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_Save.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btn_Save.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanel7.add(btn_Save);

        btn_delete.setBackground(new java.awt.Color(255, 51, 51));
        btn_delete.setText("ລົບຂໍ້ມູນນັກຮຽນ");
        btn_delete.setEnabled(false);
        btn_delete.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_delete.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.DELETE);
        btn_delete.setJocolorHover(new java.awt.Color(158, 30, 30));
        btn_delete.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanel7.add(btn_delete);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        PNStudent2.add(jPanel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(PNStudent2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoPanel PNStudent1;
    private Components.JoPanel PNStudent2;
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_BrotherSister;
    private Components.JoButtonIconfont btn_History;
    private Components.JoButtonIconfont btn_Save;
    private Components.JoButtonIconfont btn_Vaccine;
    private Components.JoButtonIconfont btn_back;
    private Components.JoButtonIconfont btn_delete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private Components.JoCombobox cb_ethnic;
    private Components.JoCombobox cb_nationality;
    private Components.JoCombobox cb_religion;
    private Components.JoCheckBox ck_GoHomeNo;
    private Components.JoCheckBox ck_GoHomeYes;
    private Components.JoDateChooser dt_DateStop;
    private Components.JoDateChooser dt_dateStart;
    private Components.JoDateChooser dt_dfb;
    private Components.JoImageAvatar img_avatar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private Components.JoLable joLable1;
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
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable joLable7;
    private Components.JoLable joLable8;
    private Components.JoLable joLable9;
    private Component.JoPanelTitle joPanelTitle1;
    private Component.JoPanelTitle joPanelTitle2;
    private Component.JoPanelTitle joPanelTitle3;
    private Component.JoPanelTitle joPanelTitle4;
    private Components.JoLableIcon lbl_AddImage;
    private Components.JoLable lbl_title;
    private Component.JoRadioButton rd_Strong;
    private Component.JoRadioButton rd_StudyDrop;
    private Component.JoRadioButton rd_StudyStop;
    private Component.JoRadioButton rd_Studying;
    private Component.JoRadioButton rd_VaccinStateNo;
    private Component.JoRadioButton rd_VaccinStateYes;
    private Component.JoRadioButton rd_Weakness;
    private Component.JoRadioButton rd_female;
    private Component.JoRadioButton rd_male;
    private Components.JoTextField txt_Disabled;
    private Components.JoTextField txt_Preschool;
    private Components.JoTextField txt_Sibling;
    private Components.JoTextField txt_StudentNo;
    private Components.JoTextField txt_Talent;
    private Components.JoTextField txt_name;
    private Components.JoTextField txt_nameENG;
    private Components.JoTextField txt_nickName;
    // End of variables declaration//GEN-END:variables
}
