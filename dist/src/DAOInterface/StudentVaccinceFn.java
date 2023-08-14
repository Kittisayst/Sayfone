package DAOInterface;

import Model.StudentVacinceModel;
import java.util.List;

public interface StudentVaccinceFn {

    public int CreaterStudentVacince(StudentVacinceModel model);

    public int UpdateStudentVacince(StudentVacinceModel model);

    public int DeleteStudentVacince(StudentVacinceModel model);

    public List<StudentVacinceModel> getStudentVacinceAllByStudentID(int StudentID);

    public StudentVacinceModel getStudentVacinceById(int StudentVacinceID);
}
