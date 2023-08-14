package Controller;

import App.AppDashboard;
import DAOSevervice.SayfoneService;
import Model.SayfoneModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import View.HomeView;
import View.SettingView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SayfoneController implements JoMVC, ActionListener {

    private SettingView view;
    private SayfoneModel model;

    public SayfoneController(SettingView view, SayfoneModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showSetting(model);
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnSave().addActionListener(this);
        view.getBtnCancel().addActionListener(this);
    }

    @Override
    public void Create() {

    }

    @Override
    public void Update() {
        SayfoneService service = new SayfoneService();
        SayfoneModel data = view.getSayfone();
        data.setId(model.getId());
        JoAlert alert = new JoAlert();
        alert.JoSubmit(service.Update(data), JoAlert.UPDATE);
    }

    @Override
    public void Delete() {

    }

    @Override
    public boolean emptyData() {
        return view.isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppDashboard ad = new AppDashboard();
        } else if (event.isEvent(view.getBtnSave())) {
            if (emptyData()) {
                Update();
            }
        }else if (event.isEvent(view.getBtnCancel())) {
            AppDashboard ad = new AppDashboard();
        }
    }

}
