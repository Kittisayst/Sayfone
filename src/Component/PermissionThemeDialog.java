package Component;

import Database.JoProperties;
import View.PermissionActiveView;

public class PermissionThemeDialog extends javax.swing.JDialog {

    private String permissData;
    private PermissionActiveView view;
    private JoProperties property = new JoProperties("/Info/permission.properties");

    public PermissionThemeDialog(java.awt.Frame parent, boolean modal, String permissData, PermissionActiveView view) {
        super(parent, modal);
        initComponents();
        this.permissData = permissData;
        this.view = view;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        txtName = new Components.JoTextField();
        btnCreate = new Components.JoButtonIconfont();
        joLable1 = new Components.JoLable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtName.setPlaceholder("ຊື່ຮູບແບບສິດທິ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 20, 0);
        jPanel1.add(txtName, gridBagConstraints);

        btnCreate.setText("ສ້າງຮູບແບບສິດທິ");
        btnCreate.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(btnCreate, gridBagConstraints);

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ຕັ້ງຊື່ຮູບແບບສິດທິ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        jPanel1.add(joLable1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(406, 225));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (txtName.TextEmpty()) {
            property.addValue(txtName.getText(), permissData);
            this.dispose();
        }
    }//GEN-LAST:event_btnCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnCreate;
    private javax.swing.JPanel jPanel1;
    private Components.JoLable joLable1;
    private Components.JoTextField txtName;
    // End of variables declaration//GEN-END:variables
}
