package Model;

import java.sql.Date;

public class TeacherOutstandingModel extends OutstandingCatModel {

    private int TeacherOutstandingID;
    private int teacherID;
    private Date OutstandingDate;
    private String OutstandingDetail;

    public int getTeacherOutstandingID() {
        return TeacherOutstandingID;
    }

    public void setTeacherOutstandingID(int TeacherOutstandingID) {
        this.TeacherOutstandingID = TeacherOutstandingID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public Date getOutstandingDate() {
        return OutstandingDate;
    }

    public void setOutstandingDate(Date OutstandingDate) {
        this.OutstandingDate = OutstandingDate;
    }

    public String getOutstandingDetail() {
        return OutstandingDetail;
    }

    public void setOutstandingDetail(String OutstandingDetail) {
        this.OutstandingDetail = OutstandingDetail;
    }

    @Override
    public String toString() {
        return "TeacherOutstandingModel{" + "TeacherOutstandingID=" + TeacherOutstandingID + ", teacherID=" + teacherID + ", OutstandingDate=" + OutstandingDate + ", OutstandingDetail=" + OutstandingDetail + '}';
    }

    
}
