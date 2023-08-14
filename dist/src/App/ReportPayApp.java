package App;

import Controller.ReportPayController;
import Log.JoLoger;
import Model.FinancialModel;
import View.ReportPayView;

public class ReportPayApp {

    private final FinancialModel model = new FinancialModel();
    private final ReportPayController controller;

    public ReportPayApp() {
        ReportPayView view = new ReportPayView("ລາຍງານຜູ້ຄ້າງຄ່າຮຽນ");
        controller = new ReportPayController(view, model);
    }

    public void Running() {
        try {
            controller.Start();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
