package DAOSevervice;

import DAO.TeacherHistoryDAO;
import Model.TeacherHistoryModel;
import java.util.List;

public class TeacherHistoryService {

    private final TeacherHistoryDAO aO = new TeacherHistoryDAO();

    public int CreaterTeacherHistory(TeacherHistoryModel model) {
        return aO.CreaterTeacherHistory(model);
    }

    public int UpdateTeacherHistory(TeacherHistoryModel model) {
        return aO.UpdateTeacherHistory(model);
    }

    public int DeleteTeacherHistory(TeacherHistoryModel model) {
        return aO.DeleteTeacherHistory(model);
    }

    public List<TeacherHistoryModel> getAllTeacherHistory() {
        return aO.getAllTeacherHistory();
    }

    public TeacherHistoryModel getTeacherHistoryById(int TeacherHistoryID) {
        return aO.getTeacherHistoryById(TeacherHistoryID);
    }

    public TeacherHistoryModel getTeacherHistoryByTeacherId(int TeacherID) {
        return aO.getTeacherHistoryByTeacherId(TeacherID);
    }

}
