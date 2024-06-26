package Model;

public class StudentKnowModel {

    private int KnowID;
    private int StudentID;
    private int KnowIndex;

    public StudentKnowModel() {
    }

    public StudentKnowModel(int KnowID, int StudentID, int KnowIndex) {
        this.KnowID = KnowID;
        this.StudentID = StudentID;
        this.KnowIndex = KnowIndex;
    }

    public int getKnowID() {
        return KnowID;
    }

    public void setKnowID(int KnowID) {
        this.KnowID = KnowID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getKnowIndex() {
        return KnowIndex;
    }

    public void setKnowIndex(int KnowIndex) {
        this.KnowIndex = KnowIndex;
    }

    @Override
    public String toString() {
        return "StudentKnowModel{" + "KnowID=" + KnowID + ", StudentID=" + StudentID + ", KnowIndex=" + KnowIndex + '}';
    }

}
