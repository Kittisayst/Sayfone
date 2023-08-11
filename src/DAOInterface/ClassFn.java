package DAOInterface;

import Model.ClassModel;
import java.util.List;

public interface ClassFn {

    public int CreaterClass(ClassModel classModel);

    public int UpdateClass(ClassModel classModel);

    public int DeleteClass(ClassModel classModel);

    public List<ClassModel> getAllClass();

    public ClassModel getClassById(int ClassID);
  
}
