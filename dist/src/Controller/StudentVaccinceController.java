package Controller;

import App.AppStudentData;
import App.AppStudentVaccince;
import Model.StudentVacinceModel;
import DAOSevervice.StudentService;
import DAOSevervice.StudentVaccinceService;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Tools.JoPopup;
import View.HomeView;
import View.StudentVaccinView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentVaccinceController implements JoMVC, ActionListener {

    private final StudentVaccinView view;
    private final int StudentID;
    private StudentVacinceModel model;
    private final StudentVaccinceService service;
    private final JoPopup popup;

    public StudentVaccinceController(StudentVaccinView view, int StudentID) {
        this.view = view;
        this.StudentID = StudentID;
        model = new StudentVacinceModel();
        service = new StudentVaccinceService();
        popup = new JoPopup();
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showStudentVaccince(service.getStudentVacinceAllByStudentID(StudentID));
    }

    @Override
    public final void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_save().addActionListener(this);
        popup.addActionListener(this, view.getTb_data());
    }

    @Override
    public void Create() {
        model.setVaccinID(0);
        model.setStudentID(StudentID);
        model.setVaccinNo(view.getTxt_VaccinNo().getText());
        model.setVaccinName(view.getTxt_VaccinName().getText());
        model.setVaccinCategory(view.getTxt_VaccinCategory().getText());
        model.setLocation(view.getTxt_Location().getText());
        model.setData(view.getDt_Date().getSQLDate());
        model.setDoctorName(view.getTxt_DoctorName().getText());
        int respon = service.CreaterStudentVacince(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppStudentVaccince appTeacherVaccin = new AppStudentVaccince(new StudentService().getStudentById(StudentID));
        }
    }

    @Override
    public void Update() {
        model.setVaccinNo(view.getTxt_VaccinNo().getText());
        model.setVaccinName(view.getTxt_VaccinName().getText());
        model.setVaccinCategory(view.getTxt_VaccinCategory().getText());
        model.setLocation(view.getTxt_Location().getText());
        model.setData(view.getDt_Date().getSQLDate());
        model.setDoctorName(view.getTxt_DoctorName().getText());
        int respon = service.UpdateStudentVacince(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppStudentVaccince appTeacherVaccin = new AppStudentVaccince(new StudentService().getStudentById(StudentID));
        }
    }

    @Override
    public void Delete() {
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            int vaccinID = view.getTb_data().getIntValue(1);
            model = service.getStudentVacinceById(vaccinID);
            service.DeleteStudentVacince(model);
            AppStudentVaccince appTeacherVaccin = new AppStudentVaccince(new StudentService().getStudentById(StudentID));
        }
    }

    @Override
    public boolean emptyData() {
        return view.getTxt_VaccinNo().TextEmpty() && view.getTxt_VaccinName().TextEmpty() && view.getTxt_VaccinCategory().TextEmpty()
                && view.getTxt_Location().TextEmpty() && view.getTxt_DoctorName().TextEmpty() && view.getDt_Date().DateEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppStudentData appTeacherData = new AppStudentData(StudentID);
        } else if (event.isEvent(view.getBtn_save())) {
            if (model.getVaccinID() == 0) {
                if (emptyData()) {
                    Create();
                }
            } else {
                if (emptyData()) {
                    Update();
                }
            }
        } else if (event.isEvent(popup.getItemshow())) {

        } else if (event.isEvent(popup.getItemEdit())) {
            int vaccinID = view.getTb_data().getIntValue(1);
            model = service.getStudentVacinceById(vaccinID);
            view.showVaccince(model);
        } else if (event.isEvent(popup.getItemDelete())) {
            Delete();
        }
    }

}
