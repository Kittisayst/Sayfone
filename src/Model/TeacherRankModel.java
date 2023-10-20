package Model;

public class TeacherRankModel {

    private int TeacherRankID;
    private int YearID;
    private int TeacherID;
    private int Rank;
    private int Month;

    public TeacherRankModel() {
    }

    public TeacherRankModel(int TeacherRankID, int YearID, int TeacherID, int Rank, int Month) {
        this.TeacherRankID = TeacherRankID;
        this.YearID = YearID;
        this.TeacherID = TeacherID;
        this.Rank = Rank;
        this.Month = Month;
    }

    public int getTeacherRankID() {
        return TeacherRankID;
    }

    public void setTeacherRankID(int TeacherRankID) {
        this.TeacherRankID = TeacherRankID;
    }

    public int getYearID() {
        return YearID;
    }

    public void setYearID(int YearID) {
        this.YearID = YearID;
    }

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int Rank) {
        this.Rank = Rank;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int Month) {
        this.Month = Month;
    }

    @Override
    public String toString() {
        return "TeacherRankModel{" + "TeacherRankID=" + TeacherRankID + ", YearID=" + YearID + ", TeacherID=" + TeacherID + ", Rank=" + Rank + ", Month=" + Month + '}';
    }

}
