package App;

import Controller.ReportFinacialController;
import Log.JoLoger;
import Model.FinancialModel;
import View.ReportFinacialView;

public class AppReportFinacial {

    public AppReportFinacial() {
        try {
            ReportFinacialView view = new ReportFinacialView("ລາຍງານການລົງທະບຽນປະຈຳວັນ");
            FinancialModel model = new FinancialModel();
            ReportFinacialController controller = new ReportFinacialController(view, model);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
