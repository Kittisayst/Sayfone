package View;

import Component.JoTableAction;
import Components.JoButtonIconfont;
import Model.DocumentModel;
import Utility.MyFormat;
import java.util.List;

public class DocumentView extends javax.swing.JPanel {

    public DocumentView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtnAdd() {
        return btnAdd;
    }

    public JoTableAction getTb_data() {
        return tb_data;
    }

    public JoButtonIconfont getBtnSearch() {
        return btnSearch;
    }

    public String getSearchText() {
        return txtSearch.getText();
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
        btnAdd = new Components.JoButtonIconfont();
        pn_Datatable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Component.JoTableAction();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtSearch = new Components.JoTextField();
        btnSearch = new Components.JoButtonIconfont();
        joLable1 = new Components.JoLable();
        lblCount = new Components.JoLable();

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

        btnAdd.setText("ເພີ່ມເອກະສານ");
        jPanel5.add(btnAdd);

        Pn_Navigation.add(jPanel5);

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ຫົວຂໍ້ເອກະສານ", "ລາຍລະອຽດ", "ວັນທີ", "ອັບໂຫຼດໂດຍ", "ຈັດການ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_data.setJoCellAction(true);
        jScrollPane1.setViewportView(tb_data);
        if (tb_data.getColumnModel().getColumnCount() > 0) {
            tb_data.getColumnModel().getColumn(0).setMinWidth(80);
            tb_data.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_data.getColumnModel().getColumn(0).setMaxWidth(80);
            tb_data.getColumnModel().getColumn(1).setMinWidth(0);
            tb_data.getColumnModel().getColumn(1).setPreferredWidth(0);
            tb_data.getColumnModel().getColumn(1).setMaxWidth(0);
            tb_data.getColumnModel().getColumn(4).setMinWidth(100);
            tb_data.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_data.getColumnModel().getColumn(4).setMaxWidth(100);
            tb_data.getColumnModel().getColumn(5).setMinWidth(150);
            tb_data.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(5).setMaxWidth(150);
            tb_data.getColumnModel().getColumn(6).setMinWidth(150);
            tb_data.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel8.setLayout(new java.awt.GridBagLayout());

        txtSearch.setPlaceholder("ຄົ້ນຫາ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 60;
        jPanel8.add(txtSearch, gridBagConstraints);

        btnSearch.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel8.add(btnSearch, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jPanel8, gridBagConstraints);

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable1.setText("ຄົ້ນຫາ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(joLable1, gridBagConstraints);

        lblCount.setText("ຈຳນວນເອກະສານທັງໝົດ: 0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(lblCount, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnAdd;
    private Components.JoButtonIconfont btnSearch;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable lblCount;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Component.JoTableAction tb_data;
    private Components.JoTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void showDocument(List<DocumentModel> models) {
        tb_data.clearModel();
        models.forEach(data -> {
            tb_data.AddJoModel(new Object[]{
                tb_data.autoNumber(),
                data.getDocumentID(),
                data.getTitle(),
                data.getComment(),
                new MyFormat().getDate(data.getUploadDate()),
                data.getUser().getFullName(),
                ""
            });
        });
        int count = tb_data.autoNumber() - 1;
        lblCount.setText("ຈຳນວນເອກະສານທັງໝົດ: " + count);
    }

    public int getDucumentID() {
        return tb_data.getIntValue(1);
    }
}
