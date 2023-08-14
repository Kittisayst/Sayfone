package App;

import Controller.UserController;
import Log.JoLoger;
import Model.UserModel;
import View.UserView;

public class AppUser {

    private UserController controller;

    public AppUser() {
        UserView view = new UserView("ຂໍ້ມູນຜູ້ໃຊ້ງານ");
        UserModel model = new UserModel();
        controller = new UserController(view, model);
    }

    public void Open() {
        try {
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
