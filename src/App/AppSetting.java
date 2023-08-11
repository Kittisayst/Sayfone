package App;

import Controller.SayfoneController;
import DAOSevervice.SayfoneService;
import Log.JoLoger;
import Tools.JoAlert;
import View.SettingView;

public class AppSetting {

    private SayfoneController controller;

    public AppSetting() {
        SettingView view = new SettingView("ຕັ້ງຄ່າໂຮງຮຽນ");
        controller = new SayfoneController(view, new SayfoneService().getById(1));
    }

    public void Open() {
        try {
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }

    }
}
