import java.util.ArrayList;

/**
 * class Instruction represent an order to
 * make robot take specfic shape.
 * 
 * Every instruction can be transfered to
 * RobotPart by using recursive algorithm.
 * 
 * An instruction has Vector2D & Double, which represent
 * desiredPosition & desiredAngle state.
 * 
 * For example, suppose there is robot structure like:
 * 
 * Body
 * L... LHand
 *      L... LFinger
 * L... RHand
 *      L... RFinger
 *      
 * You want to move them as specified instructions.
 * 
 * [0, 0, 1]
 * L... [0, 0, 30]
 *      L... [0, 0, -10]
 * L... [0, 0, -30]
 *      L... [0, 0, -10]
 * 
 * Then you have to construct like this
 * 
 * Instruction i1 = new Instruction(0, 0, 1);
 * Instruction i2 = i1.add(new Instruction(0, 0, 30));
 * Instruction i3 = i3.add(new Instruction(0, 0, -30));
 * Instruction i4 = i2.add(new Instruction(0, 0, -10));
 * Instruction i5 = i3.add(new Instruction(0, 0, -10));
 * 
 * Or you may want to use VLP style:
 * 
 * Instruction i1 = new Instruction(0, 0, 1);
 * i1.add(new Instruction(0, 0, 30));
 * i1.add(new Instruction(0, 0, -30));
 * i1.add(new Instruction(0, 0, 30));
 * i1.add(new Instruction(0, 0, -10), 0);
 * i1.add(new Instruction(0, 0, -10), 0);
 * 
 * @author Se-Kyu-Kwon
 *
 */
public class Instruction {
	private Vector2D desiredPos;
	private double   desiredAngle;
	private ArrayList <Instruction> child;
	
	public Instruction(double x, double y, double theta) {
		desiredPos = new Vector2D(x, y);
		desiredAngle = theta;
		child = new ArrayList <Instruction> (4);
	}
	
	public Vector2D setDesiredPos(double x, double y) {
		return desiredPos.set(x, y);
	}
	
	public Vector2D getDesiredPos() {
		return desiredPos;
	}
	
	public double setDesiredAngle(double theta) {
		return (desiredAngle = theta);
	}
	
	public double getDesiredAngle() {
		return desiredAngle;
	}
	
	/**
	 * Easy method to add instruction. The Variable-Length-Parameter
	 * indicates sequence of child number, where new instruction should be
	 * added.
	 * 
	 * For example, if you want to add instruction to the root, then you
	 * don't have to provide any address parameter. But if you want to
	 * add an instruction to second child of first child of root, then
	 * you might have to write as : add(in, 1, 0);
	 * 
	 * 
	 * @param in
	 * @param root
	 * @param address
	 * @return
	 */
	public Instruction add(Instruction in, int ... address) {
		return Instruction.add(in, this, 0, address);
	}
	
	public Instruction getChild(int index) {
		return child.get(index);
	}
	
	/**
	 * Helper method to implement static add.
	 * @param in
	 * @param where
	 * @param depth
	 * @param address
	 * @return
	 */
	private static Instruction add(Instruction in, Instruction where, int depth, int ... address) {
		if(depth == address.length) {
			where.child.add(in);
			return in;
		}
		else {
			return Instruction.add(in, where.child.get(address[depth]), depth+1, address);
		}
	}
	
	/**
	 * (Not) Simple toString. Format likes as below
	 * 
	 * ex)
	 * [a, b, c]
	 *    [d, e, f]
	 *    [g, h, i]
	 *       [u, v, w]
	 *    [x, y, z]
	 */
	public String toString() {
		return toStringR(0);
	}
	
	/**
	 * Helper method to implement toString.
	 * 
	 * @param depth : to make indent.
	 * @return
	 */
	private String toStringR(int depth) {
		String result = "";
		for(int i=0; i<depth; ++i) {
			result += "   ";
		}
		result += "[" + desiredPos.x + ", " + desiredPos.y + ", " + desiredAngle + "]\n";
		
		for(Instruction in : child) {
			result += in.toStringR(depth+1);
		}
		return result;
	}
}
