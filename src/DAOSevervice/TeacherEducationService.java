package DAOSevervice;

import DAO.TeacherEducationDAO;
import Model.TeacherEducationModel;
import java.util.List;

public class TeacherEducationService {

    TeacherEducationDAO aO = new TeacherEducationDAO();

    public int CreaterTeacherEducation(TeacherEducationModel model) {
        return aO.CreaterTeacherEducation(model);
    }

    public int UpdateTeacherEducation(TeacherEducationModel model) {
        return aO.UpdateTeacherEducation(model);
    }

    public int DeleteTeacherEducation(TeacherEducationModel model) {
        return aO.DeleteTeacherEducation(model);
    }

    public List<TeacherEducationModel> getALLByTeacherID(int TeacherID) {
        return aO.getALLByTeacherID(TeacherID);
    }

    public TeacherEducationModel getTeacherEducationById(int TeacherEducationID) {
        return aO.getTeacherEducationById(TeacherEducationID);
    }

}
