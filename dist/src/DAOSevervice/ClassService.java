package DAOSevervice;

import DAO.ClassDAO;
import Model.ClassModel;
import java.util.List;

public class ClassService {

    ClassDAO classDAO = new ClassDAO();

    public void CreaterClass(ClassModel classModel) {
        classDAO.CreaterClass(classModel);
    }

    public void UpdateClass(ClassModel classModel) {
        classDAO.UpdateClass(classModel);
    }

    public void DeleteClass(ClassModel classModel) {
        classDAO.DeleteClass(classModel);
    }

    public List<ClassModel> getAllClass() {
        return classDAO.getAllClass();
    }

    public ClassModel getClassById(int ID) {
        return classDAO.getClassById(ID);
    }

}
