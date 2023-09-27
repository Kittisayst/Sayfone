package View;

import Components.JoButton;
import Components.JoButtonIconfont;
import Components.JoPasswordField;
import Components.JoTextField;
import Tools.JoFrameDesign;
import javax.swing.ImageIcon;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();
        JoFrameDesign design = new JoFrameDesign(this);
        design.setIconUI(new ImageIcon(getClass().getResource("/Source/sfsc.png")));
    }

    public void ShowVersion(String version) {
        lbl_version.setText("Version: " + version);
    }

    // Getter
    public JoPasswordField getTxt_password() {
        return txt_password;
    }

    public JoTextField getTxt_user() {
        return txt_user;
    }

    public JoButton getBtn_login() {
        return btn_login;
    }

    public JoButtonIconfont getBtn_setting() {
        return btn_setting;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_version = new Components.JoLable();
        joLable3 = new Components.JoLable();
        joLabelImage1 = new Components.JoLabelImage();
        joLable4 = new Components.JoLable();
        txt_password = new Components.JoPasswordField();
        txt_user = new Components.JoTextField();
        joLable1 = new Components.JoLable();
        btn_login = new Components.JoButton();
        joLable5 = new Components.JoLable();
        joLable6 = new Components.JoLable();
        btn_setting = new Components.JoButtonIconfont();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sayfone School");

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));

        jPanel2.setBackground(new java.awt.Color(25, 118, 210));

        lbl_version.setForeground(new java.awt.Color(255, 255, 255));
        lbl_version.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_version.setText("Version: 0.13.20");

        joLable3.setForeground(new java.awt.Color(255, 255, 255));
        joLable3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable3.setText("ຍິນດີຕ້ອນຮັບ");
        joLable3.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N

        joLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/sfsc.png"))); // NOI18N

        joLable4.setForeground(new java.awt.Color(255, 255, 255));
        joLable4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable4.setText("ເຂົ້າສູ່ລະບົບ Sayfone School");
        joLable4.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joLable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_version, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lbl_version, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txt_password.setPlaceholder("Password");
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        txt_user.setPlaceholder("User");

        joLable1.setForeground(new java.awt.Color(25, 118, 210));
        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ເຂົ້າສູ່ລະບົບ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 1, 36)); // NOI18N

        btn_login.setText("ເຂົ້າສູ່ລະບົບ");
        btn_login.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N

        joLable5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joLable5.setText("ຜູ້ໃຊ້ລະບົບ");
        joLable5.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N

        joLable6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joLable6.setText("ລະຫັດຜ່ານ");
        joLable6.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N

        btn_setting.setBackground(new java.awt.Color(243, 243, 243));
        btn_setting.setForeground(new java.awt.Color(0, 0, 0));
        btn_setting.setJoIconColor(new java.awt.Color(153, 153, 153));
        btn_setting.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SETTINGS);
        btn_setting.setJocolorHover(new java.awt.Color(243, 243, 243));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_user, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_setting, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(joLable5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joLable6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btn_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(777, 462));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed

    }//GEN-LAST:event_txt_passwordKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButton btn_login;
    private Components.JoButtonIconfont btn_setting;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Components.JoLabelImage joLabelImage1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable lbl_version;
    private Components.JoPasswordField txt_password;
    private Components.JoTextField txt_user;
    // End of variables declaration//GEN-END:variables


}
