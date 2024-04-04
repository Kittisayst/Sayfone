package Component;

import Tools.JoAlert;
import Utility.ActionCellEvent;
import Utility.ActionCellRender;
import Utility.TableHeader;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JoTableAction extends JTable {

    private boolean JoCellAction = false;
    private DefaultTableModel tableModel = new DefaultTableModel();

    public JoTableAction() {
        setRowHeight(28);
        getTableHeader().setFont(new Font("Phetsarath OT", 1, 14));
        setFont(new Font("Phetsarath OT", 0, 12));
        getTableHeader().setDefaultRenderer(new TableHeader());
    }

    public void setActionCellEvent(ActionCellEvent cellEvent) {
        int lastColumn = getColumnCount() - 1;
        getColumnModel().getColumn(lastColumn).setCellEditor(cellEvent);
    }

    public boolean isJoCellAction() {
        return JoCellAction;
    }

    public void setJoCellAction(boolean JoCellAction) {
        this.JoCellAction = JoCellAction;
        int lastColumn = getColumnCount() - 1;
        if (JoCellAction) {
            getColumnModel().getColumn(lastColumn).setCellRenderer(new ActionCellRender());
        }
    }

    public void clearModel() {
        int row = getRowCount() - 1;
        while (row > -1) {
            tableModel.removeRow(row--);
        }
    }

    public int autoNumber() {
        return getRowCount() + 1;
    }

    public String getValue(int columnIndex) {
        int row = getSelectedRow();
        if (row < 0) {
            new JoAlert().messages("ຄຳເຕືອນ", "ກະລຸນາເລືອກຂໍ້ມູນໃນຕາຕະລາງ", "warning");
            return "NaN";
        } else {
            return getValueAt(row, columnIndex).toString();
        }
    }

    public int getIntValue(int columnIndex) {
        int row = getSelectedRow();
        if (row < 0) {
            new JoAlert().messages("ຄຳເຕືອນ", "ກະລຸນາເລືອກຂໍ້ມູນໃນຕາຕະລາງ", "warning");
            return 0;
        } else {
            return Integer.parseInt(getValueAt(row, columnIndex).toString());
        }
    }

    private DefaultTableModel getJoModel() {
        tableModel = (DefaultTableModel) getModel();
        return tableModel;
    }

    public void AddJoModel(Object[] rows) {
        if (rows != null) {
            getJoModel().addRow(rows);
            setModel(tableModel);
        }
    }

}
