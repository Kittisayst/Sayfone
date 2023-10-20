package DAOInterface;

import Model.TeacherRankModel;
import java.util.List;

public interface TeacherRankFn {

    public int CreaterTeacherRank(TeacherRankModel model);

    public int UpdateTeacherRank(TeacherRankModel model);

    public int DeleteTeacherRank(TeacherRankModel model);

    public List<TeacherRankModel> getAllTeacherRank();

    public TeacherRankModel getTeacherRankById(int ID);

    public TeacherRankModel getTeacherRankByTeacherId(int TearcherID, int YearID, int Month);

    public int getMoney(int TeacherID);
}
