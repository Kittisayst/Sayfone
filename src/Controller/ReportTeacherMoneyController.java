package Controller;

import DAOSevervice.TeacherMoneyService;
import DAOSevervice.TeacherService;
import Model.GlobalDataModel;
import Tools.JoHookEvent;
import View.ReportTeacherMoneyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportTeacherMoneyController implements JoMVC, ActionListener {

    private ReportTeacherMoneyView view;
    private TeacherMoneyService moneyService = new TeacherMoneyService();

    public ReportTeacherMoneyController(ReportTeacherMoneyView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showTeacher(new TeacherService().getAllTeacher());
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
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtnSearch())) {
            view.showMoney(moneyService.readAllTeacherID(view.getTeacherID()));
        }
    }

}
