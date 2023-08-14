
package DAOSevervice;

import DAO.TeacherOutStandingDAO;
import Model.TeacherOutstandingModel;
import java.util.List;


public class TeacherOutStandingService {
    TeacherOutStandingDAO aO = new TeacherOutStandingDAO();

    public int CreaterTeacherOutstanding(TeacherOutstandingModel model) {
        return aO.CreaterTeacherOutstanding(model);
    }

    public int UpdateTeacherOutstanding(TeacherOutstandingModel model) {
        return aO.UpdateTeacherOutstanding(model);
    }

    public int DeleteTeacherOutstanding(TeacherOutstandingModel model) {
        return aO.DeleteTeacherOutstanding(model);
    }

    public List<TeacherOutstandingModel> getAllByTeacherID(int TeacherID) {
        return aO.getAllByTeacherID(TeacherID);
    }

    public TeacherOutstandingModel getByTeacherOutstandingID(int TeacherOutstandingID) {
        return aO.getByTeacherOutstandingID(TeacherOutstandingID);
    }
    
}
