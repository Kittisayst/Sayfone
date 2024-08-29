package Controller;

import Component.DialogStudentCount;
import DAOSevervice.StudentService;
import Model.GlobalDataModel;
import Model.StudentCountModel;
import Model.StudentModel;
import Tools.JoHookEvent;
import View.ReportStudentStateView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReportStudentStateController implements JoMVC, ActionListener {

    private ReportStudentStateView view;
    private List<StudentModel> models;
    private StudentService service = new StudentService();

    public ReportStudentStateController(ReportStudentStateView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showYear();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnSearch().addActionListener(this);
        view.handelChart((e) -> showChart());
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtnSearch())) {
            models = service.getStudentByState(view.getState());
            view.showStudent(models);
        }
    }

    private void showChart() {
        List<StudentCountModel> countModels = service.getStudentCounts(view.getYearID());
        DialogStudentCount app = new DialogStudentCount(GlobalDataModel.rootView, true);
        app.showTable(countModels);
        app.showChart(countModels);
        app.setVisible(true);
        System.out.println(countModels);
    }

}
