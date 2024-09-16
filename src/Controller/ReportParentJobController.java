package Controller;

import Chart.PieChartUI;
import Chart.PieChartUIModel;
import Component.BarChart;
import DAOSevervice.StudentHistoryService;
import Model.ChartParentJobModel;
import Model.GlobalDataModel;
import Tools.JoHookEvent;
import Utility.JoExportExcel;
import Utility.chart.ModelChart;
import View.ReportParentJobView;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ReportParentJobController implements JoMVC, ActionListener, ChangeListener {

    private final ReportParentJobView view;
    List<ChartParentJobModel> exportData1;
    List<ChartParentJobModel> exportData2;

    public ReportParentJobController(ReportParentJobView view) {
        this.view = view;
        exportData1 = new ArrayList<>();
        exportData2 = new ArrayList<>();
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.updateButtonStateSwitchParent1();
        view.updateButtonStateSwitchParent2();
        PiechartParent1();
        PiechartParent2();
    }

    @Override
    public void AddEvent() {
        view.getTabab().addChangeListener(this);
        view.getBtnBarchart1().addActionListener(this);
        view.getBtnBarchart2().addActionListener(this);
        view.getBtnPiechart1().addActionListener(this);
        view.getBtnPiechart2().addActionListener(this);
        view.getBtn_back().addActionListener(this);
        view.handelEport1(e -> export1());
        view.handelEport2(e -> export2());
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
        } else if (event.isEvent(view.getBtnPiechart1())) {
            PiechartParent1();
            view.updateButtonStateSwitchParent1();
        } else if (event.isEvent(view.getBtnBarchart1())) {
            BarcharParent1();
            view.updateButtonStateSwitchParent1();
        } else if (event.isEvent(view.getBtnPiechart2())) {
            PiechartParent2();
            view.updateButtonStateSwitchParent2();
        } else if (event.isEvent(view.getBtnBarchart2())) {
            BarcharParent2();
            view.updateButtonStateSwitchParent2();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTabab())) {
            if (view.getTabab().getSelectedIndex() == 0) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }

    private void PiechartParent1() {
        List<ChartParentJobModel> models = new StudentHistoryService().getChartJobs("FatherJob");
        exportData1 = models;
        PieChartUI chartUI = new PieChartUI();
        Random random = new Random();
        for (ChartParentJobModel model : models) {
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color randomColor = new Color(red, green, blue);
            if (model.getCount() > 2) {
                String name = model.getName().equals("") ? "ວ່າງເບົ່າ" : model.getName();
                chartUI.addData(new PieChartUIModel(name, model.getCount(), randomColor));
            }
        }
        view.setPiechartParent1(chartUI);
    }

    private void PiechartParent2() {
        List<ChartParentJobModel> models = new StudentHistoryService().getChartJobs("MotherJob");
        exportData2 = models;
        PieChartUI chartUI = new PieChartUI();
        Random random = new Random();
        for (ChartParentJobModel model : models) {
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color randomColor = new Color(red, green, blue);
            if (model.getCount() > 2) {
                String name = model.getName().equals("") ? "ວ່າງເບົ່າ" : model.getName();
                chartUI.addData(new PieChartUIModel(name, model.getCount(), randomColor));
            }
        }
        view.setPiechartParent2(chartUI);
    }

    private void BarcharParent1() {
        List<ChartParentJobModel> models = new StudentHistoryService().getChartJobs("FatherJob");
        BarChart barChart = new BarChart();
        barChart.setFont(new Font("Phetsarath OT", 0, 12));
        barChart.addLegend("ອາຊີບຜູ້ປົກຄອງ ຜູ້ທີ1", new Color(25, 118, 210));
        for (ChartParentJobModel model : models) {
            if (model.getCount() > 2) {
                String name = model.getName().equals("") ? "ວ່າງເບົ່າ" : model.getName();
                barChart.addData(new ModelChart(name, new double[]{model.getCount()}));
            }
        }
        view.setBarchatParent1(barChart);
    }

    private void BarcharParent2() {
        List<ChartParentJobModel> models = new StudentHistoryService().getChartJobs("MotherJob");
        BarChart barChart = new BarChart();
        barChart.setFont(new Font("Phetsarath OT", 0, 12));
        barChart.addLegend("ອາຊີບຜູ້ປົກຄອງ ຜູ້ທີ2", new Color(25, 118, 210));
        for (ChartParentJobModel model : models) {
            if (model.getCount() > 2) {
                String name = model.getName().equals("") ? "ວ່າງເບົ່າ" : model.getName();
                barChart.addData(new ModelChart(name, new double[]{model.getCount()}));
            }
        }
        view.setBarchatParent2(barChart);
    }

    private void export1() {
        String[] columns = {
            "ລຳດັບ",
            "ອາຊີບ",
            "ຈຳນວນ"
        };
        JoExportExcel excel = new JoExportExcel(columns, "ອາຊີບຜູ້ປົກຄອງທີ່ 1", "ລາຍງານອາຊີບຜູ້ປົກຄອງ 1");
        Thread thread = new Thread(() -> {
            try {
                excel.showLoading("ກຳລັງສ້າງ Excel");
                exportData1.forEach(data -> {
                    excel.addRow(excel.getAutoNum(), data.getName(), data.getCount());
                    excel.setSleep(exportData1.size(), 100);
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

    private void export2() {
        String[] columns = {
            "ລຳດັບ",
            "ອາຊີບ",
            "ຈຳນວນ"
        };
        JoExportExcel excel = new JoExportExcel(columns, "ອາຊີບຜູ້ປົກຄອງທີ່ 2", "ລາຍງານອາຊີບຜູ້ປົກຄອງ 2");
        Thread thread = new Thread(() -> {
            try {
                excel.showLoading("ກຳລັງສ້າງ Excel");
                exportData2.forEach(data -> {
                    excel.addRow(excel.getAutoNum(), data.getName(), data.getCount());
                    excel.setSleep(exportData2.size(), 100);
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
