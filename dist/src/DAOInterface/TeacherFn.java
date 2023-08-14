package DAOInterface;

import Model.TeacherModel;
import java.util.List;

public interface TeacherFn {

    public int CreateTeacher(TeacherModel teacherModel);

    public int UpdateTeacher(TeacherModel teacherModel);

    public int DeleteTeacher(TeacherModel teacherModel);

    public TeacherModel getTeacherById(int teacherID);

    public List<TeacherModel> getAllTeacher();

    public int getLastTeacherID();

    public int getGenderCount();
    
    public int getTeacherCount();
}
