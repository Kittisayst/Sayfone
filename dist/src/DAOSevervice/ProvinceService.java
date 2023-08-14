package DAOSevervice;

import DAO.ProvinceDAO;
import Model.ProvinceModel;
import java.util.List;

public class ProvinceService {

    private final ProvinceDAO aO = new ProvinceDAO();

    public int CreaterProvince(ProvinceModel model) {
        return aO.CreaterProvince(model);
    }

    public int UpdateProvince(ProvinceModel model) {
        return aO.UpdateProvince(model);
    }

    public int DeleteProvince(ProvinceModel model) {
        return aO.DeleteProvince(model);
    }

    public List<ProvinceModel> getAllProvince() {
        return aO.getAllProvince();
    }

    public ProvinceModel getProvinceById(int ProvinceID) {
        return aO.getProvinceById(ProvinceID);
    }

}
