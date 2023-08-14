package Utility;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.UIManager;

public class JoToolTipText {

    private JComponent component;
    private String ToolTipText = "";
    private Color ToolTipBackground = Color.WHITE;
    private Color ToolTipForeground = Color.BLACK;
    private Font ToolTipFont = new Font("Phetsarath OT", 0, 14);

    public JoToolTipText(JComponent component) {
        this.component = component;
    }

    public JoToolTipText(JComponent component, String ToolTipText) {
        this.ToolTipText = ToolTipText;
        component.setToolTipText(ToolTipText);
        UIManager.put("ToolTip.background", Color.white);
        UIManager.put("ToolTip.foreground", Color.black);
        UIManager.put("ToolTip.font", new Font("Phetsarath OT", 0, 14));
    }

    public JoToolTipText(JComponent component, String ToolTipText, Color ToolTipBackground) {
        this.ToolTipText = ToolTipText;
        this.ToolTipBackground = ToolTipBackground;
        component.setToolTipText(ToolTipText);
        UIManager.put("ToolTip.background", ToolTipBackground);
        UIManager.put("ToolTip.foreground", Color.black);
        UIManager.put("ToolTip.font", new Font("Phetsarath OT", 0, 14));
    }

    public JoToolTipText(JComponent component, String ToolTipText, Color ToolTipBackground, Color ToolTipForeground) {
        this.ToolTipText = ToolTipText;
        this.ToolTipBackground = ToolTipBackground;
        this.ToolTipForeground = ToolTipForeground;
        component.setToolTipText(ToolTipText);
        UIManager.put("ToolTip.background", ToolTipBackground);
        UIManager.put("ToolTip.foreground", ToolTipForeground);
        UIManager.put("ToolTip.font", new Font("Phetsarath OT", 0, 14));
    }

    public JoToolTipText(JComponent component, String ToolTipText, Color ToolTipBackground, Color ToolTipForeground, Font ToolTipFont) {
        this.ToolTipText = ToolTipText;
        this.ToolTipBackground = ToolTipBackground;
        this.ToolTipForeground = ToolTipForeground;
        this.ToolTipFont = ToolTipFont;
        component.setToolTipText(ToolTipText);
        UIManager.put("ToolTip.background", ToolTipBackground);
        UIManager.put("ToolTip.foreground", ToolTipForeground);
        UIManager.put("ToolTip.font", ToolTipFont);
    }

    public String getToolTipText() {
        return ToolTipText;
    }

    public void setToolTipText(String ToolTipText) {
        component.setToolTipText(ToolTipText);
        this.ToolTipText = ToolTipText;
    }

    public Color getToolTipBackground() {
        return ToolTipBackground;
    }

    public void setToolTipBackground(Color ToolTipBackground) {
        UIManager.put("ToolTip.background", ToolTipBackground);
        this.ToolTipBackground = ToolTipBackground;
    }

    public Color getToolTipForeground() {
        return ToolTipForeground;
    }

    public void setToolTipForeground(Color ToolTipForeground) {
        UIManager.put("ToolTip.foreground", ToolTipForeground);
        this.ToolTipForeground = ToolTipForeground;
    }

    public Font getToolTipFont() {
        return ToolTipFont;
    }

    public void setToolTipFont(Font ToolTipFont) {
        UIManager.put("ToolTip.font", ToolTipFont);
        this.ToolTipFont = ToolTipFont;
    }

}
