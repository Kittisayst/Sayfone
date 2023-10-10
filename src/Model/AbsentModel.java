package Model;

import java.sql.Date;

public class AbsentModel {

    private int absentID;
    private int RegisterID;
    private Date absentDate;
    private String absentData;
    private int UserID;
    private String Comment;

    public AbsentModel() {
    }

    public AbsentModel(int absentID, int RegisterID, Date absentDate, String absentData, int UserID, String Comment) {
        this.absentID = absentID;
        this.RegisterID = RegisterID;
        this.absentDate = absentDate;
        this.absentData = absentData;
        this.UserID = UserID;
        this.Comment = Comment;
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

    public Date getAbsentDate() {
        return absentDate;
    }

    public void setAbsentDate(Date absentDate) {
        this.absentDate = absentDate;
    }

    public void setAbsentData(String absentData) {
        this.absentData = absentData;
    }

    public String getAbsentData() {
        return absentData;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    @Override
    public String toString() {
        return "AbsentModel{" + "absentID=" + absentID + ", RegisterID=" + RegisterID + ", absentDate=" + absentDate + ", absentData=" + absentData + ", UserID=" + UserID + ", Comment=" + Comment + '}';
    }
    
    

   

}
