package DAOInterface;

import Model.TeacherOutstandingModel;
import java.util.List;

public interface TeacherOutStandingFn {

    public int CreaterTeacherOutstanding(TeacherOutstandingModel model);

    public int UpdateTeacherOutstanding(TeacherOutstandingModel model);

    public int DeleteTeacherOutstanding(TeacherOutstandingModel model);

    public List<TeacherOutstandingModel> getAllByTeacherID(int TeacherID);

    public TeacherOutstandingModel getByTeacherOutstandingID(int TeacherOutstandingID);
}
