package App;

import Controller.ReportParentJobController;
import View.ReportParentJobView;

public class AppReportParentJob {

    private final ReportParentJobController controller;

    public AppReportParentJob() {
        ReportParentJobView view = new ReportParentJobView("ລາຍງານອາຊີບຜູ້ປົກຄອງ");
        controller = new ReportParentJobController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
