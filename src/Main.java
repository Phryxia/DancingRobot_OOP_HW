import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Test for GRobotBody
		JFrame aFrame = new JFrame();
		aFrame.setSize(400, 400);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setResizable(false);
		
		aFrame.add(new RobotDisplayer());
		
		aFrame.setVisible(true);
	}

}

/*
 * Test Bed
 * 
 * This class is just test application.
 * You may want to create your own canvas.
 */
class RobotDisplayer extends JComponent {
	
	GRobot myRobot;
	GRobot youRobot;
	
	private int t;
	
	public RobotDisplayer() {
		
		myRobot = new SeKyuRobot("SeKyu!");
		myRobot.move(200, 200);
		
		ArrayList <Instruction> iList = new ArrayList <Instruction> ();
		
		myRobot.applyInstruction(iList);
		
		youRobot = new SeKyuRobot("JiSu!");
		youRobot.move(300, 200);
		
		
		class THandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				t = (t + 1)%1000;
				
				repaint();
			}
			
		}
		
		(new Timer(1, new THandler())).start();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLACK);
		g2d.drawLine(200, 0, 200, 400);
		g2d.drawLine(0, 200, 400, 200);
		
		myRobot.draw(g2d);
		youRobot.draw(g2d);
	}
}