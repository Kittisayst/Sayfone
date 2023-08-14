package Model;

import DAOSevervice.ClassService;
import DAOSevervice.YearService;
import java.sql.Date;
import java.text.DecimalFormat;

public class CreateRegisterModel {

    private int registerID;
    private String ClassRoomName;
    private int YearID;
    private int ClassID;
    private Date registerDate;

    public CreateRegisterModel() {
    }

    public CreateRegisterModel(int registerID, String ClassRoomName, int YearID, int ClassID, Date registerDate) {
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
        return new ClassService().getClassById(ClassID);
    }

    public YearModel getYearModel() {
        return new YearService().getYearById(YearID);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
