package Model;

public class StudentCountModel {

    private String ClassRoom;
    private String Year;
    private int Count;
    private int classID;

    public StudentCountModel(String ClassRoom, String Year, int Count, int classID) {
        this.ClassRoom = ClassRoom;
        this.Year = Year;
        this.Count = Count;
        this.classID = classID;
    }

    public String getClassRoom() {
        return ClassRoom;
    }

    public void setClassRoom(String ClassRoom) {
        this.ClassRoom = ClassRoom;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "StudentCountModel{" + "ClassRoom=" + ClassRoom + ", Year=" + Year + ", Count=" + Count + ", classID=" + classID + '}';
    }

}
