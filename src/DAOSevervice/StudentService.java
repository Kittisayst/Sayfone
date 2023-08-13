package DAOSevervice;

import DAO.StudentDAO;
import Model.StudentModel;
import java.util.List;

public class StudentService {

    StudentDAO aO = new StudentDAO();

    public int CreaterStudent(StudentModel model) {
        return aO.CreaterStudent(model);
    }

    public int UpdateStudent(StudentModel model) {
        return aO.UpdateStudent(model);
    }

    public int DeleteStudent(StudentModel model) {
        return aO.DeleteStudent(model);
    }

    public List<StudentModel> getAllStudent() {
        return aO.getAllStudent();
    }

    public StudentModel getStudentById(int StudentID) {
        return aO.getStudentById(StudentID);
    }

    public int getSudentLastID() {
        return aO.getSudentLastID();
    }

    public int getStudentCount() {
        return aO.getStudentCount();
    }

    public List<StudentModel> getSutdentNotRegister() {
        return aO.getSutdentNotRegister();
    }

    public String getAutoStudentID() {
        return aO.getAutoStudentID();
    }

    public boolean getChekStudentNo(String studentNo) {
        return aO.getChekStudentNo(studentNo);
    }

    public List<StudentModel> getStudentBrotherSister(int StudentID) {
        return aO.getStudentBrotherSister(StudentID);
    }

}
