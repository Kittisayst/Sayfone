package Controller;

import DAOSevervice.SayfoneService;
import DAOSevervice.StudentKnowService;
import Model.GlobalDataModel;
import Model.SayfoneModel;
import Model.StudentKnowModel;
import Utility.JoExportExcel;
import View.ReportStudentKnowView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReportStudentKnowController implements JoMVC {

    private ReportStudentKnowView View;
    private StudentKnowService service = new StudentKnowService();
    private List<StudentKnowModel> models;

    public ReportStudentKnowController(ReportStudentKnowView View) {
        this.View = View;
        models = new ArrayList<>();
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(View);
        models = service.getCount();
        View.showChart(models);
    }

    @Override
    public void AddEvent() {
        View.handelBack((e) -> GlobalDataModel.rootView.showDashbord());
        View.handelExport(e -> eportExcel());
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

    private void eportExcel() {
        String[] columns = {
            "ລຳດັບ",
            "ລາຍການ",
            "ຈຳນວນ",};
        JoExportExcel excel = new JoExportExcel(columns, "ຮູ້ຈັກໂຮງຮຽນສາຍຝົນ", "ລາຍງານຮູ້ຈັກໂຮງຮຽນສາຍຝົນ");
        Thread thread = new Thread(() -> {
            try {
                excel.showLoading("ກຳລັງສ້າງ Excel");
                models.forEach(data -> {
                    excel.addRow(excel.getAutoNum(), getKnowName(data.getKnowIndex()), data.getStudentID());
                    excel.setSleep(models.size(), 100);
                });
                excel.createExport();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                excel.closeExport(View);
            }
        });
        thread.start();
    }

    private String getKnowName(int index) {
        try {
            SayfoneModel model = new SayfoneService().getById(2);
            String str = model.getEnglish();
            String[] array = str.substring(1, str.length() - 1).split(", ");
            List<String> result = Arrays.stream(array)
                    .map(s -> s.replaceAll("\"", ""))
                    .collect(Collectors.toList());
            return result.get(index);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "NaN";
        }
    }

}
