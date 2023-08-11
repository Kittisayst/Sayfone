package App;

import Controller.FinancialController;
import DAOSevervice.ClassService;
import Log.JoLoger;
import Model.ClassModel;
import Model.CreateRegisterModel;
import Model.StudentModel;
import Tools.JoAlert;
import View.FinancialView;

public class AppFinancial {

    public AppFinancial(CreateRegisterModel registerModel, StudentModel studentModel) {
        try {
            ClassModel classModel = new ClassService().getClassById(registerModel.getClassID());
            FinancialView view = new FinancialView(
                    "ຈ່າຍຄ່າຮຽນ: " + classModel.getClassName()
                    + "/" + studentModel.getFullName());
            FinancialController controller = new FinancialController(view, studentModel, registerModel);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
    }

}
