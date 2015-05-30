import java.awt.*;

/**
 * Cute class to support Drawable with preserving good encapsulation.
 * Make users to make their own robot, but also give common Must-methods.
 *  
 * @author Se-Kyu-Kwon
 */
public abstract class GRobot extends Robot implements Drawable {
	
	public GRobot(String name) {
		super(name);
	}

	/**
	 * Common drawing method to assure being working on any paintComponent.
	 * 
	 * You can't override this function, because this is really important
	 * method, and you have to know what g2d does inside of this objects.
	 * 
	 * You have to decide roobt's appearance in setAppearance(String name).
	 */
	public final void draw(Graphics2D g2d) {
		if(root != null && root instanceof GRobotPart) {
			((GRobotPart)root).draw(g2d);
		}
	}
}
