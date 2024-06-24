package Component;

import Components.JoCombobox;
import DAOSevervice.YearService;
import Model.YearModel;
import java.util.List;

public class comboboxYear extends JoCombobox {

    public void showYears() {
        List<YearModel> yearModels = new YearService().getYearAll();
        this.JoClearData();
        yearModels.forEach(year -> {
            this.JoAddIntModel(year.getYearID(), year.getYear());
        });
    }

}
