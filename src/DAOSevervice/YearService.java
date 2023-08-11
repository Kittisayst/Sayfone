package DAOSevervice;

import DAO.YearDAO;
import Model.YearModel;
import java.util.List;

public class YearService {

    private final YearDAO dAO = new YearDAO();

    public int Creater(YearModel model) {
        return dAO.Creater(model);
    }

    public int Update(YearModel model) {
        return dAO.Update(model);
    }

    public int Delete(YearModel model) {
        return dAO.Delete(model);
    }

    public List<YearModel> getYearAll() {
        return dAO.getYearAll();
    }

    public YearModel getYearById(int ID) {
        return dAO.getYearById(ID);
    }

    public YearModel getLastYear() {
        return dAO.getLastYear();
    }
    
    

}
