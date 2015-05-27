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
		
		class THandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				t = (t + 1)%1000;
				
				body.move(0, -0.1*Math.sin(2*Math.PI*t/500));
				
				if(t % 500 == 0) {
					larm.rotate(Math.PI*(0.5 - Math.random()));
					rarm.rotate(Math.PI*(0.5 - Math.random()));
					lleg.rotate(Math.PI*(0.5 - Math.random()));
					rleg.rotate(Math.PI*(0.5 - Math.random()));
				}
				
				repaint();
			}
			
		}
		
		(new Timer(1, new THandler())).start();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		body.draw(g2d);
		//repaint();
	}
}