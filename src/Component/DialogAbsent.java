package Component;

import Components.JoScrollBar;
import DAOSevervice.AbsentService;
import Model.AbsentModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoAlert;
import Utility.JoJson;
import View.AbsentDataView;
import java.awt.GridBagConstraints;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;

public class DialogAbsent extends javax.swing.JDialog {

    private List<StudentModel> studentList;
    private AbsentModel absentModel;
    private RegisterModel registerModel;
    private AbsentDataView view;
    private JoAlert alert = new JoAlert();
    private AbsentService service = new AbsentService();

    public DialogAbsent(java.awt.Frame parent, boolean modal, RegisterModel registerModel, List<StudentModel> studentList, AbsentModel absentModel, AbsentDataView view) {
        super(parent, modal);
        initComponents();
        this.registerModel = registerModel;
        this.studentList = studentList;
        this.absentModel = absentModel;
        this.view = view;
        dtDate.setDateData(new Date());
        showStudent();
        lblStudentCount.setText("ຈຳນວນທັງໝົດ: " + this.studentList.size() + " ຄົນ");
        JoScrollBar scrollBar = new JoScrollBar(jScrollPane1);
        scrollBar.setScrollSizeV(5);
        JoScrollBar scrollBarComment = new JoScrollBar(jScrollPane2);
        scrollBarComment.setScrollSizeV(5);
        if (absentModel.getAbsentID() > 0) {
            dtDate.setDateData(absentModel.getAbsentDate());
            JoJson json = new JoJson(absentModel.getAbsentData());
            for (int i = 0; i < pnAbsent.getComponentCount(); i++) {
                if (pnAbsent.getComponent(i) instanceof CheckStudent) {
                    CheckStudent checkStudent = (CheckStudent) pnAbsent.getComponent(i);
                    checkStudent.setAbsent(json.getInt(checkStudent.getKey()));
                }
            }
        }
    }

    private void showStudent() {
        txtComment.setText(absentModel.getComment());
        pnAbsent.removeAll();
        GridBagConstraints layout;
        for (int i = 0; i < studentList.size(); i++) {
            StudentModel model = studentList.get(i);
            layout = new java.awt.GridBagConstraints();
            CheckStudent checkStudent = new CheckStudent(i + 1, model);
            layout = new java.awt.GridBagConstraints();
            layout.gridx = 0;
            layout.gridy = i;
            layout.fill = java.awt.GridBagConstraints.HORIZONTAL;
            pnAbsent.add(checkStudent, layout);
        }
        JLabel lable = new JLabel();
        layout = new java.awt.GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = studentList.size();
        layout.fill = java.awt.GridBagConstraints.BOTH;
        layout.weightx = 0.1;
        layout.weighty = 0.1;
        pnAbsent.add(lable, layout);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnAbsent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new Components.JoButtonIconfont();
        jPanel2 = new javax.swing.JPanel();
        lblStudentCount = new Components.JoLable();
        dtDate = new Components.JoDateChooser();
        btnSelectAll = new Components.JoButtonIconfont();
        btnNotSelect = new Components.JoButtonIconfont();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComment = new Components.JoTextArea();
        joLable1 = new Components.JoLable();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(1366, 768));

        pnAbsent.setMaximumSize(new java.awt.Dimension(1366, 768));
        pnAbsent.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(pnAbsent);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        getContentPane().add(jPanel4, gridBagConstraints);

        jPanel1.setMaximumSize(new java.awt.Dimension(80, 60));
        jPanel1.setMinimumSize(new java.awt.Dimension(80, 220));
        jPanel1.setPreferredSize(new java.awt.Dimension(80, 220));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnSave.setText("ບັນທຶກການຂາດຮຽນ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel1.add(btnSave, gridBagConstraints);

        jPanel2.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblStudentCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStudentCount.setText("Result");
        lblStudentCount.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(lblStudentCount, gridBagConstraints);

        dtDate.setMaximumSize(new java.awt.Dimension(60, 40));
        dtDate.setMinimumSize(new java.awt.Dimension(100, 40));
        dtDate.setPreferredSize(new java.awt.Dimension(140, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 30);
        jPanel2.add(dtDate, gridBagConstraints);

        btnSelectAll.setBackground(new java.awt.Color(0, 153, 102));
        btnSelectAll.setText("ມາທັງໝົດ");
        btnSelectAll.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CHECK_CIRCLE);
        btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(btnSelectAll, gridBagConstraints);

        btnNotSelect.setBackground(new java.awt.Color(255, 153, 51));
        btnNotSelect.setText("ຂາດທັງໝົດ");
        btnNotSelect.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CHECK_BOX_OUTLINE_BLANK);
        btnNotSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotSelectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(btnNotSelect, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        jPanel1.add(jPanel2, gridBagConstraints);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(200, 60));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(150, 50));

        txtComment.setColumns(20);
        txtComment.setRows(4);
        txtComment.setMaximumSize(new java.awt.Dimension(200, 50));
        txtComment.setMinimumSize(new java.awt.Dimension(100, 80));
        jScrollPane2.setViewportView(txtComment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 41;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        joLable1.setText("ໝາຍເຫດ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(joLable1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        setSize(new java.awt.Dimension(653, 856));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HashMap<String, String> jsonModel = new HashMap<>();
        for (int i = 0; i < pnAbsent.getComponentCount(); i++) {
            if (pnAbsent.getComponent(i) instanceof CheckStudent) {
                CheckStudent checkStudent = (CheckStudent) pnAbsent.getComponent(i);
                jsonModel.put(checkStudent.getKey(), checkStudent.getValue());
            }
        }
        JoJson joJson = new JoJson(jsonModel);

        boolean state;
        int userID = GlobalDataModel.userModel.getUserID();

        if (absentModel.getAbsentID() == 0) {
            absentModel = new AbsentModel(0, registerModel.getRegisterID(), dtDate.getSQLDate(), joJson.getJsonString(), userID, txtComment.getText());
            state = alert.JoSubmit(service.create(absentModel), JoAlert.INSERT);
        } else {
            absentModel.setAbsentDate(dtDate.getSQLDate());
            absentModel.setAbsentData(joJson.getJsonString());
            absentModel.setUserID(userID);
            absentModel.setComment(txtComment.getText());
            state = alert.JoSubmit(service.update(absentModel), JoAlert.UPDATE);
        }

        if (state) {
            view.showAbsent(service.readByRegisterID(registerModel.getRegisterID()));
            this.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNotSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotSelectActionPerformed
        for (int i = 0; i < pnAbsent.getComponentCount(); i++) {
            if (pnAbsent.getComponent(i) instanceof CheckStudent) {
                CheckStudent checkStudent = (CheckStudent) pnAbsent.getComponent(i);
                checkStudent.setAbsent(2);
            }
        }
    }//GEN-LAST:event_btnNotSelectActionPerformed

    private void btnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllActionPerformed
        for (int i = 0; i < pnAbsent.getComponentCount(); i++) {
            if (pnAbsent.getComponent(i) instanceof CheckStudent) {
                CheckStudent checkStudent = (CheckStudent) pnAbsent.getComponent(i);
                checkStudent.setAbsent(0);
            }
        }
    }//GEN-LAST:event_btnSelectAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnNotSelect;
    private Components.JoButtonIconfont btnSave;
    private Components.JoButtonIconfont btnSelectAll;
    private Components.JoDateChooser dtDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Components.JoLable joLable1;
    private Components.JoLable lblStudentCount;
    private javax.swing.JPanel pnAbsent;
    private Components.JoTextArea txtComment;
    // End of variables declaration//GEN-END:variables
}
