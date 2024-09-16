package View;

import Chart.PieChartUI;
import Chart.PieChartUIModel;
import DAOSevervice.SayfoneService;
import Model.SayfoneModel;
import Model.StudentKnowModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ReportStudentKnowView extends javax.swing.JPanel {

    public ReportStudentKnowView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void handelBack(ActionListener evt) {
        btn_back.addActionListener(evt);
    }

    public void showChart(List<StudentKnowModel> models) {
        PieChartUI pie = new PieChartUI();
        Random random = new Random();

        for (StudentKnowModel item : models) {
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color randomColor = new Color(red, green, blue);
            //item.getStudentID() = count Value
            pie.addData(new PieChartUIModel(getKnowName(item.getKnowIndex()), item.getStudentID(), randomColor));
        }
        pn_Datatable.add(pie, BorderLayout.CENTER);
    }

    private String getKnowName(int index) {
        try {
            SayfoneModel model = new SayfoneService().getById(2);
            String str = model.getEnglish();
            String[] array = str.substring(1, str.length() - 1).split(", ");
            List<String> result = Arrays.stream(array)
                    .map(s -> s.replaceAll("\"", ""))
                    .collect(Collectors.toList());
            return result.get(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "NaN";
        }
    }

    public void handelExport(ActionListener evt) {
        btnExportNkow.addActionListener(evt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        pn_Datatable = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnExportNkow = new Components.JoButtonIconfont();

        Pn_Navigation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Pn_Navigation.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btn_back.setText("ກັບຄືນ");
        btn_back.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ARROW_BACK);
        jPanel3.add(btn_back);

        Pn_Navigation.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        lbl_title.setText("Title");
        lbl_title.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel4.add(lbl_title);

        Pn_Navigation.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        Pn_Navigation.add(jPanel5);

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnExportNkow.setBackground(new java.awt.Color(0, 102, 102));
        btnExportNkow.setText("Excel");
        btnExportNkow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.GRID_ON);
        jPanel1.add(btnExportNkow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnExportNkow;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    // End of variables declaration//GEN-END:variables
}
