package View;

import Component.JoPanelMenu;
import Components.JoButtonIconfont;
import Components.JoLable;
import Components.JoLableIcon;
import Components.JoRouter;
import Components.JoScrollBar;
import Model.TeacherModel;
import Tools.JoFrameDesign;
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

    public static JoRouter getMyRouter() {
        return MyRouter;
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

    public JoLable getLblVersion() {
        return lblVersion;
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
        lblVersion = new Components.JoLable();
        MyRouter = new Components.JoRouter();
        Pn_Menu = new javax.swing.JPanel();
        pn_DrawerHeader = new javax.swing.JPanel();
        lblLogo = new Components.JoLabelImage();
        joLable1 = new Components.JoLable();
        jPanel2 = new javax.swing.JPanel();
        scrollMenu = new javax.swing.JScrollPane();
        pnSideBar = new javax.swing.JPanel();
        btn_home = new Components.JoButtonIconfont();
        btn_Manage = new Components.JoButtonIconfont();
        PN_Manage = new javax.swing.JPanel();
        btn_teacher = new Components.JoButtonIconfont();
        joButtonIconfont4 = new Components.JoButtonIconfont();
        btn_Student = new Components.JoButtonIconfont();
        btnSubject = new Components.JoButtonIconfont();
        btnSubjectTeacher = new Components.JoButtonIconfont();
        btnUser = new Components.JoButtonIconfont();
        btnClass = new Components.JoButtonIconfont();
        pn_School = new javax.swing.JPanel();
        joButtonIconfont6 = new Components.JoButtonIconfont();
        btn_Register = new Components.JoButtonIconfont();
        btnTeacherRank = new Components.JoButtonIconfont();
        btnFinancial = new Components.JoButtonIconfont();
        btnAbsent = new Components.JoButtonIconfont();
        pn_report = new javax.swing.JPanel();
        btnReportFinancial = new Components.JoButtonIconfont();
        btnReportPay = new Components.JoButtonIconfont();
        joButtonIconfont13 = new Components.JoButtonIconfont();
        joButtonIconfont11 = new Components.JoButtonIconfont();
        joButtonIconfont10 = new Components.JoButtonIconfont();
        btnWithdraw = new Components.JoButtonIconfont();
        btnFood = new Components.JoButtonIconfont();
        btnReportUserFinancial = new Components.JoButtonIconfont();
        btn_Service = new Components.JoButtonIconfont();
        btn_report = new Components.JoButtonIconfont();
        btn_Setting = new Components.JoButtonIconfont();
        pnSetting = new javax.swing.JPanel();
        btnInfo = new Components.JoButtonIconfont();
        btnPrinter = new Components.JoButtonIconfont();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sayfonschool");
        setExtendedState(MAXIMIZED_BOTH);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

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

        lblVersion.setForeground(new java.awt.Color(255, 255, 255));
        lblVersion.setText("version 1.0.5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        Nav_Left.add(lblVersion, gridBagConstraints);

        Pn_Navbar.add(Nav_Left);

        pn_DrawerHeader.setBackground(new java.awt.Color(10, 49, 89));
        pn_DrawerHeader.setPreferredSize(new java.awt.Dimension(249, 50));

        joLable1.setForeground(new java.awt.Color(255, 255, 255));
        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joLable1.setText("Sayfoneschool");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 1, 20)); // NOI18N
        joLable1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pn_DrawerHeaderLayout = new javax.swing.GroupLayout(pn_DrawerHeader);
        pn_DrawerHeader.setLayout(pn_DrawerHeaderLayout);
        pn_DrawerHeaderLayout.setHorizontalGroup(
            pn_DrawerHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DrawerHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pn_DrawerHeaderLayout.setVerticalGroup(
            pn_DrawerHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_DrawerHeaderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pn_DrawerHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel2.setLayout(new java.awt.BorderLayout());

        scrollMenu.setBorder(null);
        scrollMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnSideBar.setBackground(new java.awt.Color(15, 77, 140));

        btn_home.setBackground(new java.awt.Color(10, 49, 89));
        btn_home.setText("Home");
        btn_home.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_home.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.HOME);
        btn_home.setJocolorHover(new java.awt.Color(6, 32, 58));

        btn_Manage.setBackground(new java.awt.Color(10, 49, 89));
        btn_Manage.setText("ຈັດການຂໍ້ມູນ");
        btn_Manage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Manage.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.WIDGETS);
        btn_Manage.setJocolorHover(new java.awt.Color(6, 32, 58));

        btn_teacher.setText("ຈັດການຂໍ້ມູນອາຈານ");
        btn_teacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_teacher.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_IND);

        joButtonIconfont4.setText("menu");
        joButtonIconfont4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joButtonIconfont4.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.NFC);

        btn_Student.setText("ຈັດການຂໍ້ມູນນັກຮຽນ");
        btn_Student.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Student.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);

        btnSubject.setText("ຈັດການລາຍວິຊາ");
        btnSubject.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSubject.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLASS);

        btnSubjectTeacher.setText("ຈັດການວິຊາ-ຄຸສອນ");
        btnSubjectTeacher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSubjectTeacher.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_LIBRARY);

        btnUser.setText("ຈັດການຂໍ້ມູນຜູ້ໃຊ້ງານ");
        btnUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUser.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_CIRCLE);

        btnClass.setText("ຂໍ້ມູນຂະແໜງ");
        btnClass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClass.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SCHOOL);

        javax.swing.GroupLayout PN_ManageLayout = new javax.swing.GroupLayout(PN_Manage);
        PN_Manage.setLayout(PN_ManageLayout);
        PN_ManageLayout.setHorizontalGroup(
            PN_ManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_ManageLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(PN_ManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_teacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Student, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
            .addComponent(btnSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSubjectTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(joButtonIconfont4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(joButtonIconfont4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        joButtonIconfont6.setText("menu");
        joButtonIconfont6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joButtonIconfont6.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.NFC);

        btn_Register.setText("ເປີດການລົງທະບຽນຮຽນ");
        btn_Register.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Register.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.EVENT_AVAILABLE);

        btnTeacherRank.setText("ຈັດອັນດັບຄູ");
        btnTeacherRank.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTeacherRank.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_PLAY);

        btnFinancial.setText("ຈ່າຍຄ່າຮຽນ");
        btnFinancial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFinancial.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.MONETIZATION_ON);

        btnAbsent.setText("ບັນທຶກການຂາດຮຽນ");
        btnAbsent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAbsent.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_TURNED_IN);

        javax.swing.GroupLayout pn_SchoolLayout = new javax.swing.GroupLayout(pn_School);
        pn_School.setLayout(pn_SchoolLayout);
        pn_SchoolLayout.setHorizontalGroup(
            pn_SchoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(joButtonIconfont6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_Register, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
            .addComponent(btnTeacherRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFinancial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAbsent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_SchoolLayout.setVerticalGroup(
            pn_SchoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_SchoolLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_Register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinancial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTeacherRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbsent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joButtonIconfont6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnReportFinancial.setText("ລາຍງານການຈ່າຍຄ່າຮຽນ");
        btnReportFinancial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportFinancial.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.MONETIZATION_ON);

        btnReportPay.setText("ລາຍງານຜູ້ຄ້າງຄ່າຮຽນ");
        btnReportPay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportPay.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.EVENT_BUSY);

        joButtonIconfont13.setText("ລາຍງານສະຖິຕິຄູ");
        joButtonIconfont13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joButtonIconfont13.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ASSIGNMENT_IND);

        joButtonIconfont11.setText("ລາຍງານສະຖິດຕິນັກຮຽນ");
        joButtonIconfont11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joButtonIconfont11.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.RECENT_ACTORS);

        joButtonIconfont10.setText("menu");
        joButtonIconfont10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        joButtonIconfont10.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.NFC);

        btnWithdraw.setText("ລາຍງານການຖອນເງິນຄືນ");
        btnWithdraw.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnWithdraw.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.DIRECTIONS);

        btnFood.setText("ລາຍງານຄ່າອາຫານ");
        btnFood.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFood.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_DINING);

        btnReportUserFinancial.setText("ລາຍງານການຈ່າຍຄ່າຮຽນຕາມຜູ້ໃຊ່ງານ");
        btnReportUserFinancial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportUserFinancial.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.FOLDER_SHARED);

        javax.swing.GroupLayout pn_reportLayout = new javax.swing.GroupLayout(pn_report);
        pn_report.setLayout(pn_reportLayout);
        pn_reportLayout.setHorizontalGroup(
            pn_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(joButtonIconfont10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportFinancial, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
            .addComponent(joButtonIconfont11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(joButtonIconfont13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnWithdraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportUserFinancial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_reportLayout.setVerticalGroup(
            pn_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_reportLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnReportFinancial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportUserFinancial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joButtonIconfont13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(joButtonIconfont11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joButtonIconfont10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        btn_Service.setBackground(new java.awt.Color(10, 49, 89));
        btn_Service.setText("ການຮຽນການສອນ");
        btn_Service.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Service.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_BALANCE);
        btn_Service.setJocolorHover(new java.awt.Color(6, 32, 58));
        btn_Service.setMaximumSize(new java.awt.Dimension(125, 41));
        btn_Service.setPreferredSize(new java.awt.Dimension(125, 41));

        btn_report.setBackground(new java.awt.Color(10, 49, 89));
        btn_report.setText("ລາຍງານ");
        btn_report.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_report.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.INSERT_CHART);
        btn_report.setJocolorHover(new java.awt.Color(6, 32, 58));

        btn_Setting.setBackground(new java.awt.Color(10, 49, 89));
        btn_Setting.setText("ຕັ້ງຄ່າ");
        btn_Setting.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Setting.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SETTINGS);
        btn_Setting.setJocolorHover(new java.awt.Color(6, 32, 58));

        btnInfo.setText("ຂໍ້ມູນໂຮງຮຽນສາຍຝົນ");
        btnInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInfo.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.INFO);

        btnPrinter.setText("ຂໍ້ມູນປີ້ນເຕີ");
        btnPrinter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrinter.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PRINT);

        javax.swing.GroupLayout pnSettingLayout = new javax.swing.GroupLayout(pnSetting);
        pnSetting.setLayout(pnSettingLayout);
        pnSettingLayout.setHorizontalGroup(
            pnSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPrinter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnSettingLayout.setVerticalGroup(
            pnSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSettingLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrinter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnSideBarLayout = new javax.swing.GroupLayout(pnSideBar);
        pnSideBar.setLayout(pnSideBarLayout);
        pnSideBarLayout.setHorizontalGroup(
            pnSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSideBarLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pnSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_home, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Manage, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PN_Manage, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Service, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_School, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_report, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_report, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Setting, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
            .addGroup(pnSideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnSideBarLayout.setVerticalGroup(
            pnSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Manage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PN_Manage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Service, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_School, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_report, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        scrollMenu.setViewportView(pnSideBar);

        jPanel2.add(scrollMenu, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout Pn_MenuLayout = new javax.swing.GroupLayout(Pn_Menu);
        Pn_Menu.setLayout(Pn_MenuLayout);
        Pn_MenuLayout.setHorizontalGroup(
            Pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_DrawerHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Pn_MenuLayout.setVerticalGroup(
            Pn_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pn_MenuLayout.createSequentialGroup()
                .addComponent(pn_DrawerHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Pn_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MyRouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pn_Navbar, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Pn_Navbar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MyRouter, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
            .addComponent(Pn_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1380, 805));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static Components.JoRouter MyRouter;
    private javax.swing.JPanel Nav_Left;
    private javax.swing.JPanel Nav_Right;
    private javax.swing.JPanel PN_Manage;
    private javax.swing.JPanel Pn_Menu;
    private javax.swing.JPanel Pn_Navbar;
    private Components.JoButtonIconfont btnAbsent;
    private Components.JoButtonIconfont btnClass;
    private Components.JoButtonIconfont btnFinancial;
    private Components.JoButtonIconfont btnFood;
    private Components.JoButtonIconfont btnInfo;
    private Components.JoButtonIconfont btnPrinter;
    private Components.JoButtonIconfont btnReportFinancial;
    private Components.JoButtonIconfont btnReportPay;
    private Components.JoButtonIconfont btnReportUserFinancial;
    private Components.JoButtonIconfont btnSubject;
    private Components.JoButtonIconfont btnSubjectTeacher;
    private Components.JoButtonIconfont btnTeacherRank;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Components.JoButtonIconfont joButtonIconfont10;
    private Components.JoButtonIconfont joButtonIconfont11;
    private Components.JoButtonIconfont joButtonIconfont13;
    private Components.JoButtonIconfont joButtonIconfont4;
    private Components.JoButtonIconfont joButtonIconfont6;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLabelImage lblLogo;
    private Components.JoLableIcon lblTutorial;
    private Components.JoLable lblVersion;
    private Components.JoLableIcon lbl_user;
    private javax.swing.JPanel pnSetting;
    private javax.swing.JPanel pnSideBar;
    private javax.swing.JPanel pn_DrawerHeader;
    private javax.swing.JPanel pn_School;
    private javax.swing.JPanel pn_report;
    private javax.swing.JScrollPane scrollMenu;
    // End of variables declaration//GEN-END:variables
}
