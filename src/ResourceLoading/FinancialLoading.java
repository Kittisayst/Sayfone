package ResourceLoading;

import DAOSevervice.FinancialService;
import Model.FinancialModel;
import java.util.List;

public class FinancialLoading {

    public List<FinancialModel> createFinancial() {
        FinancialService service = new FinancialService();
        return service.getFinancialAll();
    }
}
