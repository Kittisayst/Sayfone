package DAOInterface;

import Model.ProvinceModel;
import java.util.List;

public interface ProvinceFn {

    public int CreaterProvince(ProvinceModel model);

    public int UpdateProvince(ProvinceModel model);

    public int DeleteProvince(ProvinceModel model);

    public List<ProvinceModel> getAllProvince();

    public ProvinceModel getProvinceById(int ProvinceID);
}
