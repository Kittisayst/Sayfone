package Component;

import App.AppStudentHistory;
import DAOSevervice.BroderSisterService;
import DAOSevervice.StudentService;
import Model.BrotherAndSisterModel;
import Model.StudentModel;
import Tools.JoDataTable;
import javax.swing.JList;

public class DialogBrotherAndSister extends javax.swing.JDialog {

    private final int StudentID;
    JList<StudentModel> studentList;

    public DialogBrotherAndSister(java.awt.Frame parent, boolean modal, int StudentID) {
        super(parent, modal);
        this.StudentID = StudentID;
        initComponents();
        StudentService service = new StudentService();
        service.getStudentBrotherSister(StudentID).forEach(data -> {
            tbStudent.AddJoModel(new Object[]{tbStudent.autoNumber(), data.getStudentID(), data.getStudentNo(), data.getFullName()});
        });
        JoDataTable dataTable = new JoDataTable(pnDatatable);
        dataTable.showDataTableAll();
        dataTable.setHiddenColumns(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnDatatable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudent = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new Components.JoButtonIconfont();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnDatatable.setLayout(new java.awt.BorderLayout());

        tbStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "StudentID", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbStudent);

        pnDatatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnSave.setText("ເລືອກອ້າຍນ້ອງ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatatable, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnDatatable, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(603, 377));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (tbStudent.getSelectedRow() > -1) {
            BroderSisterService service = new BroderSisterService();
            int BSID = tbStudent.getIntValue(1);
            service.CreaterBrotherAndSister(new BrotherAndSisterModel(0, StudentID, BSID));
            AppStudentHistory appStudentHistory = new AppStudentHistory(StudentID, 2);
            this.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnDatatable;
    private Components.JoTable tbStudent;
    // End of variables declaration//GEN-END:variables
}
