package DAOInterface;

import Model.RegisterModel;
import java.util.List;

public interface RegisterFn {

    public int Creater(RegisterModel model);

    public int Update(RegisterModel model);

    public int Delete(int ID);

    public List<RegisterModel> getRegisterAll();

    public List<RegisterModel> getRegisterAllByYearID(int YearID);

    public List<RegisterModel> getRegisterLastYearAll();

    public RegisterModel getRegisterById(int ID);

    public int getCountRegister();

    public boolean getCheckClassRegister(int classID);
}
