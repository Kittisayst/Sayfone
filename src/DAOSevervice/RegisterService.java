package DAOSevervice;

import DAO.RegisterDAO;
import Model.RegisterModel;
import java.util.List;

public class RegisterService {

    private final RegisterDAO aO = new RegisterDAO();

    public int Creater(RegisterModel model) {
        return aO.Creater(model);
    }

    public int Update(RegisterModel model) {
        return aO.Update(model);
    }

    public int Delete(int ID) {
        return aO.Delete(ID);
    }

    public List<RegisterModel> getRegisterAll() {
        return aO.getRegisterAll();
    }

    public RegisterModel getRegisterById(int ID) {
        return aO.getRegisterById(ID);
    }

    public int getCountRegister() {
        return aO.getCountRegister();
    }

    public boolean getCheckClassRegister(int classID) {
        return aO.getCheckClassRegister(classID);
    }

    public List<RegisterModel> getRegisterLastYearAll() {
        return aO.getRegisterLastYearAll();
    }

    public List<RegisterModel> getRegisterAllByYearID(int YearID) {
        return aO.getRegisterAllByYearID(YearID);
    }

    public List<RegisterModel> getRegisterByYear_Class(int YearID, int ClassID) {
        return aO.getRegisterByYear_Class(YearID, ClassID);
    }

}
