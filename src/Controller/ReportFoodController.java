package Controller;

import App.AppDashboard;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.YearService;
import Tools.JoHookEvent;
import View.HomeView;
import View.ReportFoodView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ReportFoodController implements JoMVC, ActionListener, ItemListener {

    private ReportFoodView view;

    public ReportFoodController(ReportFoodView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showYear(new YearService().getYearAll());
        showClassRoom();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getCbYear().addItemListener(this);
        view.getBtnShow().addActionListener(this);
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
            AppDashboard ad = new AppDashboard();
        } else if (event.isEvent(view.getBtnShow())) {
            FinancialService service = new FinancialService();
            int registerID = view.getCbClassRoom().getKeyInt();
            view.showFood(service.getStudentRegistered(registerID));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getCbYear())) {
            showClassRoom();
        }
    }

    private void showClassRoom() {
        RegisterService registerService = new RegisterService();
        int yearD = view.getCbYear().getKeyInt();
        view.showClassRoom(registerService.getRegisterAllByYearID(yearD));
    }

}
