package DAOInterface;

import Model.TeacherHistoryModel;
import java.util.List;

public interface TeacherHistoryFn {

    public int CreaterTeacherHistory(TeacherHistoryModel model);

    public int UpdateTeacherHistory(TeacherHistoryModel model);

    public int DeleteTeacherHistory(TeacherHistoryModel model);

    public List<TeacherHistoryModel> getAllTeacherHistory();

    public TeacherHistoryModel getTeacherHistoryById(int TeacherHistoryID);
    
    public TeacherHistoryModel getTeacherHistoryByTeacherId(int TeacherID);
}
