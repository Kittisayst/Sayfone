package View;

import Components.JoButtonIconfont;
import Components.JoTable;
import Components.JoTextField;
import Model.GlobalDataModel;
import Model.StudentModel;
import Utility.MyFormat;
import java.awt.Color;
import java.util.List;
import theme.JoTheme;

public class FinancailStudentView extends javax.swing.JPanel {

    private boolean buttonState = true;
    private PnLoading loading = new PnLoading();

    public FinancailStudentView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        loading.setTitle("ໂຫຼດຂໍ້ມູນນັກຮຽນ");
        jPanel2.setVisible(false);
        jPanel6.setVisible(false);
        btnRegistered.setVisible(false);
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

    public JoButtonIconfont getBtnRegister() {
        return btnRegister;
    }

    public JoButtonIconfont getBtnRegistered() {
        return btnRegistered;
    }

    public boolean isButtonState() {
        return buttonState;
    }

    public JoTextField getTxtCurrentPage() {
        return txtCurrentPage;
    }

    public void showCurrentPage(int currentNumber, int totalPages) {
        int sum = totalPages;
        lblCurrentPage.setText("ໜ້າ: " + currentNumber + " / " + sum);
        txtCurrentPage.setText("" + currentNumber);
    }

    public void setButtonState(boolean buttonState) {
        this.buttonState = buttonState;
        Color colregistered = buttonState ? new Color(255, 0, 51) : JoTheme.Primary;
        Color colregister = buttonState ? JoTheme.Primary : new Color(255, 0, 51);
        btnRegister.setBackground(colregister);
        btnRegistered.setBackground(colregistered);
    }

    public void showStudentAll(List<StudentModel> models) {
        tb_data.JoClearModel();
        GlobalDataModel.rootView.setView(loading);
        Thread thread = new Thread(() -> {
            try {
                if (GlobalDataModel.TableStudentRegistered == null) {
                    models.forEach(data -> {
                        if (data.getStudentID() > 0) {
                            Object[] tableData = new Object[]{
                                tb_data.autoNumber(),
                                data.getStudentID(),
                                data.getStudentNo(),
                                data.getFullName(),
                                data.getDateStart() == null ? "ວ່າງ" : new MyFormat().getDate(data.getDateStart())
                            };
                            tb_data.AddJoModel(tableData);
                            loading.StartProgress(models.size(), 10);
                        }
                    });
                    GlobalDataModel.TableStudentRegistered = tb_data.getJoModel();
                } else {
                    tb_data.setModel(GlobalDataModel.TableStudentRegistered);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                GlobalDataModel.rootView.setView(this);
                loading.close();
            }
        });
        thread.start();
    }

    public JoButtonIconfont getBtnSearch() {
        return btnSearch;
    }

    public JoTextField getTxtSearch() {
        return txtSearch;
    }

    public JoButtonIconfont getBtnNext() {
        return btnNext;
    }

    public JoButtonIconfont getBtnPrevious() {
        return btnPrevious;
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
        btn_add = new Components.JoButtonIconfont();
        pn_Datatable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        btnRegister = new Components.JoButtonIconfont();
        btnRegistered = new Components.JoButtonIconfont();
        jPanel2 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        txtSearch = new Components.JoTextField();
        btnSearch = new Components.JoButtonIconfont();
        jPanel6 = new javax.swing.JPanel();
        btnPrevious = new Components.JoButtonIconfont();
        btnNext = new Components.JoButtonIconfont();
        txtCurrentPage = new Components.JoTextField();
        lblCurrentPage = new Components.JoLable();

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

        btn_add.setText("ລົງທະບຽນ");
        btn_add.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ADD_CIRCLE);
        jPanel5.add(btn_add);

        Pn_Navigation.add(jPanel5);

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ", "ວັນທີ່ເຂົ້າຮຽນ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_data.setJoBackgoundHead(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(tb_data);
        if (tb_data.getColumnModel().getColumnCount() > 0) {
            tb_data.getColumnModel().getColumn(1).setMinWidth(0);
            tb_data.getColumnModel().getColumn(1).setPreferredWidth(0);
            tb_data.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnRegister.setBackground(new java.awt.Color(255, 0, 51));
        btnRegister.setText("ລາຍຊື່ຍັງບໍ່ລົງທະບຽນ");
        btnRegister.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PERSON_ADD);
        jPanel1.add(btnRegister);

        btnRegistered.setText("ລາຍຊື່ທີ່ລົງທະບຽນແລ້ວ");
        btnRegistered.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.RECENT_ACTORS);
        jPanel1.add(btnRegistered);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(25, 118, 210)));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        joLable1.setText("ຄົ້ນຫາ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel2.add(joLable1);

        txtSearch.setPlaceholder("ຄົ້ນຫາ");
        jPanel2.add(txtSearch);

        btnSearch.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        btnSearch.setLabel("ຄົ້ນຫາ");
        jPanel2.add(btnSearch);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        btnPrevious.setText("ກ່ອນໜ້າ");
        btnPrevious.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ARROW_BACK);
        btnPrevious.setPreferredSize(new java.awt.Dimension(109, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel6.add(btnPrevious, gridBagConstraints);

        btnNext.setText("ໜ້າຕໍ່ໄປ");
        btnNext.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ARROW_FORWARD);
        btnNext.setPreferredSize(new java.awt.Dimension(109, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel6.add(btnNext, gridBagConstraints);

        txtCurrentPage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCurrentPage.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        txtCurrentPage.setNumberOnly(true);
        txtCurrentPage.setPlaceholder("ໜ້າທີ");
        txtCurrentPage.setPreferredSize(new java.awt.Dimension(80, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel6.add(txtCurrentPage, gridBagConstraints);

        lblCurrentPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrentPage.setText("ໜ້າທີ: 1");
        lblCurrentPage.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel6.add(lblCurrentPage, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnNext;
    private Components.JoButtonIconfont btnPrevious;
    private Components.JoButtonIconfont btnRegister;
    private Components.JoButtonIconfont btnRegistered;
    private Components.JoButtonIconfont btnSearch;
    private Components.JoButtonIconfont btn_add;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable lblCurrentPage;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    private Components.JoTextField txtCurrentPage;
    private Components.JoTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
