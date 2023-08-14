package DAOInterface;

import Model.SubjectModel;
import java.util.List;

public interface SubjectFn {

    public int CreaterSubject(SubjectModel model);

    public int UpdateSubject(SubjectModel model);

    public int DeleteSubject(int ID);

    public List<SubjectModel> getAll();

    public SubjectModel getSubjectById(int ID);
}
