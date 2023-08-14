package Controller;

import App.AppDashboard;
import DAO.TeacherDAO;
import DAO.YearDAO;
import DAOSevervice.TeacherService;
import DAOSevervice.YearService;
import Model.TeacherRankModel;
import Model.YearModel;
import Tools.JoHookEvent;
import View.HomeView;
import View.TeacherRinkView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherRankController implements JoMVC, ActionListener {

    private TeacherRankModel model;
    private TeacherRinkView view;

    public TeacherRankController(TeacherRankModel model, TeacherRinkView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        YearService yearService = new YearService();
        view.showYear(yearService.getYearAll());
        YearModel yearModel = yearService.getLastYear();
        view.showTeacher(new TeacherDAO().getAllTeacher(), yearModel);
        view.getCbYear().setSelectedIndex(yearService.getYearAll().size() - 1);
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnShow().addActionListener(this);
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
            AppDashboard dashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtnShow())) {
            System.out.println("ok");
            YearModel yearModel = new YearService().getYearById(view.getCbYear().getKeyInt());
            view.showTeacher(new TeacherService().getAllTeacher(), yearModel);
        }
    }

}
