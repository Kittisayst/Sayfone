package View;

import Components.JoButtonIconfont;
import Components.JoDateChooser;
import Components.JoTable;
import Components.JoTextField;
import Model.TeacherVaccinModel;
import Tools.JoDataTable;
import java.util.List;

public class TeacherVaccinView extends javax.swing.JPanel {

    public TeacherVaccinView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void showTeacherVaccin(List<TeacherVaccinModel> models) {
        models.forEach(data -> {
            tb_data.AddJoModel(new Object[]{
                tb_data.autoNumber(),
                data.getVaccinID(),
                data.getVaccinNo(),
                data.getVaccinName(),
                data.getVaccinCategory(),
                data.getDate(),
                data.getLocation(),
                data.getDoctorName()});
        });
        JoDataTable dataTable = new JoDataTable(pn_Datatable);
    }

    public void showVaccince(TeacherVaccinModel model) {
        txt_VaccinNo.setText(model.getVaccinNo());
        txt_VaccinName.setText(model.getVaccinName());
        txt_Location.setText(model.getLocation());
        txt_VaccinCategory.setText(model.getVaccinCategory());
        dt_Date.setDateData(model.getDate());
        txt_DoctorName.setText(model.getDoctorName());
    }

//====== Getter ==========
    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoTable getTb_data() {
        return tb_data;
    }

    public JoButtonIconfont getBtn_save() {
        return btn_save;
    }

    public JoDateChooser getDt_Date() {
        return dt_Date;
    }

    public JoTextField getTxt_DoctorName() {
        return txt_DoctorName;
    }

    public JoTextField getTxt_Location() {
        return txt_Location;
    }

    public JoTextField getTxt_VaccinCategory() {
        return txt_VaccinCategory;
    }

    public JoTextField getTxt_VaccinName() {
        return txt_VaccinName;
    }

    public JoTextField getTxt_VaccinNo() {
        return txt_VaccinNo;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        txt_VaccinNo = new Components.JoTextField();
        joLable2 = new Components.JoLable();
        txt_VaccinName = new Components.JoTextField();
        txt_VaccinCategory = new Components.JoTextField();
        joLable3 = new Components.JoLable();
        joLable4 = new Components.JoLable();
        txt_Location = new Components.JoTextField();
        joLable5 = new Components.JoLable();
        txt_DoctorName = new Components.JoTextField();
        joLable6 = new Components.JoLable();
        dt_Date = new Components.JoDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btn_save = new Components.JoButtonIconfont();

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
                "#", "ID", "ລະຫັດຜູ້ຮັບວັກຊີນ", "ຊື່ວັກຊີນ-ໂດສ໌", "ຊື່ຜະລິດຕະພັນ", "ວັນທີ່ຮັບວັກຊີນ", "ສະຖານທີ່", "ຊື່-ລາຍເຊັນແພດ"
            }
        ));
        jScrollPane1.setViewportView(tb_data);

        pn_Datatable.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);

        joLable1.setText("ລະຫັດວັກຊີນ");

        txt_VaccinNo.setPlaceholder("ລະຫັດວັກຊີນ");

        joLable2.setText("ຊື່ວັກຊີນ-ໂດສ໌");

        txt_VaccinName.setPlaceholder("ຊື່ວັກຊີນ-ໂດສ໌");

        txt_VaccinCategory.setPlaceholder("ຊື່ຜະລິດຕະພັນ");

        joLable3.setText("ຊື່ຜະລິດຕະພັນ");

        joLable4.setText("ສະຖານທີ່");

        txt_Location.setPlaceholder("ສະຖານທີ່");

        joLable5.setText("ຊື່ - ລາຍເຊັນແພດ");

        txt_DoctorName.setPlaceholder("ຊື່ - ລາຍເຊັນແພດ");

        joLable6.setText("ວັນທີ່ຮັບວັກຊີນ");

        dt_Date.setPlaceholder("ວັນທີ່ຮັບວັກຊີນ");

        btn_save.setText("ບັນທຶກຂໍ້ມູນວັກຊີນ");
        btn_save.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        btn_save.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        jPanel2.add(btn_save);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(joLable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_VaccinNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_VaccinCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_DoctorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_VaccinName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joLable4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Location, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joLable6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dt_Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_VaccinNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_VaccinName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(joLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_VaccinCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joLable5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joLable6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_DoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dt_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 289, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 290, Short.MAX_VALUE))
                    .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btn_back;
    private Components.JoButtonIconfont btn_save;
    private Components.JoDateChooser dt_Date;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLable joLable4;
    private Components.JoLable joLable5;
    private Components.JoLable joLable6;
    private Components.JoLable lbl_title;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTable tb_data;
    private Components.JoTextField txt_DoctorName;
    private Components.JoTextField txt_Location;
    private Components.JoTextField txt_VaccinCategory;
    private Components.JoTextField txt_VaccinName;
    private Components.JoTextField txt_VaccinNo;
    // End of variables declaration//GEN-END:variables
}
