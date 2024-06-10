package ResourceLoading;

import DAOSevervice.SettingSevice;
import Model.SettingModel;

public class SettingPaymentLoading {
    public SettingModel getSettingModel(){
        SettingSevice sevice = new SettingSevice();
        return sevice.read(1);
    }
}
