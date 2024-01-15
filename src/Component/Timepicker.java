package Component;

public class Timepicker extends javax.swing.JPanel {

    public Timepicker() {
        initComponents();
        //set Hour
        for (int i = 0; i <= 23; i++) {
            String val = String.format("%02d", i);
            cbHour.JoAddIntModel(i, val);
        }
        //minute
        for (int i = 0; i <= 59; i++) {
            String val = String.format("%02d", i);
            cbMinute.JoAddIntModel(i, val);
        }
        //second
        for (int i = 0; i <= 59; i++) {
            String val = String.format("%02d", i);
            cbSecond.JoAddIntModel(i, val);
        }

    }

    public String getHour() {
        return cbHour.getSelectedItem().toString();
    }

    public String getMinute() {
        return cbMinute.getSelectedItem().toString();
    }

    public String getSecond() {
        return cbSecond.getSelectedItem().toString();
    }

    public void setHour(String hour) {
        cbHour.setSelectedItem(hour);
    }

    public void setMinute(String minute) {
        cbMinute.setSelectedItem(minute);
    }

    public void setSecond(String second) {
        cbSecond.setSelectedItem(second);
    }

    public String getTime() {
        String selectedTime = cbHour.getSelectedItem() + ":"
                + cbMinute.getSelectedItem() + ":"
                + cbSecond.getSelectedItem();
        return selectedTime;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        cbHour = new Components.JoCombobox();
        cbMinute = new Components.JoCombobox();
        cbSecond = new Components.JoCombobox();

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(cbHour, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(cbMinute, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(cbSecond, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoCombobox cbHour;
    private Components.JoCombobox cbMinute;
    private Components.JoCombobox cbSecond;
    // End of variables declaration//GEN-END:variables
}
