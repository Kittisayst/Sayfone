package Component;

import DAOSevervice.FoodPaymentService;
import DAOSevervice.SayfoneService;
import Database.JoConnect;
import Log.JoLoger;
import Model.FoodPaymentModel;
import Model.GlobalDataModel;
import Model.RegisterModel;
import Model.SayfoneModel;
import Model.StudentModel;
import Tools.JoAlert;
import Tools.JoFileSystem;
import Utility.JoJasperPrinter;
import Utility.MyFormat;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class DialogShowFoodPay extends javax.swing.JDialog {

    private final RegisterModel registerModel;
    private final StudentModel studentModel;
    private final FoodPaymentService service = new FoodPaymentService();
    private int total = 0;

    public DialogShowFoodPay() {
        this.registerModel = null;
        this.studentModel = null;
    }

    public DialogShowFoodPay(java.awt.Frame parent, boolean modal, RegisterModel registerModel, StudentModel studentModel) {
        super(parent, modal);
        initComponents();
        this.registerModel = registerModel;
        this.studentModel = studentModel;
        List<FoodPaymentModel> models = service.getByRegisterANDStudentID(registerModel.getRegisterID(), studentModel.getStudentID());
        ViewListFood(models);
    }

    private void ViewListFood(List<FoodPaymentModel> models) {
        pnFoods.removeAll();
        models.forEach(data -> {
            GridBagConstraints gridBagConstraints;
            ActionListener actionEdit = (ActionEvent e) -> {
                this.dispose();
                DialogFoodPay foodPay = new DialogFoodPay(GlobalDataModel.rootView, true, registerModel, studentModel, data);
                foodPay.setVisible(true);
            };
            ActionListener actionDelete = (ActionEvent e) -> {
                JoAlert alert = new JoAlert();
                if (alert.JoSubmitDelete()) {
                    service.delete(data.getFoodPaymentID());
                    List<FoodPaymentModel> newmodels = service.getByRegisterANDStudentID(registerModel.getRegisterID(), studentModel.getStudentID());
                    ViewListFood(newmodels);
                }
            };

            ActionListener actionPrinter = (ActionEvent e) -> {
                System.out.println("printer");
                Printer(data);
            };

            int index = pnFoods.getComponentCount();
            gridBagConstraints = new java.awt.GridBagConstraints();
            PnListFoodPay foodPay = new PnListFoodPay(index + 1, data, actionEdit, actionDelete, actionPrinter);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = index;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            pnFoods.add(foodPay, gridBagConstraints);
            sumMoney(data.getPrice());
        });
        GridBagConstraints gridBagConstraints;
        gridBagConstraints = new java.awt.GridBagConstraints();
        int index = pnFoods.getComponentCount();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = index;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnFoods.add(new JLabel(""), gridBagConstraints);
    }

    private void sumMoney(int price) {
        total += price;
        lblTotal.setText("ລວມເງິນທັງໝົດ: " + new MyFormat().formatMoney(total) + " ກີບ");
    }

    public void UpdateView(List<FoodPaymentModel> models) {
        ViewListFood(models);
    }

    private void Printer(FoodPaymentModel model) {
        JoFileSystem fileSystem = new JoFileSystem();
        String logo = fileSystem.getCurrentPath() + "/Icon/sfsc.png";
        //ດຶງຂໍ້ມູນໂຮງຮຽນ
        SayfoneService sayfoneService = new SayfoneService();
        SayfoneModel sayfoneModel = sayfoneService.getById(1);
        //ດຶງຂໍ້ມູນຜູ້ປີ້ນ
        String teacherLogin = GlobalDataModel.userModel.getFullName().toString();
        try {
            Map parameter = new HashMap();
            parameter.put("foodpayID", model.getFoodPaymentID());
            parameter.put("LogoPath", logo);
            parameter.put("School", sayfoneModel.getSchool());
            parameter.put("English", sayfoneModel.getEnglish());
            parameter.put("Contact", sayfoneModel.getContact());
            parameter.put("Detail", sayfoneModel.getDetail());
            parameter.put("UserPrint", "( " + teacherLogin + " )");
            JasperPrint print = JasperFillManager.fillReport("sayfoneFoodBill.jasper", parameter, new JoConnect().getConnectionDefault());
            if (GlobalDataModel.printerBillState) {
                new JoJasperPrinter(print).print();
            } else {
                JasperViewer showReport = new JasperViewer(print, false);
                showReport.setTitle("sayfone Food Receipt");
                showReport.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        DialogShowFoodPay dialogShowFoodPay = new DialogShowFoodPay(GlobalDataModel.rootView, true, registerModel, studentModel);
                        dialogShowFoodPay.setVisible(true);
                    }
                });
                this.dispose();
                showReport.setVisible(true);
            }
        } catch (JRException e) {
            JoAlert.Error(e, this);
            JoLoger.saveLog(e, this);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        joLable1 = new Components.JoLable();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new Components.JoButtonIconfont();
        pnFoods = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTotal = new Components.JoLable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ລາຍການຈ່າຍຄ່າອາຫານ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        getContentPane().add(joLable1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 102, 102)));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAdd.setBackground(new java.awt.Color(255, 153, 0));
        btnAdd.setText("ຈ່າຍຄ່າອາຫານ");
        btnAdd.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.LOCAL_DINING);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        pnFoods.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(pnFoods, gridBagConstraints);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        lblTotal.setText("ລວມທັງໝົດ:");
        lblTotal.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel1.add(lblTotal);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel1, gridBagConstraints);

        setSize(new java.awt.Dimension(770, 625));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        this.dispose();
        DialogFoodPay foodPay = new DialogFoodPay(GlobalDataModel.rootView, true, registerModel, studentModel, new FoodPaymentModel());
        foodPay.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnAdd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Components.JoLable joLable1;
    private Components.JoLable lblTotal;
    private javax.swing.JPanel pnFoods;
    // End of variables declaration//GEN-END:variables
}
