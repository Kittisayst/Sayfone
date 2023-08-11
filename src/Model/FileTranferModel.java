package Model;

import Tools.JoCreateImage;
import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

public class FileTranferModel {

    private int FileTranferID;
    private int FinancialID;
    private Date FileTranferDate;
    private String TransferTime;
    private File File;
    private Blob Image;

    public FileTranferModel() {
    }

    public FileTranferModel(int FileTranferID, int FinancialID, Date FileTranferDate, String TransferTime, File File) {
        this.FileTranferID = FileTranferID;
        this.FinancialID = FinancialID;
        this.FileTranferDate = FileTranferDate;
        this.TransferTime = TransferTime;
        this.File = File;
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

    public Blob getImage() {
        return Image;
    }

    public void setImage(Blob Image) {
        this.Image = Image;
    }

    public Icon getImageIcon() {
        try {
            return new JoCreateImage().JoCreateImage(Image);
        } catch (Exception ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String toString() {
        return "FileTranferModel{" + "FileTranferID=" + FileTranferID + ", FinancialID=" + FinancialID + ", FileTranferDate=" + FileTranferDate + ", TransferTime=" + TransferTime + ", File=" + File + ", Image=" + Image + '}';
    }



}
