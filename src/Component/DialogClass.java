package Component;

import App.AppClass;
import DAOSevervice.ClassService;
import Model.ClassModel;

public class DialogClass extends javax.swing.JDialog {

    private final ClassModel classModel;

    public DialogClass(java.awt.Frame parent, boolean modal, ClassModel classModel) {
        super(parent, modal);
        this.classModel = classModel;
        initComponents();
        if (classModel.getClassID() != 0) {
            txtClassName.setText(classModel.getClassName());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        txtClassName = new Components.JoTextField();
        joButtonIconfont1 = new Components.JoButtonIconfont();
        joButtonIconfont2 = new Components.JoButtonIconfont();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        joLable1.setText("ຊື່ຂະແໜງ");
        jPanel1.add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 310, -1));

        txtClassName.setPlaceholder("ຊື່ຂະແໜງ");
        jPanel1.add(txtClassName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 310, -1));

        joButtonIconfont1.setBackground(new java.awt.Color(255, 0, 0));
        joButtonIconfont1.setText("ຍົກເລີກ");
        joButtonIconfont1.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CANCEL);
        joButtonIconfont1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButtonIconfont1ActionPerformed(evt);
            }
        });
        jPanel1.add(joButtonIconfont1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 140, -1));

        joButtonIconfont2.setText("ບັນທຶກ");
        joButtonIconfont2.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        joButtonIconfont2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButtonIconfont2ActionPerformed(evt);
            }
        });
        jPanel1.add(joButtonIconfont2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 140, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(465, 270));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void joButtonIconfont2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButtonIconfont2ActionPerformed
        ClassService classService = new ClassService();
        if (txtClassName.TextEmpty()) {
            classModel.setClassName(txtClassName.getText());
            if (classModel.getClassID() == 0) {
                classService.CreaterClass(classModel);
            } else {
                classService.UpdateClass(classModel);
            }
            AppClass ac = new AppClass();
            ac.Open();
            this.setVisible(false);
        }
    }//GEN-LAST:event_joButtonIconfont2ActionPerformed

    private void joButtonIconfont1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButtonIconfont1ActionPerformed
        AppClass ac = new AppClass();
        ac.Open();
         this.setVisible(false);
    }//GEN-LAST:event_joButtonIconfont1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private Components.JoButtonIconfont joButtonIconfont1;
    private Components.JoButtonIconfont joButtonIconfont2;
    private Components.JoLable joLable1;
    private Components.JoTextField txtClassName;
    // End of variables declaration//GEN-END:variables
}
