package Utility;

import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class JoSheet {

    private String path;
    private String sheetName;
    private String[] columns;
    private Workbook workbook;
    private Sheet sheet;
    private Font sheetFont;
    private CellStyle sheetStyle;
    private BorderStyle borderStyle = BorderStyle.THIN;
    private String fontName = "Phetsarath OT";

    public JoSheet(String path, String sheetName, String[] columns) {
        this.path = path;
        this.sheetName = sheetName;
        this.columns = columns;
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet(sheetName);
        sheetFont = workbook.createFont();
        sheetFont.setFontName(fontName);
        sheetStyle = workbook.createCellStyle();
        sheetStyle.setBorderTop(borderStyle);
        sheetStyle.setBorderLeft(borderStyle);
        sheetStyle.setBorderRight(borderStyle);
        sheetStyle.setBorderBottom(borderStyle);
        sheetStyle.setFont(sheetFont);
        setSheetHeader();
    }

    private void setSheetHeader() {
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i <= columns.length - 1; i++) {
            String columnName = columns[i];
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnName);
            cell.setCellStyle(sheetStyle);
        }
    }

    private void sheetAutoSize(Sheet sheet, String[] columns) {
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    public void addRow(int indexRow, Object... values) {
        Row row = sheet.createRow(indexRow);
        for (int i = 0; i < values.length; i++) {
            Cell cell = row.createCell(i);
//            System.out.println("data: "+values[i].toString());
            cell.setCellValue(validate(values[i]));
            cell.setCellStyle(sheetStyle);
        }
    }

    private String validate(Object value) {
        return value == null ? "" : value.toString();
    }

    public void getCreateSheet() throws Exception {
        sheetAutoSize(sheet, columns);
        try (OutputStream fileOut = new FileOutputStream(path)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public Font getSheetFont() {
        return sheetFont;
    }

    public void setSheetFont(Font sheetFont) {
        this.sheetFont = sheetFont;
    }

    public CellStyle getSheetStyle() {
        return sheetStyle;
    }

    public void setSheetStyle(CellStyle sheetStyle) {
        this.sheetStyle = sheetStyle;
    }

    public BorderStyle getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(BorderStyle borderStyle) {
        this.borderStyle = borderStyle;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    @Override
    public String toString() {
        return "JoSheet{" + "path=" + path + ", sheetName=" + sheetName + ", columns=" + columns + ", workbook=" + workbook + ", sheet=" + sheet + ", sheetFont=" + sheetFont + ", sheetStyle=" + sheetStyle + ", borderStyle=" + borderStyle + ", fontName=" + fontName + '}';
    }

}
