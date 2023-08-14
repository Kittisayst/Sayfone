package Component;

import java.io.File;

public class DialogTutorial extends javax.swing.JDialog {

    public DialogTutorial(java.awt.Frame parent, boolean modal, String tile, File file) {
        super(parent, modal);
        initComponents();
        setTitle(tile);
        getContentPane().add(new ImagePanel(file), java.awt.BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.POPUP);

        setSize(new java.awt.Dimension(1035, 654));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
