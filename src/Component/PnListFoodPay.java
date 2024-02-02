package Component;

import DAOSevervice.UserService;
import Model.FoodPaymentModel;
import Utility.MonthCaculator;
import Utility.MyFormat;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PnListFoodPay extends javax.swing.JPanel {

    private final int Number;
    private final FoodPaymentModel model;
    private final ActionListener actionEdit;
    private final ActionListener actionDelete;
    private final ActionListener actionPrinter;

    public PnListFoodPay(int Number, FoodPaymentModel model, ActionListener actionEdit, ActionListener actionDelete, ActionListener actionPrinter) {
        initComponents();
        this.Number = Number;
        this.model = model;
        this.actionEdit = actionEdit;
        this.actionDelete = actionDelete;
        this.actionPrinter = actionPrinter;
        ViewPayment();
    }

    private void ViewPayment() {
        lblNumber.setText(Number + ".");
        lblMonths.setText("ຈ່າຍເດືອນ: " + FormatMonth());
        lblPrice.setText("ຈຳນວນເງິນ: " + new MyFormat().formatMoney(model.getPrice()) + " ກີບ");
        lblComment.setText("ໝາຍເຫດ: " + model.getComment());
        String userName = new UserService().getUserById(model.getUserID()).getFullName().toString();
        lblUser.setText("ໂດຍ: " + userName);
        btnEdit.addActionListener(actionEdit);
        btnDelete.addActionListener(actionDelete);
        btnPrinter.addActionListener(actionPrinter);
    }

    private String FormatMonth() {
        MonthCaculator caculator = new MonthCaculator();
        List<Integer> monthsArray = caculator.ToArrayMonth(model.getMonths());
        ArrayList strMonth = new ArrayList();
        for (Integer monthsArray1 : monthsArray) {
            if (monthsArray1 != 0) {
                strMonth.add(monthsArray1);
            }
        }
        return strMonth.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblNumber = new Components.JoLable();
        lblMonths = new Components.JoLable();
        lblPrice = new Components.JoLable();
        lblComment = new Components.JoLable();
        lblUser = new Components.JoLable();
        btnEdit = new Components.JoButtonIconfont();
        btnDelete = new Components.JoButtonIconfont();
        btnPrinter = new Components.JoButtonIconfont();

        setBackground(new java.awt.Color(102, 102, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        setMinimumSize(new java.awt.Dimension(230, 40));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(823, 40));
        setLayout(new java.awt.GridBagLayout());

        lblNumber.setText("#");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        add(lblNumber, gridBagConstraints);

        lblMonths.setText("Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(lblMonths, gridBagConstraints);

        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrice.setText("Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(lblPrice, gridBagConstraints);

        lblComment.setText("Comment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        add(lblComment, gridBagConstraints);

        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("UserID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 3, 0);
        add(lblUser, gridBagConstraints);

        btnEdit.setBackground(new java.awt.Color(0, 153, 102));
        btnEdit.setJoIconSize(25);
        btnEdit.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.EDIT);
        btnEdit.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnEdit.setMinimumSize(new java.awt.Dimension(35, 20));
        btnEdit.setPreferredSize(new java.awt.Dimension(50, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 7, 3, 2);
        add(btnEdit, gridBagConstraints);

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setJoIconSize(25);
        btnDelete.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.DELETE);
        btnDelete.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnDelete.setMinimumSize(new java.awt.Dimension(35, 20));
        btnDelete.setPreferredSize(new java.awt.Dimension(50, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 2, 3, 2);
        add(btnDelete, gridBagConstraints);

        btnPrinter.setJoIconSize(25);
        btnPrinter.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PRINT);
        btnPrinter.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnPrinter.setMinimumSize(new java.awt.Dimension(35, 20));
        btnPrinter.setPreferredSize(new java.awt.Dimension(50, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 2, 3, 7);
        add(btnPrinter, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont btnDelete;
    private Components.JoButtonIconfont btnEdit;
    private Components.JoButtonIconfont btnPrinter;
    private Components.JoLable lblComment;
    private Components.JoLable lblMonths;
    private Components.JoLable lblNumber;
    private Components.JoLable lblPrice;
    private Components.JoLable lblUser;
    // End of variables declaration//GEN-END:variables
}
