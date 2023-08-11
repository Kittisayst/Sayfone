package App;

import Controller.TeacherOutstandingController;
import Log.JoLoger;
import Model.TeacherModel;
import View.TeacherOutstandingView;

public class AppTeacherOutstanding {

    public AppTeacherOutstanding(TeacherModel model) {
        try {
            TeacherOutstandingView view = new TeacherOutstandingView("ຂໍ້ມູນຜົນງານພົ້ນເດັ່ນ (" + model.getFullName() + ")");
            TeacherOutstandingController controller = new TeacherOutstandingController(view, model.getTeacherID());
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
