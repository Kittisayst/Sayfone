
package DAOSevervice;

import DAO.TeacherMoneyDAO;
import Model.TeacherMoneyModel;
import java.sql.ResultSet;
import java.util.List;


public class TeacherMoneyService {
    private TeacherMoneyDAO dAO = new TeacherMoneyDAO();

    public int create(TeacherMoneyModel data) {
        return dAO.create(data);
    }

    public TeacherMoneyModel read(int id) {
        return dAO.read(id);
    }

    public TeacherMoneyModel readTeacherID(int id) {
        return dAO.readTeacherID(id);
    }

    public int update(TeacherMoneyModel data) {
        return dAO.update(data);
    }

    public int delete(int id) {
        return dAO.delete(id);
    }

    public List<TeacherMoneyModel> getAll() {
        return dAO.getAll();
    }

    public TeacherMoneyModel getResult(ResultSet rs) throws Exception {
        return dAO.getResult(rs);
    }
    
}
