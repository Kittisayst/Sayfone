package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.YearModel;
import Tools.JoDataTable;
import Utility.MyFormat;
import java.util.List;
import javax.swing.SwingUtilities;

public class ReportDiscountView extends javax.swing.JPanel {

    private PnLoading pnLoading = new PnLoading();

    public ReportDiscountView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        pnLoading.setTitle("ໂຫຼດຂໍ້ມູນສ່ວນຫຼຸດ");
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

    int row = 1;

    public void showDiscount(List<FinancialModel> models) {
        tb_data.JoClearModel();
        Thread thread = new Thread(() -> {
            try {
                HomeView.MyRouter.setRouter(pnLoading);
                StudentService service = new StudentService();
                FinancialService financialService = new FinancialService();
                models.forEach(data -> {
                    pnLoading.startState();
                    StudentModel studentModel = service.getStudentById(data.getStudentID());
                    FinancialModel financialModel = financialService.getFinancialCalculator(data.getRegisterID(), data.getStudentID());
                    if (financialModel.getDiscount() > 0) {
                        tb_data.AddJoModel(new Object[]{
                            tb_data.autoNumber(),
                            data.getFinancialIID(),
                            data.getRegisterID(),
                            data.getStudentID(),
                            new MyFormat().formatMoney(financialModel.getDiscount()),
                            financialModel.getFinancialMonth(),
                            studentModel.getStudentNo(),
                            studentModel.getFullName(),});
                        SwingUtilities.invokeLater(() -> {
                            pnLoading.StartProgress(models.size());
                        });
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                HomeView.MyRouter.setRouter(this);
                clearData();
                ExportEnable();
                pnLoading.close();
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

    public void ExportEnable() {
        btnExport.setEnabled(tb_data.getJoModel().getRowCount() > 0);
    }

    public String getClassName() {
        return cbClassRoom.getValue();
    }

    public String getExportName() {
        return cbYear.getValue() + "-" + cbClassRoom.getValue();
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
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

    public PnLoading getPnLoading() {
        return pnLoading;
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
        btnExport = new Components.JoButtonIconfont();
        lblAmount = new Components.JoLable();

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
                "#", "FinancilID", "RegisterID", "StudentID", "ສ່ວນຫຼຸດ", "ເດືອນ", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ"
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

        btnExport.setBackground(new java.awt.Color(0, 153, 102));
        btnExport.setText("Export Excel");
        btnExport.setEnabled(false);
        btnExport.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.GRID_ON);
        jPanel2.add(btnExport);

        lblAmount.setText("ລວມເງິນ");
        lblAmount.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel2.add(lblAmount);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(69, 69, 69))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 657, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
}
