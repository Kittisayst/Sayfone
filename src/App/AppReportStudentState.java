package App;

import Controller.ReportStudentStateController;
import View.ReportStudentStateView;

public class AppReportStudentState {

    private ReportStudentStateController controller;

    public AppReportStudentState() {
        ReportStudentStateView view = new ReportStudentStateView("ລາຍງານຂໍ້ມູນນັກຮຽນທັງໝົດ");
        controller = new ReportStudentStateController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
