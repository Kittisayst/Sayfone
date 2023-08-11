package DAOInterface;

import Model.OutstandingCatModel;
import java.util.List;

public interface OutStandingCatFn {

    public int Creater(OutstandingCatModel model);

    public int Update(OutstandingCatModel model);

    public int Delete(OutstandingCatModel model);

    public List<OutstandingCatModel> getAllOutstanding();

    public OutstandingCatModel getOutstandingById(int OutstandingID);
}
