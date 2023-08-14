package DAOSevervice;

import DAO.NationalityDAO;
import Model.NationalityModel;
import java.util.List;

public class NationalityService {

    NationalityDAO nationalityDAO = new NationalityDAO();

    public void CreaterNationality(NationalityModel model) {
        nationalityDAO.CreaterNationality(model);
    }

    public void UpdateNationality(NationalityModel model) {
        nationalityDAO.UpdateNationality(model);
    }

    public void DeleteNationality(NationalityModel model) {
        nationalityDAO.DeleteNationality(model);
    }

    public List<NationalityModel> getAllNationality() {
        return nationalityDAO.getAllNationality();
    }

    public NationalityModel getNationalityById(int NationalityID) {
        return nationalityDAO.getNationalityById(NationalityID);
    }

}
