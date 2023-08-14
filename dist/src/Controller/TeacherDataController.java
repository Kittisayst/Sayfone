package Controller;

import App.AppTeacher;
import App.AppTeacherData;
import App.AppTeacherHistory;
import App.AppTeacherOutstanding;
import App.AppTeacherVaccin;
import Model.TeacherAddressModel;
import DAOSevervice.TeacherAddressService;
import Model.TeacherHistoryModel;
import Model.TeacherModel;
import DAOSevervice.ClassService;
import DAOSevervice.EthnicService;
import DAOSevervice.NationalityService;
import DAOSevervice.ReligionService;
import DAOSevervice.TeacherEducationService;
import DAOSevervice.TeacherExperienceService;
import DAOSevervice.TeacherFileService;
import DAOSevervice.TeacherHistoryService;
import DAOSevervice.TeacherOutStandingService;
import DAOSevervice.TeacherService;
import DAOSevervice.TeacherVaccinService;
import Tools.JoAlert;
import Tools.JoFilechooser;
import Tools.JoHookEvent;
import View.HomeView;
import View.TeacherDataView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class TeacherDataController implements JoMVC, ActionListener, MouseListener {

    private final TeacherDataView view;
    private final TeacherModel teacherModel;
    private final ClassService classService;
    private final NationalityService nationalityService;
    private final ReligionService religionService;
    private final EthnicService ethnicService;
    private final JoFilechooser filechooser;
    private boolean IsSelectFile;

    public TeacherDataController(TeacherDataView view, TeacherModel teacherModel) {
        this.view = view;
        this.teacherModel = teacherModel;
        filechooser = new JoFilechooser();
        classService = new ClassService();
        nationalityService = new NationalityService();
        religionService = new ReligionService();
        ethnicService = new EthnicService();
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showClass(classService.getAllClass());
        view.showNationality(nationalityService.getAllNationality());
        view.showReligion(religionService.getAllReligionModel());
        view.showEthnic(ethnicService.getAllEthnic());
        if (teacherModel.getTeacherID() != 0) {
            view.showTeacher(teacherModel);
        }
    }

    @Override
    public final void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_Save().addActionListener(this);
        view.getBtn_delete().addActionListener(this);
        view.getLbl_AddImage().addMouseListener(this);
        view.getBtn_History().addActionListener(this);
        view.getBtn_Outstanding().addActionListener(this);
        view.getBtn_Vaccine().addActionListener(this);
    }

    @Override
    public void Create() {
        teacherModel.setTeacherID(0);
        teacherModel.setNationalityID(view.getCb_nationality().getKeyInt());
        teacherModel.setEthnicID(view.getCb_ethnic().getKeyInt());
        teacherModel.setReligionID(view.getCb_religion().getKeyInt());
        teacherModel.setClassID(view.getCb_class().getKeyInt());
        teacherModel.setTeacherNo(view.getTxt_teacherNo().getText());
        teacherModel.setName(view.getTxt_name().getText());
        teacherModel.setNameENG(view.getTxt_nameENG().getText());
        teacherModel.setNickName(view.getTxt_nickName().getText());
        teacherModel.setGender(view.getRd_male().isSelected() ? 1 : 0);
        teacherModel.setDateOfBirth(view.getDt_dfb().getSQLDate());
        teacherModel.setTel(view.getTxt_tel().getText());
        teacherModel.setEmail(view.getTxt_Email().getText());
        teacherModel.setFacebook(view.getTxt_facebook().getText());
        teacherModel.setDateStart(view.getDt_dateStart().getSQLDate());
        teacherModel.setDateStop(view.getDt_DateStop().getSQLDate());
        teacherModel.setTalent(view.getTxt_talent().getText());
        teacherModel.setImage(null);
        teacherModel.setHealth(view.getRd_Strong().isSelected() ? 1 : 0);
        if (view.getRd_Complete().isSelected()) {
            teacherModel.setStatus(0);
        } else if (view.getRd_probation().isSelected()) {
            teacherModel.setStatus(1);
        } else if (view.getRd_unemployed().isSelected()) {
            teacherModel.setStatus(2);
        }
        TeacherService service = new TeacherService();
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(service.CreateTeacher(teacherModel), JoAlert.INSERT)) {
            AppTeacherData appTeacherData = new AppTeacherData(service.getTeacherById(service.getLastTeacherID()));
        }
    }

    @Override
    public void Update() {
        teacherModel.setNationalityID(view.getCb_nationality().getKeyInt());
        teacherModel.setEthnicID(view.getCb_ethnic().getKeyInt());
        teacherModel.setReligionID(view.getCb_religion().getKeyInt());
        teacherModel.setClassID(view.getCb_class().getKeyInt());
        teacherModel.setTeacherNo(view.getTxt_teacherNo().getText());
        teacherModel.setName(view.getTxt_name().getText());
        teacherModel.setNameENG(view.getTxt_nameENG().getText());
        teacherModel.setNickName(view.getTxt_nickName().getText());
        teacherModel.setGender(view.getRd_male().isSelected() ? 1 : 0);
        teacherModel.setDateOfBirth(view.getDt_dfb().getSQLDate());
        teacherModel.setTel(view.getTxt_tel().getText());
        teacherModel.setEmail(view.getTxt_Email().getText());
        teacherModel.setFacebook(view.getTxt_facebook().getText());
        teacherModel.setDateStart(view.getDt_dateStart().getSQLDate());
        teacherModel.setDateStop(view.getDt_DateStop().getSQLDate());
        teacherModel.setTalent(view.getTxt_talent().getText());
        if (IsSelectFile) {
            teacherModel.setImageFile(filechooser.getSelectedFile());
        }
        teacherModel.setHealth(view.getRd_Strong().isSelected() ? 1 : 0);
        if (view.getRd_Complete().isSelected()) {
            teacherModel.setStatus(0);
        } else if (view.getRd_probation().isSelected()) {
            teacherModel.setStatus(1);
        } else if (view.getRd_unemployed().isSelected()) {
            teacherModel.setStatus(2);
        }
        TeacherService service = new TeacherService();
        JoAlert alert = new JoAlert();
        if (alert.JoSubmit(service.UpdateTeacher(teacherModel), JoAlert.UPDATE)) {
            AppTeacherData appTeacherData = new AppTeacherData(service.getTeacherById(teacherModel.getTeacherID()));
        }
    }

    @Override
    public void Delete() {
        int TeacherID = teacherModel.getTeacherID();
        TeacherService service = new TeacherService();
        TeacherHistoryService historyService = new TeacherHistoryService();
        TeacherAddressService addressService = new TeacherAddressService();
        TeacherEducationService educationService = new TeacherEducationService();
        TeacherExperienceService experienceService = new TeacherExperienceService();
        TeacherOutStandingService outStandingService = new TeacherOutStandingService();
        TeacherVaccinService vaccinService = new TeacherVaccinService();
        TeacherFileService fileService = new TeacherFileService();
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            //===================== Delete History ===================
            TeacherHistoryModel historyModel = historyService.getTeacherHistoryByTeacherId(TeacherID);
            historyService.DeleteTeacherHistory(historyModel);
            //===================== Delete Address =================
            TeacherAddressModel addressModel = addressService.getTeacherAddressById(TeacherID);
            addressService.DeleteTeacherAddress(addressModel);
            //===================== Delete Education ================
            educationService.getALLByTeacherID(TeacherID).forEach(educationModel -> {
                educationService.DeleteTeacherEducation(educationModel);
            });
            //================== Dlete Experience ================
            experienceService.getAllExperienceByTeacherID(TeacherID).forEach(experienceModel -> {
                experienceService.DeleteExperience(experienceModel);
            });
            //================= Delete File ===================
            fileService.getAllTeacherFileByTeacherID(TeacherID).forEach(fileModel -> {
                fileService.DeleteTeacherFile(fileModel);
            });
            //=============== Deletet OutStanding ================
            outStandingService.getAllByTeacherID(TeacherID).forEach(outstanding -> {
                outStandingService.DeleteTeacherOutstanding(outstanding);
            });
            //=============== Delete Vaccince ================
            vaccinService.getTeacherVaccinAllByTeacherID(TeacherID).forEach(vaccince -> {
                vaccinService.DeleteTeacherVaccin(vaccince);
            });

            //============ Delete Teacher Data =================
            int respon = service.DeleteTeacher(teacherModel);
            alert.messages("ລົບຂໍ້", "ລົບຂໍ້ມູນອຈານສຳເລັດ", JoAlert.Icons.success);
            AppTeacher appTeacher = new AppTeacher();
        }
    }

    @Override
    public boolean emptyData() {
        return view.getTxt_teacherNo().TextEmpty()
                && view.getTxt_name().TextEmpty()
                && view.getTxt_nameENG().TextEmpty()
                && view.getTxt_nickName().TextEmpty()
                && view.getTxt_tel().TextEmpty()
                && view.getDt_dfb().DateEmpty()
                && view.getDt_dateStart().DateEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            AppTeacher appTeacher = new AppTeacher();
        } else if (event.isEvent(view.getBtn_Save())) {
            if (teacherModel.getTeacherID() == 0) {
                if (emptyData()) {
                    Create();
                }
            } else {
                if (emptyData()) {
                    Update();
                }
            }
        } else if (event.isEvent(view.getBtn_delete())) {
            Delete();
        } else if (event.isEvent(view.getBtn_History())) {
            AppTeacherHistory appTeacherHistory = new AppTeacherHistory(teacherModel, 0);
        } else if (event.isEvent(view.getBtn_Outstanding())) {
            AppTeacherOutstanding appTeacherOutstanding = new AppTeacherOutstanding(teacherModel);
        } else if (event.isEvent(view.getBtn_Vaccine())) {
            AppTeacherVaccin appTeacherVaccin = new AppTeacherVaccin(teacherModel);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        filechooser.addFilter("PNG", "png");
        filechooser.addFilter("JPG", "jpg");
        IsSelectFile = filechooser.showOpenDialog(null);
        if (IsSelectFile) {
            view.getImg_avatar().setIcon(new ImageIcon(filechooser.getSelectedFile().getAbsolutePath()));
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
