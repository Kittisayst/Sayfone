package View;

import Components.JoCheckBox;
import DAOSevervice.PermissionService;
import Model.GlobalDataModel;
import Model.PermissionModel;
import Model.UserModel;

public class PermissionActiveView extends javax.swing.JPanel {

    private UserModel userModel;
    private PermissionView view;
    private PermissionService service = new PermissionService();

    public PermissionActiveView(String Title, PermissionView view, UserModel userModel) {
        initComponents();
        lbl_title.setText(Title);
        this.view = view;
        this.userModel = userModel;
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
        lblPermission = new Components.JoLable();
        jLabel1 = new javax.swing.JLabel();

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

        joCheckBox1.setText("ຈັດການຂໍ້ມູນອາຈານ");
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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox4, gridBagConstraints);

        joCheckBox5.setText("ຈັດການລາຍວິຊາ");
        joCheckBox5.setName("3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox5, gridBagConstraints);

        joCheckBox6.setText("ຂໍ້ມູນຂະແໜງ");
        joCheckBox6.setName("5"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox6, gridBagConstraints);

        joCheckBox7.setText("ຈັດການຂໍ້ມູນຜູ້ໃຊ້ງານ");
        joCheckBox7.setName("6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox7, gridBagConstraints);

        joCheckBox8.setText("ເປີດການລົງທະບຽນຮຽນ");
        joCheckBox8.setName("8"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox8, gridBagConstraints);

        joCheckBox9.setText("ຈັດການຂໍ້ມູນສິດທິ");
        joCheckBox9.setName("7"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox9, gridBagConstraints);

        joCheckBox10.setText("ຈ່າຍຄ່າຮຽນ");
        joCheckBox10.setName("9"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox10, gridBagConstraints);

        joCheckBox11.setText("ຈັດອັນດັບຄູ");
        joCheckBox11.setName("10"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox11, gridBagConstraints);

        joCheckBox12.setText("ບັນທຶກການຂາດຮຽນ");
        joCheckBox12.setName("11"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnLayout.add(joCheckBox12, gridBagConstraints);

        joCheckBox2.setText("ລາຍງານການຈ່າຍຄ່າຮຽນ");
        joCheckBox2.setName("12"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox2, gridBagConstraints);

        joCheckBox13.setText("ລາຍງານການຈ່າຍຄ່າຮຽນຕາມຜູ້ໃຊ່ງານ");
        joCheckBox13.setName("13"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox13, gridBagConstraints);

        joCheckBox15.setText("ລາຍງານຜູ້ຄ້າງຄ່າຮຽນ");
        joCheckBox15.setName("14"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox15, gridBagConstraints);

        joCheckBox14.setText("ລາຍງານຄ່າອາຫານ");
        joCheckBox14.setName("15"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox14, gridBagConstraints);

        joCheckBox16.setText("ລາຍງານສ່ວນຫຼຸດ");
        joCheckBox16.setName("16"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox16, gridBagConstraints);

        joCheckBox18.setText("ລາຍງານການຖອນເງິນຄືນ");
        joCheckBox18.setName("17"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox18, gridBagConstraints);

        joCheckBox17.setText("ລາຍງານສະຖິຕິຄູ");
        joCheckBox17.setName("18"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox17, gridBagConstraints);

        joCheckBox19.setText("ຂໍ້ມູນໂຮງຮຽນສາຍຝົນ");
        joCheckBox19.setName("20"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox19, gridBagConstraints);

        joCheckBox20.setText("ລາຍງານຂໍ້ມູນນັກຮຽນ");
        joCheckBox20.setName("19"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox20, gridBagConstraints);

        joCheckBox21.setText("ຂໍ້ມູນປີ້ນເຕີ");
        joCheckBox21.setName("21"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 5, 0);
        pnLayout.add(joCheckBox21, gridBagConstraints);

        lblPermission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPermission.setText("ກຳນົດສິດທີການໃຊ້ງານ");
        lblPermission.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 30, 0);
        pnLayout.add(lblPermission, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        pnLayout.add(jLabel1, gridBagConstraints);

        pn_Datatable.add(pnLayout, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        GlobalDataModel.rootView.setView(view);
    }//GEN-LAST:event_btn_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JLabel jLabel1;
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
    private Components.JoCheckBox joCheckBox3;
    private Components.JoCheckBox joCheckBox4;
    private Components.JoCheckBox joCheckBox5;
    private Components.JoCheckBox joCheckBox6;
    private Components.JoCheckBox joCheckBox7;
    private Components.JoCheckBox joCheckBox8;
    private Components.JoCheckBox joCheckBox9;
    private Components.JoLable lblPermission;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pnLayout;
    private javax.swing.JPanel pn_Datatable;
    // End of variables declaration//GEN-END:variables
}
