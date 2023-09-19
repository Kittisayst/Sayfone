package View;

public class PnLoading extends javax.swing.JPanel {

    public PnLoading() {
        initComponents();
    }

    public void setValue(int value) {
        joProgressBar1.setValue(value);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        joProgressBar1 = new Components.JoProgressBar();

        setLayout(new java.awt.GridBagLayout());

        joProgressBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        joProgressBar1.setMaximumSize(new java.awt.Dimension(500, 40));
        joProgressBar1.setMinimumSize(new java.awt.Dimension(500, 40));
        joProgressBar1.setPreferredSize(new java.awt.Dimension(500, 40));
        add(joProgressBar1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoProgressBar joProgressBar1;
    // End of variables declaration//GEN-END:variables
}
