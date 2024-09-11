package Component;

import App.AppDocument;
import DAOSevervice.DocumentService;
import Database.JoProperties;
import Model.DocumentModel;
import Model.GlobalDataModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoFilechooser;
import Utility.MyFormat;
import java.awt.Color;
import java.util.Date;
import javax.swing.ImageIcon;
import theme.JoTheme;

public class DialogDocument extends javax.swing.JDialog {

    JoFilechooser fileDoc = new JoFilechooser();
    JoFilechooser fileImage = new JoFilechooser();
    private JoProperties property = new JoProperties("/JoConfig/config.properties");
    private String server = property.getValueAt("db.Server");
    boolean openDoc = false;
    boolean openImage = false;
    private String Docpath = "";
    private String ImagePath = "";
    private DocumentModel documentModel;
    private DocumentService service;

    public DialogDocument(java.awt.Frame parent, boolean modal, DocumentModel documentModel) {
        super(parent, modal);
        initComponents();
        this.documentModel = documentModel;
        fileImage.addFilter("JPG", "jpg");
        fileImage.addFilter("JPEG", "jpeg");
        fileImage.addFilter("PNG", "png");
        fileImage.addFilter("GIF", "gif");
        service = new DocumentService();
        btnDownload.setVisible(false);
        if (documentModel.getDocumentID() != 0) {
            if (!documentModel.getImagePath().equals("")) {
                lblImage.setIcon(documentModel.getImageIcon());
            }
            txtTitle.setText(documentModel.getTitle());
            txtPath.setText(documentModel.getFileName());
            txtComment.setText(documentModel.getComment());
            Docpath = documentModel.getFilePath();
            ImagePath = documentModel.getImagePath();
            btnDownload.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        joPanel1 = new Components.JoPanel();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new Components.JoLabelImage();
        btnSelectImage = new Components.JoButtonIconfont();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        txtTitle = new Components.JoTextField();
        joLable2 = new Components.JoLable();
        jPanel6 = new javax.swing.JPanel();
        txtPath = new Components.JoTextField();
        btnFile = new Components.JoButtonIconfont();
        joLable3 = new Components.JoLable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComment = new Components.JoTextArea();
        jPanel7 = new javax.swing.JPanel();
        btnSave = new Components.JoButtonIconfont();
        jLabel1 = new javax.swing.JLabel();
        btnDownload = new Components.JoButtonIconfont();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        joPanel1.setBackground(new java.awt.Color(236, 236, 236));
        joPanel1.setJoPrimaryColor(new java.awt.Color(236, 236, 236));
        joPanel1.setJoSecondaryColor(new java.awt.Color(236, 236, 236));
        joPanel1.setMinimumSize(new java.awt.Dimension(200, 137));
        joPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        joPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblImage.setText("joLabelImage1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(lblImage, gridBagConstraints);

        btnSelectImage.setJoIconSize(25);
        btnSelectImage.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.IMAGE);
        btnSelectImage.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnSelectImage.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel2.add(btnSelectImage, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 10);
        joPanel1.add(jPanel2, gridBagConstraints);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        joLable1.setText("ຫົວຂໍ້ເອກະສານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(joLable1, gridBagConstraints);

        txtTitle.setMinimumSize(new java.awt.Dimension(200, 40));
        txtTitle.setPlaceholder("ຫົວຂໍ້ເອກະສານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtTitle, gridBagConstraints);

        joLable2.setText("ເລືອກເອກະສານ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(joLable2, gridBagConstraints);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridBagLayout());

        txtPath.setEditable(false);
        txtPath.setMinimumSize(new java.awt.Dimension(300, 21));
        txtPath.setPlaceholder("ເລືອກເອກະສານ");
        txtPath.setPreferredSize(new java.awt.Dimension(300, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel6.add(txtPath, gridBagConstraints);

        btnFile.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLOUD_UPLOAD);
        btnFile.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel6.add(btnFile, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jPanel6, gridBagConstraints);

        joLable3.setText("ລາຍລະອຽດ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(joLable3, gridBagConstraints);

        jScrollPane2.setMinimumSize(new java.awt.Dimension(16, 200));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(212, 200));

        txtComment.setColumns(20);
        txtComment.setRows(5);
        txtComment.setMinimumSize(new java.awt.Dimension(1, 200));
        txtComment.setPreferredSize(new java.awt.Dimension(200, 200));
        jScrollPane2.setViewportView(txtComment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 2;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jPanel7.setMinimumSize(new java.awt.Dimension(450, 82));
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(550, 0));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        btnSave.setText("ບັນທຶກ");
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 0.1;
        jPanel7.add(btnSave, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel1, gridBagConstraints);

        btnDownload.setBackground(new java.awt.Color(0, 102, 102));
        btnDownload.setText("ດາວໂຫຼດ");
        btnDownload.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLOUD_DOWNLOAD);
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel7.add(btnDownload, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 49;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jPanel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 20, 20);
        joPanel1.add(jPanel1, gridBagConstraints);

        getContentPane().add(joPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1063, 715));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        openDoc = fileDoc.showOpenDialog(null);
        if (openDoc) {
            Docpath = fileDoc.getSelectedFile().getAbsolutePath();
            txtPath.setText(fileDoc.getSelectedFile().getName());
            documentModel.setFileDocument(fileDoc.getSelectedFile());
            LineFileColor(JoTheme.Primary);
        }
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        openImage = fileImage.showOpenDialog(null);
        if (openImage) {
            ImagePath = fileImage.getSelectedFile().getAbsolutePath();
            lblImage.setIcon(new ImageIcon(fileImage.getSelectedFile().getAbsolutePath()));
            documentModel.setFileImage(fileImage.getSelectedFile());
        }
    }//GEN-LAST:event_btnSelectImageActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JoAlert alert = new JoAlert();
        if (txtTitle.TextEmpty()) {
            if (documentModel.getDocumentID() == 0) {
                if (openDoc) {
                    documentModel = new DocumentModel(
                            0,
                            txtTitle.getText(),
                            fileImage.getSelectedFile() == null ? "" : fileImage.getSelectedFile().getName(),
                            fileDoc.getSelectedFile().getName(),
                            fileDoc.getSelectedFile().getName(),
                            txtComment.getText(),
                            new MyFormat().getSQLDate(new Date()),
                            GlobalDataModel.userModel.getUserID(),
                            fileDoc.getSelectedFile(),
                            fileImage.getSelectedFile());
                    alert.JoSubmit(service.create(documentModel), JoAlert.INSERT);
                    new AppDocument().Open();
                    this.dispose();
                } else {
                    alert.messages("ວ່າງເປົ່າ", "ກະລຸນາເລືອກໄຟລ໌ເອກະສານ", JoAlert.Icons.warning);
                    LineFileColor(JoTheme.Danger);
                }
            } else {
                AuthenPopUp auth = new AuthenPopUp(GlobalDataModel.rootView, true);
                auth.setVisible(true);
                UserModel userModel = auth.getUserModel();
                if (userModel.getUserID() != 0) {
                    boolean isSameDoc = documentModel.getFilePath().equals(Docpath);
                    boolean isSameImage = documentModel.getImagePath().equals(ImagePath);
                    documentModel.setTitle(txtTitle.getText());
                    if (!isSameDoc) {
                        documentModel.setFilePath(fileDoc.getSelectedFile() == null ? "" : fileDoc.getSelectedFile().getName());
                    }
                    if (!isSameImage) {
                        documentModel.setImagePath(fileImage.getSelectedFile() == null ? "" : fileImage.getSelectedFile().getName());
                    }
                    documentModel.setFileName(fileDoc.getSelectedFile() == null ? "" : txtPath.getText());
                    documentModel.setComment(txtComment.getText());
                    documentModel.setUploadDate(new MyFormat().getSQLDate(new Date()));
                    documentModel.setUserID(GlobalDataModel.userModel.getUserID());
                    alert.JoSubmit(service.update(documentModel), JoAlert.UPDATE);
                    new AppDocument().Open();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        documentModel.Download();
        new AppDocument().Open();
        this.dispose();
    }//GEN-LAST:event_btnDownloadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnDownload;
    private Components.JoButtonIconfont btnFile;
    private Components.JoButtonIconfont btnSave;
    private Components.JoButtonIconfont btnSelectImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoPanel joPanel1;
    private Components.JoLabelImage lblImage;
    private Components.JoTextArea txtComment;
    private Components.JoTextField txtPath;
    private Components.JoTextField txtTitle;
    // End of variables declaration//GEN-END:variables

    private void LineFileColor(Color lineColor) {
        int joLineSize = txtPath.getJoLineSize();
        txtPath.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, joLineSize, 0, lineColor));
    }

}
