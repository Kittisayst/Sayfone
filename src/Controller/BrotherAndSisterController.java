package Controller;

import App.AppHome;
import Component.DialogBrotherAndSister;
import DAOSevervice.BroderSisterService;
import Model.BrotherAndSisterModel;
import Model.StudentHistoryModel;
import Tools.JoHookEvent;
import View.StudentHistoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrotherAndSisterController implements JoMVC, ActionListener {

    private StudentHistoryView View;
    private StudentHistoryModel StudentModel;
    private BrotherAndSisterModel brotherAndSisterModel;

    public BrotherAndSisterController(StudentHistoryView View, StudentHistoryModel StudentModel) {
        this.View = View;
        this.StudentModel = StudentModel;
        brotherAndSisterModel = new BrotherAndSisterModel();
    }

    @Override
    public void Start() {
        View.showBorderAndSister(new BroderSisterService().getBrotherSisterAll(StudentModel.getStudentID()));
    }

    @Override
    public void AddEvent() {
        View.getBtnAddBS().addActionListener(this);
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
        if (event.isEvent(View.getBtnAddBS())) {
            DialogBrotherAndSister bs = new DialogBrotherAndSister(AppHome.viewParent, true, StudentModel.getStudentID());
            bs.setVisible(true);
        }
    }

}
