import java.awt.*;
import java.awt.geom.*;

/**
 * Drawing class of RobotArm. (Owner : Se Kyu Kwon)
 * 
 * Hey You!!!!! ToDo!!!!!
 * 
 * Extends GRobotPart to this class and remove draw function
 * 
 * @author Se-Kyu-Kwon
 */
public class GRobotArm extends GRobotPart implements ColorModule {
	// Attribution
	public static final int BODY_LINE = 0;
	public static final int BODY_FILL = 1;
	
	private Color[] cList;
	
	/**
	 * Constructor 
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param length
	 * @param weight
	 */
	public GRobotArm(String name, double x, double y, double length, double weight) {
		super(name, x, y);
		
		this.length = length;
		this.weight = weight;
		
		cList = new Color[4];
		cList[BODY_LINE] = Color.BLACK;
		cList[BODY_FILL] = Color.RED;
	}
	
	protected double length;
	protected double weight;

	/**
	 * Get this part's specific color.
	 * 
	 * ex: getColor(GRobotArm.BODY_LINE);
	 */
	@Override
	public Color getColor(int color_id) {
		return cList[color_id];
	}
	
	/**
	 * Change this part's partial color.
	 * Use static id in this class.
	 * (ex: setColor(GRobotArm.BODY_FILL, Color.RED));
	 * 
	 * @param color_id
	 * @param c
	 */
	@Override
	public void setColor(int color_id, Color c) {
		cList[color_id] = c;
	}
	
	/**
	 * Your own drawing method.
	 * 
	 * @param g2d
	 */
	public void drawDefine(Graphics2D g2d) {
		// Start Drawing
		g2d.setColor(cList[BODY_LINE]);
		g2d.drawRect(-20, (int)(-weight/2), (int)length, (int)weight);
		g2d.setColor(cList[BODY_FILL]);
		g2d.fillRect(-20, (int)(-weight/2), (int)length, (int)weight);
	}
}
