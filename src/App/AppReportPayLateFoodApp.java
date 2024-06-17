package App;

import Controller.ReportPayLateFoodController;
import Log.JoLoger;
import Model.FinancialModel;
import View.ReportPayLateFoodView;

public class AppReportPayLateFoodApp {

    private final FinancialModel model = new FinancialModel();
    private final ReportPayLateFoodController controller;

    public AppReportPayLateFoodApp() {
        ReportPayLateFoodView view = new ReportPayLateFoodView("ລາຍງານຜູ້ຄ້າງຄ່າອາຫານ");
        controller = new ReportPayLateFoodController(view, model);
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
