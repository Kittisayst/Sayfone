package Controller;

import DAOSevervice.ParentJobService;
import Model.GlobalDataModel;
import View.ParentJobView;

public class ParentJobController implements JoMVC {

    private ParentJobView view;
    private ParentJobService service;

    public ParentJobController(ParentJobView view) {
        this.view = view;
        service = new ParentJobService();
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showList(service.getJobs());
    }

    @Override
    public void AddEvent() {
        view.handelBack((e) -> back());
        view.handelAdd((e) -> addParentJob());
    }

    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean emptyData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void back() {
        GlobalDataModel.rootView.showDashbord();
    }

    private void addParentJob() {
        System.out.println(view.isText());
          if (view.isText()) {
            view.addList(view.getText());
            service.update(view.getData());
        }
    }

}
