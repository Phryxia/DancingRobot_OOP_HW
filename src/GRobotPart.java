import java.awt.Graphics2D;


public abstract class GRobotPart extends RobotPart implements Drawable {

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param x
	 * @param y
	 */
	public GRobotPart(String name, double x, double y)
	{
		super(name, x, y);
	}

	/**
	 * Implement draw function from drawable.
	 * You can't override this functino directly.
	 * But you can define your own function by
	 * overriding drawDefine().
	 */
	@Override
	public final void draw(Graphics2D g2d) {
		double   temp_angle  = getAbsoluteAngle(); // To ensure thread safety
		Vector2D absolutePos = getAbsolutePosition();
		
		// Transformation
		g2d.translate(absolutePos.x(), absolutePos.y());
		g2d.rotate(temp_angle);
		
		drawDefine(g2d);
		
		// Inverse-Transformation
		g2d.rotate(-temp_angle);
		g2d.translate(-absolutePos.x(), -absolutePos.y());
		
		// Draw attached subParts
		for(RobotPart e : subParts) {
			if(e instanceof Drawable) {
				((Drawable) e).draw(g2d);
			}
		}
	}
	
	/**
	 * You can define your own drawing method
	 * 
	 * @param g2d
	 */
	public abstract void drawDefine(Graphics2D g2d);
}
