package View;

import javax.swing.SwingUtilities;

public class PnLoading extends javax.swing.JPanel {

    private int state = 1;
    private int progress = 0;

    public PnLoading() {
        initComponents();
    }

    public void setValue(int value) {
        joProgressBar1.setValue(value);
    }

    public void setTitle(String text) {
        lblTitle.setText(text);
    }

    public void StartProgress(int maxSize, int time) {
        state++;
        progress = (int) ((double) state / maxSize * 100);
        SwingUtilities.invokeLater(() -> {
            joProgressBar1.setValue(progress);
        });
        setSleep(time);
    }

    private void setSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        state = 1;
        progress = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        joProgressBar1 = new Components.JoProgressBar();
        lblTitle = new Components.JoLable();

        setLayout(new java.awt.GridBagLayout());

        joProgressBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        joProgressBar1.setMaximumSize(new java.awt.Dimension(500, 40));
        joProgressBar1.setMinimumSize(new java.awt.Dimension(500, 40));
        joProgressBar1.setPreferredSize(new java.awt.Dimension(500, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(joProgressBar1, gridBagConstraints);

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(lblTitle, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoProgressBar joProgressBar1;
    private Components.JoLable lblTitle;
    // End of variables declaration//GEN-END:variables
}
