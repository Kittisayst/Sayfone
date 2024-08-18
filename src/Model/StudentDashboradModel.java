package Model;

import DAOSevervice.FinancialService;

public class StudentDashboradModel {

    private int studentID;
    private String studentName;
    private String studentNo;
    private int gender;
    private int FinancialID;
    private int studentState;

    public StudentDashboradModel(int studentID, String studentNo, String studentName, int gender, int FinancialID, int studentState) {
        this.studentID = studentID;
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.gender = gender;
        this.FinancialID = FinancialID;
        this.studentState = studentState;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getFinancialID() {
        return FinancialID;
    }

    public void setFinancialID(int FinancialID) {
        this.FinancialID = FinancialID;
    }

    public int getStudentState() {
        return studentState;
    }

    public void setStudentState(int studentState) {
        this.studentState = studentState;
    }

    public String getFullName() {
        return this.gender == 0 ? "ນາງ " + this.studentName : "ທ້າວ " + this.studentName;
    }

    public String getClassName() {
        FinancialService financialService = new FinancialService();
        String lastClass = financialService.getLastClass(this.studentID);
        return lastClass;
    }

    public String getStatusName() {
        switch (this.studentState) {
            case 0:
                return "ຮຽນຢູ່";
            case 1:
                return "ພັກຮຽນ";
            case 2:
                return "ປະລະການຮຽນ";
            default:
                return "ບໍ່ພົບຂໍ້ມູນ";
        }
    }

    @Override
    public String toString() {
        return "StudentDashboradModel{" + "studentID=" + studentID + ", studentName=" + studentName + ", studentNo=" + studentNo + ", gender=" + gender + ", FinancialID=" + FinancialID + ", studentState=" + studentState + '}';
    }

}
