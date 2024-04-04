package Model;

import DAOSevervice.UserService;
import Database.JoProperties;
import Main.JoHttp;
import Tools.JoFileSystem;
import java.io.File;
import java.sql.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DocumentModel {

    private int documentID;
    private String title;
    private String imagePath;
    private String filePath;
    private String fileName;
    private String comment;
    private java.sql.Date uploadDate;
    private int userID;
    private File FileDocument;
    private File FileImage;
    private JoProperties property = new JoProperties("/JoConfig/config.properties");
    private String server = property.getValueAt("db.Server");

    public DocumentModel() {
    }

    public DocumentModel(int documentID, String title, String imagePath, String filePath, String fileName, String comment, Date uploadDate, int userID, File FileDocument, File FileImage) {
        this.documentID = documentID;
        this.title = title;
        this.imagePath = imagePath;
        this.filePath = filePath;
        this.fileName = fileName;
        this.comment = comment;
        this.uploadDate = uploadDate;
        this.userID = userID;
        this.FileDocument = FileDocument;
        this.FileImage = FileImage;
    }

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public File getFileDocument() {
        return FileDocument;
    }

    public void setFileDocument(File FileDocument) {
        this.FileDocument = FileDocument;
    }

    public File getFileImage() {
        return FileImage;
    }

    public void setFileImage(File FileImage) {
        this.FileImage = FileImage;
    }

    public UserModel getUser() {
        return new UserService().getUserById(userID);
    }

    public Icon getImageIcon() {
        try {
            if (imagePath == null) {
                return new ImageIcon(getClass().getResource("/Source/empty.jpg"));
            } else {
                JoFileSystem fileSystem = new JoFileSystem();
                String utl = "http://" + server + "/sayfone/LoadDocument.php?folder=imageFile&fileName=" + imagePath;
                String savepath = fileSystem.getCurrentPath() + "/ResizeImage/" + imagePath;
                JoHttp johttp = new JoHttp(utl);
                johttp.Open();
                if (johttp.getResponseContent().equals("Image not found.")) {
                    return new ImageIcon(getClass().getResource("/Source/empty.jpg"));
                } else {
                    johttp.DownloadFile(utl, imagePath, savepath);
                    return new ImageIcon(savepath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ImageIcon(getClass().getResource("/Source/empty.png"));
        }
    }

    public boolean Download() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String utl = "http://" + server + "/sayfone/LoadDocument.php?folder=docFile&fileName=" + filePath;
            String savepath = fileSystem.getUserPath() + "/Downloads/" + fileName;
            JoHttp johttp = new JoHttp(utl);
            johttp.Open();
            if (johttp.getResponseContent().equals("Image not found.")) {
                return false;
            } else {
                johttp.DownloadFile(utl, fileName, savepath);
                fileSystem.OpenFile(savepath);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return "DocumentModel{" + "documentID=" + documentID + ", title=" + title + ", imagePath=" + imagePath + ", filePath=" + filePath + ", fileName=" + fileName + ", comment=" + comment + ", uploadDate=" + uploadDate + ", userID=" + userID + ", FileDocument=" + FileDocument + ", FileImage=" + FileImage + '}';
    }

}
