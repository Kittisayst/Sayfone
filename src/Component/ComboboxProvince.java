package Component;

import Components.JoCombobox;
import DAOSevervice.ProvinceService;
import Model.ProvinceModel;
import java.util.List;

public class ComboboxProvince extends JoCombobox {

    public void showProvinces() {
        List<ProvinceModel> models = new ProvinceService().getAllProvince();
        this.JoClearData();
        for (ProvinceModel model : models) {
            this.JoAddIntModel(model.getProvinceID(), model.getProvinceName());
        }
    }

    public int getProvinceID() {
        return getKeyInt();
    }
}
