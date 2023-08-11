
package DAOSevervice;

import DAO.ReligionDAO;
import Model.ReligionModel;
import java.util.List;


public class ReligionService {
    ReligionDAO religionDAO = new ReligionDAO();

    public void CreaterReligionModel(ReligionModel model) {
        religionDAO.CreaterReligionModel(model);
    }

    public void UpdateReligionModel(ReligionModel model) {
        religionDAO.UpdateReligionModel(model);
    }

    public void DeleteReligionModel(ReligionModel model) {
        religionDAO.DeleteReligionModel(model);
    }

    public List<ReligionModel> getAllReligionModel() {
        return religionDAO.getAllReligionModel();
    }

    public ReligionModel getReligionModelById(int ReligionModelID) {
        return religionDAO.getReligionModelById(ReligionModelID);
    }
    
}
