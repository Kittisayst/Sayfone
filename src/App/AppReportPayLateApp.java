package App;

import Controller.ReportPayLateController;
import Log.JoLoger;
import Model.FinancialModel;
import View.ReportPayLateView;

public class AppReportPayLateApp {

    private final FinancialModel model = new FinancialModel();
    private final ReportPayLateController controller;

    public AppReportPayLateApp() {
        ReportPayLateView view = new ReportPayLateView("ລາຍງານຜູ້ຄ້າງຄ່າຮຽນ");
        controller = new ReportPayLateController(view, model);
    }

    public void Running() {
        try {
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
