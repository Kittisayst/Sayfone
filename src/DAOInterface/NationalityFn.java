package DAOInterface;

import Model.NationalityModel;
import java.util.List;

public interface NationalityFn {

    public int CreaterNationality(NationalityModel model);

    public int UpdateNationality(NationalityModel model);

    public int DeleteNationality(NationalityModel model);

    public List<NationalityModel> getAllNationality();

    public NationalityModel getNationalityById(int NationalityID);
}
