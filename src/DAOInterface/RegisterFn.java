package DAOInterface;

import Model.CreateRegisterModel;
import java.util.List;

public interface RegisterFn {

    public int Creater(CreateRegisterModel model);

    public int Update(CreateRegisterModel model);

    public int Delete(int ID);

    public List<CreateRegisterModel> getRegisterAll();

    public CreateRegisterModel getRegisterById(int ID);
    
    public int getCountRegister();
}
