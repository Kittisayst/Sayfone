package Model;

import Database.JoProperties;
import Main.JoHttp;
import Tools.JoFileSystem;
import java.io.File;
import java.sql.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FileTranferModel {

    private int FileTranferID;
    private int FinancialID;
    private Date FileTranferDate;
    private String TransferTime;
    private File File;
    private String FileName;
    private JoProperties property = new JoProperties("/JoConfig/config.properties");
    private String server = property.getValueAt("db.Server");

    public FileTranferModel() {
    }

    public FileTranferModel(int FileTranferID, int FinancialID, Date FileTranferDate, String TransferTime, File File, String FileName) {
        this.FileTranferID = FileTranferID;
        this.FinancialID = FinancialID;
        this.FileTranferDate = FileTranferDate;
        this.TransferTime = TransferTime;
        this.File = File;
        this.FileName = FileName;
    }

    public int getFileTranferID() {
        return FileTranferID;
    }

    public void setFileTranferID(int FileTranferID) {
        this.FileTranferID = FileTranferID;
    }

    public int getFinancialID() {
        return FinancialID;
    }

    public void setFinancialID(int FinancialID) {
        this.FinancialID = FinancialID;
    }

    public Date getFileTranferDate() {
        return FileTranferDate;
    }

    public void setFileTranferDate(Date FileTranferDate) {
        this.FileTranferDate = FileTranferDate;
    }

    public String getTransferTime() {
        return TransferTime;
    }

    public void setTransferTime(String TransferTime) {
        this.TransferTime = TransferTime;
    }

    public File getFile() {
        return File;
    }

    public void setFile(File File) {
        this.File = File;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public Icon getImageIcon() {
        try {
            if (FileName == null) {
                return new ImageIcon(getClass().getResource("/Source/empty.jpg"));
            } else {
                JoFileSystem fileSystem = new JoFileSystem();
                String utl = "http://" + server + "/imageAPI.php?fileName=" + FileName;
                String savepath = fileSystem.getCurrentPath() + "/ResizeImage/" + FileName;
                JoHttp johttp = new JoHttp(utl);
                johttp.Open();
                if (johttp.getResponseContent().equals("Image not found.")) {
                    return new ImageIcon(getClass().getResource("/Source/empty.jpg"));
                } else {
                    johttp.DownloadFile(utl, FileName, savepath);
                    return new ImageIcon(savepath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ImageIcon(getClass().getResource("/Source/empty.png"));
        }
    }

    public boolean checkURLImage() {
        JoHttp http = new JoHttp("http://" + server + "/imageAPI.php?fileName=" + FileName);
        return http.Open();
    }

    @Override
    public String toString() {
        return "FileTranferModel{" + "FileTranferID=" + FileTranferID + ", FinancialID=" + FinancialID + ", FileTranferDate=" + FileTranferDate + ", TransferTime=" + TransferTime + ", File=" + File + ", FileName=" + FileName + '}';
    }

}
