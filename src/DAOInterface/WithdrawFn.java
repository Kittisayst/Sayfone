package DAOInterface;

import Model.WithdrawModel;
import java.util.List;

public interface WithdrawFn {

    public int CreaterWithdraw(WithdrawModel model);

    public int UpdateWithdraw(WithdrawModel model);

    public int DeleteWithdraw(WithdrawModel model);

    public List<WithdrawModel> getWithdrawAll();

    public WithdrawModel getWithdrawById(int ID);

    public WithdrawModel getWithdrawByFinancailID(int FinancailID);
}
