package View;

import App.AppDashboard;
import Components.JoButtonIconfont;
import Database.JoProperties;
import Log.JoLoger;
import Tools.JoAlert;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class PrinterView extends javax.swing.JPanel {

    private final JoProperties properties = new JoProperties("Info/About.properties");

    public PrinterView(String Title) {
        initComponents();
        lbl_title.setText(Title);
        System.out.println(properties.getValueAt("Copies"));
        System.out.println(properties.getValueAt("PrinterName"));
//        PrinterName
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        int index = 0;
        for (PrintService printService : printServices) {
            cbPrinterName.JoAddIntModel(index++, printService.getName());
        }
        cbPrinterName.setSelectedItem(properties.getValueAt("PrinterName"));
        cbCopies.setSelectedItem(properties.getValueAt("Copies"));
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
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
        joPanel1 = new Components.JoPanel();
        cbPrinterName = new Components.JoCombobox();
        btnSave = new Components.JoButtonIconfont();
        joLable1 = new Components.JoLable();
        cbCopies = new Components.JoCombobox();
        joLable2 = new Components.JoLable();

        Pn_Navigation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Pn_Navigation.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btn_back.setText("ກັບຄືນ");
        btn_back.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ARROW_BACK);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel3.add(btn_back);

        Pn_Navigation.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        lbl_title.setText("Title");
        lbl_title.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel4.add(lbl_title);

        Pn_Navigation.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        Pn_Navigation.add(jPanel5);

        joPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        joPanel1.add(cbPrinterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 330, 35));

        btnSave.setText("ບັນທຶກ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        joPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 330, -1));

        joLable1.setText("ຈຳນວນໜ້າ");
        joPanel1.add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 330, 30));

        cbCopies.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        joPanel1.add(cbCopies, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 330, 35));

        joLable2.setText("ຕັ້ງຄ່າປີ້ນເຕີ");
        joPanel1.add(joLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 39, 330, 30));

        javax.swing.GroupLayout pn_DatatableLayout = new javax.swing.GroupLayout(pn_Datatable);
        pn_Datatable.setLayout(pn_DatatableLayout);
        pn_DatatableLayout.setHorizontalGroup(
            pn_DatatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DatatableLayout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(joPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        pn_DatatableLayout.setVerticalGroup(
            pn_DatatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DatatableLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(joPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            properties.addValue("PrinterName", cbPrinterName.getValue());
            properties.addValue("Copies", cbCopies.getValue());
            new JoAlert().messages("ບັນທຶກ", "ບັນທຶກການຕັ້ງຄ່າປີ້ນເຕີສຳເລັດ", JoAlert.Icons.success);
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
      AppDashboard dashboard = new AppDashboard();
    }//GEN-LAST:event_btn_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnSave;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbCopies;
    private Components.JoCombobox cbPrinterName;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoPanel joPanel1;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    // End of variables declaration//GEN-END:variables
}
