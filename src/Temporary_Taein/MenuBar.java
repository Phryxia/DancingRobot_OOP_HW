/**
 * MenuBar.java
 * 
 * @author Taein Kim 
 */
package Temporary_Taein;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar extends JMenuBar {
    Color bgColor=Color.WHITE;

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