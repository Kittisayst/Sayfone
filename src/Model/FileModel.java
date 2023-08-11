package Model;

import java.io.File;
import java.sql.Blob;

public class FileModel {

    private int TeacherFileID;
    private int TeacherID;
    private String FlieName;
    private Blob File;
    private String Comments;
    private File LocalFile;

    public FileModel() {
    }

    public FileModel(int TeacherFileID) {
        this.TeacherFileID = TeacherFileID;
    }

    public FileModel(int TeacherFileID, String FielName, Blob File, String Comments) {
        this.TeacherFileID = TeacherFileID;
//        this.FielName = FielName;
        this.File = File;
        this.Comments = Comments;
    }

    public int getTeacherFileID() {
        return TeacherFileID;
    }

    public void setTeacherFileID(int TeacherFileID) {
        this.TeacherFileID = TeacherFileID;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getFlieName() {
        return FlieName;
    }

    public void setFlieName(String FlieName) {
        this.FlieName = FlieName;
    }

    public Blob getFile() {
        return File;
    }

    public void setFile(Blob File) {
        this.File = File;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public File getLocalFile() {
        return LocalFile;
    }

    public void setLocalFile(File LocalFile) {
        this.LocalFile = LocalFile;
    }

}
