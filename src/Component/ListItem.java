package Component;

import java.awt.Color;
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

    public void addHandelDelete(ActionListener evt) {
        btnDelete.addActionListener(evt);
    }

    public String getText() {
        return lblText.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblText = new Components.JoLable();
        btnDelete = new Components.JoButtonIconfont();

        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
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
        btnDelete.setMinimumSize(new java.awt.Dimension(40, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(btnDelete, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBackground(new Color(153, 204, 255));
        setOpaque(true);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(null);
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnDelete;
    private Components.JoLable lblText;
    // End of variables declaration//GEN-END:variables
}
