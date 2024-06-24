package Component;

import App.AppFinancial;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoDataTable;
import Utility.MyFormat;
import java.util.List;

public class DialogStudentsRegister extends javax.swing.JDialog {

    List<StudentModel> studentModels;
    RegisterModel registerModel;
    StudentService studentService = new StudentService();
    FinancialService financialService = new FinancialService();

    public DialogStudentsRegister(java.awt.Frame parent, boolean modal, List<StudentModel> studentModels, RegisterModel registerModel) {
        super(parent, modal);
        this.studentModels = studentModels;
        this.registerModel = registerModel;
        initComponents();
        showStudent();
    }

    private void showStudent() {
        try {
            tb_student.JoClearModel();
            studentModels.forEach(student -> {
                boolean isRegister = financialService.isOldStudentRegistered(registerModel.getRegisterID(), student.getStudentID()); // ກວດສອບວ່າໄດ້ລົງທະບຽນແລ້ວບໍ່
                if (!isRegister) {
                    Object[] tableData = new Object[]{
                        tb_student.autoNumber(),
                        student.getStudentID(),
                        student.getStudentNo(),
                        student.getFullName(),
                        student.getDateStart() == null ? "ວ່າງ" : new MyFormat().getDate(student.getDateStart())
                    };
                    tb_student.AddJoModel(tableData);
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            pnStudent.removeAll();
            pnStudent.add(scrollStudent);
            JoDataTable dataTable = new JoDataTable(pnStudent);
            dataTable.setHiddenColumns(1);
            dataTable.showDataTableAll();
        }
    }

    private void showStudentNew() {
        try {
            tb_studentNew.JoClearModel();
            List<StudentModel> studentnewModels = new FinancialService().getStudentNew();
            studentnewModels.forEach(student -> {
                Object[] tableData = new Object[]{
                    tb_studentNew.autoNumber(),
                    student.getStudentID(),
                    student.getStudentNo(),
                    student.getFullName(),
                    student.getDateStart() == null ? "ວ່າງ" : new MyFormat().getDate(student.getDateStart())
                };
                tb_studentNew.AddJoModel(tableData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            pnStudentNew.removeAll();
            pnStudentNew.add(ScrollStudentNew);
            JoDataTable dataTable = new JoDataTable(pnStudentNew);
            dataTable.setHiddenColumns(1);
            dataTable.showDataTableAll();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        joTabbed1 = new Components.JoTabbed();
        pnStudent = new javax.swing.JPanel();
        scrollStudent = new javax.swing.JScrollPane();
        tb_student = new Components.JoTable();
        pnStudentNew = new javax.swing.JPanel();
        ScrollStudentNew = new javax.swing.JScrollPane();
        tb_studentNew = new Components.JoTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        joTabbed1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                joTabbed1StateChanged(evt);
            }
        });

        pnStudent.setLayout(new java.awt.BorderLayout());

        tb_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ", "ວັນທີ່ເຂົ້າຮຽນ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_student.setJoBackgoundHead(new java.awt.Color(255, 51, 51));
        tb_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_studentMousePressed(evt);
            }
        });
        scrollStudent.setViewportView(tb_student);

        pnStudent.add(scrollStudent, java.awt.BorderLayout.CENTER);

        joTabbed1.addTab("ນັກຮຽນເລື່ອນຊັ້ນ", pnStudent);

        pnStudentNew.setLayout(new java.awt.BorderLayout());

        tb_studentNew.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ", "ວັນທີ່ເຂົ້າຮຽນ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_studentNew.setJoBackgoundHead(new java.awt.Color(0, 102, 0));
        tb_studentNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_studentNewMousePressed(evt);
            }
        });
        ScrollStudentNew.setViewportView(tb_studentNew);

        pnStudentNew.add(ScrollStudentNew, java.awt.BorderLayout.CENTER);

        joTabbed1.addTab("ນັກຮຽນໃໝ່", pnStudentNew);

        getContentPane().add(joTabbed1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1121, 776));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void joTabbed1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_joTabbed1StateChanged
        if (joTabbed1.getSelectedIndex() == 1) {
            showStudentNew();
        }
    }//GEN-LAST:event_joTabbed1StateChanged

    private void tb_studentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_studentMousePressed
        if (evt.getClickCount() == 2) {
            OpenPayment(studentService.getStudentById(tb_student.getIntValue(1)));
        }
    }//GEN-LAST:event_tb_studentMousePressed

    private void tb_studentNewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_studentNewMousePressed
        if (evt.getClickCount() == 2) {
            OpenPayment(studentService.getStudentById(tb_studentNew.getIntValue(1)));
        }
    }//GEN-LAST:event_tb_studentNewMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollStudentNew;
    private Components.JoTabbed joTabbed1;
    private javax.swing.JPanel pnStudent;
    private javax.swing.JPanel pnStudentNew;
    private javax.swing.JScrollPane scrollStudent;
    private Components.JoTable tb_student;
    private Components.JoTable tb_studentNew;
    // End of variables declaration//GEN-END:variables

    private void OpenPayment(StudentModel studentModel) {
        AppFinancial app = new AppFinancial(registerModel, studentModel);
        this.dispose();
    }
}
