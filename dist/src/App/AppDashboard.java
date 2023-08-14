package App;

import Controller.DasboardController;
import Log.JoLoger;
import View.DasboardView;

public class AppDashboard {

    public AppDashboard() {
        try {
            DasboardView view = new DasboardView();
            DasboardController controller = new DasboardController(view);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
