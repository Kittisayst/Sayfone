package Component;

import Components.JoButtonIconfont;
import java.awt.event.ActionListener;

public class PanelTableAction extends javax.swing.JPanel {

    public PanelTableAction() {
        initComponents();
    }

    public void InitEvent(ActionListener... events) {
        for (int i = 0; i < getComponentCount(); i++) {
            JoButtonIconfont btn = (JoButtonIconfont) getComponent(i);
            btn.addActionListener(events[i]);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnView = new Components.JoButtonIconfont();
        btnEdit = new Components.JoButtonIconfont();
        btnDelete = new Components.JoButtonIconfont();

        setLayout(new java.awt.GridBagLayout());

        btnView.setBackground(new java.awt.Color(0, 153, 204));
        btnView.setJoIconSize(22);
        btnView.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.EDIT);
        btnView.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnView.setMinimumSize(new java.awt.Dimension(47, 30));
        btnView.setPreferredSize(new java.awt.Dimension(47, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        add(btnView, gridBagConstraints);

        btnEdit.setBackground(new java.awt.Color(0, 153, 102));
        btnEdit.setJoIconSize(25);
        btnEdit.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLOUD_DOWNLOAD);
        btnEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnEdit.setMinimumSize(new java.awt.Dimension(47, 30));
        btnEdit.setPreferredSize(new java.awt.Dimension(47, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 3, 1, 3);
        add(btnEdit, gridBagConstraints);

        btnDelete.setBackground(new java.awt.Color(255, 51, 0));
        btnDelete.setJoIconSize(25);
        btnDelete.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.DELETE);
        btnDelete.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnDelete.setMinimumSize(new java.awt.Dimension(47, 30));
        btnDelete.setPreferredSize(new java.awt.Dimension(47, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        add(btnDelete, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnDelete;
    private Components.JoButtonIconfont btnEdit;
    private Components.JoButtonIconfont btnView;
    // End of variables declaration//GEN-END:variables
}
