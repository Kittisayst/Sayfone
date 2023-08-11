package DAOInterface;

import Model.SayfoneModel;
import java.util.List;

public interface SayFoneFn {

    public int Creater(SayfoneModel model);

    public int Update(SayfoneModel model);

    public int Delete(SayfoneModel model);

    public List<SayfoneModel> getAll();

    public SayfoneModel getById(int ID);
}
