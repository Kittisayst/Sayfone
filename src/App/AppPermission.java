package App;

import Controller.PermissionController;
import Model.PermissionModel;
import View.PermissionView;

public class AppPermission {

    private final PermissionController controller;

    public AppPermission() {
        PermissionView view = new PermissionView("ຈັດການຂໍ້ມູນສິດທິ");
        PermissionModel model = new PermissionModel();
        controller = new PermissionController(view, model);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
