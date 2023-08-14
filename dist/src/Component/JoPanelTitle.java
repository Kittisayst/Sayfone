package Component;

import javax.swing.JPanel;

public class JoPanelTitle extends JPanel {

    private String JoTitle = "Title";

    public JoPanelTitle() {
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0), JoTitle, javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Phetsarath OT", 0, 18)));
    }

    public String getJoTitle() {
        return JoTitle;
    }

    public void setJoTitle(String JoTitle) {
        this.JoTitle = JoTitle;
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0), JoTitle, javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Phetsarath OT", 0, 18)));
    }

}
