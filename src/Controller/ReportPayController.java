package Controller;

import DAOSevervice.StudentService;
import DAOSevervice.YearService;
import Model.FinancialModel;
import View.HomeView;
import View.ReportPayView;

public class ReportPayController implements JoMVC {
    
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
        StudentService studentService = new StudentService();
        view.showReportPay(studentService.getAllStudent());
    }
    
    @Override
    public void AddEvent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
}
