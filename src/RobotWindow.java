import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.io.*;

/**
 * Robot Window is a master set of Robot, InstructionIO, RobotController.
 * This only provides minimal features to user.
 * 
 * @author Se-Kyu-Kwon
 */
@SuppressWarnings("serial")
public class RobotWindow extends JComponent
{
	private BGM audioFactory;
	private ArrayList <InstructionIO>   robotMotion;
	private ArrayList <RobotController> robotFactory;
	private ArrayList <Boolean>         robotActivity;
	
	private double xsize, ysize;
	
	/**
	 * Invariant : every list should be initialized in constructor.
	 */
	public RobotWindow(double xsize, double ysize)
	{
		// Initialize every list in this object
		robotMotion  = new ArrayList <InstructionIO> (4);
		robotFactory = new ArrayList <RobotController> (4);
		robotActivity = new ArrayList <Boolean> (4);
		audioFactory = new BGM();
		
		// Set Size
		this.xsize = xsize;
		this.ysize = ysize;
		
		// Initialize
		init();
	}
	
	/**
	 * Specified your robot list here.
	 * Do NOT Change anything but *** part
	 */
	private void init()
	{
		// Temporary list
		ArrayList <GRobot> robotList = new ArrayList <GRobot> (4);
		
		// *** *** *** ***
		// *** *** *** *** Assign your robot here. You're allowed to change here only.
		// *** *** *** ***
		
		SeKyuRobot seKyuRobot = new SeKyuRobot("Se Kyu Kwon");
		robotList.add(seKyuRobot);
		
		TaeinRobot taeinRobot = new TaeinRobot("Tae in Kim");
		robotList.add(taeinRobot);
		
		//robotList.add(new TaeInRobot("Tae In Kim"));
		
		// *** *** *** ***
		// *** *** *** ***
		// *** *** *** ***
		
		// Assign new robot controller for them
		InstructionIO rm_temp;
		double gap = xsize/(robotList.size()+1.0);
		double xpos = gap/2;
		for(GRobot r : robotList)
		{
			// Default position.
			r.move(xpos, ysize/2);
			xpos += gap;
			
			// Each robot has it's own motionList.
			robotMotion.add((rm_temp = new InstructionIO()));
			
			// Each robot has it's controller, which manage their motion.
			robotFactory.add(new RobotController(r, rm_temp, audioFactory, 450));
			
			// In default, every robot should be deactivated.
			robotActivity.add(false);
		}
	}
	
	/**
	 * Start to dance to every robot.
	 */
	public void startDancing()
	{
		for(RobotController rc : robotFactory)
		{
			rc.startDancing();
		}
		audioFactory.play();
	}
	
	/**
	 * Stop every robot.
	 */
	public void stopDancing()
	{
		for(RobotController rc : robotFactory)
		{
			rc.stopDancing();
		}
		audioFactory.stop();
	}
	
	/**
	 * Change music mode on every RobotController.
	 * @param isMusicMode
	 */
	public void setMode(boolean isMusicMode)
	{
		for(RobotController rc : robotFactory)
		{
			rc.setMusicMode(isMusicMode);
		}
	}
	
	/**
	 * 
	 * @param filename
	 */
	public void setBGM(String filename)
	{
		// Exception handling
		try
		{
			audioFactory.loadMP3(filename);
		}
		catch(Exception e)
		{
			System.out.println("There is no such file : " + filename);
		}
	}
	
	/**
	 * JComponent drawing method.
	 * It will iterate via robotFactory list.
	 */
	public void paintComponent(Graphics g)
	{
		// Graphics2D
		Graphics2D g2d = (Graphics2D)g;
		
		// Draw Every Robot
		int cnt = 0;
		for(RobotController rc : robotFactory)
		{
			if(robotActivity.get(cnt++))
			{
				rc.draw(g2d);
			}
		}
		
		// Frame Rate Control
		try
		{
			wait(10);
		}
		catch(Exception e)
		{
			
		}
		
		repaint();
	}
	
	/**
	 * Return specified robot's InstructionIO
	 * Invalid index will return null
	 * 
	 * @param index
	 * @return
	 */
	public InstructionIO getMotionList(int index)
	{
		if(isValidIndex(index))
		{
			return robotMotion.get(index);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Activate specific robot.
	 * Invalid index will be ignored
	 * 
	 * @param index
	 */
	public void activeRobot(int index)
	{
		if(isValidIndex(index))
		{
			robotActivity.set(index, true);
		}
	}
	
	/**
	 * De-Activate specific robot.
	 * Invalid index will be ignored
	 * 
	 * @param index
	 */
	public void deactiveRobot(int index)
	{
		if(isValidIndex(index))
		{
			robotActivity.set(index, false);
		}
	}
	
	/**
	 * Check whether an random index is valid or not.
	 * 
	 * @param index
	 * @return
	 */
	private boolean isValidIndex(int index)
	{
		return 0 <= index && index < robotMotion.size();
	}
}
