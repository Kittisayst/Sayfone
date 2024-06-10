package Component;

import DAOSevervice.SettingSevice;
import Model.GlobalDataModel;
import Model.SettingModel;
import Model.settingPaymentModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;

public class DialogSettingPayment extends javax.swing.JDialog {

    private SettingModel settingModel = new SettingSevice().read(1);
    private int Money = 0;
    settingPaymentModel pm;

    public DialogSettingPayment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(new Color(243, 241, 241));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object[] array = objectMapper.readValue(settingModel.getValue(), Object[].class);
            // Access the elements of the array
            pm = new settingPaymentModel((int) array[0], objectMapper.convertValue(array[1], int[].class));
            ckOverpay.setSelected(pm.isOverpary());
            ckDiscount.setSelected(pm.isDiscount());
            Money = pm.getMoney();
            showMoney();
        } catch (JsonProcessingException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showMoney() {
        pnMoney.setVisible(ckDiscount.isSelected());
        txtMoney.setText(Money + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        joLable1 = new Components.JoLable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        joLable2 = new Components.JoLable();
        ckOverpay = new Components.JoCheckBox();
        joLable3 = new Components.JoLable();
        ckDiscount = new Components.JoCheckBox();
        pnMoney = new javax.swing.JPanel();
        joLable4 = new Components.JoLable();
        txtMoney = new Components.JoTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ຕັ້ງຄ່າການຈ່າຍຄ່າຮຽນ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        getContentPane().add(joLable1, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(243, 241, 241));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        joLable2.setText("ປ້ອນເງິນຄ່າຈ່າຍຊ້າ");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 1, 16)); // NOI18N
        joLable2.setMinimumSize(new java.awt.Dimension(200, 40));
        joLable2.setPreferredSize(new java.awt.Dimension(212, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jPanel2.add(joLable2, gridBagConstraints);

        ckOverpay.setText("ເປີດໃຊ້ງານ");
        ckOverpay.setFont(new java.awt.Font("Phetsarath OT", 0, 16)); // NOI18N
        ckOverpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckOverpayActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(ckOverpay, gridBagConstraints);

        joLable3.setText("ໃສ່ລະຫັດເງິນສ່ວຍຫຼຸດ");
        joLable3.setFont(new java.awt.Font("Phetsarath OT", 1, 16)); // NOI18N
        joLable3.setMinimumSize(new java.awt.Dimension(200, 40));
        joLable3.setPreferredSize(new java.awt.Dimension(212, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(joLable3, gridBagConstraints);

        ckDiscount.setText("ເປີດໃຊ້ງານ");
        ckDiscount.setFont(new java.awt.Font("Phetsarath OT", 0, 16)); // NOI18N
        ckDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckDiscountActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(ckDiscount, gridBagConstraints);

        pnMoney.setOpaque(false);
        pnMoney.setLayout(new java.awt.GridBagLayout());

        joLable4.setText("ວົງເງິນ");
        joLable4.setFont(new java.awt.Font("Phetsarath OT", 1, 16)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        pnMoney.add(joLable4, gridBagConstraints);

        txtMoney.setNumberOnly(true);
        txtMoney.setPlaceholder("ປ້ອນຈຳນວນເງິນ");
        txtMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoneyKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnMoney.add(txtMoney, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(pnMoney, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        setSize(new java.awt.Dimension(516, 430));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ckDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckDiscountActionPerformed
        pm.setDisCountState(ckDiscount.isSelected());
        showMoney();
        UpdateSetting();
    }//GEN-LAST:event_ckDiscountActionPerformed

    private void ckOverpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckOverpayActionPerformed
        pm.setOverpayState(ckOverpay.isSelected());
        UpdateSetting();
    }//GEN-LAST:event_ckOverpayActionPerformed

    private void txtMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoneyKeyReleased
        pm.setMoney(txtMoney.getNumber());
        UpdateSetting();
    }//GEN-LAST:event_txtMoneyKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoCheckBox ckDiscount;
    private Components.JoCheckBox ckOverpay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private javax.swing.JPanel pnMoney;
    private Components.JoTextField txtMoney;
    // End of variables declaration//GEN-END:variables

    private void UpdateSetting() {
        settingModel.setValue(pm.createValue());
        new SettingSevice().update(settingModel);
        GlobalDataModel.settingModel = settingModel;
    }

}
