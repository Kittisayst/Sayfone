package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.YearModel;
import Tools.JoDataTable;
import Utility.MyFormat;
import java.util.List;

public class CreateRoomView extends javax.swing.JPanel {

    private PnLoading loading = new PnLoading();

    public CreateRoomView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void showRegister(List<RegisterModel> models) {
        tb_data.JoClearModel();
        loading.setTitle("ໂຫຼດຂໍ້ມູນຫ້ອງຮຽນ");
        Thread thread = new Thread(() -> {
            try {
                GlobalDataModel.rootView.setView(loading);
                models.forEach(data -> {
                    tb_data.AddJoModel(new Object[]{
                        tb_data.autoNumber(),
                        data.getRegisterID(),
                        data.getClassModel().getClassName(),
                        data.getClassRoomName(),
                        data.getYearModel().getYear(),
                        new MyFormat().getDate(data.getRegisterDate())});
                    loading.StartProgress(models.size(), 20);
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                GlobalDataModel.rootView.setView(this);
                loading.close();
                JoDataTable dataTable = new JoDataTable(pn_Datatable);
                dataTable.setHiddenColumns(1);
                dataTable.showDataTableAll();
            }
        });
        thread.start();
    }

    public void showYear(List<YearModel> years) {
        cbYear.JoClearData();
        years.forEach(data -> {
            cbYear.JoAddIntModel(data.getYearID(), data.getYear());
        });
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtn_Add() {
        return btn_add;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public int getRegisterID() {
        return tb_data.getIntValue(1);
    }

    public JoCombobox getCbYear() {
        return cbYear;
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
        btn_add = new Components.JoButtonIconfont();
        pn_Datatable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        cbYear = new Components.JoCombobox();

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

        btn_add.setText("ເປີດລົງທະບຽນໃໝ່");
        btn_add.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ADD_CIRCLE);
        jPanel5.add(btn_add);

        Pn_Navigation.add(jPanel5);

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ຂະແໜງ", "ຫ້ອງຮຽນ", "ສົກຮຽນ", "ວັນທີເປີດລົງທະບຽນ"
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

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        joLable1.setText("ສົກຮຽນ");
        jPanel1.add(joLable1);

        cbYear.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel1.add(cbYear);

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
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_add;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbYear;
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
}
