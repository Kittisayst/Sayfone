package ResourceLoading;

import DAOSevervice.StudentService;
import Model.StudentModel;
import java.util.List;

public class StudentLoading {

    public List<StudentModel> createStudents() {
        return new StudentService().getAllStudent();
    }
}
