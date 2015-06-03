/**
 * RobotController class handle specific robot's motion.
 * This is kind of factory class which does some central
 * management using them.
 * 
 * @author Se-Kyu-Kwon
 *
 */
public class RobotController extends Thread implements DancingRobot
{
	private Robot robot;
	private InstructionIO iSequence;
	private int period = 100;
	private int pointer = 0;
	private boolean isDancing = false;
	private boolean musicMode = false;
	private BGM bgm;
	
	/**
	 * Constructor. Please link valid robot & iSeqReference.
	 * You can't link null reference, so the entire code doesn't
	 * need null-pointer exception check.
	 * 
	 * @param robotReference
	 */
	public RobotController(Robot robotReference, InstructionIO iSeqReference, BGM music, int period)
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
		}
		
		// Start the clock
		start();
	}
	
	/**
	 * Extends running threads
	 */
	@Override
	public final void run()
	{
		// Loop
		while(true)
		{
			// Check the pointer's validation and assign them.
			if(iSequence.size() > 0 && isDancing)
			{
				// Move pointer to next one.
				if(!musicMode || (musicMode && bgm.getData(0) > 0.4))
				{
					// Do some nice things
					robot.applyInstruction(iSequence.get(pointer));
					
					pointer = (pointer + 1)%iSequence.size();
				}
			}
			
			// Rest
			try
			{
				if(musicMode)
				{
					sleep(10);
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
	}
	
	public void setMusicMode(boolean t)
	{
		musicMode = t;
	}
}
