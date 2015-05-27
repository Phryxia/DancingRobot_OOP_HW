import java.util.ArrayList;

/**
 * Class RobotBody represent robot body.
 * 
 * @author Se-Kyu-Kwon
 *
 */
public class RobotBody extends RobotPart {
	// Attribute
	protected double width;
	protected double height;
	
	/**
	 * Constructor. You must define robot's width & height explicitly.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public RobotBody(String name, double x, double y, double width, double height) {
		super(name, x, y);
		
		this.width = width;
		this.height = height;
	}
}
