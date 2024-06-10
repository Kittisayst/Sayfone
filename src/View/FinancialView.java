package View;

import Component.CheckboxMonths;
import Components.JoButton;
import Components.JoButtonIconfont;
import Components.JoCheckBox;
import Components.JoTable;
import Components.JoTextArea;
import Components.JoTextField;
import DAOSevervice.UserService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.StudentHistoryModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoIconFont;
import Utility.MyFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;

public class FinancialView extends javax.swing.JPanel {

    MyFormat format = new MyFormat();

    public FinancialView(String Title) {
        initComponents();
        System.out.println(GlobalDataModel.settingModel);
        lbl_title.setText(Title);
        lblUserAuth.setVisible(false);
        lblfood.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.LOCAL_DINING, 20));
        lblslow.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.SLOW_MOTION_VIDEO, 20));
        repaint();
        revalidate();
    }

    public void showParent(StudentHistoryModel historyModel) {
        lbl_parents.setText("ຜູ້ປົກຄອງ: " + historyModel.getFatherName() + " ເບີໂທ: " + historyModel.getFatherTel());
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

    int sumMoney = 0;
    int sumMoneyTransfer = 0;
    int sumMoneyFood = 0;

    public void showFinancial(List<FinancialModel> models) {
        tb_data.JoClearModel();
        UserService userService = new UserService();
        models.forEach(data -> {
            FinancialMonths.setSelectMonth(data.getFinancialMonth());
            foodMonths.setSelectMonth(data.getFoodMonth());
            UserModel um = userService.getUserById(data.getUserID());
            String money = format.formatMoney(data.getMoney());
            String transfer = format.formatMoney(data.getTransferMoney());
            sumMoney += data.getMoney();
            sumMoneyTransfer += data.getTransferMoney();
            sumMoneyFood += data.getFoodMoney();
            tb_data.AddJoModel(new Object[]{
                tb_data.autoNumber(),
                data.getFinancialIID(),
                format.getDate(data.getFinancialDate()),
                money,
                transfer,
                toMonthString(data.getFinancialMonth()),
                format.formatMoney(data.getFoodMoney()),
                data.getFoodMonth(),
                data.getFinancialComment(),
                um.getFullName()
            });
        });
        showSumMoney();
    }

    private void showSumMoney() {
        int sum = sumMoney + sumMoneyTransfer;
        lblMoney.setText(format.formatMoney(sum));
        lblFoodMoney.setText(format.formatMoney(sumMoneyFood));
    }

    public void showFinacial(FinancialModel financialModel) {
        MyFormat format = new MyFormat();
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

    public void setButtonState() {
        btnSave.setEnabled(!txtMoney.getText().isBlank() || !txtTransferMoney.getText().isBlank());
        btnAddTransfer.setEnabled(!txtTransferMoney.getText().isBlank() && !txtTransferMoney.getText().equals("0"));
        btnRefresh.setEnabled(btnAddTransfer.isEnabled());
    }

    public void setButtonTextState(String text) {
        btnSave.setText(text);
    }

    public void Message(String Title, String message, JoAlert.Icons icons) {
        new JoAlert().messages(Title, message, icons);
    }

    public boolean MoneyEmpty() {
        return txtMoney.getText().isEmpty();
    }

    public boolean TransferMoneyEmpty() {
        return txtTransferMoney.getText().isEmpty() || txtTransferMoney.getText().equals("0");
    }

    public boolean FoodMoney() {
        return (int) new MyFormat().unFormatMoney(txtFood.getText()) > 0 && foodMonths.isEmptySelect();
    }

    public int getMoney() {
        return (int) new MyFormat().unFormatMoney(txtMoney.getText());
    }

    public int getTransferMoney() {
        return (int) new MyFormat().unFormatMoney(txtTransferMoney.getText());
    }

    public boolean getTransferMoneyZero() {
        return txtTransferMoney.getText().equals("0");
    }

    public int getDiscount() {
        return (int) new MyFormat().unFormatMoney(txtDiscount.getText());
    }

    public int getOverPay() {
        return (int) new MyFormat().unFormatMoney(txtOverPay.getText());
    }

    public int getFoodMoney() {
        return (int) new MyFormat().unFormatMoney(txtFood.getText());
    }

    public String getComment() {
        return txtComment.getText();
    }

    public boolean TransferMoneyIsNull() {
        return txtTransferMoney.TextEmpty();
    }

    public boolean MoneyIsnull() {
        return txtMoney.TextEmpty();
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

    public JoCheckBox getCkDiscount() {
        return ckDiscount;
    }

    public JoButton getBtnAddTransfer() {
        return btnAddTransfer;
    }

    public JoButtonIconfont getBtnRefresh() {
        return btnRefresh;
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

    public CheckboxMonths getFoodMonths() {
        return foodMonths;
    }

    public CheckboxMonths getFinancialMonths() {
        return FinancialMonths;
    }

    public JoButtonIconfont getBtnExport() {
        return btnExport;
    }

    public String getExportName() {
        return lbl_title.getText();
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
        lbl_parents = new Components.JoLable();
        jPanel1 = new javax.swing.JPanel();
        joPanel2 = new Components.JoPanel();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        foodMonths = new Component.CheckboxMonths();
        jSeparator1 = new javax.swing.JSeparator();
        FinancialMonths = new Component.CheckboxMonths();
        joPanel3 = new Components.JoPanel();
        joLable7 = new Components.JoLable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComment = new Components.JoTextArea();
        lblUserAuth = new Components.JoLable();
        lblshowDate = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        lblslow = new Components.JoLable();
        ckDiscount = new Components.JoCheckBox();
        lblfood = new Components.JoLable();
        jPanel6 = new javax.swing.JPanel();
        txtOverPay = new Components.JoTextField();
        txtDiscount = new Components.JoTextField();
        txtFood = new Components.JoTextField();
        joPanel4 = new Components.JoPanel();
        joLable6 = new Components.JoLable();
        txtMoney = new Components.JoTextField();
        joLable5 = new Components.JoLable();
        btnSave = new Components.JoButtonIconfont();
        pnSelectMonths = new javax.swing.JPanel();
        joLable8 = new Components.JoLable();
        jPanel7 = new javax.swing.JPanel();
        txtTransferMoney = new Components.JoTextField();
        jPanel8 = new javax.swing.JPanel();
        btnAddTransfer = new Components.JoButton();
        btnRefresh = new Components.JoButtonIconfont();
        pn_Datatable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Components.JoTable();
        jPanel2 = new javax.swing.JPanel();
        joLable10 = new Components.JoLable();
        lblMoney = new Components.JoLable();
        joLable4 = new Components.JoLable();
        lblFoodMoney = new Components.JoLable();
        btnExport = new Components.JoButtonIconfont();

        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(0, 0));
        setLayout(new java.awt.GridBagLayout());

        Pn_Navigation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Pn_Navigation.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btn_back.setText("ກັບຄືນ");
        btn_back.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ARROW_BACK);
        jPanel3.add(btn_back);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        Pn_Navigation.add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        lbl_title.setText("Title");
        lbl_title.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel4.add(lbl_title);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        Pn_Navigation.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        add(Pn_Navigation, gridBagConstraints);

        lbl_parents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_parents.setText("info");
        lbl_parents.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(lbl_parents, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(1127, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(990, 350));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        joPanel2.setPreferredSize(new java.awt.Dimension(330, 300));
        joPanel2.setLayout(new java.awt.GridBagLayout());

        joLable1.setForeground(new java.awt.Color(0, 0, 204));
        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ຈ່າຍຄ່າຮຽນເດືອນ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        joPanel2.add(joLable1, gridBagConstraints);

        joLable2.setForeground(new java.awt.Color(204, 153, 0));
        joLable2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable2.setText("ຈ່າຍຄ່າອາຫານເດືອນ");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        joPanel2.add(joLable2, gridBagConstraints);

        foodMonths.setBackground(new java.awt.Color(255, 255, 153));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        joPanel2.add(foodMonths, gridBagConstraints);

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        joPanel2.add(jSeparator1, gridBagConstraints);

        FinancialMonths.setBackground(new java.awt.Color(153, 204, 255));
        FinancialMonths.setMinimumSize(new java.awt.Dimension(200, 174));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        joPanel2.add(FinancialMonths, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(joPanel2, gridBagConstraints);

        joPanel3.setJoPrimaryColor(new java.awt.Color(234, 234, 234));
        joPanel3.setJoSecondaryColor(new java.awt.Color(234, 234, 234));
        joPanel3.setMinimumSize(new java.awt.Dimension(360, 280));
        joPanel3.setPreferredSize(new java.awt.Dimension(330, 300));
        joPanel3.setLayout(new java.awt.GridBagLayout());

        joLable7.setText("ໝາຍເຫດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 11);
        joPanel3.add(joLable7, gridBagConstraints);

        txtComment.setRows(3);
        jScrollPane2.setViewportView(txtComment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 11);
        joPanel3.add(jScrollPane2, gridBagConstraints);

        lblUserAuth.setBackground(new java.awt.Color(51, 51, 51));
        lblUserAuth.setForeground(new java.awt.Color(255, 153, 153));
        lblUserAuth.setMinimumSize(new java.awt.Dimension(0, 40));
        lblUserAuth.setOpaque(true);
        lblUserAuth.setPreferredSize(new java.awt.Dimension(0, 40));
        lblUserAuth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserAuthMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 11);
        joPanel3.add(lblUserAuth, gridBagConstraints);

        lblshowDate.setForeground(new java.awt.Color(25, 118, 210));
        lblshowDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblshowDate.setText("ວັນທີ");
        lblshowDate.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 20, 11);
        joPanel3.add(lblshowDate, gridBagConstraints);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        lblslow.setText("ຄ່າຈ່າຍຊ້າ");
        jPanel5.add(lblslow);

        ckDiscount.setText("ສ່ວນຫຼຸດ");
        jPanel5.add(ckDiscount);

        lblfood.setText("ອາຫານ");
        jPanel5.add(lblfood);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        joPanel3.add(jPanel5, gridBagConstraints);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        txtOverPay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtOverPay.setMinimumSize(new java.awt.Dimension(100, 40));
        txtOverPay.setNumberOnly(true);
        txtOverPay.setPlaceholder("ຄ່າຈ່າຍຊ້າ");
        txtOverPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOverPayKeyReleased(evt);
            }
        });
        jPanel6.add(txtOverPay);

        txtDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDiscount.setEnabled(false);
        txtDiscount.setMinimumSize(new java.awt.Dimension(100, 40));
        txtDiscount.setNumberOnly(true);
        txtDiscount.setPlaceholder("ສ່ວນຫຼຸດ");
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        jPanel6.add(txtDiscount);

        txtFood.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFood.setMinimumSize(new java.awt.Dimension(100, 40));
        txtFood.setPlaceholder("ອາຫານ");
        txtFood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFoodKeyReleased(evt);
            }
        });
        jPanel6.add(txtFood);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        joPanel3.add(jPanel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        jPanel1.add(joPanel3, gridBagConstraints);

        joPanel4.setJoPrimaryColor(new java.awt.Color(234, 234, 234));
        joPanel4.setJoSecondaryColor(new java.awt.Color(234, 234, 234));
        joPanel4.setMinimumSize(new java.awt.Dimension(350, 271));
        joPanel4.setPreferredSize(new java.awt.Dimension(330, 300));
        joPanel4.setLayout(new java.awt.GridBagLayout());

        joLable6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joLable6.setText("ຈ່າຍຄ່າຮຽນປະຈຳເດືອນ");
        joLable6.setMinimumSize(new java.awt.Dimension(0, 30));
        joLable6.setPreferredSize(new java.awt.Dimension(0, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        joPanel4.add(joLable6, gridBagConstraints);

        txtMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMoney.setMinimumSize(new java.awt.Dimension(0, 40));
        txtMoney.setNumberOnly(true);
        txtMoney.setPlaceholder("ຈຳນວນເງິນສົດ");
        txtMoney.setPreferredSize(new java.awt.Dimension(0, 40));
        txtMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoneyKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 5, 0, 5);
        joPanel4.add(txtMoney, gridBagConstraints);

        joLable5.setText("ຈຳນວນເງິນໂອນ");
        joLable5.setMinimumSize(new java.awt.Dimension(0, 30));
        joLable5.setPreferredSize(new java.awt.Dimension(0, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        joPanel4.add(joLable5, gridBagConstraints);

        btnSave.setBackground(new java.awt.Color(0, 153, 102));
        btnSave.setText("ບັນທຶກການຈ່າຍຄ້າຮຽນ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.setMinimumSize(new java.awt.Dimension(0, 40));
        btnSave.setPreferredSize(new java.awt.Dimension(0, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        joPanel4.add(btnSave, gridBagConstraints);

        pnSelectMonths.setBackground(new java.awt.Color(51, 51, 51));
        pnSelectMonths.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        pnSelectMonths.setToolTipText("");
        pnSelectMonths.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnSelectMonths.setMinimumSize(new java.awt.Dimension(0, 40));
        pnSelectMonths.setPreferredSize(new java.awt.Dimension(0, 40));
        pnSelectMonths.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        joPanel4.add(pnSelectMonths, gridBagConstraints);

        joLable8.setText("ຈຳນວນເງິນສົດ");
        joLable8.setMinimumSize(new java.awt.Dimension(0, 30));
        joLable8.setPreferredSize(new java.awt.Dimension(0, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        joPanel4.add(joLable8, gridBagConstraints);

        jPanel7.setMinimumSize(new java.awt.Dimension(200, 40));
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(410, 40));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        txtTransferMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTransferMoney.setNumberOnly(true);
        txtTransferMoney.setPlaceholder("ຈຳນວນເງິນໂອນ");
        txtTransferMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTransferMoneyKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel7.add(txtTransferMoney, gridBagConstraints);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        btnAddTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/bcel.png"))); // NOI18N
        btnAddTransfer.setMinimumSize(new java.awt.Dimension(40, 40));
        btnAddTransfer.setPreferredSize(new java.awt.Dimension(40, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel8.add(btnAddTransfer, gridBagConstraints);

        btnRefresh.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.REFRESH);
        btnRefresh.setMinimumSize(new java.awt.Dimension(40, 40));
        btnRefresh.setPreferredSize(new java.awt.Dimension(40, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel8.add(btnRefresh, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel7.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        joPanel4.add(jPanel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        jPanel1.add(joPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ເລກທີບິນ", "ວດປ", "ຈຳນວນເງິນສົດ", "ຈຳນວນເງິນໂອນ", "ເດືອນຄ່າຮຽນ", "ເງິນຄ່າອາຫານ", "ເດືອນອາຫານ", "ໝາຍເຫດ", "ຜູ້ລົງບັນຊີ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            tb_data.getColumnModel().getColumn(2).setMinWidth(120);
            tb_data.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_data.getColumnModel().getColumn(2).setMaxWidth(120);
            tb_data.getColumnModel().getColumn(3).setMinWidth(120);
            tb_data.getColumnModel().getColumn(3).setPreferredWidth(120);
            tb_data.getColumnModel().getColumn(3).setMaxWidth(120);
            tb_data.getColumnModel().getColumn(4).setMinWidth(120);
            tb_data.getColumnModel().getColumn(4).setPreferredWidth(120);
            tb_data.getColumnModel().getColumn(4).setMaxWidth(120);
            tb_data.getColumnModel().getColumn(6).setMinWidth(120);
            tb_data.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_data.getColumnModel().getColumn(6).setMaxWidth(120);
            tb_data.getColumnModel().getColumn(9).setMinWidth(150);
            tb_data.getColumnModel().getColumn(9).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(9).setMaxWidth(150);
        }

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(pn_Datatable, gridBagConstraints);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        joLable10.setText("ຈ່າຍຄ່າຮຽນທັງໝົດ:");
        joLable10.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        jPanel2.add(joLable10);

        lblMoney.setText("0");
        lblMoney.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        jPanel2.add(lblMoney);

        joLable4.setText("ຈ່າຍຄ່າອາຫານ:");
        joLable4.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        jPanel2.add(joLable4);

        lblFoodMoney.setText("0");
        lblFoodMoney.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        jPanel2.add(lblFoodMoney);

        btnExport.setBackground(new java.awt.Color(0, 153, 102));
        btnExport.setText("Excel");
        btnExport.setJoIconSize(25);
        btnExport.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.GRID_ON);
        jPanel2.add(btnExport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jPanel2, gridBagConstraints);
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

    private void lblUserAuthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserAuthMouseClicked
        System.out.println(FinancialMonths.getMonths());
    }//GEN-LAST:event_lblUserAuthMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.CheckboxMonths FinancialMonths;
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButton btnAddTransfer;
    private Components.JoButtonIconfont btnExport;
    private Components.JoButtonIconfont btnRefresh;
    private Components.JoButtonIconfont btnSave;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCheckBox ckDiscount;
    private Component.CheckboxMonths foodMonths;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable10;
    private Components.JoLable joLable2;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable joLable7;
    private Components.JoLable joLable8;
    private Components.JoPanel joPanel2;
    private Components.JoPanel joPanel3;
    private Components.JoPanel joPanel4;
    private Components.JoLable lblFoodMoney;
    private Components.JoLable lblMoney;
    private Components.JoLable lblUserAuth;
    private Components.JoLable lbl_parents;
    private Components.JoLable lbl_title;
    private Components.JoLable lblfood;
    private Components.JoLable lblshowDate;
    private Components.JoLable lblslow;
    private javax.swing.JPanel pnSelectMonths;
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
