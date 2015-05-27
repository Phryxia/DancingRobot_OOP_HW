import java.awt.Graphics2D;

/**
 * Drawable object can be draw on JComponent.
 * 
 * For example, let's say GRobot implements Drawable.
 * Then you can use GRobot like this:
 * 
 * (in JComponent class)
 * public void paintComponent(Graphic g) {
 *    GRobot myRobot = new GRobot();
 *    
 *    ...
 *    
 *    myRobot.draw((Graphics2D)g);
 * }
 * 
 * You can't use this kind of object without JFrame or JComponent.
 * 
 * @author Se-Kyu-Kwon
 *
 */
public interface Drawable {
	public abstract void draw(Graphics2D g2d);
}
