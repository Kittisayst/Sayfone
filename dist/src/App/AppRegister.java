package App;

import Controller.CreateRoomController;
import Log.JoLoger;
import Model.CreateRegisterModel;
import View.CreateRoomView;

public class AppRegister {
    
    public void OpenRegister() {
        try {
            CreateRoomView view = new CreateRoomView("ສ້າງຫ້ອງຮຽນ ລົງທະບຽນ");
            CreateRegisterModel model = new CreateRegisterModel();
            CreateRoomController controller = new CreateRoomController(view, model);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }
    }
}
