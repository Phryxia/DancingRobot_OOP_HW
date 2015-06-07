/**
 * MenuBar.java
 * 
 * @author Taein Kim 
 */

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
    Color bgColor=Color.WHITE;

    /**
     * Method setColor : Set the menu background color.
     * @param color
     */
    public void setColor(Color color) {
        bgColor=color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}