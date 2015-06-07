import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Robot Window is a master set of Robot, InstructionIO, RobotController.
 * This only provides minimal features to user.
 * 
 * Also this draws several robots above the stage panel.
 * 
 * Every robot-related origin references are stored here.
 * (It means this is the main control tower of robot)
 * 
 * @author Se-Kyu-Kwon
 */
@SuppressWarnings("serial")
public class RobotWindow extends JComponent
{
	/*
	 * Unlike other class, this class's member is opned to public
	 * because too many separated UI class want to share them.
	 * 
	 * And even, there is no way to separate these objects from
	 * this class, because they need some event handler.
	 */
	public BGM audioFactory;
	public ArrayList <InstructionIO>   robotMotion;
	public ArrayList <RobotController> robotFactory;
	
	private double xsize, ysize;
	
	/**
	 * Invariant : every list should be initialized in constructor.
	 */
	public RobotWindow(double xsize, double ysize)
	{
		// Initialize every list in this object
		robotMotion  = new ArrayList <InstructionIO> (4);
		robotFactory = new ArrayList <RobotController> (4);
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
		RobotController rf_temp;
		double gap = xsize/(robotList.size());
		double xpos = gap/2;
		for(GRobot r : robotList)
		{
			// Default position.
			r.move(xpos, ysize/2);
			xpos += gap;
			
			// Each robot has it's own motionList.
			rm_temp = new InstructionIO();
			robotMotion.add(rm_temp);
			
			// Each robot has it's controller, which manage their motion.
			rf_temp = new RobotController(r, rm_temp, audioFactory, 650);
			robotFactory.add(rf_temp);
			addMouseListener(rf_temp);
			addMouseMotionListener(rf_temp);
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
			System.out.println("[RobotWindow : setBGM] Warning : Null music file will be ignored : " + filename);
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
		for(RobotController rc : robotFactory)
		{
			if(rc.isActive())
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
	 * Save selected robot's motion list to the file.
	 * Just give this function absolute path of the file
	 * which is going to be saved.
	 * 
	 * @param index
	 * @param filenmae
	 */
	public void saveMotionList(int index, String filename)
	{
		if(!isValidIndex(index))
		{
			System.out.println("[RobotWindow : saveMotionList] Warning : Invalid robot index will be ignored : " + index);
		}
		else if(filename == null)
		{
			System.out.println("[RobotWindow : saveMotionList] Warning : Invalid filename (null) will be ignored");
		}
		else
		{
			System.out.println("[RobotWindow : saveMotionList] Notice : Robot " + (index+1) + "'s motion has been saved");
			robotMotion.get(index).save(filename);
		}
	}
	
	/**
	 * Load selected robot's motion list from the file.
	 * Just give this function absolute path of the file
	 * which is going to be loaded.
	 * 
	 * @param index
	 * @param filenmae
	 */
	public void loadMotionList(int index, String filename)
	{
		if(!isValidIndex(index))
		{
			System.out.println("[RobotWindow : saveMotionList] Warning : Invalid robot index will be ignored : " + index);
		}
		else if(filename == null)
		{
			System.out.println("[RobotWindow : saveMotionList] Warning : Invalid filename (null) will be ignored");
		}
		else
		{
			System.out.println("[RobotWindow : saveMotionList] Notice : Robot " + (index+1) + "'s motion has been loaded");
			robotMotion.get(index).load(filename);
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
			robotFactory.get(index).activate();
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
			robotFactory.get(index).deactivate();
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
