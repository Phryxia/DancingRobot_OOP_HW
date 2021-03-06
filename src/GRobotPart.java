import java.awt.Color;
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
		
		//drawVector(g2d);
		
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
	 * Draw this part's geometric data such as vector & angle.
	 * Only use for debugging purpose.
	 * 
	 * @param g2d
	 */
	protected void drawVector(Graphics2D g2d)
	{
		// Draw Relative Angle
		g2d.setColor(Color.BLACK);
		g2d.drawOval(-5, -5, 10, 10);
		g2d.drawLine(0, 0, 20, 0);
		
		// Draw Relative Position of subParts
		g2d.setColor(Color.YELLOW);
		Vector2D temp;
		for(RobotPart e : subParts)
		{
			temp = e.getRelativePosition();
			
			g2d.drawLine(0, 0, (int)Math.round(temp.x()), (int)Math.round(temp.y()));
		}
	}
	
	/**
	 * You can define your own drawing method
	 * 
	 * @param g2d
	 */
	public abstract void drawDefine(Graphics2D g2d);
}
