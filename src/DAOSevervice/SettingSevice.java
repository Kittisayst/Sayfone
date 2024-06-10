
package DAOSevervice;

import DAO.SettingDAO;
import Model.SettingModel;
import java.sql.ResultSet;
import java.util.List;


public class SettingSevice {
    private final SettingDAO aO = new SettingDAO();

    public int create(SettingModel data) {
        return aO.create(data);
    }

    public SettingModel read(int id) {
        return aO.read(id);
    }

    public int update(SettingModel data) {
        return aO.update(data);
    }

    public int delete(int id) {
        return aO.delete(id);
    }

    public List<SettingModel> getAll() {
        return aO.getAll();
    }

    public SettingModel getResult(ResultSet rs) throws Exception {
        return aO.getResult(rs);
    }
    
}
