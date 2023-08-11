package DAOSevervice;

import DAO.OutStandingCatDAO;
import Model.OutstandingCatModel;
import java.util.List;

public class OutStandingCatService {

    OutStandingCatDAO aO = new OutStandingCatDAO();

    public int Creater(OutstandingCatModel model) {
        return aO.Creater(model);
    }

    public int Update(OutstandingCatModel model) {
        return aO.Update(model);
    }

    public int Delete(OutstandingCatModel model) {
        return aO.Delete(model);
    }

    public List<OutstandingCatModel> getAllOutstanding() {
        return aO.getAllOutstanding();
    }

    public OutstandingCatModel getOutstandingById(int OutstandingID) {
        return aO.getOutstandingById(OutstandingID);
    }

}
