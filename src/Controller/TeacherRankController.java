package Controller;

import Component.DialogTeacherMoney;
import Component.DialogTeacherRank;
import DAO.TeacherDAO;
import DAOSevervice.TeacherMoneyService;
import DAOSevervice.TeacherService;
import DAOSevervice.YearService;
import Model.GlobalDataModel;
import Model.TeacherMoneyModel;
import Model.TeacherRankModel;
import Model.YearModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import View.TeacherRinkView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TeacherRankController implements JoMVC, ActionListener, MouseListener {

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
        view.getPopup().addActionListener(this);
        view.TeacherEvent(this);
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
            YearModel yearModel = new YearService().getYearById(view.getCbYear().getKeyInt());
            view.showTeacher(new TeacherService().getAllTeacher(), yearModel);
        } else if (event.isEvent(view.getPopup().getItemshow())) {
            DialogTeacherRank teacherRank = new DialogTeacherRank(
                    GlobalDataModel.rootView,
                    true,
                    new TeacherService().getTeacherById(view.getTeacherID()),
                    view.getYearID(),
                    view.getMonthID(),
                    view
            );
            teacherRank.setVisible(true);
        } else if (event.isEvent(view.getPopup().getItemEdit())) {
            DialogTeacherMoney teacherMoney = new DialogTeacherMoney(
                    GlobalDataModel.rootView,
                    true,
                    new TeacherService().getTeacherById(view.getTeacherID()),
                    new YearService().getYearById(view.getYearID()),
                    new TeacherMoneyService().readTeacherID(view.getTeacherID()),
                    view
            );
            String text = view.getPopup().getItemEdit().getText();
            teacherMoney.setTitle(text);
            teacherMoney.setButtonText("ບັນທຶກ " + text);
            teacherMoney.setMoneystate(true);
            teacherMoney.setVisible(true);
        } else if (event.isEvent(view.getPopup().getItemDelete())) {
            TeacherMoneyModel moneyModel = new TeacherMoneyService().readTeacherID(view.getTeacherID());
            if (moneyModel.getTeacherMoneyID() != 0) {
                DialogTeacherMoney teacherMoney = new DialogTeacherMoney(
                        GlobalDataModel.rootView,
                        true,
                        new TeacherService().getTeacherById(view.getTeacherID()),
                        new YearService().getYearById(view.getYearID()),
                        moneyModel,
                        view
                );
                String text = view.getPopup().getItemDelete().getText();
                teacherMoney.setTitle(text);
                teacherMoney.setButtonText("ບັນທຶກ " + text);
                teacherMoney.setMoneystate(false);
                teacherMoney.setVisible(true);
            } else {
                new JoAlert().messages("ການເງິນຄູ", "ຍັງບໍ່ມີຂໍ້ມູນການເງິນຄູ!", JoAlert.Icons.warning);
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
        if (event.isEvent(view.getTbTeacher())) {
            view.getPopup().ShowPopup(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
