package Component;

import App.AppHome;
import Components.JoLable;
import DAOSevervice.TeacherExperienceService;
import DAOSevervice.TeacherRankService;
import DAOSevervice.TeacherService;
import DAOSevervice.YearService;
import Model.GlobalDataModel;
import Model.TeacherExperienceModel;
import Model.TeacherModel;
import Model.TeacherRankModel;
import Model.YearModel;
import Tools.JoAlert;
import Utility.MyFormat;
import Utility.WrapLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JPanel;
import theme.JoTheme;

public class TeacherRanking extends javax.swing.JPanel {

    private final Color ColorSelect = JoTheme.Danger;
    private final Color ColorNotSelect = JoTheme.Primary;
    private final TeacherRankModel rankModel;

    public TeacherRanking(TeacherModel model, YearModel yearModel) {
        initComponents();
        lblTeacherImage.setIcon(model.getImageIcon());
        lblTeacherName.setText(model.getFullName().toString());
        TeacherRankService rankService = new TeacherRankService();
        rankModel = rankService.getTeacherRankByTeacherId(model.getTeacherID(), yearModel.getYearID());
        //ກຳນົດຄ່າເພື່ອນຳໄປເພີ່ມຂໍ້ມູນ
        rankModel.setTeacherID(model.getTeacherID());
        rankModel.setYearID(yearModel.getYearID());
        //ສະແດງອັນດັບ
        showRank(rankModel.getRank());
    }

    private void showRank(int Rank) {
        resetColor();
        switch (Rank) {
            case 1:
                lblYear.setText("ຈັດອັນດັບ( " + Rank + " )");
                btn1.setBackground(ColorSelect);
                break;
            case 2:
                lblYear.setText("ຈັດອັນດັບ( " + Rank + " )");
                btn2.setBackground(ColorSelect);
                break;
            case 3:
                lblYear.setText("ຈັດອັນດັບ( " + Rank + " )");
                btn3.setBackground(ColorSelect);
                break;
            case 4:
                lblYear.setText("ຈັດອັນດັບ( " + Rank + " )");
                btn4.setBackground(ColorSelect);
                break;
            case 5:
                lblYear.setText("ຈັດອັນດັບ( " + Rank + " )");
                btn5.setBackground(ColorSelect);
                break;
            default:
                resetColor();
                break;
        }
    }

    private void addRankEvent(int Rank, TeacherRankModel model) {
        System.out.println("Rank " + Rank);
        model.setRank(Rank);
        if (model.getTeacherRankID() == 0) {
            new TeacherRankService().CreaterTeacherRank(model);
            showRank(Rank);
        } else {
            System.out.println("Update" + model.getRank());
            new TeacherRankService().UpdateTeacherRank(model);
            showRank(Rank);
        }
    }

    private void resetColor() {
        lblYear.setText("ຍັງບໍ່ຈັດອັນດັບ");
        btn1.setBackground(ColorNotSelect);
        btn2.setBackground(ColorNotSelect);
        btn3.setBackground(ColorNotSelect);
        btn4.setBackground(ColorNotSelect);
        btn5.setBackground(ColorNotSelect);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTeacherImage = new Components.JoImageAvatar();
        lblTeacherName = new Components.JoLable();
        jPanel1 = new javax.swing.JPanel();
        btn1 = new Components.JoButtonIconfont();
        btn2 = new Components.JoButtonIconfont();
        btn3 = new Components.JoButtonIconfont();
        btn4 = new Components.JoButtonIconfont();
        btn5 = new Components.JoButtonIconfont();
        lblYear = new Components.JoLable();
        btnMore = new Components.JoButtonIconfont();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        lblTeacherName.setText("joLable1");

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btn1.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOOKS_ONE);
        btn1.setMinimumSize(new java.awt.Dimension(30, 41));
        btn1.setPreferredSize(new java.awt.Dimension(30, 30));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btn1, gridBagConstraints);

        btn2.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOOKS_TWO);
        btn2.setMinimumSize(new java.awt.Dimension(30, 41));
        btn2.setPreferredSize(new java.awt.Dimension(30, 30));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btn2, gridBagConstraints);

        btn3.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOOKS_3);
        btn3.setMinimumSize(new java.awt.Dimension(30, 41));
        btn3.setPreferredSize(new java.awt.Dimension(30, 30));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btn3, gridBagConstraints);

        btn4.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOOKS_4);
        btn4.setMinimumSize(new java.awt.Dimension(30, 41));
        btn4.setPreferredSize(new java.awt.Dimension(30, 30));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btn4, gridBagConstraints);

        btn5.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOOKS_5);
        btn5.setMinimumSize(new java.awt.Dimension(30, 41));
        btn5.setPreferredSize(new java.awt.Dimension(30, 30));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        jPanel1.add(btn5, gridBagConstraints);

        lblYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYear.setText("ຈັດອັນດັບ");
        lblYear.setFont(new java.awt.Font("Phetsarath OT", 1, 12)); // NOI18N

        btnMore.setText("ຂໍ້ມູນຜົນງານ");
        btnMore.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.MORE_HORIZ);
        btnMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTeacherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTeacherName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTeacherImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        addRankEvent(1, rankModel);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        addRankEvent(2, rankModel);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        addRankEvent(3, rankModel);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        addRankEvent(4, rankModel);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        addRankEvent(5, rankModel);
    }//GEN-LAST:event_btn5ActionPerformed
    int no = 1;
    private void btnMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreActionPerformed
        JoAlert alert = new JoAlert();
        MyFormat fm = new MyFormat();
        YearModel model = new YearService().getYearById(rankModel.getYearID());
        TeacherModel teacherModel = new TeacherService().getTeacherById(rankModel.getTeacherID());
        List<TeacherExperienceModel> models = new TeacherExperienceService().getExperienceBetweenYear(rankModel.getTeacherID(), model.getYear());
        JPanel panel = new JPanel(new WrapLayout(FlowLayout.LEFT, 5, 5));
        models.forEach(data -> {
            JoLable lable = new JoLable();
            lable.setFont(new Font(lable.getFont().getFamily(), 0, 18));
            lable.setText(no +". "+ data.getExperienceName() + " " + data.getExperiencePlace() + " " + data.getExperienceInfo() + " " + fm.getDate(data.getExperienceDateStart()) + " " + fm.getDate(data.getExperienceDateStop()));
            panel.add(lable);
            no++;
        });
        DialogExperience experience = new DialogExperience(GlobalDataModel.rootView, true);
        experience.setTitle(teacherModel.getFullName() + " ປະສົບການສົກຮຽນ: " + model.getYear());
        experience.add(panel, BorderLayout.CENTER);
        experience.setVisible(true);
    }//GEN-LAST:event_btnMoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btn1;
    private Components.JoButtonIconfont btn2;
    private Components.JoButtonIconfont btn3;
    private Components.JoButtonIconfont btn4;
    private Components.JoButtonIconfont btn5;
    private Components.JoButtonIconfont btnMore;
    private javax.swing.JPanel jPanel1;
    private Components.JoImageAvatar lblTeacherImage;
    private Components.JoLable lblTeacherName;
    private Components.JoLable lblYear;
    // End of variables declaration//GEN-END:variables
}
