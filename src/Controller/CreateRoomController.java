package Controller;

import App.AppDashboard;
import App.AppCreateRegister;
import DAOSevervice.RegisterService;
import Model.RegisterModel;
import Tools.JoHookEvent;
import Utility.MyPopup;
import View.CreateRoomView;
import View.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreateRoomController implements JoMVC, ActionListener, MouseListener {

    private final CreateRoomView view;
    private final RegisterModel model;
    private MyPopup popup;

    public CreateRoomController(CreateRoomView view, RegisterModel model) {
        this.view = view;
        this.model = model;
        popup = new MyPopup();
        popup.getItemshow().setEnabled(false);
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showRegister(new RegisterService().getRegisterAll());
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_Add().addActionListener(this);
        view.getTb_data().addMouseListener(this);
        popup.addActionListener(this);
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
            AppDashboard appDashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtn_Add())) {
            AppCreateRegister appRegisterData = new AppCreateRegister();
            appRegisterData.showRegisterData();
        } else if (event.isEvent(popup.getItemshow())) {
            System.out.println("show");
        } else if (event.isEvent(popup.getItemEdit())) {
            RegisterService registerService = new RegisterService();
            AppCreateRegister appRegisterData = new AppCreateRegister();
            appRegisterData.showRegisterData(registerService.getRegisterById(view.getTb_data().getIntValue(1)));
        } else if (event.isEvent(popup.getItemDelete())) {
            System.out.println("delete");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                RegisterService registerService = new RegisterService();
                AppCreateRegister appRegisterData = new AppCreateRegister();
                appRegisterData.showRegisterData(registerService.getRegisterById(view.getTb_data().getIntValue(1)));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            popup.ShowPopup(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
