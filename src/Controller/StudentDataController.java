package Controller;

import App.AppStudent;
import App.AppStudentData;
import App.AppStudentHistory;
import App.AppStudentVaccince;
import Model.StudentAddressModel;
import Model.StudentHistoryModel;
import Model.StudentModel;
import DAOSevervice.EthnicService;
import DAOSevervice.NationalityService;
import DAOSevervice.ReligionService;
import DAOSevervice.StudentAddressService;
import DAOSevervice.StudentHistoryService;
import DAOSevervice.StudentService;
import DAOSevervice.StudentVaccinceService;
import Tools.JoAlert;
import Tools.JoFilechooser;
import Tools.JoHookEvent;
import View.HomeView;
import View.StudentDataView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class StudentDataController implements JoMVC, ActionListener, MouseListener {

    private final StudentModel model;
    private final StudentDataView view;
    private final NationalityService nationalityService;
    private final EthnicService ethnicService;
    private final ReligionService religionService;
    private boolean openFile;
    private final JoFilechooser filechooser;
    private StudentService service;

    public StudentDataController(StudentModel model, StudentDataView view) {
        this.model = model;
        this.view = view;
        service = new StudentService();
        nationalityService = new NationalityService();
        ethnicService = new EthnicService();
        religionService = new ReligionService();
        filechooser = new JoFilechooser();
    }

    @Override
    public final void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showNationality(nationalityService.getAllNationality());
        view.showEthnic(ethnicService.getAllEthnic());
        view.showReligion(religionService.getAllReligionModel());
        if (model.getStudentID() != 0) {
            view.showStudent(model);
        } else {
            view.getTxt_StudentNo().setText(service.getAutoStudentID());
        }
    }

    @Override
    public final void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_Save().addActionListener(this);
        view.getBtn_delete().addActionListener(this);
        view.getLbl_AddImage().addMouseListener(this);
        view.getBtn_History().addActionListener(this);
        view.getBtn_Vaccine().addActionListener(this);
        view.getBtn_BrotherSister().addActionListener(this);
    }

    @Override
    public void Create() {
        model.setStudentID(0);
        model.setStudentNo(service.getAutoStudentID()); // ໄອດີອັດຕະໂນມັດ
        model.setGender(view.getRd_male().isSelected() ? 1 : 0);
        model.setStudentName(view.getTxt_name().getText());
        model.setStudentENG(view.getTxt_nameENG().getText());
        model.setNickName(view.getTxt_nickName().getText());
        model.setDateofBirth(view.getDt_dfb().getSQLDate());
        model.setDateStart(view.getDt_dateStart().getSQLDate());
        model.setDateStop(view.getDt_DateStop().getSQLDate());
        model.setPreschool(view.getTxt_Preschool().getText());
        model.setHealth(view.getRd_Strong().isSelected() ? 1 : 0);
        model.setTalent(view.getTxt_Talent().getText());
        model.setVaccinState(view.getRd_VaccinStateYes().isSelected() ? 1 : 0);
        model.setDisabled(view.getTxt_Disabled().getText());
        model.setSibling(view.getTxt_Sibling().getNumber());
        if (openFile) {
            model.setLocationFile(filechooser.getSelectedFile());
        }
        model.setGoHome(view.getCk_GoHomeYes().isSelected() ? 1 : 0);
        model.setStatus(view.getRd_Studying().isSelected() ? 0 : 1);
        model.setNationalityID(view.getCb_nationality().getKeyInt());
        model.setEthnicID(view.getCb_ethnic().getKeyInt());
        model.setReligionID(view.getCb_religion().getKeyInt());
        int respon = service.CreaterStudent(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.INSERT)) {
            AppStudentData studentData = new AppStudentData(service.getSudentLastID());
        }
    }

    @Override
    public void Update() {
        service = new StudentService();
        model.setStudentNo(view.getTxt_StudentNo().getText());
        model.setGender(view.getRd_male().isSelected() ? 1 : 0);
        model.setStudentName(view.getTxt_name().getText());
        model.setStudentENG(view.getTxt_nameENG().getText());
        model.setNickName(view.getTxt_nickName().getText());
        model.setDateofBirth(view.getDt_dfb().getSQLDate());
        model.setDateStart(view.getDt_dateStart().getSQLDate());
        model.setDateStop(view.getDt_DateStop().getSQLDate());
        model.setPreschool(view.getTxt_Preschool().getText());
        model.setHealth(view.getRd_Strong().isSelected() ? 1 : 0);
        model.setTalent(view.getTxt_Talent().getText());
        model.setVaccinState(view.getRd_VaccinStateYes().isSelected() ? 1 : 0);
        model.setDisabled(view.getTxt_Disabled().getText());
        model.setSibling(view.getTxt_Sibling().getNumber());
        if (openFile) {
            model.setLocationFile(filechooser.getSelectedFile());
        }
        model.setGoHome(view.getCk_GoHomeYes().isSelected() ? 1 : 0);
        model.setStatus(view.getRd_Studying().isSelected() ? 0 : 1);
        model.setNationalityID(view.getCb_nationality().getKeyInt());
        model.setEthnicID(view.getCb_ethnic().getKeyInt());
        model.setReligionID(view.getCb_religion().getKeyInt());
        int respon = service.UpdateStudent(model);
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(respon, JoAlert.UPDATE)) {
            AppStudentData studentData = new AppStudentData(model.getStudentID());
        }
    }

    @Override
    public void Delete() {
        StudentHistoryService historyService = new StudentHistoryService();
        StudentAddressService addressService = new StudentAddressService();
        StudentHistoryModel historyModel = historyService.getStudentHistoryByStudentID(model.getStudentID());
        StudentAddressModel addressModel = addressService.getStudentLocationByStudentID(model.getStudentID());
        StudentVaccinceService vaccinceService = new StudentVaccinceService();
        vaccinceService.getStudentVacinceAllByStudentID(model.getStudentID()).forEach(vaccince -> {
            vaccinceService.DeleteStudentVacince(vaccince);
        });
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            service.DeleteStudent(model);
            historyService.DeleteStudentHistory(historyModel);
            addressService.DeleteStudentLocation(addressModel);
            alert.messages("ລົບຂໍ້ມູນ", "ລົບຂໍ້ມູນນັກສຶກສາສຳເລັດ!", JoAlert.Icons.success);
            AppStudent student = new AppStudent();
        }
    }

    @Override
    public boolean emptyData() {
        return view.getTxt_StudentNo().TextEmpty()
                && view.getTxt_name().TextEmpty()
                && view.getTxt_nameENG().TextEmpty()
                && view.getTxt_nickName().TextEmpty()
                && view.getTxt_Sibling().TextEmpty()
                && view.getTxt_Preschool().TextEmpty()
                && view.getTxt_Talent().TextEmpty()
                && view.getDt_dfb().DateEmpty()
                && view.getDt_dateStart().DateEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppStudent student = new AppStudent();
        } else if (event.isEvent(view.getBtn_Save())) {
            if (model.getStudentID() == 0) {
                if (emptyData()) {
                    Create();
                }
            } else {
                if (emptyData()) {
                    if (view.getTxt_StudentNo().getText().equals(model.getStudentNo())) { // ກວດສອບລະຫັດເກົ່າກັບລະຫັດໃໝ່ຊ້ຳກັນ
                        Update();
                    } else {
                        if (service.getChekStudentNo(view.getTxt_StudentNo().getText())) { // ກວດສອບລະຫັດໃໝ່ຊ້ຳກັນ
                            new JoAlert().messages("ລະຫັດນັກຮຽນ", "ລະຫັດນັກຮຽນຊ້ຳກັນ", JoAlert.Icons.warning);
                        } else {
                            Update();
                        }
                    }
                }
            }
        } else if (event.isEvent(view.getBtn_delete())) {
            Delete();
        } else if (event.isEvent(view.getBtn_History())) {
            AppStudentHistory appStudentHistory = new AppStudentHistory(model.getStudentID(), 0);
        } else if (event.isEvent(view.getBtn_Vaccine())) {
            AppStudentVaccince appStudentVaccince = new AppStudentVaccince(model);
        } else if (event.isEvent(view.getBtn_BrotherSister())) {
            AppStudentHistory appStudentHistory = new AppStudentHistory(model.getStudentID(), 2);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getLbl_AddImage())) {
            filechooser.addFilter("JPG", "jpg");
            filechooser.addFilter("PNG", "png");
            openFile = filechooser.showOpenDialog(null);
            if (openFile) {
                view.showAvatar(new ImageIcon(filechooser.getSelectedFile().getAbsolutePath()));
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
