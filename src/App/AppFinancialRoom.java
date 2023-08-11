package App;

import Controller.FinancialRoomController;
import Log.JoLoger;
import View.FinancialRoomView;

public class AppFinancialRoom {
    
    private FinancialRoomController controller;
    
    public AppFinancialRoom() {
        FinancialRoomView view = new FinancialRoomView("ເລືອກຫ້ອງຮຽນ ຈ່າຍຄ່າຮຽນ");
        controller = new FinancialRoomController(view);
    }
    
    public void open() {
        try {
            controller.Start();
            controller.AddEvent();
        } catch (Exception e) {
            JoLoger.saveLog(e, this);
        }
        
    }
    
}
