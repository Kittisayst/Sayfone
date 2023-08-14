package DAOSevervice;

import DAO.RegisterDAO;
import Model.CreateRegisterModel;
import java.util.List;

public class RegisterService {

    private final RegisterDAO aO = new RegisterDAO();

    public int Creater(CreateRegisterModel model) {
        return aO.Creater(model);
    }

    public int Update(CreateRegisterModel model) {
        return aO.Update(model);
    }

    public int Delete(int ID) {
        return aO.Delete(ID);
    }

    public List<CreateRegisterModel> getRegisterAll() {
        return aO.getRegisterAll();
    }

    public CreateRegisterModel getRegisterById(int ID) {
        return aO.getRegisterById(ID);
    }

    public int getCountRegister() {
        return aO.getCountRegister();
    }

}
