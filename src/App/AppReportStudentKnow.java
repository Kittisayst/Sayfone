package App;

import Controller.ReportStudentKnowController;
import View.ReportStudentKnowView;

public class AppReportStudentKnow {

    private ReportStudentKnowController controller;

    public AppReportStudentKnow() {
        ReportStudentKnowView view = new ReportStudentKnowView("ລາຍງານຮູ້ຈັກໂຮງຮຽນ");
        controller = new ReportStudentKnowController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
