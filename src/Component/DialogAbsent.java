package Component;

import Components.JoLable;
import Components.JoScrollBar;
import DAOSevervice.AbsentService;
import Model.AbsentModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoAlert;
import Utility.JoJson;
import View.AbsentDataView;
import java.awt.Dimension;
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
        lblStudentCount = new Components.JoLable();
        dtDate = new Components.JoDateChooser();
        btnSave = new Components.JoButtonIconfont();

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
        jPanel1.setMinimumSize(new java.awt.Dimension(80, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(80, 60));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        lblStudentCount.setText("Result");
        lblStudentCount.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        jPanel1.add(lblStudentCount);

        dtDate.setPreferredSize(new java.awt.Dimension(140, 40));
        jPanel1.add(dtDate);

        btnSave.setText("ບັນທຶກການຂາດຮຽນ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        setSize(new java.awt.Dimension(528, 658));
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
        int userID = GlobalDataModel.globalUsermodel.getUserID();

        if (absentModel.getAbsentID() == 0) {
            absentModel = new AbsentModel(0, registerModel.getRegisterID(), dtDate.getSQLDate(), joJson.getJsonString(), userID);
            state = alert.JoSubmit(service.create(absentModel), JoAlert.INSERT);
        } else {
            System.out.println(absentModel.getAbsentID());
            absentModel.setAbsentDate(dtDate.getSQLDate());
            absentModel.setAbsentData(joJson.getJsonString());
            absentModel.setUserID(userID);
            state = alert.JoSubmit(service.update(absentModel), JoAlert.UPDATE);
        }

        if (state) {
            view.showAbsent(service.readByRegisterID(registerModel.getRegisterID()));
            this.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnSave;
    private Components.JoDateChooser dtDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable lblStudentCount;
    private javax.swing.JPanel pnAbsent;
    // End of variables declaration//GEN-END:variables
}
