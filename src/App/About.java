package App;

import Database.JoProperties;

public class About {

    private final JoProperties joProperties;

    public About() {
        joProperties = new JoProperties("/Info/About.properties");
        joProperties.addValue("Bulid", "Sayfoneschool Buld");
        joProperties.addValue("version", "1.0.9");
    }

    public String getVersion() {
        return joProperties.getValueAt("version");
    }

}
