package Component;

import App.AppUser;
import DAOSevervice.TeacherService;
import DAOSevervice.UserService;
import Model.UserModel;
import Tools.JoAlert;

public class DialogUser extends javax.swing.JDialog {

    private UserModel model;

    public DialogUser(java.awt.Frame parent, boolean ss, UserModel model) {
        super(parent, ss);
        initComponents();
        this.model = model;
        TeacherService service = new TeacherService();
        service.getAllTeacher().forEach(data -> {
            cbTeacher.JoAddIntModel(data.getTeacherID(), data.getFullName().toString());
        });
        if (model.getUserID() != 0) {
            cbTeacher.setSelectIntValue(model.getTeacherID());
            txtUser.setText(model.getUserName());
            txtConfirm.setText(model.getAuthenKey());
            txtPassword.setText(model.getPassword());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUser = new Components.JoTextField();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        cbTeacher = new Components.JoCombobox();
        joLable3 = new Components.JoLable();
        txtConfirm = new Components.JoPasswordField();
        joLable4 = new Components.JoLable();
        txtPassword = new Components.JoPasswordField();
        btnCancel = new Components.JoButtonIconfont();
        btnSave = new Components.JoButtonIconfont();
        joLable5 = new Components.JoLable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 234, 234));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setPlaceholder("User Name");
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 310, -1));

        joLable1.setText("ລະຫັດຢືນຢັນການເງິນ");
        jPanel1.add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 310, -1));

        joLable2.setText("ເລືອກຄຸສອນ");
        jPanel1.add(joLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 310, -1));
        jPanel1.add(cbTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 310, 40));

        joLable3.setText("ຜູ້ໃຊ້ງານ");
        jPanel1.add(joLable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 310, -1));

        txtConfirm.setPlaceholder("Confirmation");
        jPanel1.add(txtConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 310, -1));

        joLable4.setText("ລະຫັດຜ່ານ");
        jPanel1.add(joLable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 310, -1));

        txtPassword.setPlaceholder("Password");
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 310, -1));

        btnCancel.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel.setText("ຍົກເລີກ");
        btnCancel.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CANCEL);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 300, 50));

        btnSave.setText("ບັນທຶກ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 310, 50));

        joLable5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable5.setText("ຈັດການຂໍ້ມູນຜູ້ໃຊ້ງານ");
        joLable5.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N
        jPanel1.add(joLable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 640, 50));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(828, 490));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtUser.TextEmpty() && txtConfirm.TextEmpty() && txtPassword.TextEmpty()) {
            JoAlert alert = new JoAlert();
            UserService service = new UserService();
            model.setUserName(txtUser.getText());
            model.setAuthenKey(txtConfirm.getText());
            model.setPassword(txtPassword.getText());
            model.setTeacherID(cbTeacher.getKeyInt());
            if (model.getUserID() == 0) {
                if (alert.JoSubmit(service.CreateUser(model), JoAlert.INSERT)) {
                    new AppUser().Open();
                    this.dispose();
                }
            } else {
                if (alert.JoSubmit(service.UpdateUser(model), JoAlert.UPDATE)) {
                    new AppUser().Open();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnCancel;
    private Components.JoButtonIconfont btnSave;
    private Components.JoCombobox cbTeacher;
    private javax.swing.JPanel jPanel1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoPasswordField txtConfirm;
    private Components.JoPasswordField txtPassword;
    private Components.JoTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
