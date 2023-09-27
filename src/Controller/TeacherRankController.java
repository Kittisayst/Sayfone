package Controller;

import DAO.TeacherDAO;
import DAOSevervice.TeacherService;
import DAOSevervice.YearService;
import Model.GlobalDataModel;
import Model.TeacherRankModel;
import Model.YearModel;
import Tools.JoHookEvent;
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
        GlobalDataModel.rootView.setView(view);
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
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtnShow())) {
            System.out.println("ok");
            YearModel yearModel = new YearService().getYearById(view.getCbYear().getKeyInt());
            view.showTeacher(new TeacherService().getAllTeacher(), yearModel);
        }
    }

}
