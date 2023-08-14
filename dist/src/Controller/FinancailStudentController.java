package Controller;

import App.AppFinancial;
import App.AppFinancialRoom;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.CreateRegisterModel;
import Model.StudentModel;
import Tools.JoHookEvent;
import View.HomeView;
import View.FinancailStudentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class FinancailStudentController implements JoMVC, ActionListener, MouseListener {

    private FinancailStudentView view;
    private CreateRegisterModel registerModel;

    public FinancailStudentController(FinancailStudentView view, CreateRegisterModel registerModel) {
        this.view = view;
        this.registerModel = registerModel;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.getBtn_Add().setEnabled(false);
        //ສະແດງນັກສຶກສາທັງໝົດ
        view.showStudentAll(FilterStudentRegistered());
        view.setButtonState(true);
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_Add().addActionListener(this);
        view.getTb_data().addMouseListener(this);
        view.getBtnRegister().addActionListener(this);
        view.getBtnRegistered().addActionListener(this);
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
            AppFinancialRoom app = new AppFinancialRoom();
            app.open();
        } else if (event.isEvent(view.getBtn_Add())) {
            StudentService studentService = new StudentService();
            StudentModel studentModel = studentService.getStudentById(view.getTb_data().getIntValue(1));
            if (studentModel.getStudentID() != 0) {
                AppFinancial app = new AppFinancial(registerModel, studentModel);
            }
        } else if (event.isEvent(view.getBtnRegister())) {
            view.setButtonState(false);
            view.ClearDataTable();
            view.showStudentAll(new StudentService().getSutdentNotRegister());
        } else if (event.isEvent(view.getBtnRegistered())) {
            view.setButtonState(true);
             view.ClearDataTable();
            view.showStudentAll(FilterStudentRegistered());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                StudentService studentService = new StudentService();
                StudentModel studentModel = studentService.getStudentById(view.getTb_data().getIntValue(1));
                AppFinancial app = new AppFinancial(registerModel, studentModel);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            view.getBtn_Add().setEnabled(true);
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

    private List<StudentModel> FilterStudentRegistered() {
        FinancialService financialService = new FinancialService();
        List<StudentModel> studentList = new ArrayList<>();
        List<FinancialModel> models = financialService.getStudentRegistered(registerModel.getRegisterID());
        models.forEach(data -> {
            studentList.add(new StudentService().getStudentById(data.getStudentID()));
        });
        return studentList;
    }

}
