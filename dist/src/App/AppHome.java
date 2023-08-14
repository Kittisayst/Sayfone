package App;

import Controller.HomeController;
import Model.UserModel;
import DAOSevervice.UserService;
import Log.JoLoger;
import View.HomeView;
import javax.swing.JFrame;

public class AppHome {
    
    public static JFrame viewParent;
    
    public AppHome(UserModel model) {
        try {
            HomeView view = new HomeView();
            viewParent = view;
            UserService service = new UserService();
            HomeController controller = new HomeController(service, view, model);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }
    }
    
}
