package Utility;

import Components.JoTable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import theme.JoTheme;

public class TableHeader implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent jcomponent = null;
        if (value instanceof String) {
            jcomponent = new JLabel((String) value);
            ((JLabel) jcomponent).setHorizontalAlignment(0);
            ((JLabel) jcomponent).setSize(35, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(35, jcomponent.getWidth()));
        }
        jcomponent.setEnabled(true);
        jcomponent.setBorder(table.getBorder());
        jcomponent.setOpaque(true);
        jcomponent.setBackground(JoTheme.HoverColor);
        jcomponent.setForeground(Color.WHITE);
        jcomponent.setFont(table.getTableHeader().getFont());
        return jcomponent;
    }

}
