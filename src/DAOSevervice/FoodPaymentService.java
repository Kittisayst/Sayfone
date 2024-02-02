package DAOSevervice;

import DAO.FoodPaymentDAO;
import Model.FoodPaymentModel;
import java.sql.ResultSet;
import java.util.List;

public class FoodPaymentService {

    private final FoodPaymentDAO aO = new FoodPaymentDAO();

    public int create(FoodPaymentModel data) {
        return aO.create(data);
    }

    public FoodPaymentModel read(int id) {
        return aO.read(id);
    }

    public int update(FoodPaymentModel data) {
        return aO.update(data);
    }

    public int delete(int id) {
        return aO.delete(id);
    }

    public List<FoodPaymentModel> getAll() {
        return aO.getAll();
    }

    public List<FoodPaymentModel> getByRegisterID(int RegisterID) {
        return aO.getByRegisterID(RegisterID);
    }

    public List<FoodPaymentModel> getByRegisterANDStudentID(int RegisterID, int StudentID) {
        return aO.getByRegisterANDStudentID(RegisterID, StudentID);
    }

    public FoodPaymentModel getResult(ResultSet rs) throws Exception {
        return aO.getResult(rs);
    }

}
