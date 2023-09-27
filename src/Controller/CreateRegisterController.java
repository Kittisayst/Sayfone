package Controller;

import App.AppRegister;
import DAOSevervice.RegisterService;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import View.CreateRegisterView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CreateRegisterController implements JoMVC, ActionListener, KeyListener {

    private CreateRegisterView view;
    private RegisterModel model;

    public CreateRegisterController(CreateRegisterView view, RegisterModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showYear(GlobalDataModel.yearModels);
        view.showClass(GlobalDataModel.classModels);
        if (model.getRegisterID() != 0) {
            view.showRegister(model);
        }
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_Save().addActionListener(this);
    }

    @Override
    public void Create() {
        if (emptyData()) {
            model = new RegisterModel(0,
                    view.getTxt_ClassRoomName().getText(),
                    view.getCb_Year().getKeyInt(),
                    view.getCb_Class().getKeyInt(),
                    view.getDt_Date().getSQLDate());
            JoAlert alert = new JoAlert();
            RegisterService registerService = new RegisterService();
            boolean isRgisterData = registerService.getRegisterAll().contains(model);
            if (isRgisterData) {
                alert.messages("ເປີດລົງທະບຽນ", "ຫ້ອງນີ້ໄດ້ເປີດລົງທະບຽນແລ້ວ", JoAlert.Icons.warning);
            } else {
                boolean respon = alert.JoSubmit(new RegisterService().Creater(model), JoAlert.INSERT);
                if (respon) {
                    AppRegister appRegister = new AppRegister();
                    appRegister.OpenRegister();
                }
            }
        }
    }

    @Override
    public void Update() {
        if (emptyData()) {
            model = new RegisterModel(model.getRegisterID(),
                    view.getTxt_ClassRoomName().getText(),
                    view.getCb_Year().getKeyInt(),
                    view.getCb_Class().getKeyInt(),
                    view.getDt_Date().getSQLDate());
            JoAlert alert = new JoAlert();
            RegisterService registerService = new RegisterService();
            alert.JoSubmit(registerService.Update(model), JoAlert.UPDATE);
            AppRegister appRegister = new AppRegister();
            appRegister.OpenRegister();
        }
    }

    @Override
    public void Delete() {
       
    }

    @Override
    public boolean emptyData() {
        return view.getDt_Date().DateEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppRegister appRegister = new AppRegister();
            appRegister.OpenRegister();
        } else if (event.isEvent(view.getBtn_Save())) {
            if (model.getRegisterID() == 0) {
                Create();
            } else {
                Update();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
     
    }

}
