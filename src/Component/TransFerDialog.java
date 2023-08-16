package Component;

import Model.FileTranferModel;
import Tools.JoFileSystem;
import Tools.JoFilechooser;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.ImageIcon;

public class TransFerDialog extends javax.swing.JDialog {

    private FileTranferModel tranferModel = new FileTranferModel();

    private boolean openFile;
    private boolean submit = false;
    JoFilechooser filechooser = new JoFilechooser();

    public TransFerDialog(java.awt.Frame parent, boolean modal, FileTranferModel tranferModel) {
        super(parent, modal);
        initComponents();
        this.tranferModel = tranferModel;
        dtDate.setDateData(new Date());
        LocalTime currentTime = LocalTime.now();
        // Get the hour and minute
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        Timer.setTime(hour, minute);
        if (tranferModel.getFileTranferID() == 0) {
            btnAddImage.doClick();
        } else {
            dtDate.setDateData(tranferModel.getFileTranferDate());
            String[] parts = tranferModel.getTransferTime().split(":");
            String strhour = parts[0]; // "15"
            String strminute = parts[1]; // "50"
            Timer.setTime(Integer.parseInt(strhour), Integer.parseInt(strminute));
            lblImage.setIcon(tranferModel.getImageIcon());
        }

    }

    public FileTranferModel getTranferModel() {
        return tranferModel;
    }

    public void setTranferModel(FileTranferModel tranferModel) {
        this.tranferModel = tranferModel;
    }

    public boolean isSubmit() {
        return submit;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new Components.JoButtonIconfont();
        dtDate = new Components.JoDateChooser();
        Timer = new Component.TimeSelector();
        joLable2 = new Components.JoLable();
        joLable3 = new Components.JoLable();
        joLable4 = new Components.JoLable();
        joLable1 = new Components.JoLable();
        txtPath = new Components.JoTextField();
        btnAddImage = new Components.JoButtonIconfont();
        btnOpenCarmera = new Components.JoButtonIconfont();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new Components.JoLabelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 153, 102));
        btnSave.setText("ບັນທຶກ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.setJocolorHover(new java.awt.Color(3, 112, 76));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        Timer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 118, 210)));

        joLable2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable2.setText("ຫຼັ້ກຖານການໂອນ");
        joLable2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N

        joLable3.setText("ເວລາ");

        joLable4.setText("ວັນທີ່");

        joLable1.setText("ເອກະສານ");

        txtPath.setEditable(false);
        txtPath.setPlaceholder("ເອກະສານ");

        btnAddImage.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ATTACH_FILE);
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });

        btnOpenCarmera.setBackground(new java.awt.Color(0, 153, 204));
        btnOpenCarmera.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ADD_A_PHOTO);
        btnOpenCarmera.setJocolorHover(new java.awt.Color(0, 111, 149));
        btnOpenCarmera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenCarmeraActionPerformed(evt);
            }
        });

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 118, 210)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpenCarmera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(joLable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joLable4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joLable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Timer, javax.swing.GroupLayout.PREFERRED_SIZE, 227, Short.MAX_VALUE))))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(Timer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOpenCarmera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        setSize(new java.awt.Dimension(565, 643));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenCarmeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenCarmeraActionPerformed
        JoFileSystem fileSystem = new JoFileSystem();
        fileSystem.OpenFile(fileSystem.getCurrentPath() + "/webcamera/Camera.html");
    }//GEN-LAST:event_btnOpenCarmeraActionPerformed

    private void btnAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImageActionPerformed
        filechooser.addFilter("JPG", "jpg");
        filechooser.addFilter("PNG", "png");
        openFile = filechooser.showOpenDialog(null);
        if (openFile) {
            txtPath.setText(filechooser.getSelectedFile().getName());
            lblImage.setIcon(new ImageIcon(filechooser.getSelectedFile().getAbsolutePath()));
        }
    }//GEN-LAST:event_btnAddImageActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        submit = true;
        if (tranferModel.getFileTranferID() == 0) {
            tranferModel = new FileTranferModel(0, 0, dtDate.getSQLDate(), Timer.getTime(), filechooser.getSelectedFile());
            setVisible(false);
        } else if (tranferModel.getFileTranferID() > 0) {
            tranferModel.setTransferTime(Timer.getTime());
            tranferModel.setFile(filechooser.getSelectedFile());
            setVisible(false);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        submit = false;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        submit = false;
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.TimeSelector Timer;
    private Components.JoButtonIconfont btnAddImage;
    private Components.JoButtonIconfont btnOpenCarmera;
    private Components.JoButtonIconfont btnSave;
    private Components.JoDateChooser dtDate;
    private javax.swing.JPanel jPanel1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLabelImage lblImage;
    private Components.JoTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
