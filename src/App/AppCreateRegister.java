package App;

import Controller.CreateRegisterController;
import Log.JoLoger;
import Model.RegisterModel;
import View.CreateRegisterView;

public class AppCreateRegister {

    public void showRegisterData() {
        try {
            CreateRegisterView view = new CreateRegisterView("ຈັດການຂໍ້ມູນຫ້ອງລົງທະບຽນ");
            RegisterModel model = new RegisterModel();
            CreateRegisterController controller = new CreateRegisterController(view, model);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }
    }

    public void showRegisterData(RegisterModel model) {
        try {
            CreateRegisterView view = new CreateRegisterView("ຈັດການຂໍ້ມູນຫ້ອງລົງທະບຽນ");
            CreateRegisterController controller = new CreateRegisterController(view, model);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }
    }
}
