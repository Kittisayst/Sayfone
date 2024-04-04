package Utility;

import Component.PanelTableAction;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ActionCellEvent extends DefaultCellEditor {

    private final ActionListener[] events;

    public ActionCellEvent(ActionListener... events) {
        super(new JCheckBox());
        this.events = events;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelTableAction action = new PanelTableAction();
        action.InitEvent(events);
        action.setBackground(table.getSelectionBackground());
        return action;
    }

}
