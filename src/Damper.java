import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Damper class is a utility to control value
 * to change smoothly. 
 * 
 * @author Se-Kyu-Kwon
 */
public class Damper extends Thread
{
	private double damp_rate;
	private double destination;
	private double current_value;
	private double prev_value;
	
	private double circular_length;
	
	/**
	 * Constructor with specified initial value.
	 * @param init_value
	 * @param init_rate
	 */
	public Damper(double init_value, double init_rate)
	{
		setRate(init_rate);
		setDestination(init_value);
		current_value = destination;
		prev_value = current_value;
		circular_length = 0.0;
		
		start();
	}
	
	/**
	 * Copy Constructor. Null reference will be ignored as 0
	 * 
	 * @param d
	 */
	public Damper(Damper d)
	{
		setRate(d.damp_rate);
		setDestination(d.getDestination());
		current_value = destination;
		prev_value = current_value;
		
		start();
	}
	
	/**
	 * Safely start this with singletonalized this method.
	 * Start should never be called again, and this thread
	 * always starts automatically.
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
	 * Run this thread. Don't use this manually.
	 * Constructor will automatically start & run.
	 */
	@Override
	public void run()
	{
		while(true)
		{
			prev_value = current_value;
			
			if(!isMoving())
			{
				current_value = destination;
			}
			else
			{
				current_value += (destination - current_value)*damp_rate;
			}
			
			try
			{
				sleep(10);
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	/**
	 * Set the current damper's destination
	 * @param x
	 */
	public void setDestination(double x)
	{
		if(circular_length != 0.0)
		{
			x = dmode(x, circular_length);
			
			if(x - destination > circular_length/2.0)
			{
				destination = x - circular_length;
			}
			else if(destination - x > circular_length/2.0)
			{
				destination = x + circular_length;
			}
			else
			{
				destination = x;
			}
		}
		else
		{
			destination = x;
		}
	}
	
	private double dmode(double x, double m)
	{
		if(x > 0)
		{
			return x -= Math.floor(x/m)*m;
		}
		else if(x < 0)
		{
			return x += (Math.ceil(x/m)+1.0)*m;
		}
		else
		{
			return x;
		}
	}
	
	/**
	 * Get the current damper's destination
	 * @return
	 */
	public double getDestination()
	{
		return destination;
	}
	
	/**
	 * Set the current damper's damper rate
	 * @param x
	 */
	public void setRate(double x)
	{
		damp_rate = x;
	}
	
	/**
	 * Get the current damper's value
	 * @return
	 */
	public double getCurrent()
	{
		return current_value;
	}
	
	/**
	 * Return the difference between previous value.
	 * @return
	 */
	public double getDelta()
	{
		return current_value - prev_value;
	}
	
	/**
	 * Whether this damper is changing or not.
	 */
	public boolean isMoving()
	{
		return Math.abs(current_value - destination) > 0.0005;
	}
	
	/**
	 * Set circularity. If you set length as 0.0
	 * the you discard circularity.
	 * 
	 * Circularity makes damper to assume that
	 * value is bounded under circularLength.
	 * 
	 * For example, if the circularLength = TWO_PI
	 * then, changing more then PI will reverse the
	 * direction.
	 * 
	 * @param length
	 */
	public void setCircularLength(double length)
	{
		if(length < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			circular_length = length;
		}
	}
}
