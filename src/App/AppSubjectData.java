package App;

import Controller.SubjectDataController;
import Log.JoLoger;
import Model.SubjectModel;
import View.SubjectDataView;

public class AppSubjectData {

    public AppSubjectData(SubjectModel model) {
        try {
            SubjectDataView view = new SubjectDataView("ຈັດການຂໍ້ມູນລາຍວິຊາ");
            SubjectDataController controller = new SubjectDataController(view, model);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
