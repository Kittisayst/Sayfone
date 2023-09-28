
package DAOSevervice;

import DAO.PermissionDAO;
import Model.PermissionModel;
import java.sql.ResultSet;
import java.util.List;


public class PermissionService {
    private PermissionDAO dao = new PermissionDAO();

    public int create(PermissionModel data) {
        return dao.create(data);
    }

    public PermissionModel read(int id) {
        return dao.read(id);
    }

    public int update(PermissionModel data) {
        return dao.update(data);
    }

    public int delete(int id) {
        return dao.delete(id);
    }

    public List<PermissionModel> getAll() {
        return dao.getAll();
    }

    public PermissionModel getRole(int UserID, int Type) {
        return dao.getRole(UserID, Type);
    }

    public PermissionModel getResult(ResultSet rs) throws Exception {
        return dao.getResult(rs);
    }
    
}
