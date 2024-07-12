package View;

import Component.ListItem;
import Components.JoButtonIconfont;
import DAOSevervice.SayfoneService;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentNkowView extends javax.swing.JPanel {

    public StudentNkowView(String Title) {
        initComponents();
        lbl_title.setText(Title);
    }

    public void showList(List<String> items) {
        for (int index = 0; index < items.size(); index++) {
            String item = items.get(index);
            ListItem list = new ListItem();
            list.setTextItem(item);
            final int finalIndex = index;
            list.addHandelDelete(e -> deleteItem(finalIndex));
            myList1.AddList(list);
        }
    }

    public void addList(String text) {
        ListItem list = new ListItem();
        list.setTextItem(text);
        list.addHandelDelete(e -> deleteItem(myList1.getCount() - 1));
        myList1.AddList(list);
        txtname.setText("");
        txtname.requestFocus();
    }

    public void handelAdd(ActionListener evt) {
        btnAdd.addActionListener(evt);
    }

    public String getText() {
        return txtname.getText();
    }

    public boolean isText() {
        return txtname.TextEmpty();
    }

    private void deleteItem(int index) {
        myList1.removeItem(index);
        new SayfoneService().updateStudentNkow(myList1.getData());
    }

    public void handelBack(ActionListener evt) {
        btn_back.addActionListener(evt);
    }

    public String getData() {
        return myList1.getData();
    }

    public JoButtonIconfont getBtn_back() {
        return btn_back;
    }

    public JoButtonIconfont getBtn_Add() {
        return btn_add;
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
        btn_add = new Components.JoButtonIconfont();
        pn_Datatable = new javax.swing.JPanel();
        myList1 = new Component.MyList();
        jPanel1 = new javax.swing.JPanel();
        txtname = new Components.JoTextField();
        btnAdd = new Components.JoButtonIconfont();

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

        btn_add.setText("ເພີ່ມຂໍ້ມູນ");
        btn_add.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ADD_CIRCLE);
        jPanel5.add(btn_add);

        Pn_Navigation.add(jPanel5);

        pn_Datatable.setLayout(new java.awt.GridBagLayout());

        myList1.setMinimumSize(new java.awt.Dimension(500, 0));
        myList1.setPreferredSize(new java.awt.Dimension(500, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        pn_Datatable.add(myList1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtname.setPlaceholder("ຊື່ຊ່ອງທາງ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(txtname, gridBagConstraints);

        btnAdd.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.ADD_CIRCLE);
        jPanel1.add(btnAdd, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        pn_Datatable.add(jPanel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pn_Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn_Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn_Navigation;
    private Components.JoButtonIconfont btnAdd;
    private Components.JoButtonIconfont btn_add;
    private Components.JoButtonIconfont btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private Components.JoLable lbl_title;
    private Component.MyList myList1;
    private javax.swing.JPanel pn_Datatable;
    private Components.JoTextField txtname;
    // End of variables declaration//GEN-END:variables
}
