package DAOSevervice;

import DAO.TeacherRankDAO;
import Model.TeacherRankModel;
import java.util.List;

public class TeacherRankService {

    private TeacherRankDAO dAO = new TeacherRankDAO();

    public int CreaterTeacherRank(TeacherRankModel model) {
        return dAO.CreaterTeacherRank(model);
    }

    public int UpdateTeacherRank(TeacherRankModel model) {
        return dAO.UpdateTeacherRank(model);
    }

    public int DeleteTeacherRank(TeacherRankModel model) {
        return dAO.DeleteTeacherRank(model);
    }

    public List<TeacherRankModel> getAllTeacherRank() {
        return dAO.getAllTeacherRank();
    }

    public TeacherRankModel getTeacherRankById(int ID) {
        return dAO.getTeacherRankById(ID);
    }

    public TeacherRankModel getTeacherRankByTeacherId(int ID, int YearID) {
        return dAO.getTeacherRankByTeacherId(ID, YearID);
    }

}
