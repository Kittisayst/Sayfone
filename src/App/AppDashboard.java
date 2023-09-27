package App;

import Controller.DasboardController;
import Model.GlobalDataModel;
import View.DasboardView;

public class AppDashboard {

    private DasboardController controller;

    public AppDashboard() {
        DasboardView view = new DasboardView();
        GlobalDataModel.dasboardView = view;
        controller = new DasboardController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
