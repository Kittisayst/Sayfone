package View;

import Component.JoRadioButton;
import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoDateChooser;
import Components.JoImageAvatar;
import Components.JoLableIcon;
import Components.JoTextField;
import Model.ClassModel;
import Model.EthnicModel;
import Model.NationalityModel;
import Model.ReligionModel;
import Model.TeacherModel;
import Tools.JoIconTransparent;
import Utility.JoToolTipText;
import java.awt.Color;
import java.util.List;

public class TeacherDataView extends javax.swing.JPanel {

    public TeacherDataView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        JoIconTransparent joIconTransparent = new JoIconTransparent(lbl_AddImage, new Color(153, 153, 153));
        JoToolTipText joTooltip = new JoToolTipText(btn_History, "ທົດສອຍການສະແດງ");
        joTooltip.setToolTipBackground(new Color(0, 0, 0, 100));
    }

    public void showTeacher(TeacherModel model) {
        img_avatar.setIcon(model.getImageIcon());
        txt_teacherNo.setText(model.getTeacherNo());
        txt_name.setText(model.getName());
        txt_nameENG.setText(model.getNameENG());
        txt_nickName.setText(model.getNickName());
        txt_tel.setText(model.getTel());
        txt_Email.setText(model.getEmail());
        txt_facebook.setText(model.getFacebook());
        rd_male.setSelected(model.getGender() == 1);
        rd_female.setSelected(model.getGender() == 0);
        rd_Strong.setSelected(model.getHealth() == 1);
        rd_Weakness.setSelected(model.getHealth() == 0);
        rd_Complete.setSelected(model.getStatus() == 0);
        rd_probation.setSelected(model.getStatus() == 1);
        rd_unemployed.setSelected(model.getStatus() == 2);
        txt_talent.setText(model.getTalent());
        cb_class.setSelectValue("" + model.getClassID());
        cb_nationality.setSelectValue("" + model.getNationalityID());
        cb_ethnic.setSelectValue("" + model.getEthnicID());
        cb_religion.setSelectValue("" + model.getReligionID());
        dt_dfb.setDateData(model.getDateOfBirth());
        dt_dateStart.setDateData(model.getDateStart());
        dt_DateStop.setDateData(model.getDateStop());
        showButtunState(true);
    }

public void showNationality(List<NationalityModel> models) {
        models.forEach(data -> {
            cb_nationality.JoAddModel("" + data.getNationalityID(), data.getNationalityName());
        });
    }

    public void showClass(List<ClassModel> classModels) {
        classModels.forEach(data -> {
            cb_class.JoAddModel("" + data.getClassID(), data.getClassName());
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
        btn_Outstanding.setEnabled(state);
        btn_Vaccine.setEnabled(state);
        btn_delete.setEnabled(state);
    }

    // Getter
    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtn_History() {
        return btn_History;
    }

    public JoButtonIconfont getBtn_Outstanding() {
        return btn_Outstanding;
    }

    public JoButtonIconfont getBtn_Vaccine() {
        return btn_Vaccine;
    }

    public JoButtonIconfont getBtn_delete() {
        return btn_delete;
    }

    public JoLableIcon getLbl_AddImage() {
        return lbl_AddImage;
    }

    public JoButtonIconfont getBtn_Save() {
        return btn_Save;
    }

    public JoTextField getTxt_Email() {
        return txt_Email;
    }

    public JoTextField getTxt_facebook() {
        return txt_facebook;
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

    public JoTextField getTxt_teacherNo() {
        return txt_teacherNo;
    }

    public JoTextField getTxt_tel() {
        return txt_tel;
    }

    public JoCombobox getCb_class() {
        return cb_class;
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

    public JoDateChooser getDt_DateStop() {
        return dt_DateStop;
    }

    public JoDateChooser getDt_dateStart() {
        return dt_dateStart;
    }

    public JoDateChooser getDt_dfb() {
        return dt_dfb;
    }

    public JoRadioButton getRd_Complete() {
        return rd_Complete;
    }

    public JoRadioButton getRd_Strong() {
        return rd_Strong;
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

    public JoRadioButton getRd_probation() {
        return rd_probation;
    }

    public JoRadioButton getRd_unemployed() {
        return rd_unemployed;
    }

    public JoTextField getTxt_talent() {
        return txt_talent;
    }

    public JoImageAvatar getImg_avatar() {
        return img_avatar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        joPanel1 = new Components.JoPanel();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        dt_dfb = new Components.JoDateChooser();
        jPanel6 = new javax.swing.JPanel();
        lbl_AddImage = new Components.JoLableIcon();
        img_avatar = new Components.JoImageAvatar();
        joLable14 = new Components.JoLable();
        txt_nickName = new Components.JoTextField();
        rd_male = new Component.JoRadioButton();
        rd_female = new Component.JoRadioButton();
        joPanelTitle4 = new Component.JoPanelTitle();
        btn_History = new Components.JoButtonIconfont();
        btn_Outstanding = new Components.JoButtonIconfont();
        btn_Vaccine = new Components.JoButtonIconfont();
        joPanel2 = new Components.JoPanel();
        joPanelTitle1 = new Component.JoPanelTitle();
        joLable4 = new Components.JoLable();
        txt_teacherNo = new Components.JoTextField();
        joLable5 = new Components.JoLable();
        txt_name = new Components.JoTextField();
        joLable6 = new Components.JoLable();
        txt_nameENG = new Components.JoTextField();
        joLable7 = new Components.JoLable();
        txt_tel = new Components.JoTextField();
        joLable8 = new Components.JoLable();
        txt_Email = new Components.JoTextField();
        joLable9 = new Components.JoLable();
        txt_facebook = new Components.JoTextField();
        joPanelTitle2 = new Component.JoPanelTitle();
        joLable10 = new Components.JoLable();
        cb_class = new Components.JoCombobox();
        joLable11 = new Components.JoLable();
        dt_dateStart = new Components.JoDateChooser();
        joLable12 = new Components.JoLable();
        dt_DateStop = new Components.JoDateChooser();
        joLable3 = new Components.JoLable();
        rd_Complete = new Component.JoRadioButton();
        rd_probation = new Component.JoRadioButton();
        rd_unemployed = new Component.JoRadioButton();
        joLable13 = new Components.JoLable();
        rd_Strong = new Component.JoRadioButton();
        rd_Weakness = new Component.JoRadioButton();
        joLable18 = new Components.JoLable();
        txt_talent = new Components.JoTextField();
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

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        joPanel1.setJoPrimaryColor(new java.awt.Color(249, 249, 249));
        joPanel1.setJoSecondaryColor(new java.awt.Color(249, 249, 249));

        joLable1.setText("ວັນເດືອນປີເກີດ");

        joLable2.setText("ເພດ");

        dt_dfb.setPlaceholder("ວັນເດືອນປີເກີດ");

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_AddImage.setJoIconColor(new java.awt.Color(153, 153, 153));
        lbl_AddImage.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CAMERA_ALT);
        jPanel6.add(lbl_AddImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 90, -1, -1));

        img_avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/tcicon.png"))); // NOI18N
        jPanel6.add(img_avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 11, 100, 100));

        joLable14.setText("ຊື່ຫຼີ້ນ");

        txt_nickName.setPlaceholder("ຊື່ຫຼີ້ນ");

        buttonGroup1.add(rd_male);
        rd_male.setSelected(true);
        rd_male.setText("ຊາຍ");

        buttonGroup1.add(rd_female);
        rd_female.setText("ຍິງ");

        joPanelTitle4.setJoTitle("ຂໍ້ມູນທີ່ກ່ຽວຂ້ອງ");
        joPanelTitle4.setOpaque(false);

        btn_History.setText("ປະຫວັດຫຍໍ້ / ປະສົບການ");
        btn_History.setEnabled(false);
        btn_History.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_History.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT);

        btn_Outstanding.setText("ຜົນງານພົ້ນເດັ່ນ");
        btn_Outstanding.setEnabled(false);
        btn_Outstanding.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Outstanding.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.BRIGHTNESS_AUTO);

        btn_Vaccine.setText("ຮັບວັກຊີນ");
        btn_Vaccine.setEnabled(false);
        btn_Vaccine.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Vaccine.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_HOSPITAL);

        javax.swing.GroupLayout joPanelTitle4Layout = new javax.swing.GroupLayout(joPanelTitle4);
        joPanelTitle4.setLayout(joPanelTitle4Layout);
        joPanelTitle4Layout.setHorizontalGroup(
            joPanelTitle4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Outstanding, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addComponent(btn_Vaccine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_History, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        joPanelTitle4Layout.setVerticalGroup(
            joPanelTitle4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btn_History, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Outstanding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Vaccine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout joPanel1Layout = new javax.swing.GroupLayout(joPanel1);
        joPanel1.setLayout(joPanel1Layout);
        joPanel1Layout.setHorizontalGroup(
            joPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, joPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(joPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(joPanelTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, joPanel1Layout.createSequentialGroup()
                        .addComponent(rd_male, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rd_female, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dt_dfb, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(joLable1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_nickName, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        joPanel1Layout.setVerticalGroup(
            joPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joLable14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_male, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_female, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dt_dfb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(joPanelTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        joPanel2.setJoPrimaryColor(new java.awt.Color(249, 249, 249));
        joPanel2.setJoSecondaryColor(new java.awt.Color(249, 249, 249));

        joPanelTitle1.setJoTitle("ຂໍ້ມູນພື້ນຖານ");
        joPanelTitle1.setOpaque(false);

        joLable4.setText("ເລກທີ່ພະນັກງານ");

        txt_teacherNo.setPlaceholder("ເລກທີ່ພະນັກງານ");

        joLable5.setText("ຊື່ ແລະ ນາມສະກຸນ");

        txt_name.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ");

        joLable6.setText("ຊື່ ແລະ ນາມສະກຸນ (ອັງກິດ)");

        txt_nameENG.setPlaceholder("ຊື່ ແລະ ນາມສະກຸນ (ອັງກິດ)");

        joLable7.setText("ເບີໂທລະສັບ");

        txt_tel.setPlaceholder("ເບີໂທລະສັບ");

        joLable8.setText("Email");

        txt_Email.setPlaceholder("Email");

        joLable9.setText("Facebook");

        txt_facebook.setPlaceholder("Facebook");

        javax.swing.GroupLayout joPanelTitle1Layout = new javax.swing.GroupLayout(joPanelTitle1);
        joPanelTitle1.setLayout(joPanelTitle1Layout);
        joPanelTitle1Layout.setHorizontalGroup(
            joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_teacherNo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable4, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nameENG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(joPanelTitle1Layout.createSequentialGroup()
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tel, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(joLable7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(joLable8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_facebook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addComponent(txt_teacherNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_facebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        joPanelTitle2.setJoTitle("ຂໍ້ມູນຄູ");
        joPanelTitle2.setOpaque(false);

        joLable10.setText("ຄູສອນຊັ້ນຮຽນ");

        joLable11.setText("ວັນທີ່ເລີ່ມເຮັດວຽກ");

        dt_dateStart.setPlaceholder("ວັນທີ່ເລີ່ມເຮັດວຽກ");

        joLable12.setText("ວັນທີ່ຍຸດເຮັດວຽກ");

        dt_DateStop.setPlaceholder("ວັນທີ່ເລີ່ມເຮັດວຽກ");

        joLable3.setText("ສະຖານະພະນັກງານ");

        buttonGroup2.add(rd_Complete);
        rd_Complete.setSelected(true);
        rd_Complete.setText("ສົມບູນ");
        rd_Complete.setMinimumSize(new java.awt.Dimension(65, 29));
        rd_Complete.setPreferredSize(new java.awt.Dimension(80, 40));

        buttonGroup2.add(rd_probation);
        rd_probation.setText("ທົດລອງວຽກ");
        rd_probation.setMinimumSize(new java.awt.Dimension(65, 29));
        rd_probation.setPreferredSize(new java.awt.Dimension(80, 40));

        buttonGroup2.add(rd_unemployed);
        rd_unemployed.setText("ອອກວຽກ");
        rd_unemployed.setMinimumSize(new java.awt.Dimension(65, 29));
        rd_unemployed.setPreferredSize(new java.awt.Dimension(80, 40));

        joLable13.setText("ສຸກຂະພາບ");

        buttonGroup3.add(rd_Strong);
        rd_Strong.setSelected(true);
        rd_Strong.setText("ແຂງແຮງ");
        rd_Strong.setMinimumSize(new java.awt.Dimension(65, 29));
        rd_Strong.setPreferredSize(new java.awt.Dimension(80, 40));

        buttonGroup3.add(rd_Weakness);
        rd_Weakness.setText("ອ່ອນເພຍ");
        rd_Weakness.setPreferredSize(new java.awt.Dimension(80, 40));

        joLable18.setText("ຄວາມສາມາດພິເສດ");

        txt_talent.setPlaceholder("ຄວາມສາມາດພິເສດ");

        javax.swing.GroupLayout joPanelTitle2Layout = new javax.swing.GroupLayout(joPanelTitle2);
        joPanelTitle2.setLayout(joPanelTitle2Layout);
        joPanelTitle2Layout.setHorizontalGroup(
            joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_class, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(joLable11, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(dt_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(joLable12, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(dt_DateStop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, joPanelTitle2Layout.createSequentialGroup()
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addComponent(rd_Complete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_probation, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_unemployed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(joLable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joLable13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                                .addComponent(rd_Strong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_Weakness, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(joLable18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_talent, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))))
                .addContainerGap())
        );
        joPanelTitle2Layout.setVerticalGroup(
            joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(joLable10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(joLable11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dt_DateStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_class, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joLable18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_Weakness, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_talent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_Strong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_unemployed, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_probation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_Complete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                    .addComponent(cb_nationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_religion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_ethnic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        btn_Save.setText("ບັນທຶກຂໍ້ມຸນອາຈານ");
        btn_Save.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_Save.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btn_Save.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanel7.add(btn_Save);

        btn_delete.setBackground(new java.awt.Color(255, 51, 51));
        btn_delete.setText("ລົບຂໍ້ມູນອາຈານ");
        btn_delete.setEnabled(false);
        btn_delete.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_delete.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.DELETE);
        btn_delete.setJocolorHover(new java.awt.Color(158, 30, 30));
        btn_delete.setPreferredSize(new java.awt.Dimension(200, 45));
        jPanel7.add(btn_delete);

        javax.swing.GroupLayout joPanel2Layout = new javax.swing.GroupLayout(joPanel2);
        joPanel2.setLayout(joPanel2Layout);
        joPanel2Layout.setHorizontalGroup(
            joPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, joPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(joPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(joPanelTitle1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joPanelTitle2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joPanelTitle3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        joPanel2Layout.setVerticalGroup(
            joPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joPanelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joPanelTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addComponent(joPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_History;
    private Components.JoButtonIconfont btn_Outstanding;
    private Components.JoButtonIconfont btn_Save;
    private Components.JoButtonIconfont btn_Vaccine;
    private Components.JoButtonIconfont btn_back;
    private Components.JoButtonIconfont btn_delete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private Components.JoCombobox cb_class;
    private Components.JoCombobox cb_ethnic;
    private Components.JoCombobox cb_nationality;
    private Components.JoCombobox cb_religion;
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
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable joLable7;
    private Components.JoLable joLable8;
    private Components.JoLable joLable9;
    private Components.JoPanel joPanel1;
    private Components.JoPanel joPanel2;
    private Component.JoPanelTitle joPanelTitle1;
    private Component.JoPanelTitle joPanelTitle2;
    private Component.JoPanelTitle joPanelTitle3;
    private Component.JoPanelTitle joPanelTitle4;
    private Components.JoLableIcon lbl_AddImage;
    private Components.JoLable lbl_title;
    private Component.JoRadioButton rd_Complete;
    private Component.JoRadioButton rd_Strong;
    private Component.JoRadioButton rd_Weakness;
    private Component.JoRadioButton rd_female;
    private Component.JoRadioButton rd_male;
    private Component.JoRadioButton rd_probation;
    private Component.JoRadioButton rd_unemployed;
    private Components.JoTextField txt_Email;
    private Components.JoTextField txt_facebook;
    private Components.JoTextField txt_name;
    private Components.JoTextField txt_nameENG;
    private Components.JoTextField txt_nickName;
    private Components.JoTextField txt_talent;
    private Components.JoTextField txt_teacherNo;
    private Components.JoTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
