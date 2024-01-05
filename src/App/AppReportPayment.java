package App;

import Controller.ReportPaymentController;
import View.ReportPaymentView;

public class AppReportPayment {

    private final ReportPaymentController controller;

    public AppReportPayment() {
        ReportPaymentView view = new ReportPaymentView("ລາຍງານຈ່າຍຄ່າຮຽນປະຈຳເດືອນ");
        controller = new ReportPaymentController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
