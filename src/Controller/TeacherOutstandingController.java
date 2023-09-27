package Controller;

import App.AppTeacherData;
import App.AppTeacherOutstanding;
import Model.TeacherOutstandingModel;
import DAOSevervice.OutStandingCatService;
import DAOSevervice.TeacherOutStandingService;
import DAOSevervice.TeacherService;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Tools.JoPopup;
import View.TeacherOutstandingView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TeacherOutstandingController implements JoMVC, ActionListener {

    private final TeacherOutstandingView view;
    private TeacherOutstandingModel model;
    private final int TeacherID;
    private final TeacherOutStandingService service;
    private final OutStandingCatService catService;
    private final JoPopup popup;

    public TeacherOutstandingController(TeacherOutstandingView view, int TeacherID) {
        this.view = view;
        this.TeacherID = TeacherID;
        service = new TeacherOutStandingService();
        model = new TeacherOutstandingModel();
        catService = new OutStandingCatService();
        popup = new JoPopup();
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
       GlobalDataModel.rootView.setView(view);
        view.showTeacherOutstanding(service.getAllByTeacherID(TeacherID));
        view.showOutstandingCategory(catService.getAllOutstanding());
        view.getDt_date().setDateData(new Date());
    }

    @Override
    public final void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_save().addActionListener(this);
        popup.addActionListener(this, view.getTb_data());
    }

    @Override
    public void Create() {
        model.setTeacherOutstandingID(0);
        model.setOutstandingCatID(view.getCb_outstandingCat().getKeyInt());
        model.setTeacherID(TeacherID);
        model.setOutstandingDate(view.getDt_date().getSQLDate());
        model.setOutstandingDetail(view.getTxt_info().getText());
        JoAlert alert = new JoAlert();
        int respon = service.CreaterTeacherOutstanding(model);
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppTeacherOutstanding appTeacherOutstanding = new AppTeacherOutstanding(new TeacherService().getTeacherById(TeacherID));
        }
    }

    @Override
    public void Update() {
        int OutstandingID = view.getTb_data().getIntValue(1);
        model.setTeacherOutstandingID(OutstandingID);
        model.setOutstandingCatID(view.getCb_outstandingCat().getKeyInt());
        model.setTeacherID(TeacherID);
        model.setOutstandingDate(view.getDt_date().getSQLDate());
        model.setOutstandingDetail(view.getTxt_info().getText());
        JoAlert alert = new JoAlert();
        int respon = service.UpdateTeacherOutstanding(model);
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppTeacherOutstanding appTeacherOutstanding = new AppTeacherOutstanding(new TeacherService().getTeacherById(TeacherID));
        }
    }

    @Override
    public void Delete() {
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            int OutstandingID = view.getTb_data().getIntValue(1);
            model.setTeacherOutstandingID(OutstandingID);
            service.DeleteTeacherOutstanding(model);
            AppTeacherOutstanding appTeacherOutstanding = new AppTeacherOutstanding(new TeacherService().getTeacherById(TeacherID));
        }
    }

    @Override
    public boolean emptyData() {
        return view.getDt_date().DateEmpty() && view.getTxt_info().TextEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppTeacherData appTeacherData = new AppTeacherData(new TeacherService().getTeacherById(TeacherID));
        } else if (event.isEvent(view.getBtn_save())) {
            if (model.getTeacherOutstandingID() == 0) {
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
            int OutStandingID = view.getTb_data().getIntValue(1);
            model = service.getByTeacherOutstandingID(OutStandingID);
            view.showTeacherOutstanding(model);
        } else if (event.isEvent(popup.getItemDelete())) {

        }
    }

}
