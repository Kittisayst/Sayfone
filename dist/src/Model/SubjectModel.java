package Model;

public class SubjectModel {

    private int SubjectID;
    private String SubjectName;

    public SubjectModel() {
    }

    public SubjectModel(int SubjectID, String SubjectName) {
        this.SubjectID = SubjectID;
        this.SubjectName = SubjectName;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    @Override
    public String toString() {
        return "SubjectModel{" + "SubjectID=" + SubjectID + ", SubjectName=" + SubjectName + '}';
    }

}
