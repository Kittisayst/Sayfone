package DAOSevervice;

import DAO.StudentKnowDAO;
import Model.StudentKnowModel;
import java.sql.ResultSet;
import java.util.List;

public class StudentKnowService {

    private final StudentKnowDAO dAO = new StudentKnowDAO();

    public int create(StudentKnowModel data) {
        return dAO.create(data);
    }

    public int create_update(StudentKnowModel data) {
        return dAO.create_update(data);
    }

    public StudentKnowModel read(int id) {
        return dAO.read(id);
    }

    public int update(StudentKnowModel data) {
        return dAO.update(data);
    }

    public int delete(int id) {
        return dAO.delete(id);
    }

    public List<StudentKnowModel> getAll() {
        return dAO.getAll();
    }

    public StudentKnowModel getResult(ResultSet rs) throws Exception {
        return dAO.getResult(rs);
    }

    public List<String> getKnowList() {
        return dAO.getKnowList();
    }

}
