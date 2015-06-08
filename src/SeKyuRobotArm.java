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
public class SeKyuRobotArm extends GRobotPart implements ColorModule, BGMListener {
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
	public SeKyuRobotArm(String name, double x, double y, double length, double weight) {
		super(name, x, y);
		
		this.length = length;
		this.weight = weight;
		
		cList = new Color[4];
		cList[BODY_LINE] = new Color(70, 139, 172);
		cList[BODY_FILL] = new Color(70, 139, 172);
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
		g2d.drawRect(0, (int)Math.round(-weight/2.0), (int)length, (int)weight);
		g2d.setColor(cList[BODY_FILL]);
		g2d.fillRect(0, (int)Math.round(-weight/2.0), (int)length, (int)weight);
	}
	
	public void musicStarted(BGM bgm)
	{
		// Also do with subPart's handling
		for(RobotPart e : subParts)
		{
			if(e instanceof BGMListener)
			{
				((BGMListener) e).musicStarted(bgm);
			}
		}
	}
	
	public void musicStopped(BGM bgm)
	{
		// Also do with subPart's handling
		for(RobotPart e : subParts)
		{
			if(e instanceof BGMListener)
			{
				((BGMListener) e).musicStopped(bgm);
			}
		}
	}
	
	public void musicChanged(BGM bgm)
	{	
		// Also do with subPart's handling
		for(RobotPart e : subParts)
		{
			if(e instanceof BGMListener)
			{
				((BGMListener) e).musicChanged(bgm);
			}
		}
	}
}
