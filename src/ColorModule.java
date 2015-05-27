import java.awt.Color;

/**
 * Interface ColorModule make class able to
 * set and get it's partial color.
 * 
 * @author Phryxia
 *
 */
public interface ColorModule {
	/**
	 * Get it's partial color.
	 * You must offer static color id to user.
	 * 
	 * @param color_id
	 * @return
	 */
	public abstract Color getColor(int color_id);
	
	/**
	 * Change it's partial color.
	 * You must offer static color id to user.
	 * 
	 * @param color_id
	 * @param c
	 */
	public abstract void setColor(int color_id, Color c);
}
