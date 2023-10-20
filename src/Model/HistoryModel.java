package Model;

public class HistoryModel {

    private String FatherName;
    private int FatherAge;
    private String FatherJob;
    private String FatherPlace;
    private String FatherTel;
    private String MotherName;
    private int MotherAge;
    private String MotherJob;
    private String MotherPlace;
    private String MotherTel;
    private int BloodGroup;
    private int DiverCategory;
    private String DiverID;
    private String Parent1;
    private String Parent2;

    public HistoryModel() {

    }

    public HistoryModel(String FatherName, int FatherAge, String FatherJob, String FatherPlace, String FatherTel, String MotherName, int MotherAge, String MotherJob, String MotherPlace, String MotherTel, int BloodGroup, int DiverCategory, String DiverID, String Parent1, String Parent2) {
        this.FatherName = FatherName;
        this.FatherAge = FatherAge;
        this.FatherJob = FatherJob;
        this.FatherPlace = FatherPlace;
        this.FatherTel = FatherTel;
        this.MotherName = MotherName;
        this.MotherAge = MotherAge;
        this.MotherJob = MotherJob;
        this.MotherPlace = MotherPlace;
        this.MotherTel = MotherTel;
        this.BloodGroup = BloodGroup;
        this.DiverCategory = DiverCategory;
        this.DiverID = DiverID;
        this.Parent1 = Parent1;
        this.Parent2 = Parent2;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String FatherName) {
        this.FatherName = FatherName;
    }

    public int getFatherAge() {
        return FatherAge;
    }

    public void setFatherAge(int FatherAge) {
        this.FatherAge = FatherAge;
    }

    public int getMotherAge() {
        return MotherAge;
    }

    public void setMotherAge(int MotherAge) {
        this.MotherAge = MotherAge;
    }

    public String getFatherJob() {
        return FatherJob;
    }

    public void setFatherJob(String FatherJob) {
        this.FatherJob = FatherJob;
    }

    public String getFatherPlace() {
        return FatherPlace;
    }

    public void setFatherPlace(String FatherPlace) {
        this.FatherPlace = FatherPlace;
    }

    public String getFatherTel() {
        return FatherTel;
    }

    public void setFatherTel(String FatherTel) {
        this.FatherTel = FatherTel;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String MotherName) {
        this.MotherName = MotherName;
    }

    public String getMotherJob() {
        return MotherJob;
    }

    public void setMotherJob(String MotherJob) {
        this.MotherJob = MotherJob;
    }

    public String getMotherPlace() {
        return MotherPlace;
    }

    public void setMotherPlace(String MotherPlace) {
        this.MotherPlace = MotherPlace;
    }

    public String getMotherTel() {
        return MotherTel;
    }

    public void setMotherTel(String MotherTel) {
        this.MotherTel = MotherTel;
    }

    public int getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(int BloodGroup) {
        this.BloodGroup = BloodGroup;
    }

    public int getDiverCategory() {
        return DiverCategory;
    }

    public void setDiverCategory(int DiverCategory) {
        this.DiverCategory = DiverCategory;
    }

    public String getDiverID() {
        return DiverID;
    }

    public void setDiverID(String DiverID) {
        this.DiverID = DiverID;
    }

    public String getParent1() {
        return Parent1;
    }

    public void setParent1(String Parent1) {
        this.Parent1 = Parent1;
    }

    public String getParent2() {
        return Parent2;
    }

    public void setParent2(String Parent2) {
        this.Parent2 = Parent2;
    }

    @Override
    public String toString() {
        return "HistoryModel{" + "FatherName=" + FatherName + ", FatherAge=" + FatherAge + ", FatherJob=" + FatherJob + ", FatherPlace=" + FatherPlace + ", FatherTel=" + FatherTel + ", MotherName=" + MotherName + ", MotherAge=" + MotherAge + ", MotherJob=" + MotherJob + ", MotherPlace=" + MotherPlace + ", MotherTel=" + MotherTel + ", BloodGroup=" + BloodGroup + ", DiverCategory=" + DiverCategory + ", Parent1=" + Parent1 + ", Parent2=" + Parent2 + ", DiverID=" + DiverID + '}';
    }

}
