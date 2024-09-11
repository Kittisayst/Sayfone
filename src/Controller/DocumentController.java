package Controller;

import App.AppDocument;
import Component.AuthenPopUp;
import Component.DialogDocument;
import DAOSevervice.DocumentService;
import Model.DocumentModel;
import Model.GlobalDataModel;
import Model.UserModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Utility.ActionCellEvent;
import View.DocumentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentController implements JoMVC, ActionListener {

    private final DocumentView view;

    public DocumentController(DocumentView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showDocument(new DocumentService().getAll());
        TableEvent();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnAdd().addActionListener(this);
        view.getBtnSearch().addActionListener(this);
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

    private void TableEvent() {
        ActionListener viewEvent = (ActionEvent e) -> {
            DialogDocument document = new DialogDocument(GlobalDataModel.rootView, true, new DocumentService().read(view.getDucumentID()));
            document.setVisible(true);
        };

        ActionListener editEvent = (ActionEvent e) -> {
            DocumentService service = new DocumentService();
            service.read(view.getDucumentID()).Download();
        };

        ActionListener deleteEvent = (ActionEvent e) -> {
            DocumentService service = new DocumentService();
            JoAlert alert = new JoAlert();
            if (alert.JoSubmitDelete()) {
                AuthenPopUp auth = new AuthenPopUp(GlobalDataModel.rootView, true);
                auth.setVisible(true);
                UserModel model = auth.getUserModel();
                if (model.getUserID() != 0) {
                    service.delete(view.getDucumentID());
                    new AppDocument().Open();
                }
            }
        };

        view.getTb_data().setActionCellEvent(new ActionCellEvent(viewEvent, editEvent, deleteEvent));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtnAdd())) {
            DialogDocument document = new DialogDocument(GlobalDataModel.rootView, true, new DocumentModel());
            document.setVisible(true);
        } else if (event.isEvent(view.getBtnSearch())) {
            view.showDocument(new DocumentService().searchDoc(view.getSearchText()));
        }
    }

}
