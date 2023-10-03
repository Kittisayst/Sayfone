package View;

import DAOSevervice.StudentService;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NewJFrame extends javax.swing.JFrame {

    StudentService service = new StudentService();

    public NewJFrame(JPanel PNPagination, JPanel jPanel1) throws HeadlessException {
        this.PNPagination = PNPagination;
        this.jPanel1 = jPanel1;
    }
    int select = 0;

    public NewJFrame() {
        initComponents();
        JButton pre = new JButton("<<");
        System.out.println(service.getStudentCount());
        PNPagination.add(pre);
        for (int i = 1; i < service.getStudentCount() / 30; i++) {
            JButton button = new JButton("" + i);
            PNPagination.add(button);
            select(button, i);
            if (i > 10) {
                button.setVisible(false);
            }
        }
        JButton next = new JButton(">>");

        PNPagination.add(next);
    }

    private void select(JButton button, int state) {
        button.addActionListener(e -> {
            defaultSelect();
            button.setBackground(Color.BLUE);
            select = state;
            if (state >=10) {
                JButton btnShow = (JButton) PNPagination.getComponent(state + 1);
                JButton btnHind = (JButton) PNPagination.getComponent(state - state + 1);
                btnShow.setVisible(true);
                btnHind.setVisible(false);
            }
        });
    }

    private void defaultSelect() {
        for (int i = 0; i < PNPagination.getComponentCount(); i++) {
            if (PNPagination.getComponent(i) instanceof JButton) {
                JButton button = (JButton) PNPagination.getComponent(i);
                button.setBackground(Color.WHITE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        PNPagination = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        PNPagination.setBackground(new java.awt.Color(204, 255, 255));
        PNPagination.setMinimumSize(new java.awt.Dimension(10, 100));
        PNPagination.setPreferredSize(new java.awt.Dimension(896, 50));
        PNPagination.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(PNPagination, gridBagConstraints);

        setSize(new java.awt.Dimension(912, 520));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNPagination;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
