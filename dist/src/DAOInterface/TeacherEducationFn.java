package DAOInterface;

import Model.TeacherEducationModel;
import java.util.List;

public interface TeacherEducationFn {
//

    public int CreaterTeacherEducation(TeacherEducationModel model);

    public int UpdateTeacherEducation(TeacherEducationModel model);

    public int DeleteTeacherEducation(TeacherEducationModel model);

    public List<TeacherEducationModel> getALLByTeacherID(int TeacherID);

    public TeacherEducationModel getTeacherEducationById(int TeacherEducationID);

}
