package DAOSevervice;

import DAO.SubjectDAO;
import Model.SubjectModel;
import java.util.List;

public class SubjectService {

    SubjectDAO aO = new SubjectDAO();

    public int CreaterSubject(SubjectModel model) {
        return aO.CreaterSubject(model);
    }

    public int UpdateSubject(SubjectModel model) {
        return aO.UpdateSubject(model);
    }

    public int DeleteSubject(int ID) {
        return aO.DeleteSubject(ID);
    }

    public List<SubjectModel> getAll() {
        return aO.getAll();
    }

    public SubjectModel getSubjectById(int ID) {
        return aO.getSubjectById(ID);
    }

}
