package ResourceLoading;

import DAOSevervice.YearService;
import Model.YearModel;
import java.util.List;

public class YearLoading {

    public List<YearModel> createGlobalYear() {
        YearService service = new YearService();
        return service.getYearAll();
    }
}
