import java.awt.*;

/**
 * Drawing class of RobotHead. (Owner : Se Kyu Kwon)
 * 
 * @author Se-Kyu-Kwon
 */
public class SeKyuRobotHead extends GRobotPart implements ColorModule {

	// Attribution
	public static final int BODY_LINE = 0;
	public static final int BODY_FILL = 1;
		
	private Color[] cList;
	
	protected double radius;
	
	/**
	 * Constructor with color initialization
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @param radius
	 */
	public SeKyuRobotHead(String name, double x, double y, double radius) {		
		super(name, x, y);
		this.radius = radius;
		
		cList = new Color[4];
		cList[BODY_LINE] = Color.BLACK;
		cList[BODY_FILL] = Color.BLACK;
	}
	
	public double setRadius(double r) {
		return (radius = r);
	}
	
	public double getRadius() {
		return radius;
	}
	
	@Override
	public Color getColor(int color_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(int color_id, Color c) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Your own drawing method.
	 * 
	 * @param g2d
	 */
	public void drawDefine(Graphics2D g2d) {
		// Start Drawing
		g2d.setColor(cList[BODY_LINE]);
		g2d.drawRect((int)(-radius/2), (int)(-radius/2), (int)radius, (int)radius);
		g2d.setColor(cList[BODY_FILL]);
		g2d.fillRect((int)(-radius/2), (int)(-radius/2), (int)radius, (int)radius);
		g2d.setColor(Color.WHITE);
		g2d.drawString(" бс  бс ", (int)(-radius/2) + 5, (int)(-radius/2) + 25);
	}
}
