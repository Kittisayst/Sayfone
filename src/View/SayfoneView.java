package View;

import Components.JoButtonIconfont;
import Model.SayfoneModel;

public class SayfoneView extends javax.swing.JPanel {

    public SayfoneView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public void showSetting(SayfoneModel model) {
        txtSchool.setText(model.getSchool());
        txtEnglist.setText(model.getEnglish());
        txtContact.setText(model.getContact());
        txtDetail.setText(model.getDetail());
    }

    public JoButtonIconfont getBtnCancel() {
        return btnCancel;
    }

    public JoButtonIconfont getBtnSave() {
        return btnSave;
    }

    public boolean isEmpty() {
        return txtSchool.TextEmpty() && txtEnglist.TextEmpty() && txtContact.TextEmpty() && txtDetail.TextEmpty();
    }

    public SayfoneModel getSayfone() {
        return new SayfoneModel(0, txtSchool.getText(), txtEnglist.getText(), txtContact.getText(), txtDetail.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        pn_Datatable = new javax.swing.JPanel();
        joPanel1 = new Components.JoPanel();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContact = new Components.JoTextArea();
        joLable3 = new Components.JoLable();
        joLable4 = new Components.JoLable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetail = new Components.JoTextArea();
        btnCancel = new Components.JoButtonIconfont();
        btnSave = new Components.JoButtonIconfont();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSchool = new Components.JoTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtEnglist = new Components.JoTextArea();

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

        joPanel1.setJoPrimaryColor(new java.awt.Color(248, 248, 248));
        joPanel1.setJoSecondaryColor(new java.awt.Color(248, 248, 248));
        joPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        joLable1.setText("ຊື່ໂຮງຮຽນ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        joPanel1.add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 460, 30));

        joLable2.setText("ຂໍ້ມູນການຕິດຕໍ່");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        joPanel1.add(joLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 460, 40));

        txtContact.setColumns(20);
        txtContact.setRows(2);
        jScrollPane1.setViewportView(txtContact);

        joPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 460, 90));

        joLable3.setText("ຊື່ໂຮງຮຽນພາສາອັງກິດ");
        joLable3.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        joPanel1.add(joLable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 460, 30));

        joLable4.setText("ໝາຍເຫດ");
        joLable4.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        joPanel1.add(joLable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 460, 30));

        txtDetail.setColumns(20);
        txtDetail.setRows(2);
        jScrollPane2.setViewportView(txtDetail);

        joPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 460, 90));

        btnCancel.setBackground(new java.awt.Color(255, 0, 51));
        btnCancel.setText("ຍົກເລີກ");
        btnCancel.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CANCEL);
        joPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 501, 210, 50));

        btnSave.setText("ບັນທຶກ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        joPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 501, 200, 50));

        txtSchool.setColumns(20);
        txtSchool.setRows(2);
        jScrollPane3.setViewportView(txtSchool);

        joPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 450, 70));

        txtEnglist.setColumns(20);
        txtEnglist.setRows(2);
        jScrollPane4.setViewportView(txtEnglist);

        joPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 450, 70));

        javax.swing.GroupLayout pn_DatatableLayout = new javax.swing.GroupLayout(pn_Datatable);
        pn_Datatable.setLayout(pn_DatatableLayout);
        pn_DatatableLayout.setHorizontalGroup(
            pn_DatatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DatatableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(joPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_DatatableLayout.setVerticalGroup(
            pn_DatatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DatatableLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(joPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnCancel;
    private Components.JoButtonIconfont btnSave;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoPanel joPanel1;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTextArea txtContact;
    private Components.JoTextArea txtDetail;
    private Components.JoTextArea txtEnglist;
    private Components.JoTextArea txtSchool;
    // End of variables declaration//GEN-END:variables

}
