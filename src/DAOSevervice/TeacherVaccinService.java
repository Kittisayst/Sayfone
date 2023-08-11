
package DAOSevervice;

import DAO.TeacherVaccinDAO;
import Model.TeacherVaccinModel;
import java.util.List;


public class TeacherVaccinService {
    TeacherVaccinDAO aO = new TeacherVaccinDAO();

    public int CreaterTeacherVaccin(TeacherVaccinModel model) {
        return aO.CreaterTeacherVaccin(model);
    }

    public int UpdateTeacherVaccin(TeacherVaccinModel model) {
        return aO.UpdateTeacherVaccin(model);
    }

    public int DeleteTeacherVaccin(TeacherVaccinModel model) {
        return aO.DeleteTeacherVaccin(model);
    }

    public List<TeacherVaccinModel> getTeacherVaccinAllByTeacherID(int TeacherID) {
        return aO.getTeacherVaccinAllByTeacherID(TeacherID);
    }

    public TeacherVaccinModel getTeacherVaccinById(int TeacherVaccinID) {
        return aO.getTeacherVaccinById(TeacherVaccinID);
    }
    
}
