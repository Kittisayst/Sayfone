package Component;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyList extends javax.swing.JPanel {

    private final List<JPanel> models = new ArrayList<>();

    public MyList() {
        initComponents();
    }

    public void AddList(JPanel panel) {
        models.add(panel);
        updateList();
    }

    private void updateList() {
        pnView.removeAll();
        GridBagConstraints gridBagConstraints;
        int row = 0;
        for (JPanel model : models) {
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = row;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 0.1;
            pnView.add(model, gridBagConstraints);
            row++;
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = row;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        pnView.add(new JLabel(), gridBagConstraints);
        pnView.repaint();
        pnView.revalidate();
    }

    public void removeItem(int index) {
        models.remove(index);
        updateList();
    }

    public int getCount() {
        return models.size();
    }
    
    public String getData(){
        List<String> texts = new ArrayList<>();
        for (JPanel model : models) {
            ListItem item = (ListItem) model;
            texts.add(item.getText());
        }
        return texts.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnView = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        pnView.setLayout(new java.awt.GridBagLayout());
        add(pnView, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnView;
    // End of variables declaration//GEN-END:variables
}
