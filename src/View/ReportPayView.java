package View;

import Components.JoButtonIconfont;
import Components.JoCombobox;
import Components.JoTable;
import DAOSevervice.FinancialService;
import DAOSevervice.RegisterService;
import DAOSevervice.StudentService;
import Model.FinancialModel;
import Model.RegisterModel;
import Model.StudentModel;
import Model.YearModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReportPayView extends javax.swing.JPanel {

    public ReportPayView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public JoButtonIconfont getBtnShow() {
        return btnShow;
    }

    public JoCombobox getCbYear() {
        return cbYear;
    }

    public void showYear(List<YearModel> models) {
        models.forEach(data -> {
            cbYear.JoAddIntModel(data.getYearID(), data.getYear());
        });
    }
    int overMoney = 0;
    int payMoney = 0;

    public void showReportPay(List<FinancialModel> models) {
        updateTable();
        try {
            models.forEach(model -> {
                addData(model);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addData(FinancialModel model) {
        StudentService studentService = new StudentService();
        RegisterService registerService = new RegisterService();
        StudentModel studentModel = studentService.getStudentById(model.getStudentID());
        RegisterModel registerModel = registerService.getRegisterById(model.getRegisterID());
        tb_data.AddJoModel(new Object[]{
            tb_data.autoNumber(),
            model.getStudentID(),
            studentModel.getFullName(),
            registerModel.getClassRoomName(),
            getMonths(model),
            registerModel.getYearModel().getYear(),});
    }

    String str = "";

    private String getMonths(FinancialModel model) {
        FinancialService service = new FinancialService();
        List<FinancialModel> financialModels = service.getFinancialByStudentID(model.getRegisterID(), model.getStudentID());
        if (financialModels.size() <= 1) {
            String payMonth = model.getFinancialMonth();
            String monthMiss = findMissingNumbers(payMonth); // ຫາຂໍ້ມູນເດືອນທີ່ຄ້າງຈ່າຍ
            return monthMiss;
        } else {
            financialModels.forEach(data -> {
                str += data.getFinancialMonth();
            });
            // Remove the square brackets and split the string into parts
            String val = convertString(str); // ປ່ຽນເປັນ String
            // Concatenate the parts into a single string
            String sortNumber = ArrangeNumber(val); //ລຽງຕົວເລກໃຫ້ເປັນລຳດັບ
            String monthMiss = findMissingNumbers(sortNumber); // ຫາຂໍ້ມູນເດືອນທີ່ຄ້າງຈ່າຍ
            str = ""; // ລ້າງຂໍ້ມູນເດືອນ
            return monthMiss;
        }
    }

    private String convertString(String input) { //ລວມເດືອນ
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        while (matcher.find()) {
            output.append(matcher.group()).append(", ");
        }
        output.setLength(output.length() - 2);
        return "[" + output.toString() + "]";
    }

    private String ArrangeNumber(String str) { // ລຽງຕົວເລກເດືອນຕາມລະດັບ
        String data = str;
        if (str.equals("[]")) {
            return "[]";
        } else {
            String[] numbersArray = data.substring(1, data.length() - 1).split(", ");
            int[] numbers = new int[numbersArray.length];
            for (int i = 0; i < numbersArray.length; i++) {
                numbers[i] = Integer.parseInt(numbersArray[i]);
            }
            Arrays.sort(numbers);
            ArrayList strlist = new ArrayList();
            for (int num : numbers) {
                strlist.add(num);
            }
            return strlist.toString();
        }
    }

    private int count(String str) {
        String data = str;
        String[] numbersArray = data.substring(1, data.length() - 1).split(", ");
        System.out.println(numbersArray.length);
        return numbersArray.length;
    }

    private String findMissingNumbers(String missingValue) {
        String value = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]";
        if (missingValue.equals("[]")) {
            return value;
        } else {
            List<Integer> missingNumbers = new ArrayList<>();
            // Convert the string values to arrays of integers
            int[] numbers = parseArray(value);
            int[] missingNumbersArray = parseArray(missingValue);
            // Create a HashSet to store the missing numbers
            HashSet<Integer> missingSet = new HashSet<>();
            for (int num : missingNumbersArray) {
                missingSet.add(num);
            }
            // Iterate over the numbers array and check for missing values
            for (int num : numbers) {
                if (!missingSet.contains(num)) {
                    missingNumbers.add(num);
                }
            }
            String payFull = missingNumbers.toString();
            return payFull.equals("[]") ? "ຈ່າຍຄົບຖ້ວນ" : payFull;
        }
    }

    private int[] parseArray(String value) {
        String[] numberStrings = value.substring(1, value.length() - 1).split(", ");
        // Convert the string values to integers
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i].trim());
        }
        return numbers;
    }

    private void updateTable() {
        tb_data.JoClearModel();
        pn_Datatable.removeAll();
        pn_Datatable.add(jScrollPane1);
        pn_Datatable.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Pn_Navigation = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_back = new Components.JoButtonIconfont();
        jPanel4 = new javax.swing.JPanel();
        lbl_title = new Components.JoLable();
        jPanel5 = new javax.swing.JPanel();
        pn_Datatable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new Components.JoTable();
        jPanel1 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        cbYear = new Components.JoCombobox();
        btnShow = new Components.JoButtonIconfont();
        joButtonIconfont1 = new Components.JoButtonIconfont();

        Pn_Navigation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        Pn_Navigation.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btn_back.setText("ກັບຄືນ");
        btn_back.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ARROW_BACK);
        jPanel3.add(btn_back);

        Pn_Navigation.add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        lbl_title.setText("Title");
        lbl_title.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel4.add(lbl_title);

        Pn_Navigation.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        Pn_Navigation.add(jPanel5);

        pn_Datatable.setLayout(new java.awt.BorderLayout());

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "ຊື່ ແລະ ນາມສະກຸນ", "ຫ້ອງຮຽນ", "ຄ້າງເດືອນ", "ສົກຮຽນ", "ລວມຄ່າຈ່າຍຊ້າ", "ລວມເງິນທີ່ຕ້ອງຈ່າຍທັງໝົດ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_data);
        if (tb_data.getColumnModel().getColumnCount() > 0) {
            tb_data.getColumnModel().getColumn(0).setMinWidth(80);
            tb_data.getColumnModel().getColumn(0).setPreferredWidth(80);
            tb_data.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        joLable1.setText("ສົກປີຮຽນ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(joLable1, gridBagConstraints);

        cbYear.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 2);
        jPanel1.add(cbYear, gridBagConstraints);

        btnShow.setText("ສະແດງ");
        btnShow.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SEARCH);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 10, 2, 10);
        jPanel1.add(btnShow, gridBagConstraints);

        joButtonIconfont1.setBackground(new java.awt.Color(0, 102, 102));
        joButtonIconfont1.setText("ກຳນົດຄ່າຮຽນ");
        joButtonIconfont1.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SETTINGS);
        jPanel1.add(joButtonIconfont1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnShow;
    private Components.JoButtonIconfont btn_back;
    private Components.JoCombobox cbYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoButtonIconfont joButtonIconfont1;
    private Components.JoLable joLable1;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    // End of variables declaration//GEN-END:variables
}
