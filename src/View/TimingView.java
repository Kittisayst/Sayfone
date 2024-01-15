package View;

import Components.JoButtonIconfont;
import DAOSevervice.TimingSevervice;
import Database.JoConnect;
import Model.GlobalDataModel;
import Model.TimingModel;
import Tools.JoAlert;
import java.sql.*;

public class TimingView extends javax.swing.JPanel {

    public TimingView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        setTime();
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
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
        jPanel1 = new javax.swing.JPanel();
        joPanel1 = new Components.JoPanel();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        btnsave = new Components.JoButtonIconfont();
        cbtimeStop = new Component.Timepicker();
        cbtimeStart = new Component.Timepicker();

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

        jPanel1.setLayout(new java.awt.GridBagLayout());

        joPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        joPanel1.setLayout(new java.awt.GridBagLayout());

        joLable1.setText("ເປີດຈ່າຍຄ່າຮຽນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanel1.add(joLable1, gridBagConstraints);

        joLable2.setText("ປິດຈ່າຍຄ່າຮຽນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        joPanel1.add(joLable2, gridBagConstraints);

        btnsave.setText("ບັນທຶກ");
        btnsave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 5, 0);
        joPanel1.add(btnsave, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        joPanel1.add(cbtimeStop, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        joPanel1.add(cbtimeStart, gridBagConstraints);

        jPanel1.add(joPanel1, new java.awt.GridBagConstraints());

        pn_Datatable.add(jPanel1, java.awt.BorderLayout.CENTER);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        TimingSevervice severvice = new TimingSevervice();
        int state = severvice.UpdateTime(1, cbtimeStart.getTime(), cbtimeStop.getTime());
        JoAlert alert = new JoAlert();
        alert.JoSubmit(state, JoAlert.UPDATE);
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        GlobalDataModel.rootView.showDashbord();
    }//GEN-LAST:event_btn_backActionPerformed

    private void setTime() {
        try {
            TimingSevervice severvice = new TimingSevervice();
            TimingModel modelStart = severvice.getTimingStart();
            TimingModel modelStop = severvice.getTimingStop();
            cbtimeStart.setHour(modelStart.getHour());
            cbtimeStart.setMinute(modelStart.getMinute());
            cbtimeStart.setSecond(modelStart.getSecond());
            //stop
            cbtimeStop.setHour(modelStop.getHour());
            cbtimeStop.setMinute(modelStop.getMinute());
            cbtimeStop.setSecond(modelStop.getSecond());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_back;
    private Components.JoButtonIconfont btnsave;
    private Component.Timepicker cbtimeStart;
    private Component.Timepicker cbtimeStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoPanel joPanel1;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    // End of variables declaration//GEN-END:variables
}
