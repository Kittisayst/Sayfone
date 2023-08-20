package App;

import Controller.FinancailStudentController;
import DAOSevervice.ClassService;
import Log.JoLoger;
import Model.ClassModel;
import Model.RegisterModel;
import View.FinancailStudentView;

public class AppFinancailStudent {

    public AppFinancailStudent(RegisterModel registerModel) {
        try {
            ClassModel classModel = new ClassService().getClassById(registerModel.getClassID());
            FinancailStudentView view = new FinancailStudentView("ລົງທະບຽນນັກສຶກສາ: " + classModel.getClassName());
            FinancailStudentController controller = new FinancailStudentController(view, registerModel);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
