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

    public List<StudentModel> getAllStudent(int max) {
        return aO.getAllStudent(max);
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

    public List<StudentModel> getSutdentNotRegister(int YearID, int page, int rowsPerPage) {
        return aO.getSutdentNotRegister(YearID, page, rowsPerPage);
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

    public List<StudentModel> getStudentPagination(int page, int rowsPerPage) {
        return aO.getStudentPagination(page, rowsPerPage);
    }

    public int getTotalPages() {
        return aO.getTotalPages();
    }

    public List<StudentModel> getSearchStudent(String search) {
        return aO.getSearchStudent(search);
    }

    public List<StudentModel> getSearchSutdentNotRegister(int YearID, String search) {
        return aO.getSearchSutdentNotRegister(YearID, search);
    }

    public List<StudentModel> getStudentByState(int State) {
        return aO.getStudentByState(State);
    }

}
