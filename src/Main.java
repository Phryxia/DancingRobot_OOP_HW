import java.io.*;
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
	
	BGM bgm;
	GRobot myRobot;
	
	private int t;
	Damper damper;
	
	public RobotDisplayer() {
		damper = new Damper(0, 0.995);
		
		// Robot Initialization
		myRobot = new SeKyuRobot("SeKyu!");
		myRobot.move(200, 200);
		
		// Sound Test bed
		bgm = new BGM();
		bgm.loadMP3("test.mp3");
		bgm.play();
		
		// Loop Function
		class THandler implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				t = (t + 1)%1000;
				
				damper.setDestination(Math.abs(bgm.getData(0)));
				
				// Se-Kyu Order : Body Arm Arm Head Leg Leg
				ArrayList <Instruction> iList = new ArrayList <Instruction> ();
					
				// Maater
				iList.add(new Instruction(0, 0, -1));
					
				// LArm
				iList.add(new Instruction(0, 0, (int)(damper.getCurrent()*90 + 90)));
					
				// RArm
				iList.add(new Instruction(0, 0, -(int)(damper.getCurrent()*90 + 90)));
					
				// Head
				iList.add(new Instruction(0, 0, -1));
				
				// LLeg
				if(damper.getDelta() > 0.2) {
					double x = (0.5-Math.random())*Math.PI/2;
					iList.add(new Instruction(0, 0, (int)(Math.PI/2 + x)));
					iList.add(new Instruction(0, 0, (int)(Math.PI/2 + x)));	
				}
				
				myRobot.applyInstruction(iList);
				iList.clear();
				
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
	}
	
	private double map(double x, double xmin, double xmax, double ymin, double ymax) {
		return (x-xmin)/(xmax-ymin)*(ymax-ymin) + ymin;
	}
}