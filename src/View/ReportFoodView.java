package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.YearModel;
import Tools.JoDataTable;
import Utility.MyFormat;
import java.util.List;

public class ReportFoodView extends javax.swing.JPanel {

    private PnLoading loading;

    public ReportFoodView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        loading = new PnLoading();
        loading.setTitle("ກຳລັງໂຫຼດຂໍ້ມູນ");
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public JoButtonIconfont getBtnExport() {
        return btnExport;
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

    public void showFood(List<FinancialModel> models) {
        tb_data.JoClearModel();
        GlobalDataModel.rootView.setView(loading);
        Thread thread = new Thread(() -> {
            try {
                StudentService service = new StudentService();
                FinancialService financialService = new FinancialService();
                models.forEach(data -> {
                    StudentModel studentModel = service.getStudentById(data.getStudentID());
                    FinancialModel financialModel = financialService.getFinancialCalculator(data.getRegisterID(), data.getStudentID());
                    String foodMoney = new MyFormat().formatMoney(financialModel.getFoodMoney());
                    if (financialModel.getFoodMoney() > 0) {
                        tb_data.AddJoModel(new Object[]{
                            tb_data.autoNumber(),
                            data.getFinancialIID(),
                            data.getRegisterID(),
                            data.getStudentID(),
                            foodMoney,
                            financialModel.getFinancialMonth(),
                            studentModel.getStudentNo(),
                            studentModel.getFullName(),
                            financialModel.getFinancialComment()
                        });
                    }
                    loading.StartProgress(models.size(), 100);
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                clearData();
                GlobalDataModel.rootView.setView(this);
                loading.close();
            }
        });
        thread.start();
    }

    private void clearData() {
        pn_Datatable.removeAll();
        pn_Datatable.add(jScrollPane1);
        JoDataTable dataTable = new JoDataTable(pn_Datatable);
        dataTable.setHiddenColumns(1);
        dataTable.setHiddenColumns(2);
        dataTable.setHiddenColumns(3);
        dataTable.showDataTableAll();
    }

    public void setAmount(int amount) {
        lblAmount.setText("ລວມເງິນທັງໝົດ: " + new MyFormat().formatMoney(amount) + " ກີບ");
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
        cbYear = new Components.JoCombobox();
        cbClassRoom = new Components.JoCombobox();
        btnShow = new Components.JoButtonIconfont();
        jPanel2 = new javax.swing.JPanel();
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
                "#", "FinacialID", "RegisterID", "StudentID", "ຄ່າອາຫານ", "ເດືອນ", "ລະຫັດນັກຮຽນ", "ຊື່ນັກຮຽນ", "ໝາຍເຫດ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            tb_data.getColumnModel().getColumn(4).setMinWidth(100);
            tb_data.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_data.getColumnModel().getColumn(4).setMaxWidth(100);
            tb_data.getColumnModel().getColumn(5).setMinWidth(200);
            tb_data.getColumnModel().getColumn(5).setPreferredWidth(200);
            tb_data.getColumnModel().getColumn(5).setMaxWidth(200);
            tb_data.getColumnModel().getColumn(6).setMinWidth(80);
            tb_data.getColumnModel().getColumn(6).setPreferredWidth(80);
            tb_data.getColumnModel().getColumn(6).setMaxWidth(80);
            tb_data.getColumnModel().getColumn(7).setMinWidth(150);
            tb_data.getColumnModel().getColumn(7).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(7).setMaxWidth(150);
        }

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        cbYear.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel1.add(cbYear);

        cbClassRoom.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel1.add(cbClassRoom);

        btnShow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        btnShow.setLabel("ສະແດງ");
        btnShow.setMargin(new java.awt.Insets(2, 5, 2, 10));
        btnShow.setPreferredSize(new java.awt.Dimension(89, 36));
        jPanel1.add(btnShow);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        lblAmount.setText("ລວມເງິນ");
        lblAmount.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
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
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnExport;
    private Components.JoButtonIconfont btnShow;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbClassRoom;
    private Components.JoCombobox cbYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable lblAmount;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    // End of variables declaration//GEN-END:variables

    public void ExportEnable() {
        btnExport.setEnabled(tb_data.getJoModel().getRowCount() > 0);
    }

    public String getClassName() {
        return cbClassRoom.getValue();
    }

    public String getExportName() {
        return cbYear.getValue() + "-" + cbClassRoom.getValue();
    }

}
