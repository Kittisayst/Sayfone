package DAOSevervice;

import DAO.SayfoneDao;
import Model.SayfoneModel;
import java.util.List;

public class SayfoneService {

    private SayfoneDao dao = new SayfoneDao();

    public int Creater(SayfoneModel model) {
        return dao.Creater(model);
    }

    public int Update(SayfoneModel model) {
        return dao.Update(model);
    }

    public int Delete(SayfoneModel model) {
        return dao.Delete(model);
    }

    public List<SayfoneModel> getAll() {
        return dao.getAll();
    }

    public SayfoneModel getById(int ID) {
        return dao.getById(ID);
    }

    public int updateStudentNkow(String value) {
        return dao.updateStudentNkow(value);
    }

}
