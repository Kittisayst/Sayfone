package DAOInterface;

import Model.YearModel;
import java.util.List;

public interface YearFn {

    public int Creater(YearModel model);

    public int Update(YearModel model);

    public int Delete(YearModel model);

    public List<YearModel> getYearAll();

    public YearModel getYearById(int ID);
    
    public YearModel getLastYear();
}
