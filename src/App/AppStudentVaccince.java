package App;

import Controller.StudentVaccinceController;
import Log.JoLoger;
import Model.StudentModel;
import View.StudentVaccinView;

public class AppStudentVaccince {

    public AppStudentVaccince(StudentModel model) {
        try {
            StudentVaccinView view = new StudentVaccinView("ຂໍ້ມູນການຮັບວັກຊີນ (" + model.getFullName() + ")");
            StudentVaccinceController controller = new StudentVaccinceController(view, model.getStudentID());
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
