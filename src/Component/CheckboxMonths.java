package Component;

import Components.JoCheckBoxUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JComponent;

public class CheckboxMonths extends javax.swing.JPanel {

    private Color selectColor = new Color(25, 118, 210);
    private final HashMap<Integer, String> months = new HashMap<>();

    public CheckboxMonths() {
        initComponents();
        Event();
    }

    private void Event() {
        Component[] components = getComponents();
        for (int i = 0; i < components.length; i++) {
            JoCheckBoxUI ck = (JoCheckBoxUI) components[i];
            final int key = i;
            ck.addActionListener((ActionEvent e) -> {
                if (ck.isSelected()) {
                    months.put(key, ck.getName());
                } else {
                    months.remove(key);
                }
            });
        }
    }

    public void setSelectCurentMonth() {
        LocalDate currentDate = LocalDate.now();
        JComponent ckmonth = (JComponent) getComponent(currentDate.getMonthValue() - 1);
        ckmonth.setForeground(selectColor);
    }

    public void setSelectMonth(String data) {
        data = data.equals("") ? "[]" : data;
        boolean isMonth = !data.equals("[]");
        if (isMonth) {
            String[] arr = data.substring(1, data.length() - 1).split(", ");
            if (arr.length > 0) {
                for (String str : arr) {
                    int key = Integer.parseInt(str);
                    JoCheckBoxUI checkBox = (JoCheckBoxUI) getComponent(key - 1);
                    checkBox.setFont(new Font("phetsarath ot", 0, 14));
                    checkBox.setSelected(true);
                    checkBox.setEnabled(false);

                }
            }
        }
    }

    public void setEditSelectMonth(String data) {
        data = data.equals("") ? "[]" : data;
        boolean isMonth = !data.equals("[]");
        if (isMonth) {
            String[] arr = data.substring(1, data.length() - 1).split(", ");
            if (arr.length > 0) {
                for (String str : arr) {
                    int key = Integer.parseInt(str);
                    JoCheckBoxUI checkBox = (JoCheckBoxUI) getComponent(key - 1);
                    checkBox.setEnabled(true);
                    checkBox.setSelected(false);
                    checkBox.doClick();
                }
            }
        }
    }

    public String getMonths() {
        Collection<String> values = months.values();
        String[] valuesArray = values.toArray(String[]::new);
        return Arrays.toString(valuesArray);
    }

    public void clearMonths() {
        setSelectMonth(getMonths());
        months.clear();
    }

    public boolean isEmptySelect() {
        return months.isEmpty();
    }

    public Color getSelectColor() {
        return selectColor;
    }

    public void setSelectColor(Color selectColor) {
        this.selectColor = selectColor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        CheckBox1 = new Components.JoCheckBoxUI();
        CheckBox2 = new Components.JoCheckBoxUI();
        CheckBox3 = new Components.JoCheckBoxUI();
        CheckBox4 = new Components.JoCheckBoxUI();
        CheckBox5 = new Components.JoCheckBoxUI();
        CheckBox6 = new Components.JoCheckBoxUI();
        CheckBox7 = new Components.JoCheckBoxUI();
        CheckBox8 = new Components.JoCheckBoxUI();
        CheckBox9 = new Components.JoCheckBoxUI();
        CheckBox10 = new Components.JoCheckBoxUI();
        CheckBox11 = new Components.JoCheckBoxUI();
        CheckBox12 = new Components.JoCheckBoxUI();

        setLayout(new java.awt.GridBagLayout());

        CheckBox1.setText("01");
        CheckBox1.setFocusable(false);
        CheckBox1.setName("1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox1, gridBagConstraints);

        CheckBox2.setText("02");
        CheckBox2.setFocusable(false);
        CheckBox2.setName("2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox2, gridBagConstraints);

        CheckBox3.setText("03");
        CheckBox3.setFocusable(false);
        CheckBox3.setName("3"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox3, gridBagConstraints);

        CheckBox4.setText("04");
        CheckBox4.setFocusable(false);
        CheckBox4.setName("4"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox4, gridBagConstraints);

        CheckBox5.setText("05");
        CheckBox5.setFocusable(false);
        CheckBox5.setName("5"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox5, gridBagConstraints);

        CheckBox6.setText("06");
        CheckBox6.setFocusable(false);
        CheckBox6.setName("6"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox6, gridBagConstraints);

        CheckBox7.setText("07");
        CheckBox7.setFocusable(false);
        CheckBox7.setName("7"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox7, gridBagConstraints);

        CheckBox8.setText("08");
        CheckBox8.setFocusable(false);
        CheckBox8.setName("8"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox8, gridBagConstraints);

        CheckBox9.setText("09");
        CheckBox9.setFocusable(false);
        CheckBox9.setName("9"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox9, gridBagConstraints);

        CheckBox10.setText("10");
        CheckBox10.setFocusable(false);
        CheckBox10.setName("10"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox10, gridBagConstraints);

        CheckBox11.setText("11");
        CheckBox11.setFocusable(false);
        CheckBox11.setName("11"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox11, gridBagConstraints);

        CheckBox12.setText("12");
        CheckBox12.setFocusable(false);
        CheckBox12.setName("12"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(CheckBox12, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoCheckBoxUI CheckBox1;
    private Components.JoCheckBoxUI CheckBox10;
    private Components.JoCheckBoxUI CheckBox11;
    private Components.JoCheckBoxUI CheckBox12;
    private Components.JoCheckBoxUI CheckBox2;
    private Components.JoCheckBoxUI CheckBox3;
    private Components.JoCheckBoxUI CheckBox4;
    private Components.JoCheckBoxUI CheckBox5;
    private Components.JoCheckBoxUI CheckBox6;
    private Components.JoCheckBoxUI CheckBox7;
    private Components.JoCheckBoxUI CheckBox8;
    private Components.JoCheckBoxUI CheckBox9;
    // End of variables declaration//GEN-END:variables
}
