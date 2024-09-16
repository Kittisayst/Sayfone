package Utility;

import Model.GlobalDataModel;
import Tools.JoFileSystem;
import View.PnLoading;
import java.util.Date;
import javax.swing.JPanel;

public class JoExportExcel {

    private JoFileSystem fileSystem;
    private String fileName;
    private String csvFile;
    private JoSheet sheet;
    private PnLoading loading;
    private int row = 1;

    public JoExportExcel(String[] columns, String sheetName, String name) {
        fileSystem = new JoFileSystem();
        loading = new PnLoading();
        fileName = name + new MyFormat().getTime(new Date(), "-HH-mm-ss") + ".xls";
        csvFile = fileSystem.getUserPath() + "/Downloads/" + fileName;
        sheet = new JoSheet(csvFile, sheetName, columns);
    }

    public void showLoading(String titleLoading) {
        loading.setTitle(titleLoading);
        GlobalDataModel.rootView.setView(loading);
    }

    public void addRow(Object... values) {
        sheet.addRow(row++, values);
    }

    public void createExport() throws Exception {
        sheet.getCreateSheet();
        fileSystem.OpenFile(csvFile);
    }

    public int getAutoNum() {
        return row;
    }

    public void setSleep(int size, int sleep) {
        loading.StartProgress(size, sleep);
    }

    public void closeExport(JPanel view) {
        loading.close();
        row = 1;
        GlobalDataModel.rootView.setView(view);
    }

}
