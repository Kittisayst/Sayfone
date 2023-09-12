package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoDateChooser;
import Components.JoTable;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.StudentModel;
import Model.UserModel;
import Model.YearModel;
import Tools.JoDataTable;
import Utility.MyFormat;
import java.util.List;

public class ReportUserFainancialView extends javax.swing.JPanel {

    public ReportUserFainancialView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public void showYear(List<YearModel> models) {
        cbYear.JoClearData();
        models.forEach(data -> {
            cbYear.JoAddIntModel(data.getYearID(), data.getYear());
        });
    }

    public void showUser(List<UserModel> models) {
        cbUser.JoClearData();
        models.forEach(data -> {
            cbUser.JoAddIntModel(data.getUserID(), data.getFullName().toString());
        });
    }

    public void showUserFinancial(List<FinancialModel> models) {
        tb_data.JoClearModel();
        StudentService service = new StudentService();
        MyFormat format = new MyFormat();
        models.forEach(data -> {
            if (data.getMoney() > 0 || data.getTransferMoney() > 0) {
                StudentModel model = service.getStudentById(data.getStudentID());
                tb_data.AddJoModel(new Object[]{
                    tb_data.autoNumber(),
                    data.getFinancialIID(),
                    model.getFullName(),
                    data.getFinancialMonth(),
                    format.getDate(data.getFinancialDate()),
                    format.formatMoney(data.getMoney()),
                    format.formatMoney(data.getTransferMoney()),
                    data.getFinancialComment().equals("") ? "ບໍ່ມີ" : data.getFinancialComment()
                });
            }
        });
        updateTable();
    }

    private void updateTable() {
        pn_Datatable.removeAll();
        pn_Datatable.add(jScrollPane1);
        JoDataTable dataTable = new JoDataTable(pn_Datatable);
        dataTable.showDataTableAll();
        dataTable.setHiddenColumns(1);
    }

    public JoDateChooser getDtEnd() {
        return dtEnd;
    }

    public JoDateChooser getDtStart() {
        return dtStart;
    }

    public JoCombobox getCbYear() {
        return cbYear;
    }

    public JoCombobox getCbUser() {
        return cbUser;
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
        joLable3 = new Components.JoLable();
        dtStart = new Components.JoDateChooser();
        joLable4 = new Components.JoLable();
        dtEnd = new Components.JoDateChooser();
        joLable1 = new Components.JoLable();
        cbYear = new Components.JoCombobox();
        joLable2 = new Components.JoLable();
        cbUser = new Components.JoCombobox();
        btnShow = new Components.JoButtonIconfont();

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
                "#", "FinancailID", "ຊື່ ແລະ ນາມສະກຸນ", "ຈ່າຍເດືອນ", "ວັນທີເດືອນປີ", "ເງິນສົດ", "ເງິນໂອນ", "ໝາຍເຫດ"
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
            tb_data.getColumnModel().getColumn(1).setMinWidth(80);
            tb_data.getColumnModel().getColumn(1).setPreferredWidth(80);
            tb_data.getColumnModel().getColumn(1).setMaxWidth(80);
            tb_data.getColumnModel().getColumn(2).setMinWidth(200);
            tb_data.getColumnModel().getColumn(2).setPreferredWidth(200);
            tb_data.getColumnModel().getColumn(2).setMaxWidth(200);
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

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        joLable3.setText("ເລິ່ມວັນທີ");
        jPanel1.add(joLable3);

        dtStart.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(dtStart);

        joLable4.setText("ຈົນເຖິງວັນທີ");
        jPanel1.add(joLable4);

        dtEnd.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel1.add(dtEnd);

        joLable1.setText("ສົກຮຽນ");
        jPanel1.add(joLable1);

        cbYear.setPreferredSize(new java.awt.Dimension(100, 38));
        jPanel1.add(cbYear);

        joLable2.setText("ຜຸ້ໃຊ້ງານ");
        jPanel1.add(joLable2);

        cbUser.setPreferredSize(new java.awt.Dimension(150, 38));
        jPanel1.add(cbUser);

        btnShow.setText("ສະແດງ");
        btnShow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        jPanel1.add(btnShow);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnShow;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbUser;
    private Components.JoCombobox cbYear;
    private Components.JoDateChooser dtEnd;
    private Components.JoDateChooser dtStart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    // End of variables declaration//GEN-END:variables
}
