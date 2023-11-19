package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.UserModel;
import Model.YearModel;
import Utility.MyFormat;
import java.util.List;

public class ReportUserClassRoomMoneyView extends javax.swing.JPanel {

    private int money = 0;
    private int transfer = 0;
    private PnLoading loading;

    public ReportUserClassRoomMoneyView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        loading = new PnLoading();
    }

    public void showUsers(List<UserModel> models) {
        cbUser.JoClearData();
        models.forEach(data -> {
            cbUser.JoAddIntModel(data.getUserID(), data.getFullName().toString());
        });
    }

    public void showYear(List<YearModel> models) {
        cbYear.JoClearData();
        models.forEach(data -> {
            cbYear.JoAddIntModel(data.getYearID(), data.getYear());
        });
    }

    public int getyearID() {
        return Integer.parseInt(cbYear.getKey());
    }

    public void showClassRoom(List<RegisterModel> models) {
        cbClassRoom.JoClearData();
        models.forEach(data -> {
            cbClassRoom.JoAddIntModel(data.getRegisterID(), data.getClassRoomName());
        });
    }

    public void showFinancailUserClassMoney(List<FinancialModel> models) {
        loading.setTitle("ໂຫຼດຂໍ້ມູນການຈ່າຍຄ່າຮຽນ");
        tb_data.JoClearModel();
        money = 0;
        transfer = 0;
        MyFormat format = new MyFormat();
        StudentService studentService = new StudentService();
        Thread thread = new Thread(() -> {
            try {
                GlobalDataModel.rootView.setView(loading);
                models.forEach(data -> {
                    StudentModel studentModel = studentService.getStudentById(data.getStudentID());
                    if (studentModel.getStudentName() != null) {
                        money += data.getMoney();
                        transfer += data.getTransferMoney();
                        tb_data.AddJoModel(new Object[]{
                            tb_data.autoNumber(),
                            studentModel.getStudentNo(),
                            studentModel.getFullName(),
                            format.getDate(data.getFinancialDate()),
                            format.formatMoney(data.getMoney()),
                            format.formatMoney(data.getTransferMoney()),
                            format.formatMoney(data.getFoodMoney()),
                            data.getFinancialMonth(),
                            data.getFinancialComment()
                        });
                    }
                    loading.StartProgress(models.size(), 100);
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                btnPrint.setEnabled(!models.isEmpty());
                lblMoney.setText("ເງິນສົດ: " + format.formatMoney(money));
                lblTransferMoney.setText("ເງິນໂອນ: " + format.formatMoney(transfer));
                loading.close();
                GlobalDataModel.rootView.setView(this);
            }
        });
        thread.start();
    }

    public int getRegisterID() {
        return Integer.parseInt(cbClassRoom.getKey());
    }

    public int getUserID() {
        return Integer.parseInt(cbUser.getKey());
    }

    public void EnableSearch() {
        btnsearch.setEnabled(!cbClassRoom.getMylist().isEmpty());
    }

    //=========geter==========
    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public JoButtonIconfont getBtnsearch() {
        return btnsearch;
    }

    public JoCombobox getCbYear() {
        return cbYear;
    }

    public JoButtonIconfont getBtnPrint() {
        return btnPrint;
    }

    public PnLoading getLoading() {
        return loading;
    }

    public String getClassName() {
        return cbClassRoom.getValue();
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
        cbYear = new Components.JoCombobox();
        cbClassRoom = new Components.JoCombobox();
        cbUser = new Components.JoCombobox();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        joLable3 = new Components.JoLable();
        btnsearch = new Components.JoButtonIconfont();
        jPanel2 = new javax.swing.JPanel();
        lblMoney = new Components.JoLable();
        btnPrint = new Components.JoButtonIconfont();
        lblTransferMoney = new Components.JoLable();

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
                "#", "ລະຫັດນັກສຶກສາ", "ຊື່ ແລະ ນາມສະກຸນ", "ວັນທີ່ເດີອນປີ", "ຈຳນວນເງິນ", "ເງິນໂອນ", "ອາຫານ", "ເດືອນ", "ໝາຍເຫດ"
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
            tb_data.getColumnModel().getColumn(1).setMinWidth(90);
            tb_data.getColumnModel().getColumn(1).setPreferredWidth(90);
            tb_data.getColumnModel().getColumn(1).setMaxWidth(90);
            tb_data.getColumnModel().getColumn(2).setMinWidth(150);
            tb_data.getColumnModel().getColumn(2).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(2).setMaxWidth(150);
            tb_data.getColumnModel().getColumn(3).setMinWidth(90);
            tb_data.getColumnModel().getColumn(3).setPreferredWidth(90);
            tb_data.getColumnModel().getColumn(3).setMaxWidth(90);
            tb_data.getColumnModel().getColumn(4).setMinWidth(100);
            tb_data.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_data.getColumnModel().getColumn(4).setMaxWidth(100);
            tb_data.getColumnModel().getColumn(5).setMinWidth(100);
            tb_data.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_data.getColumnModel().getColumn(5).setMaxWidth(100);
            tb_data.getColumnModel().getColumn(6).setMinWidth(100);
            tb_data.getColumnModel().getColumn(6).setPreferredWidth(100);
            tb_data.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(cbYear, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(cbClassRoom, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(cbUser, gridBagConstraints);

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable1.setText("ສົກຮຽນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(joLable1, gridBagConstraints);

        joLable2.setText("ຫ້ອງຮຽນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(joLable2, gridBagConstraints);

        joLable3.setText("ຜູ້ໃຊ້ງານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(joLable3, gridBagConstraints);

        btnsearch.setText("ສະແດງ");
        btnsearch.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(btnsearch, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblMoney.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMoney.setText("ເງິນສົດ");
        lblMoney.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel2.add(lblMoney, gridBagConstraints);

        btnPrint.setBackground(new java.awt.Color(0, 102, 51));
        btnPrint.setText("Excel");
        btnPrint.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btnPrint.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.GRID_ON);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel2.add(btnPrint, gridBagConstraints);

        lblTransferMoney.setText("ເງິນໂອນ");
        lblTransferMoney.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 20);
        jPanel2.add(lblTransferMoney, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1148, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnPrint;
    private Components.JoButtonIconfont btn_back;
    private Components.JoButtonIconfont btnsearch;
    private Components.JoCombobox cbClassRoom;
    private Components.JoCombobox cbUser;
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
    private Components.JoLable lblMoney;
    private Components.JoLable lblTransferMoney;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    // End of variables declaration//GEN-END:variables

}
