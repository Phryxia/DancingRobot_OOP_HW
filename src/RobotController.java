import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * RobotController class handle specific robot's motion.
 * This is kind of factory class which does some central
 * management using them.
 * 
 * @author Se-Kyu-Kwon
 *
 */
public class RobotController extends Thread
implements DancingRobot, MouseListener, MouseMotionListener
{
	private GRobot robot;
	private InstructionIO iSequence;
	private int period = 100;
	private int pointer = 0;
	private boolean isActive  = false;
	private boolean isDancing = false;
	private boolean musicMode = false;
	private BGM bgm;
	
	/**
	 * Constructor. Please link valid robot & iSeqReference.
	 * You can't link null reference, so the entire code doesn't
	 * need null-pointer exception check.
	 * 
	 * Note that this class doesn't change InstructionIO, BGM.
	 * It only controls robot from 
	 * 
	 * @param robotReference
	 */
	public RobotController(GRobot robotReference, InstructionIO iSeqReference, BGM music, int period)
	{
		// Null Pointer Check
		if(robotReference == null || iSeqReference == null || music == null)
		{
			throw new NullPointerException("[RobotController : Constructor] Null argument error");
		}
		else
		{
			robot     = robotReference;
			iSequence = iSeqReference;
			bgm       = music;
			setPeriod(period);
			
			if(robot instanceof BGMListener)
			{
				bgm.addBGMListener((BGMListener)robot);
			}
		}
		
		// Start the clock
		start();
	}
	
	/**
	 * Extends running threads
	 */
	private boolean warning = false;
	@Override
	public final void run()
	{	
		// Loop
		while(true)
		{
			// Check the pointer's validation and assign them.
			if(iSequence.size() > 0 && isDancing)
			{
				// Invalid Pointer State Fixing
				if(pointer < 0 || pointer >= iSequence.size())
				{
					System.out.println("[RobotController : run] Log : Motion pointer reset");
					pointer = 0;
				}
				
				// Move pointer to next one.
				if(musicMode)
				{
					// Check if the music has been loaded properly.
					if(bgm.getPlayer() != null)
					{
						// Do some nice things
						if(bgm.getFFT().calcAvg(20, 300) > 50)
						{
							robot.applyInstruction(iSequence.get(pointer));	
							pointer = (pointer + 1)%iSequence.size(); // Loop in bounded region [0, size-1]
						}
					}
					else
					{
						// If there is no music loaded, reset the robot and do nothing.
						if(!warning)
						{
							System.out.println("[RobotController : run] Null audio player will be ignored : There is no music loaded.");
							robot.reset();
							warning = true;
						}
					}
				}
				else
				{
					// Do some nice things
					robot.applyInstruction(iSequence.get(pointer));	
					pointer = (pointer + 1)%iSequence.size(); // Loop in bounded region [0, size-1]
					
					// Reset warning flag
					warning = false;
				}
			}
			
			// Rest
			try
			{
				if(musicMode)
				{
					sleep(100);
				}
				else
				{
					sleep(period);
				}
			}
			catch(Exception e)
			{
			}
		}
	}
	
	/**
	 * Prohibit calling start() more than once.(Similar to singleton)
	 */
	private boolean hasBooted = false;
	@Override
	public void start()
	{
		if(!hasBooted)
		{
			hasBooted = true;
			super.start();
		}
	}
	
	/**
	 * Set the period of loop in millisecond.
	 * 
	 * @param x
	 */
	public void setPeriod(int x) {
		if(x <= 0)
		{
			throw new IllegalArgumentException("[RobotController : setPeriod] Period cannot be equal or less then 0");
		}
		else
		{
			period = x;
		}
	}

	/**
	 * Implementation of Interface DancingRobot
	 */
	@Override
	public void startDancing()
	{
		isDancing = true;
	}

	/**
	 * Implementation of Interface DancingRobot
	 */
	@Override
	public void stopDancing()
	{
		isDancing = false;
		robot.reset();
	}
	
	public void setMusicMode(boolean t)
	{
		musicMode = t;
	}
	
	public void draw(Graphics2D g2d)
	{
		robot.draw(g2d);
	}
	
	/**
	 * Some mouse attribution
	 */
	private boolean isDragging   = false;
	private Vector2D mouseVector = new Vector2D(0, 0);
	private Vector2D diff        = new Vector2D(0, 0);
	
	/**
	 * Drag the robot. RobotWindow will pass MouseEvent automatically
	 * so DO NOT use this function directly.
	 */
	private void scanMouse(MouseEvent mouse)
	{
		// Calculate the difference between mouse and robot.
		mouseVector.set(mouse.getX(), mouse.getY());
		diff.set(Vector2D.sub(mouseVector, robot.getPosition()));
	}
	
	@Override
	public void mouseDragged(MouseEvent mouse)
	{
		if(isActive && isDragging)
		{
			scanMouse(mouse);
			robot.move(diff.x()*0.2, diff.y()*0.2);
		}
	}

	@Override
	public void mouseMoved(MouseEvent mouse)
	{
		if(isActive)
		{
			scanMouse(mouse);
		}
	}			
	
	public void activate()
	{
		isActive = true;
	}
	
	public void deactivate()
	{
		isActive = false;
	}
	
	public boolean isActive()
	{
		return isActive;
	}

	@Override
	public void mouseClicked(MouseEvent mouse)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent mouse)
	{
		if(isActive)
		{
			scanMouse(mouse);
			
			if(diff.size() < 70)
			{
				isDragging = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		isDragging = false;
		diff.set(0, 0);
	}
}
