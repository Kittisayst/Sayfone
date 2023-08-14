package App;

import Controller.TeacherRankController;
import Log.JoLoger;
import Model.TeacherRankModel;
import View.TeacherRinkView;

public class AppTeacherRank {

    public AppTeacherRank() {
        try {
            TeacherRinkView view = new TeacherRinkView("ຈັດອັນດັບຜົນງານຄູສອນ");
            TeacherRankModel model = new TeacherRankModel();
            TeacherRankController controller = new TeacherRankController(model, view);
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
