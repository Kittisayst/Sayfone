package Controller;

import App.AppDashboard;
import DAOSevervice.FinancialService;
import Database.JoConnect;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.MyFormat;
import View.HomeView;
import View.ReportFinacialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class ReportFinacialController implements JoMVC, ActionListener {

    private ReportFinacialView view;
    private FinancialModel model;
    private boolean showDay = true; // ສະແດງລາຍງານປະຈຳວັນ
    private boolean showWeek = false; // ສະແດງລາຍງານປະຈຳອາທິດ
    private boolean showDatetoDate = false; // ສະແດງລາຍງານປະຈຳວັນທີ່-ວັນທີ່
    private boolean moneyState = true; // false ໂອນ  , true ສົດ

    public ReportFinacialController(ReportFinacialView view, FinancialModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.getDtDateEnd().setDateData(new Date());
        view.showDataReport(new FinancialService().getFinancialReportByDate(new MyFormat().getDateCustom(new Date(), "yyyy-MM-dd")));
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtnShow().addActionListener(this);
        view.getBtn_ReportDay().addActionListener(this);
        view.getBtnReportWeek().addActionListener(this);
        view.getBtnCashOnly().addActionListener(this);
        view.getBtnTransferOnly().addActionListener(this);
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
            AppDashboard appDashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtn_ReportDay())) { // ລາຍງານປະຈຳວັນ
            setDefaultShow();
            showDay = true;
            showReportDay();
        } else if (event.isEvent(view.getBtnReportWeek())) { // ລາຍງານປະຈຳອາທິດ
            setDefaultShow();
            showWeek = true;
            showReportWeek();
        } else if (event.isEvent(view.getBtnShow())) { // ສະແດງວັນ-ວັນ
            setDefaultShow();
            showDatetoDate = true;
            showReportDatetoDate();
        } else if (event.isEvent(view.getBtnCashOnly())) {
            moneyState = true;
            view.showOnlyState(moneyState);
            showCashOnly();
        } else if (event.isEvent(view.getBtnTransferOnly())) {
            moneyState = false;
            view.showOnlyState(moneyState);
            showTransferOnly();
        } else if (event.isEvent(view.getBtnPrint())) {
            if (showDay) {
                if (moneyState) {
                    System.out.println("Print day Cash");
                    Printercash();
                } else {
                    System.out.println("Print day Transfer");
                    PrinterTransfer();
                }
            } else if (showWeek) {
                if (moneyState) {
                    System.out.println("Print Week Cash");
                    PrintercashWeek();
                } else {
                    System.out.println("Print Week Transfer");
                    PrinterTransferWeek();
                }
            } else if (showDatetoDate) {
                if (moneyState) {
                    System.out.println("Print Date to Date Cash");
                    PrintercashDatetoDate();
                } else {
                    System.out.println("Print Date to Date Transfer");
                    PrinterTransferDatetoDate();
                }
            }
        }
    }

    private void setDefaultShow() {
        showDay = false; // ສະແດງລາຍງານປະຈຳວັນ
        showWeek = false; // ສະແດງລາຍງານປະຈຳອາທິດ
        showDatetoDate = false; // ສະແດງລາຍງານປະຈຳວັນທີ່-ວັນທີ່
    }

    private void showReportDay() {
        showDay = true;
        FinancialService service = new FinancialService();
        if (moneyState) {
            view.showDataReport(service.getFinancialReportByDate(new MyFormat().getDateSQL(new Date())));
        } else {
            view.showDataReportTransfer(service.getFinancialReportByDateTransfer(new MyFormat().getDateSQL(new Date())));
        }
    }

    private void showReportWeek() {
        showWeek = true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date startDateOfWeek = calendar.getTime();
        FinancialService service = new FinancialService();
        if (moneyState) {
            view.showDataReport(service.getFinancialReportByWeek(new MyFormat().getDateSQL(startDateOfWeek)));
        } else {
            view.showDataReportTransfer(service.getFinancialReportByWeekTransfer(new MyFormat().getDateSQL(startDateOfWeek)));
        }

    }

    private void showReportDatetoDate() {
        FinancialService service = new FinancialService();
        String dateStart, dateEnd;
        dateStart = view.getDtDate().getDateSQL();
        dateEnd = view.getDtDateEnd().getDateSQL();
        if (moneyState) {
            view.showDataReport(service.getFinancialReportByDateToDate(dateStart, dateEnd));
        } else {
            view.showDataReportTransfer(service.getFinancialReportByDateToDateTransfer(dateStart, dateEnd));
        }
    }

    private void showCashOnly() {
        if (showDay) {
            System.out.println("DC");
            showReportDay();
        } else if (showWeek) {
            System.out.println("WC");
            showReportWeek();
        } else if (showDatetoDate) {
            System.out.println("DDC");
            showReportDatetoDate();
        }
    }

    private void showTransferOnly() {
        if (showDay) {
            System.out.println("DT");
            showReportDay();
        } else if (showWeek) {
            System.out.println("WT");
            showReportWeek();
        } else if (showDatetoDate) {
            System.out.println("DDT");
            showReportDatetoDate();
        }
    }

    private void Printercash() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            String reportDate = new MyFormat().getDateCustom(new Date(), "yyyy-MM-dd");
            System.out.println(GlobalDataModel.globalUsermodel.getName());
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.globalUsermodel.getFullName() + " )");
            parameter.put("UserID", GlobalDataModel.globalUsermodel.getUserID());
            JasperPrint print = JasperFillManager.fillReport("ReportCashDay.jasper", parameter, new JoConnect().getConnectionDefault());
            JasperViewer showReport = new JasperViewer(print, false);
            showReport.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

    private void PrintercashWeek() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            LocalDate localDate = LocalDate.now();
            // Get the first date of the week
            LocalDate firstDateOfWeek = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            Date date = Date.from(firstDateOfWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
            String reportDate = new MyFormat().getDateCustom(date, "yyyy-MM-dd");
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.globalUsermodel.getFullName() + " )");
            JasperPrint print = JasperFillManager.fillReport("ReportCashWeek.jasper", parameter, new JoConnect().getConnectionDefault());
            JasperViewer showReport = new JasperViewer(print, false);
            showReport.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

    private void PrintercashDatetoDate() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            String reportDate = new MyFormat().getDateCustom(view.getDtDate().getDateData(), "yyyy-MM-dd");
            String reportDateEnd = new MyFormat().getDateCustom(view.getDtDateEnd().getDateData(), "yyyy-MM-dd");
            System.out.println(GlobalDataModel.globalUsermodel.getName());

            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("parmDateEnd", "" + reportDateEnd);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.globalUsermodel.getFullName() + " )");
            JasperPrint print = JasperFillManager.fillReport("ReportCashDaytoDay.jasper", parameter, new JoConnect().getConnectionDefault());
            JasperViewer showReport = new JasperViewer(print, false);
            showReport.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

    private void PrinterTransfer() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            String reportDate = new MyFormat().getDateCustom(new Date(), "yyyy-MM-dd");
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.globalUsermodel.getFullName() + " )");
            JasperPrint print = JasperFillManager.fillReport("ReportTransferDay.jasper", parameter, new JoConnect().getConnectionDefault());
            JasperViewer showReport = new JasperViewer(print, false);
            showReport.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

    private void PrinterTransferWeek() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            String reportDate = new MyFormat().getDateCustom(new Date(), "yyyy-MM-dd");
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.globalUsermodel.getFullName() + " )");
            JasperPrint print = JasperFillManager.fillReport("ReportTransferWeek.jasper", parameter, new JoConnect().getConnectionDefault());
            JasperViewer showReport = new JasperViewer(print, false);
            showReport.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

    private void PrinterTransferDatetoDate() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            String reportDate = new MyFormat().getDateCustom(view.getDtDate().getDateData(), "yyyy-MM-dd");
            String reportDateEnd = new MyFormat().getDateCustom(view.getDtDateEnd().getDateData(), "yyyy-MM-dd");
            System.out.println(GlobalDataModel.globalUsermodel.getName());

            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("parmDateEnd", "" + reportDateEnd);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.globalUsermodel.getFullName() + " )");
            JasperPrint print = JasperFillManager.fillReport("ReportTransferDaytoDay.jasper", parameter, new JoConnect().getConnectionDefault());
            JasperViewer showReport = new JasperViewer(print, false);
            showReport.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
    }

}
