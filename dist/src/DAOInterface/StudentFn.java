package DAOInterface;

import Model.StudentModel;
import java.util.List;

public interface StudentFn {

    public int CreaterStudent(StudentModel model);

    public int UpdateStudent(StudentModel model);

    public int DeleteStudent(StudentModel model);

    public List<StudentModel> getAllStudent();

    public StudentModel getStudentById(int StudentID);

    public int getSudentLastID();

    public int getStudentCount();

    public int getCountClass(int ClassID);

    public List<StudentModel> getNewStudent();

    public List<StudentModel> getSutdentNotRegister();

    public String getAutoStudentID();

    public boolean getChekStudentNo(String studentNo);
    
    public List<StudentModel> getStudentBrotherSister(int StudentID);

}
