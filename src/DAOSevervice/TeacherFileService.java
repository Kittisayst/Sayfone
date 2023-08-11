
package DAOSevervice;

import DAO.TeacherFileDAO;
import Model.TeacherFileModel;
import java.util.List;


public class TeacherFileService {
    TeacherFileDAO aO = new TeacherFileDAO();

    public int CreaterTeacherFile(TeacherFileModel model) {
        return aO.CreaterTeacherFile(model);
    }

    public int UpdateTeacherFile(TeacherFileModel model) {
        return aO.UpdateTeacherFile(model);
    }

    public void UpdateImage(TeacherFileModel model) {
        aO.UpdateImage(model);
    }

    public int DeleteTeacherFile(TeacherFileModel model) {
        return aO.DeleteTeacherFile(model);
    }

    public List<TeacherFileModel> getAllTeacherFileByTeacherID(int TeacherFileID) {
        return aO.getAllTeacherFileByTeacherID(TeacherFileID);
    }

    public TeacherFileModel getTeacherFileById(int TeacherFileID) {
        return aO.getTeacherFileById(TeacherFileID);
    }

    public void CreatePDF(TeacherFileModel model) {
        aO.CreatePDF(model);
    }
    
}
