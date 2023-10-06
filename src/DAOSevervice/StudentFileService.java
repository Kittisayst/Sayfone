package DAOSevervice;

import DAO.StudentFileDAO;
import Model.StudentFileModel;
import java.sql.ResultSet;
import java.util.List;

public class StudentFileService {

    private final StudentFileDAO dao = new StudentFileDAO();

    public int create(StudentFileModel data) {
        return dao.create(data);
    }

    public StudentFileModel read(int id) {
        return dao.read(id);
    }

    public int update(StudentFileModel data) {
        return dao.update(data);
    }

    public int delete(int id) {
        return dao.delete(id);
    }

    public List<StudentFileModel> getAll() {
        return dao.getAll();
    }

    public List<StudentFileModel> getByStudentID(int ID) {
        return dao.getByStudentID(ID);
    }

    public StudentFileModel getResult(ResultSet rs) throws Exception {
        return dao.getResult(rs);
    }

    public boolean openFile(int id) {
        return dao.openFile(id);
    }
    
    

}
