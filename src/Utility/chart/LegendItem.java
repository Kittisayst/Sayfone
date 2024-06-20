package Utility.chart;

public class LegendItem extends javax.swing.JPanel {

    public LegendItem(ModelLegend data) {
        initComponents();
        setOpaque(false);
        lbColor.setBackground(data.getColor());
        lbName.setText(data.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbName = new javax.swing.JLabel();
        lbColor = new Utility.chart.LabelColor();

        setLayout(new java.awt.GridBagLayout());

        lbName.setFont(new java.awt.Font("Phetsarath OT", 0, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(100, 100, 100));
        lbName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(lbName, gridBagConstraints);

        lbColor.setText("labelColor1");
        lbColor.setPreferredSize(new java.awt.Dimension(40, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lbColor, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Utility.chart.LabelColor lbColor;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
