package Component;

import java.awt.event.ActionListener;

public class ListItem extends javax.swing.JPanel {

    private String textItem = "Item";

    public ListItem() {
        initComponents();
    }

    public String getTextItem() {
        return textItem;
    }

    public void setTextItem(String textItem) {
        this.textItem = textItem;
        lblText.setText(textItem);
    }

    public void setHandelDelete(ActionListener evt) {
        btnDelete.addActionListener(evt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblText = new Components.JoLable();
        btnDelete = new Components.JoButtonIconfont();

        setLayout(new java.awt.GridBagLayout());

        lblText.setText("Item");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(lblText, gridBagConstraints);

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setJoIconSize(25);
        btnDelete.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.DELETE);
        btnDelete.setMaximumSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(btnDelete, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnDelete;
    private Components.JoLable lblText;
    // End of variables declaration//GEN-END:variables
}
