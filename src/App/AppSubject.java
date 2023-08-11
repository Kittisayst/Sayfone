package App;

import Controller.SubjectController;
import Log.JoLoger;
import Model.SubjectModel;
import View.SubjectView;

public class AppSubject {

    public AppSubject() {
        try {
            SubjectView view = new SubjectView("ຈັດຂໍ້ມູນການລາຍວິຊາ");
            SubjectModel model = new SubjectModel();
            SubjectController controller = new SubjectController(view, model);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
