package Model;

public class BrotherAndSisterModel extends StudentModel {

    private int bsID;
    private int StudentID;
    private int StudentBSID;

    public BrotherAndSisterModel() {
    }

    public BrotherAndSisterModel(int bsID, int StudentID, int StudentBSID) {
        this.bsID = bsID;
        this.StudentID = StudentID;
        this.StudentBSID = StudentBSID;
    }

    public int getBsID() {
        return bsID;
    }

    public void setBsID(int bsID) {
        this.bsID = bsID;
    }

    @Override
    public int getStudentID() {
        return StudentID;
    }

    @Override
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getStudentBSID() {
        return StudentBSID;
    }

    public void setStudentBSID(int StudentBSID) {
        this.StudentBSID = StudentBSID;
    }

    @Override
    public Object getFullName() {
        return super.getFullName(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setStudentName(String StudentName) {
        super.setStudentName(StudentName); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getStudentName() {
        return super.getStudentName(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setGender(int Gender) {
        super.setGender(Gender); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getGender() {
        return super.getGender(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String toString() {
        return "BrotherAndSisterModel{" + "bsID=" + bsID + ", StudentID=" + StudentID + ", StudentBSID=" + StudentBSID + '}';
    }

}
