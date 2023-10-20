package Model;

public class StudentHistoryModel extends HistoryModel {

    private int HistroyID;
    private int studentID;
    private String FamilyID;
    private String PeopleID;
    private String PassportID;
    private String SiblingName;
    private int SiblingAge;
    private String SiblingJob;
    private String SiblingPlace;
    private String SiblingTel;
    private int Higth;
    private int Weight;

    public StudentHistoryModel() {
    }

    public StudentHistoryModel(int HistroyID, int studentID, String FamilyID, String PeopleID, String PassportID, String SiblingName, int SiblingAge, String SiblingJob, String SiblingPlace, String SiblingTel, int Higth, int Weight, String FatherName, int FatherAge, String FatherJob, String FatherPlace, String FatherTel, String MotherName, int MotherAge, String MotherJob, String MotherPlace, String MotherTel, int BloodGroup, int DiverCategory, String DiverID, String Parent1, String Parent2) {
        super(FatherName, FatherAge, FatherJob, FatherPlace, FatherTel, MotherName, MotherAge, MotherJob, MotherPlace, MotherTel, BloodGroup, DiverCategory, DiverID, Parent1, Parent2);
        this.HistroyID = HistroyID;
        this.studentID = studentID;
        this.FamilyID = FamilyID;
        this.PeopleID = PeopleID;
        this.PassportID = PassportID;
        this.SiblingName = SiblingName;
        this.SiblingAge = SiblingAge;
        this.SiblingJob = SiblingJob;
        this.SiblingPlace = SiblingPlace;
        this.SiblingTel = SiblingTel;
        this.Higth = Higth;
        this.Weight = Weight;
    }

   

    
    
    

    public int getHistroyID() {
        return HistroyID;
    }

    public void setHistroyID(int HistroyID) {
        this.HistroyID = HistroyID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFamilyID() {
        return FamilyID;
    }

    public void setFamilyID(String FamilyID) {
        this.FamilyID = FamilyID;
    }

    public String getPeopleID() {
        return PeopleID;
    }

    public void setPeopleID(String PeopleID) {
        this.PeopleID = PeopleID;
    }

    public String getPassportID() {
        return PassportID;
    }

    public void setPassportID(String PassportID) {
        this.PassportID = PassportID;
    }

    public String getSiblingName() {
        return SiblingName;
    }

    public void setSiblingName(String SiblingName) {
        this.SiblingName = SiblingName;
    }

    public int getSiblingAge() {
        return SiblingAge;
    }

    public void setSiblingAge(int SiblingAge) {
        this.SiblingAge = SiblingAge;
    }

    public String getSiblingJob() {
        return SiblingJob;
    }

    public void setSiblingJob(String SiblingJob) {
        this.SiblingJob = SiblingJob;
    }

    public String getSiblingPlace() {
        return SiblingPlace;
    }

    public void setSiblingPlace(String SiblingPlace) {
        this.SiblingPlace = SiblingPlace;
    }

    public String getSiblingTel() {
        return SiblingTel;
    }

    public void setSiblingTel(String SiblingTel) {
        this.SiblingTel = SiblingTel;
    }

    public int getHigth() {
        return Higth;
    }

    public void setHigth(int Higth) {
        this.Higth = Higth;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

}
