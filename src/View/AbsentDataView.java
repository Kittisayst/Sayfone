package View;

import Components.JoButtonIconfont;
import Components.JoDateChooser;
import Components.JoTable;
import DAOSevervice.UserService;
import Model.AbsentModel;
import Tools.JoDataTable;
import Utility.AbsentCaculator;
import Utility.MyFormat;
import java.util.List;

public class AbsentDataView extends javax.swing.JPanel {

    public AbsentDataView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void showAbsent(List<AbsentModel> models) {
        tbData.JoClearModel();
        UserService userService = new UserService();
        models.forEach(data -> {
            AbsentCaculator caculator = new AbsentCaculator(data.getAbsentData());
            tbData.AddJoModel(new Object[]{
                tbData.autoNumber(),
                data.getAbsentID(),
                new MyFormat().getDate(data.getAbsentDate()),
                caculator.getComeCount(),
                caculator.getSickCount(),
                caculator.getAbsentCount(),
                data.getComment(),
                userService.getUserById(data.getUserID()).getFullName()
            });
        });
        UpdateData();
    }

    private void UpdateData() {
        pn_Datatable.removeAll();
        pn_Datatable.add(jScrollPane1);
        JoDataTable dataTable = new JoDataTable(pn_Datatable);
        dataTable.setHiddenColumns(1);
        dataTable.showDataTableAll();
    }

    public int getAbsentID() {
        return tbData.getIntValue(1);
    }

    public JoDateChooser getDtDate() {
        return dtDate;
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtnShow() {
        return btnShow;
    }

    public JoButtonIconfont getBtnCheckStudent() {
        return btnCheckStudent;
    }

    public JoTable getTbData() {
        return tbData;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        btnShow = new Components.JoButtonIconfont();
        btnCheckStudent = new Components.JoButtonIconfont();
        dtDate = new Components.JoDateChooser();

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

        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "absentID", "ວັນທີເດືອນປີ", "ມາຮຽນ", "ຄອບ", "ຂາດ", "ໝາຍເຫດ", "ຜູ້ບັນທຶກ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(365, 55));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable1.setText("ວັນທີເດືອນປີ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 8, 5);
        jPanel1.add(joLable1, gridBagConstraints);

        btnShow.setText("ສະແດງ");
        btnShow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnShow.setIconTextGap(0);
        btnShow.setJoIconSize(28);
        btnShow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        btnShow.setMargin(new java.awt.Insets(2, 5, 2, 14));
        btnShow.setPreferredSize(new java.awt.Dimension(90, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 8, 10);
        jPanel1.add(btnShow, gridBagConstraints);

        btnCheckStudent.setBackground(new java.awt.Color(0, 102, 51));
        btnCheckStudent.setText("ບັນທຶກຂາດຮຽນ");
        btnCheckStudent.setJoIconSize(28);
        btnCheckStudent.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_TURNED_IN);
        btnCheckStudent.setMargin(new java.awt.Insets(2, 5, 2, 14));
        btnCheckStudent.setPreferredSize(new java.awt.Dimension(135, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 10, 8, 5);
        jPanel1.add(btnCheckStudent, gridBagConstraints);

        dtDate.setPreferredSize(new java.awt.Dimension(150, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel1.add(dtDate, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnCheckStudent;
    private Components.JoButtonIconfont btnShow;
    private Components.JoButtonIconfont btn_back;
    private Components.JoDateChooser dtDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tbData;
    // End of variables declaration//GEN-END:variables

}
