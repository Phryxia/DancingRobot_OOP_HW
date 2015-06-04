import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Drawing class of RobotBody.
 * Made by UlnamSong(Taein Kim)
 * 
 * @author UlnamSong
 */
public class TaeinRobotBody extends GRobotPart implements ColorModule {
	
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
	public TaeinRobotBody(String name, double x, double y, double width, double height) {
		super(name, x, y);
		
		this.width = width;
		this.height = height;
		
		cList = new Color[4];
		cList[BODY_LINE] = new Color(0, 0, 0);
		cList[BODY_FILL] = new Color(53, 176, 186);
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
		g2d.drawRoundRect((int)(-width/2), (int)(-height/2), (int)width, (int)height + 50, 3, 3);
		g2d.setColor(cList[BODY_FILL]);
		g2d.fillRoundRect((int)(-width/2), (int)(-height/2), (int)width, (int)height + 50, 3, 3);
				
		// Draw Text
		g2d.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		g2d.setColor(Color.WHITE);
		g2d.drawString("²ÞÀÌ ÀÖ¾î¿ä", -45, 0);
	}
}