package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import DAOSevervice.TeacherMoneyService;
import DAOSevervice.TeacherRankService;
import Model.GlobalDataModel;
import Model.TeacherModel;
import Model.TeacherMoneyModel;
import Model.TeacherRankModel;
import Model.YearModel;
import Tools.JoDataTable;
import Tools.JoIconFont;
import Utility.MyFormat;
import Utility.MyPopup;
import java.awt.event.MouseListener;
import java.util.List;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.MyColor;

public class TeacherRinkView extends javax.swing.JPanel {

    private PnLoading loading = new PnLoading();
    private TeacherRankService rankService = new TeacherRankService();
    private TeacherMoneyService moneyService = new TeacherMoneyService();
    private MyPopup popup = new MyPopup();

    public TeacherRinkView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        loading.setTitle("ໂຫຼດຂໍ້ມູນຄູສອນ");
        popup.getItemshow().setText("ຈັດອັນດັບ");
        popup.getItemEdit().setText("ເງິນລາງວັນ");
        popup.getItemDelete().setText("ຖອນເງິນ");
        popup.getItemshow().setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.LOCAL_ACTIVITY, 20, MyColor.blue700));
        popup.getItemEdit().setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.ADD_CIRCLE, 20, MyColor.green700));
        popup.getItemDelete().setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.REMOVE_CIRCLE, 20, MyColor.red700));
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtnShow() {
        return btnShow;
    }

    public JoCombobox getCbYear() {
        return cbYear;
    }

    public MyPopup getPopup() {
        return popup;
    }

    public void TeacherEvent(MouseListener e) {
        tbTeacher.addMouseListener(e);
    }

    public JoTable getTbTeacher() {
        return tbTeacher;
    }

    public int getTeacherID() {
        return tbTeacher.getIntValue(1);
    }

    public int getYearID() {
        return cbYear.getKeyInt();
    }

    public int getMonthID() {
        return Integer.parseInt(cbMonth.getValue());
    }

    public void showTeacher(List<TeacherModel> models, YearModel yearModel) {
        tbTeacher.JoClearModel();
        Thread thread = new Thread(() -> {
            GlobalDataModel.rootView.setView(loading);
            try {
                models.forEach(data -> {
                    TeacherRankModel rankModel = rankService.getTeacherRankByTeacherId(data.getTeacherID(), yearModel.getYearID(), Integer.parseInt(cbMonth.getValue()));
                    TeacherMoneyModel moneyModel = moneyService.readTeacherID(data.getTeacherID());
                    tbTeacher.AddJoModel(new Object[]{
                        tbTeacher.autoNumber(),
                        data.getTeacherID(),
                        data.getFullName(),
                        rankModel.getRank() == 0 ? "ບໍ່ມີອັນດັບ" : "ອັນດັບ " + rankModel.getRank(),
                        rankModel.getMonth(),
                        yearModel.getYear(),
                        new MyFormat().formatMoney(moneyModel.getMoney())
                    });
                    loading.StartProgress(models.size(), 100);
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                loading.close();
                GlobalDataModel.rootView.setView(this);
                pn_Datatable.removeAll();
                pn_Datatable.add(jScrollPane2);
                JoDataTable dataTable = new JoDataTable(pn_Datatable);
                dataTable.setHiddenColumns(1);
                dataTable.showDataTableAll();
            }
        });
        thread.start();
    }

    public void showYear(List<YearModel> models) {
        cbYear.JoClearData();
        models.forEach(data -> {
            cbYear.JoAddIntModel(data.getYearID(), data.getYear());
        });
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTeacher = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        cbYear = new Components.JoCombobox();
        btnShow = new Components.JoButtonIconfont();
        joLable2 = new Components.JoLable();
        cbMonth = new Components.JoCombobox();

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

        tbTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "TeacherID", "ຊື່ ແລະ ນາມສະກຸນ", "ຈັດອັນດັບ", "ເດືອນ", "ສົກຮຽນ", "ຈຳນວນເງິນສະສົມ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbTeacher);

        pn_Datatable.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable1.setText("ສົກປີຮຽນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(joLable1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 2);
        jPanel1.add(cbYear, gridBagConstraints);

        btnShow.setText("ສະແດງ");
        btnShow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 10);
        jPanel1.add(btnShow, gridBagConstraints);

        joLable2.setText("ເດືອນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(joLable2, gridBagConstraints);

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbMonth.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 2);
        jPanel1.add(cbMonth, gridBagConstraints);

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
    private Components.JoButtonIconfont btnShow;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbMonth;
    private Components.JoCombobox cbYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tbTeacher;
    // End of variables declaration//GEN-END:variables

}
