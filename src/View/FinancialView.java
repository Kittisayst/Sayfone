package View;

import Components.JoButton;
import Components.JoButtonIconfont;
import Components.JoCheckBox;
import Components.JoLable;
import Components.JoTable;
import Components.JoTextArea;
import Components.JoTextField;
import DAOSevervice.UserService;
import Model.FinancialModel;
import Model.StudentHistoryModel;
import Model.UserModel;
import Tools.JoIconFont;
import Utility.MyFormat;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;

public class FinancialView extends javax.swing.JPanel {

    public FinancialView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        lblUserAuth.setVisible(false);
        lblfood.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.LOCAL_DINING, 20));
        lblslow.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.SLOW_MOTION_VIDEO, 20));
    }

    public void showParent(StudentHistoryModel historyModel) {
        lbl_parents.setText("ຜູ້ປົກຄອງ: " + historyModel.getFatherName() + " ເບີໂທ: " + historyModel.getFatherTel());
    }

    public void showCurentMonth() {
        LocalDate currentDate = LocalDate.now();
        // Get the current month
        lblshowDate.setText(new MyFormat().getDate(new Date()));
        JComponent ckmonth = (JComponent) pnShowMonth.getComponent(currentDate.getMonthValue() - 1);
        ckmonth.setForeground(new Color(25, 118, 210));
    }

    public void EnableDisCount(UserModel model) { // ສະແດງຂໍ້ມູນຜູ້ອານຸມັດ
        txtDiscount.setEnabled(ckDiscount.isSelected());
        if (ckDiscount.isSelected()) {
            txtDiscount.requestFocus();
            lblUserAuth.setText("ຜຸ້ອານຸມັດ: " + model.getName());
            lblUserAuth.setVisible(ckDiscount.isSelected());
        } else {
            lblUserAuth.setVisible(ckDiscount.isSelected());
            txtDiscount.setText("");
        }
    }

    public void showSelectMonth(HashMap<Integer, String> months) {
        pnSelectMonths.removeAll();
        months.forEach((key, data) -> {
            JoLable lable = new JoLable();
            lable.setText(data);
            lable.setFont(new Font("Phetsarath OT", 0, 10));
            lable.setForeground(new Color(153, 255, 204));
            pnSelectMonths.add(lable);
            pnShowMonth.revalidate();
        });
    }

    public void showFinancial(List<FinancialModel> models) {
        MyFormat format = new MyFormat();
        models.forEach(data -> {
            setSelectMonth(data);
            tb_data.AddJoModel(new Object[]{
                tb_data.autoNumber(),
                data.getFinancialIID(),
                format.getDate(data.getFinancialDate()),
                format.formatMoney(data.getMoney()),
                format.formatMoney(data.getTransferMoney()),
                toMonthString(data.getFinancialMonth()),
                data.getFinancialComment()
            });
        });
    }

    public void setSelectMonth(FinancialModel model) {
        boolean isMonth = !model.getFinancialMonth().equals("[]");
        if (isMonth) {
            String[] arr = model.getFinancialMonth().substring(1, model.getFinancialMonth().length() - 1).split(", ");
            if (arr.length > 0) {
                for (String str : arr) {
                    JCheckBox checkBox = (JCheckBox) pnShowMonth.getComponent(Integer.parseInt(str) - 1);
                    checkBox.setSelected(true);
                    checkBox.setEnabled(false);
                }
            }
        }
    }

    public void setSelectMonthEnnable(FinancialModel model) {
        boolean isMonth = !model.getFinancialMonth().equals("[]");
        if (isMonth) {
            String[] arr = model.getFinancialMonth().substring(1, model.getFinancialMonth().length() - 1).split(", ");
            if (arr.length > 0) {
                for (String str : arr) {
                    JCheckBox checkBox = (JCheckBox) pnShowMonth.getComponent(Integer.parseInt(str) - 1);
                    checkBox.setSelected(true);
                    checkBox.setEnabled(true);
                }
            }
        }

    }

    public void showFinacial(FinancialModel financialModel) {
        MyFormat format = new MyFormat();
        setSelectMonthEnnable(financialModel);
        txtDiscount.setText(format.formatMoney(financialModel.getDiscount()));
        if (financialModel.getAuthenUserID() != 0) {
            ckDiscount.setSelected(true);
            EnableDisCount(new UserService().getUserById(financialModel.getAuthenUserID()));
        } else {
            ckDiscount.setSelected(false);
            EnableDisCount(new UserService().getUserById(financialModel.getAuthenUserID()));
        }
        txtOverPay.setText(format.formatMoney(financialModel.getOvertimePay()));
        txtComment.setText(financialModel.getFinancialComment());
        txtMoney.setText(format.formatMoney(financialModel.getMoney()));
        txtTransferMoney.setText(format.formatMoney(financialModel.getTransferMoney()));
        txtFood.setText(format.formatMoney(financialModel.getFoodMoney()));
    }

    private String toMonthString(String month) {
        boolean isMonth = !month.equals("[]");
        if (isMonth) {
            String str = month;
            str = str.replaceAll("\\[|\\]|\\s", ""); // remove square brackets and spaces
            String[] strArray = str.split(",");
            int[] intArray = new int[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i].trim());
            }
            return Arrays.toString(strArray);
        } else {
            return "[]";
        }
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public JPanel getPnSelectMonths() {
        return pnSelectMonths;
    }

    public JPanel getPnShowMonth() {
        return pnShowMonth;
    }

    public JoCheckBox getCkDiscount() {
        return ckDiscount;
    }

    public JoButton getBtnAddTransfer() {
        return btnAddTransfer;
    }

    public JoButtonIconfont getBtnSave() {
        return btnSave;
    }

    public JoTextField getTxtDiscount() {
        return txtDiscount;
    }

    public JoTextField getTxtMoney() {
        return txtMoney;
    }

    public JoTextArea getTxtComment() {
        return txtComment;
    }

    public JoTextField getTxtOverPay() {
        return txtOverPay;
    }

    public JoTextField getTxtFood() {
        return txtFood;
    }

    public JoTextField getTxtTransferMoney() {
        return txtTransferMoney;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        pn_Datatable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Components.JoTable();
        joPanel1 = new Components.JoPanel();
        lbl_parents = new Components.JoLable();
        joPanel2 = new Components.JoPanel();
        joLable1 = new Components.JoLable();
        pnShowMonth = new javax.swing.JPanel();
        joCheckBoxUI2 = new Components.JoCheckBoxUI();
        joCheckBoxUI1 = new Components.JoCheckBoxUI();
        joCheckBoxUI3 = new Components.JoCheckBoxUI();
        joCheckBoxUI4 = new Components.JoCheckBoxUI();
        joCheckBoxUI5 = new Components.JoCheckBoxUI();
        joCheckBoxUI6 = new Components.JoCheckBoxUI();
        joCheckBoxUI7 = new Components.JoCheckBoxUI();
        joCheckBoxUI8 = new Components.JoCheckBoxUI();
        joCheckBoxUI9 = new Components.JoCheckBoxUI();
        joCheckBoxUI10 = new Components.JoCheckBoxUI();
        joCheckBoxUI11 = new Components.JoCheckBoxUI();
        joCheckBoxUI12 = new Components.JoCheckBoxUI();
        joPanel3 = new Components.JoPanel();
        lblshowDate = new Components.JoLable();
        joLable7 = new Components.JoLable();
        txtDiscount = new Components.JoTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComment = new Components.JoTextArea();
        txtOverPay = new Components.JoTextField();
        lblfood = new Components.JoLable();
        ckDiscount = new Components.JoCheckBox();
        lblUserAuth = new Components.JoLable();
        lblslow = new Components.JoLable();
        txtFood = new Components.JoTextField();
        joPanel4 = new Components.JoPanel();
        joLable6 = new Components.JoLable();
        txtMoney = new Components.JoTextField();
        joLable5 = new Components.JoLable();
        btnSave = new Components.JoButtonIconfont();
        pnSelectMonths = new javax.swing.JPanel();
        txtTransferMoney = new Components.JoTextField();
        joLable8 = new Components.JoLable();
        btnAddTransfer = new Components.JoButton();

        setMaximumSize(new java.awt.Dimension(1920, 1080));

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
                "#", "ເລກທີບິນ", "ວດປ", "ຈຳນວນເງິນສົດ", "ຈຳນວນເງິນໂອນ", "ເດືອນ", "ໝາຍເຫດ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_data);

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        joPanel1.setJoPrimaryColor(new java.awt.Color(204, 204, 204));
        joPanel1.setJoSecondaryColor(new java.awt.Color(204, 204, 204));
        joPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_parents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_parents.setText("info");
        lbl_parents.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        joPanel1.add(lbl_parents, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 950, 30));

        joPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ເດືອນທີ່ຈ່າຍຄ່າຮຽນແລ້ວ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        joPanel2.add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 10, 240, -1));

        pnShowMonth.setOpaque(false);
        pnShowMonth.setLayout(new java.awt.GridLayout(4, 3, 5, 5));

        joCheckBoxUI2.setText("ເດືອນ 1");
        joCheckBoxUI2.setName("1"); // NOI18N
        pnShowMonth.add(joCheckBoxUI2);

        joCheckBoxUI1.setText("ເດືອນ 2");
        joCheckBoxUI1.setName("2"); // NOI18N
        pnShowMonth.add(joCheckBoxUI1);

        joCheckBoxUI3.setText("ເດືອນ 3");
        joCheckBoxUI3.setName("3"); // NOI18N
        pnShowMonth.add(joCheckBoxUI3);

        joCheckBoxUI4.setText("ເດືອນ 4");
        joCheckBoxUI4.setName("4"); // NOI18N
        pnShowMonth.add(joCheckBoxUI4);

        joCheckBoxUI5.setText("ເດືອນ 5");
        joCheckBoxUI5.setName("5"); // NOI18N
        pnShowMonth.add(joCheckBoxUI5);

        joCheckBoxUI6.setText("ເດືອນ 6");
        joCheckBoxUI6.setName("6"); // NOI18N
        pnShowMonth.add(joCheckBoxUI6);

        joCheckBoxUI7.setText("ເດືອນ 7");
        joCheckBoxUI7.setName("7"); // NOI18N
        pnShowMonth.add(joCheckBoxUI7);

        joCheckBoxUI8.setText("ເດືອນ 8");
        joCheckBoxUI8.setName("8"); // NOI18N
        pnShowMonth.add(joCheckBoxUI8);

        joCheckBoxUI9.setText("ເດືອນ 9");
        joCheckBoxUI9.setName("9"); // NOI18N
        pnShowMonth.add(joCheckBoxUI9);

        joCheckBoxUI10.setText("ເດືອນ 10");
        joCheckBoxUI10.setName("10"); // NOI18N
        pnShowMonth.add(joCheckBoxUI10);

        joCheckBoxUI11.setText("ເດືອນ 11");
        joCheckBoxUI11.setName("11"); // NOI18N
        pnShowMonth.add(joCheckBoxUI11);

        joCheckBoxUI12.setText("ເດືອນ 12");
        joCheckBoxUI12.setName("12"); // NOI18N
        pnShowMonth.add(joCheckBoxUI12);

        joPanel2.add(pnShowMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 60, 240, 210));

        joPanel1.add(joPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 290, 290));

        joPanel3.setJoPrimaryColor(new java.awt.Color(234, 234, 234));
        joPanel3.setJoSecondaryColor(new java.awt.Color(234, 234, 234));
        joPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblshowDate.setForeground(new java.awt.Color(25, 118, 210));
        lblshowDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblshowDate.setText("ວັນທີ");
        lblshowDate.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        joPanel3.add(lblshowDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 300, -1));

        joLable7.setText("ໝາຍເຫດ");
        joPanel3.add(joLable7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 168, 340, -1));

        txtDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDiscount.setEnabled(false);
        txtDiscount.setNumberOnly(true);
        txtDiscount.setPlaceholder("ສ່ວນຫຼຸດ");
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        joPanel3.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));

        txtComment.setRows(3);
        jScrollPane2.setViewportView(txtComment);

        joPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 340, 80));

        txtOverPay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtOverPay.setNumberOnly(true);
        txtOverPay.setPlaceholder("ຄ່າຈ່າຍຊ້າ");
        txtOverPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOverPayKeyReleased(evt);
            }
        });
        joPanel3.add(txtOverPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 110, -1));

        lblfood.setText("ອາຫານ");
        joPanel3.add(lblfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 45, 100, 30));

        ckDiscount.setText("ສ່ວນຫຼຸດ");
        joPanel3.add(ckDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 45, 120, 30));

        lblUserAuth.setBackground(new java.awt.Color(51, 51, 51));
        lblUserAuth.setForeground(new java.awt.Color(255, 153, 153));
        lblUserAuth.setOpaque(true);
        joPanel3.add(lblUserAuth, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 340, 30));

        lblslow.setText("ຄ່າຈ່າຍຊ້າ");
        joPanel3.add(lblslow, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 45, 110, 30));

        txtFood.setPlaceholder("ອາຫານ");
        txtFood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFoodKeyReleased(evt);
            }
        });
        joPanel3.add(txtFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 100, -1));

        joPanel1.add(joPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 60, 380, 290));

        joPanel4.setJoPrimaryColor(new java.awt.Color(234, 234, 234));
        joPanel4.setJoSecondaryColor(new java.awt.Color(234, 234, 234));
        joPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        joLable6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joLable6.setText("ຈ່າຍຄ່າຮຽນປະຈຳເດືອນ");
        joPanel4.add(joLable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        txtMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMoney.setNumberOnly(true);
        txtMoney.setPlaceholder("ຈຳນວນເງິນສົດ");
        txtMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoneyKeyReleased(evt);
            }
        });
        joPanel4.add(txtMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 270, -1));

        joLable5.setText("ຈຳນວນເງິນໂອນ");
        joPanel4.add(joLable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 270, 20));

        btnSave.setText("ບັນທຶກ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        joPanel4.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 270, -1));

        pnSelectMonths.setBackground(new java.awt.Color(51, 51, 51));
        pnSelectMonths.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        pnSelectMonths.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        joPanel4.add(pnSelectMonths, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35, 270, 50));

        txtTransferMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTransferMoney.setNumberOnly(true);
        txtTransferMoney.setPlaceholder("ຈຳນວນເງິນໂອນ");
        txtTransferMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTransferMoneyKeyReleased(evt);
            }
        });
        joPanel4.add(txtTransferMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 40));

        joLable8.setText("ຈຳນວນເງິນສົດ");
        joPanel4.add(joLable8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, -1));

        btnAddTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/bcel.png"))); // NOI18N
        joPanel4.add(btnAddTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 50, 40));

        joPanel1.add(joPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 310, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(joPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtOverPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOverPayKeyReleased
        txtOverPay.setText(new MyFormat().formatMoney(txtOverPay.getText()));
    }//GEN-LAST:event_txtOverPayKeyReleased

    private void txtMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoneyKeyReleased
        txtMoney.setText(new MyFormat().formatMoney(txtMoney.getText()));
    }//GEN-LAST:event_txtMoneyKeyReleased

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
        txtDiscount.setText(new MyFormat().formatMoney(txtDiscount.getText()));
    }//GEN-LAST:event_txtDiscountKeyReleased

    private void txtTransferMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTransferMoneyKeyReleased
        txtTransferMoney.setText(new MyFormat().formatMoney(txtTransferMoney.getText()));
    }//GEN-LAST:event_txtTransferMoneyKeyReleased

    private void txtFoodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFoodKeyReleased
        txtFood.setText(new MyFormat().formatMoney(txtFood.getText()));
    }//GEN-LAST:event_txtFoodKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButton btnAddTransfer;
    private Components.JoButtonIconfont btnSave;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.ButtonGroup buttonGroup1;
    private Components.JoCheckBox ckDiscount;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private Components.JoCheckBoxUI joCheckBoxUI1;
    private Components.JoCheckBoxUI joCheckBoxUI10;
    private Components.JoCheckBoxUI joCheckBoxUI11;
    private Components.JoCheckBoxUI joCheckBoxUI12;
    private Components.JoCheckBoxUI joCheckBoxUI2;
    private Components.JoCheckBoxUI joCheckBoxUI3;
    private Components.JoCheckBoxUI joCheckBoxUI4;
    private Components.JoCheckBoxUI joCheckBoxUI5;
    private Components.JoCheckBoxUI joCheckBoxUI6;
    private Components.JoCheckBoxUI joCheckBoxUI7;
    private Components.JoCheckBoxUI joCheckBoxUI8;
    private Components.JoCheckBoxUI joCheckBoxUI9;
    private Components.JoLable joLable1;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable joLable7;
    private Components.JoLable joLable8;
    private Components.JoPanel joPanel1;
    private Components.JoPanel joPanel2;
    private Components.JoPanel joPanel3;
    private Components.JoPanel joPanel4;
    private Components.JoLable lblUserAuth;
    private Components.JoLable lbl_parents;
    private Components.JoLable lbl_title;
    private Components.JoLable lblfood;
    private Components.JoLable lblshowDate;
    private Components.JoLable lblslow;
    private javax.swing.JPanel pnSelectMonths;
    private javax.swing.JPanel pnShowMonth;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    private Components.JoTextArea txtComment;
    private Components.JoTextField txtDiscount;
    private Components.JoTextField txtFood;
    private Components.JoTextField txtMoney;
    private Components.JoTextField txtOverPay;
    private Components.JoTextField txtTransferMoney;
    // End of variables declaration//GEN-END:variables

}
