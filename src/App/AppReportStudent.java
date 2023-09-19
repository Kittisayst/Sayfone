package App;

import Controller.ReportStudentController;
import View.ReportStudentView;

public class AppReportStudent {

    private final ReportStudentController controller;

    public AppReportStudent() {
        ReportStudentView view = new ReportStudentView("ລາຍງານນັກສຶກສາ");
        controller = new ReportStudentController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
