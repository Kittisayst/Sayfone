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
            String html = http.getResponseContent();
            html = html.trim();
            String text = html.replaceAll("<[^>]*>", "");
            String respon = text.replaceAll("\\r?\\n", "").trim();
            return respon.equals("Sayfone school API");
        } catch (Exception e) {
            System.out.println("null");
            return false;
        }
    }

}
