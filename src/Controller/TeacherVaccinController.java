package Controller;

import App.AppTeacherData;
import App.AppTeacherVaccin;
import Model.TeacherVaccinModel;
import DAOSevervice.TeacherService;
import DAOSevervice.TeacherVaccinService;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Tools.JoPopup;
import View.TeacherVaccinView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherVaccinController implements JoMVC, ActionListener {

    private final TeacherVaccinView view;
    private final int TeacherID;
    private final TeacherVaccinService service;
    private TeacherVaccinModel model;
    private final JoPopup popup;

    public TeacherVaccinController(TeacherVaccinView view, int TeacherID) {
        this.view = view;
        this.TeacherID = TeacherID;
        service = new TeacherVaccinService();
        model = new TeacherVaccinModel();
        popup = new JoPopup();
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showTeacherVaccin(service.getTeacherVaccinAllByTeacherID(TeacherID));
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
        model.setTeacherID(TeacherID);
        model.setVaccinNo(view.getTxt_VaccinNo().getText());
        model.setVaccinName(view.getTxt_VaccinName().getText());
        model.setVaccinCategory(view.getTxt_VaccinCategory().getText());
        model.setLocation(view.getTxt_Location().getText());
        model.setData(view.getDt_Date().getSQLDate());
        model.setDoctorName(view.getTxt_DoctorName().getText());
        int respon = service.CreaterTeacherVaccin(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppTeacherVaccin appTeacherVaccin = new AppTeacherVaccin(new TeacherService().getTeacherById(TeacherID));
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
        int respon = service.UpdateTeacherVaccin(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppTeacherVaccin appTeacherVaccin = new AppTeacherVaccin(new TeacherService().getTeacherById(TeacherID));
        }
    }

    @Override
    public void Delete() {
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            int vaccinID = view.getTb_data().getIntValue(1);
            model = service.getTeacherVaccinById(vaccinID);
            service.DeleteTeacherVaccin(model);
            AppTeacherVaccin appTeacherVaccin = new AppTeacherVaccin(new TeacherService().getTeacherById(TeacherID));
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
            AppTeacherData appTeacherData = new AppTeacherData(new TeacherService().getTeacherById(TeacherID));
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
            model = service.getTeacherVaccinById(vaccinID);
            view.showVaccince(model);
        } else if (event.isEvent(popup.getItemDelete())) {
            Delete();
        }
    }

}
