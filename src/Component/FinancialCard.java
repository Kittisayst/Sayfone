package Component;

import Components.JoLable;
import javax.swing.ImageIcon;

public class FinancialCard extends javax.swing.JPanel {
    
    public FinancialCard() {
        initComponents();
    }
    
    public JoLable getLblCount() {
        return lblCount;
    }
    
    public JoLable getLblTitle() {
        return lblTitle;
    }
    
    public void showNo(String no) {
        lblNo.setText("ເລກທີ: " + no);
    }
    
    public void showFinacialType(int money) {
      lblType.setText(money+" ກີບ");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new Components.JoLable();
        lblCount = new Components.JoLable();
        lblType = new Components.JoLable();
        lblNo = new Components.JoLable();

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Date");
        lblTitle.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N

        lblCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCount.setText("Count");

        lblType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/cash.png"))); // NOI18N
        lblType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNo.setText("ເລກທີ:");
        lblNo.setFont(new java.awt.Font("Phetsarath OT", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(lblCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoLable lblCount;
    private Components.JoLable lblNo;
    private Components.JoLable lblTitle;
    private Components.JoLable lblType;
    // End of variables declaration//GEN-END:variables
}
