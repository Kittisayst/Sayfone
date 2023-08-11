
package DAOSevervice;

import DAO.StudentVacinceDAO;
import Model.StudentVacinceModel;
import java.util.List;


public class StudentVaccinceService {
    StudentVacinceDAO aO = new StudentVacinceDAO();

    public int CreaterStudentVacince(StudentVacinceModel model) {
        return aO.CreaterStudentVacince(model);
    }

    public int UpdateStudentVacince(StudentVacinceModel model) {
        return aO.UpdateStudentVacince(model);
    }

    public int DeleteStudentVacince(StudentVacinceModel model) {
        return aO.DeleteStudentVacince(model);
    }

    public List<StudentVacinceModel> getStudentVacinceAllByStudentID(int StudentID) {
        return aO.getStudentVacinceAllByStudentID(StudentID);
    }

    public StudentVacinceModel getStudentVacinceById(int StudentVacinceID) {
        return aO.getStudentVacinceById(StudentVacinceID);
    }
    
}
