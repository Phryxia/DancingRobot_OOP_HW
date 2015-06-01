import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * class Robot represent the dancing robot.
 * It has very essential elements such as
 * coordinate or something else.
 * 
 * 
 * 
 * @author Se-Kyu-Kwon
 *
 */
public abstract class Robot {
	
	/*
	 * Invariant : Central informations are stored in root part.
	 * For example, essential datas such as robot's master position
	 * and angle are stored in root.
	 */
	protected RobotPart root;
	
	/**
	 * You have to give name to your robot.
	 * 
	 * @param name
	 */
	public Robot(String name) {
		setAppearance(name);
	}
	
	/*
	 * Some essential movement. These methods are just that of
	 * RobotPart. The only difference is how much open to
	 * End-User who want to play with their own robot.
	 * 
	 * Because root's modifier classification is 'protected',
	 * you cannot access to root directly outside of robot class.
	 * 
	 * But you still want to control whole body.
	 * That's why I provide these method explicitly.
	 */
	public void move(double dx, double dy) {
		root.move(dx, dy);
	}
	
	public void rotate(double theta) {
		root.rotate(theta);
	}
	
	/**
	 * You must override this method to set your own robot.
	 * You can use super name in the parameter of this method.
	 * 
	 * You have to determine every element's appearance on your
	 * own RobotPart extended class' drawDefine(g2d), and align
	 * them in this method.
	 * 
	 * For example this method may look like:
	 * 
	 * root = new GRobotBody(name + "_body", 200, 200, 100, 100);
	 * GRobotArm larm = (GRobotArm)root.add(new GRobotArm(name + "_larm", 50, 0, 100, 20));
	 * GRobotArm rarm = (GRobotArm)root.add(new GRobotArm(name + "_rarm", -50, 0, 100, 20));
	 * larm.add(new GRobotArm(name + "_laram_finger", ~~));
	 * rarm.add(new GRobotArm(name + "_raram_finger", ~~));
	 */
	public abstract void setAppearance(String name);
	
	/**
	 * Return it's linear order in String[].
	 * This is determined by BFS.
	 * 
	 * @return
	 */
	public ArrayList <String> getNameList() {
		ArrayList <String> result = new ArrayList <String> ();
		Queue <RobotPart> bfs = new LinkedList <RobotPart> ();
		
		if(root != null) {
			bfs.add(root);
		}
		
		// Do BFS traversal and stored their name.
		while(!bfs.isEmpty()) {
			result.add(bfs.peek().name);
			
			for(RobotPart e : bfs.peek().getSubParts()) {
				bfs.add(e);
			}
			
			bfs.poll();
		}
		
		return result;
	}
	
	/**
	 * Apply several multiple instructions to this system.
	 * The order of what part is applied first is determined
	 * by BFS traversal.
	 * 
	 * Null list will be ignored.
	 * 
	 * @param list
	 */
	public void applyInstruction(ArrayList <Instruction> list) {
		// Null Check
		if(list == null) {
			return ;
		}
		
		Queue <RobotPart> bfs = new LinkedList <RobotPart> ();
		int itr = 0; // Iteartor Number
		
		if(root != null) {
			bfs.add(root);
		}
		
		// Do BFS traversal and stored their name.
		while(!bfs.isEmpty() && itr < list.size()) {
			bfs.peek().applyInstruction(list.get(itr++));
			
			// Assign it's child to bfs
			for(RobotPart e : bfs.peek().getSubParts()) {
				bfs.add(e);
			}
			
			bfs.poll();
		}
	}
}
