package App;

import Controller.TeacherDataController;
import Log.JoLoger;
import Model.TeacherModel;
import View.TeacherDataView;

public class AppTeacherData {

    public AppTeacherData() {
        try {
            TeacherModel model = new TeacherModel();
            TeacherDataView view = new TeacherDataView("ຂໍ້ມູນອາຈານສອນ");
            TeacherDataController controller = new TeacherDataController(view, model);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

    public AppTeacherData(TeacherModel model) {
        try {
            TeacherDataView view = new TeacherDataView("ຂໍ້ມູນອາຈານສອນ");
            TeacherDataController controller = new TeacherDataController(view, model);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
