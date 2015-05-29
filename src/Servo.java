/**
 * Interface Servo represents rotable objects.
 * Servo is like a mathmatical vector which size
 * is 1 and only have angle.
 * 
 * @author Se-Kyu-Kwon
 *
 */
public interface Servo {
	/**
	 * Return this servo's center point.
	 * 
	 * @return
	 */
	abstract Vector2D getCenter();
	
	/**
	 * Set this servo's center point.
	 * 
	 * @param center
	 */
	abstract void setCenter(Vector2D center);
	
	/**
	 * Return current servo's angle in rad.
	 * 
	 * @return
	 */
	abstract double getCurrentAngle();
	
	/**
	 * Set this servo's angle displacement.
	 * 
	 * @param theta
	 */
	abstract void setCurrentAngle(double theta);
	
	/**
	 * Rotate this servo in amount of theta (in rad)
	 * 
	 * @param theta
	 */
	abstract void rotate(double theta);
}
