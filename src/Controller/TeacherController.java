package Controller;

import App.AppTeacher;
import App.AppTeacherData;
import Model.ClassModel;
import Model.TeacherAddressModel;
import DAOSevervice.TeacherAddressService;
import Model.TeacherHistoryModel;
import Model.TeacherModel;
import DAOSevervice.ClassService;
import DAOSevervice.TeacherEducationService;
import DAOSevervice.TeacherExperienceService;
import DAOSevervice.TeacherFileService;
import DAOSevervice.TeacherHistoryService;
import DAOSevervice.TeacherOutStandingService;
import DAOSevervice.TeacherService;
import DAOSevervice.TeacherVaccinService;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Tools.JoPopup;
import View.TeacherView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TeacherController implements JoMVC, ActionListener, MouseListener {

    private final TeacherView view;
    private final TeacherService teacherService;
    private final JoPopup popup;

    public TeacherController(TeacherView view, TeacherService teacherService) {
        this.view = view;
        this.teacherService = teacherService;
        popup = new JoPopup();
        Start();
        AddEvent();
    }

    @Override
    public final void Start() {
        GlobalDataModel.rootView.setView(view);
        view.showTeacher(teacherService.getAllTeacher());
    }

    @Override
    public final void AddEvent() {
        popup.addActionListener(this);
        view.getBtn_back().addActionListener(this);
        view.getBtn_Add().addActionListener(this);
        view.getTb_data().addMouseListener(this);
    }

    @Override
    public void Create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete() {
        int TeacherID = view.getTb_data().getIntValue(1);
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
            TeacherModel model = teacherService.getTeacherById(TeacherID);
            int respon = service.DeleteTeacher(model);
            alert.messages("ລົບຂໍ້", "ລົບຂໍ້ມູນອຈານສຳເລັດ", JoAlert.Icons.success);
            AppTeacher appTeacher = new AppTeacher();
        }
    }

    @Override
    public boolean emptyData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getBtn_back())) {
            GlobalDataModel.rootView.showDashbord();
        } else if (event.isEvent(view.getBtn_Add())) {
            AppTeacherData appTeacherData = new AppTeacherData();
        } else if (event.isEvent(popup.getItemshow())) {
            int teacherID = view.getTb_data().getIntValue(1);
            TeacherModel model = teacherService.getTeacherById(teacherID);
            ClassService classService = new ClassService();
            ClassModel classModel = classService.getClassById(model.getClassID());
            String[] ms = new String[]{
                "ເລກທີ່ພະນັກງານ: " + model.getTeacherNo() + "    ຊື່ ແລະ ນາມສະກຸນ: " + model.getFullName().toString(),
                "ຊື່ ແລະ ນາມສະກຸນ (ອັງກິດ): " + model.getNameENG() + "   ຊື່ຫຼີ້ນ: " + model.getNickName(),
                "ວັນເດືອນປີເກີດ: " + model.getDateOfBirth() + "   ເບີໂທລະສັບ: " + model.getTel(),
                "Email: " + model.getEmail() + "    Facebook: " + model.getFacebook(),
                "ຄູສອນຊັ້ນຮຽນ: " + classModel.getClassName() + "    ສະຖານະພະນັກງານ: " + model.getStatusName(),
                "ສຸກຂະພາບ: " + model.getHealthName() + "    ຄວາມສາມາດພິເສດ: " + model.getTalent(),
                "ສັນຊາດ: " + model.getNationalityID() + "    ສາດສະໜາ: " + model.getReligionID() + "    ຊົນເຜົ່າ: " + model.getEthnicID(),
                "ວັນທີ່ເລີ່ມເຮັດວຽກ: " + model.getDateStart() + "   ວັນທີ່ຍຸດເຮັດວຽກ" + model.getDateStop()};
            JoAlert alert = new JoAlert();
            alert.messages("ຂໍ້ມູນຄູສອນ", ms, JoAlert.Icons.info);
        } else if (event.isEvent(popup.getItemEdit())) {
            int teacherID = view.getTb_data().getIntValue(1);
            AppTeacherData appTeacherData = new AppTeacherData(teacherService.getTeacherById(teacherID));
        } else if (event.isEvent(popup.getItemDelete())) {
            Delete();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                int teacherID = view.getTb_data().getIntValue(1);
                AppTeacherData appTeacherData = new AppTeacherData(teacherService.getTeacherById(teacherID));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            popup.ShowPopup(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
