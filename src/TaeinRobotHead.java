import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Drawing class of RobotHead.
 * 
 * @author UlnamSong(Taein Kim)
 */
public class TaeinRobotHead extends GRobotPart implements ColorModule {

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
	public TaeinRobotHead(String name, double x, double y, double radius) {		
		super(name, x, y);
		this.radius = radius;
		
		cList = new Color[4];
		cList[BODY_LINE] = new Color(120, 120, 120);
		cList[BODY_FILL] = new Color(120, 120, 120);
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
		g2d.drawRect((int)(-radius/2), (int)(-radius/2) + 14, (int)radius, (int)radius - 20);
		g2d.setColor(cList[BODY_FILL]);
		g2d.fillRect((int)(-radius/2), (int)(-radius/2) + 14, (int)radius, (int)radius - 20);
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawRect((int)(-radius/2), (int)(-radius/2) + 24, (int)radius, 20);
		g2d.fillRect((int)(-radius/2), (int)(-radius/2) + 24, (int)radius, 20);
		g2d.setColor(Color.WHITE);
		g2d.drawString(" --  --", (int)(-radius/2) + 5, (int)(-radius/2) + 40);
	}
}
