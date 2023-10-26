package Component;

import DAOSevervice.TeacherMoneyService;
import DAOSevervice.TeacherService;
import Model.GlobalDataModel;
import Model.TeacherModel;
import Model.TeacherMoneyModel;
import Model.YearModel;
import Tools.JoAlert;
import Utility.MyFormat;
import View.TeacherRinkView;
import java.util.Date;

public class DialogTeacherMoney extends javax.swing.JDialog {

    private TeacherModel teacherModel;
    private TeacherMoneyModel moneyModel;
    private YearModel yearModel;
    private TeacherMoneyService moneyService = new TeacherMoneyService();
    private TeacherRinkView view;
    private JoAlert alert = new JoAlert();
    private String Code;

    public DialogTeacherMoney(java.awt.Frame parent, boolean state, String Code, TeacherModel teacherModel, YearModel yearModel, TeacherMoneyModel moneyModel, TeacherRinkView view) {
        super(parent, state);
        initComponents();
        this.Code = Code;
        this.teacherModel = teacherModel;
        this.yearModel = yearModel;
        this.moneyModel = moneyModel;
        this.view = view;
        if (Code.equals("TRF")) {
            btnSave.setText("ຝາກເງິນ");
        } else {
            btnSave.setText("ຖອນເງິນ");
        }
        lblTeacher.setText(teacherModel.getFullName().toString());
        int balance = moneyService.getTeacherBalance(teacherModel.getTeacherID()).getBalance();
        lblMoney.setText(new MyFormat().formatMoney(balance) + " ກີບ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblMoney = new Components.JoLable();
        txtMoney = new Components.JoTextField();
        btnSave = new Components.JoButtonIconfont();
        lblTeacher = new Components.JoLable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComment = new Components.JoTextArea();
        joLable2 = new Components.JoLable();
        joLable3 = new Components.JoLable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblMoney.setBackground(new java.awt.Color(0, 0, 0));
        lblMoney.setForeground(new java.awt.Color(0, 204, 153));
        lblMoney.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMoney.setText("Money");
        lblMoney.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        lblMoney.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 2, 0);
        getContentPane().add(lblMoney, gridBagConstraints);

        txtMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMoney.setNumberOnly(true);
        txtMoney.setPlaceholder("ຈຳນວນເງິນ");
        txtMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoneyKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        getContentPane().add(txtMoney, gridBagConstraints);

        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.setLabel("ບັນທຶກ");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        getContentPane().add(btnSave, gridBagConstraints);

        lblTeacher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTeacher.setText("Teacher");
        lblTeacher.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 9, 0);
        getContentPane().add(lblTeacher, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(52, 80));

        txtComment.setColumns(3);
        txtComment.setRows(2);
        jScrollPane1.setViewportView(txtComment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        joLable2.setText("ໝາຍເຫດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        getContentPane().add(joLable2, gridBagConstraints);

        joLable3.setText("ຈຳນວນເງິນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(19, 0, 0, 0);
        getContentPane().add(joLable3, gridBagConstraints);

        setSize(new java.awt.Dimension(513, 436));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoneyKeyReleased
        txtMoney.setText(new MyFormat().formatMoney(txtMoney.getText()));
    }//GEN-LAST:event_txtMoneyKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (Code.equals("TRF")) {
            SaveDeposit();
        } else {
            SaveWithDraw();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private int getMoney() {
        return (int) new MyFormat().unFormatMoney(txtMoney.getText());
    }

    private void SaveDeposit() {
        int balance = moneyService.getTeacherBalance(teacherModel.getTeacherID()).getBalance();
        int sum = balance + getMoney();
        if (txtMoney.TextEmpty()) {
            moneyModel.setTeacherID(teacherModel.getTeacherID());
            moneyModel.setBalance(sum);
            moneyModel.setSaveDate(new MyFormat().getSQLDate(new Date()));
            moneyModel.setCode(Code);
            moneyModel.setWithdraw(0);
            moneyModel.setDeposit(getMoney());
            moneyModel.setComment(txtComment.getText());
            moneyModel.setUserID(GlobalDataModel.userModel.getUserID());
            moneyService.create(moneyModel);
        }
        this.setVisible(false);
        view.showTeacher(new TeacherService().getAllTeacher(), yearModel);
    }

    private void SaveWithDraw() {
        if (txtMoney.TextEmpty()) {
            int balance = moneyService.getTeacherBalance(teacherModel.getTeacherID()).getBalance();
            int sum = balance - getMoney();
            if (sum < 0) {
                alert = new JoAlert();
                alert.messages("ຈຳນວນເງິນບໍ່ພຽງບພໍ", "ກະລຸນາປ້ອນຈຳນວນເງິນໃໝ່!", JoAlert.Icons.warning);
            } else {
                alert = new JoAlert();
                alert.setButtonOption(new String[]{"ຖອນເງິນ", "ຍົກເລີກ"});
                int conf = alert.messages("ຖອນເງິນ: " + teacherModel.getFullName(), "ຈຳນວນເງິນທີ່ຕ້ອງການຖອນ: " + new MyFormat().formatMoney(getMoney()) + " ກີບ", JoAlert.Icons.info);
                if (conf == 0) {
                    moneyModel.setTeacherMoneyID(0);
                    moneyModel.setTeacherID(teacherModel.getTeacherID());
                    moneyModel.setBalance(sum);
                    moneyModel.setSaveDate(new MyFormat().getSQLDate(new Date()));
                    moneyModel.setCode(Code);
                    moneyModel.setWithdraw(getMoney());
                    moneyModel.setDeposit(0);
                    moneyModel.setComment(txtComment.getText());
                    moneyModel.setUserID(GlobalDataModel.userModel.getUserID());
                    moneyService.create(moneyModel);
                    this.setVisible(false);
                    view.showTeacher(new TeacherService().getAllTeacher(), yearModel);
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable lblMoney;
    private Components.JoLable lblTeacher;
    private Components.JoTextArea txtComment;
    private Components.JoTextField txtMoney;
    // End of variables declaration//GEN-END:variables

}
