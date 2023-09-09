package Controller;

import App.AppDashboard;
import App.AppFinancial;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import DAOSevervice.YearService;
import Model.FinancialModel;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoHookEvent;
import View.HomeView;
import View.ReportPayView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReportPayController implements JoMVC, ActionListener, ItemListener, MouseListener {

    private final ReportPayView view;
    private final FinancialModel model;

    public ReportPayController(ReportPayView view, FinancialModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showYear(new YearService().getYearAll());
        view.getCbYear().setSelectedIndex(new YearService().getYearAll().size() - 1);
        view.showClassRoom(new RegisterService().getRegisterAllByYearID(view.getCbYear().getKeyInt()));
//        view.showReportPay(financialService.getFinancialFree(view.getCbYear().getKeyInt()));
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnShow().addActionListener(this);
        view.getCbYear().addItemListener(this);
        view.getTb_data().addMouseListener(this);
        view.getBtnPrint().addActionListener(this);
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
            FinancialService financialService = new FinancialService();
            view.showReportPay(financialService.getStudentRegistered(view.getCbClassRoom().getKeyInt()));
        }else if (event.isEvent(view.getBtnPrint())) {
            FinancialService financialService = new FinancialService();
            financialService.ExportPayment(view.getCbClassRoom().getKeyInt());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getCbYear())) {
            view.showClassRoom(new RegisterService().getRegisterAllByYearID(view.getCbYear().getKeyInt()));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount()==2) {
                RegisterModel registerModel = new RegisterService().getRegisterById(view.getCbClassRoom().getKeyInt());
                StudentModel studentModel = new StudentService().getStudentById(view.getTb_data().getIntValue(2));
                AppFinancial app = new AppFinancial(registerModel, studentModel);
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
