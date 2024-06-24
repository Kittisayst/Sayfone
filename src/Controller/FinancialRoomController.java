package Controller;

import App.AppFinancailStudent;
import DAOSevervice.RegisterService;
import Model.GlobalDataModel;
import Tools.JoHookEvent;
import View.FinancialRoomView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FinancialRoomController implements JoMVC, ActionListener, MouseListener {

    private FinancialRoomView view;

    public FinancialRoomController(FinancialRoomView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        GlobalDataModel.TableStudentRegistered = null;
        view.showRegister(GlobalDataModel.registerModels);
        view.showYears();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getTb_data().addMouseListener(this);
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
        }else if (event.isEvent(view.getBtnSearch())) {
            view.showRegister(new RegisterService().getRegisterAllByYearID(view.getYearID()));
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
            RegisterService registerService = new RegisterService();
            AppFinancailStudent appStudentRegister = new AppFinancailStudent(registerService.getRegisterById(registerID));
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
