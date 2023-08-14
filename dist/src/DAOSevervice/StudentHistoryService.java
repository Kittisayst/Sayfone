
package DAOSevervice;

import DAO.StudentHistoryDAO;
import Model.StudentHistoryModel;
import java.util.List;


public class StudentHistoryService {
    StudentHistoryDAO aO = new StudentHistoryDAO();

    public int CreaterStudentHistory(StudentHistoryModel model) {
        return aO.CreaterStudentHistory(model);
    }

    public int UpdateStudentHistory(StudentHistoryModel model) {
        return aO.UpdateStudentHistory(model);
    }

    public int DeleteStudentHistory(StudentHistoryModel model) {
        return aO.DeleteStudentHistory(model);
    }

    public List<StudentHistoryModel> getAllStudentHistory() {
        return aO.getAllStudentHistory();
    }

    public StudentHistoryModel getStudentHistoryByStudentID(int StudentHistoryID) {
        return aO.getStudentHistoryByStudentID(StudentHistoryID);
    }
    
}
