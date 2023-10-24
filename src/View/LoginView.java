package View;

import Components.JoButton;
import Components.JoButtonIconfont;
import Components.JoPasswordField;
import Components.JoTextField;
import Tools.JoFrameDesign;
import java.time.LocalDate;
import javax.swing.ImageIcon;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();
        JoFrameDesign design = new JoFrameDesign(this);
        design.setIconUI(new ImageIcon(getClass().getResource("/Source/sfsc.png")));
        int currentYear = LocalDate.now().getYear();
        lblCredit.setText("Copyright © 2020 - " + currentYear + " Codingsabay. All rights reserved.");
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_version = new Components.JoLable();
        joLable3 = new Components.JoLable();
        joLabelImage1 = new Components.JoLabelImage();
        joLable4 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        lblCredit = new Components.JoLable();
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
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_version.setForeground(new java.awt.Color(255, 255, 255));
        lbl_version.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_version.setText("Version: 0.13.20");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel2.add(lbl_version, gridBagConstraints);

        joLable3.setForeground(new java.awt.Color(255, 255, 255));
        joLable3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable3.setText("ຍິນດີຕ້ອນຮັບ");
        joLable3.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(joLable3, gridBagConstraints);

        joLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/sfsc.png"))); // NOI18N
        joLabelImage1.setMaximumSize(new java.awt.Dimension(100, 250));
        joLabelImage1.setMinimumSize(new java.awt.Dimension(100, 250));
        joLabelImage1.setPreferredSize(new java.awt.Dimension(100, 250));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(joLabelImage1, gridBagConstraints);

        joLable4.setForeground(new java.awt.Color(255, 255, 255));
        joLable4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable4.setText("ເຂົ້າສູ່ລະບົບ Sayfone School");
        joLable4.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel2.add(joLable4, gridBagConstraints);

        joLable2.setForeground(new java.awt.Color(255, 255, 255));
        joLable2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        joLable2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        jPanel2.add(joLable2, gridBagConstraints);

        lblCredit.setForeground(new java.awt.Color(255, 255, 255));
        lblCredit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCredit.setText("Copyright © 2016 - 2023 Codingsabay");
        lblCredit.setFont(new java.awt.Font("Phetsarath OT", 0, 10)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(lblCredit, gridBagConstraints);

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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(777, 475));
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
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable lblCredit;
    private Components.JoLable lbl_version;
    private Components.JoPasswordField txt_password;
    private Components.JoTextField txt_user;
    // End of variables declaration//GEN-END:variables

}
