package Temporary_Taein;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test_Add_Component extends JPanel{
	public void paintComponent (Graphics g) {
        g.setColor(new Color(53, 176, 186));
        g.fillRect(100, 100, 100, 100);
        setOpaque(false);
      	super.paintComponent(g);
	}
}
