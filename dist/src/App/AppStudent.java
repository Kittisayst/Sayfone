package App;

import Controller.StudentController;
import Log.JoLoger;
import View.StudentView;

public class AppStudent {

    public AppStudent() {
        try {
            StudentView view = new StudentView("ຂໍ້ມູນນັກຮຽນ");
            StudentController controller = new StudentController(view);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
