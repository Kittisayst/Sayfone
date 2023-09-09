package App;

import Controller.ReportUserFinancialController;
import View.ReportUserFainancialView;

public class AppReportUserFinancial {

    private final ReportUserFinancialController controller;

    public AppReportUserFinancial() {
        ReportUserFainancialView view = new ReportUserFainancialView("ລາຍງານຈ່າຍຄ່າຮຽນຕາມຜູ້ລົງບັນຊີ");
        controller = new ReportUserFinancialController(view);
    }

    public void OPen() {
        controller.Start();
        controller.AddEvent();
    }

}
