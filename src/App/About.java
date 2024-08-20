package App;

import Database.JoProperties;
import Model.GlobalDataModel;

public class About {

    private final JoProperties joProperties;

    public About() {
        joProperties = new JoProperties("/Info/About.properties");
        joProperties.addValue("Bulid", "Sayfoneschool Buld");
        joProperties.addValue("version", "2.19.0");
        AppDBPing ping = new AppDBPing();
        //ຕັ້ງຕ່າເລີ່ມຕົ້ນປີ້ນເຕີ 0
        GlobalDataModel.printerBillState = Boolean.parseBoolean(joProperties.getValueAt("PrinterBillState"));  //ໃບບິນ
        GlobalDataModel.printerReportState = Boolean.parseBoolean(joProperties.getValueAt("PrinterReportState")); //ລາຍງານ
    }

    public String getVersion() {
        return joProperties.getValueAt("version");
    }

}
