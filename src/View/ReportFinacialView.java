package View;

import Components.JoButtonIconfont;
import Components.JoDateChooser;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import Model.CreateRegisterModel;
import Model.FinancialModel;
import Model.StudentModel;
import Utility.MyFormat;
import java.awt.Color;
import java.util.List;

public class ReportFinacialView extends javax.swing.JPanel {

    public ReportFinacialView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void showDataReport(List<FinancialModel> models) {
        tb_data.JoClearModel();
        MyFormat format = new MyFormat();
        models.forEach(data -> {
            RegisterService registerService = new RegisterService();
            StudentService studentService = new StudentService();
            CreateRegisterModel registerModel = registerService.getRegisterById(data.getRegisterID());
            StudentModel studentModel = studentService.getStudentById(data.getStudentID());
            tb_data.AddJoModel(new Object[]{
                tb_data.autoNumber(),
                registerModel.getClassRoomName(),
                studentModel.getStudentNo(),
                studentModel.getFullName(),
                format.getDate(data.getFinancialDate()),
                format.formatMoney(data.getMoney()),
                data.getFinancialMonth(),
                data.getFinancialComment()
            });
        });
        btnPrint.setEnabled(!models.isEmpty());
    }

    public void showDataReportTransfer(List<FinancialModel> models) {
        tb_data.JoClearModel();
        MyFormat format = new MyFormat();
        models.forEach(data -> {
            RegisterService registerService = new RegisterService();
            StudentService studentService = new StudentService();
            CreateRegisterModel registerModel = registerService.getRegisterById(data.getRegisterID());
            StudentModel studentModel = studentService.getStudentById(data.getStudentID());
            tb_data.AddJoModel(new Object[]{
                tb_data.autoNumber(),
                registerModel.getClassRoomName(),
                studentModel.getStudentNo(),
                studentModel.getFullName(),
                format.getDate(data.getFinancialDate()),
                format.formatMoney(data.getTransferMoney()),
                data.getFinancialMonth(),
                data.getFinancialComment()
            });
        });
        btnPrint.setEnabled(!models.isEmpty());
    }

    public void showOnlyState(boolean State) {
        Color cash = new Color(204, 51, 0);
        Color transfer = new Color(0, 102, 51);
        System.out.println(State);
        tb_data.setJoBackgoundHead(State ? cash : transfer);
        pnDataReport.repaint();
        pnDataReport.revalidate();
        showMoneyTitle(State);
    }

    private void showMoneyTitle(boolean State) {
        lblMoneyTitle.setText(State ? btnCashOnly.getText() : btnTransferOnly.getText());
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtnShow() {
        return btnShow;
    }

    public JoDateChooser getDtDate() {
        return dtDate;
    }

    public JoDateChooser getDtDateEnd() {
        return dtDateEnd;
    }

    public JoButtonIconfont getBtnReportWeek() {
        return btnReportWeek;
    }

    public JoButtonIconfont getBtn_ReportDay() {
        return btn_ReportDay;
    }

    public JoButtonIconfont getBtnCashOnly() {
        return btnCashOnly;
    }

    public JoButtonIconfont getBtnTransferOnly() {
        return btnTransferOnly;
    }

    public JoButtonIconfont getBtnPrint() {
        return btnPrint;
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_ReportDay = new Components.JoButtonIconfont();
        btnReportWeek = new Components.JoButtonIconfont();
        joLable1 = new Components.JoLable();
        dtDate = new Components.JoDateChooser();
        joLable2 = new Components.JoLable();
        dtDateEnd = new Components.JoDateChooser();
        PnFilter = new javax.swing.JPanel();
        btnShow = new Components.JoButtonIconfont();
        pnDataReport = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Components.JoTable();
        jPanel7 = new javax.swing.JPanel();
        lblMoneyTitle = new Components.JoLable();
        jPanel6 = new javax.swing.JPanel();
        joPanel1 = new Components.JoPanel();
        btnCashOnly = new Components.JoButtonIconfont();
        btnTransferOnly = new Components.JoButtonIconfont();
        btnPrint = new Components.JoButtonIconfont();

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

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btn_ReportDay.setBackground(new java.awt.Color(0, 153, 153));
        btn_ReportDay.setText("ສະແດງປະຈຳວັນ");
        btn_ReportDay.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.TODAY);
        jPanel2.add(btn_ReportDay);

        btnReportWeek.setBackground(new java.awt.Color(204, 153, 0));
        btnReportWeek.setText("ສະແດງປະຈຳອາທິດ");
        btnReportWeek.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.EVENT);
        jPanel2.add(btnReportWeek);

        joLable1.setText("ວັນທີ່ເລີ່ມ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel2.add(joLable1);

        dtDate.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(dtDate);

        joLable2.setText("ຈົນເຖິງວັນທີ່");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel2.add(joLable2);

        dtDateEnd.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(dtDateEnd);
        jPanel2.add(PnFilter);

        btnShow.setText("ສະແດງ");
        btnShow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        jPanel2.add(btnShow);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jPanel2, gridBagConstraints);

        pnDataReport.setBackground(new java.awt.Color(153, 204, 255));
        pnDataReport.setLayout(new java.awt.BorderLayout());

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ຫ້ອງຮຽນ", "ລະຫັດນັກສຶກສາ", "ຊື່ ແລະ ນາມສະກຸນ", "ວັນທີ່ເດີອນປີ", "ຈຳນວນເງິນ", "ເດືອນ", "ໝາຍເຫດ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_data.setJoBackgoundHead(new java.awt.Color(204, 51, 0));
        jScrollPane1.setViewportView(tb_data);
        if (tb_data.getColumnModel().getColumnCount() > 0) {
            tb_data.getColumnModel().getColumn(0).setMinWidth(70);
            tb_data.getColumnModel().getColumn(0).setPreferredWidth(70);
            tb_data.getColumnModel().getColumn(0).setMaxWidth(70);
            tb_data.getColumnModel().getColumn(2).setMinWidth(80);
            tb_data.getColumnModel().getColumn(2).setPreferredWidth(80);
            tb_data.getColumnModel().getColumn(2).setMaxWidth(80);
            tb_data.getColumnModel().getColumn(4).setMinWidth(80);
            tb_data.getColumnModel().getColumn(4).setPreferredWidth(80);
            tb_data.getColumnModel().getColumn(4).setMaxWidth(80);
            tb_data.getColumnModel().getColumn(5).setMinWidth(150);
            tb_data.getColumnModel().getColumn(5).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(5).setMaxWidth(150);
            tb_data.getColumnModel().getColumn(6).setMinWidth(80);
            tb_data.getColumnModel().getColumn(6).setPreferredWidth(80);
            tb_data.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        pnDataReport.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        lblMoneyTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMoneyTitle.setText("ສະແດງສະເພາະງິນສົດ");
        lblMoneyTitle.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N
        lblMoneyTitle.setPreferredSize(new java.awt.Dimension(300, 40));
        jPanel7.add(lblMoneyTitle);

        pnDataReport.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(pnDataReport, gridBagConstraints);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        joPanel1.setPreferredSize(new java.awt.Dimension(410, 60));
        joPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        btnCashOnly.setBackground(new java.awt.Color(204, 51, 0));
        btnCashOnly.setText("ສະແດງສະເພາະງິນສົດ");
        btnCashOnly.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btnCashOnly.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ATTACH_MONEY);
        btnCashOnly.setJocolorHover(new java.awt.Color(163, 40, 0));
        joPanel1.add(btnCashOnly);

        btnTransferOnly.setBackground(new java.awt.Color(0, 102, 51));
        btnTransferOnly.setText("ສະແດງສະເພາະເງິນໂອນ");
        btnTransferOnly.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btnTransferOnly.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.FILTER_DRAMA);
        btnTransferOnly.setJocolorHover(new java.awt.Color(8, 80, 44));
        joPanel1.add(btnTransferOnly);

        jPanel6.add(joPanel1);

        btnPrint.setText("ປີ້ນລາຍງານ");
        btnPrint.setEnabled(false);
        btnPrint.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        btnPrint.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PRINT);
        btnPrint.setPreferredSize(new java.awt.Dimension(200, 55));
        jPanel6.add(btnPrint);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(jPanel6, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnFilter;
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnCashOnly;
    private Components.JoButtonIconfont btnPrint;
    private Components.JoButtonIconfont btnReportWeek;
    private Components.JoButtonIconfont btnShow;
    private Components.JoButtonIconfont btnTransferOnly;
    private Components.JoButtonIconfont btn_ReportDay;
    private Components.JoButtonIconfont btn_back;
    private Components.JoDateChooser dtDate;
    private Components.JoDateChooser dtDateEnd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoPanel joPanel1;
    private Components.JoLable lblMoneyTitle;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pnDataReport;
    private Components.JoTable tb_data;
    // End of variables declaration//GEN-END:variables
}
