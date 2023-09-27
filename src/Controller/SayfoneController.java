package Controller;

import DAOSevervice.SayfoneService;
import Model.GlobalDataModel;
import Model.SayfoneModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import View.SayfoneView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SayfoneController implements JoMVC, ActionListener {

    private SayfoneView view;
    private SayfoneModel model;

    public SayfoneController(SayfoneView view, SayfoneModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
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
           GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtnSave())) {
            if (emptyData()) {
                Update();
            }
        } else if (event.isEvent(view.getBtnCancel())) {
           GlobalDataModel.rootView.showDashbord();
        }
    }

}
