package App;

import Controller.AbsentDataController;
import Model.CreateRegisterModel;
import View.AbsentDataView;

public class AppAbsentData {

    private AbsentDataView view;
    private AbsentDataController controller;

    public AppAbsentData(CreateRegisterModel registerModel) {
        view = new AbsentDataView("ບັນທຶກການຂາດຮຽນ " + registerModel.getClassRoomName());
        controller = new AbsentDataController(view, registerModel);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
