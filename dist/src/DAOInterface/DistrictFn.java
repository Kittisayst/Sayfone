package DAOInterface;

import Model.DistrictModel;
import java.util.List;

public interface DistrictFn {

    public int CreaterDistrict(DistrictModel model);

    public int UpdateDistrict(DistrictModel model);

    public int DeleteDistrict(DistrictModel model);

    public List<DistrictModel> getAllDistrict();

    public DistrictModel getDistrictById(int DistrictID);

    public List<DistrictModel> getProvinceById(int ProvinceID);
}
