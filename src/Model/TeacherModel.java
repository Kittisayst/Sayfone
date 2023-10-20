package Model;

import Tools.JoCreateImage;
import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

public class TeacherModel {

    private int TeacherID;
    private int NationalityID;
    private int EthnicID;
    private int ReligionID;
    private int ClassID;
    private String TeacherNo;
    private String Name;
    private String NameENG;
    private String NickName;
    private int Gender;
    private Date DateOfBirth;
    private String Tel;
    private String Email;
    private String Facebook;
    private Date DateStart;
    private Date DateStop;
    private String Talent;
    private Blob Image;
    private File ImageFile;
    private int Health;
    private int Status;

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public int getNationalityID() {
        return NationalityID;
    }

    public void setNationalityID(int NationalityID) {
        this.NationalityID = NationalityID;
    }

    public int getEthnicID() {
        return EthnicID;
    }

    public void setEthnicID(int EthnicID) {
        this.EthnicID = EthnicID;
    }

    public int getReligionID() {
        return ReligionID;
    }

    public void setReligionID(int ReligionID) {
        this.ReligionID = ReligionID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public String getTeacherNo() {
        return TeacherNo;
    }

    public void setTeacherNo(String TeacherNo) {
        this.TeacherNo = TeacherNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNameENG() {
        return NameENG;
    }

    public void setNameENG(String NameENG) {
        this.NameENG = NameENG;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String Facebook) {
        this.Facebook = Facebook;
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

    public String getTalent() {
        return Talent;
    }

    public void setTalent(String Talent) {
        this.Talent = Talent;
    }

    public Blob getImage() {
        return Image;
    }

    public void setImage(Blob Image) {
        this.Image = Image;
    }

    public File getImageFile() {
        return ImageFile;
    }

    public void setImageFile(File ImageFile) {
        this.ImageFile = ImageFile;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int Health) {
        this.Health = Health;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Object getFullName() {
        return Gender == 1 ? "ທ້າວ " + Name : "ນາງ " + Name;
    }

    public String getStatusName() {
        switch (Status) {
            case 0:
                return "ສົມບູນ";
            case 1:
                return "ທົດລອງວຽກ";
            case 2:
                return "ອອກວຽກ";
            default:
                return "Null";
        }
    }

    public String getHealthName() {
        return Health == 1 ? "ແຂງແຮງ" : "ອ່ອນເພຍ";
    }

    public Icon getImageIcon() {
        try {
            return new JoCreateImage().JoCreateImage(Image);
        } catch (Exception ex) {
            Logger.getLogger(TeacherModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String toString() {
        return "TeacherModel{" + "TeacherID=" + TeacherID + ", NationalityID=" + NationalityID + ", EthnicID=" + EthnicID + ", ReligionID=" + ReligionID + ", ClassID=" + ClassID + ", TeacherNo=" + TeacherNo + ", Name=" + Name + ", NameENG=" + NameENG + ", NickName=" + NickName + ", Gender=" + Gender + ", DateOfBirth=" + DateOfBirth + ", Tel=" + Tel + ", Email=" + Email + ", Facebook=" + Facebook + ", DateStart=" + DateStart + ", DateStop=" + DateStop + ", Talent=" + Talent + ", Image=" + Image + ", ImageFile=" + ImageFile + ", Health=" + Health + ", Status=" + Status + '}';
    }
    
    

}
