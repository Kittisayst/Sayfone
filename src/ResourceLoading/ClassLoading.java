package ResourceLoading;

import DAOSevervice.ClassService;
import Model.ClassModel;
import java.util.List;

public class ClassLoading {

    public List<ClassModel> createGlobalClass() {
        ClassService classService = new ClassService();
        return classService.getAllClass();
    }
}
