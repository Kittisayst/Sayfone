package Utility;

import Components.JoPopUpMenu;
import Tools.JoIconFont;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.UnsupportedLookAndFeelException;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import org.jfree.ui.action.ActionMenuItem;
import theme.MyColor;

public class MyPopup {

    private final JMenuItem itemshow;
    private final JMenuItem itemEdit;
    private final JMenuItem itemDelete;
    private JoPopUpMenu menu;

    public MyPopup() {
        try {
            menu = new JoPopUpMenu();
        } catch (UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            Logger.getLogger(MyPopup.class.getName()).log(Level.SEVERE, null, ex);
        }
        itemshow = new JMenuItem("ສະແດງ");
        itemEdit = new JMenuItem("ແກ້ໄຂ");
        itemDelete = new JMenuItem("ລຶບ");
        //=================== Icon =========================
        itemshow.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.FIND_IN_PAGE, 20, MyColor.blue600));
        itemEdit.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.BORDER_COLOR, 20, MyColor.green600));
        itemDelete.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.DELETE, 20, MyColor.red600));
        addItem();
    }

    public void ShowPopup(MouseEvent e) {
        menu.showPopupMenu(e);
    }

    public void addActionListener(ActionListener e) {
        for (Component component : menu.getComponents()) {
            JMenuItem item = (JMenuItem) component;
            item.addActionListener(e);
        }
    }

    public JoPopUpMenu getMenu() {
        return menu;
    }

    public JMenuItem getItemshow() {
        return itemshow;
    }

    public JMenuItem getItemEdit() {
        return itemEdit;
    }

    public JMenuItem getItemDelete() {
        return itemDelete;
    }

    private void addItem() {
        //================= Add =============================
        menu.add(itemshow);
        menu.add(itemEdit);
        menu.add(itemDelete);
    }

    public void addMenuItem(String text) {
        JMenuItem item = new ActionMenuItem(text);
        menu.add(item);
    }

    public void addMenuItem(String text, GoogleMaterialDesignIcons icons) {
        JMenuItem item = new ActionMenuItem(text);
        item.setIcon(new JoIconFont().setIconFont(icons, 20, Color.BLACK));
        menu.add(item);
    }

    public void addMenuItem(String text, GoogleMaterialDesignIcons icons, Color color) {
        JMenuItem item = new ActionMenuItem(text);
        item.setIcon(new JoIconFont().setIconFont(icons, 20, color));
        menu.add(item);
    }

    public JMenuItem getMenuItem(int indexItem) {
        return menu.getMenuItem(indexItem);
    }

}
