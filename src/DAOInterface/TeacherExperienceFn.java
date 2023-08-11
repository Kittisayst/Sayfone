package DAOInterface;

import Model.TeacherExperienceModel;
import java.util.List;

public interface TeacherExperienceFn {

    public int CreaterExperience(TeacherExperienceModel model);

    public int UpdateExperience(TeacherExperienceModel model);

    public int DeleteExperience(TeacherExperienceModel model);

    public List<TeacherExperienceModel> getAllExperienceByTeacherID(int TeacherID);

    public TeacherExperienceModel getExperienceById(int ExperienceID);

    public List<TeacherExperienceModel> getExperienceBetweenYear(int TeacherID, String YearName);
}
