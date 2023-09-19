package Model;

import Main.JoUploadFile;
import Tools.JoCreateImage;
import java.io.File;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FileTranferModel {

    private int FileTranferID;
    private int FinancialID;
    private Date FileTranferDate;
    private String TransferTime;
    private File File;
    private String FileName;

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
                URL url = new URL("http://sayfoneapi/imageAPI.php?fileName=" + FileName);
                return new ImageIcon(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ImageIcon(getClass().getResource("/Source/empty.png"));
        }
    }

    @Override
    public String toString() {
        return "FileTranferModel{" + "FileTranferID=" + FileTranferID + ", FinancialID=" + FinancialID + ", FileTranferDate=" + FileTranferDate + ", TransferTime=" + TransferTime + ", File=" + File + ", FileName=" + FileName + '}';
    }

}
