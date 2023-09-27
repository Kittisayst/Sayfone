package ResourceLoading;

import DAOSevervice.YearService;
import Model.GlobalDataModel;

public class YearLoading {

    public void createGlobalYear() {
        YearService service = new YearService();
        GlobalDataModel.yearModels = service.getYearAll();
    }
}
