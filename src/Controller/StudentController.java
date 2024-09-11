package Controller;

import App.AppStudent;
import App.AppStudentData;
import Component.DialogChangeStudentNo;
import DAOSevervice.EthnicService;
import DAOSevervice.FinancialService;
import DAOSevervice.NationalityService;
import DAOSevervice.ReligionService;
import Model.StudentAddressModel;
import Model.StudentHistoryModel;
import Model.StudentModel;
import DAOSevervice.StudentAddressService;
import DAOSevervice.StudentHistoryService;
import DAOSevervice.StudentService;
import DAOSevervice.StudentVaccinceService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Tools.JoAlert;
import Tools.JoHookEvent;
import Tools.JoPopup;
import Utility.MyPopup;
import View.StudentView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.MyColor;

public class StudentController implements JoMVC, ActionListener, MouseListener, KeyListener {

    private final StudentView view;
    private final StudentService service;
    private final MyPopup popup;
    private int currentPage = 1;
    private int totalPages;

    public StudentController(StudentView view) {
        this.view = view;
        service = new StudentService();
        popup = new MyPopup();
        popup.addMenuItem("ປ່ຽນລະຫັດນັກຮຽນ", GoogleMaterialDesignIcons.ASSIGNMENT_IND, MyColor.Info);
    }

    @Override
    public final void Start() {
        GlobalDataModel.rootView.setView(view);
        totalPages = service.getTotalPages();
        int pages = (int) Math.ceil((double) service.getStudentCount() / 25);
        view.showCurrentPage(currentPage, pages);
        view.showStudent(service.getStudentPagination(currentPage, 25));
        view.showYear();
        view.showClass();
        view.showRoom();
    }

    @Override
    public final void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_Add().addActionListener(this);
        view.getBtnPrevious().addActionListener(this);
        view.getBtnNext().addActionListener(this);
        view.getTb_data().addMouseListener(this);
        view.getBtnSeach().addActionListener(this);
        view.getTxtCurrentPage().addKeyListener(this);
        popup.addActionListener(this);
        view.handelChangeClass(e -> view.showRoom());
        view.handelChangeYear(e -> view.showRoom());
        view.handelFilter(e -> showFilterStudnet());
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
        int StudentID = view.getTb_data().getIntValue(1);
        StudentModel model = service.getStudentById(StudentID);
        StudentHistoryService historyService = new StudentHistoryService();
        StudentHistoryModel historyModel = historyService.getStudentHistoryByStudentID(StudentID);
        StudentAddressService addressService = new StudentAddressService();
        StudentAddressModel addressModel = addressService.getStudentLocationByStudentID(StudentID);
        StudentVaccinceService vaccinceService = new StudentVaccinceService();
        vaccinceService.getStudentVacinceAllByStudentID(StudentID).forEach(vaccince -> {
            vaccinceService.DeleteStudentVacince(vaccince);
        });
        JoAlert alert = new JoAlert();
        if (alert.JoSubmitDelete()) {
            int isdelete = service.DeleteStudent(model);
            if (isdelete == 1) {
                alert.messages("ລົບຂໍ້ມູນ", "ລົບຂໍ້ມູນນັກຮຽນສຳເລັດ!", JoAlert.Icons.success);
                historyService.DeleteStudentHistory(historyModel);
                addressService.DeleteStudentLocation(addressModel);
                AppStudent appStudent = new AppStudent();
            }
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
            AppStudentData studentData = new AppStudentData();
        } else if (event.isEvent(view.getBtnPrevious())) {
            navigatePrevious();
        } else if (event.isEvent(view.getBtnNext())) {
            navigateNext();
        } else if (event.isEvent(view.getBtnSeach())) {
            search();
        } else if (event.isEvent(popup.getItemshow())) {
            StudentService studentService = new StudentService();
            StudentModel model = studentService.getStudentById(view.getTb_data().getIntValue(1));
            String NationalyName = new NationalityService().getNationalityById(model.getNationalityID()).getNationalityName();
            String ReligionName = new ReligionService().getReligionModelById(model.getReligionID()).getReligionName();
            String EthnicName = new EthnicService().getEthnicById(model.getEthnicID()).getEthnicName();
            String[] students = new String[]{
                "ລະຫັດນັກຮຽນ: " + model.getStudentNo() + "   ຊື່ ແລະ ນາມສະກຸນ: " + model.getFullName(),
                "ຊື່ ແລະ ນາມສະກຸນ (ອັງກິດ): " + model.getStudentENG() + "   ຊື່ຫຼີ້ນ: " + model.getNickName(),
                "ວັນເດືອນປີເກີດ: " + model.getDateofBirth() + "   ອ້າຍນ້ອງທັງໝົດ: " + model.getSibling(),
                "ໂຮງຮຽນທີ່ຜ່ານມາລ່າສຸດ: " + model.getPreschool() + "   ຄວາມສາມາດພິເສດ: " + model.getTalent(),
                "ວັນທີ່ເລີ່ມຮຽນ: " + model.getDateStart() + "   ວັນທີ່ອອກຮຽນ: " + model.getDateStop(),
                "ສະຖານະນັກຮຽນ: " + model.getStatusName() + "   ສຸກຂະພາບ: " + model.getHealthName(),
                "ສັກຢາກັນພະຍາດ: " + model.getVucinStateName() + "   ພິການ: " + model.getDisabled() + "   ອະນຸຍາດ ໃຫ້ກັບເຮືອນຕອນທ່ຽງ " + model.getGohomeName(),
                "ສັນຊາດ: " + NationalyName + "   ສາດສະໜາ: " + ReligionName + "   ຊົນເຜົ່າ: " + EthnicName,};
            JoAlert alert = new JoAlert();
            alert.messages("ຂໍ້ມູນນັກຮຽນ", students, JoAlert.Icons.info);
        } else if (event.isEvent(popup.getItemEdit())) {
            int StudentID = view.getTb_data().getIntValue(1);
            AppStudentData studentData = new AppStudentData(StudentID);
        } else if (event.isEvent(popup.getItemDelete())) {
            Delete();
        } else if (event.isEvent(popup.getMenuItem(3))) {
            int StudentID = view.getTb_data().getIntValue(1);
            String No = view.getTb_data().getValue(2);
            DialogChangeStudentNo changeStudentNo = new DialogChangeStudentNo(GlobalDataModel.rootView, true, StudentID, No, view.getTb_data());
            changeStudentNo.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                int StudentID = view.getTb_data().getIntValue(1);
                AppStudentData studentData = new AppStudentData(StudentID);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTxtCurrentPage())) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                currentText();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void navigatePrevious() {
        if (currentPage > 1) {
            currentPage--;
            view.showCurrentPage(currentPage, totalPages);
            view.showStudent(service.getStudentPagination(currentPage, 25));
        }
    }

    private void currentText() {
        totalPages = service.getTotalPages();
        currentPage = view.getTxtCurrentPage().getNumber();
        if (currentPage <= totalPages && currentPage >= 1) {
            view.showCurrentPage(currentPage, totalPages);
            view.showStudent(service.getStudentPagination(currentPage, 25));
        }
    }

    private void navigateNext() {
        totalPages = service.getTotalPages();
        if (currentPage < totalPages) {
            currentPage++;
            view.showCurrentPage(currentPage, totalPages);
            view.showStudent(service.getStudentPagination(currentPage, 25));
        }
    }

    private void search() {
        String searchTerm = view.getTxtSearch().getText().trim();
        if (!searchTerm.isEmpty()) {
            view.showStudent(service.getSearchStudent(searchTerm));
        } else {
            view.showStudent(service.getStudentPagination(currentPage, 25));
        }
    }

    private void showFilterStudnet() {
        FinancialService financialService = new FinancialService();
        List<StudentModel> studentList = new ArrayList<>();
        List<FinancialModel> models = financialService.getStudentRegistered(view.RegisterID());
        models.forEach(data -> {
            studentList.add(service.getStudentById(data.getStudentID()));
        });
        view.showStudent(studentList);
    }

}
