package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoDateChooser;
import Components.JoTable;
import Components.JoTextArea;
import Model.OutstandingCatModel;
import Model.TeacherOutstandingModel;
import Tools.JoDataTable;
import java.util.List;

public class TeacherOutstandingView extends javax.swing.JPanel {

    public TeacherOutstandingView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public void showOutstandingCategory(List<OutstandingCatModel> model) {
        model.forEach(data -> {
            cb_outstandingCat.JoAddModel("" + data.getOutstandingCatID(), data.getOutstandingName());
        });
    }

    public void showTeacherOutstanding(List<TeacherOutstandingModel> models) {
        models.forEach(data -> {
            tb_data.AddJoModel(new Object[]{tb_data.autoNumber(), data.getTeacherOutstandingID(), data.getOutstandingName(), data.getOutstandingDate(), data.getOutstandingDetail()});
        });
        JoDataTable dataTable = new JoDataTable(pn_DataTable);
        dataTable.setHiddenColumns(1);
        dataTable.showDataTableAll();
    }

    public void showTeacherOutstanding(TeacherOutstandingModel model) {
        cb_outstandingCat.setSelectValue("" + model.getOutstandingCatID());
        dt_date.setDateData(model.getOutstandingDate());
        txt_info.setText(model.getOutstandingDetail());
    }

    //======== Getter ============
    public JoDateChooser getDt_date() {
        return dt_date;
    }

    public JoTextArea getTxt_info() {
        return txt_info;
    }

    public JoCombobox getCb_outstandingCat() {
        return cb_outstandingCat;
    }

    public JoButtonIconfont getBtn_save() {
        return btn_save;
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
        pn_DataTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_info = new Components.JoTextArea();
        joLable2 = new Components.JoLable();
        cb_outstandingCat = new Components.JoCombobox();
        btn_save = new Components.JoButtonIconfont();
        joLable3 = new Components.JoLable();
        dt_date = new Components.JoDateChooser();

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

        pn_DataTable.setLayout(new java.awt.BorderLayout());

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ປະເພດຜົນງານ", "ວັນທີ່", "ລາຍລະອຽດ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_data);

        pn_DataTable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));
        jPanel1.setOpaque(false);

        joLable1.setText("ລາຍລະອຽດຜົນງານ");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        txt_info.setColumns(20);
        txt_info.setRows(5);
        jScrollPane2.setViewportView(txt_info);

        joLable2.setText("ປະເພດຜົນງານ");

        btn_save.setText("ບັນທຶກຜົນງານພົ້ນດັ່ນ");
        btn_save.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_save.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);

        joLable3.setText("ວັນທີ່ບັນທຶກຜົນງານ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_outstandingCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dt_date, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(joLable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_outstandingCat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_DataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_DataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_back;
    private Components.JoButtonIconfont btn_save;
    private Components.JoCombobox cb_outstandingCat;
    private Components.JoDateChooser dt_date;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_DataTable;
    private Components.JoTable tb_data;
    private Components.JoTextArea txt_info;
    // End of variables declaration//GEN-END:variables
}
