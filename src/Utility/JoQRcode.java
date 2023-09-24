package Utility;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class JoQRcode {

    private String text = "JoQRcode";
    private Color backgroundQR = Color.WHITE;
    private Color colorQR = Color.BLACK;
    private int size = 200;

    public JoQRcode(String text) {
        this.text = text;
    }

    public Icon getCreateQRcode() {
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix;
            try {
                bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hints);
            } catch (WriterException e) {
                e.printStackTrace();
                return null;
            }

            // Create a BufferedImage from the BitMatrix
            BufferedImage qrCodeImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
            qrCodeImage.createGraphics();
            Graphics2D graphics = (Graphics2D) qrCodeImage.getGraphics();
            graphics.setColor(backgroundQR);
            graphics.fillRect(0, 0, size, size);
            graphics.setColor(colorQR);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (bitMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            // Create an ImageIcon from the BufferedImage
            ImageIcon qrCodeIcon = new ImageIcon(qrCodeImage);
            return qrCodeIcon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getBackgroundQR() {
        return backgroundQR;
    }

    public void setBackgroundQR(Color backgroundQR) {
        this.backgroundQR = backgroundQR;
    }

    public Color getColorQR() {
        return colorQR;
    }

    public void setColorQR(Color colorQR) {
        this.colorQR = colorQR;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
