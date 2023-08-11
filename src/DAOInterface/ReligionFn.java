package DAOInterface;

import Model.ReligionModel;
import java.util.List;

public interface ReligionFn {

    public int CreaterReligionModel(ReligionModel model);

    public int UpdateReligionModel(ReligionModel model);

    public int DeleteReligionModel(ReligionModel model);

    public List<ReligionModel> getAllReligionModel();

    public ReligionModel getReligionModelById(int ReligionModelID);
}
