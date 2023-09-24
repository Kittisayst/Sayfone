package App;

import Controller.ReportDiscountController;
import View.ReportDiscountView;

public class AppReportDiscount {

    private ReportDiscountController controller;

    public AppReportDiscount() {
        ReportDiscountView view = new ReportDiscountView("ລາຍງານສ່ວນຫຼຸດ");
        controller = new ReportDiscountController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
