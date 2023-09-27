package ResourceLoading;

import DAOSevervice.ClassService;
import Model.GlobalDataModel;

public class ClassLoading {

    public void createGlobalClass() {
        ClassService classService = new ClassService();
        GlobalDataModel.classModels = classService.getAllClass();
    }
}
