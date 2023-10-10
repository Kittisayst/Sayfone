package Controller;

import App.AppFinancial;
import App.AppFinancialRoom;
import Component.DialogChangeClassRoom;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoHookEvent;
import Tools.JoIconFont;
import Utility.MyPopup;
import View.FinancailStudentView;
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

public class FinancailStudentController implements JoMVC, ActionListener, MouseListener, KeyListener {

    private FinancailStudentView view;
    private RegisterModel registerModel;
    private int currentPage = 1;
    private int totalPages;
    private StudentService studentService;
    private boolean buttonState = true;
    private MyPopup popup;

    public FinancailStudentController(FinancailStudentView view, RegisterModel registerModel) {
        this.view = view;
        this.registerModel = registerModel;
        studentService = new StudentService();
        popup = new MyPopup();
        popup.getItemEdit().setText("ຍ້າຍຫ້ອງຮຽນ");
        popup.getItemEdit().setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.ARCHIVE, 25, MyColor.green700));
        popup.getItemDelete().setVisible(false);
    }

    @Override
    public void Start() {
        GlobalDataModel.rootView.setView(view);
        view.getBtn_Add().setEnabled(false);
        //ສະແດງນັກສຶກສາທັງໝົດ
        totalPages = studentService.getTotalPages();
        int pages = (int) Math.ceil((double) studentService.getTotalPages() / 25);
        view.showCurrentPage(currentPage, pages);
        showFilterStudentRegistered();
    }

    @Override
    public void AddEvent() {
        view.getBtn_back().addActionListener(this);
        view.getBtn_Add().addActionListener(this);
        view.getTb_data().addMouseListener(this);
        view.getBtnRegister().addActionListener(this);
        view.getBtnRegistered().addActionListener(this);
        view.getBtnPrevious().addActionListener(this);
        view.getBtnNext().addActionListener(this);
        view.getBtnSearch().addActionListener(this);
        view.getTxtCurrentPage().addKeyListener(this);
        popup.addActionListener(this);
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
            AppFinancialRoom app = new AppFinancialRoom();
            app.open();
        } else if (event.isEvent(view.getBtn_Add())) {
            StudentService studentService = new StudentService();
            StudentModel studentModel = studentService.getStudentById(view.getTb_data().getIntValue(1));
            if (studentModel.getStudentID() != 0) {
                AppFinancial app = new AppFinancial(registerModel, studentModel);
            }
        } else if (event.isEvent(view.getBtnRegister())) {
            GlobalDataModel.TableStudentRegistered = null;
            showFilterStudentRegister();
        } else if (event.isEvent(view.getBtnRegistered())) {
            showFilterStudentRegistered();
        } else if (event.isEvent(view.getBtnPrevious())) {
            navigatePrevious();
        } else if (event.isEvent(view.getBtnNext())) {
            navigateNext();
        } else if (event.isEvent(view.getBtnSearch())) {
            searchStudent();
        } else if (event.isEvent(popup.getItemshow())) {
            StudentModel studentModel = studentService.getStudentById(view.getTb_data().getIntValue(1));
            AppFinancial app = new AppFinancial(registerModel, studentModel);
        } else if (event.isEvent(popup.getItemEdit())) {
            int studentID = view.getTb_data().getIntValue(currentPage);
            DialogChangeClassRoom classRoom = new DialogChangeClassRoom(GlobalDataModel.rootView, true, registerModel, studentID);
            classRoom.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            if (e.getClickCount() == 2) {
                StudentModel studentModel = studentService.getStudentById(view.getTb_data().getIntValue(1));
                AppFinancial app = new AppFinancial(registerModel, studentModel);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JoHookEvent event = new JoHookEvent(e.getSource());
        if (event.isEvent(view.getTb_data())) {
            view.getBtn_Add().setEnabled(true);
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

    private void showFilterStudentRegister() { // ສະແດງນັກສຶກສາຍັງບໍ່ຈ່າຍຄ່າຮຽນ
        buttonState = false;
        view.setButtonState(buttonState);
        view.ClearDataTable();
        List<StudentModel> models = studentService.getSutdentNotRegister(registerModel.getYearID(), currentPage, 25);
        view.showStudentAll(models);
    }

    private void showFilterStudentRegistered() { //ສະແດງນັກສຶກສາຈ່າຈະຮຽນແລ້ວ
        FinancialService financialService = new FinancialService();
        List<StudentModel> studentList = new ArrayList<>();
        List<FinancialModel> models = financialService.getStudentRegistered(registerModel.getRegisterID());
        models.forEach(data -> {
            studentList.add(studentService.getStudentById(data.getStudentID()));
        });
        buttonState = true;
        view.setButtonState(buttonState);
        view.ClearDataTable();
        view.showStudentAll(studentList);
    }

    private void navigatePrevious() {
        GlobalDataModel.TableStudentRegistered = null;
        if (!buttonState) {
            if (currentPage > 1) {
                currentPage--;
                view.showCurrentPage(currentPage, totalPages);
                List<StudentModel> models = studentService.getSutdentNotRegister(registerModel.getYearID(), currentPage, 25);
                view.showStudentAll(models);
            }
        }
    }

    private void currentText() {
        GlobalDataModel.TableStudentRegistered = null;
        totalPages = studentService.getTotalPages();
        currentPage = view.getTxtCurrentPage().getNumber();
        if (currentPage <= totalPages && currentPage >= 1) {
            view.showCurrentPage(currentPage, totalPages);
            List<StudentModel> models = studentService.getSutdentNotRegister(registerModel.getYearID(), currentPage, 25);
            view.showStudentAll(models);
        }
    }

    private void navigateNext() {
        GlobalDataModel.TableStudentRegistered = null;
        if (!buttonState) {
            totalPages = studentService.getTotalPages();
            if (currentPage < totalPages) {
                currentPage++;
                view.showCurrentPage(currentPage, totalPages);
                List<StudentModel> models = studentService.getSutdentNotRegister(registerModel.getYearID(), currentPage, 25);
                view.showStudentAll(models);
            }
        }
    }

    private void searchStudent() {
        GlobalDataModel.TableStudentRegistered = null;
        String searchTerm = view.getTxtSearch().getText();
        if (buttonState) {
            if (!searchTerm.isEmpty()) {
                searchRegistered(searchTerm);
                System.out.println("ss");
            } else {
                showFilterStudentRegistered();
            }
        } else {
            if (!searchTerm.isEmpty()) {
                System.out.println("ddd");
                searchNotRegister(searchTerm);
            } else {
                showFilterStudentRegister();
            }
        }
    }

    private void searchNotRegister(String search) {
        view.ClearDataTable();
        List<StudentModel> models = studentService.getSearchSutdentNotRegister(registerModel.getYearID(), search);
        view.showStudentAll(models);
    }

    private void searchRegistered(String search) {
        FinancialService financialService = new FinancialService();
        List<StudentModel> studentList = new ArrayList<>();
        List<FinancialModel> models = financialService.getSearchStudentRegistered(registerModel.getRegisterID(), search);
        models.forEach(data -> {
            if (data.getMoney() > 0 || data.getTransferMoney() > 0) {
                studentList.add(studentService.getStudentById(data.getStudentID()));
            }
        });
        buttonState = true;
        view.setButtonState(buttonState);
        view.ClearDataTable();
        view.showStudentAll(studentList);
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

}
