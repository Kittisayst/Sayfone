package App;

import Controller.WithdrawController;
import Model.WithdrawModel;
import View.WithDrawView;

public class AppWithdraw {

    private final WithdrawController controller;

    public AppWithdraw() {
        WithDrawView view = new WithDrawView("ລາຍງານການຖອນເງິນຄືນ");
        WithdrawModel model = new WithdrawModel();
        controller = new WithdrawController(view, model);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
