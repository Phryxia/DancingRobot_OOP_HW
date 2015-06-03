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
		
		System.out.println("Ignore Minim Libraries Error : Just internal error");
	}
}

/*
 * Test Bed
 * 
 * This class is just test application.
 * You may want to create your own canvas.
 */
class RobotDisplayer extends JComponent
{
	
	BGM bgm;
	GRobot myRobot;
	InstructionIO io;
	RobotController rc;
	
	private int t;
	
	public RobotDisplayer()
	{
		// Instruction IO Test
		io = new InstructionIO();
		
		// Make Random Sequence
		ArrayList <Instruction> temp;
		for(int i=0; i<4; ++i)
		{
			temp = new ArrayList <Instruction> (5);
			temp.add(new Instruction(0, Math.pow(-1, i)*50, -1));
			for(int j=0; j<4; ++j)
			{
				temp.add(new Instruction(0, 0, (int)(Math.random()*360)));
			}
			io.add(temp);
		}
		
		// Robot Initialization
		myRobot = new SeKyuRobot("SeKyu!");
		myRobot.move(200, 200);
			
		// Sound Test bed
		bgm = new BGM();
		bgm.loadMP3("test.mp3");
		bgm.play();
		
		rc = new RobotController(myRobot, io, bgm, 1000);
		rc.setMusicMode(true);
		rc.startDancing();
		
		// Some annoying looping machine
		(new Timer(10, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				loop();
				repaint();
			}
		})).start();
	}
	
	/**
	 * Loop
	 */
	public void loop()
	{
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLACK);
		g2d.drawLine(200, 0, 200, 400);
		g2d.drawLine(0, 200, 400, 200);
		
		myRobot.draw(g2d);
	}
	
	private double map(double x, double xmin, double xmax, double ymin, double ymax)
	{
		return (x-xmin)/(xmax-ymin)*(ymax-ymin) + ymin;
	}
}