package App;

import Controller.LoginController;
import DAOSevervice.UserService;
import Log.JoLoger;
import Tools.JoAlert;
import Utility.SayfoneFile;
import View.LoginView;
import theme.JoTheme;

public class SayFoneSchool {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JoTheme().setLookUI();
                LoginView view = new LoginView();
                UserService service = new UserService();
                LoginController controller = new LoginController(service, view);
                SayfoneFile file = new SayfoneFile();
            } catch (Exception e) {
                JoAlert.Error(e, args);
                JoLoger.saveLog(e, args);
            }
        });

    }

}
