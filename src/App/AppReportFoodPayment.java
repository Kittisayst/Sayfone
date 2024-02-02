package App;

import Controller.ReportFoodPaymentController;
import View.ReportFoodPaymentView;

public class AppReportFoodPayment {

    private final ReportFoodPaymentController controller;

    public AppReportFoodPayment() {
        ReportFoodPaymentView view = new ReportFoodPaymentView("ລາຍງານຄ່າອາຫານ v2");
        controller = new ReportFoodPaymentController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
