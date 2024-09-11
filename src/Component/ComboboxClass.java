package Component;

import Components.JoCombobox;
import DAOSevervice.ClassService;
import Model.ClassModel;
import java.util.List;

public class ComboboxClass extends JoCombobox {

    public void showClass() {
        List<ClassModel> models = new ClassService().getAllClass();
        for (ClassModel model : models) {
            this.JoAddIntModel(model.getClassID(), model.getClassName());
        }
    }

    public int getClassID() {
        return this.getKeyInt();
    }
}
