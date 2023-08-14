package DAOInterface;

import Model.EthnicModel;
import java.util.List;

public interface EthnicFn {

    public int CreaterEthnic(EthnicModel model);

    public int UpdateEthnic(EthnicModel model);

    public int DeleteEthnic(EthnicModel model);

    public List<EthnicModel> getAllEthnic();

    public EthnicModel getEthnicById(int ID);
}
