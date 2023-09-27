package ResourceLoading;

import DAOSevervice.RegisterService;
import Model.GlobalDataModel;

public class RegisterLoading {

    public void createGlobalRegister() {
        RegisterService registerService = new RegisterService();
        GlobalDataModel.registerModels = registerService.getRegisterLastYearAll();
    }
}
