package App;

import Controller.TeacherController;
import DAOSevervice.TeacherService;
import Log.JoLoger;
import View.TeacherView;

public class AppTeacher {

    public AppTeacher() {
        try {
            TeacherView view = new TeacherView("ຂໍ້ມູນຄູສອນ");
            TeacherService teacherService = new TeacherService();
            TeacherController controller = new TeacherController(view, teacherService);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
