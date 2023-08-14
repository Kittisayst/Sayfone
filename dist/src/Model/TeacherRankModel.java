package Model;

public class TeacherRankModel {

    private int TeacherRankID;
    private int YearID;
    private int TeacherID;
    private int Rank;

    public TeacherRankModel() {
    }

    public TeacherRankModel(int TeacherRankID, int YearID, int TeacherID, int Rank) {
        this.TeacherRankID = TeacherRankID;
        this.YearID = YearID;
        this.TeacherID = TeacherID;
        this.Rank = Rank;
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

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
