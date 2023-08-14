package DAOInterface;

import Model.StudentHistoryModel;
import java.util.List;

public interface StudentHistoryFn {

    public int CreaterStudentHistory(StudentHistoryModel model);

    public int UpdateStudentHistory(StudentHistoryModel model);

    public int DeleteStudentHistory(StudentHistoryModel model);

    public List<StudentHistoryModel> getAllStudentHistory();

    public StudentHistoryModel getStudentHistoryByStudentID(int StudentHistoryID);
}
