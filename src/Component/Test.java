package Component;

import java.awt.Color;

public class Test extends javax.swing.JFrame {

    public Test() {
        initComponents();
        JoPanelMenu menu = new JoPanelMenu();
        menu.SetJoPanelMenu(joButtonIconfont1, Pn_SubMenu);
        menu.SetJoPanelMenu(joButtonIconfont5, Pn_SubMenu1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        joButtonIconfont1 = new Components.JoButtonIconfont();
        Pn_SubMenu = new javax.swing.JPanel();
        joButtonIconfont2 = new Components.JoButtonIconfont();
        joButtonIconfont3 = new Components.JoButtonIconfont();
        joButtonIconfont4 = new Components.JoButtonIconfont();
        joButtonIconfont5 = new Components.JoButtonIconfont();
        Pn_SubMenu1 = new javax.swing.JPanel();
        joButtonIconfont6 = new Components.JoButtonIconfont();
        joButtonIconfont7 = new Components.JoButtonIconfont();
        joButtonIconfont8 = new Components.JoButtonIconfont();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        joButtonIconfont1.setText("joButtonIconfont1");
        joButtonIconfont1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joButtonIconfont1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButtonIconfont1ActionPerformed(evt);
            }
        });

        joButtonIconfont2.setText("joButtonIconfont2");
        joButtonIconfont2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        joButtonIconfont3.setText("joButtonIconfont2");
        joButtonIconfont3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        joButtonIconfont4.setText("joButtonIconfont2");
        joButtonIconfont4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout Pn_SubMenuLayout = new javax.swing.GroupLayout(Pn_SubMenu);
        Pn_SubMenu.setLayout(Pn_SubMenuLayout);
        Pn_SubMenuLayout.setHorizontalGroup(
            Pn_SubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(joButtonIconfont2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
            .addComponent(joButtonIconfont3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(joButtonIconfont4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Pn_SubMenuLayout.setVerticalGroup(
            Pn_SubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pn_SubMenuLayout.createSequentialGroup()
                .addComponent(joButtonIconfont2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joButtonIconfont3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joButtonIconfont4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        joButtonIconfont5.setText("joButtonIconfont1");
        joButtonIconfont5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joButtonIconfont5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButtonIconfont5ActionPerformed(evt);
            }
        });

        joButtonIconfont6.setText("joButtonIconfont2");
        joButtonIconfont6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        joButtonIconfont7.setText("joButtonIconfont2");
        joButtonIconfont7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        joButtonIconfont8.setText("joButtonIconfont2");
        joButtonIconfont8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout Pn_SubMenu1Layout = new javax.swing.GroupLayout(Pn_SubMenu1);
        Pn_SubMenu1.setLayout(Pn_SubMenu1Layout);
        Pn_SubMenu1Layout.setHorizontalGroup(
            Pn_SubMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(joButtonIconfont6, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
            .addComponent(joButtonIconfont7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(joButtonIconfont8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Pn_SubMenu1Layout.setVerticalGroup(
            Pn_SubMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pn_SubMenu1Layout.createSequentialGroup()
                .addComponent(joButtonIconfont6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joButtonIconfont7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joButtonIconfont8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joButtonIconfont1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pn_SubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joButtonIconfont5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pn_SubMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(joButtonIconfont5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pn_SubMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(joButtonIconfont1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pn_SubMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(933, 424));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void joButtonIconfont1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButtonIconfont1ActionPerformed


    }//GEN-LAST:event_joButtonIconfont1ActionPerformed

    private void joButtonIconfont5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButtonIconfont5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joButtonIconfont5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_SubMenu;
    private javax.swing.JPanel Pn_SubMenu1;
    private Components.JoButtonIconfont joButtonIconfont1;
    private Components.JoButtonIconfont joButtonIconfont2;
    private Components.JoButtonIconfont joButtonIconfont3;
    private Components.JoButtonIconfont joButtonIconfont4;
    private Components.JoButtonIconfont joButtonIconfont5;
    private Components.JoButtonIconfont joButtonIconfont6;
    private Components.JoButtonIconfont joButtonIconfont7;
    private Components.JoButtonIconfont joButtonIconfont8;
    // End of variables declaration//GEN-END:variables
}
