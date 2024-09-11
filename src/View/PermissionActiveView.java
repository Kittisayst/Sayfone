package View;

import Component.PermissionThemeDialog;
import Components.JoCheckBox;
import DAOSevervice.PermissionService;
import Database.JoProperties;
import Model.GlobalDataModel;
import Model.PermissionModel;
import Model.UserModel;
import Utility.JoJson;

public class PermissionActiveView extends javax.swing.JPanel {

    private UserModel userModel;
    private PermissionView view;
    private PermissionService service = new PermissionService();
    private JoProperties property = new JoProperties("/Info/permission.properties");
    private JoJson json = new JoJson();

    public PermissionActiveView(String Title, PermissionView view, UserModel userModel) {
        initComponents();
        lbl_title.setText(Title);
        this.view = view;
        this.userModel = userModel;
        showThemeName();
        lblPermission.setText("ກຳນົດສິດທີການໃຊ້ງານ ( " + userModel.getFullName() + " )");
        for (int i = 0; i < pnLayout.getComponentCount(); i++) {
            if (pnLayout.getComponent(i) instanceof JoCheckBox) {
                JoCheckBox checkBox = (JoCheckBox) pnLayout.getComponent(i);
                int type = Integer.parseInt(checkBox.getName());
                PermissionModel model = service.getRole(userModel.getUserID(), type);
                checkBox.setSelected(model.isState());
                checkBox.addActionListener(e -> {
                    Save(model, checkBox);
                });
            }
        }
    }

    private void Save(PermissionModel model, JoCheckBox checkbox) {
        if (model.getPermissionID() == 0) {
            service.create(new PermissionModel(0, userModel.getUserID(), Integer.parseInt(checkbox.getName()), true));
        } else {
            model.setState(checkbox.isSelected());
            service.update(model);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        pn_Datatable = new javax.swing.JPanel();
        pnLayout = new javax.swing.JPanel();
        joCheckBox1 = new Components.JoCheckBox();
        joCheckBox3 = new Components.JoCheckBox();
        joCheckBox4 = new Components.JoCheckBox();
        joCheckBox5 = new Components.JoCheckBox();
        joCheckBox6 = new Components.JoCheckBox();
        joCheckBox7 = new Components.JoCheckBox();
        joCheckBox8 = new Components.JoCheckBox();
        joCheckBox9 = new Components.JoCheckBox();
        joCheckBox10 = new Components.JoCheckBox();
        joCheckBox11 = new Components.JoCheckBox();
        joCheckBox12 = new Components.JoCheckBox();
        joCheckBox2 = new Components.JoCheckBox();
        joCheckBox13 = new Components.JoCheckBox();
        joCheckBox15 = new Components.JoCheckBox();
        joCheckBox14 = new Components.JoCheckBox();
        joCheckBox16 = new Components.JoCheckBox();
        joCheckBox18 = new Components.JoCheckBox();
        joCheckBox17 = new Components.JoCheckBox();
        joCheckBox19 = new Components.JoCheckBox();
        joCheckBox20 = new Components.JoCheckBox();
        joCheckBox21 = new Components.JoCheckBox();
        joCheckBox22 = new Components.JoCheckBox();
        lblPermission = new Components.JoLable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSelectAll = new Components.JoButtonIconfont();
        cbName = new Components.JoCombobox();
        btnCreate = new Components.JoButtonIconfont();
        joLable1 = new Components.JoLable();
        btnUse = new Components.JoButtonIconfont();
        joCheckBox23 = new Components.JoCheckBox();
        joCheckBox24 = new Components.JoCheckBox();
        joCheckBox25 = new Components.JoCheckBox();
        joCheckBox26 = new Components.JoCheckBox();
        joCheckBox27 = new Components.JoCheckBox();
        joCheckBox28 = new Components.JoCheckBox();
        joCheckBox29 = new Components.JoCheckBox();
        joCheckBox30 = new Components.JoCheckBox();
        joCheckBox31 = new Components.JoCheckBox();
        joCheckBox32 = new Components.JoCheckBox();
        joCheckBox33 = new Components.JoCheckBox();
        joCheckBox34 = new Components.JoCheckBox();
        joCheckBox35 = new Components.JoCheckBox();
        joCheckBox36 = new Components.JoCheckBox();

        Pn_Navigation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Pn_Navigation.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btn_back.setText("ກັບຄືນ");
        btn_back.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ARROW_BACK);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel3.add(btn_back);

        Pn_Navigation.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        lbl_title.setText("Title");
        lbl_title.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel4.add(lbl_title);

        Pn_Navigation.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        Pn_Navigation.add(jPanel5);

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        pnLayout.setMaximumSize(new java.awt.Dimension(500, 500));
        pnLayout.setLayout(new java.awt.GridBagLayout());

        joCheckBox1.setText("ຈັດການຂໍ້ມູນຄູ");
        joCheckBox1.setName("1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox1, gridBagConstraints);

        joCheckBox3.setText("ຈັດການຂໍ້ມູນນັກຮຽນ");
        joCheckBox3.setName("2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox3, gridBagConstraints);

        joCheckBox4.setText("ຈັດການວິຊາ-ຄຸສອນ");
        joCheckBox4.setName("4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox4, gridBagConstraints);

        joCheckBox5.setText("ຈັດການລາຍວິຊາ");
        joCheckBox5.setName("3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox5, gridBagConstraints);

        joCheckBox6.setText("ຂໍ້ມູນຂະແໜງ");
        joCheckBox6.setName("5"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox6, gridBagConstraints);

        joCheckBox7.setText("ຈັດການຂໍ້ມູນຜູ້ໃຊ້ງານ");
        joCheckBox7.setName("6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox7, gridBagConstraints);

        joCheckBox8.setText("ເປີດການລົງທະບຽນຮຽນ");
        joCheckBox8.setName("8"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox8, gridBagConstraints);

        joCheckBox9.setText("ຈັດການຂໍ້ມູນສິດທິ");
        joCheckBox9.setName("7"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox9, gridBagConstraints);

        joCheckBox10.setText("ຈ່າຍຄ່າຮຽນ");
        joCheckBox10.setName("9"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox10, gridBagConstraints);

        joCheckBox11.setText("ຈັດອັນດັບຄູ");
        joCheckBox11.setName("10"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox11, gridBagConstraints);

        joCheckBox12.setText("ບັນທຶກການຂາດຮຽນ");
        joCheckBox12.setName("11"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox12, gridBagConstraints);

        joCheckBox2.setText("ລາຍງານການຈ່າຍຄ່າຮຽນ");
        joCheckBox2.setName("12"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox2, gridBagConstraints);

        joCheckBox13.setText("ລາຍງານການຈ່າຍຄ່າຮຽນຕາມຜູ້ໃຊ່ງານ");
        joCheckBox13.setName("13"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox13, gridBagConstraints);

        joCheckBox15.setText("ລາຍງານຜູ້ຄ້າງຄ່າຮຽນ");
        joCheckBox15.setName("14"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox15, gridBagConstraints);

        joCheckBox14.setText("ລາຍງານຄ່າອາຫານ");
        joCheckBox14.setName("15"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox14, gridBagConstraints);

        joCheckBox16.setText("ລາຍງານສ່ວນຫຼຸດ");
        joCheckBox16.setName("16"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox16, gridBagConstraints);

        joCheckBox18.setText("ລາຍງານການຖອນເງິນຄືນ");
        joCheckBox18.setName("17"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox18, gridBagConstraints);

        joCheckBox17.setText("ລາຍງານສະຖິຕິຄູ");
        joCheckBox17.setName("18"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox17, gridBagConstraints);

        joCheckBox19.setText("ຂໍ້ມູນໂຮງຮຽນສາຍຝົນ");
        joCheckBox19.setName("20"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox19, gridBagConstraints);

        joCheckBox20.setText("ລາຍງານຂໍ້ມູນນັກຮຽນ");
        joCheckBox20.setName("19"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox20, gridBagConstraints);

        joCheckBox21.setText("ຂໍ້ມູນປີ້ນເຕີ");
        joCheckBox21.setName("21"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox21, gridBagConstraints);

        joCheckBox22.setText("ເວລາເປີດປິດການຈ່າຍເງິນ");
        joCheckBox22.setName("25"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox22, gridBagConstraints);

        lblPermission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPermission.setText("ກຳນົດສິດທີການໃຊ້ງານ");
        lblPermission.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        pnLayout.add(lblPermission, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        pnLayout.add(jLabel1, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnSelectAll.setText("ເລືອກທັງໝົດ");
        btnSelectAll.setJoIconSize(25);
        btnSelectAll.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.DONE_ALL);
        btnSelectAll.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 7, 0);
        jPanel1.add(btnSelectAll, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel1.add(cbName, gridBagConstraints);

        btnCreate.setBackground(new java.awt.Color(204, 102, 0));
        btnCreate.setText("ສຳເນົາຮູບແບບສິດທິ");
        btnCreate.setJoIconSize(25);
        btnCreate.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CONTENT_COPY);
        btnCreate.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 50, 7, 5);
        jPanel1.add(btnCreate, gridBagConstraints);

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable1.setText("ຮູບແບບສິດທິ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 10);
        jPanel1.add(joLable1, gridBagConstraints);

        btnUse.setBackground(new java.awt.Color(0, 153, 153));
        btnUse.setText("ນຳໃຊ້");
        btnUse.setJoIconSize(25);
        btnUse.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.VERIFIED_USER);
        btnUse.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 10, 7, 0);
        jPanel1.add(btnUse, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 30, 0);
        pnLayout.add(jPanel1, gridBagConstraints);

        joCheckBox23.setText("ຜູ້ອານຸມັດ");
        joCheckBox23.setName("22"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox23, gridBagConstraints);

        joCheckBox24.setText("ລາຍງານການເງິນຄູ");
        joCheckBox24.setName("23"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox24, gridBagConstraints);

        joCheckBox25.setText("ສຳຮອງຂໍ້ມູນ");
        joCheckBox25.setName("24"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox25, gridBagConstraints);

        joCheckBox26.setText("ຈັດການຂໍ້ມູນຮູ້ຈັກໂຮງຮຽນ");
        joCheckBox26.setName("26"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox26, gridBagConstraints);

        joCheckBox27.setText("ລາຍງານຂໍ້ມູນຮູ້ຈັກໂຮງຮຽນ");
        joCheckBox27.setName("27"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox27, gridBagConstraints);

        joCheckBox28.setText("ຈັດການຂໍ້ມູນອາຊີບຜູ້ປົກຄອງ");
        joCheckBox28.setName("28"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox28, gridBagConstraints);

        joCheckBox29.setText("ລາຍງານຂໍ້ມູນອາຊີບຜູ້ປົກຄອງ");
        joCheckBox29.setName("29"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox29, gridBagConstraints);

        joCheckBox30.setText("ລາຍງານທີ່ຢູ່ນັກຮຽນ");
        joCheckBox30.setName("30"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox30, gridBagConstraints);

        joCheckBox31.setText("ເອກະສານໂຮງຮຽນ");
        joCheckBox31.setName("31"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox31, gridBagConstraints);

        joCheckBox32.setText("ຕັ້ງຄ່າການຈ່າຍຄ່າຮຽນ");
        joCheckBox32.setName("32"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox32, gridBagConstraints);

        joCheckBox33.setText("ລາຍງານຈ່າຍຄ່າຮຽນປະຈຳເດືອນ");
        joCheckBox33.setName("33"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox33, gridBagConstraints);

        joCheckBox34.setText("ລາຍງານຈ່າຍຄ່າຮຽນຕາມຫ້ອງຮຽນ");
        joCheckBox34.setName("34"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox34, gridBagConstraints);

        joCheckBox35.setText("ລາຍງານຜູ້ຄ້າງຄ່າອາຫານ");
        joCheckBox35.setName("35"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        pnLayout.add(joCheckBox35, gridBagConstraints);

        joCheckBox36.setText("ລາຍງານຂໍ້ມູນນັກຮຽນທັງໝົດ");
        joCheckBox36.setName("36"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox36, gridBagConstraints);

        pn_Datatable.add(pnLayout, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        GlobalDataModel.rootView.setView(view);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllActionPerformed
        for (int i = 0; i < pnLayout.getComponentCount(); i++) {
            if (pnLayout.getComponent(i) instanceof JoCheckBox) {
                JoCheckBox checkBox = (JoCheckBox) pnLayout.getComponent(i);
                int type = Integer.parseInt(checkBox.getName());
                PermissionModel model = service.getRole(userModel.getUserID(), type);
                checkBox.setSelected(model.isState());
                checkBox.setSelected(!checkBox.isSelected());
                Save(model, checkBox);
            }
        }
    }//GEN-LAST:event_btnSelectAllActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        for (int i = 0; i < pnLayout.getComponentCount(); i++) {
            if (pnLayout.getComponent(i) instanceof JoCheckBox) {
                JoCheckBox checkBox = (JoCheckBox) pnLayout.getComponent(i);
                json.setValue(checkBox.getName(), checkBox.isSelected() ? "1" : "0");
            }
        }
        PermissionThemeDialog themeDialog = new PermissionThemeDialog(GlobalDataModel.rootView, true, json.getJsonString(), this);
        themeDialog.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseActionPerformed
        JoJson joJson = new JoJson(property.getValueAt(cbName.getValue()));
        for (int i = 0; i < pnLayout.getComponentCount(); i++) {
            if (pnLayout.getComponent(i) instanceof JoCheckBox) {
                JoCheckBox checkBox = (JoCheckBox) pnLayout.getComponent(i);
                 boolean state = joJson.getInt(checkBox.getName()) == 1;
                 checkBox.setSelected(state);
            }
        }
    }//GEN-LAST:event_btnUseActionPerformed

    public void showThemeName() {
        int i = 0;
        for (String key : property.get().stringPropertyNames()) {
            cbName.JoAddIntModel(i, key);
            i++;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnCreate;
    private Components.JoButtonIconfont btnSelectAll;
    private Components.JoButtonIconfont btnUse;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private Components.JoCheckBox joCheckBox1;
    private Components.JoCheckBox joCheckBox10;
    private Components.JoCheckBox joCheckBox11;
    private Components.JoCheckBox joCheckBox12;
    private Components.JoCheckBox joCheckBox13;
    private Components.JoCheckBox joCheckBox14;
    private Components.JoCheckBox joCheckBox15;
    private Components.JoCheckBox joCheckBox16;
    private Components.JoCheckBox joCheckBox17;
    private Components.JoCheckBox joCheckBox18;
    private Components.JoCheckBox joCheckBox19;
    private Components.JoCheckBox joCheckBox2;
    private Components.JoCheckBox joCheckBox20;
    private Components.JoCheckBox joCheckBox21;
    private Components.JoCheckBox joCheckBox22;
    private Components.JoCheckBox joCheckBox23;
    private Components.JoCheckBox joCheckBox24;
    private Components.JoCheckBox joCheckBox25;
    private Components.JoCheckBox joCheckBox26;
    private Components.JoCheckBox joCheckBox27;
    private Components.JoCheckBox joCheckBox28;
    private Components.JoCheckBox joCheckBox29;
    private Components.JoCheckBox joCheckBox3;
    private Components.JoCheckBox joCheckBox30;
    private Components.JoCheckBox joCheckBox31;
    private Components.JoCheckBox joCheckBox32;
    private Components.JoCheckBox joCheckBox33;
    private Components.JoCheckBox joCheckBox34;
    private Components.JoCheckBox joCheckBox35;
    private Components.JoCheckBox joCheckBox36;
    private Components.JoCheckBox joCheckBox4;
    private Components.JoCheckBox joCheckBox5;
    private Components.JoCheckBox joCheckBox6;
    private Components.JoCheckBox joCheckBox7;
    private Components.JoCheckBox joCheckBox8;
    private Components.JoCheckBox joCheckBox9;
    private Components.JoLable joLable1;
    private Components.JoLable lblPermission;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pnLayout;
    private javax.swing.JPanel pn_Datatable;
    // End of variables declaration//GEN-END:variables
}
