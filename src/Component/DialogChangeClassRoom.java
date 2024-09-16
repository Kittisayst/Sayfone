package Component;

import App.AppFinancailStudent;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoAlert;
import Tools.JoIconFont;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.MyColor;

public class DialogChangeClassRoom extends javax.swing.JDialog {

    private RegisterModel registerModel;
    private int studentID;

    public DialogChangeClassRoom(java.awt.Frame parent, boolean modal, RegisterModel registerModel, int studentID) {
        super(parent, modal);
        initComponents();
        this.registerModel = registerModel;
        this.studentID = studentID;
        StudentService studentService = new StudentService();
        StudentModel studentModel = studentService.getStudentById(studentID);
        lblStudent.setText(studentModel.getFullName().toString());
        lblIcon.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.CHEVRON_RIGHT, 50, MyColor.Primary));
        cbRoom.JoAddIntModel(registerModel.getRegisterID(), registerModel.getClassRoomName());
        showClassRoom();
    }

    private void showClassRoom() {
        RegisterService registerService = new RegisterService();
        registerService.getRegisterLastYearAll().forEach(data -> {
            if (data.getRegisterID() != registerModel.getRegisterID()) {
                cbChangeRoom.JoAddIntModel(data.getRegisterID(), data.getClassRoomName());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        cbChangeRoom = new Components.JoCombobox();
        btnSave = new Components.JoButtonIconfont();
        lblStudent = new Components.JoLable();
        joLable4 = new Components.JoLable();
        cbRoom = new Components.JoCombobox();
        lblIcon = new Components.JoLable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        joLable1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        joLable1.setForeground(new java.awt.Color(25, 118, 210));
        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("ຍ້າຍຫ້ອງຮຽນ");
        joLable1.setFont(new java.awt.Font("Phetsarath OT", 1, 24)); // NOI18N
        joLable1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(joLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 60));

        joLable2.setText("ຫ້ອງທີ່ຕ້ອງການຍ້າຍ");
        joLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        getContentPane().add(joLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 140, 140, -1));
        getContentPane().add(cbChangeRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 140, 40));

        btnSave.setText("ຍ້າຍຫ້ອງ");
        btnSave.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btnSave.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SYSTEM_UPDATE_ALT);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 380, 50));

        lblStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStudent.setText("ຊື່ນັກຮຽນ");
        lblStudent.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N
        lblStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 390, 70));

        joLable4.setText("ຫ້ອງປະຈຸບັນ");
        joLable4.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        getContentPane().add(joLable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 140, 150, -1));

        cbRoom.setEnabled(false);
        getContentPane().add(cbRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 150, 40));

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 50, 40));

        setSize(new java.awt.Dimension(450, 374));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JoAlert alert = new JoAlert();
        alert.setButtonOption(new String[]{"ຍ້າຍຫ້ອງ", "ຍົກເລີກ"});
        int conf = alert.messages("ຍ້າຍຫ້ອງ", "ຕ້ອງການຍ້າຍຫ້ອງ: " + cbRoom.getValue() + "  >  " + cbChangeRoom.getValue() + " ຫຼືບໍ່!", JoAlert.Icons.warning);
        if (conf == 0) {
            FinancialService financialService = new FinancialService();
            int isSave = financialService.UpdateClassRoom(cbRoom.getKeyInt(), cbChangeRoom.getKeyInt(), studentID);
            if (isSave > 0) {
                new JoAlert().messages("ຍ້າຍຫ້ອງ", "ຍ້າຍຫ້ອງຮຽນສຳເລັດ", JoAlert.Icons.success);
                RegisterService registerService = new RegisterService();
                AppFinancailStudent financailStudent = new AppFinancailStudent(registerService.getRegisterById(cbChangeRoom.getKeyInt()));
                System.out.println(financailStudent);
                this.dispose();
            } else {
                new JoAlert().messages("ຍ້າຍຫ້ອງ", "ຍ້າຍຫ້ອງຮຽນຜິດພາດ", JoAlert.Icons.error);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnSave;
    private Components.JoCombobox cbChangeRoom;
    private Components.JoCombobox cbRoom;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable4;
    private Components.JoLable lblIcon;
    private Components.JoLable lblStudent;
    // End of variables declaration//GEN-END:variables
}
