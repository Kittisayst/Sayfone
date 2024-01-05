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
import Tools.JoAlert;
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
        repaint();
        revalidate();
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
            lable.setFont(new Font("Phetsarath OT", 0, 18));
            lable.setForeground(new Color(153, 255, 204));
            pnSelectMonths.add(lable);
            pnShowMonth.revalidate();
        });
    }

    public void showFinancial(List<FinancialModel> models) {
        tb_data.JoClearModel();
        MyFormat format = new MyFormat();
        UserService userService = new UserService();
        models.forEach(data -> {
            setSelectMonth(data);
            UserModel um = userService.getUserById(data.getUserID());
            String money = format.formatMoney(data.getMoney());
            String transfer = format.formatMoney(data.getTransferMoney());
            tb_data.AddJoModel(new Object[]{
                tb_data.autoNumber(),
                data.getFinancialIID(),
                format.getDate(data.getFinancialDate()),
                money,
                transfer,
                toMonthString(data.getFinancialMonth()),
                data.getFinancialComment(),
                um.getFullName()
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
                    checkBox.setFont(new Font("phetsarath ot", 0, 14));
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
                    checkBox.setFont(new Font("phetsarath ot", 0, 14));
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

    public JPanel getPnShowMonth() {
        return pnShowMonth;
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
        lblshowDate = new Components.JoLable();
        joPanel4 = new Components.JoPanel();
        joLable6 = new Components.JoLable();
        txtMoney = new Components.JoTextField();
        joLable5 = new Components.JoLable();
        btnSave = new Components.JoButtonIconfont();
        pnSelectMonths = new javax.swing.JPanel();
        txtTransferMoney = new Components.JoTextField();
        joLable8 = new Components.JoLable();
        btnAddTransfer = new Components.JoButton();
        btnRefresh = new Components.JoButtonIconfont();
        pn_Datatable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Components.JoTable();

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
        gridBagConstraints.ipadx = 520;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(Pn_Navigation, gridBagConstraints);

        lbl_parents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_parents.setText("info");
        lbl_parents.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 812;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(lbl_parents, gridBagConstraints);

        joPanel2.setPreferredSize(new java.awt.Dimension(330, 300));
        joPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ເດືອນທີ່ຈ່າຍຄ່າຮຽນແລ້ວ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        joPanel2.add(joLable1);

        pnShowMonth.setOpaque(false);
        pnShowMonth.setPreferredSize(new java.awt.Dimension(250, 200));
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

        joPanel2.add(pnShowMonth);

        jPanel1.add(joPanel2);

        joPanel3.setJoPrimaryColor(new java.awt.Color(234, 234, 234));
        joPanel3.setJoSecondaryColor(new java.awt.Color(234, 234, 234));
        joPanel3.setMinimumSize(new java.awt.Dimension(360, 280));
        joPanel3.setPreferredSize(new java.awt.Dimension(330, 300));
        java.awt.GridBagLayout joPanel3Layout = new java.awt.GridBagLayout();
        joPanel3Layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        joPanel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        joPanel3.setLayout(joPanel3Layout);

        joLable7.setText("ໝາຍເຫດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(joLable7, gridBagConstraints);

        txtDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDiscount.setEnabled(false);
        txtDiscount.setNumberOnly(true);
        txtDiscount.setPlaceholder("ສ່ວນຫຼຸດ");
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(txtDiscount, gridBagConstraints);

        txtComment.setRows(3);
        jScrollPane2.setViewportView(txtComment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 10, 3);
        joPanel3.add(jScrollPane2, gridBagConstraints);

        txtOverPay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtOverPay.setNumberOnly(true);
        txtOverPay.setPlaceholder("ຄ່າຈ່າຍຊ້າ");
        txtOverPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOverPayKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(txtOverPay, gridBagConstraints);

        lblfood.setText("ອາຫານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(lblfood, gridBagConstraints);

        ckDiscount.setText("ສ່ວນຫຼຸດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(ckDiscount, gridBagConstraints);

        lblUserAuth.setBackground(new java.awt.Color(51, 51, 51));
        lblUserAuth.setForeground(new java.awt.Color(255, 153, 153));
        lblUserAuth.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(lblUserAuth, gridBagConstraints);

        lblslow.setText("ຄ່າຈ່າຍຊ້າ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(lblslow, gridBagConstraints);

        txtFood.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFood.setPlaceholder("ອາຫານ");
        txtFood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFoodKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(txtFood, gridBagConstraints);

        lblshowDate.setForeground(new java.awt.Color(25, 118, 210));
        lblshowDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblshowDate.setText("ວັນທີ");
        lblshowDate.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        joPanel3.add(lblshowDate, gridBagConstraints);

        jPanel1.add(joPanel3);

        joPanel4.setJoPrimaryColor(new java.awt.Color(234, 234, 234));
        joPanel4.setJoSecondaryColor(new java.awt.Color(234, 234, 234));
        joPanel4.setMinimumSize(new java.awt.Dimension(350, 271));
        joPanel4.setPreferredSize(new java.awt.Dimension(330, 300));
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

        btnSave.setBackground(new java.awt.Color(0, 153, 102));
        btnSave.setText("ບັນທຶກການຈ່າຍຄ້າຮຽນ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        joPanel4.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 270, -1));

        pnSelectMonths.setBackground(new java.awt.Color(51, 51, 51));
        pnSelectMonths.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        pnSelectMonths.setToolTipText("");
        pnSelectMonths.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnSelectMonths.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));
        joPanel4.add(pnSelectMonths, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35, 270, 50));

        txtTransferMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTransferMoney.setNumberOnly(true);
        txtTransferMoney.setPlaceholder("ຈຳນວນເງິນໂອນ");
        txtTransferMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTransferMoneyKeyReleased(evt);
            }
        });
        joPanel4.add(txtTransferMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 160, 40));

        joLable8.setText("ຈຳນວນເງິນສົດ");
        joPanel4.add(joLable8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, -1));

        btnAddTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/bcel.png"))); // NOI18N
        joPanel4.add(btnAddTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 50, 40));

        btnRefresh.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.REFRESH);
        joPanel4.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 179, 45, -1));

        jPanel1.add(joPanel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ເລກທີບິນ", "ວດປ", "ຈຳນວນເງິນສົດ", "ຈຳນວນເງິນໂອນ", "ເດືອນ", "ໝາຍເຫດ", "ຜູ້ລົງບັນຊີ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
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
            tb_data.getColumnModel().getColumn(7).setMinWidth(150);
            tb_data.getColumnModel().getColumn(7).setPreferredWidth(150);
            tb_data.getColumnModel().getColumn(7).setMaxWidth(150);
        }

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 834;
        gridBagConstraints.ipady = 140;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(pn_Datatable, gridBagConstraints);
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
    private Components.JoButtonIconfont btnRefresh;
    private Components.JoButtonIconfont btnSave;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCheckBox ckDiscount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
