package Component;

import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import DAOSevervice.WithdrawService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.StudentModel;
import Model.UserModel;
import Model.WithdrawModel;
import Tools.JoAlert;
import Utility.MyFormat;
import View.FinancialView;
import java.util.Date;
import java.util.List;

public class DialogWithdraw extends javax.swing.JDialog {

    private FinancialModel financialModel;
    private UserModel userAuthen;
    private FinancialView view;
    private int moneyWithdow;
    private int transferMoneyWithdraw;
    private WithdrawService service = new WithdrawService();
    private WithdrawModel model = new WithdrawModel();
    private FinancialService financialService = new FinancialService();

    public DialogWithdraw(java.awt.Frame parent, boolean modal, FinancialModel financialModel, FinancialView view) {
        super(parent, modal);
        initComponents();
        this.financialModel = financialModel;
        this.view = view;
        if (financialModel.getFinancialIID() != 0) {
            btnWithdraw.setEnabled(true);
            StudentModel studentModel = new StudentService().getStudentById(financialModel.getStudentID());
            lbl_student.setText(studentModel.getFullName().toString());
            lblMonth.setText(financialModel.getFinancialMonth());
            moneyWithdow = financialModel.getMoney();
            transferMoneyWithdraw = financialModel.getTransferMoney();
            txtMoney.setText(new MyFormat().formatMoney(moneyWithdow));
            txtTransferMoney.setText(new MyFormat().formatMoney(transferMoneyWithdraw));
            txtMoneyWithdraw.setEditable(moneyWithdow > 0);
            txtTransferMoneyWithdraw.setEditable(transferMoneyWithdraw > 0);
            model = service.getWithdrawByFinancailID(financialModel.getFinancialIID());
            txtMoneyWithdraw.setText(new MyFormat().formatMoney(model.getMoney()));
            txtTransferMoneyWithdraw.setText(new MyFormat().formatMoney(model.getTransferMoney()));
            txtComment.setText(model.getWithdrawComment());
            btnDelete.setEnabled(model.getWithdrawID() > 0);
        }
    }

    public void setUserAuthen(UserModel userAuthen) {
        this.userAuthen = userAuthen;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTransferMoney = new Components.JoTextField();
        txtMoney = new Components.JoTextField();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        joLable3 = new Components.JoLable();
        lbl_student = new Components.JoLable();
        btnWithdraw = new Components.JoButtonIconfont();
        lblMonth = new Components.JoLable();
        joLable4 = new Components.JoLable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComment = new Components.JoTextArea();
        joLable5 = new Components.JoLable();
        joLable6 = new Components.JoLable();
        txtMoneyWithdraw = new Components.JoTextField();
        joLable7 = new Components.JoLable();
        txtTransferMoneyWithdraw = new Components.JoTextField();
        btnDelete = new Components.JoButtonIconfont();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTransferMoney.setEditable(false);
        txtTransferMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTransferMoney.setPlaceholder("ເງິນໂອນ");
        getContentPane().add(txtTransferMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 150, -1));

        txtMoney.setEditable(false);
        txtMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMoney.setPlaceholder("ເງິນສົດ");
        getContentPane().add(txtMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 150, -1));

        joLable1.setText("ໝາຍເຫດ");
        getContentPane().add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 320, 30));

        joLable2.setText("ເດືອນຈ່າຍຄ່າຮຽນ");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        getContentPane().add(joLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 360, 30));

        joLable3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 153, 102)));
        joLable3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable3.setText("ຖອນເງິນ ການຈ່າຍຄ່າຮຽນ");
        joLable3.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N
        joLable3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(joLable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 60));

        lbl_student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_student.setText("name");
        lbl_student.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        getContentPane().add(lbl_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 320, 40));

        btnWithdraw.setBackground(new java.awt.Color(0, 153, 102));
        btnWithdraw.setText("ຖອນເງິນ");
        btnWithdraw.setEnabled(false);
        btnWithdraw.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btnWithdraw.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SWAP_HORIZ);
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });
        getContentPane().add(btnWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 350, 50));

        lblMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonth.setText("month");
        lblMonth.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        getContentPane().add(lblMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 320, 30));

        joLable4.setText("ເງິນສົດ");
        getContentPane().add(joLable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 150, 30));

        txtComment.setColumns(20);
        txtComment.setRows(3);
        jScrollPane1.setViewportView(txtComment);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 350, 90));

        joLable5.setText("ເງິນໂອນ");
        getContentPane().add(joLable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 150, 30));

        joLable6.setText("ຈຳນວນເງິນສົດ ຕ້ອງການຖອນ");
        getContentPane().add(joLable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 140, 30));

        txtMoneyWithdraw.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMoneyWithdraw.setNumberOnly(true);
        txtMoneyWithdraw.setPlaceholder("ຖອນເງິນສົດ");
        txtMoneyWithdraw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoneyWithdrawKeyReleased(evt);
            }
        });
        getContentPane().add(txtMoneyWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 160, -1));

        joLable7.setText("ຈຳນວນເງິນໂອນ ຕ້ອງການຖອນ");
        getContentPane().add(joLable7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 150, 30));

        txtTransferMoneyWithdraw.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTransferMoneyWithdraw.setNumberOnly(true);
        txtTransferMoneyWithdraw.setPlaceholder("ຖອນເງິນໂອນ");
        txtTransferMoneyWithdraw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTransferMoneyWithdrawKeyReleased(evt);
            }
        });
        getContentPane().add(txtTransferMoneyWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 160, -1));

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setText("ລົບຂໍ້ມູນການຖອນເງິນ");
        btnDelete.setEnabled(false);
        btnDelete.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.DELETE);
        btnDelete.setJocolorHover(new java.awt.Color(255, 51, 51));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 350, 50));

        setSize(new java.awt.Dimension(768, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        int money = (int) new MyFormat().unFormatMoney(txtMoneyWithdraw.getText());
        int transfer = (int) new MyFormat().unFormatMoney(txtTransferMoneyWithdraw.getText());
        int amoutMoney = moneyWithdow - money;
        int amoutTransfer = transferMoneyWithdraw - transfer;
        if (money > 0 || transfer > 0) {
            if (model.getWithdrawID() == 0) {
                model = new WithdrawModel(
                        0,
                        financialModel.getFinancialIID(),
                        money,
                        transfer,
                        new MyFormat().getDateCustom(new Date(), "dd/MM/yyyy hh:mm:ss"),
                        GlobalDataModel.userModel.getUserID(),
                        userAuthen.getUserID(),
                        txtComment.getText());
                if (showConfirm(amoutMoney, amoutTransfer) == 0) {
                    saveWithdraw(amoutMoney, amoutTransfer);
                } else {
                    this.dispose();
                }
            } else {
                UpdateWithdraw(money, transfer, amoutMoney, amoutTransfer);
            }
        } else {
            new JoAlert().messages("ຂໍ້ມູນບໍ່ຄົບຖ້ວນ", "ກະລຸນາປ້ອນຈຳນວນເງິນທີ່ຕ້ອງການຖອນ", JoAlert.Icons.warning);
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void saveWithdraw(int amountMoney, int amountTransfer) {
        int state = service.CreaterWithdraw(model);
        if (state > 0) {
            int financialState = UpdateFinancial(amountMoney, amountTransfer);
            if (financialState > 0) {
                new JoAlert().messages("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນການຖອນເງິນສຳເລັດ", JoAlert.Icons.success);
                List<FinancialModel> models = new FinancialService().getFinancialByStudentID(financialModel.getRegisterID(), financialModel.getStudentID()); //ດຶງຂໍ້ມູນການລົງທະບຽນ
                view.showFinancial(models);
                this.dispose();
            } else {
                new JoAlert().messages("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນການຖອນເງິນຜິດພາດ", JoAlert.Icons.error);
            }
        } else {
            new JoAlert().messages("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນການຖອນເງິນຜິດພາດ", JoAlert.Icons.error);
        }
    }

    private void UpdateWithdraw(int money, int transfer, int amountMoney, int amountTransfer) {
        model.setMoney(money);
        model.setTransferMoney(transfer);
        model.setWithdrawComment(txtComment.getText());
        model.setWithdrawDate(new MyFormat().getDateCustom(new Date(), "dd/MM/yyyy hh:mm:ss"));
        int state = service.UpdateWithdraw(model);
        if (state > 0) {
            int financialState = UpdateFinancial(amountMoney, amountTransfer);
            if (financialState > 0) {
                new JoAlert().messages("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນການຖອນເງິນສຳເລັດ", JoAlert.Icons.success);
                List<FinancialModel> models = new FinancialService().getFinancialByStudentID(financialModel.getRegisterID(), financialModel.getStudentID()); //ດຶງຂໍ້ມູນການລົງທະບຽນ
                view.showFinancial(models);
                this.dispose();
            } else {
                new JoAlert().messages("ບັນທຶກຂໍ້ມູນ", "ບັນທຶກຂໍ້ມູນການຖອນເງິນຜິດພາດ", JoAlert.Icons.error);
            }
        } else {
            new JoAlert().messages("ແກ້ໄຂຂໍ້ມູນ", "ແກ້ໄຂຂໍ້ມູນການຖອນເງິນຜິດພາດ", JoAlert.Icons.error);
        }
    }

    private int UpdateFinancial(int amountMoney, int amountTransfer) {
        financialModel.setMoney(amountMoney);
        financialModel.setTransferMoney(amountTransfer);
        return financialService.Update(financialModel);
    }

    private int showConfirm(int amountMoney, int amountTransfer) {
        JoAlert alert = new JoAlert();
        alert.setButtonOption(new String[]{"ຖອນເງິນ", "ຍົກເລີກ"});
        return alert.messages("ຢືນຢັນການຖອນເງິນ", "ທ່ານຕ້ອງການຖອນເງິນ ເງິນສົດ: " + amountMoney + " ແລະ ເງິນໂອນ: " + amountTransfer + " ຫຼືບໍ່!", JoAlert.Icons.info);
    }

    private void txtMoneyWithdrawKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoneyWithdrawKeyReleased
        txtMoneyWithdraw.setText(new MyFormat().formatMoney(txtMoneyWithdraw.getText()));
        int inputMoney = (int) new MyFormat().unFormatMoney(txtMoneyWithdraw.getText());
        int money = inputMoney;
        if (money > moneyWithdow) {
            JoAlert alert = new JoAlert();
            alert.messages("ຖອນເງິນ", "ຈຳນວນເງິນທີ່ຖອນ ຫຼາຍກວ່າເງິນສົດ", JoAlert.Icons.warning);
            txtMoneyWithdraw.setText(txtMoney.getText());
            moneyWithdow = (int) new MyFormat().unFormatMoney(txtMoneyWithdraw.getText());
        }
    }//GEN-LAST:event_txtMoneyWithdrawKeyReleased

    private void txtTransferMoneyWithdrawKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTransferMoneyWithdrawKeyReleased
        txtTransferMoneyWithdraw.setText(new MyFormat().formatMoney(txtTransferMoneyWithdraw.getText()));
        int inputMoney = (int) new MyFormat().unFormatMoney(txtTransferMoneyWithdraw.getText());
        int money = inputMoney;
        if (money > transferMoneyWithdraw) {
            JoAlert alert = new JoAlert();
            alert.messages("ຖອນເງິນ", "ຈຳນວນເງິນທີ່ຖອນ ຫຼາຍກວ່າເງິນສົດ", JoAlert.Icons.warning);
            txtTransferMoneyWithdraw.setText(txtTransferMoney.getText());
            transferMoneyWithdraw = (int) new MyFormat().unFormatMoney(txtTransferMoneyWithdraw.getText());
        }
    }//GEN-LAST:event_txtTransferMoneyWithdrawKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int money = (int) new MyFormat().unFormatMoney(txtMoneyWithdraw.getText());
        int transfer = (int) new MyFormat().unFormatMoney(txtTransferMoneyWithdraw.getText());
        int amoutMoney = moneyWithdow + money;
        int amoutTransfer = transferMoneyWithdraw + transfer;
        financialModel.setMoney(amoutMoney);
        financialModel.setTransferMoney(amoutTransfer);
        if (new JoAlert().JoSubmitDelete()) {
            financialService.Update(financialModel);
            service.DeleteWithdraw(model);
            List<FinancialModel> models = new FinancialService().getFinancialByStudentID(financialModel.getRegisterID(), financialModel.getStudentID()); //ດຶງຂໍ້ມູນການລົງທະບຽນ
            view.showFinancial(models);
            this.dispose();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnDelete;
    private Components.JoButtonIconfont btnWithdraw;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable joLable7;
    private Components.JoLable lblMonth;
    private Components.JoLable lbl_student;
    private Components.JoTextArea txtComment;
    private Components.JoTextField txtMoney;
    private Components.JoTextField txtMoneyWithdraw;
    private Components.JoTextField txtTransferMoney;
    private Components.JoTextField txtTransferMoneyWithdraw;
    // End of variables declaration//GEN-END:variables
}
