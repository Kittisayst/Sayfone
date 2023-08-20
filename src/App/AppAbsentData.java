package App;

import Controller.AbsentDataController;
import Model.RegisterModel;
import View.AbsentDataView;

public class AppAbsentData {

    private AbsentDataView view;
    private AbsentDataController controller;

    public AppAbsentData(RegisterModel registerModel) {
        view = new AbsentDataView("ບັນທຶກການຂາດຮຽນ " + registerModel.getClassRoomName());
        controller = new AbsentDataController(view, registerModel);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
