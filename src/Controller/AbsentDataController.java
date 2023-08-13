package Controller;

import App.AppAbsent;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import Model.CreateRegisterModel;
import Tools.JoHookEvent;
import View.AbsentDataView;
import View.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbsentDataController implements JoMVC, ActionListener {

    private AbsentDataView view;
    private CreateRegisterModel registerModel;

    public AbsentDataController(AbsentDataView view, CreateRegisterModel registerModel) {
        this.view = view;
        this.registerModel = registerModel;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showStudent(new FinancialService().getStudentRegistered(registerModel.getRegisterID()));
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
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
            AppAbsent absent = new AppAbsent();
            absent.Open();
        }
    }

}
