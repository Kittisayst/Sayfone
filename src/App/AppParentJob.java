package App;

import Controller.ParentJobController;
import View.ParentJobView;

public class AppParentJob {

    private ParentJobController controller;

    public AppParentJob() {
        ParentJobView view = new ParentJobView("ອາຊີບຜູ້ປົກຄອງ");
        controller = new ParentJobController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
