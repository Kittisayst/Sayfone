package Model;

import java.io.File;

public class FileModel {

    private int FileID;
    private int ID;
    private String FlieName;
    private String Comments;
    private File file;

    public FileModel() {
    }

    public FileModel(int FileID, int ID, String FlieName, String Comments, File file) {
        this.FileID = FileID;
        this.ID = ID;
        this.FlieName = FlieName;
        this.Comments = Comments;
        this.file = file;
    }

    public int getFileID() {
        return FileID;
    }

    public void setFileID(int FileID) {
        this.FileID = FileID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFlieName() {
        return FlieName;
    }

    public void setFlieName(String FlieName) {
        this.FlieName = FlieName;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileModel{" + "FileID=" + FileID + ", ID=" + ID + ", FlieName=" + FlieName + ", Comments=" + Comments + ", file=" + file + '}';
    }

}
