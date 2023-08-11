package Component;

import javax.swing.*;
import java.awt.*;

public class TimeSelector extends JPanel {

    private JComboBox<String> hourBox;
    private JComboBox<String> minuteBox;

    public TimeSelector() {
        setLayout(new FlowLayout());

        // Hour selector
        JLabel hourLabel = new JLabel("ຊົ່ວໂມງ:");
        hourLabel.setFont(new Font("Phetsarath OT", 0, 12));
        String[] hours = new String[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d", i);
        }
        hourBox = new JComboBox<>(hours);
        hourBox.setPreferredSize(new Dimension(50, 30));

        // Minute selector
        JLabel minuteLabel = new JLabel("ນາທີ:");
        minuteLabel.setFont(new Font("Phetsarath OT", 0, 12));
        String[] minutes = new String[60];
        for (int i = 0; i < 60; i++) {
            minutes[i] = String.format("%02d", i);
        }
        minuteBox = new JComboBox<>(minutes);
        minuteBox.setPreferredSize(new Dimension(50, 30));

        // Add components to panel
        add(hourLabel);
        add(hourBox);
        add(minuteLabel);
        add(minuteBox);
    }
    
    public void setTime(int hour,int minute){
        String hourString = String.format("%02d", hour);
        String minuteString = String.format("%02d", minute);
        hourBox.setSelectedItem(hourString);
        minuteBox.setSelectedItem(minuteString);
    }

    public String getTime() {
        return hourBox.getSelectedItem().toString() + ":" + minuteBox.getSelectedItem().toString();
    }

}
