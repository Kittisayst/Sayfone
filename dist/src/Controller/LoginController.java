package Controller;

import App.About;
import App.AppHome;
import Model.UserModel;
import DAOSevervice.UserService;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoDateTime;
import Tools.JoHookEvent;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import theme.MyColor;

public class LoginController implements JoMVC, ActionListener, KeyListener {

    private final UserService service;
    private final LoginView view;

    public LoginController(UserService service, LoginView view) {
        this.service = service;
        this.view = view;
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
        view.setVisible(true);
        view.ShowVersion(new About().getVersion());
    }

    @Override
    public final void AddEvent() {
        view.getBtn_login().addActionListener(this);
        view.getTxt_password().addKeyListener(this);
    }

    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean emptyData() {
        return view.getTxt_user().TextEmpty() && view.getTxt_password().TextEmpty();
    }

    private void Login() {
        if (emptyData()) {
            String user, password;
            user = view.getTxt_user().getText();
            password = view.getTxt_password().getText();
            UserModel model = service.UserLogin(user, password);
            if (model.getUserID() != 0) {
                GlobalDataModel.globalUsermodel = model;
                model.setUserLog(new JoDateTime().getTimeNow());
                model.setDate(new JoDateTime().getParseDate(new Date()));
                service.UpdateUserLogTime(model);
                AppHome home = new AppHome(model);
                view.setVisible(false);
            } else {
                JoAlert alert = new JoAlert();
                alert.setTitleColor(MyColor.Danger);
                alert.messages("ຊື່ຜູ້ໃຊ້ງານ ຫຼື ລະຫັດຜ່ານບໍ່ຖືກຕ້ອງ", "ກວດສອບຂໍ້ມູນ ແລະ ລອງເຂົ້າສູ່ລະບົບອີກຄັ້ງ!", JoAlert.Icons.info);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_login())) {
            Login();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTxt_password())) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Login();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
