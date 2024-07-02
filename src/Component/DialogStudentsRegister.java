package Component;

import App.AppFinancial;
import DAOSevervice.FinancialService;
import DAOSevervice.StudentService;
import Model.RegisterModel;
import Model.StudentModel;
import Tools.JoDataTable;
import Utility.MyFormat;
import View.PnLoading;
import java.awt.BorderLayout;
import java.util.List;

public class DialogStudentsRegister extends javax.swing.JDialog {

    List<StudentModel> studentModels;
    RegisterModel registerModel;
    StudentService studentService = new StudentService();
    FinancialService financialService = new FinancialService();
    PnLoading loading = new PnLoading();

    public DialogStudentsRegister(java.awt.Frame parent, boolean modal, List<StudentModel> studentModels, RegisterModel registerModel) {
        super(parent, modal);
        this.studentModels = studentModels;
        this.registerModel = registerModel;
        initComponents();
        loading.setTitle("ໂຫຼດຂໍ້ມູນນັກຮຽນ");
        showStudent();
    }

    private void showStudent() {
        Thread thread = new Thread(() -> {
            try {
                tb_student.JoClearModel();
                pnStudent.removeAll();
                pnStudent.add(loading, BorderLayout.CENTER);
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
                    loading.StartProgress(studentModels.size(), 20);
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                pnStudent.removeAll();
                pnStudent.add(scrollStudent);
                JoDataTable dataTable = new JoDataTable(pnStudent);
                dataTable.setHiddenColumns(1);
                dataTable.showDataTableAll();
                loading.close();
            }
        });
        thread.start();
    }

    private void showStudentRepeat() {
        Thread thread = new Thread(() -> {
            try {
                pnStudentRepeat.removeAll();
                pnStudentRepeat.add(loading, BorderLayout.CENTER);
                tb_studentRepeat.JoClearModel();
                int YearID = registerModel.getYearID();
                int classID = registerModel.getClassID();
                int colYear = YearID == 1 ? 1 : YearID - 1;
                List<StudentModel> studentnewModels = new FinancialService().getStudentOldClass(colYear, classID);
                studentnewModels.forEach(student -> {
                    boolean isRegister = financialService.isOldStudentRegistered(registerModel.getRegisterID(), student.getStudentID()); // ກວດສອບວ່າໄດ້ລົງທະບຽນແລ້ວບໍ່
                    if (!isRegister) {
                        Object[] tableData = new Object[]{
                            tb_studentRepeat.autoNumber(),
                            student.getStudentID(),
                            student.getStudentNo(),
                            student.getFullName(),
                            student.getDateStart() == null ? "ວ່າງ" : new MyFormat().getDate(student.getDateStart())
                        };
                        tb_studentRepeat.AddJoModel(tableData);
                    }
                    loading.StartProgress(studentnewModels.size(), 20);
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                pnStudentRepeat.removeAll();
                pnStudentRepeat.add(scrollStudentRepeat);
                JoDataTable dataTable = new JoDataTable(pnStudentRepeat);
                dataTable.setHiddenColumns(1);
                dataTable.showDataTableAll();
                loading.close();
            }
        });
        thread.start();
    }

    private void showStudentNew() {
        Thread thread = new Thread(() -> {
            try {
                pnStudentNew.removeAll();
                pnStudentNew.add(loading, BorderLayout.CENTER);
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
                    loading.StartProgress(studentnewModels.size(), 20);
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                pnStudentNew.removeAll();
                pnStudentNew.add(ScrollStudentNew);
                JoDataTable dataTable = new JoDataTable(pnStudentNew);
                dataTable.setHiddenColumns(1);
                dataTable.showDataTableAll();
                loading.close();
            }
        });
        thread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        joTabbed1 = new Components.JoTabbed();
        pnStudent = new javax.swing.JPanel();
        scrollStudent = new javax.swing.JScrollPane();
        tb_student = new Components.JoTable();
        pnStudentRepeat = new javax.swing.JPanel();
        scrollStudentRepeat = new javax.swing.JScrollPane();
        tb_studentRepeat = new Components.JoTable();
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

        pnStudentRepeat.setLayout(new java.awt.BorderLayout());

        tb_studentRepeat.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_studentRepeat.setJoBackgoundHead(new java.awt.Color(255, 102, 0));
        tb_studentRepeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_studentRepeatMousePressed(evt);
            }
        });
        scrollStudentRepeat.setViewportView(tb_studentRepeat);

        pnStudentRepeat.add(scrollStudentRepeat, java.awt.BorderLayout.CENTER);

        joTabbed1.addTab("ນັກຮຽນເຊ້ຳຊັ້ນ", pnStudentRepeat);

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
        if (joTabbed1.getSelectedIndex() == 2) {
            showStudentNew();
        } else if (joTabbed1.getSelectedIndex() == 1) {
            showStudentRepeat();
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

    private void tb_studentRepeatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_studentRepeatMousePressed
        if (evt.getClickCount() == 2) {
            OpenPayment(studentService.getStudentById(tb_studentRepeat.getIntValue(1)));
        }
    }//GEN-LAST:event_tb_studentRepeatMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollStudentNew;
    private Components.JoTabbed joTabbed1;
    private javax.swing.JPanel pnStudent;
    private javax.swing.JPanel pnStudentNew;
    private javax.swing.JPanel pnStudentRepeat;
    private javax.swing.JScrollPane scrollStudent;
    private javax.swing.JScrollPane scrollStudentRepeat;
    private Components.JoTable tb_student;
    private Components.JoTable tb_studentNew;
    private Components.JoTable tb_studentRepeat;
    // End of variables declaration//GEN-END:variables

    private void OpenPayment(StudentModel studentModel) {
        AppFinancial app = new AppFinancial(registerModel, studentModel);
        this.dispose();
    }
}
