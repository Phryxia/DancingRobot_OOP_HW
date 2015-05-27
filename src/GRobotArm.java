import java.awt.*;
import java.awt.geom.*;

public class GRobotArm extends RobotArm implements Drawable, ColorModule {
	// Attribution
	public static final int BODY_LINE = 0;
	public static final int BODY_FILL = 1;
	
	private Color[] cList;
	
	// Don't touch if you don't know what you are doing
	private AffineTransform matrix;
	
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
		super(name, x, y, length, weight);
		
		cList = new Color[4];
		cList[BODY_LINE] = Color.BLACK;
		cList[BODY_FILL] = Color.RED;
	}

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
	 * Draw robot arm using transformation.
	 */
	@Override
	public void draw(Graphics2D g2d) {
		double   temp_angle  = getCurrentAngle(); // To ensure thread safety
		Vector2D absolutePos = getAbsolutePosition();
		
		// Transformation
		g2d.translate(absolutePos.x, absolutePos.y);
		g2d.rotate(temp_angle);
		
		// Start Drawing
		g2d.setColor(cList[BODY_LINE]);
		g2d.drawRect(-20, (int)(-weight/2), (int)length, (int)weight);
		g2d.setColor(cList[BODY_FILL]);
		g2d.fillRect(-20, (int)(-weight/2), (int)length, (int)weight);
		
		// Inverse-Transformation
		g2d.rotate(-temp_angle);
		g2d.translate(-absolutePos.x, -absolutePos.y);
		
		// Draw attached subParts
		for(RobotPart e : subParts) {
			if(e instanceof Drawable) {
				((Drawable) e).draw(g2d);
			}
		}
	}

}
