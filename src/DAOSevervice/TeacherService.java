package DAOSevervice;

import DAO.TeacherDAO;
import Model.TeacherModel;
import java.util.List;

public class TeacherService {

    private final TeacherDAO teacherDAO = new TeacherDAO();

    public int CreateTeacher(TeacherModel model) {
        return teacherDAO.CreateTeacher(model);
    }

    public int UpdateTeacher(TeacherModel teacherModel) {
        return teacherDAO.UpdateTeacher(teacherModel);
    }

    public int DeleteTeacher(TeacherModel teacherModel) {
        return teacherDAO.DeleteTeacher(teacherModel);
    }

    public TeacherModel getTeacherById(int teacherID) {
        return teacherDAO.getTeacherById(teacherID);
    }

    public List<TeacherModel> getAllTeacher() {
        return teacherDAO.getAllTeacher();
    }

    public int getLastTeacherID() {
        return teacherDAO.getLastTeacherID();
    }

    public int getGenderCount() {
        return teacherDAO.getGenderCount();
    }

    public int getTeacherCount() {
        return teacherDAO.getTeacherCount();
    }

}
