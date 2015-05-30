import java.util.ArrayList;

/**
 * Todo List
 * 
 * - Bug : getAbsolutePosition - Unmatched. (Not Accurate)
 */

/**
 * Abstract class RobotPart represents independent
 * robot parts. Each part can have several RobotParts.
 * 
 * This is kind of tree node.
 * 
 * @author Se-Kyu-Kwon
 */
public abstract class RobotPart implements Servo {
	// Attribute
	protected String    name;
	protected Vector2D  position;
	protected RobotPart root;
	protected ArrayList <RobotPart> subParts;
	
	private Damper angle;
	
	/**
	 * Constructor with name. (name is used to search part)
	 * 
	 * @param name
	 * @param x
	 * @param y
	 */
	public RobotPart(String name, double x, double y) {
		this.name = name;
		position = new Vector2D(x, y);
		root     = null;
		subParts = new ArrayList <RobotPart> (5);
		
		angle = new Damper(0, 0.1);
	}
	
	/**
	 * Return it's subParts. Don't abuse this function.
	 * 
	 * @return
	 */
	public ArrayList <RobotPart> getSubParts() {
		return subParts;
	}
	
	/**
	 * Search and return RobotPart which name is 'targetName'
	 * If there is no such element, null will be returned
	 * 
	 * @param targetName
	 * @return
	 */
	public RobotPart search(String targetName) {
		if(targetName.equals(name)) {
			return this;
		}
		else {
			RobotPart temp;
			for(RobotPart e : subParts) {
				temp = e.search(targetName);
				
				if(temp != null) {
					return temp;
				}
			}
			return null;
		}
	}
	
	/**
	 * Add new RobotPart to this system. You can't add RobotPart
	 * which name is same to one that already exists.
	 * 
	 * @param newPart
	 * @return newPart
	 */
	public RobotPart add(RobotPart newPart) {
		if(search(newPart.name) != null) {
			throw new IllegalArgumentException("[RobotPart] Can't have duplicated name : " + newPart.name);
		}
		else {	
			subParts.add(newPart);
			newPart.root = this;
			return newPart;
		}
	}
	
	/**
	 * Remove name-specified part. Yet, you can't remove root part.
	 * If removing completed, true will be returnend.
	 * Other wise false will be returned.
	 */
	public boolean remove(String targetName) {
		/*
		 * Search from my subParts
		 */
		for(int i=0; i<subParts.size(); ++i) {
			if(subParts.get(i).name.equals(targetName)) {
				// First, change root of target's childs
				for(RobotPart e : subParts.get(i).subParts) {
					e.root = this;
				}
				subParts.remove(i);
				return true;
			}
		}
		
		/*
		 * Search from child's subParts
		 */
		boolean flag;
		for(int i=0; i<subParts.size(); ++i) {
			flag = subParts.get(i).remove(targetName);
			
			if(flag) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Move this parts as specified difference.
	 * 
	 * @param dx
	 * @param dy
	 */
	public void move(double dx, double dy) {
		position.translate(dx, dy);
	}
	
	/**
	 * Return current relative position
	 * 
	 * @return
	 */
	public Vector2D getRelativePosition() {
		return new Vector2D(position);
	}
	
	/**
	 * Position stored in this part is relative-coordination
	 * to Root. This method will calculate absolute level
	 * coordination of this by using recursive algorithm.
	 * 
	 * @return
	 */
	public Vector2D getAbsolutePosition() {
		Vector2D result = new Vector2D(position);
		
		// Calculate from root's position.
		if(root != null) {
			result.rotate(root.angle.getCurrent()); // Follow root's angle
			result.add(root.getAbsolutePosition());
		}
		
		return result;
	}
	
	/**
	 * Return it's relative angular position.
	 * This is completly same as getCurrentAngle()
	 * 
	 * @return
	 */
	public double getRelativeAngle() {
		return getCurrentAngle();
	}
	
	/**
	 * Return it's absolute angular position.
	 * Note that method from Servo is relative angular.
	 * 
	 * @return
	 */
	public double getAbsoluteAngle() {
		if(root == null) {
			return getCurrentAngle();
		}
		else {
			return getCurrentAngle() + root.getAbsoluteAngle();
		}
	}
	
	/**
	 * Servo Methods
	 */
	@Override
	public Vector2D getCenter()
	{
		return position;
	}

	@Override
	public void setCenter(Vector2D center)
	{
		position.set(center);
	}

	@Override
	public double getCurrentAngle()
	{
		return angle.getCurrent();
	}

	@Override
	public void setCurrentAngle(double theta)
	{
		angle.setDestination(theta);
	}

	@Override
	public void rotate(double theta)
	{
		angle.setDestination(angle.getDestination() + theta);
	}
	
	/**
	 * Apply single instruction to current RobotPart.
	 * 
	 * @param ins
	 */
	public void applyInstruction(Instruction ins) {
		position.set(ins.position);
		setCurrentAngle(ins.angle);
	}
	
	/**
	 * Investigate how many children exist in this system.
	 * Use recursive algortihm.
	 * 
	 * @return
	 */
	public int size() {
		int result = 1; // Count itself
		for(RobotPart rp : subParts) {
			result += rp.size();
		}
		return result;
	}
}
