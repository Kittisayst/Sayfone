package Controller;

import App.AppDashboard;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import DAOSevervice.YearService;
import Model.FinancialModel;
import Tools.JoHookEvent;
import View.HomeView;
import View.ReportPayView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportPayController implements JoMVC, ActionListener {

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
        FinancialService financialService = new FinancialService();
        view.showReportPay(financialService.getFinancialFree(view.getCbYear().getKeyInt()));
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
            AppDashboard dashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtnShow())) {
            FinancialService financialService = new FinancialService();
            view.showReportPay(financialService.getFinancialFree(view.getCbYear().getKeyInt()));
        }
    }

}
