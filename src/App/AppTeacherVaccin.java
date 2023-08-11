package App;

import Controller.TeacherVaccinController;
import Log.JoLoger;
import Model.TeacherModel;
import View.TeacherVaccinView;

public class AppTeacherVaccin {

    public AppTeacherVaccin(TeacherModel model) {
        try {
            TeacherVaccinView view = new TeacherVaccinView("ຂໍ້ມູນການຮັບວັກຊີນ (" + model.getFullName() + ")");
            TeacherVaccinController controller = new TeacherVaccinController(view, model.getTeacherID());
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
