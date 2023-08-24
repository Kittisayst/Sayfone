package Component;

import App.AppFinancial;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.WithdrawService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.UserModel;
import Model.WithdrawModel;
import Tools.JoAlert;
import Utility.MyFormat;
import java.util.Date;

public class DialogWithdraw extends javax.swing.JDialog {

    private FinancialModel financialModel;
    private UserModel userAuthen;

    public DialogWithdraw(java.awt.Frame parent, boolean modal, FinancialModel financialModel) {
        super(parent, modal);
        initComponents();
        this.financialModel = financialModel;
        if (financialModel.getFinancialIID() != 0) {
            btnWithdraw.setEnabled(true);
            StudentModel studentModel = new StudentService().getStudentById(financialModel.getStudentID());
            lbl_student.setText(studentModel.getFullName().toString());
            lblMonth.setText(financialModel.getFinancialMonth());
            txtMoney.setText(new MyFormat().formatMoney(financialModel.getMoney()));
            txtTransferMoney.setText(new MyFormat().formatMoney(financialModel.getTransferMoney()));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTransferMoney.setEditable(false);
        txtTransferMoney.setPlaceholder("ເງິນໂອນ");
        getContentPane().add(txtTransferMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 320, -1));

        txtMoney.setEditable(false);
        txtMoney.setPlaceholder("ເງິນສົດ");
        getContentPane().add(txtMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 320, -1));

        joLable1.setText("ໝາຍເຫດ");
        getContentPane().add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 320, 30));

        joLable2.setText("ເດືອນຈ່າຍຄ່າຮຽນ");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        getContentPane().add(joLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 320, 30));

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
        getContentPane().add(btnWithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 320, 50));

        lblMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonth.setText("month");
        lblMonth.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        getContentPane().add(lblMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 320, 30));

        joLable4.setText("ເງິນສົດ");
        getContentPane().add(joLable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 320, 30));

        txtComment.setColumns(20);
        txtComment.setRows(3);
        jScrollPane1.setViewportView(txtComment);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 320, 90));

        joLable5.setText("ເງິນໂອນ");
        getContentPane().add(joLable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 320, 30));

        setSize(new java.awt.Dimension(768, 674));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        JoAlert alert = new JoAlert();
        alert.setButtonOption(new String[]{"ຢືນຢັນ", "ຍົກເລີກ"});
        int conff = alert.messages("ຢືນຢັນການຖອນເງິນ", "ໝາຍເຫດ: ຖ້າຫາກວ່າຖອນເງິນການຈ່າຍຄ່າຮຽນນີ້ຈະຖືກລະງັບ ແລະ ຈຳນວນເດືອນທີ່ລົງທະບຽນຈະຖືກຍົກເລີກ", JoAlert.Icons.warning);
        if (conff == 0) {
            int money = (int) new MyFormat().unFormatMoney(txtMoney.getText());
            int transferMoney = (int) new MyFormat().unFormatMoney(txtTransferMoney.getText());
            String dateTime = new MyFormat().getDateCustom(new Date(), "dd/MM/yyyy HH:mm:ss");
            int userID = GlobalDataModel.globalUsermodel.getUserID();
            WithdrawModel withdrawModel = new WithdrawModel(
                    0,
                    financialModel.getFinancialIID(),
                    money,
                    transferMoney,
                    dateTime, userID,
                    userAuthen.getUserID(),
                    txtComment.getText());
            WithdrawService withdrawService = new WithdrawService();
            FinancialService financialService = new FinancialService();
            withdrawService.CreaterWithdraw(withdrawModel);
            int issave = financialService.getUpdateWithdrawMonth(financialModel.getFinancialIID());
            alert.JoSubmit(issave, JoAlert.INSERT);
            RegisterModel registerModel = new RegisterService().getRegisterById(financialModel.getRegisterID());
            StudentModel studentModel = new StudentService().getStudentById(financialModel.getStudentID());
            AppFinancial financial = new AppFinancial(registerModel, studentModel);
            this.dispose();
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnWithdraw;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable lblMonth;
    private Components.JoLable lbl_student;
    private Components.JoTextArea txtComment;
    private Components.JoTextField txtMoney;
    private Components.JoTextField txtTransferMoney;
    // End of variables declaration//GEN-END:variables
}
