/**
 * Simple mathmatical 2d vector.
 * 
 * Note that coordination in Java uses right +x, down +y.
 * Rotation also obey that rule, so clock-wise direction is
 * positive theta.
 * 
 * @author Se-Kyu-Kwon
 *
 */
public class Vector2D {
	// Data
	public double x;
	public double y;
	
	// Basic Vector
	public static final Vector2D ZERO_VECTOR = new Vector2D(0, 0);
	public static final Vector2D UNIT_VECTOR = new Vector2D(1, 0);
	
	/**
	 * Simple Constructor
	 */
	public Vector2D() {
		x = 0.0;
		y = 0.0;
	}
	
	/**
	 * Initial value specified constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Copy constructor
	 * 
	 * @param v
	 */
	public Vector2D(Vector2D v) {
		x = v.x;
		y = v.y;
	}
	
	/**
	 * Copy this vector.
	 * 
	 * @return
	 */
	public Vector2D get() {
		return new Vector2D(this);
	}
	
	/**
	 * Set this vector as specified parameter and return itself.
	 * 
	 * @param v
	 * @return
	 */
	public Vector2D set(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	/**
	 * Set this vector as specified parameter and return itself.
	 * 
	 * @param v
	 * @return
	 */
	public Vector2D set(Vector2D v) {
		x = v.x;
		y=  v.y;
		return this;
	}
	
	/**
	 * Return this vector's size
	 * 
	 * @return
	 */
	public double size() {
		return Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Return this vector's heading direction in radian.
	 * (-PI ~ PI)
	 * 
	 * @return
	 */
	public double getDirection() {
		return Math.atan2(y, x);
	}
	
	/**
	 * Set this vector to head specific degree and return
	 * itself.
	 * 
	 * @param theta
	 */
	public Vector2D setDirection(double theta) {
		double mag = size();
		x = Math.cos(theta) * mag;
		y = Math.sin(theta) * mag;
		return this;
	}
	
	/**
	 * Move this vector.
	 * 
	 * @param dx
	 * @param dy
	 */
	public Vector2D translate(double dx, double dy) {
		x += dx;
		y += dy;
		return this;
	}
	
	/**
	 * Rotate this vector using 2D transformation and
	 * return itself.
	 * 
	 * @param theta
	 */
	public Vector2D rotate(double theta) {
		double x_temp = x * Math.cos(theta) - y * Math.sin(theta);
		double y_temp = x * Math.sin(theta) + y * Math.cos(theta);
		x = x_temp;
		y = y_temp;
		return this;
	}

	/**
	 * Add one vector to this vector and return itself.
	 * 
	 * @param v
	 * @return this += v
	 */
	public Vector2D add(Vector2D v) {
		x += v.x;
		y += v.y;
		return this;
	}
	
	/**
	 * Subtract one vector to this vector and return itself.
	 * 
	 * @param v
	 * @return this -= v
	 */
	public Vector2D sub(Vector2D v) {
		x -= v.x;
		y -= v.y;
		return this;
	}
	
	/**
	 * Do scalar multiplication to this vector and return itself.
	 * 
	 * @param v
	 * @return this *= k
	 */
	public Vector2D mul(double k) {
		x *= k;
		y *= k;
		return this;
	}
	
	/**
	 * Add Function. Doesn't affect to original things.
	 * 
	 * @param v1
	 * @param v2
	 * @return v1+v2
	 */
	public static Vector2D add(Vector2D v1, Vector2D v2) {
		return new Vector2D(v1.x + v2.x, v1.y + v2.y);
	}
	
	/**
	 * Sub Function. Doesn't affect to original things.
	 * 
	 * @param v1
	 * @param v2
	 * @return v1-v2
	 */
	public static Vector2D sub(Vector2D v1, Vector2D v2) {
		return new Vector2D(v1.x - v2.x, v1.y - v2.y);
	}
	
	/**
	 * Scalar multiplication. Doesn't affect to original things.
	 * 
	 * @param v1
	 * @param k
	 * @return k*v1
	 */
	public static Vector2D mul(Vector2D v1, double k) {
		return new Vector2D(k*v1.x, k*v1.y);
	}
	
	/**
	 * Inner product calculation.
	 * 
	 * @param v1
	 * @param v2
	 * @return v1.v2
	 */
	public static double dotProduct(Vector2D v1, Vector2D v2) {
		return v1.x * v2.x + v1.y * v2.y;
	}
	
	/**
	 * Simple toString which represents this vector as:
	 * 
	 * [0, 0]
	 */
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
