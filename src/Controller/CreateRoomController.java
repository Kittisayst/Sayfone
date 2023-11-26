package Controller;

import App.AppCreateRegister;
import App.AppDashboard;
import App.AppRegister;
import DAOSevervice.RegisterService;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Utility.MyPopup;
import View.CreateRoomView;
import View.DasboardView;
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
        GlobalDataModel.rootView.setView(view);
        view.showRegister(GlobalDataModel.registerModels);
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
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtn_Add())) {
            AppCreateRegister appRegisterData = new AppCreateRegister();
            appRegisterData.showRegisterData();
        } else if (event.isEvent(popup.getItemshow())) {
            System.out.println("show");
        } else if (event.isEvent(popup.getItemEdit())) {
            RegisterService registerService = new RegisterService();
            AppCreateRegister appRegisterData = new AppCreateRegister();
            appRegisterData.showRegisterData(registerService.getRegisterById(view.getRegisterID()));
        } else if (event.isEvent(popup.getItemDelete())) {
            JoAlert alert = new JoAlert();
            if (alert.JoSubmitDelete()) {
                RegisterService registerService = new RegisterService();
                registerService.Delete(view.getRegisterID());
                new AppDashboard().Open();
                AppRegister appRegister = new AppRegister();
                appRegister.OpenRegister();
            }
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
