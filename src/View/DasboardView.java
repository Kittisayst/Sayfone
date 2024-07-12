package View;

import Chart.PieChartUI;
import Chart.PieChartUIModel;
import Component.JoDashboardItem;
import Components.JoButtonIconfont;
import Components.JoScrollBar;
import Components.JoTable;
import Components.JoTextField;
import DAOSevervice.FinancialService;
import Model.RegisterModel;
import Model.StudentModel;
import Utility.WrapLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DasboardView extends javax.swing.JPanel {

    private JoScrollBar scrollBar;
    private PnLoading loading = new PnLoading();

    public DasboardView() {
        initComponents();
        scrollBar = new JoScrollBar(scrollDashbord);
        loading.setTitle("ໂຫຼດຂໍ້ມູນນັກຮຽນ");
    }

    public void ShowStudentCount(int newCount, int Count) {
        ds_Student.setItemTitle("ນັກຮຽນທັງໝົດ: " + Count);
        ds_Student.getLbl_Title().setFont(new java.awt.Font("Phetsarath OT", 0, 16));
        ds_Student.getLbl_detail().setText("ນັກຮຽນໃໝ່: " + newCount);
    }

    public void ShowTeacherCount(int Count) {
        ds_Teacher.setItemTitle("" + Count);
    }

    public void showFinalcailCount(int countFinancial) {
        ds_Financail.setItemTitle("" + countFinancial);
    }

    public void showRegisterCount(int countRegister) {
        ds_ClassRoom.setItemTitle("" + countRegister);
    }

    public JoDashboardItem getDs_Student() {
        return ds_Student;
    }

    public JoDashboardItem getDs_Teacher() {
        return ds_Teacher;
    }

    public JoDashboardItem getDs_ClassRoom() {
        return ds_ClassRoom;
    }

    public JoDashboardItem getDs_Financail() {
        return ds_Financail;
    }

    public JoButtonIconfont getBtnSearch() {
        return btnSearch;
    }

    public JoTable getTbData() {
        return tbData;
    }

    public JoTextField getTxtSearch() {
        return txtSearch;
    }

    public void showYear() {
        comboboxYear1.showYears();
    }

    public int getYear() {
        return comboboxYear1.getYearID();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        scrollDashbord = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ds_Student = new Component.JoDashboardItem();
        ds_Teacher = new Component.JoDashboardItem();
        ds_ClassRoom = new Component.JoDashboardItem();
        ds_Financail = new Component.JoDashboardItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnClassRoom = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        comboboxYear1 = new Component.comboboxYear();
        txtSearch = new Components.JoTextField();
        btnSearch = new Components.JoButtonIconfont();
        pnChart = new javax.swing.JPanel();
        lblKindergarten = new Components.JoLable();
        lblElementary = new Components.JoLable();
        lblJuniorHighSchool = new Components.JoLable();
        lblHighSchool = new Components.JoLable();
        pnTable = new javax.swing.JPanel();
        scollTable = new javax.swing.JScrollPane();
        tbData = new Components.JoTable();

        setLayout(new java.awt.BorderLayout());

        scrollDashbord.setBorder(null);
        scrollDashbord.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDashbord.setToolTipText("");

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(618, 120));
        jPanel1.setMinimumSize(new java.awt.Dimension(618, 120));
        jPanel1.setPreferredSize(new java.awt.Dimension(618, 120));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        ds_Student.setForeground(new java.awt.Color(255, 255, 255));
        ds_Student.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PEOPLE);
        ds_Student.setItemBackground(new java.awt.Color(0, 153, 153));
        ds_Student.setItemDetail("ນັກຮຽນ");
        ds_Student.setItemTitle("205");
        ds_Student.setMinimumSize(new java.awt.Dimension(200, 108));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(ds_Student, gridBagConstraints);

        ds_Teacher.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_BOX);
        ds_Teacher.setItemBackground(new java.awt.Color(142, 144, 124));
        ds_Teacher.setItemDetail("ຄູສອນ");
        ds_Teacher.setItemTitle("200");
        ds_Teacher.setMaximumSize(ds_Student.getMaximumSize());
        ds_Teacher.setMinimumSize(new java.awt.Dimension(200, 108));
        ds_Teacher.setPreferredSize(ds_Student.getPreferredSize());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(ds_Teacher, gridBagConstraints);

        ds_ClassRoom.setItemBackground(new java.awt.Color(255, 204, 0));
        ds_ClassRoom.setItemDetail("ຫ້ອງຮຽນ");
        ds_ClassRoom.setItemTitle("50");
        ds_ClassRoom.setMaximumSize(ds_Student.getMaximumSize());
        ds_ClassRoom.setMinimumSize(new java.awt.Dimension(200, 108));
        ds_ClassRoom.setPreferredSize(ds_Student.getPreferredSize());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(ds_ClassRoom, gridBagConstraints);

        ds_Financail.setIcon(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
        ds_Financail.setItemBackground(new java.awt.Color(0, 153, 51));
        ds_Financail.setItemDetail("ຈ່າຍຄ່າຮຽນ");
        ds_Financail.setItemTitle("150");
        ds_Financail.setMaximumSize(ds_Student.getMaximumSize());
        ds_Financail.setMinimumSize(new java.awt.Dimension(200, 108));
        ds_Financail.setPreferredSize(ds_Student.getPreferredSize());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(ds_Financail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("\\");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.weightx = 0.1;
            gridBagConstraints.weighty = 0.1;
            jPanel1.add(jLabel2, gridBagConstraints);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.weightx = 0.1;
            gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
            jPanel4.add(jPanel1, gridBagConstraints);

            pnClassRoom.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(204, 204, 204)), "ຫ້ອງຮຽນທັງໝົດ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Phetsarath OT", 0, 14))); // NOI18N
            pnClassRoom.setMaximumSize(new java.awt.Dimension(0, 0));
            pnClassRoom.setPreferredSize(new java.awt.Dimension(0, 200));
            pnClassRoom.setLayout(new java.awt.BorderLayout());
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.weightx = 0.1;
            gridBagConstraints.insets = new java.awt.Insets(15, 15, 0, 15);
            jPanel4.add(pnClassRoom, gridBagConstraints);

            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(204, 204, 204)), "ຂໍ້ມູນນັກຮຽນຈ່າຍຄ່າຮຽນ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Phetsarath OT", 0, 14))); // NOI18N
            jPanel2.setMaximumSize(new java.awt.Dimension(618, 168));
            jPanel2.setPreferredSize(new java.awt.Dimension(18, 100));
            jPanel2.setLayout(new java.awt.GridBagLayout());

            jPanel3.setMaximumSize(new java.awt.Dimension(100, 50));
            jPanel3.setMinimumSize(new java.awt.Dimension(100, 50));
            jPanel3.setPreferredSize(new java.awt.Dimension(100, 50));
            jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

            comboboxYear1.setMinimumSize(new java.awt.Dimension(72, 30));
            comboboxYear1.setPreferredSize(new java.awt.Dimension(150, 40));
            jPanel3.add(comboboxYear1);

            txtSearch.setPlaceholder("ຄົ້ນຫານັກຮຽນ");
            jPanel3.add(txtSearch);

            btnSearch.setText("ສະແດງ");
            btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            btnSearch.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
            btnSearch.setMargin(new java.awt.Insets(2, 5, 2, 10));
            jPanel3.add(btnSearch);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.weightx = 0.1;
            jPanel2.add(jPanel3, gridBagConstraints);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 0.1;
            jPanel4.add(jPanel2, gridBagConstraints);

            pnChart.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(204, 204, 204)), "ຈຳນວນນັກຮຽນ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Phetsarath OT", 0, 14))); // NOI18N
            pnChart.setMinimumSize(new java.awt.Dimension(171, 300));
            pnChart.setPreferredSize(new java.awt.Dimension(171, 300));
            pnChart.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

            lblKindergarten.setForeground(new java.awt.Color(255, 82, 73));
            lblKindergarten.setText("ອານຸບານ");
            lblKindergarten.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
            pnChart.add(lblKindergarten);

            lblElementary.setForeground(new java.awt.Color(214, 187, 122));
            lblElementary.setText("ປະຖົມ");
            lblElementary.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
            pnChart.add(lblElementary);

            lblJuniorHighSchool.setForeground(new java.awt.Color(19, 208, 201));
            lblJuniorHighSchool.setText("ມັດທະຍົມ");
            lblJuniorHighSchool.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
            pnChart.add(lblJuniorHighSchool);

            lblHighSchool.setForeground(new java.awt.Color(79, 128, 220));
            lblHighSchool.setText("ມັດທະຍົມປາຍ");
            lblHighSchool.setFont(new java.awt.Font("Phetsarath OT", 1, 18)); // NOI18N
            pnChart.add(lblHighSchool);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            jPanel4.add(pnChart, gridBagConstraints);

            pnTable.setLayout(new java.awt.BorderLayout());

            tbData.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "#", "studentID", "ລະຫັດນັກຮຽນ", "ຊື່ ແລະ ນາມສະກຸນ", "ຫ້ອງຮຽນ", "ສະຖານະນັກຮຽນ"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            scollTable.setViewportView(tbData);
            if (tbData.getColumnModel().getColumnCount() > 0) {
                tbData.getColumnModel().getColumn(1).setMinWidth(0);
                tbData.getColumnModel().getColumn(1).setPreferredWidth(0);
                tbData.getColumnModel().getColumn(1).setMaxWidth(0);
            }

            pnTable.add(scollTable, java.awt.BorderLayout.CENTER);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 4;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.weightx = 0.1;
            gridBagConstraints.weighty = 0.1;
            jPanel4.add(pnTable, gridBagConstraints);

            scrollDashbord.setViewportView(jPanel4);

            add(scrollDashbord, java.awt.BorderLayout.CENTER);
        }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnSearch;
    private Component.comboboxYear comboboxYear1;
    private Component.JoDashboardItem ds_ClassRoom;
    private Component.JoDashboardItem ds_Financail;
    private Component.JoDashboardItem ds_Student;
    private Component.JoDashboardItem ds_Teacher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private Components.JoLable lblElementary;
    private Components.JoLable lblHighSchool;
    private Components.JoLable lblJuniorHighSchool;
    private Components.JoLable lblKindergarten;
    private javax.swing.JPanel pnChart;
    private javax.swing.JPanel pnClassRoom;
    private javax.swing.JPanel pnTable;
    private javax.swing.JScrollPane scollTable;
    private javax.swing.JScrollPane scrollDashbord;
    private Components.JoTable tbData;
    private Components.JoTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void showClassRoom(List<RegisterModel> models) {
        pnClassRoom.removeAll();
        resetCount();
        pnClassRoom.setSize(500, 500);
        FinancialService financialService = new FinancialService();
        JPanel classRoomLayout = new JPanel(new WrapLayout(WrapLayout.LEFT, 2, 2));
        classRoomLayout.setSize(200, 200);
        models.forEach(data -> {
            JLabel btnClass = new JLabel();
            btnClass.setFont(new Font("Phetsarath OT", 1, 12));
            btnClass.setPreferredSize(new Dimension(140, 30));
            btnClass.setFocusable(false);
            int CountStudent = financialService.getStudentRegistered(data.getRegisterID()).size();
            btnClass.setText(data.getClassRoomName() + " : ( " + CountStudent + " )");
            //ສີຕົວໜັງສື
            btnClass.setForeground(getColorClass(data.getClassID()));
            classRoomLayout.add(btnClass);
            CoutClass(data.getClassID(), CountStudent); //ສະແດງຈຳນວນລວມນັກຮຽນ
        });
        pnClassRoom.add(classRoomLayout, BorderLayout.CENTER);
        showChart();
    }

    int Kindergarten = 0;
    int Elementary = 0;
    int JuniorHighSchool = 0;
    int HighSchool = 0;
    int studentCount = 0;

    private void resetCount() {
        Kindergarten = 0;
        Elementary = 0;
        JuniorHighSchool = 0;
        HighSchool = 0;
        studentCount = 0;
    }

    private void CoutClass(int classID, int count) {
        switch (classID) {
            case 1:
                Kindergarten += count;
                break;
            case 18:
                Kindergarten += count;
                break;
            case 19:
                Kindergarten += count;
                break;
            case 20:
                Kindergarten += count;
                break;
            case 21:
                Elementary += count;
                break;
            case 22:
                Elementary += count;
                break;
            case 23:
                Elementary += count;
                break;
            case 24:
                Elementary += count;
                break;
            case 25:
                Elementary += count;
                break;
            case 26:
                JuniorHighSchool += count;
                break;
            case 27:
                JuniorHighSchool += count;
                break;
            case 28:
                JuniorHighSchool += count;
                break;
            case 29:
                JuniorHighSchool += count;
                break;
            case 30:
                HighSchool += count;
                break;
            case 31:
                HighSchool += count;
                break;
            case 32:
                HighSchool += count;
                break;
            default:
                break;
        }
    }

    public void showTableData(List<StudentModel> models) {
        Thread thread = new Thread(() -> {
            try {
                pnTable.removeAll();
                tbData.JoClearModel();
                pnTable.add(loading, BorderLayout.CENTER);
                pnTable.revalidate();
                FinancialService financialService = new FinancialService();
                models.forEach(data -> {
                    String lastClass = financialService.getLastClass(data.getStudentID());
                    tbData.AddJoModel(new Object[]{tbData.autoNumber(), data.getStudentID(), data.getStudentNo(), data.getFullName(), lastClass, data.getStatusName()});
                    loading.StartProgress(models.size() + 10, 20);
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                pnTable.removeAll();
                pnTable.add(scollTable, BorderLayout.CENTER);
                loading.close();
                pnTable.revalidate();
            }
        });
        thread.start();
    }

    private void showChart() {
        pnChart.removeAll();
        PieChartUI chartUI = new PieChartUI();
        chartUI.addData(new PieChartUIModel("ອານຸບານ", Kindergarten, new Color(255, 82, 73)));
        chartUI.addData(new PieChartUIModel("ປະຖົມ", Elementary, new Color(214, 187, 122)));
        chartUI.addData(new PieChartUIModel("ມັດທະຍົມຕົ້ນ", JuniorHighSchool, new Color(19, 208, 201)));
        chartUI.addData(new PieChartUIModel("ມັດທະຍົມປາຍ", HighSchool, new Color(79, 128, 220)));
        chartUI.setPreferredSize(new Dimension(270, 270));
        lblKindergarten.setText("ອານຸບານ: " + Kindergarten + " ຄົນ");
        lblElementary.setText("ປະຖົມ: " + Elementary + " ຄົນ");
        lblJuniorHighSchool.setText("ມັດທະຍົມຕົ້ນ: " + JuniorHighSchool + " ຄົນ");
        lblHighSchool.setText("ມັດທະຍົມປາຍ: " + HighSchool + " ຄົນ");
        studentCount += Kindergarten + Elementary + JuniorHighSchool + HighSchool;
        pnChart.add(chartUI);
        pnChart.add(lblKindergarten);
        pnChart.add(lblElementary);
        pnChart.add(lblJuniorHighSchool);
        pnChart.add(lblHighSchool);
        pnChart.repaint();
        pnChart.revalidate();
    }

    private Color getColorClass(int classID) {
        if (classID <= 20) {
            return new Color(255, 82, 73);
        } else if (classID <= 25) {
            return new Color(214, 187, 122);
        } else if (classID <= 29) {
            return new Color(19, 208, 201);
        } else if (classID <= 32) {
            return new Color(79, 128, 220);
        } else {
            return Color.BLACK;
        }
    }

}
