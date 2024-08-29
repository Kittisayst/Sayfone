package Controller;

import DAOSevervice.StudentKnowService;
import Model.GlobalDataModel;
import View.ReportStudentKnowView;

public class ReportStudentKnowController implements JoMVC {

    private ReportStudentKnowView View;
    private StudentKnowService service = new StudentKnowService();

    public ReportStudentKnowController(ReportStudentKnowView View) {
        this.View = View;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(View);
        View.showChart(service.getCount());
    }

    @Override
    public void AddEvent() {
        View.handelBack((e) -> GlobalDataModel.rootView.showDashbord());
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

}
