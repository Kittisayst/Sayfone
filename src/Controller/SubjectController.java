package Controller;

import App.AppDashboard;
import App.AppSubject;
import App.AppSubjectData;
import DAOSevervice.SubjectService;
import Model.SubjectModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Tools.JoPopup;
import View.HomeView;
import View.SubjectView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SubjectController implements JoMVC, ActionListener, MouseListener {

    private final SubjectView view;
    private final SubjectService service = new SubjectService();
    private final JoPopup popup;

    public SubjectController(SubjectView view, SubjectModel service) {
        this.view = view;
        popup = new JoPopup();
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showSubject(service.getAll());
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        popup.addActionListener(this, view.getTb_data());
        view.getBtn_Add().addActionListener(this);
        view.getTb_data().addMouseListener(this);
    }

    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean emptyData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_Add())) {
            AppSubjectData subjectData = new AppSubjectData(new SubjectModel());
        }else if (event.isEvent(view.getBtn_back())) {
            new AppDashboard();
        }  else if (event.isEvent(popup.getItemshow())) {
            new JoAlert().messages(view.getTb_data().getValue(2));
        } else if (event.isEvent(popup.getItemEdit())) {
            AppSubjectData subjectData = new AppSubjectData(service.getSubjectById(view.getTb_data().getIntValue(1)));
        } else if (event.isEvent(popup.getItemDelete())) {
            if (new JoAlert().JoSubmitDelete()) {
                service.DeleteSubject(Integer.parseInt(view.getTb_data().getValue(1)));
                AppSubject appSubject = new AppSubject();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                AppSubjectData subjectData = new AppSubjectData(service.getSubjectById(view.getTb_data().getIntValue(1)));
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
