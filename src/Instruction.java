/**
 * Instruction class represent the specific robot's
 * motion state.
 * 
 * Each robots have their own joint structure. For
 * example, a robot might have two legs, two hands,
 * one head. Also you may want to move them sperately.
 * 
 * Instruction allows to do such things. One instruc-
 * tion has two values: Position & Angle.
 * 
 * @author Se-Kyu-Kwon
 *
 */
public class Instruction {
	public Vector2D position;
	public int angle;
	
	public static final Instruction NO_CHANGE = new Instruction(0, 0, -1);
	
	/**
	 * Constructor. Note that argument will be copied.
	 * (Doesn't store it's reference)
	 * 
	 * theta should be represented in 60-degree
	 * 
	 * @param position
	 * @param angle
	 */
	public Instruction(Vector2D position, int theta) {
		if(position == null) {
			throw new NullPointerException("[Instruction : Constructor] Null Vector2D Argument");
		}
		else {
			this.position = new Vector2D(position);
			angle = theta;
		}
	}
	
	/**
	 * Copy Constructor. Null reference will be considered as NO_CHANGE
	 * 
	 * @param ins
	 */
	public Instruction(Instruction ins) {
		if(ins == null) {
			position = new Vector2D(0, 0);
			angle    = -1;
		}
		else {
			position = new Vector2D(ins.position);
			angle    = ins.angle;
		}
	}
	
	/**
	 * Constructor with primitive parameters.
	 * 
	 * @param x
	 * @param y
	 * @param angle
	 */
	public Instruction(double x, double y, int theta) {
		position = new Vector2D(x, y);
		angle = theta;
	}
	
	/**
	 * Simple toString method
	 */
	@Override
	public String toString() {
		return "[" + position.x() + ", " + position.y() + ", " + angle + "]";
	}
}
