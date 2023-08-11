package Model;

public class ClassModel {

    private int ClassID;
    private String ClassName;

    public ClassModel() {
    }

    public ClassModel(int ClassID, String ClassName) {
        this.ClassID = ClassID;
        this.ClassName = ClassName;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

}
