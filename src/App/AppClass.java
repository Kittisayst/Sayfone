package App;

import Controller.ClassController;
import View.ClassView;

public class AppClass {

    private final ClassController controller;

    public AppClass() {
        ClassView view = new ClassView("ຂໍ້ມູນຂະແໜງ");
        controller = new ClassController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
