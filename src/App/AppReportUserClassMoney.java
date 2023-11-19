package App;

import Controller.ReportUserClassRoomMoneyController;
import View.ReportUserClassRoomMoneyView;

public class AppReportUserClassMoney {

    private ReportUserClassRoomMoneyController controller;

    public AppReportUserClassMoney() {
        ReportUserClassRoomMoneyView view = new ReportUserClassRoomMoneyView("ລາຍງານການຈ່າຍຄ່າຮຽນແຕ່ລະຫ້ອງຮຽນ");
        controller = new ReportUserClassRoomMoneyController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
