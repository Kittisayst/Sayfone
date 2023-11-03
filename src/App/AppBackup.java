package App;

import Controller.BackupController;
import View.BackupView;

public class AppBackup {

    private BackupController controller;

    public AppBackup() {
        BackupView view = new BackupView("ສຳຮອງຂໍ້ມູນ");
        controller = new BackupController(view);
    }

    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
