package View;

import Component.JoDashboardItem;
import Components.JoButton;
import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import Components.JoTextField;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.RegisterModel;
import Model.StudentModel;
import Utility.WrapLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

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
        joLable2 = new Components.JoLable();
        pnClassRoom = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new Components.JoTable();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new Components.JoTextField();
        btnSearch = new Components.JoButtonIconfont();

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
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(ds_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(ds_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 25, Short.MAX_VALUE)
                .addComponent(ds_ClassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 25, Short.MAX_VALUE)
                .addComponent(ds_Financail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
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

        joLable2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable2.setText("ຫ້ອງຮຽນທັງໝົດ");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N

        pnClassRoom.setLayout(new java.awt.BorderLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ຂໍ້ມູນນັກຮຽນຈ່າຍຄ່າຮຽນ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N

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

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        txtSearch.setPlaceholder("ຄົ້ນຫານັກຮຽນ");
        jPanel3.add(txtSearch);

        btnSearch.setText("ສະແດງ");
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSearch.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        btnSearch.setMargin(new java.awt.Insets(2, 5, 2, 10));
        jPanel3.add(btnSearch);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnClassRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnClassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnSearch;
    private Component.JoDashboardItem ds_ClassRoom;
    private Component.JoDashboardItem ds_Financail;
    private Component.JoDashboardItem ds_Student;
    private Component.JoDashboardItem ds_Teacher;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private javax.swing.JPanel pnClassRoom;
    private Components.JoTable tbData;
    private Components.JoTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void showClassRoom(List<RegisterModel> models) {
        pnClassRoom.removeAll();
        pnClassRoom.setSize(500, 500);
        FinancialService financialService = new FinancialService();
        JPanel classRoomLayout = new JPanel(new WrapLayout(WrapLayout.LEFT, 5, 5));
        classRoomLayout.setSize(200, 200);
        models.forEach(data -> {
            JButton btnClass = new JButton();
            btnClass.setFont(new Font("Phetsarath OT", 0, 12));
            btnClass.setPreferredSize(new Dimension(140, 30));
            btnClass.setFocusable(false);
            int CountStudent = financialService.getStudentRegistered(data.getRegisterID()).size();
            btnClass.setText(data.getClassRoomName() + " : ( " + CountStudent + " )");
            classRoomLayout.add(btnClass);
        });
        pnClassRoom.add(classRoomLayout, BorderLayout.CENTER);
    }

    public void showTableData(List<StudentModel> models) {
        tbData.JoClearModel();
        models.forEach(data -> {
            tbData.AddJoModel(new Object[]{tbData.autoNumber(), data.getStudentID(), data.getStudentNo(), data.getFullName()});
        });

    }

}
