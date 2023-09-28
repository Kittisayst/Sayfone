package ResourceLoading;

import DAOSevervice.RegisterService;
import Model.RegisterModel;
import java.util.List;

public class RegisterLoading {

    public List<RegisterModel> createGlobalRegister() {
        RegisterService registerService = new RegisterService();
        return registerService.getRegisterLastYearAll();
    }
}
