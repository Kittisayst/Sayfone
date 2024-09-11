package View;

import Component.JoPanelMenu;
import Components.JoButtonIconfont;
import Components.JoLableIcon;
import Components.JoScrollBar;
import Model.GlobalDataModel;
import Model.TeacherModel;
import Tools.JoFrameDesign;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomeView extends javax.swing.JFrame {

    public HomeView() {
        initComponents();
        JoFrameDesign design = new JoFrameDesign(this);
        design.setIconUI(new ImageIcon(getClass().getResource("/Source/sfsc.png")));
        JoScrollBar scrollBar = new JoScrollBar(scrollMenu);
        scrollBar.setScrollSizeV(0);
        JoPanelMenu menu = new JoPanelMenu();
        menu.SetJoPanelMenu(btn_Manage, PN_Manage);
        menu.SetJoPanelMenu(btn_Service, pn_School);
        menu.SetJoPanelMenu(btn_report, pn_report);
        menu.SetJoPanelMenu(btn_Setting, pnSetting);
        int currentYear = LocalDate.now().getYear();
        lblCredit.setText("Copyright © 2020 - " + currentYear + " Codingsabay. All rights reserved.");
        btnFoodPayment.setVisible(false);

    }

    public void showUserName(TeacherModel model) {
        lbl_user.setText(model.getName());
    }

    public void showMenu(boolean isshow) {
        Pn_Menu.setVisible(isshow);
    }

    public void showBandLogo(Icon icon) {
        lblLogo.setIcon(icon);
    }

    // getter
    public JoButtonIconfont getBtn_home() {
        return btn_home;
    }

    public JoButtonIconfont getBtn_Menu() {
        return btn_Menu;
    }

    public JPanel getPn_Menu() {
        return Pn_Menu;
    }

    public JoButtonIconfont getBtn_teacher() {
        return btn_teacher;
    }

    public void showDashbord() {
        MyRouter.setRouter(GlobalDataModel.dasboardView);
    }

    public void setView(JPanel view) {
        MyRouter.setRouter(view);
    }

    public JoButtonIconfont getBtn_Student() {
        return btn_Student;
    }

    public JoButtonIconfont getBtnSubject() {
        return btnSubject;
    }

    public JoButtonIconfont getBtnSubjectTeacher() {
        return btnSubjectTeacher;
    }

    public JoButtonIconfont getBtnClass() {
        return btnClass;
    }

    public JoButtonIconfont getBtn_Service() {
        return btn_Service;
    }

    public JoButtonIconfont getBtnDocument() {
        return btnDocument;
    }

    public JoButtonIconfont getBtn_report() {
        return btn_report;
    }

    public JoButtonIconfont getBtn_Register() {
        return btn_Register;
    }

    public JoButtonIconfont getBtnFinancial() {
        return btnFinancial;
    }

    public JoButtonIconfont getBtnReportFinancial() {
        return btnReportFinancial;
    }

    public JoButtonIconfont getBtnReportStudent() {
        return btnReportStudent;
    }

    public JoLableIcon getLblTutorial() {
        return lblTutorial;
    }

    public JoButtonIconfont getBtnTeacherRank() {
        return btnTeacherRank;
    }

    public JoButtonIconfont getBtnReportPay() {
        return btnReportPay;
    }

    public JoButtonIconfont getBtnUser() {
        return btnUser;
    }

    public JoButtonIconfont getBtn_Setting() {
        return btn_Setting;
    }

    public void setLblVersion(String version) {
        lblVersion.setText("version: " + version);
    }

    public JoButtonIconfont getBtnInfo() {
        return btnInfo;
    }

    public JoButtonIconfont getBtnPrinter() {
        return btnPrinter;
    }

    public JoButtonIconfont getBtnAbsent() {
        return btnAbsent;
    }

    public JoButtonIconfont getBtnWithdraw() {
        return btnWithdraw;
    }

    public JoButtonIconfont getBtnFood() {
        return btnFood;
    }

    public JoButtonIconfont getBtnReportUserFinancial() {
        return btnReportUserFinancial;
    }

    public JoButtonIconfont getBtnReportUserClassMoney() {
        return btnReportUserClassMoney;
    }

    public JoButtonIconfont getBtnReportDiscount() {
        return btnReportDiscount;
    }

    public JoButtonIconfont getBtnReportTeacher() {
        return btnReportTeacher;
    }

    public JoButtonIconfont getBtnReportTeacherMoney() {
        return btnReportTeacherMoney;
    }

    public JoButtonIconfont getBtnPermission() {
        return btnPermission;
    }

    public JoButtonIconfont getBtnBackup() {
        return btnBackup;
    }

    public JoButtonIconfont getBtnReportStudentState() {
        return btnReportStudentState;
    }

    public JoButtonIconfont getBtnReportPayment() {
        return btnReportPayment;
    }

    public JoButtonIconfont getBtnTiming() {
        return btnTiming;
    }

    public JoButtonIconfont getBtnFoodPayment() {
        return btnFoodPayment;
    }

    public JoButtonIconfont getBtnPaymentSetting() {
        return btnPaymentSetting;
    }

    public JoButtonIconfont getBtnPayRateFood() {
        return btnPayRateFood;
    }

    public JoButtonIconfont getBtnReportParentJob() {
        return btnReportParentJob;
    }

    public JoButtonIconfont getBtnReportStudentAddress() {
        return btnReportStudentAddress;
    }

    public JoButtonIconfont getBtnReportStudentKnow() {
        return btnReportStudentKnow;
    }
    
    

    public JoButtonIconfont getBtnNkow() {
        return btnNkow;
    }

    public void setPing(String text) {
        lblPing.setText(text);
    }

    public JoButtonIconfont getBtnjob() {
        return btnjob;
    }
    
    public void handelReportStudentKnow(ActionListener listener){
        btnReportStudentKnow.addActionListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        Pn_Navbar = new javax.swing.JPanel();
        Nav_Right = new javax.swing.JPanel();
        btn_Menu = new Components.JoButtonIconfont();
        Nav_Left = new javax.swing.JPanel();
        lbl_user = new Components.JoLableIcon();
        joLable2 = new Components.JoLable();
        lblTutorial = new Components.JoLableIcon();
        Pn_Menu = new javax.swing.JPanel();
        pn_DrawerHeader = new javax.swing.JPanel();
        lblLogo = new Components.JoLabelImage();
        joLable1 = new Components.JoLable();
        pnMainSidebar = new javax.swing.JPanel();
        scrollMenu = new javax.swing.JScrollPane();
        pnSideBar = new javax.swing.JPanel();
        btn_home = new Components.JoButtonIconfont();
        btn_Manage = new Components.JoButtonIconfont();
        PN_Manage = new javax.swing.JPanel();
        btn_teacher = new Components.JoButtonIconfont();
        btn_Student = new Components.JoButtonIconfont();
        btnSubject = new Components.JoButtonIconfont();
        btnSubjectTeacher = new Components.JoButtonIconfont();
        btnUser = new Components.JoButtonIconfont();
        btnClass = new Components.JoButtonIconfont();
        btnPermission = new Components.JoButtonIconfont();
        btnNkow = new Components.JoButtonIconfont();
        btnjob = new Components.JoButtonIconfont();
        pn_School = new javax.swing.JPanel();
        btnDocument = new Components.JoButtonIconfont();
        btn_Register = new Components.JoButtonIconfont();
        btnTeacherRank = new Components.JoButtonIconfont();
        btnFinancial = new Components.JoButtonIconfont();
        btnAbsent = new Components.JoButtonIconfont();
        pn_report = new javax.swing.JPanel();
        btnReportFinancial = new Components.JoButtonIconfont();
        btnReportPay = new Components.JoButtonIconfont();
        btnReportTeacher = new Components.JoButtonIconfont();
        btnReportStudent = new Components.JoButtonIconfont();
        btnWithdraw = new Components.JoButtonIconfont();
        btnFood = new Components.JoButtonIconfont();
        btnReportUserFinancial = new Components.JoButtonIconfont();
        btnReportDiscount = new Components.JoButtonIconfont();
        btnReportTeacherMoney = new Components.JoButtonIconfont();
        btnReportUserClassMoney = new Components.JoButtonIconfont();
        btnReportStudentState = new Components.JoButtonIconfont();
        btnReportPayment = new Components.JoButtonIconfont();
        btnFoodPayment = new Components.JoButtonIconfont();
        btnPayRateFood = new Components.JoButtonIconfont();
        btnReportParentJob = new Components.JoButtonIconfont();
        btnReportStudentAddress = new Components.JoButtonIconfont();
        btnReportStudentKnow = new Components.JoButtonIconfont();
        btn_Service = new Components.JoButtonIconfont();
        btn_report = new Components.JoButtonIconfont();
        btn_Setting = new Components.JoButtonIconfont();
        pnSetting = new javax.swing.JPanel();
        btnInfo = new Components.JoButtonIconfont();
        btnPrinter = new Components.JoButtonIconfont();
        btnBackup = new Components.JoButtonIconfont();
        btnTiming = new Components.JoButtonIconfont();
        btnPaymentSetting = new Components.JoButtonIconfont();
        jPanel3 = new javax.swing.JPanel();
        pnContent = new javax.swing.JPanel();
        MyRouter = new Components.JoRouter();
        pnFooter = new javax.swing.JPanel();
        lblCredit = new Components.JoLable();
        lblVersion = new Components.JoLable();
        lblPing = new Components.JoLable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sayfone School");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        Pn_Navbar.setBackground(new java.awt.Color(25, 118, 210));
        Pn_Navbar.setLayout(new java.awt.GridLayout(1, 0));

        Nav_Right.setOpaque(false);
        Nav_Right.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btn_Menu.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.MENU);
        btn_Menu.setJocolorHover(new java.awt.Color(17, 83, 147));
        btn_Menu.setMaximumSize(new java.awt.Dimension(50, 41));
        btn_Menu.setMinimumSize(new java.awt.Dimension(40, 41));
        btn_Menu.setPreferredSize(new java.awt.Dimension(50, 41));
        Nav_Right.add(btn_Menu);

        Pn_Navbar.add(Nav_Right);

        Nav_Left.setOpaque(false);
        Nav_Left.setLayout(new java.awt.GridBagLayout());

        lbl_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_user.setText("ShowUser");
        lbl_user.setJoIconColor(new java.awt.Color(255, 255, 255));
        lbl_user.setJoIconSize(30);
        lbl_user.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_CIRCLE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        Nav_Left.add(lbl_user, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        Nav_Left.add(joLable2, gridBagConstraints);

        lblTutorial.setForeground(new java.awt.Color(255, 255, 255));
        lblTutorial.setText("ຄູ່ມື");
        lblTutorial.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N
        lblTutorial.setJoIconColor(new java.awt.Color(255, 255, 255));
        lblTutorial.setJoIconSize(20);
        lblTutorial.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_LATE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 15);
        Nav_Left.add(lblTutorial, gridBagConstraints);

        Pn_Navbar.add(Nav_Left);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel1.add(Pn_Navbar, gridBagConstraints);

        Pn_Menu.setMaximumSize(new java.awt.Dimension(0, 0));
        Pn_Menu.setMinimumSize(new java.awt.Dimension(280, 104));
        Pn_Menu.setLayout(new java.awt.GridBagLayout());

        pn_DrawerHeader.setBackground(new java.awt.Color(10, 49, 89));
        pn_DrawerHeader.setMaximumSize(new java.awt.Dimension(0, 0));
        pn_DrawerHeader.setMinimumSize(new java.awt.Dimension(320, 50));
        pn_DrawerHeader.setLayout(new java.awt.GridBagLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/bcel.png"))); // NOI18N
        lblLogo.setMinimumSize(new java.awt.Dimension(50, 50));
        lblLogo.setPreferredSize(new java.awt.Dimension(50, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pn_DrawerHeader.add(lblLogo, gridBagConstraints);

        joLable1.setForeground(new java.awt.Color(255, 255, 255));
        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joLable1.setText("Sayfone School");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 1, 20)); // NOI18N
        joLable1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        joLable1.setMaximumSize(new java.awt.Dimension(0, 0));
        joLable1.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pn_DrawerHeader.add(joLable1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        Pn_Menu.add(pn_DrawerHeader, gridBagConstraints);

        pnMainSidebar.setLayout(new java.awt.GridBagLayout());

        scrollMenu.setBorder(null);
        scrollMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollMenu.setMaximumSize(new java.awt.Dimension(0, 0));

        pnSideBar.setBackground(new java.awt.Color(15, 77, 140));
        pnSideBar.setMaximumSize(new java.awt.Dimension(0, 2147483647));
        pnSideBar.setMinimumSize(new java.awt.Dimension(0, 1298));
        pnSideBar.setLayout(new java.awt.GridBagLayout());

        btn_home.setBackground(new java.awt.Color(10, 49, 89));
        btn_home.setText("Home");
        btn_home.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_home.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.HOME);
        btn_home.setJocolorHover(new java.awt.Color(6, 32, 58));
        btn_home.setMaximumSize(new java.awt.Dimension(270, 40));
        btn_home.setMinimumSize(new java.awt.Dimension(270, 40));
        btn_home.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnSideBar.add(btn_home, gridBagConstraints);

        btn_Manage.setBackground(new java.awt.Color(10, 49, 89));
        btn_Manage.setText("ຈັດການຂໍ້ມູນ");
        btn_Manage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Manage.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.WIDGETS);
        btn_Manage.setJocolorHover(new java.awt.Color(6, 32, 58));
        btn_Manage.setMaximumSize(new java.awt.Dimension(270, 40));
        btn_Manage.setMinimumSize(new java.awt.Dimension(270, 40));
        btn_Manage.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnSideBar.add(btn_Manage, gridBagConstraints);

        btn_teacher.setText("ຈັດການຂໍ້ມູນຄຸ");
        btn_teacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_teacher.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_IND);
        btn_teacher.setMaximumSize(new java.awt.Dimension(270, 40));
        btn_teacher.setMinimumSize(new java.awt.Dimension(270, 40));
        btn_teacher.setPreferredSize(new java.awt.Dimension(270, 40));

        btn_Student.setText("ຈັດການຂໍ້ມູນນັກຮຽນ");
        btn_Student.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Student.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);
        btn_Student.setMaximumSize(new java.awt.Dimension(270, 40));
        btn_Student.setMinimumSize(new java.awt.Dimension(270, 40));
        btn_Student.setPreferredSize(new java.awt.Dimension(270, 40));

        btnSubject.setText("ຈັດການລາຍວິຊາ");
        btnSubject.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSubject.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLASS);
        btnSubject.setMaximumSize(new java.awt.Dimension(270, 40));
        btnSubject.setMinimumSize(new java.awt.Dimension(270, 40));
        btnSubject.setPreferredSize(new java.awt.Dimension(270, 40));

        btnSubjectTeacher.setText("ຈັດການວິຊາ-ຄຸສອນ");
        btnSubjectTeacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSubjectTeacher.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_LIBRARY);
        btnSubjectTeacher.setMaximumSize(new java.awt.Dimension(270, 40));
        btnSubjectTeacher.setMinimumSize(new java.awt.Dimension(270, 40));
        btnSubjectTeacher.setPreferredSize(new java.awt.Dimension(270, 40));

        btnUser.setText("ຈັດການຂໍ້ມູນຜູ້ໃຊ້ງານ");
        btnUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUser.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_CIRCLE);
        btnUser.setMaximumSize(new java.awt.Dimension(270, 40));
        btnUser.setMinimumSize(new java.awt.Dimension(270, 40));
        btnUser.setPreferredSize(new java.awt.Dimension(270, 40));

        btnClass.setText("ຂໍ້ມູນຂະແໜງ");
        btnClass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClass.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SCHOOL);
        btnClass.setMaximumSize(new java.awt.Dimension(270, 40));
        btnClass.setMinimumSize(new java.awt.Dimension(270, 40));
        btnClass.setPreferredSize(new java.awt.Dimension(270, 40));

        btnPermission.setText("ຈັດການຂໍ້ມູນສິດທິ");
        btnPermission.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPermission.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_IND);
        btnPermission.setMaximumSize(new java.awt.Dimension(270, 40));
        btnPermission.setMinimumSize(new java.awt.Dimension(270, 40));
        btnPermission.setPreferredSize(new java.awt.Dimension(270, 40));

        btnNkow.setText("ຊ່ອງທາງຮູ້ຈັກໂຮງຮຽນ");
        btnNkow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNkow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.THUMB_UP);
        btnNkow.setMaximumSize(new java.awt.Dimension(270, 40));
        btnNkow.setMinimumSize(new java.awt.Dimension(270, 40));
        btnNkow.setPreferredSize(new java.awt.Dimension(270, 40));

        btnjob.setText("ອາຊີບຜູ້ປົກຄອງ");
        btnjob.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnjob.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SUBTITLES);
        btnjob.setMaximumSize(new java.awt.Dimension(270, 40));
        btnjob.setMinimumSize(new java.awt.Dimension(270, 40));
        btnjob.setPreferredSize(new java.awt.Dimension(270, 40));

        javax.swing.GroupLayout PN_ManageLayout = new javax.swing.GroupLayout(PN_Manage);
        PN_Manage.setLayout(PN_ManageLayout);
        PN_ManageLayout.setHorizontalGroup(
            PN_ManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_ManageLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(PN_ManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_teacher, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(btn_Student, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(btnSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSubjectTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNkow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnjob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PN_ManageLayout.setVerticalGroup(
            PN_ManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_ManageLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Student, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubjectTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNkow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPermission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnSideBar.add(PN_Manage, gridBagConstraints);

        pn_School.setLayout(new java.awt.GridBagLayout());

        btnDocument.setText("ເອກະສານ");
        btnDocument.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDocument.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LIBRARY_BOOKS);
        btnDocument.setMaximumSize(new java.awt.Dimension(270, 40));
        btnDocument.setMinimumSize(new java.awt.Dimension(270, 40));
        btnDocument.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        pn_School.add(btnDocument, gridBagConstraints);

        btn_Register.setText("ເປີດການລົງທະບຽນຮຽນ");
        btn_Register.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Register.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.EVENT_AVAILABLE);
        btn_Register.setMaximumSize(new java.awt.Dimension(270, 40));
        btn_Register.setMinimumSize(new java.awt.Dimension(270, 40));
        btn_Register.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        pn_School.add(btn_Register, gridBagConstraints);

        btnTeacherRank.setText("ຈັດອັນດັບຄູ");
        btnTeacherRank.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTeacherRank.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_PLAY);
        btnTeacherRank.setMaximumSize(new java.awt.Dimension(270, 40));
        btnTeacherRank.setMinimumSize(new java.awt.Dimension(270, 40));
        btnTeacherRank.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_School.add(btnTeacherRank, gridBagConstraints);

        btnFinancial.setText("ຈ່າຍຄ່າຮຽນ");
        btnFinancial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFinancial.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.MONETIZATION_ON);
        btnFinancial.setMaximumSize(new java.awt.Dimension(270, 40));
        btnFinancial.setMinimumSize(new java.awt.Dimension(270, 40));
        btnFinancial.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pn_School.add(btnFinancial, gridBagConstraints);

        btnAbsent.setText("ບັນທຶກການຂາດຮຽນ");
        btnAbsent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAbsent.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_TURNED_IN);
        btnAbsent.setMaximumSize(new java.awt.Dimension(270, 40));
        btnAbsent.setMinimumSize(new java.awt.Dimension(270, 40));
        btnAbsent.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_School.add(btnAbsent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnSideBar.add(pn_School, gridBagConstraints);

        pn_report.setMaximumSize(new java.awt.Dimension(0, 0));
        pn_report.setMinimumSize(new java.awt.Dimension(250, 0));
        pn_report.setLayout(new java.awt.GridBagLayout());

        btnReportFinancial.setText("ລາຍງານການຈ່າຍຄ່າຮຽນ");
        btnReportFinancial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportFinancial.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.MONETIZATION_ON);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportFinancial, gridBagConstraints);

        btnReportPay.setText("ລາຍງານຜູ້ຄ້າງຄ່າຮຽນ");
        btnReportPay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportPay.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.EVENT_BUSY);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportPay, gridBagConstraints);

        btnReportTeacher.setText("ລາຍງານສະຖິຕິຄູ");
        btnReportTeacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportTeacher.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_IND);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportTeacher, gridBagConstraints);

        btnReportStudent.setText("ລາຍງານຂໍ້ມູນນັກຮຽນ");
        btnReportStudent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportStudent.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.RECENT_ACTORS);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportStudent, gridBagConstraints);

        btnWithdraw.setText("ລາຍງານການຖອນເງິນຄືນ");
        btnWithdraw.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnWithdraw.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ROTATE_90_DEGREES_CCW);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnWithdraw, gridBagConstraints);

        btnFood.setText("ລາຍງານຄ່າອາຫານ");
        btnFood.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFood.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_DINING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnFood, gridBagConstraints);

        btnReportUserFinancial.setText("ລາຍງານການຈ່າຍຄ່າຮຽນຕາມຜູ້ໃຊ່ງານ");
        btnReportUserFinancial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportUserFinancial.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.FOLDER_SHARED);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportUserFinancial, gridBagConstraints);

        btnReportDiscount.setText("ລາຍງານສ່ວນຫຼຸດ");
        btnReportDiscount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportDiscount.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_ATM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportDiscount, gridBagConstraints);

        btnReportTeacherMoney.setText("ລາຍງານການເງິນຄູ");
        btnReportTeacherMoney.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportTeacherMoney.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SWAP_VERTICAL_CIRCLE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportTeacherMoney, gridBagConstraints);

        btnReportUserClassMoney.setText("ລາຍງານການຈ່າຍຄ່າຮຽນຕາມຫ້ອງຮຽນ");
        btnReportUserClassMoney.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportUserClassMoney.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_ATM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportUserClassMoney, gridBagConstraints);

        btnReportStudentState.setText("ລາຍງານຂໍ້ມູນນັກຮຽນທັງໝົດ");
        btnReportStudentState.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportStudentState.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportStudentState, gridBagConstraints);

        btnReportPayment.setText("ລາຍງານການຈ່າຍຄ່າຮຽນປະຈຳເດືອນ");
        btnReportPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportPayment.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.EVENT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportPayment, gridBagConstraints);

        btnFoodPayment.setText("ລາຍງານຄ່າອາຫານ V2");
        btnFoodPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFoodPayment.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_DINING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnFoodPayment, gridBagConstraints);

        btnPayRateFood.setText("ລາຍງານຜູ້ຄ້າງຄ່າອາຫານ");
        btnPayRateFood.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPayRateFood.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_DINING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnPayRateFood, gridBagConstraints);

        btnReportParentJob.setText("ລາຍງານຂໍ້ມູນສະຖິຕິອາຊີບຜູ້ປົກຄອງ");
        btnReportParentJob.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportParentJob.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportParentJob, gridBagConstraints);

        btnReportStudentAddress.setText("ລາຍງານຂໍ້ມູນສະຖິຕິທີ່ຢູ່ນັກຮຽນ");
        btnReportStudentAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportStudentAddress.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportStudentAddress, gridBagConstraints);

        btnReportStudentKnow.setText("ລາຍງານຮູ້ຈັກໂຮງຮຽນ");
        btnReportStudentKnow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportStudentKnow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pn_report.add(btnReportStudentKnow, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnSideBar.add(pn_report, gridBagConstraints);

        btn_Service.setBackground(new java.awt.Color(10, 49, 89));
        btn_Service.setText("ການຮຽນການສອນ");
        btn_Service.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Service.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_BALANCE);
        btn_Service.setJocolorHover(new java.awt.Color(6, 32, 58));
        btn_Service.setMaximumSize(new java.awt.Dimension(270, 40));
        btn_Service.setMinimumSize(new java.awt.Dimension(270, 40));
        btn_Service.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnSideBar.add(btn_Service, gridBagConstraints);

        btn_report.setBackground(new java.awt.Color(10, 49, 89));
        btn_report.setText("ລາຍງານ");
        btn_report.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_report.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.INSERT_CHART);
        btn_report.setJocolorHover(new java.awt.Color(6, 32, 58));
        btn_report.setMaximumSize(new java.awt.Dimension(270, 40));
        btn_report.setMinimumSize(new java.awt.Dimension(270, 40));
        btn_report.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnSideBar.add(btn_report, gridBagConstraints);

        btn_Setting.setBackground(new java.awt.Color(10, 49, 89));
        btn_Setting.setText("ຕັ້ງຄ່າ");
        btn_Setting.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Setting.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SETTINGS);
        btn_Setting.setJocolorHover(new java.awt.Color(6, 32, 58));
        btn_Setting.setMaximumSize(new java.awt.Dimension(270, 40));
        btn_Setting.setMinimumSize(new java.awt.Dimension(270, 40));
        btn_Setting.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        pnSideBar.add(btn_Setting, gridBagConstraints);

        pnSetting.setMaximumSize(new java.awt.Dimension(272, 2147483647));
        pnSetting.setMinimumSize(new java.awt.Dimension(272, 225));
        pnSetting.setPreferredSize(new java.awt.Dimension(272, 225));
        pnSetting.setLayout(new java.awt.GridBagLayout());

        btnInfo.setText("ຂໍ້ມູນໂຮງຮຽນສາຍຝົນ");
        btnInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInfo.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.INFO);
        btnInfo.setMaximumSize(new java.awt.Dimension(270, 40));
        btnInfo.setMinimumSize(new java.awt.Dimension(270, 40));
        btnInfo.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnSetting.add(btnInfo, gridBagConstraints);

        btnPrinter.setText("ຂໍ້ມູນປີ້ນເຕີ");
        btnPrinter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrinter.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PRINT);
        btnPrinter.setMaximumSize(new java.awt.Dimension(270, 40));
        btnPrinter.setMinimumSize(new java.awt.Dimension(270, 40));
        btnPrinter.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnSetting.add(btnPrinter, gridBagConstraints);

        btnBackup.setText("ສຳຮອງຂໍ້ມູນ");
        btnBackup.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBackup.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.BACKUP);
        btnBackup.setMaximumSize(new java.awt.Dimension(270, 40));
        btnBackup.setMinimumSize(new java.awt.Dimension(270, 40));
        btnBackup.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnSetting.add(btnBackup, gridBagConstraints);

        btnTiming.setText("ຕັ້ງເວລາຈາຍຄ່າຮຽນ");
        btnTiming.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTiming.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCESS_ALARMS);
        btnTiming.setMaximumSize(new java.awt.Dimension(270, 40));
        btnTiming.setMinimumSize(new java.awt.Dimension(270, 40));
        btnTiming.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        pnSetting.add(btnTiming, gridBagConstraints);

        btnPaymentSetting.setText("ຕັ້ງຄ່າການຈ່າຍຄ່າຮຽນ");
        btnPaymentSetting.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPaymentSetting.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.MONETIZATION_ON);
        btnPaymentSetting.setMaximumSize(new java.awt.Dimension(270, 40));
        btnPaymentSetting.setMinimumSize(new java.awt.Dimension(270, 40));
        btnPaymentSetting.setPreferredSize(new java.awt.Dimension(270, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnSetting.add(btnPaymentSetting, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pnSideBar.add(pnSetting, gridBagConstraints);

        jPanel3.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel3.setMinimumSize(new java.awt.Dimension(250, 0));
        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnSideBar.add(jPanel3, gridBagConstraints);

        scrollMenu.setViewportView(pnSideBar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnMainSidebar.add(scrollMenu, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        Pn_Menu.add(pnMainSidebar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(Pn_Menu, gridBagConstraints);

        pnContent.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 2);
        pnContent.add(MyRouter, gridBagConstraints);

        pnFooter.setBackground(new java.awt.Color(25, 118, 210));
        pnFooter.setMinimumSize(new java.awt.Dimension(0, 40));
        pnFooter.setPreferredSize(new java.awt.Dimension(0, 40));
        pnFooter.setLayout(new java.awt.GridBagLayout());

        lblCredit.setForeground(new java.awt.Color(255, 255, 255));
        lblCredit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCredit.setText("credit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnFooter.add(lblCredit, gridBagConstraints);

        lblVersion.setForeground(new java.awt.Color(255, 255, 255));
        lblVersion.setText("version 1.0.5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 15);
        pnFooter.add(lblVersion, gridBagConstraints);

        lblPing.setForeground(new java.awt.Color(255, 255, 255));
        lblPing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPing.setText("Ping");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pnFooter.add(lblPing, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnContent.add(pnFooter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(pnContent, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1380, 805));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoRouter MyRouter;
    private javax.swing.JPanel Nav_Left;
    private javax.swing.JPanel Nav_Right;
    private javax.swing.JPanel PN_Manage;
    private javax.swing.JPanel Pn_Menu;
    private javax.swing.JPanel Pn_Navbar;
    private Components.JoButtonIconfont btnAbsent;
    private Components.JoButtonIconfont btnBackup;
    private Components.JoButtonIconfont btnClass;
    private Components.JoButtonIconfont btnDocument;
    private Components.JoButtonIconfont btnFinancial;
    private Components.JoButtonIconfont btnFood;
    private Components.JoButtonIconfont btnFoodPayment;
    private Components.JoButtonIconfont btnInfo;
    private Components.JoButtonIconfont btnNkow;
    private Components.JoButtonIconfont btnPayRateFood;
    private Components.JoButtonIconfont btnPaymentSetting;
    private Components.JoButtonIconfont btnPermission;
    private Components.JoButtonIconfont btnPrinter;
    private Components.JoButtonIconfont btnReportDiscount;
    private Components.JoButtonIconfont btnReportFinancial;
    private Components.JoButtonIconfont btnReportParentJob;
    private Components.JoButtonIconfont btnReportPay;
    private Components.JoButtonIconfont btnReportPayment;
    private Components.JoButtonIconfont btnReportStudent;
    private Components.JoButtonIconfont btnReportStudentAddress;
    private Components.JoButtonIconfont btnReportStudentKnow;
    private Components.JoButtonIconfont btnReportStudentState;
    private Components.JoButtonIconfont btnReportTeacher;
    private Components.JoButtonIconfont btnReportTeacherMoney;
    private Components.JoButtonIconfont btnReportUserClassMoney;
    private Components.JoButtonIconfont btnReportUserFinancial;
    private Components.JoButtonIconfont btnSubject;
    private Components.JoButtonIconfont btnSubjectTeacher;
    private Components.JoButtonIconfont btnTeacherRank;
    private Components.JoButtonIconfont btnTiming;
    private Components.JoButtonIconfont btnUser;
    private Components.JoButtonIconfont btnWithdraw;
    private Components.JoButtonIconfont btn_Manage;
    private Components.JoButtonIconfont btn_Menu;
    private Components.JoButtonIconfont btn_Register;
    private Components.JoButtonIconfont btn_Service;
    private Components.JoButtonIconfont btn_Setting;
    private Components.JoButtonIconfont btn_Student;
    private Components.JoButtonIconfont btn_home;
    private Components.JoButtonIconfont btn_report;
    private Components.JoButtonIconfont btn_teacher;
    private Components.JoButtonIconfont btnjob;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable lblCredit;
    private Components.JoLabelImage lblLogo;
    private Components.JoLable lblPing;
    private Components.JoLableIcon lblTutorial;
    private Components.JoLable lblVersion;
    private Components.JoLableIcon lbl_user;
    private javax.swing.JPanel pnContent;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPanel pnMainSidebar;
    private javax.swing.JPanel pnSetting;
    private javax.swing.JPanel pnSideBar;
    private javax.swing.JPanel pn_DrawerHeader;
    private javax.swing.JPanel pn_School;
    private javax.swing.JPanel pn_report;
    private javax.swing.JScrollPane scrollMenu;
    // End of variables declaration//GEN-END:variables
}
