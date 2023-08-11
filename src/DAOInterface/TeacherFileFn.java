package DAOInterface;

import Model.TeacherFileModel;
import java.util.List;

public interface TeacherFileFn {

    public int CreaterTeacherFile(TeacherFileModel model);

    public int UpdateTeacherFile(TeacherFileModel model);

    public void UpdateImage(TeacherFileModel model);

    public int DeleteTeacherFile(TeacherFileModel model);

    public List<TeacherFileModel> getAllTeacherFileByTeacherID(int TeacherFileID);

    public TeacherFileModel getTeacherFileById(int TeacherFileID);

    public void CreatePDF(TeacherFileModel model);
}
