package Controller;

import Chart.PieChartUI;
import Chart.PieChartUIModel;
import Component.BarChart;
import DAOSevervice.StudentAddressService;
import Model.ChartStudentAddree;
import Model.CountVillageModel;
import Model.GlobalDataModel;
import Tools.JoHookEvent;
import Utility.JoExportExcel;
import Utility.chart.ModelChart;
import View.ReportStudentAddressView;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReportStudentAddressController implements JoMVC, ActionListener {

    private ReportStudentAddressView view;
    private boolean provinceState1 = false;
    private boolean provinceState2 = false;
    private List<CountVillageModel> exportvillageCurent;
    private List<CountVillageModel> exportvillageNow;

    public ReportStudentAddressController(ReportStudentAddressView view) {
        this.view = view;
        exportvillageCurent = new ArrayList<>();
        exportvillageNow = new ArrayList<>();
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.updateButtonStateSwitchParent1();
        view.updateButtonStateSwitchParent2();
        showPieChartAddress1();
        showPieChartAddress2();
        showVillageCountCurrent();
        showVillageCountNow();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getCkProvince1().addActionListener(this);
        view.getCkProvince2().addActionListener(this);
        view.getBtnBarchart1().addActionListener(this);
        view.getBtnBarchart2().addActionListener(this);
        view.getBtnPiechart1().addActionListener(this);
        view.getBtnPiechart2().addActionListener(this);
        view.handelExportVillageCurent(e -> exportVillageCurent());
        view.handelExportVillageNow(e -> exportVillageNow());
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
        } else if (event.isEvent(view.getCkProvince1())) {
            provinceState1 = !provinceState1;
            view.getBtnPiechart1().doClick();
        } else if (event.isEvent(view.getCkProvince2())) {
            provinceState2 = !provinceState2;
            view.getBtnPiechart2().doClick();
        } else if (event.isEvent(view.getBtnPiechart1())) {
            view.updateButtonStateSwitchParent1();
            showPieChartAddress1();
        } else if (event.isEvent(view.getBtnPiechart2())) {
            view.updateButtonStateSwitchParent2();
            showPieChartAddress2();
        } else if (event.isEvent(view.getBtnBarchart1())) {
            view.updateButtonStateSwitchParent1();
            showBarcharAddress1();
        } else if (event.isEvent(view.getBtnBarchart2())) {
            view.updateButtonStateSwitchParent2();
            showBarcharAddress2();
        }
    }

    private void showPieChartAddress1() {
        if (provinceState1) {
            List<ChartStudentAddree> datas = new StudentAddressService().getChartStudentProvince(true);
            PieChartUI chartUI = createPieChart(datas);
            view.setPiechartParent1(chartUI);
        } else {
            List<ChartStudentAddree> datas = new StudentAddressService().getChartStudentAddressDistrict(true);
            PieChartUI chartUI = createPieChart(datas);
            view.setPiechartParent1(chartUI);
        }
    }

    private void showPieChartAddress2() {
        if (provinceState2) {
            List<ChartStudentAddree> datas = new StudentAddressService().getChartStudentProvince(false);
            PieChartUI chartUI = createPieChart(datas);
            view.setPiechartParent2(chartUI);
        } else {
            List<ChartStudentAddree> datas = new StudentAddressService().getChartStudentAddressDistrict(false);
            PieChartUI chartUI = createPieChart(datas);
            view.setPiechartParent2(chartUI);
        }
    }

    private void showBarcharAddress1() {
        if (provinceState1) {
            List<ChartStudentAddree> datas = new StudentAddressService().getChartStudentProvince(true);
            BarChart barChart = createBarchart(datas, "ແຂວງ");
            view.setBarchatParent1(barChart);
        } else {
            List<ChartStudentAddree> datas = new StudentAddressService().getChartStudentAddressDistrict(true);
            BarChart barChart = createBarchart(datas, "ເມືອງ");
            view.setBarchatParent1(barChart);
        }
    }

    private void showBarcharAddress2() {
        if (provinceState2) {
            List<ChartStudentAddree> datas = new StudentAddressService().getChartStudentProvince(false);
            BarChart barChart = createBarchart(datas, "ແຂວງ");
            view.setBarchatParent2(barChart);
        } else {
            List<ChartStudentAddree> datas = new StudentAddressService().getChartStudentAddressDistrict(false);
            BarChart barChart = createBarchart(datas, "ເມືອງ");
            view.setBarchatParent2(barChart);
        }
    }

    private BarChart createBarchart(List<ChartStudentAddree> datas, String text) {
        BarChart barChart = new BarChart();
        barChart.setFont(new Font("Phetsarath OT", 0, 12));
        barChart.addLegend(text, new Color(25, 118, 210));
        for (ChartStudentAddree data : datas) {
            if (data.getCount() > 2) {
                String name = data.getName().equals("") ? "ວ່າງເບົ່າ" : data.getName();
                barChart.addData(new ModelChart(name, new double[]{data.getCount()}));
            }
        }
        return barChart;
    }

    private PieChartUI createPieChart(List<ChartStudentAddree> datas) {
        PieChartUI chartUI = new PieChartUI();
        Random random = new Random();
        for (ChartStudentAddree data : datas) {
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color randomColor = new Color(red, green, blue);
            if (data.getCount() > 2) {
                String name = data.getName().equals("") ? "ວ່າງເບົ່າ" : data.getName();
                chartUI.addData(new PieChartUIModel(name, data.getCount(), randomColor));
            }
        }
        return chartUI;
    }

    private void showVillageCountCurrent() {
        StudentAddressService service = new StudentAddressService();
        exportvillageCurent = service.getCountVillageCurrent();
        view.showTableVillageCurrent(exportvillageCurent);
    }

    private void showVillageCountNow() {
        StudentAddressService service = new StudentAddressService();
        exportvillageNow = service.getCountVillageNow();
        view.showTableVillageNow(exportvillageNow);
    }

    private void exportVillageCurent() {
        String[] columns = {
            "ລຳດັບ",
            "ແຂວງ",
            "ເມືອງ",
            "ບ້ານ",
            "ຈຳນວນ",};
        JoExportExcel excel = new JoExportExcel(columns, "ບ້ານເກີດນັກຮຽນ", "ລາຍງານບ້ານເກີດນັກຮຽນ");
        Thread thread = new Thread(() -> {
            try {
                excel.showLoading("ກຳລັງສ້າງ Excel");
                exportvillageCurent.forEach(data -> {
                    excel.addRow(excel.getAutoNum(), data.getProvinceName(), data.getDistrictName(), data.getVillageName(), data.getCount());
                    excel.setSleep(exportvillageCurent.size(), 100);
                });
                excel.createExport();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                excel.closeExport(view);
            }
        });
        thread.start();
    }

    private void exportVillageNow() {
       String[] columns = {
            "ລຳດັບ",
            "ແຂວງ",
            "ເມືອງ",
            "ບ້ານ",
            "ຈຳນວນ",};
        JoExportExcel excel = new JoExportExcel(columns, "ບ້ານປະຈຸບັນນັກຮຽນ", "ລາຍງານບ້ານປະຈຸບັນນັກຮຽນ");
        Thread thread = new Thread(() -> {
            try {
                excel.showLoading("ກຳລັງສ້າງ Excel");
                exportvillageNow.forEach(data -> {
                    excel.addRow(excel.getAutoNum(), data.getProvinceName(), data.getDistrictName(), data.getVillageName(), data.getCount());
                    excel.setSleep(exportvillageNow.size(), 100);
                });
                excel.createExport();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                excel.closeExport(view);
            }
        });
        thread.start();
    }

}
