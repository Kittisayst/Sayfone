package DAOSevervice;

import DAO.BrotherssistersDAO;
import Model.BrotherAndSisterModel;
import java.util.List;

public class BroderSisterService {

    private BrotherssistersDAO aO = new BrotherssistersDAO();

    public int CreaterBrotherAndSister(BrotherAndSisterModel model) {
        return aO.CreaterBrotherAndSister(model);
    }

    public int UpdateBrotherAndSister(BrotherAndSisterModel model) {
        return aO.UpdateBrotherAndSister(model);
    }

    public int DeleteBrotherAndSister(BrotherAndSisterModel model) {
        return aO.DeleteBrotherAndSister(model);
    }

    public List<BrotherAndSisterModel> getBrotherAndSisterAll() {
        return aO.getBrotherAndSisterAll();
    }

    public BrotherAndSisterModel getBrotherAndSisterById(int ID) {
        return aO.getBrotherAndSisterById(ID);
    }

    public List<BrotherAndSisterModel> getBrotherSisterAll(int StudentID) {
        return aO.getBrotherSisterAll(StudentID);
    }

}
