package Component;

import Database.JoConnect;
import Database.JoSQL;
import Log.JoLoger;
import Tools.JoAlert;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DialogCreateImage extends javax.swing.JDialog {

    public DialogCreateImage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 290, 50));

        setSize(new java.awt.Dimension(759, 510));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JoConnect connect = new JoConnect();
        JoSQL sql = new JoSQL(connect.getConnectionDefault(), "tb_filetransfer");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
        String createName = dateFormat.format(new java.util.Date());
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                Blob blob = rs.getBlob(5);
                saveImage(rs.getString(1) + "-" + createName + ".png", rs.getInt(1));
                try (InputStream inputStream = blob.getBinaryStream(); OutputStream outputStream = new FileOutputStream("C:/Users/LENOVO/Downloads/jo/" + rs.getString(1) + "-" + createName + ".png")) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
            System.out.println("finish");

        } catch (SQLException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DialogCreateImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DialogCreateImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DialogCreateImage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connect.close();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveImage(String Name, int ID) {
        JoConnect connect = new JoConnect();
        String sql = "UPDATE tb_filetransfer SET fileName=? WHERE transferID=?";
        try {
            PreparedStatement pre = connect.getConnectionDefault().prepareStatement(sql);
            pre.setString(1, Name);
            pre.setInt(2, ID);
            pre.executeUpdate();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        } finally {
            connect.close();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
