package DAOSevervice;

import DAO.TeacherExperienceDAO;
import Model.TeacherExperienceModel;
import java.util.List;

public class TeacherExperienceService {

    TeacherExperienceDAO aO = new TeacherExperienceDAO();

    public int CreaterExperience(TeacherExperienceModel model) {
        return aO.CreaterExperience(model);
    }

    public int UpdateExperience(TeacherExperienceModel model) {
        return aO.UpdateExperience(model);
    }

    public int DeleteExperience(TeacherExperienceModel model) {
        return aO.DeleteExperience(model);
    }

    public List<TeacherExperienceModel> getAllExperienceByTeacherID(int TeacherID) {
        return aO.getAllExperienceByTeacherID(TeacherID);
    }

    public TeacherExperienceModel getExperienceById(int ExperienceID) {
        return aO.getExperienceById(ExperienceID);
    }

    public List<TeacherExperienceModel> getExperienceBetweenYear(int TeacherID, String YearName) {
        return aO.getExperienceBetweenYear(TeacherID, YearName);
    }
    
    

}
