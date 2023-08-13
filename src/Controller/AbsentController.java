package Controller;

import App.AppAbsentData;
import App.AppDashboard;
import DAOSevervice.RegisterService;
import DAOSevervice.YearService;
import Model.CreateRegisterModel;
import Tools.JoHookEvent;
import View.AbsentView;
import View.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AbsentController implements JoMVC, ActionListener, MouseListener {

    private final AbsentView view;

    public AbsentController(AbsentView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showClassRoom(new RegisterService().getRegisterAll());
        view.showYear(new YearService().getYearAll());
    }

    @Override
    public void AddEvent() {
        view.getBtn_Add().addActionListener(this);
        view.getBtn_back().addActionListener(this);
        view.getTb_data().addMouseListener(this);
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
            AppDashboard dashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtn_Add())) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            int registerID = view.getTb_data().getIntValue(1);
            CreateRegisterModel registerModel = new RegisterService().getRegisterById(registerID);
            AppAbsentData absentData = new AppAbsentData(registerModel);
            absentData.Open();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
