package DAOSevervice;

import DAO.WithdrawDAO;
import Model.WithdrawModel;
import java.util.List;

public class WithdrawService {

    private WithdrawDAO aO = new WithdrawDAO();

    public int CreaterWithdraw(WithdrawModel model) {
        return aO.CreaterWithdraw(model);
    }

    public int UpdateWithdraw(WithdrawModel model) {
        return aO.UpdateWithdraw(model);
    }

    public int DeleteWithdraw(WithdrawModel model) {
        return aO.DeleteWithdraw(model);
    }

    public List<WithdrawModel> getWithdrawAll() {
        return aO.getWithdrawAll();
    }

    public WithdrawModel getWithdrawById(int ID) {
        return aO.getWithdrawById(ID);
    }

    public WithdrawModel getWithdrawByFinancailID(int FinancailID) {
        return aO.getWithdrawByFinancailID(FinancailID);
    }

}
