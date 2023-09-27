package Component;

import Controller.LoginController;
import DAOSevervice.UserService;
import ResourceLoading.ClassLoading;
import ResourceLoading.ConnectMysql;
import ResourceLoading.DashboardLoading;
import ResourceLoading.RegisterLoading;
import ResourceLoading.SayfoneAPI;
import ResourceLoading.YearLoading;
import Tools.JoAlert;
import Tools.JoFrameDesign;
import Utility.SayfoneFile;
import View.LoginView;
import View.PnLoading;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class LoadingResources extends javax.swing.JFrame {

    private PnLoading loading = new PnLoading();
    private ArrayList resourses = new ArrayList();
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
        resourses.add(new DashboardLoading());
    }

    public void startLoading() {
        pnLayout.add(loading, BorderLayout.CENTER);
        Thread thread = new Thread(() -> {
            try {
                resourses.forEach(data -> {
                    if (data instanceof SayfoneAPI) {
                        sayfoneAPI();
                    } else if (data instanceof ConnectMysql) {
                        connect();
                    } else if (data instanceof YearLoading) {
                        yearloading();
                    } else if (data instanceof RegisterLoading) {
                        registerloading();
                    } else if (data instanceof ClassLoading) {
                        classloading();
                    } else if (data instanceof DashboardLoading) {
                        dashboard();
                    }
                    loading.StartProgress(resourses.size(), 100);
                });
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
            startLoading();
        } else {
            System.exit(0);
        }
    }

    private void sayfoneAPI() {
        loading.setTitle("ກວດສອບ Sayfone API");
        SayfoneAPI sayfoneAPI = new SayfoneAPI();
        if (sayfoneAPI.checkAPI()) {
            state = true;
        } else {
            message = "ໂຫຼດຂໍ້ມູນ Sayfone API ຜິດພາດ";
            state = false;
        }
    }

    private void connect() {
        loading.setTitle("ກວດສອບ ການເຊື່ອມຕໍ່ຖານຂໍ້ມູນ");
        ConnectMysql mysql = new ConnectMysql();
        if (mysql.getConnect()) {
            state = true;
        } else {
            message = "ໂຫຼດຂໍ້ມູນ ການເຊື່ອມຕໍ່ຖານຂໍ້ມູນ ຜິດພາດ";
            state = false;
        }
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

        setSize(new java.awt.Dimension(1032, 625));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void yearloading() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນສົກປີ");
        YearLoading yearLoading = new YearLoading();
        yearLoading.createGlobalYear();
    }

    private void registerloading() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນຫ້ອງຮຽນ");
        RegisterLoading registerLoading = new RegisterLoading();
        registerLoading.createGlobalRegister();
    }

    private void dashboard() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນ ໜ້າ Dashboard");
        DashboardLoading dashboardLoading = new DashboardLoading();
        dashboardLoading.createGlobalDashboard();
    }

    private void classloading() {
        loading.setTitle("ໂຫຼດຂໍ້ມູນຂໍ້ມູນຂະແໜງ");
        ClassLoading classLoading = new ClassLoading();
        classLoading.createGlobalClass();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private Components.JoLabelImage joLabelImage1;
    private Components.JoLable joLable1;
    private javax.swing.JPanel pnLayout;
    // End of variables declaration//GEN-END:variables

}
