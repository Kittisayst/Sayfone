package Component;

public class ParentComponent extends javax.swing.JPanel {

    public ParentComponent() {
        initComponents();
    }

    public void setParentIndex(int value) {
        cbParent.setSelectedIndex(value);
    }

    public void setParent(String value) {
        switch (value) {
            case "ພໍ່":
                cbParent.setSelectedIndex(0);
                break;
            case "ແມ່":
                cbParent.setSelectedIndex(1);
                break;
            default:
                cbParent.setSelectedIndex(2);
                break;
        }
        txtParent.setText(value);
    }

    public String getParentName() {
        if (!txtParent.getText().equals("")) {
            return txtParent.getText();
        } else {
            return "ອື່ນໆ";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cbParent = new Components.JoCombobox();
        txtParent = new Components.JoTextField();

        setLayout(new java.awt.GridBagLayout());

        cbParent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ພໍ່", "ແມ່", "ອື່ນໆ" }));
        cbParent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbParentItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 2, 3, 2);
        add(cbParent, gridBagConstraints);

        txtParent.setEditable(false);
        txtParent.setPlaceholder("ຜູ້ປົກຄອງ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 2);
        add(txtParent, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cbParentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbParentItemStateChanged
        txtParent.setText(cbParent.getValue());
        txtParent.setEditable(cbParent.getSelectedIndex() == 2);
        txtParent.requestFocus();
    }//GEN-LAST:event_cbParentItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoCombobox cbParent;
    private Components.JoTextField txtParent;
    // End of variables declaration//GEN-END:variables
}
