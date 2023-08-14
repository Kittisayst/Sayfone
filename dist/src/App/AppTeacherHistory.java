package App;

import Controller.TeacherHistoryController;
import Model.TeacherHistoryModel;
import Model.TeacherModel;
import DAOSevervice.TeacherHistoryService;
import Log.JoLoger;
import View.TeacherHistoryView;

public class AppTeacherHistory {

    public AppTeacherHistory(TeacherModel model, int TapIndex) {
        try {
            TeacherHistoryView view = new TeacherHistoryView("ຂໍ້ມູນປະຫວັດ ( " + model.getFullName() + " )");
            TeacherHistoryService service = new TeacherHistoryService();
            TeacherHistoryModel historyModel = service.getTeacherHistoryByTeacherId(model.getTeacherID());
            TeacherHistoryController controller = new TeacherHistoryController(view, historyModel, model.getTeacherID(), TapIndex);
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
