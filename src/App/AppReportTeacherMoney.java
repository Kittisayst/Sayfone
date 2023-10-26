package App;

import Controller.ReportTeacherMoneyController;
import View.ReportTeacherMoneyView;

public class AppReportTeacherMoney {

    private final ReportTeacherMoneyController controller;

    public AppReportTeacherMoney() {
        ReportTeacherMoneyView view = new ReportTeacherMoneyView("ລາຍງານການເງິນຄູສອນ");
        controller = new ReportTeacherMoneyController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
