package App;

import Controller.StudentNkowController;
import DAOInterface.AppInterface;
import View.StudentNkowView;

public class AppStudentNkow implements AppInterface {

    StudentNkowController controller;

    public AppStudentNkow() {
        StudentNkowView view = new StudentNkowView("ຈັດການຂໍ້ມູນຊ່ອງທາງຮູ້ຈັກໂຮງຮຽນ");
        controller = new StudentNkowController(view);
    }

    @Override
    public void Open() {
        controller.Start();
        controller.AddEvent();
    }

}
