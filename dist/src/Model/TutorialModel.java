package Model;

import java.awt.event.MouseListener;
import java.io.File;

public class TutorialModel {

    private String Title;
    private String fileName;
    private String time;
    private File file;
    private MouseListener tutorEvet;

    public TutorialModel(String Title, String fileName, String time, File file, MouseListener tutorEvet) {
        this.Title = Title;
        this.fileName = fileName;
        this.time = time;
        this.file = file;
        this.tutorEvet = tutorEvet;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public MouseListener getTutorEvet() {
        return tutorEvet;
    }

    public void setTutorEvet(MouseListener tutorEvet) {
        this.tutorEvet = tutorEvet;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    


}
