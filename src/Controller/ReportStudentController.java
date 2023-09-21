package Controller;

import App.AppDashboard;
import DAOSevervice.EthnicService;
import DAOSevervice.FinancialService;
import DAOSevervice.NationalityService;
import DAOSevervice.RegisterService;
import DAOSevervice.ReligionService;
import DAOSevervice.StudentService;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Model.StudentModel;
import Tools.JoFileSystem;
import Tools.JoHookEvent;
import Utility.JoSheet;
import Utility.MyFormat;
import View.HomeView;
import View.PnLoading;
import View.ReportStudentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class ReportStudentController implements JoMVC, ActionListener, ItemListener {

    private ReportStudentView view;
    private List<StudentModel> studentModels;
    private StudentService studentService;
    private PnLoading loading = new PnLoading();

    public ReportStudentController(ReportStudentView view) {
        this.view = view;
        studentModels = new ArrayList<>();
        studentService = new StudentService();
    }

    @Override
    public void Start() {
        HomeView.MyRouter.setRouter(view);
        view.showYear(new YearService().getYearAll());
        view.showClassRoom(new RegisterService().getRegisterAllByYearID(view.getCbYear().getKeyInt()));
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getCbYear().addItemListener(this);
        view.getBtnSearch().addActionListener(this);
        view.getBtnExport().addActionListener(this);
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
            AppDashboard dashboard = new AppDashboard();
        } else if (event.isEvent(view.getBtnSearch())) {
            FinancialService financialService = new FinancialService();
            studentModels.clear();
            financialService.getStudentRegistered(view.getRegisterID()).forEach(data -> {
                studentModels.add(studentService.getStudentById(data.getStudentID()));
            });
            view.showStudent(studentModels);
            view.setExportState();
        } else if (event.isEvent(view.getBtnExport())) {
            Export();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getCbYear())) {
            view.showClassRoom(new RegisterService().getRegisterAllByYearID(view.getCbYear().getKeyInt()));
        }
    }

    int row = 1;

    private void Export() {
        Thread thread = new Thread(() -> {
            try {
                JoFileSystem fileSystem = new JoFileSystem();
                String genfileName = "Export" + new MyFormat().getTime(new Date(), "HH-mm-ss") + ".xls";
                String csvFile = fileSystem.getUserPath() + "/Downloads/" + genfileName;
                String[] columns = {
                    "ລຳດັບ",
                    "ລະຫັດນັກຮຽນ",
                    "ຊື່ ແລະ ນາມສະກຸນ",
                    "ຊື່ ພາສາອັງກິດ",
                    "ຊື່ຫຼີ້ນ",
                    "ເພດ",
                    "ວັນເດືອນປີເກີດ",
                    "ວັນທີເຂົ້າຮຽນ",
                    "ວັນທີອອກຮຽນ",
                    "ໂຮຮຽນກ່ອນໜ້າ",
                    "ສຸກຂະພາບ",
                    "ຄວາມສາມາດ",
                    "ການຮັບວັກຊີນ",
                    "ພິການ",
                    "ອ້າຍນ້ອງ",
                    "ກັບບ້ານ",
                    "ສັນຊາດ",
                    "ຊົນເຜົ່າ",
                    "ສາດສະໜາ",
                    "ສະຖານະ",
                    "ຜູ້ລົງບັນຊີ"
                };

                JoSheet sheet = new JoSheet(csvFile, view.getClassRoomName(), columns);
                HomeView.MyRouter.setRouter(loading);
                studentModels.forEach(data -> {
                    sheet.addRow(row++,
                            row - 1,
                            data.getStudentNo(),
                            data.getStudentName(),
                            data.getStudentENG(),
                            data.getNickName(),
                            data.getGender() == 0 ? "ຍິງ" : "ຊາຍ",
                            formatDate(data.getDateofBirth()),
                            formatDate(data.getDateStart()),
                            formatDate(data.getDateStop()),
                            data.getPreschool(),
                            data.getHealth(),
                            data.getTalent(),
                            vaccination(data.getVaccinState()),
                            data.getDisabled(),
                            data.getSibling(),
                            goHome(data.getGoHome()),
                            nationaity(data.getNationalityID()),
                            ethnic(data.getEthnicID()),
                            religion(data.getReligionID()),
                            status(data.getStatus()),
                            userCreate(data.getUserCreate())
                    );
                    int progress = (int) ((double) row / studentModels.size() * 100);
                    SwingUtilities.invokeLater(() -> {
                        loading.setValue(progress);
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ReportStudentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

                sheet.getCreateSheet();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                row = 1;
                HomeView.MyRouter.setRouter(view);
            }
        });
        thread.start();
    }

    private String formatDate(Date date) {
        MyFormat format = new MyFormat();
        return date == null ? "" : format.getDate(date);
    }

    private String goHome(int state) {
        return state == 1 ? "ໄດ້ຮັບອານຸຍາດ" : "ບໍ່ໄດ້ຮັບອານຸຍາດ";
    }

    private String vaccination(int state) {
        return state == 1 ? "ຄົບຖ້ວນ" : "ບໍ່ຄົບ";
    }

    private String nationaity(int id) {
        return new NationalityService().getNationalityById(id).getNationalityName();
    }

    private String religion(int id) {
        return new ReligionService().getReligionModelById(id).getReligionName();
    }

    private String ethnic(int id) {
        return new EthnicService().getEthnicById(id).getEthnicName();
    }

    private String status(int state) {
        switch (state) {
            case 0:
                return "ຮຽນຢູ່";
            case 1:
                return "ພັກຮຽນ";
            case 2:
                return "ປະລະການຮຽນ";
            default:
                return "";
        }
    }

    private String userCreate(int id) {
        return new UserService().getUserById(id).getFullName().toString();
    }

}
