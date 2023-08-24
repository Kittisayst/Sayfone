package Utility;

import Database.JoProperties;
import Log.JoLoger;
import Tools.JoAlert;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.PrinterName;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;

public class JoJasperPrinter {

    private final JasperPrint jasperPrint;

    public JoJasperPrinter(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public void print() {
        try {
            JoProperties properties = new JoProperties("Info/About.properties");
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            int Copies = Integer.parseInt(properties.getValueAt("Copies"));
            printRequestAttributeSet.add(new Copies(Copies));
            PrinterName printerName = new PrinterName(properties.getValueAt("PrinterName"), null); //gets printer 
            PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
            printServiceAttributeSet.add(printerName);
            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
            SimplePrintServiceExporterConfiguration configuration = new SimplePrintServiceExporterConfiguration();
            configuration.setPrintRequestAttributeSet(printRequestAttributeSet);
            configuration.setPrintServiceAttributeSet(printServiceAttributeSet);
            configuration.setDisplayPageDialog(false);
            configuration.setDisplayPrintDialog(false);
            exporter.setConfiguration(configuration);
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.exportReport();
        } catch (JRException ex) {
            JoLoger.saveLog(ex, this);
            JoAlert.Error(ex, this);
        }
    }
    
     public void print(int copies) {
        try {
            JoProperties properties = new JoProperties("Info/About.properties");
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            printRequestAttributeSet.add(new Copies(copies));
            PrinterName printerName = new PrinterName(properties.getValueAt("PrinterName"), null); //gets printer 
            PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
            printServiceAttributeSet.add(printerName);
            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
            SimplePrintServiceExporterConfiguration configuration = new SimplePrintServiceExporterConfiguration();
            configuration.setPrintRequestAttributeSet(printRequestAttributeSet);
            configuration.setPrintServiceAttributeSet(printServiceAttributeSet);
            configuration.setDisplayPageDialog(false);
            configuration.setDisplayPrintDialog(false);
            exporter.setConfiguration(configuration);
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.exportReport();
        } catch (JRException ex) {
            JoLoger.saveLog(ex, this);
            JoAlert.Error(ex, this);
        }
    }

}
