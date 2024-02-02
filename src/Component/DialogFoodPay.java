package Component;

import Components.JoCheckBox;
import DAOSevervice.FoodPaymentService;
import Model.FoodPaymentModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoAlert;
import Utility.MonthCaculator;
import Utility.MyFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DialogFoodPay extends javax.swing.JDialog {

    private final RegisterModel registerModel;
    private final StudentModel studentModel;
    private final FoodPaymentModel paymentModel;
    private final List<Integer> numMonth = new ArrayList<>();
    private final MyFormat format = new MyFormat();
    private final JoAlert alert = new JoAlert();
    private final FoodPaymentService service = new FoodPaymentService();

    public DialogFoodPay(java.awt.Frame parent, boolean modal, RegisterModel registerModel, StudentModel studentModel, FoodPaymentModel paymentModel) {
        super(parent, modal);
        initComponents();
        this.registerModel = registerModel;
        this.studentModel = studentModel;
        this.paymentModel = paymentModel;
        CreateEvent();
        CheckboxVisible();
        showEdit();
    }

    private void CreateEvent() {
        for (int i = 0; i < pnMonth.getComponentCount(); i++) {
            final int index = i;
            JoCheckBox box = (JoCheckBox) pnMonth.getComponent(i);
            box.addActionListener((e) -> {
                int mon = index + 1;
                numMonth.add(box.isSelected() ? mon : 0);
                Collections.sort(numMonth);
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnMonth = new javax.swing.JPanel();
        joCheckBox2 = new Components.JoCheckBox();
        joCheckBox1 = new Components.JoCheckBox();
        joCheckBox7 = new Components.JoCheckBox();
        joCheckBox5 = new Components.JoCheckBox();
        joCheckBox11 = new Components.JoCheckBox();
        joCheckBox9 = new Components.JoCheckBox();
        joCheckBox3 = new Components.JoCheckBox();
        joCheckBox4 = new Components.JoCheckBox();
        joCheckBox6 = new Components.JoCheckBox();
        joCheckBox8 = new Components.JoCheckBox();
        joCheckBox10 = new Components.JoCheckBox();
        joCheckBox12 = new Components.JoCheckBox();
        jPanel3 = new javax.swing.JPanel();
        txtPrice = new Components.JoTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComment = new Components.JoTextArea();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new Components.JoButtonIconfont();
        joLable3 = new Components.JoLable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnMonth.setLayout(new java.awt.GridLayout(3, 4, 10, 10));

        joCheckBox2.setText("ເດືອນ 1");
        joCheckBox2.setName("1"); // NOI18N
        pnMonth.add(joCheckBox2);

        joCheckBox1.setText("ເດືອນ 2");
        joCheckBox1.setName("2"); // NOI18N
        pnMonth.add(joCheckBox1);

        joCheckBox7.setText("ເດືອນ 3");
        joCheckBox7.setName("3"); // NOI18N
        pnMonth.add(joCheckBox7);

        joCheckBox5.setText("ເດືອນ 4");
        joCheckBox5.setName("4"); // NOI18N
        pnMonth.add(joCheckBox5);

        joCheckBox11.setText("ເດືອນ 5");
        joCheckBox11.setName("5"); // NOI18N
        pnMonth.add(joCheckBox11);

        joCheckBox9.setText("ເດືອນ 6");
        joCheckBox9.setName("6"); // NOI18N
        pnMonth.add(joCheckBox9);

        joCheckBox3.setText("ເດືອນ 7");
        joCheckBox3.setName("7"); // NOI18N
        pnMonth.add(joCheckBox3);

        joCheckBox4.setText("ເດືອນ 8");
        joCheckBox4.setName("8"); // NOI18N
        pnMonth.add(joCheckBox4);

        joCheckBox6.setText("ເດືອນ 9");
        joCheckBox6.setName("9"); // NOI18N
        pnMonth.add(joCheckBox6);

        joCheckBox8.setText("ເດືອນ 10");
        joCheckBox8.setName("10"); // NOI18N
        pnMonth.add(joCheckBox8);

        joCheckBox10.setText("ເດືອນ 11");
        joCheckBox10.setName("11"); // NOI18N
        pnMonth.add(joCheckBox10);

        joCheckBox12.setText("ເດືອນ 12");
        joCheckBox12.setName("12"); // NOI18N
        pnMonth.add(joCheckBox12);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(pnMonth, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        txtPrice.setMinimumSize(new java.awt.Dimension(200, 40));
        txtPrice.setNumberOnly(true);
        txtPrice.setPlaceholder("ຄ່າອາຫານ");
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel3.add(txtPrice, gridBagConstraints);

        txtComment.setColumns(1);
        txtComment.setRows(3);
        jScrollPane1.setViewportView(txtComment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        joLable1.setText("ຄ່າອາຫານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 7, 5);
        jPanel3.add(joLable1, gridBagConstraints);

        joLable2.setText("ໝາຍເຫດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 7, 5);
        jPanel3.add(joLable2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(jPanel3, gridBagConstraints);

        btnSave.setText("ບັນທຶກການຈ່າຍຄ່າອາຫານ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        joLable3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable3.setText("ຈ່າຍຄ່າອາຫານ");
        joLable3.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(joLable3, gridBagConstraints);

        setSize(new java.awt.Dimension(463, 479));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (paymentModel.getFoodPaymentID() == 0) {
            if (txtPrice.TextEmpty() && !numMonth.isEmpty()) {
                Create();
            }
        } else {
            if (txtPrice.TextEmpty() && !numMonth.isEmpty()) {
                Update();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        txtPrice.setText(new MyFormat().formatMoney(txtPrice.getText()));
    }//GEN-LAST:event_txtPriceKeyReleased

    private void showEdit() {
        if (paymentModel.getFoodPaymentID() != 0) {
            MonthCaculator caculator = new MonthCaculator();
            txtPrice.setText(new MyFormat().formatMoney(paymentModel.getPrice()));
            txtComment.setText(paymentModel.getComment());
            List<Integer> editMonths = caculator.ToArrayMonth(paymentModel.getMonths());
            editMonths.forEach(number -> {
                JoCheckBox box = (JoCheckBox) pnMonth.getComponent(number - 1);
                box.setEnabled(true);
                numMonth.add(number);
            });
            Collections.sort(numMonth);
        }
    }

    private void CheckboxVisible() {
        List<FoodPaymentModel> models = service.getByRegisterANDStudentID(registerModel.getRegisterID(), studentModel.getStudentID());
        List<Integer> mergedList = new ArrayList<>();
        models.forEach(data -> {
            List<Integer> getmonth = new MonthCaculator().ToArrayMonth(data.getMonths());
            mergedList.addAll(getmonth);
        });
        mergedList.forEach(number -> {
            if (number != 0) {
                JoCheckBox box = (JoCheckBox) pnMonth.getComponent(number - 1);
                box.setSelected(true);
                box.setEnabled(false);
            }
        });
    }

    private void Create() {
        String month = numMonth.toString();
        int money = (int) format.unFormatMoney(txtPrice.getText());
        int conf = service.create(new FoodPaymentModel(
                0,
                registerModel.getRegisterID(),
                studentModel.getStudentID(),
                month,
                money,
                txtComment.getText(),
                format.getSQLDate(new Date()),
                GlobalDataModel.userModel.getUserID()));
        boolean issave = alert.JoSubmit(conf, JoAlert.INSERT);
        if (issave) {
            this.dispose();
            DialogShowFoodPay dialogShowFoodPay = new DialogShowFoodPay(GlobalDataModel.rootView, issave, registerModel, studentModel);
            dialogShowFoodPay.setVisible(issave);
        }
    }

    private void Update() {
        String month = numMonth.toString();
        int money = (int) format.unFormatMoney(txtPrice.getText());
        int conf = service.update(new FoodPaymentModel(
                paymentModel.getFoodPaymentID(),
                registerModel.getRegisterID(),
                studentModel.getStudentID(),
                month,
                money,
                txtComment.getText(),
                format.getSQLDate(new Date()),
                GlobalDataModel.userModel.getUserID()));
        boolean issave = alert.JoSubmit(conf, JoAlert.UPDATE);
        if (issave) {
            this.dispose();
            DialogShowFoodPay dialogShowFoodPay = new DialogShowFoodPay(GlobalDataModel.rootView, true, registerModel, studentModel);
            dialogShowFoodPay.setVisible(true);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnSave;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoCheckBox joCheckBox1;
    private Components.JoCheckBox joCheckBox10;
    private Components.JoCheckBox joCheckBox11;
    private Components.JoCheckBox joCheckBox12;
    private Components.JoCheckBox joCheckBox2;
    private Components.JoCheckBox joCheckBox3;
    private Components.JoCheckBox joCheckBox4;
    private Components.JoCheckBox joCheckBox5;
    private Components.JoCheckBox joCheckBox6;
    private Components.JoCheckBox joCheckBox7;
    private Components.JoCheckBox joCheckBox8;
    private Components.JoCheckBox joCheckBox9;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private javax.swing.JPanel pnMonth;
    private Components.JoTextArea txtComment;
    private Components.JoTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
