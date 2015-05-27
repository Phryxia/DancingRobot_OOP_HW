/**
 * RobotArm represent abstract robot arms.
 * It has center point and can rotate.
 * 
 * @author Se-Kyu-Kwon
 *
 */
public class RobotArm extends RobotPart {
	
	protected double length;
	protected double weight;
	
	/**
	 * Constructor. 
	 * 
	 * @param x
	 * @param y
	 */
	public RobotArm(String name, double x, double y, double length, double weight)
	{
		super(name, x, y);
		
		this.length = length;
		this.weight = weight;
	}
}
