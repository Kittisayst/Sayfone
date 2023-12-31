package App;

import Controller.DasboardController;
import Controller.StudentDataController;
import Model.StudentModel;
import DAOSevervice.StudentService;
import Log.JoLoger;
import Model.GlobalDataModel;
import View.DasboardView;
import View.StudentDataView;

public class AppStudentData {

    public AppStudentData() {
        try {
            StudentModel model = new StudentModel();
            StudentDataView view = new StudentDataView("ເພີ່ມນັກຮຽນໃໝ່");
            StudentDataController controller = new StudentDataController(model, view);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

    public AppStudentData(int StudentID) {
        DasboardView dasboardView = new DasboardView();
        GlobalDataModel.dasboardView = dasboardView;
        DasboardController dasboardController = new DasboardController(dasboardView);
        dasboardController.UpdateView();
        try {
            StudentModel model = new StudentService().getStudentById(StudentID);
            StudentDataView view = new StudentDataView("ຂໍ້ມູນນັກຮຽນ (" + model.getFullName() + ")");
            StudentDataController controller = new StudentDataController(model, view);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
