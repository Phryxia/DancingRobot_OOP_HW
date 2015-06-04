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
	protected VDamper   position;
	protected RobotPart root;
	protected ArrayList <RobotPart> subParts;
	
	protected Damper angle; // in Radian
	
	/**
	 * Constructor with name. (name is used to search part)
	 * 
	 * @param name
	 * @param x
	 * @param y
	 */
	public RobotPart(String name, double x, double y) {
		// Null Check
		if(name == null) {
			throw new NullPointerException("[RobotPart : Constructor] Null name cannot be used");
		}
		
		this.name = name;
		position = new VDamper(new Vector2D(x, y), 0.07);
		root     = null;
		subParts = new ArrayList <RobotPart> (5);
		
		angle = new Damper(0, 0.07);
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
	 * If there is no such element, null will be returned.
	 * Null input will return null reference.
	 * 
	 * @param targetName
	 * @return
	 */
	public RobotPart search(String targetName) {
		// Null Check
		if(targetName == null) {
			return null;
		}
		else if(targetName.equals(name)) {
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
		// Null Check
		if(newPart == null) {
			throw new NullPointerException("[RobotPart : add] You can't add null object");
		}
		if(search(newPart.name) != null) {
			throw new IllegalArgumentException("[RobotPart : add] Can't have duplicated name : " + newPart.name);
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
		// Null Pointer Handling
		if(targetName == null) {
			return false;
		}
		
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
		position.getDestination().translate(dx, dy);
	}
	
	/**
	 * Return current relative position
	 * 
	 * @return
	 */
	public Vector2D getRelativePosition() {
		return new Vector2D(position.getCurrent());
	}
	
	/**
	 * Position stored in this part is relative-coordination
	 * to Root. This method will calculate absolute level
	 * coordination of this by using recursive algorithm.
	 * 
	 * @return
	 */
	public Vector2D getAbsolutePosition() {
		Vector2D result = new Vector2D(position.getCurrent());
		
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
		return position.getCurrent();
	}

	/**
	 * Null reference will be ignored.
	 */
	@Override
	public void setCenter(Vector2D center)
	{
		// Null pointer handling	
		if(center == null) {
			System.out.println("[RobotPart : setCenter] Note : A null argument was ignored.");
		}
		else {
			position.getDestination().set(center);
		}
		
	}
	
	/**
	 * Use radian unit.
	 */
	@Override
	public double getCurrentAngle()
	{
		return angle.getCurrent();
	}
	/**
	 * Use radian unit.
	 */
	@Override
	public void setCurrentAngle(double theta)
	{
		angle.setDestination(theta);
	}

	/**
	 * Use radian unit.
	 */
	@Override
	public void rotate(double theta)
	{
		angle.setDestination(angle.getDestination() + theta);
	}
	
	/**
	 * Apply single instruction to current RobotPart.
	 * Note that angle must within 0 ~ 360 otherwise no change.
	 * 
	 * Note that Instruction has 60-degree angle so that you
	 * have to convert it in radian.
	 * 
	 * Null instruction will be ignored.
	 * 
	 * @param ins
	 */
	public void applyInstruction(Instruction ins) {
		// Null Pointer Check : Just ignore null argument.
		if(ins == null) {
			return ;
		}
		position.getDestination().add(ins.position);
		
		if(ins.angle != -1) {
			setCurrentAngle(Math.PI/180*ins.angle);
		}
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
