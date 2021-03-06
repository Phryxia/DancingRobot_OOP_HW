import java.awt.Color;
import java.util.ArrayList;

/**
 * Strange Robot for Me.
 * 
 * @author Tae-in Kim
 */
public class TaeinRobot extends GRobot {

	private static ArrayList <Instruction> DEFAULT_STATE = null;
	
	public TaeinRobot(String name) {
		super(name);
	}

	@SuppressWarnings("unused")
	@Override
	public void setAppearance(String name) {
		// Check whether Null Pointer Exception is occured
		if(name == null) {
			name = "null";
		}
		root = new TaeinRobotBody(name + "_body", 0, 0, 100, 100);
		
		TaeinRobotArm larm = (TaeinRobotArm)root.add(new TaeinRobotArm(name + "_left_arm", new Color(150, 150, 150), new Color(150, 150, 150), -55, -20, 70, 15));
		larm.setCurrentAngle(Math.PI/2);
		
		TaeinRobotArm rarm = (TaeinRobotArm)root.add(new TaeinRobotArm(name + "_right_arm", new Color(150, 150, 150), new Color(150, 150, 150), 57, -20, 70, 15));
		rarm.setCurrentAngle(Math.PI/2);
		
		TaeinRobotHead head = (TaeinRobotHead)root.add(new TaeinRobotHead(name + "_head", 0, -80, 70));
		
		TaeinRobotArm lleg = (TaeinRobotArm)root.add(new TaeinRobotArm(name + "_left_leg", new Color(60, 60, 60), new Color(60, 60, 60), -30, 60, 100, 25));
		
		TaeinRobotArm rleg = (TaeinRobotArm)root.add(new TaeinRobotArm(name + "_right_leg", new Color(60, 60, 60), new Color(60, 60, 60), 30, 60, 100, 25));
		
		TaeinRobotArm lhand = (TaeinRobotArm)larm.add(new TaeinRobotArm(name + "_left_hand", new Color(100, 100, 100), new Color(100, 100, 100), 55, 11, 20, 20));
		
		TaeinRobotArm rhand = (TaeinRobotArm)rarm.add(new TaeinRobotArm(name + "_right_hand", new Color(100, 100, 100), new Color(100, 100, 100), 55, 11, 20, 20));
		
		TaeinRobotArm lfoot = (TaeinRobotArm)lleg.add(new TaeinRobotArm(name + "_left_hand", new Color(0, 0, 0), new Color(0, 0, 0), 90, 8, 10, 40));
		
		TaeinRobotArm rfoot = (TaeinRobotArm)rleg.add(new TaeinRobotArm(name + "_right_hand", new Color(0, 0, 0), new Color(0, 0, 0), 90, -7, 10, 40));
		
		reset();
	}
	
	/**
	 * Reset current robot's motion state into default.
	 */
	public void reset() {
		// Construct DEFAULT_STATE only once.
		if(DEFAULT_STATE == null) {
			DEFAULT_STATE = new ArrayList <Instruction> (1);
			DEFAULT_STATE.add(new Instruction(0, 0, 0));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
			DEFAULT_STATE.add(new Instruction(0, 0, 0));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
		}
		
		applyInstruction(DEFAULT_STATE);
	}
}
