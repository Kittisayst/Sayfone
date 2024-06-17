package Controller;

import DAOSevervice.FinancialService;
import Database.JoConnect;
import Log.JoLoger;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.JoJasperPrinter;
import Utility.MyFormat;
import View.ReportFinacialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.JRException;

public class ReportFinacialController implements JoMVC, ActionListener {

    private ReportFinacialView view;
    private FinancialModel model;
    private boolean showDay = true; // ສະແດງລາຍງານປະຈຳວັນ
    private boolean showWeek = false; // ສະແດງລາຍງານປະຈຳອາທິດ
    private boolean showDatetoDate = false; // ສະແດງລາຍງານປະຈຳວັນທີ່-ວັນທີ່
    private boolean moneyState = true; // false ໂອນ  , true ສົດ
    private final String UserLogin = "" + GlobalDataModel.userModel.getUserID();

    public ReportFinacialController(ReportFinacialView view, FinancialModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.getDtDateEnd().setDateData(new Date());
        // ສະແດງຂໍ້ມູນໃນຕາຕະລາງປະຈຳວັນທີ
        FinancialService service = new FinancialService();
        String dateNow = new MyFormat().getDateSQL(new Date());
        List<FinancialModel> models = service.getFinancialReportByDate(dateNow, UserLogin);
        view.showDataReport(models); //ເງິນສົດ
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
           GlobalDataModel.rootView.showDashbord();
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

    private void showReportDay() {  // ສະແດງຂໍ້ມູນລາຍງານປະຈຳ ວັນ ໃນຕາຕະລາງ 
        showDay = true;
        FinancialService service = new FinancialService();
        String dateNow = new MyFormat().getDateSQL(new Date());
        List<FinancialModel> models;
        if (moneyState) {
            models = service.getFinancialReportByDate(dateNow, UserLogin);
            view.showDataReport(models); //ເງິນສົດ
        } else {
            models = service.getFinancialReportByDateTransfer(dateNow, UserLogin);
            view.showDataReportTransfer(models); //ໂອນ
        }
    }

    private void showReportWeek() { // ສະແດງຂໍ້ມູນລາຍງານປະຈຳ ອາທິດ ໃນຕາຕະລາງ 
        showWeek = true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date startDateOfWeek = calendar.getTime();
        FinancialService service = new FinancialService();
        String dateInWeek = new MyFormat().getDateSQL(startDateOfWeek);
        List<FinancialModel> models;
        if (moneyState) {
            models = service.getFinancialReportByWeek(dateInWeek, UserLogin);
            view.showDataReport(models); //ເງິນສົດ
        } else {
            models = service.getFinancialReportByWeekTransfer(dateInWeek, UserLogin);
            view.showDataReportTransfer(models); //ໂອນ
        }

    }

    private void showReportDatetoDate() { // ສະແດງຂໍ້ມູນລາຍງານປະຈຳວັນທີ່ໃນຕາຕະລາງ
        FinancialService service = new FinancialService();
        String dateStart, dateEnd;
        dateStart = view.getDtDate().getDateSQL();
        dateEnd = view.getDtDateEnd().getDateSQL();
        List<FinancialModel> models;
        if (moneyState) {
            models = service.getFinancialReportByDateToDate(dateStart, dateEnd, UserLogin);
            view.showDataReport(models); //ເງິນສົດ
        } else {
            models = service.getFinancialReportByDateToDateTransfer(dateStart, dateEnd, UserLogin);
            view.showDataReportTransfer(models); //ໂອນ
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
            System.out.println(GlobalDataModel.userModel.getName());
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.userModel.getFullName() + " )");
            parameter.put("UserID", UserLogin);
            JasperPrint print = JasperFillManager.fillReport("ReportCashDay.jasper", parameter, new JoConnect().getConnectionDefault());
            setPrintState(print, "ReportCashDay");
        } catch (Exception e) {
            e.printStackTrace();
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
    }

    private void PrintercashWeek() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            Date startDateOfWeek = calendar.getTime();
            String dateInWeek = new MyFormat().getDateSQL(startDateOfWeek);
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + dateInWeek);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.userModel.getFullName() + " )");
            parameter.put("UserID", UserLogin);
            JasperPrint print = JasperFillManager.fillReport("ReportCashWeek.jasper", parameter, new JoConnect().getConnectionDefault());
            setPrintState(print, "ReportCashWeek");
        } catch (Exception e) {
            e.printStackTrace();
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
    }

    private void PrintercashDatetoDate() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            String reportDate = new MyFormat().getDateCustom(view.getDtDate().getDateData(), "yyyy-MM-dd");
            String reportDateEnd = new MyFormat().getDateCustom(view.getDtDateEnd().getDateData(), "yyyy-MM-dd");
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("parmDateEnd", "" + reportDateEnd);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.userModel.getFullName() + " )");
            parameter.put("UserID", UserLogin);
            JasperPrint print = JasperFillManager.fillReport("ReportCashDaytoDay.jasper", parameter, new JoConnect().getConnectionDefault());
            setPrintState(print, "ReportCashDaytoDay");
        } catch (Exception e) {
            e.printStackTrace();
            JoLoger.saveLog(e, this);
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
            parameter.put("UserPrint", "( " + GlobalDataModel.userModel.getFullName() + " )");
            parameter.put("UserID", UserLogin);
            JasperPrint print = JasperFillManager.fillReport("ReportTransferDay.jasper", parameter, new JoConnect().getConnectionDefault());
            setPrintState(print, "ReportTransferDay");
        } catch (JRException e) {
            e.printStackTrace();
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
    }

    private void PrinterTransferWeek() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            Date startDateOfWeek = calendar.getTime();
            String dateInWeek = new MyFormat().getDateSQL(startDateOfWeek);
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + dateInWeek);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.userModel.getFullName() + " )");
            parameter.put("UserID", UserLogin);
            JasperPrint print = JasperFillManager.fillReport("ReportTransferWeek.jasper", parameter, new JoConnect().getConnectionDefault());
            setPrintState(print, "ReportTransferWeek");
        } catch (Exception e) {
            e.printStackTrace();
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
    }

    private void PrinterTransferDatetoDate() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
            String reportDate = new MyFormat().getDateCustom(view.getDtDate().getDateData(), "yyyy-MM-dd");
            String reportDateEnd = new MyFormat().getDateCustom(view.getDtDateEnd().getDateData(), "yyyy-MM-dd");
            Map parameter = new HashMap();
            parameter.put("parmDate", "" + reportDate);
            parameter.put("parmDateEnd", "" + reportDateEnd);
            parameter.put("LogoPath", logo);
            parameter.put("UserPrint", "( " + GlobalDataModel.userModel.getFullName() + " )");
            parameter.put("UserID", UserLogin);
            JasperPrint print = JasperFillManager.fillReport("ReportTransferDaytoDay.jasper", parameter, new JoConnect().getConnectionDefault());
            setPrintState(print, "ReportTransferDaytoDay");
        } catch (Exception e) {
            e.printStackTrace();
            JoLoger.saveLog(e, this);
            JoAlert.Error(e, this);
        }
    }

    private void setPrintState(JasperPrint print, String Title) {
        try {
            if (GlobalDataModel.printerReportState) {
                new JoJasperPrinter(print).print(1);
            } else {
                JasperViewer showReport = new JasperViewer(print, false);
                showReport.setTitle(Title);
                showReport.setVisible(true);
            }
        } catch (Exception e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }
    }

}
