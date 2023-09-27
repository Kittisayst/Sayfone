package App;

import Controller.HomeController;
import Model.UserModel;
import DAOSevervice.UserService;
import Log.JoLoger;
import Model.GlobalDataModel;
import View.HomeView;

public class AppHome {

    public AppHome(UserModel model) {
        try {
            HomeView view = new HomeView();
            GlobalDataModel.rootView = view;
            UserService service = new UserService();
            HomeController controller = new HomeController(service, view, model);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }
    }

}
