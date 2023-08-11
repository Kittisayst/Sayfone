package App;

import Controller.TutorialController;
import Log.JoLoger;
import View.TutorialView;

public class AppTutorial {

    private TutorialView view;
    private TutorialController controller;

    public AppTutorial() {
        view = new TutorialView("ວິທີການໃຊ້ງານ");
        controller = new TutorialController(view);
    }

    public void OpentTutorail() {
        try {
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }

    }

}
