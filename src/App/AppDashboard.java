package App;

import Controller.DasboardController;
import Log.JoLoger;
import View.DasboardView;

public class AppDashboard {

    public static DasboardView dasboardView;

    public AppDashboard() {
        try {
            DasboardView view = new DasboardView();
            dasboardView = view;
            DasboardController controller = new DasboardController(view);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
