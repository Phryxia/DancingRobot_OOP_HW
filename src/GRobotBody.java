import java.awt.*;

/**
 * Drawing class of RobotBody. (Owner : Se Kyu Kwon)
 * 
 * @author Se-Kyu-Kwon
 */
public class GRobotBody extends GRobotPart implements ColorModule {
	
	public static final int BODY_LINE = 0;
	public static final int BODY_FILL = 1;
	
	private Color[] cList;
	
	// Attribute
	protected double width;
	protected double height;
	
	/**
	 * Constructor from super, but initialize color list.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public GRobotBody(String name, double x, double y, double width, double height) {
		super(name, x, y);
		
		this.width = width;
		this.height = height;
		
		cList = new Color[4];
		cList[BODY_LINE] = Color.BLACK;
		cList[BODY_FILL] = Color.RED;
	}
	
	/**
	 * Get robot's specific color
	 * 
	 * ex: getColor(GRobotBody.BODY_LINE);
	 */
	@Override
	public Color getColor(int color_id) {
		return cList[color_id];
	}
	
	/**
	 * Change robot's color information.
	 * Use static id in this class.
	 * (ex: setColor(GRobotBody.BODY_FILL, Color.RED));
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
		// Draw Body
		g2d.setColor(cList[BODY_LINE]);
		g2d.drawRect((int)(-width/2), (int)(-height/2), (int)width, (int)height);
		g2d.setColor(cList[BODY_FILL]);
		g2d.fillRect((int)(-width/2), (int)(-height/2), (int)width, (int)height);
				
		// Draw Text
		g2d.setFont(new Font("Gulim", Font.PLAIN, 25));
		g2d.setColor(Color.WHITE);
		g2d.drawString("I ¢¾ Robot", -45, 0);
	}
}
