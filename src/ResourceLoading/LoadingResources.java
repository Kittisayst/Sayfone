package ResourceLoading;

import Controller.LoginController;
import DAOSevervice.UserService;
import DAOSevervice.YearService;
import Model.GlobalDataModel;
import Model.SettingModel;
import Model.YearModel;
import Tools.JoAlert;
import Tools.JoFrameDesign;
import Utility.SayfoneFile;
import View.LoginView;
import View.PnLoading;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

public class LoadingResources extends javax.swing.JFrame {

    private final PnLoading loading = new PnLoading();
    private final ArrayList resourses = new ArrayList();
    private boolean state = false;
    private String message = "ໂຫຼດຂໍ້ມູນຜິດພາດ";

    public LoadingResources() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        loading.setOpaque(false);
        JoFrameDesign design = new JoFrameDesign(this);
        design.setIconUI(new ImageIcon(getClass().getResource("/Source/sfsc.png")));
        resourses.add(new SayfoneAPI());
        resourses.add(new ConnectMysql());
        resourses.add(new YearLoading());
        resourses.add(new RegisterLoading());
        resourses.add(new ClassLoading());
        resourses.add(new FinancialLoading());
        resourses.add(new StudentLoading());
        resourses.add(new DashboardLoading());
        resourses.add(new CleanCashFile());
        resourses.add(new SettingPaymentLoading());
    }

    public void startLoading() {
        pnLayout.add(loading, BorderLayout.CENTER);
        Thread thread = new Thread(() -> {
            try {
                for (Object data : resourses) {
                    if (data instanceof SayfoneAPI) {
                        if (!sayfoneAPI()) {
                            break;
                        }
                    } else if (data instanceof ConnectMysql) {
                        if (!connect()) {
                            break;
                        }
                    } else if (data instanceof YearLoading) {
                        if (!yearloading()) {
                            break;
                        }
                    } else if (data instanceof RegisterLoading) {
                        if (!registerloading()) {
                            break;
                        }
                    } else if (data instanceof ClassLoading) {
                        if (!classloading()) {
                            break;
                        }
                    } else if (data instanceof StudentLoading) {
                        if (!studentLoading()) {
                            break;
                        }
                    } else if (data instanceof FinancialLoading) {
                        if (!financialLoading()) {
                            break;
                        }
                    } else if (data instanceof DashboardLoading) {
                        dashboard();
                    } else if (data instanceof CleanCashFile) {
                        cleanCashFile();
                    } else if (data instanceof SettingPaymentLoading) {
                        if (!loadSettingPayment()) {
                            break;
                        }
                    }
                    loading.StartProgress(resourses.size(), 100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                loading.close();
                if (state) {
                    StartProgram();
                } else {
                    ShowMessage();
                }
            }
        });
        thread.start();
    }

    private void StartProgram() {
        this.dispose();
        LoginView view = new LoginView();
        UserService service = new UserService();
        LoginController controller = new LoginController(service, view);
        SayfoneFile file = new SayfoneFile();
    }

    private void ShowMessage() {
        JoAlert alert = new JoAlert();
        alert.setButtonOption(new String[]{"ກວດສອບໃໝ່", "ປິດໂປຣແກຣມ"});
        int conf = alert.messages("ການໂຫຼດຊັບພະຍາກອນ", message, JoAlert.Icons.warning);
        if (conf == 0) {
            message = "";
            state = false;
            startLoading();
        } else {
            System.exit(0);
        }
    }

    private void setState(boolean data) {
        if (data) {
            state = true;
        } else {
            message += loading.getTitle() + " ຜິດພາດ";
            state = false;
        }
    }

    private boolean sayfoneAPI() {
        loading.setTitle("ກວດສອບ Sayfone API");
        SayfoneAPI sayfoneAPI = new SayfoneAPI();
        setState(sayfoneAPI.checkAPI());
        return state;
    }

    private boolean connect() {
        loading.setTitle("ກວດສອບ ການເຊື່ອມຕໍ່ຖານຂໍ້ມູນ");
        ConnectMysql mysql = new ConnectMysql();
        setState(mysql.getConnect());
        return state;
    }

    private boolean yearloading() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນສົກປີ");
        YearLoading yearLoading = new YearLoading();
        GlobalDataModel.yearModels = yearLoading.createGlobalYear();
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        int monthValue = currentMonth.getValue(); // 1 to 12
        int currentYear = currentDate.getYear();
        if (!GlobalDataModel.yearModels.isEmpty()) {
            if (monthValue == 6) {
                YearModel model = new YearService().getLastYear();
                String lastYear = model.getYear().split(" - ")[1];
                int yearInt = Integer.parseInt(lastYear);
                if (currentYear == yearInt) {
                    int nextYear = currentYear + 1;
                    String createYear = currentYear + " - " + nextYear;
                    System.out.println("create New Year"+createYear);
                    new YearService().Creater(new YearModel(0, createYear));
                }
            }
        }
        setState(!GlobalDataModel.yearModels.isEmpty());
        return state;
    }

    private boolean registerloading() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນຫ້ອງຮຽນ");
        RegisterLoading registerLoading = new RegisterLoading();
        GlobalDataModel.registerModels = registerLoading.createGlobalRegister();
        setState(!GlobalDataModel.registerModels.isEmpty());
        return state;
    }

    private boolean classloading() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນຂໍ້ມູນຂະແໜງ");
        ClassLoading classLoading = new ClassLoading();
        GlobalDataModel.classModels = classLoading.createGlobalClass();
        setState(!GlobalDataModel.classModels.isEmpty());
        return state;
    }

    private boolean studentLoading() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນຂໍ້ມູນນັກຮຽນ");
        StudentLoading studentLoading = new StudentLoading();
        GlobalDataModel.studentAll = studentLoading.createStudents();
        setState(!GlobalDataModel.studentAll.isEmpty());
        return state;
    }

    private boolean financialLoading() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນຂໍ້ມູນການຈ່າຍຄ່າຮຽນ");
        FinancialLoading financialLoading = new FinancialLoading();
        GlobalDataModel.financialAll = financialLoading.createFinancial();
        setState(!GlobalDataModel.financialAll.isEmpty());
        return state;
    }

    private boolean cleanCashFile() {
        loading.setTitle("ໂຫຼດໄຟລ໌ເອກະສານ");
        CleanCashFile cashFile = new CleanCashFile();
        setState(cashFile.clearFile());
        return state;
    }

    private void dashboard() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນ ໜ້າ Dashboard");
        DashboardLoading dashboardLoading = new DashboardLoading();
        dashboardLoading.createGlobalDashboard();
    }

    private boolean loadSettingPayment() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນ ຊັບພະຍາກອນ");
        SettingPaymentLoading paymentLoading = new SettingPaymentLoading();
        SettingModel model = paymentLoading.getSettingModel();
        if (model.equals(new SettingModel())) {
            setState(false);
        } else {
            GlobalDataModel.settingModel = model;
            setState(true);
        }
        return state;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        joLabelImage1 = new Components.JoLabelImage();
        joLable1 = new Components.JoLable();
        pnLayout = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        joLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/sfsc.png"))); // NOI18N
        joLabelImage1.setPreferredSize(new java.awt.Dimension(300, 300));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(joLabelImage1, gridBagConstraints);

        joLable1.setForeground(new java.awt.Color(51, 51, 255));
        joLable1.setText("ລະບົບຄຸ້ມຄອງຂໍ້ມູນ ໂຮງຮຽນສາຍຝົນ Sayfone School");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 1, 36)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        jPanel1.add(joLable1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        pnLayout.setBackground(new java.awt.Color(255, 255, 255));
        pnLayout.setPreferredSize(new java.awt.Dimension(0, 200));
        pnLayout.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        getContentPane().add(pnLayout, gridBagConstraints);

        setSize(new java.awt.Dimension(1204, 705));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private Components.JoLabelImage joLabelImage1;
    private Components.JoLable joLable1;
    private javax.swing.JPanel pnLayout;
    // End of variables declaration//GEN-END:variables

}
