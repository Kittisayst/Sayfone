package Controller;

import App.AppDashboard;
import App.AppHome;
import App.AppUser;
import Component.DialogUser;
import DAOSevervice.UserService;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Utility.MyPopup;
import View.HomeView;
import View.UserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserController implements JoMVC, ActionListener, MouseListener {

    private UserView view;
    private UserModel Model;
    private MyPopup popup = new MyPopup();
    private DialogUser dialogUser;

    public UserController(UserView view, UserModel Model) {
        this.view = view;
        this.Model = Model;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showUser(new UserService().getUserAll());
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

    }

    @Override
    public void Update() {

    }

    @Override
    public void Delete() {

    }

    @Override
    public boolean emptyData() {
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            new AppDashboard();
        } else if (event.isEvent(view.getBtn_Add())) {
            dialogUser = new DialogUser(AppHome.viewParent, true, Model);
            dialogUser.setVisible(true);
        } else if (event.isEvent(popup.getItemshow())) {

        } else if (event.isEvent(popup.getItemEdit())) {
            int userID = view.getTb_data().getIntValue(1);
            UserService service = new UserService();
            Model = service.getUserById(userID);
            if (Model.getUserID() != 0) {
                dialogUser = new DialogUser(AppHome.viewParent, true, Model);
                dialogUser.setVisible(true);
            }
        } else if (event.isEvent(popup.getItemDelete())) {
            JoAlert alert = new JoAlert();
            if (alert.JoSubmitDelete()) {
                int userID = view.getTb_data().getIntValue(1);
                UserService service = new UserService();
                Model = service.getUserById(userID);
                service.DeleteUser(Model);
                new AppUser().Open();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
