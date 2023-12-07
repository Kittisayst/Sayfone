package View;

import Components.JoButtonIconfont;
import Components.JoTable;
import DAOSevervice.FinancialService;
import Model.GlobalDataModel;
import Model.StudentModel;
import Tools.JoDataTable;
import java.util.List;

public class ReportStudentStateView extends javax.swing.JPanel {

    private PnLoading loading = new PnLoading();

    public ReportStudentStateView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        loading.setTitle("ກຳລັງໂຫຼດຂໍ້ມູນນັກຮຽນ");
    }

    public void showStudent(List<StudentModel> models) {
        tb_data.JoClearModel();
        GlobalDataModel.rootView.setView(loading);
        Thread thread = new Thread(() -> {
            try {
                FinancialService financialService = new FinancialService();
                models.forEach(data -> {
                    if (data.getStudentID() > 0) {
                        String LastClass = financialService.getLastClass(data.getStudentID());
                        tb_data.AddJoModel(new Object[]{tb_data.autoNumber(), data.getStudentID(), data.getStudentNo(), data.getFullName(), LastClass, data.getStatusName()});
                    }
                    loading.StartProgress(models.size(), 20);
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                GlobalDataModel.rootView.setView(this);
                loading.close();
                pn_Datatable.removeAll();
                pn_Datatable.add(jScrollPane1);
                JoDataTable dataTable = new JoDataTable(pn_Datatable);
                dataTable.showDataTableAll();
                dataTable.setHiddenColumns(1);
            }
        });
        thread.start();

    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public JoButtonIconfont getBtnSearch() {
        return btnSearch;
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
        tb_data = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        cbState = new Components.JoCombobox();
        btnSearch = new Components.JoButtonIconfont();

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

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "StudentID", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ", "ຫ້ອງຮຽນ", "ສະຖານະ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_data);

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable1.setText("ເລືອກສະຖານະ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel1.add(joLable1, gridBagConstraints);

        cbState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ຮຽນຢູ່", "ພັກຮຽນ", "ປະລະການຮຽນ" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel1.add(cbState, gridBagConstraints);

        btnSearch.setText("ສະແດງ");
        btnSearch.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel1.add(btnSearch, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnSearch;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbState;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    // End of variables declaration//GEN-END:variables

    public int getState() {
        return cbState.getSelectedIndex();
    }
}
