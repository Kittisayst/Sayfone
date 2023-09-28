package Controller;

import DAOSevervice.PermissionService;
import DAOSevervice.UserService;
import Model.GlobalDataModel;
import Model.PermissionModel;
import Model.UserModel;
import Tools.JoHookEvent;
import View.PermissionActiveView;
import View.PermissionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PermissionController implements JoMVC, ActionListener, MouseListener {

    private PermissionView view;
    private PermissionModel model;
    private PermissionService service = new PermissionService();
    private UserService userService;

    public PermissionController(PermissionView view, PermissionModel model) {
        this.view = view;
        this.model = model;
        userService = new UserService();
    }

    @Override
    public void Start() {
        view.showUser(userService.getUserAll());
    }

    @Override
    public void AddEvent() {
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
            GlobalDataModel.rootView.showDashbord();
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
                UserModel userModel = userService.getUserById(view.getID());
                PermissionActiveView activeView = new PermissionActiveView("ເລືອກສິດທິຜູ້ໃຊ້ງານ", view, userModel);
                GlobalDataModel.rootView.setView(activeView);
            }
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
