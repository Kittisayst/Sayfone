package Component;

import Components.JoCombobox;
import DAOSevervice.RegisterService;
import Model.RegisterModel;
import java.util.List;

public class ComboboxClassRoom extends JoCombobox {

    public void showClassRoom() {
        List<RegisterModel> models = new RegisterService().getRegisterAll();
        for (RegisterModel model : models) {
            this.JoAddIntModel(model.getRegisterID(), model.getClassRoomName());
        }
    }

    public void showClassRoomByYear_Class(int yearID,int ClassID) {
        List<RegisterModel> models = new RegisterService().getRegisterByYear_Class(yearID, ClassID);
        this.JoClearData();
        for (RegisterModel model : models) {
            this.JoAddIntModel(model.getRegisterID(), model.getClassRoomName());
        }
    }

    public int getRegisterID() {
        return this.getKeyInt();
    }
}
