package DAOSevervice;

import DAO.EthnicDAO;
import Model.EthnicModel;
import java.util.List;

public class EthnicService {

    EthnicDAO ethnicDAO = new EthnicDAO();

    public void CreaterEthnic(EthnicModel model) {
        ethnicDAO.CreaterEthnic(model);
    }

    public void UpdateEthnic(EthnicModel model) {
        ethnicDAO.UpdateEthnic(model);
    }

    public void DeleteEthnic(EthnicModel model) {
        ethnicDAO.DeleteEthnic(model);
    }

    public List<EthnicModel> getAllEthnic() {
        return ethnicDAO.getAllEthnic();
    }

    public EthnicModel getEthnicById(int ID) {
        return ethnicDAO.getEthnicById(ID);
    }

}
