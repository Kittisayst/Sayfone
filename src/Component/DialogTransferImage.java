package Component;

import Components.JoLabelImage;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.Icon;

public class DialogTransferImage extends javax.swing.JDialog {

    public DialogTransferImage(java.awt.Frame parent, boolean modal, Icon icon) {
        super(parent, modal);
        initComponents();
        JoLabelImage labelImage = new JoLabelImage();
        labelImage.setIcon(icon);
        add(labelImage, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        setSize(new java.awt.Dimension(516, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
