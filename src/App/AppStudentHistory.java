package App;

import Controller.StudentHistoryController;
import Model.StudentHistoryModel;
import Model.StudentModel;
import DAOSevervice.StudentHistoryService;
import DAOSevervice.StudentService;
import Log.JoLoger;
import View.StudentHistoryView;

public class AppStudentHistory {

    public AppStudentHistory(int StudentID, int TapIndex) {
        try {
            StudentService service = new StudentService();
            StudentModel studentModel = service.getStudentById(StudentID);
            StudentHistoryModel model = new StudentHistoryService().getStudentHistoryByStudentID(StudentID);
            StudentHistoryView view = new StudentHistoryView("ປະຫວັດນັກຮຽນ (" + studentModel.getFullName() + ")");
            StudentHistoryController controller = new StudentHistoryController(view, model, StudentID, TapIndex);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
