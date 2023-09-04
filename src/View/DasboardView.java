package View;

import Component.JoDashboardItem;
import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import Components.JoTextField;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.RegisterModel;
import Model.StudentModel;
import java.util.List;

public class DasboardView extends javax.swing.JPanel {

    public DasboardView() {
        initComponents();
    }

    public void ShowStudentCount(int Count) {
        ds_Student.setItemTitle("" + Count);
    }

    public void ShowTeacherCount(int Count) {
        ds_Teacher.setItemTitle("" + Count);
    }

    public void showFinalcailCount(int countFinancial) {
        ds_Financail.setItemTitle("" + countFinancial);
    }

    public void showRegisterCount(int countRegister) {
        ds_ClassRoom.setItemTitle("" + countRegister);
    }

    public JoDashboardItem getDs_Student() {
        return ds_Student;
    }

    public JoDashboardItem getDs_Teacher() {
        return ds_Teacher;
    }

    public JoDashboardItem getDs_ClassRoom() {
        return ds_ClassRoom;
    }

    public JoDashboardItem getDs_Financail() {
        return ds_Financail;
    }

    public JoButtonIconfont getBtnSearch() {
        return btnSearch;
    }

    public JoCombobox getCbClass() {
        return cbClass;
    }

    public JoTable getTbData() {
        return tbData;
    }

    public JoTextField getTxtSearch() {
        return txtSearch;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ds_Student = new Component.JoDashboardItem();
        ds_Teacher = new Component.JoDashboardItem();
        ds_ClassRoom = new Component.JoDashboardItem();
        ds_Financail = new Component.JoDashboardItem();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new Components.JoTable();
        txtSearch = new Components.JoTextField();
        btnSearch = new Components.JoButtonIconfont();
        cbClass = new Components.JoCombobox();
        joLable3 = new Components.JoLable();
        joLable1 = new Components.JoLable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Phetsarath OT", 0, 18))); // NOI18N

        ds_Student.setForeground(new java.awt.Color(255, 255, 255));
        ds_Student.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);
        ds_Student.setItemBackground(new java.awt.Color(0, 153, 153));
        ds_Student.setItemDetail("ນັກຮຽນ");
        ds_Student.setItemTitle("205");

        ds_Teacher.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_BOX);
        ds_Teacher.setItemBackground(new java.awt.Color(142, 144, 124));
        ds_Teacher.setItemDetail("ຄູສອນ");
        ds_Teacher.setItemTitle("200");

        ds_ClassRoom.setItemBackground(new java.awt.Color(255, 204, 0));
        ds_ClassRoom.setItemDetail("ຫ້ອງຮຽນ");
        ds_ClassRoom.setItemTitle("50");

        ds_Financail.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
        ds_Financail.setItemBackground(new java.awt.Color(0, 153, 51));
        ds_Financail.setItemDetail("ຈ່າຍຄ່າຮຽນ");
        ds_Financail.setItemTitle("150");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(ds_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(ds_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 22, Short.MAX_VALUE)
                .addComponent(ds_ClassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 22, Short.MAX_VALUE)
                .addComponent(ds_Financail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ds_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(ds_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(ds_ClassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ds_Financail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "studentID", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbData);
        if (tbData.getColumnModel().getColumnCount() > 0) {
            tbData.getColumnModel().getColumn(1).setMinWidth(0);
            tbData.getColumnModel().getColumn(1).setPreferredWidth(0);
            tbData.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        txtSearch.setPlaceholder("ຄົ້ນຫານັກຮຽນ");

        btnSearch.setText("ສະແດງ");
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSearch.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        btnSearch.setMargin(new java.awt.Insets(2, 5, 2, 5));

        joLable3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable3.setText("ຫ້ອງຮຽນ");
        joLable3.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(joLable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ຂໍ້ມູນນັກຮຽນຈ່າຍຄ່າຮຽນ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnSearch;
    private Components.JoCombobox cbClass;
    private Component.JoDashboardItem ds_ClassRoom;
    private Component.JoDashboardItem ds_Financail;
    private Component.JoDashboardItem ds_Student;
    private Component.JoDashboardItem ds_Teacher;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable3;
    private Components.JoTable tbData;
    private Components.JoTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void showClassRoom(List<RegisterModel> models) {
        models.forEach(data -> {
            cbClass.JoAddIntModel(data.getRegisterID(), data.getClassRoomName());
        });
    }

    public void showTableData(List<StudentModel> models) {
        tbData.JoClearModel();
        models.forEach(data -> {
            tbData.AddJoModel(new Object[]{tbData.autoNumber(), data.getStudentID(), data.getStudentNo(), data.getFullName()});
        });

    }

}
