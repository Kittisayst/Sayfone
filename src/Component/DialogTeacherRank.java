package Component;

import DAOSevervice.TeacherRankService;
import DAOSevervice.TeacherService;
import DAOSevervice.YearService;
import Model.TeacherModel;
import Model.TeacherRankModel;
import View.TeacherRinkView;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class DialogTeacherRank extends javax.swing.JDialog {

    TeacherRinkView view;
    private TeacherModel teacherModel;
    TeacherRankService rankService = new TeacherRankService();
    private int YearID, Month;

    public DialogTeacherRank(java.awt.Frame parent, boolean modal, TeacherModel teacherModel, int YearID, int Month, TeacherRinkView view) {
        super(parent, modal);
        initComponents();
        this.view = view;
        this.teacherModel = teacherModel;
        this.YearID = YearID;
        this.Month = Month;
        lblTeacherName.setText(teacherModel.getFullName().toString());
        setTitle("ຈັດອັນດັບຄູປະຈຳເດືອນ: " + this.Month);
        TeacherRankModel rankModel = rankService.getTeacherRankByTeacherId(teacherModel.getTeacherID(), YearID, Month);
        JRadioButton selectRadio = (JRadioButton) pnRank.getComponent(rankModel.getRank() == 0 ? 0 : rankModel.getRank() - 1);
        selectRadio.setSelected(true);
        for (int i = 0; i < pnRank.getComponentCount(); i++) {
            JRadioButton radioButton = (JRadioButton) pnRank.getComponent(i);
            radioButton.addActionListener((ActionEvent e) -> {;
                Save(rankModel, Integer.parseInt(radioButton.getName()));
            });
        }
    }

    private void Save(TeacherRankModel rankModel, int Rank) {
        if (rankModel.getTeacherRankID() == 0) {
            rankModel.setTeacherID(teacherModel.getTeacherID());
            rankModel.setYearID(YearID);
            rankModel.setRank(Rank);
            rankModel.setMonth(Month);
            rankService.CreaterTeacherRank(rankModel);
        } else {
            rankModel.setRank(Rank);
            rankService.UpdateTeacherRank(rankModel);
        }
        view.showTeacher(new TeacherService().getAllTeacher(), new YearService().getYearById(YearID));
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTeacherName = new Components.JoLable();
        pnRank = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTeacherName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTeacherName.setText("joLable1");
        lblTeacherName.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        getContentPane().add(lblTeacherName, gridBagConstraints);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jRadioButton1.setText("ອັນດັບ 1");
        jRadioButton1.setFocusable(false);
        jRadioButton1.setName("1"); // NOI18N
        pnRank.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jRadioButton2.setText("ອັນດັບ 2");
        jRadioButton2.setFocusable(false);
        jRadioButton2.setName("2"); // NOI18N
        pnRank.add(jRadioButton2);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jRadioButton3.setText("ອັນດັບ 3");
        jRadioButton3.setFocusable(false);
        jRadioButton3.setName("3"); // NOI18N
        pnRank.add(jRadioButton3);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jRadioButton4.setText("ອັນດັບ 4");
        jRadioButton4.setFocusable(false);
        jRadioButton4.setName("4"); // NOI18N
        pnRank.add(jRadioButton4);

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jRadioButton5.setText("ອັນດັບ 5");
        jRadioButton5.setFocusable(false);
        jRadioButton5.setName("5"); // NOI18N
        pnRank.add(jRadioButton5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(pnRank, gridBagConstraints);

        setSize(new java.awt.Dimension(512, 175));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private Components.JoLable lblTeacherName;
    private javax.swing.JPanel pnRank;
    // End of variables declaration//GEN-END:variables
}
