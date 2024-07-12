package Controller;

import DAOSevervice.SayfoneService;
import Model.GlobalDataModel;
import Model.SayfoneModel;
import View.StudentNkowView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentNkowController implements JoMVC {

    private StudentNkowView view;

    public StudentNkowController(StudentNkowView view) {
        this.view = view;
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        SayfoneService service = new SayfoneService();
        SayfoneModel model = service.getById(2);
        String str = model.getEnglish();
        String[] array = str.substring(1, str.length() - 1).split(", ");
        List<String> result = Arrays.stream(array)
                .map(s -> s.replaceAll("\"", ""))
                .collect(Collectors.toList());
        view.showList(result);
    }

    @Override
    public void AddEvent() {
        view.handelAdd(e -> handelAdd());
        view.handelBack(e -> handleback());
    }

    private void handelAdd() {
        if (view.isText()) {
            view.addList(view.getText());
            new SayfoneService().updateStudentNkow(view.getData());
        }
    }

    private void handleback() {
        GlobalDataModel.rootView.showDashbord();
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
