package Model;

import java.sql.Date;

public class TeacherEducationModel {

    private int TeacherEducationID;
    private int TeacherID;
    private int educationCat;
    private String MajorName;
    private String InstitutionName;
    private Date graduatDate;

    public int getTeacherEducationID() {
        return TeacherEducationID;
    }

    public void setTeacherEducationID(int TeacherEducationID) {
        this.TeacherEducationID = TeacherEducationID;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public int getEducationCat() {
        return educationCat;
    }

    public void setEducationCat(int educationCat) {
        this.educationCat = educationCat;
    }

    public String getMajorName() {
        return MajorName;
    }

    public void setMajorName(String MajorName) {
        this.MajorName = MajorName;
    }

    public String getInstitutionName() {
        return InstitutionName;
    }

    public void setInstitutionName(String InstitutionName) {
        this.InstitutionName = InstitutionName;
    }

    public Date getGraduatDate() {
        return graduatDate;
    }

    public void setGraduatDate(Date graduatDate) {
        this.graduatDate = graduatDate;
    }

    public Object getEducationName(int educationCat) {
        switch (educationCat) {
            case 0:
                return "ຊັ້ນກາງ";
            case 1:
                return "ຊັ້ນສູງ";
            case 2:
                return "ປະລິນຍາຕີ";
            case 3:
                return "ປະລິນຍາໂທ";
            case 4:
                return "ປະລິນຍາເອກ";
            default:
                return "NULL";
        }
    }

}
