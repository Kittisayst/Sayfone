package DAOInterface;

import Model.TeacherVaccinModel;
import java.util.List;

public interface TeacherVacinFn {

    public int CreaterTeacherVaccin(TeacherVaccinModel model);

    public int UpdateTeacherVaccin(TeacherVaccinModel model);

    public int DeleteTeacherVaccin(TeacherVaccinModel model);

    public List<TeacherVaccinModel> getTeacherVaccinAllByTeacherID(int TeacherID);

    public TeacherVaccinModel getTeacherVaccinById(int TeacherVaccinID);
}
