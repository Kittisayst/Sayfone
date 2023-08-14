package App;

import Controller.CreateRegisterController;
import Log.JoLoger;
import Model.CreateRegisterModel;
import View.CreateRegisterView;

public class AppCreateRegister {

    public void showRegisterData() {
        try {
            CreateRegisterView view = new CreateRegisterView("ຈັດການຂໍ້ມູນຫ້ອງລົງທະບຽນ");
            CreateRegisterModel model = new CreateRegisterModel();
            CreateRegisterController controller = new CreateRegisterController(view, model);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }
    }

    public void showRegisterData(CreateRegisterModel model) {
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
