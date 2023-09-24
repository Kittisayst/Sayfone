package Controller;

import App.AppAbsent;
import App.AppHome;
import Component.DialogAbsent;
import DAOSevervice.AbsentService;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.AbsentModel;
import Model.FinancialModel;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoHookEvent;
import View.AbsentDataView;
import View.HomeView;
import View.PnLoading;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.SwingUtilities;

public class AbsentDataController implements JoMVC, ActionListener, MouseListener {
    
    private AbsentDataView view;
    private RegisterModel registerModel;
    private List<StudentModel> studentModels;
    private AbsentService service;
    private PnLoading loading = new PnLoading();
    
    public AbsentDataController(AbsentDataView view, RegisterModel registerModel) {
        this.view = view;
        this.registerModel = registerModel;
        studentModels = new ArrayList<>();
        service = new AbsentService();
        loading.setTitle("ໂຫຼດຂໍ້ມູນນັກຮຽນ");
    }
    
    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        loading();
        view.showAbsent(service.readByRegisterID(registerModel.getRegisterID()));
        view.getDtDate().setDateData(new Date());
    }
    
    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnShow().addActionListener(this);
        view.getBtnCheckStudent().addActionListener(this);
        view.getTbData().addMouseListener(this);
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
            AppAbsent absent = new AppAbsent();
            absent.Open();
        } else if (event.isEvent(view.getBtnCheckStudent())) {
            DialogAbsent dialogAbsent = new DialogAbsent(AppHome.viewParent, true, registerModel, studentModels, new AbsentModel(), view);
            dialogAbsent.setTitle(registerModel.getClassRoomName());
            dialogAbsent.setVisible(true);
        } else if (event.isEvent(view.getBtnShow())) {
            view.showAbsent(service.searchByDate(view.getDtDate().getSQLDate()));
        }
    }
    
    int row = 1;
    
    private void loading() {
        Thread thread = new Thread(() -> {
            try {
                studentModels.clear();
                HomeView.MyRouter.setRouter(loading);
                List<FinancialModel> financialModels = new FinancialService().getStudentRegistered(registerModel.getRegisterID());
                financialModels.forEach(data -> {
                    row++;
                    studentModels.add(new StudentService().getStudentById(data.getStudentID()));
                    int progress = (int) ((double) row / financialModels.size() * 100);
                    SwingUtilities.invokeLater(() -> {
                        loading.setValue(progress);
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                row = 1;
                HomeView.MyRouter.setRouter(view);
            }
        });
        thread.start();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTbData())) {
            if (e.getClickCount() == 2) {
                AbsentModel absentModel = service.read(view.getAbsentID());
                DialogAbsent absent = new DialogAbsent(AppHome.viewParent, true, registerModel, studentModels, absentModel, view);
                absent.setTitle(registerModel.getClassRoomName() + " ວັນທີ: " + absentModel.getAbsentDate());
                absent.setVisible(true);
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
