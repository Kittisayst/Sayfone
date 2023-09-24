package Component;

import Model.StudentModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckStudent extends javax.swing.JPanel {

    private final StudentModel model;
    private final int StudentID;

    public CheckStudent(int No, StudentModel model) {
        initComponents();
        this.model = model;
        StudentID = this.model.getStudentID();
        lblNo.setText(No + ". ");
        lblStudentName.setText(model.getFullName().toString());
        cbabsent.JoClearData();
        cbabsent.JoAddIntModel(0, "ມາ");
        cbabsent.JoAddIntModel(1, "ຄອບ");
        cbabsent.JoAddIntModel(2, "ຂາດຮຽນ");
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(null);
                lblNo.setForeground(Color.BLACK);
                lblStudentName.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(new Color(25, 118, 210));
                lblNo.setForeground(Color.WHITE);
                lblStudentName.setForeground(Color.WHITE);
            }

        });
    }

    public String getKey() {
        return "" + StudentID;
    }

    public String getValue() {
        return cbabsent.getKey();
    }

    public void setAbsent(int absent) {
        cbabsent.setSelectIntValue(absent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblStudentName = new Components.JoLable();
        cbabsent = new Components.JoCombobox();
        lblNo = new Components.JoLable();

        setLayout(new java.awt.GridBagLayout());

        lblStudentName.setText("Name");
        lblStudentName.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 25);
        add(lblStudentName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 30);
        add(cbabsent, gridBagConstraints);

        lblNo.setText("0");
        lblNo.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 5);
        add(lblNo, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoCombobox cbabsent;
    private Components.JoLable lblNo;
    private Components.JoLable lblStudentName;
    // End of variables declaration//GEN-END:variables
}
