package DAOSevervice;

import DAO.AbsentDAO;
import Model.AbsentModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

public class AbsentService {

    private AbsentDAO dao = new AbsentDAO();

    public int create(AbsentModel data) {
        return dao.create(data);
    }

    public AbsentModel read(int id) {
        return dao.read(id);
    }

    public List<AbsentModel> readByRegisterID(int registerID) {
        return dao.readByRegisterID(registerID);
    }

    public List<AbsentModel> searchByDate(Date date) {
        return dao.searchByDate(date);
    }

    public int update(AbsentModel data) {
        return dao.update(data);
    }

    public int delete(int id) {
        return dao.delete(id);
    }

    public List<AbsentModel> getAll() {
        return dao.getAll();
    }

    public AbsentModel getResult(ResultSet rs) throws Exception {
        return dao.getResult(rs);
    }

}
