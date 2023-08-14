package Model;

public class TeacherHistoryModel extends HistoryModel {

    private int TeacherHostoryID;
    private int TeacherID;
    private String FamilyID;
    private String PeopleID;
    private String PassportID;
    private String SpouseName;
    private int SpouseAge;
    private String SpouseJob;
    private String SpousePlace;
    private String SpouseTel;
    private int Higth;
    private int Weight;

    public int getTeacherHostoryID() {
        return TeacherHostoryID;
    }

    public void setTeacherHostoryID(int TeacherHostoryID) {
        this.TeacherHostoryID = TeacherHostoryID;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
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

    public String getSpouseName() {
        return SpouseName;
    }

    public void setSpouseName(String SpouseName) {
        this.SpouseName = SpouseName;
    }

    public int getSpouseAge() {
        return SpouseAge;
    }

    public void setSpouseAge(int SpouseAge) {
        this.SpouseAge = SpouseAge;
    }

    public String getSpouseJob() {
        return SpouseJob;
    }

    public void setSpouseJob(String SpouseJob) {
        this.SpouseJob = SpouseJob;
    }

    public String getSpousePlace() {
        return SpousePlace;
    }

    public void setSpousePlace(String SpousePlace) {
        this.SpousePlace = SpousePlace;
    }

    public String getSpouseTel() {
        return SpouseTel;
    }

    public void setSpouseTel(String SpouseTel) {
        this.SpouseTel = SpouseTel;
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

    @Override
    public String toString() {
        return "TeacherHistoryModel{" + "TeacherHostoryID=" + TeacherHostoryID + ", TeacherID=" + TeacherID + ", FamilyID=" + FamilyID + ", PeopleID=" + PeopleID + ", PassportID=" + PassportID + ", SpouseName=" + SpouseName + ", SpouseAge=" + SpouseAge + ", SpouseJob=" + SpouseJob + ", SpousePlace=" + SpousePlace + ", SpouseTel=" + SpouseTel + ", Higth=" + Higth + ", Weight=" + Weight + '}';
    }

}
