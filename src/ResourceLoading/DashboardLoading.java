package ResourceLoading;

import Controller.DasboardController;
import Model.GlobalDataModel;
import View.DasboardView;

public class DashboardLoading {

    public void createGlobalDashboard() {
        DasboardView dasboardView = new DasboardView();
        GlobalDataModel.dasboardView = dasboardView;
        DasboardController dasboardController = new DasboardController(dasboardView);
        dasboardController.UpdateView();
    }
}
