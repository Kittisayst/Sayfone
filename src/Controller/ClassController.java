package Controller;

import App.AppClass;
import App.AppDashboard;
import App.AppHome;
import Component.DialogClass;
import DAOSevervice.ClassService;
import DAOSevervice.RegisterService;
import Model.ClassModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Utility.MyPopup;
import View.ClassView;
import View.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClassController implements JoMVC, ActionListener, MouseListener {

    private ClassView view;
    private MyPopup popup;

    public ClassController(ClassView view) {
        this.view = view;
        popup = new MyPopup();
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showClass(new ClassService().getAllClass());
    }

    @Override
    public void AddEvent() {
        view.getBtn_Add().addActionListener(this);
        view.getBtn_back().addActionListener(this);
        popup.addActionListener(this);
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
        if (event.isEvent(view.getBtn_Add())) {
            DialogClass dc = new DialogClass(AppHome.viewParent, true, new ClassModel());
            dc.setVisible(true);
        } else if (event.isEvent(view.getBtn_back())) {
            AppDashboard dashboard = new AppDashboard();
        } else if (event.isEvent(popup.getItemshow())) {

        } else if (event.isEvent(popup.getItemEdit())) {
            int ID = view.getTb_data().getIntValue(1);
            DialogClass dc = new DialogClass(AppHome.viewParent, true, new ClassService().getClassById(ID));
            dc.setVisible(true);
        } else if (event.isEvent(popup.getItemDelete())) {
            int ID = view.getTb_data().getIntValue(1);
            ClassService classService = new ClassService();
            JoAlert alert = new JoAlert();
            if (alert.JoSubmitDelete()) {
                RegisterService registerService = new RegisterService();
                ClassModel classModel = classService.getClassById(ID);
                if (registerService.getCheckClassRegister(ID)) { // ກວດສອບວ່າຫ້ອງນີ້ມີການລົງທະບຽນຫຼືບໍ່
                    alert.messages("ການລົງທະບຽນ", "ຂະແໜງ " + classModel.getClassName() + " ໄດ້ມີການລົງທະບຽນຢູ່", JoAlert.Icons.error);
                } else {
                    classService.DeleteClass(classModel);
                    AppClass ac = new AppClass();
                    ac.Open();
                }
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
