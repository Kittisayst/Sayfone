package View;

import Components.JoButtonIconfont;
import Components.JoTable;

public class YearRegisterView extends javax.swing.JPanel {

    public YearRegisterView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }
    
    

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtn_Add() {
        return btn_add;
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
        btn_add = new Components.JoButtonIconfont();
        pn_Datatable = new javax.swing.JPanel();
        joPanel1 = new Components.JoPanel();
        joTextField1 = new Components.JoTextField();
        joLable1 = new Components.JoLable();

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

        btn_add.setText("ເພີ່ມຂໍ້ມູນ");
        btn_add.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ADD_CIRCLE);
        jPanel5.add(btn_add);

        Pn_Navigation.add(jPanel5);

        pn_Datatable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        joPanel1.setBackground(new java.awt.Color(204, 204, 204));
        joPanel1.setJoPrimaryColor(new java.awt.Color(204, 204, 204));
        joPanel1.setJoSecondaryColor(new java.awt.Color(204, 204, 204));
        joPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        joPanel1.add(joTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 315, -1));

        joLable1.setText("joLable1");
        joPanel1.add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 310, 30));

        pn_Datatable.add(joPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 460, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_add;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private Components.JoLable joLable1;
    private Components.JoPanel joPanel1;
    private Components.JoTextField joTextField1;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    // End of variables declaration//GEN-END:variables
}
