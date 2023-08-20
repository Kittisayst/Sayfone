package App;

import Controller.CreateRoomController;
import Log.JoLoger;
import Model.RegisterModel;
import View.CreateRoomView;

public class AppRegister {
    
    public void OpenRegister() {
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
