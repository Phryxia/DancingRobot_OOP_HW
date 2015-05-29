import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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

// Test class
class RobotDisplayer extends JComponent {
	
	GRobotBody body;
	GRobotArm larm;
	GRobotArm rarm;
	GRobotArm lleg, rleg;
	private int t;
	
	public RobotDisplayer() {
		body = new GRobotBody("Robot Body", 200, 200, 100, 100);
		larm = new GRobotArm("Robot Arm L", -50, -50, 100, 30);
		larm.setCurrentAngle(Math.PI);
		
		rarm = new GRobotArm("Robot Arm R", 50, -50, 100, 30);
		lleg = new GRobotArm("Robot Leg L", -50, 50, 120, 30);
		lleg.setCurrentAngle(Math.PI/2);
		rleg = new GRobotArm("Robot Leg R", 50, 50, 120, 30);
		rleg.setCurrentAngle(Math.PI/2);
		
		body.add(larm);
		body.add(rarm);
		body.add(lleg);
		body.add(rleg);
		body.add(new GRobotHead("Robot Head", 0, -85, 80));
		lleg.add(new GRobotArm("Test", 100, 0, 50, 5));
		
		class THandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				t = (t + 1)%1000;
				
				//body.move(0, -0.1*Math.sin(2*Math.PI*t/500));
				
				if(t % 50 == 0) {
					Instruction i1 = new Instruction(0, 0, 0.25*Math.PI*(0.5 - Math.random()));
					i1.add(new Instruction(0, 0, Math.PI*(0.5 - Math.random())));
					i1.add(new Instruction(0, 0, Math.PI*(0.5 - Math.random())));
					i1.add(new Instruction(0, 0, Math.PI*(0.5 - Math.random())));
					i1.add(new Instruction(0, 0, Math.PI*(0.5 - Math.random())));
					
					body.giveInstruction(i1);
				}
				
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
		
		body.draw(g2d);
		//repaint();
	}
}