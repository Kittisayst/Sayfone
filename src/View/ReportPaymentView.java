package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.YearModel;
import Tools.JoDataTable;
import Utility.MyFormat;
import java.util.List;

public class ReportPaymentView extends javax.swing.JPanel {

    private PnLoading loading = new PnLoading();

    public ReportPaymentView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        loading.setTitle("ກຳລັງໂຫຼດຂໍ້ມູນ" + Title);
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public PnLoading getLoading() {
        return loading;
    }

    public String getClassName() {
        return cbClassRoom.getSelectedItem().toString();
    }

    public void showYear(List<YearModel> models) {
        cbYear.JoClearData();
        models.forEach(data -> {
            cbYear.JoAddIntModel(data.getYearID(), data.getYear());
        });
    }

    public void showClassRoom(List<RegisterModel> models) {
        cbClassRoom.JoClearData();
        models.forEach(data -> {
            cbClassRoom.JoAddIntModel(data.getRegisterID(), data.getClassRoomName());
        });
    }

    private void clearData() {
        pn_Datatable.removeAll();
        pn_Datatable.add(jScrollPane1);
        JoDataTable dataTable = new JoDataTable(pn_Datatable);
//        dataTable.setHiddenColumns(1);
//        dataTable.setHiddenColumns(2);
//        dataTable.setHiddenColumns(3);
        dataTable.showDataTableAll();
    }

    public void setAmount(int money, int transfer, int food, int discount, int overpay, int amount) {
        MyFormat mf = new MyFormat();
        lblMoney.setText("ເງິນສົດ: " + mf.formatMoney(money) + " ກີບ");
        lblTransfer.setText("ເງິນໂອນ: " + mf.formatMoney(transfer) + " ກີບ");
        lbldiscount.setText("ສ່ວນຫຼຸດ: " + mf.formatMoney(discount) + " ກີບ");
        lbloverpay.setText("ຈ່າຍຊ້າ: " + mf.formatMoney(overpay) + " ກີບ");
        lblAmount.setText("ລວມເງິນທັງໝົດ: " + mf.formatMoney(amount) + " ກີບ");
    }

    public int getMonth() {
        return cbMonth.getSelectedIndex();
    }

    public JoCombobox getCbClassRoom() {
        return cbClassRoom;
    }

    public JoCombobox getCbYear() {
        return cbYear;
    }

    public JoButtonIconfont getBtnShow() {
        return btnShow;
    }

    public JoButtonIconfont getBtnExport() {
        return btnExport;
    }

    private void EnableReport() {
        btnExport.setEnabled(tb_data.getJoModel().getRowCount() > 0);
    }

    public void showReport(List<FinancialModel> reportData) {
        Thread thread = new Thread(() -> {
            try {
                tb_data.JoClearModel();
                MyFormat mf = new MyFormat();
                GlobalDataModel.rootView.setView(loading);
                reportData.forEach(data -> {
                    StudentModel studentModel = new StudentService().getStudentById(data.getStudentID());
                    tb_data.AddJoModel(new Object[]{
                        tb_data.autoNumber(),
                        studentModel.getFullName(),
                        data.getFinancialMonth(),
                        mf.formatMoney(data.getMoney()),
                        mf.formatMoney(data.getTransferMoney()),
                        mf.formatMoney(data.getOvertimePay()),
                        mf.formatMoney(data.getDiscount()),
                        data.getFinancialComment().equals("") ? "null" : data.getFinancialComment()
                    });
                    loading.StartProgress(reportData.size(), 50);
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                EnableReport();
                clearData();
                loading.close();
                GlobalDataModel.rootView.setView(this);
            }
        });
        thread.start();
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
        tb_data = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        cbYear = new Components.JoCombobox();
        joLable2 = new Components.JoLable();
        cbClassRoom = new Components.JoCombobox();
        joLable3 = new Components.JoLable();
        cbMonth = new Components.JoCombobox();
        btnShow = new Components.JoButtonIconfont();
        jPanel2 = new javax.swing.JPanel();
        lblMoney = new Components.JoLable();
        lblTransfer = new Components.JoLable();
        lbldiscount = new Components.JoLable();
        lbloverpay = new Components.JoLable();
        lblAmount = new Components.JoLable();
        btnExport = new Components.JoButtonIconfont();

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
                "#", "ຊື່ ແລະ ນາມສະກຸນ", "ຈ່າຍເດືອນ", "ເງິນສົດ", "ເງິນໂອນ", "ຈ່າຍຊ້າ", "ສ່ວນຫຼຸດ", "ໝາຍເຫດ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_data);
        if (tb_data.getColumnModel().getColumnCount() > 0) {
            tb_data.getColumnModel().getColumn(0).setMinWidth(80);
            tb_data.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_data.getColumnModel().getColumn(0).setMaxWidth(80);
            tb_data.getColumnModel().getColumn(1).setMinWidth(150);
            tb_data.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(1).setMaxWidth(150);
            tb_data.getColumnModel().getColumn(3).setMinWidth(150);
            tb_data.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(3).setMaxWidth(150);
            tb_data.getColumnModel().getColumn(4).setMinWidth(150);
            tb_data.getColumnModel().getColumn(4).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(4).setMaxWidth(150);
            tb_data.getColumnModel().getColumn(5).setMinWidth(150);
            tb_data.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(5).setMaxWidth(150);
            tb_data.getColumnModel().getColumn(6).setMinWidth(150);
            tb_data.getColumnModel().getColumn(6).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        joLable1.setText("ສົກຮຽນ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel1.add(joLable1);

        cbYear.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel1.add(cbYear);

        joLable2.setText("ຫ້ອງຮຽນ");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel1.add(joLable2);

        cbClassRoom.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel1.add(cbClassRoom);

        joLable3.setText("ເດືອນ");
        joLable3.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel1.add(joLable3);

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ທັງໝົດ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbMonth.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel1.add(cbMonth);

        btnShow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        btnShow.setLabel("ສະແດງ");
        btnShow.setMargin(new java.awt.Insets(2, 5, 2, 10));
        btnShow.setPreferredSize(new java.awt.Dimension(89, 36));
        jPanel1.add(btnShow);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 10));

        lblMoney.setText("ເງິນສົດ");
        lblMoney.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel2.add(lblMoney);

        lblTransfer.setText("ເງິນໂອນ");
        lblTransfer.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel2.add(lblTransfer);

        lbldiscount.setText("ສ່ວນຫຼຸດ");
        lbldiscount.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel2.add(lbldiscount);

        lbloverpay.setText("ຈ່າຍຊ້າ");
        lbloverpay.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel2.add(lbloverpay);

        lblAmount.setText("ລວມເງິນ");
        lblAmount.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        jPanel2.add(lblAmount);

        btnExport.setBackground(new java.awt.Color(0, 153, 102));
        btnExport.setText("Excel");
        btnExport.setEnabled(false);
        btnExport.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.GRID_ON);
        jPanel2.add(btnExport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnExport;
    private Components.JoButtonIconfont btnShow;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbClassRoom;
    private Components.JoCombobox cbMonth;
    private Components.JoCombobox cbYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable lblAmount;
    private Components.JoLable lblMoney;
    private Components.JoLable lblTransfer;
    private Components.JoLable lbl_title;
    private Components.JoLable lbldiscount;
    private Components.JoLable lbloverpay;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    // End of variables declaration//GEN-END:variables

}
