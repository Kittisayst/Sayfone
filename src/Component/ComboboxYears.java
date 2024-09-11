package Component;

import Components.JoCombobox;
import DAOSevervice.YearService;
import Model.YearModel;
import java.util.List;

public class ComboboxYears extends JoCombobox {

    public void showYears() {
        List<YearModel> models = new YearService().getYearAll();
        for (YearModel model : models) {
            this.JoAddIntModel(model.getYearID(), model.getYear());
        }
    }

    public int getYearID() {
        return this.getKeyInt();
    }
}
