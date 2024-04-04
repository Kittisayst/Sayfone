package Utility;

import Component.PanelTableAction;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        PanelTableAction action = new PanelTableAction();
        if (isSelected == false && row % 2 == 0) {
            action.setBackground(Color.white);
        } else {
            action.setBackground(com.getBackground());
        }
        return action;
    }

}
