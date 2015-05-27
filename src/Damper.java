import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Damper class is a utility to control value
 * to change smoothly. 
 * 
 * @author Phryxia
 */
public class Damper
{
	private double damp_rate;
	private double destination;
	private double current_value;
	private Timer  timer;
	
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
		
		class DamperListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				current_value += (destination - current_value)*damp_rate;
			}	
		}
		
		timer = new Timer(10, new DamperListener());
		timer.start();
	}
	
	/**
	 * Set the current damper's destination
	 * @param x
	 */
	public void setDestination(double x)
	{
		destination = x;
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
	
	/*
	 * Whether this damper is changing or not.
	 */
	public boolean isMoving()
	{
		return Math.abs(current_value - destination) > 0.00001;
	}
}
