package App;

import ResourceLoading.LoadingResources;
import Log.JoLoger;
import Tools.JoAlert;
import theme.JoTheme;

public class SayFoneSchool {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JoTheme().setLookUI();
                LoadingResources resource = new LoadingResources();
                resource.startLoading();
                resource.setVisible(true);
            } catch (Exception e) {
                JoAlert.Error(e, args);
                JoLoger.saveLog(e, args);
            }
        });

    }

}
