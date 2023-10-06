package Model;

import java.io.File;
import java.sql.Date;

public class StudentFileModel {

    private int FileID;
    private int StudentID;
    private String FileName;
    private Date SaveDate;
    private String Comment;
    private File file;

    public StudentFileModel() {
    }

    public StudentFileModel(int FileID, int StudentID, String FileName, Date SaveDate, String Comment, File file) {
        this.FileID = FileID;
        this.StudentID = StudentID;
        this.FileName = FileName;
        this.SaveDate = SaveDate;
        this.Comment = Comment;
        this.file = file;
    }

    public int getFileID() {
        return FileID;
    }

    public void setFileID(int FileID) {
        this.FileID = FileID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public Date getSaveDate() {
        return SaveDate;
    }

    public void setSaveDate(Date SaveDate) {
        this.SaveDate = SaveDate;
    }

    public String getComment() {
        return Comment == null ? "..." : Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "StudentFileModel{" + "FileID=" + FileID + ", StudentID=" + StudentID + ", FileName=" + FileName + ", SaveDate=" + SaveDate + ", Comment=" + Comment + ", file=" + file + '}';
    }

}
