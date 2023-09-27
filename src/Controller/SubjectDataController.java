package Controller;

import App.AppSubject;
import DAOSevervice.SubjectService;
import Model.GlobalDataModel;
import Model.SubjectModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import View.SubjectDataView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectDataController implements JoMVC, ActionListener {

    SubjectDataView view;
    SubjectModel model;

    public SubjectDataController(SubjectDataView view, SubjectModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        view.showSubject(model);
        GlobalDataModel.rootView.setView(view);
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_save().addActionListener(this);
    }

    @Override
    public void Create() {
        if (emptyData()) {
            SubjectService service = new SubjectService();
            int check = service.CreaterSubject(new SubjectModel(0, view.getTxt_SubjectName().getText()));
            JoAlert alert = new JoAlert();
            alert.JoSubmit(check, JoAlert.INSERT);
            AppSubject appSubject = new AppSubject();
        }

    }

    @Override
    public void Update() {
        if (emptyData()) {
            SubjectService service = new SubjectService();
            model.setSubjectName(view.getTxt_SubjectName().getText());
            int check = service.UpdateSubject(model);
            if (check == 1) {
                JoAlert alert = new JoAlert();
                alert.JoSubmit(check, JoAlert.UPDATE);
                AppSubject appSubject = new AppSubject();
            }
        }
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean emptyData() {
        return view.getTxt_SubjectName().TextEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppSubject appSubject = new AppSubject();
        } else if (event.isEvent(view.getBtn_save())) {
            if (model.getSubjectID() == 0) {
                Create();
            } else {
                Update();
            }
        }
    }

}
