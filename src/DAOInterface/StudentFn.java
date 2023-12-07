package DAOInterface;

import Model.StudentModel;
import java.util.List;

public interface StudentFn {

    public int CreaterStudent(StudentModel model);

    public int UpdateStudent(StudentModel model);

    public int DeleteStudent(StudentModel model);

    public List<StudentModel> getAllStudent();

    public List<StudentModel> getAllStudent(int max);

    public StudentModel getStudentById(int StudentID);

    public int getSudentLastID();

    public int getStudentCount();

    public int getCountClass(int ClassID);

    public List<StudentModel> getNewStudent();

    public List<StudentModel> getSutdentNotRegister(int YearID, int page, int rowsPerPage);

    public String getAutoStudentID();

    public boolean getChekStudentNo(String studentNo);

    public List<StudentModel> getStudentBrotherSister(int StudentID);

    public List<StudentModel> getStudentPagination(int page, int rowsPerPage);

    public List<StudentModel> getSearchStudent(String search);

    public List<StudentModel> getSearchSutdentNotRegister(int YearID, String search);

    public List<StudentModel> getStudentByState(int State);

}
