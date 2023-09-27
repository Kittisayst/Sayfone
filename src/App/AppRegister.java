package App;

import Controller.CreateRoomController;
import Controller.DasboardController;
import Log.JoLoger;
import Model.GlobalDataModel;
import Model.RegisterModel;
import View.CreateRoomView;
import View.DasboardView;

public class AppRegister {

    public void OpenRegister() {
        DasboardView dasboardView = new DasboardView();
        GlobalDataModel.dasboardView = dasboardView;
        DasboardController dasboardController = new DasboardController(dasboardView);
        dasboardController.UpdateView();
        try {
            CreateRoomView view = new CreateRoomView("ສ້າງຫ້ອງຮຽນ ລົງທະບຽນ");
            RegisterModel model = new RegisterModel();
            CreateRoomController controller = new CreateRoomController(view, model);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }
    }
}
