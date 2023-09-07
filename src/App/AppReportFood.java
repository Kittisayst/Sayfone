package App;

import Controller.ReportFoodController;
import View.ReportFoodView;

public class AppReportFood {

    private ReportFoodController controller;

    public AppReportFood() {
        ReportFoodView view = new ReportFoodView("ລາຍງານຄ່າອາຫານ");
        controller = new ReportFoodController(view);
    }

    public void open() {
        controller.Start();
        controller.AddEvent();
    }

}
