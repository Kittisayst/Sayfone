package Model;

import java.sql.Date;

public class AbsentModel {

    private int absentID;
    private int RegisterID;
    private int studentID;
    private Date absentDate;
    private int absentState;
    private int UserID;

    public AbsentModel() {
    }

    public AbsentModel(int absentID, int RegisterID, int studentID, Date absentDate, int absentState, int UserID) {
        this.absentID = absentID;
        this.RegisterID = RegisterID;
        this.studentID = studentID;
        this.absentDate = absentDate;
        this.absentState = absentState;
        this.UserID = UserID;
    }

    public int getAbsentID() {
        return absentID;
    }

    public void setAbsentID(int absentID) {
        this.absentID = absentID;
    }

    public int getRegisterID() {
        return RegisterID;
    }

    public void setRegisterID(int RegisterID) {
        this.RegisterID = RegisterID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getAbsentDate() {
        return absentDate;
    }

    public void setAbsentDate(Date absentDate) {
        this.absentDate = absentDate;
    }

    public int getAbsentState() {
        return absentState;
    }

    public void setAbsentState(int absentState) {
        this.absentState = absentState;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    @Override
    public String toString() {
        return "AbsentModel{" + "absentID=" + absentID + ", RegisterID=" + RegisterID + ", studentID=" + studentID + ", absentDate=" + absentDate + ", absentState=" + absentState + ", UserID=" + UserID + '}';
    }

}
