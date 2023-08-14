package Model;

import Tools.JoCreateImage;
import java.io.File;
import java.sql.Date;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

public class StudentModel {

    private int StudentID;
    private int nationalityID;
    private int ethnicID;
    private int religionID;
    private String StudentNo;
    private int Gender;
    private String StudentName;
    private String StudentENG;
    private String NickName;
    private Date DateofBirth;
    private Date DateStart;
    private Date DateStop;
    private String Preschool;
    private int Health;
    private String Talent;
    private int VaccinState;
    private String Disabled;
    private int Sibling;
    private Blob Image;
    private File LocationFile;
    private int GoHome;
    private int Status;
    private int UserCreate;

    public int getStudentID() {
        return StudentID;
    }

    public StudentModel() {
    }

    public StudentModel(int StudentID, int nationalityID, int ethnicID, int religionID, String StudentNo, int Gender, String StudentName, String StudentENG, String NickName, Date DateofBirth, Date DateStart, Date DateStop, String Preschool, int Health, String Talent, int VaccinState, String Disabled, int Sibling, Blob Image, File LocationFile, int GoHome, int Status, int UserCreate) {
        this.StudentID = StudentID;
        this.nationalityID = nationalityID;
        this.ethnicID = ethnicID;
        this.religionID = religionID;
        this.StudentNo = StudentNo;
        this.Gender = Gender;
        this.StudentName = StudentName;
        this.StudentENG = StudentENG;
        this.NickName = NickName;
        this.DateofBirth = DateofBirth;
        this.DateStart = DateStart;
        this.DateStop = DateStop;
        this.Preschool = Preschool;
        this.Health = Health;
        this.Talent = Talent;
        this.VaccinState = VaccinState;
        this.Disabled = Disabled;
        this.Sibling = Sibling;
        this.Image = Image;
        this.LocationFile = LocationFile;
        this.GoHome = GoHome;
        this.Status = Status;
        this.UserCreate = UserCreate;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getNationalityID() {
        return nationalityID;
    }

    public void setNationalityID(int nationalityID) {
        this.nationalityID = nationalityID;
    }

    public int getEthnicID() {
        return ethnicID;
    }

    public void setEthnicID(int ethnicID) {
        this.ethnicID = ethnicID;
    }

    public int getReligionID() {
        return religionID;
    }

    public void setReligionID(int religionID) {
        this.religionID = religionID;
    }

    public String getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(String StudentNo) {
        this.StudentNo = StudentNo;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getStudentENG() {
        return StudentENG;
    }

    public void setStudentENG(String StudentENG) {
        this.StudentENG = StudentENG;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public Date getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(Date DateofBirth) {
        this.DateofBirth = DateofBirth;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date DateStart) {
        this.DateStart = DateStart;
    }

    public Date getDateStop() {
        return DateStop;
    }

    public void setDateStop(Date DateStop) {
        this.DateStop = DateStop;
    }

    public String getPreschool() {
        return Preschool;
    }

    public void setPreschool(String Preschool) {
        this.Preschool = Preschool;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int Health) {
        this.Health = Health;
    }

    public String getTalent() {
        return Talent;
    }

    public void setTalent(String Talent) {
        this.Talent = Talent;
    }

    public int getVaccinState() {
        return VaccinState;
    }

    public void setVaccinState(int VaccinState) {
        this.VaccinState = VaccinState;
    }

    public String getDisabled() {
        return Disabled;
    }

    public void setDisabled(String Disabled) {
        this.Disabled = Disabled;
    }

    public int getSibling() {
        return Sibling;
    }

    public void setSibling(int Sibling) {
        this.Sibling = Sibling;
    }

    public Blob getImage() {
        return Image;
    }

    public void setImage(Blob Image) {
        this.Image = Image;
    }

    public File getLocationFile() {
        return LocationFile;
    }

    public void setLocationFile(File LocationFile) {
        this.LocationFile = LocationFile;
    }

    public int getGoHome() {
        return GoHome;
    }

    public void setGoHome(int GoHome) {
        this.GoHome = GoHome;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getUserCreate() {
        return UserCreate;
    }

    public void setUserCreate(int UserCreate) {
        this.UserCreate = UserCreate;
    }

    public Object getFullName() {
        return Gender == 1 ? "ທ້າວ " + StudentName : "ນາງ " + StudentName;
    }

    public String getStatusName() {
        switch (Status) {
            case 0:
                return "ຮຽນຢູ່";
            case 1:
                return "ພັກຮຽນ";
            case 2:
                return "ປະລະການຮຽນ";
            default:
                return "ບໍ່ພົບຂໍ້ມູນ";
        }
    }

    public String getHealthName() {
        return Health != 0 ? "ແຂງແຮງ" : "ອ່ອນເພຍ";
    }

    public String getVucinStateName() {
        return VaccinState != 0 ? "ຄົບຖ້ວນ" : "ບໍ່ຄົບ";
    }

    public String getGohomeName() {
        return GoHome != 0 ? "ໄດ້ຮັບອານຸຍາດ" : "ບໍ່ໄດ້ຮັບອານຸຍາດ";
    }

    public Icon getAvatar() {
        try {
            return new JoCreateImage().JoCreateImage(Image);
        } catch (Exception ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String toString() {
        return "StudentModel{" + "StudentID=" + StudentID + ", nationalityID=" + nationalityID + ", ethnicID=" + ethnicID + ", religionID=" + religionID + ", StudentNo=" + StudentNo + ", Gender=" + Gender + ", StudentName=" + StudentName + ", StudentENG=" + StudentENG + ", NickName=" + NickName + ", DateofBirth=" + DateofBirth + ", DateStart=" + DateStart + ", DateStop=" + DateStop + ", Preschool=" + Preschool + ", Health=" + Health + ", Talent=" + Talent + ", VaccinState=" + VaccinState + ", Disabled=" + Disabled + ", Sibling=" + Sibling + ", Image=" + Image + ", LocationFile=" + LocationFile + ", GoHome=" + GoHome + ", Status=" + Status + '}';
    }

}
