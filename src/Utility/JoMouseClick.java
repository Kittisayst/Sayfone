package Utility;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@FunctionalInterface
public interface JoMouseClick extends MouseListener {

    @Override
    default public void mouseEntered(final MouseEvent e) {
    }

    @Override
    default public void mouseExited(final MouseEvent e) {
    }

    @Override
    default public void mousePressed(final MouseEvent e) {
    }

    @Override
    default public void mouseReleased(final MouseEvent e) {
    }
}
