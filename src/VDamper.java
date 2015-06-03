/**
 * Vector2D Version of Damper
 * 
 * @author Se-Kyu-Kwon
 */
public class VDamper extends Thread
{
	private Vector2D destination;
	private Vector2D current;
	private double   damp_rate;
	
	public VDamper(Vector2D v1, double init_rate)
	{
		destination = new Vector2D(v1);
		current     = new Vector2D(v1);
		damp_rate   = init_rate;
		
		start();
	}
	
	public void run()
	{
		while(!isInterrupted())
		{
			current.translate((destination.x() - current.x())*damp_rate,
					(destination.y() - current.y())*damp_rate);
			
			try
			{
				sleep(10);
			}
			catch(Exception e)
			{
			}
		}
	}
	
	public void setDestination(Vector2D v)
	{
		destination.set(v);
	}
	
	public Vector2D getDestination()
	{
		return destination;
	}
	
	public Vector2D getCurrent()
	{
		return current;
	}
}
