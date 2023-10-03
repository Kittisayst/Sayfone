package Component;

import Components.JoPasswordField;
import DAOSevervice.PermissionService;
import DAOSevervice.UserService;
import Model.GlobalDataModel;
import Model.PermissionModel;
import Model.UserModel;
import Tools.JoAlert;
import java.awt.event.KeyEvent;

public class AuthenPopUp extends javax.swing.JDialog {

    private UserModel userModel = new UserModel();

    public AuthenPopUp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JoPasswordField getTxt_Authen() {
        return txt_Authen;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        joPanel1 = new Components.JoPanel();
        joLable1 = new Components.JoLable();
        btnAuthen = new Components.JoButtonIconfont();
        txt_Authen = new Components.JoPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        joPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ປ້ອນລະຫັດຢືນຢັນ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        joPanel1.add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 350, 40));

        btnAuthen.setText("ຢືນຢັນລະຫັດ");
        btnAuthen.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btnAuthen.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCK);
        btnAuthen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthenActionPerformed(evt);
            }
        });
        joPanel1.add(btnAuthen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, -1));

        txt_Authen.setPlaceholder("Confirm Password");
        txt_Authen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_AuthenKeyPressed(evt);
            }
        });
        joPanel1.add(txt_Authen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 350, -1));

        getContentPane().add(joPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(453, 243));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAuthenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthenActionPerformed
        AuthenActive();
    }//GEN-LAST:event_btnAuthenActionPerformed

    private void txt_AuthenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AuthenKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AuthenActive();
        }
    }//GEN-LAST:event_txt_AuthenKeyPressed

    private void AuthenActive() {
        if (txt_Authen.TextEmpty()) {
            userModel = new UserService().getUserByAuthenKey(txt_Authen.getText());
            if (userModel.getUserID() == 0) {
                new JoAlert().messages("ກວດສວບລະຫັດຢືນຢັນ", "ລະຫັດຢືນຢັນບໍ່ຖືກຕ້ອງ", JoAlert.Icons.warning);
            } else {
                PermissionService permissionService = new PermissionService();
                PermissionModel permissionModel = permissionService.getRole(userModel.getUserID(), 22);
                if (!permissionModel.isState()) {
                    new JoAlert().messages("ສິດທີການໃຊ້ງານ", "ຜູ້ໃຊ້ງານ " + userModel.getUserName() + " ບໍ່ໄດ້ຮັບອານຸມັດໃນການແກ້ໄຂຂໍ້ມູນ", JoAlert.Icons.warning);
                    userModel = new UserModel();
                } else {
                    setVisible(false);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnAuthen;
    private Components.JoLable joLable1;
    private Components.JoPanel joPanel1;
    private Components.JoPasswordField txt_Authen;
    // End of variables declaration//GEN-END:variables

    public UserModel getUserModel() {
        return userModel;
    }

}
