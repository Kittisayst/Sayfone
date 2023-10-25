package Model;

import java.sql.Date;

public class RegisterModel {

    private int registerID;
    private String ClassRoomName;
    private int YearID;
    private int ClassID;
    private Date registerDate;

    public RegisterModel() {
    }

    public RegisterModel(int registerID, String ClassRoomName, int YearID, int ClassID, Date registerDate) {
        this.registerID = registerID;
        this.ClassRoomName = ClassRoomName;
        this.YearID = YearID;
        this.ClassID = ClassID;
        this.registerDate = registerDate;
    }

    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public String getClassRoomName() {
        return ClassRoomName;
    }

    public void setClassRoomName(String ClassRoomName) {
        this.ClassRoomName = ClassRoomName;
    }

    public int getYearID() {
        return YearID;
    }

    public void setYearID(int YearID) {
        this.YearID = YearID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public ClassModel getClassModel() {
        ClassModel cm = new ClassModel();
        for (ClassModel data : GlobalDataModel.classModels) {
            if (data.getClassID() == ClassID) {
                cm = data;
                break;
            }
        }
        return cm;
    }

    public YearModel getYearModel() {
        YearModel ym = new YearModel();
        for (YearModel data : GlobalDataModel.yearModels) {
            if (data.getYearID() == YearID) {
                ym = data;
                break;
            }
        }
        return ym;
    }

    @Override
    public String toString() {
        return "RegisterModel{" + "registerID=" + registerID + ", ClassRoomName=" + ClassRoomName + ", YearID=" + YearID + ", ClassID=" + ClassID + ", registerDate=" + registerDate + '}';
    }



}
