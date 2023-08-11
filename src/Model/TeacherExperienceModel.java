package Model;

import java.sql.Date;

public class TeacherExperienceModel {

    private int ExperienceID;
    private int TeacherID;
    private String ExperienceName;
    private String ExperiencePlace;
    private String ExperienceInfo;
    private Date ExperienceDateStart;
    private Date ExperienceDateStop;

    public TeacherExperienceModel() {
    }

    public TeacherExperienceModel(int ExperienceID, int TeacherID, String ExperienceName, String ExperiencePlace, String ExperienceInfo, Date ExperienceDateStart, Date ExperienceDateStop) {
        this.ExperienceID = ExperienceID;
        this.TeacherID = TeacherID;
        this.ExperienceName = ExperienceName;
        this.ExperiencePlace = ExperiencePlace;
        this.ExperienceInfo = ExperienceInfo;
        this.ExperienceDateStart = ExperienceDateStart;
        this.ExperienceDateStop = ExperienceDateStop;
    }

    public int getExperienceID() {
        return ExperienceID;
    }

    public void setExperienceID(int ExperienceID) {
        this.ExperienceID = ExperienceID;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getExperienceName() {
        return ExperienceName;
    }

    public void setExperienceName(String ExperienceName) {
        this.ExperienceName = ExperienceName;
    }

    public String getExperiencePlace() {
        return ExperiencePlace;
    }

    public void setExperiencePlace(String ExperiencePlace) {
        this.ExperiencePlace = ExperiencePlace;
    }

    public Date getExperienceDateStart() {
        return ExperienceDateStart;
    }

    public void setExperienceDateStart(Date ExperienceDateStart) {
        this.ExperienceDateStart = ExperienceDateStart;
    }

    public Date getExperienceDateStop() {
        return ExperienceDateStop;
    }

    public void setExperienceDateStop(Date ExperienceDateStop) {
        this.ExperienceDateStop = ExperienceDateStop;
    }

    public String getExperienceInfo() {
        return ExperienceInfo;
    }

    public void setExperienceInfo(String ExperienceInfo) {
        this.ExperienceInfo = ExperienceInfo;
    }

}
