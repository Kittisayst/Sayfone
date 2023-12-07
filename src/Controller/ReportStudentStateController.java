package Controller;

import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.GlobalDataModel;
import Tools.JoHookEvent;
import View.ReportStudentStateView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportStudentStateController implements JoMVC, ActionListener {

    private ReportStudentStateView view;

    public ReportStudentStateController(ReportStudentStateView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnSearch().addActionListener(this);
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

        } else if (event.isEvent(view.getBtnSearch())) {
            StudentService service = new StudentService();
            view.showStudent(service.getStudentByState(view.getState()));
        }
    }

}
