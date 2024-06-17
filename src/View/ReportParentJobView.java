package View;

import Chart.PieChartUI;
import Components.JoButtonIconfont;
import Components.JoTabbed;
import java.awt.BorderLayout;
import java.awt.Color;

public class ReportParentJobView extends javax.swing.JPanel {

    private boolean switchParent1 = false;
    private boolean switchParent2 = false;

    public ReportParentJobView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void updateStateSwitchParent1() {
        switchParent1 = !switchParent1;
        if (switchParent1) {
            btnPiechart1.setBackground(Color.red);
            btnBarchart1.setBackground(new Color(25, 118, 210));
        } else {
            btnBarchart1.setBackground(Color.red);
            btnPiechart1.setBackground(new Color(25, 118, 210));
        }
    }

    public void updateStateSwitchParent2() {
        switchParent2 = !switchParent2;
        if (switchParent2) {
            btnPiechart2.setBackground(Color.red);
            btnBarchart2.setBackground(new Color(25, 118, 210));
        } else {
            btnBarchart2.setBackground(Color.red);
            btnPiechart2.setBackground(new Color(25, 118, 210));
        }
    }

    public void setPiechartParent1(PieChartUI pieChartUI) {
        pnParent1.removeAll();
        pnParent1.add(pieChartUI, BorderLayout.CENTER);
    }

    public void setPiechartParent2(PieChartUI pieChartUI) {
        pnParent2.removeAll();
        pnParent2.add(pieChartUI, BorderLayout.CENTER);
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtnBarchart1() {
        return btnBarchart1;
    }

    public JoButtonIconfont getBtnBarchart2() {
        return btnBarchart2;
    }

    public JoButtonIconfont getBtnPiechart1() {
        return btnPiechart1;
    }

    public JoButtonIconfont getBtnPiechart2() {
        return btnPiechart2;
    }

    public JoTabbed getTabab() {
        return Tabab;
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Tabab = new Components.JoTabbed();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnPiechart1 = new Components.JoButtonIconfont();
        btnBarchart1 = new Components.JoButtonIconfont();
        pnParent1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnPiechart2 = new Components.JoButtonIconfont();
        btnBarchart2 = new Components.JoButtonIconfont();
        pnParent2 = new javax.swing.JPanel();

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

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        Tabab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        btnPiechart1.setText("Pie Chart");
        jPanel9.add(btnPiechart1);

        btnBarchart1.setText("Bar Chart");
        jPanel9.add(btnBarchart1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel6.add(jPanel9, gridBagConstraints);

        pnParent1.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(pnParent1, gridBagConstraints);

        Tabab.addTab("ຜູ້ປົກຄອງ 1", jPanel6);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        btnPiechart2.setText("Pie Chart");
        jPanel10.add(btnPiechart2);

        btnBarchart2.setText("Bar Chart");
        jPanel10.add(btnBarchart2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jPanel7.add(jPanel10, gridBagConstraints);

        pnParent2.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(pnParent2, gridBagConstraints);

        Tabab.addTab("ຜູ້ປົກຄອງ 2", jPanel7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(Tabab, gridBagConstraints);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoTabbed Tabab;
    private Components.JoButtonIconfont btnBarchart1;
    private Components.JoButtonIconfont btnBarchart2;
    private Components.JoButtonIconfont btnPiechart1;
    private Components.JoButtonIconfont btnPiechart2;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pnParent1;
    private javax.swing.JPanel pnParent2;
    // End of variables declaration//GEN-END:variables
}
