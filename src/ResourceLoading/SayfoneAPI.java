package ResourceLoading;

import Database.JoProperties;
import Main.JoHttp;

public class SayfoneAPI {

    private JoProperties property = new JoProperties("/JoConfig/config.properties");
    private String server = property.getValueAt("db.Server");

    public boolean checkAPI() {
        try {
            JoHttp http = new JoHttp("http://" + server + "/sayfone");
            http.Open();
            return http.getResponseCode() == 200;
        } catch (Exception e) {
            System.out.println("null");
            return false;
        }
    }

}
