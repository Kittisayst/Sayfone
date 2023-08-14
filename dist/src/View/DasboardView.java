package View;

import Chart.PieChartUI;
import Chart.PieChartUIModel;
import Component.JoDashboardItem;
import java.util.List;

public class DasboardView extends javax.swing.JPanel {
    
    public DasboardView() {
        initComponents();
    }
    
    public void ShowStudentCount(int Count) {
        ds_Student.setItemTitle("" + Count);
    }
    
    public void ShowTeacherCount(int Count) {
        ds_Teacher.setItemTitle("" + Count);
    }
    
    public void showFinalcailCount(int countFinancial) {
        ds_Financail.setItemTitle("" + countFinancial);
    }
    
    public void showRegisterCount(int countRegister) {
        ds_ClassRoom.setItemTitle("" + countRegister);
    }
    
    public JoDashboardItem getDs_Student() {
        return ds_Student;
    }
    
    public JoDashboardItem getDs_Teacher() {
        return ds_Teacher;
    }
    
    public PieChartUI getPieChartElementary() {
        return PieChartKindergarten;
    }
    
    public PieChartUI getPieChartKindergarten() {
        return PieChartElementary;
    }
    
    public PieChartUI getPieChartSecondary() {
        return PieChartSecondary;
    }
    
    public JoDashboardItem getDs_ClassRoom() {
        return ds_ClassRoom;
    }
    
    public JoDashboardItem getDs_Financail() {
        return ds_Financail;
    }
    
    public void showElementary(List<PieChartUIModel> models) {
        models.forEach(data -> {
            PieChartElementary.addData(data);
        });
    }
    
    public void showKindergarten(List<PieChartUIModel> models) {
        models.forEach(data -> {
            PieChartKindergarten.addData(data);
        });
    }
    
    public void showSecondary(List<PieChartUIModel> models) {
        models.forEach(data -> {
            PieChartSecondary.addData(data);
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ds_Student = new Component.JoDashboardItem();
        ds_Teacher = new Component.JoDashboardItem();
        ds_ClassRoom = new Component.JoDashboardItem();
        ds_Financail = new Component.JoDashboardItem();
        joPanelTitle1 = new Components.JoPanelTitle();
        PieChartElementary = new Chart.PieChartUI();
        joPanelTitle2 = new Components.JoPanelTitle();
        PieChartKindergarten = new Chart.PieChartUI();
        joPanelTitle3 = new Components.JoPanelTitle();
        PieChartSecondary = new Chart.PieChartUI();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)), "Dashboard", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Phetsarath OT", 0, 18))); // NOI18N

        ds_Student.setForeground(new java.awt.Color(255, 255, 255));
        ds_Student.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);
        ds_Student.setItemBackground(new java.awt.Color(0, 153, 153));
        ds_Student.setItemDetail("ນັກຮຽນ");
        ds_Student.setItemTitle("205");

        ds_Teacher.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_BOX);
        ds_Teacher.setItemBackground(new java.awt.Color(142, 144, 124));
        ds_Teacher.setItemDetail("ຄູສອນ");
        ds_Teacher.setItemTitle("200");

        ds_ClassRoom.setItemBackground(new java.awt.Color(255, 204, 0));
        ds_ClassRoom.setItemDetail("ຫ້ອງຮຽນ");
        ds_ClassRoom.setItemTitle("50");

        ds_Financail.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
        ds_Financail.setItemBackground(new java.awt.Color(0, 153, 51));
        ds_Financail.setItemDetail("ຈ່າຍຄ່າຮຽນ");
        ds_Financail.setItemTitle("150");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(ds_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(ds_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(ds_ClassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 22, Short.MAX_VALUE)
                .addComponent(ds_Financail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ds_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(ds_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(ds_ClassRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ds_Financail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        joPanelTitle1.setJoTitle("ນັກຮຽນ ອານຸບານ");
        joPanelTitle1.setJoTitlePosition(Components.JoPanelTitle.JoTitlePosition.Center);

        PieChartElementary.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout joPanelTitle1Layout = new javax.swing.GroupLayout(joPanelTitle1);
        joPanelTitle1.setLayout(joPanelTitle1Layout);
        joPanelTitle1Layout.setHorizontalGroup(
            joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, joPanelTitle1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PieChartElementary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        joPanelTitle1Layout.setVerticalGroup(
            joPanelTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PieChartElementary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        joPanelTitle2.setJoTitle("ນັກຮຽນ ປະຖົມ");
        joPanelTitle2.setJoTitlePosition(Components.JoPanelTitle.JoTitlePosition.Center);

        PieChartKindergarten.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout joPanelTitle2Layout = new javax.swing.GroupLayout(joPanelTitle2);
        joPanelTitle2.setLayout(joPanelTitle2Layout);
        joPanelTitle2Layout.setHorizontalGroup(
            joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, joPanelTitle2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PieChartKindergarten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        joPanelTitle2Layout.setVerticalGroup(
            joPanelTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PieChartKindergarten, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        joPanelTitle3.setJoTitle("ນັກຮຽນ ມັດທະຍົມ");
        joPanelTitle3.setJoTitlePosition(Components.JoPanelTitle.JoTitlePosition.Center);

        PieChartSecondary.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout joPanelTitle3Layout = new javax.swing.GroupLayout(joPanelTitle3);
        joPanelTitle3.setLayout(joPanelTitle3Layout);
        joPanelTitle3Layout.setHorizontalGroup(
            joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, joPanelTitle3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PieChartSecondary, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );
        joPanelTitle3Layout.setVerticalGroup(
            joPanelTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanelTitle3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PieChartSecondary, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(joPanelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joPanelTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joPanelTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(joPanelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(joPanelTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
                .addGap(152, 152, 152))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Chart.PieChartUI PieChartElementary;
    private Chart.PieChartUI PieChartKindergarten;
    private Chart.PieChartUI PieChartSecondary;
    private Component.JoDashboardItem ds_ClassRoom;
    private Component.JoDashboardItem ds_Financail;
    private Component.JoDashboardItem ds_Student;
    private Component.JoDashboardItem ds_Teacher;
    private javax.swing.JPanel jPanel1;
    private Components.JoPanelTitle joPanelTitle1;
    private Components.JoPanelTitle joPanelTitle2;
    private Components.JoPanelTitle joPanelTitle3;
    // End of variables declaration//GEN-END:variables

}
