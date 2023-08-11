package App;

import Controller.StudentDataController;
import Model.StudentModel;
import DAOSevervice.StudentService;
import Log.JoLoger;
import View.StudentDataView;

public class AppStudentData {

    public AppStudentData() {
        try {
            StudentModel model = new StudentModel();
            StudentDataView view = new StudentDataView("ເພີ່ມນັກຮຽນໃໝ່");
            StudentDataController controller = new StudentDataController(model, view);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

    public AppStudentData(int StudentID) {
        try {
            StudentModel model = new StudentService().getStudentById(StudentID);
            StudentDataView view = new StudentDataView("ຂໍ້ມູນນັກຮຽນ (" + model.getFullName() + ")");
            StudentDataController controller = new StudentDataController(model, view);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
