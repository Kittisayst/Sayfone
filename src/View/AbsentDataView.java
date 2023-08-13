package View;

import Components.JoButtonIconfont;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.StudentModel;
import java.util.List;

public class AbsentDataView extends javax.swing.JPanel {

    public AbsentDataView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void showStudent(List<FinancialModel> models) {

    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        joTable1 = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        joCombobox1 = new Components.JoCombobox();
        joLable2 = new Components.JoLable();
        joCombobox2 = new Components.JoCombobox();
        joButtonIconfont1 = new Components.JoButtonIconfont();
        joButtonIconfont2 = new Components.JoButtonIconfont();

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

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        joTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "StudentID", "ລະຫັດນັກຮຽນ", "ສະຖານະຂາດຮຽນ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(joTable1);

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 8));

        joLable1.setText("ເລືອກເດືອນ");
        jPanel1.add(joLable1);

        joCombobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        joCombobox1.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        joCombobox1.setPreferredSize(new java.awt.Dimension(50, 35));
        jPanel1.add(joCombobox1);

        joLable2.setText("ເລືອກວັນທີ່");
        jPanel1.add(joLable2);

        joCombobox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01/02/2023", "ເດືອນ 2", "ເດືອນ 3", "ເດືອນ 4", "ເດືອນ 5", "ເດືອນ 6", "ເດືອນ 7", "ເດືອນ 8", "ເດືອນ 9", "ເດືອນ 10", "ເດືອນ 11", "ເດືອນ 12" }));
        joCombobox2.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        joCombobox2.setPreferredSize(new java.awt.Dimension(120, 35));
        jPanel1.add(joCombobox2);

        joButtonIconfont1.setText("ສະແດງ");
        joButtonIconfont1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joButtonIconfont1.setIconTextGap(0);
        joButtonIconfont1.setJoIconSize(28);
        joButtonIconfont1.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        joButtonIconfont1.setMargin(new java.awt.Insets(2, 5, 2, 14));
        joButtonIconfont1.setPreferredSize(new java.awt.Dimension(90, 35));
        jPanel1.add(joButtonIconfont1);

        joButtonIconfont2.setBackground(new java.awt.Color(0, 102, 51));
        joButtonIconfont2.setText("ບັນທຶກຂາດຮຽນ");
        joButtonIconfont2.setJoIconSize(28);
        joButtonIconfont2.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_TURNED_IN);
        joButtonIconfont2.setMargin(new java.awt.Insets(2, 5, 2, 14));
        joButtonIconfont2.setPreferredSize(new java.awt.Dimension(135, 35));
        jPanel1.add(joButtonIconfont2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoButtonIconfont joButtonIconfont1;
    private Components.JoButtonIconfont joButtonIconfont2;
    private Components.JoCombobox joCombobox1;
    private Components.JoCombobox joCombobox2;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoTable joTable1;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    // End of variables declaration//GEN-END:variables

}
