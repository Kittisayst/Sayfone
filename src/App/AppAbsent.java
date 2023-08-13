package App;

import Controller.AbsentController;
import View.AbsentView;

public class AppAbsent {

    private AbsentView view;
    private AbsentController controller;

    public AppAbsent() {
        view = new AbsentView("ເລືອກຫ້ອງຮຽນ");
        controller = new AbsentController(view);
    }
    
    public void Open(){
        controller.Start();
        controller.AddEvent();
    }

}
