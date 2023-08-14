package DAOSevervice;

import DAO.DistrictDAO;
import Model.DistrictModel;
import java.util.List;

public class DistrictService {

    DistrictDAO aO = new DistrictDAO();

    public int CreaterDistrict(DistrictModel model) {
        return aO.CreaterDistrict(model);
    }

    public int UpdateDistrict(DistrictModel model) {
        return aO.UpdateDistrict(model);
    }

    public int DeleteDistrict(DistrictModel model) {
        return aO.DeleteDistrict(model);
    }

    public List<DistrictModel> getAllDistrict() {
        return aO.getAllDistrict();
    }

    public DistrictModel getDistrictById(int DistrictID) {
        return aO.getDistrictById(DistrictID);
    }

    public List<DistrictModel> getProvinceById(int ProvinceID) {
        return aO.getProvinceById(ProvinceID);
    }

}
