import java.util.ArrayList;

/**
 * My first robot in my life!!!!!
 * 
 * @author Se-Kyu-Kwon
 */
public class SeKyuRobot extends GRobot implements BGMListener {
	
	private static ArrayList <Instruction> DEFAULT_STATE = null;
	
	public SeKyuRobot(String name) {
		super(name);
	}

	@Override
	public void setAppearance(String name) {
		// Null Pointer Check
		if(name == null) {
			name = "null";
		}
		root = new SeKyuRobotBody(name + "_body", 0, 0, 100, 100);
		
		SeKyuRobotArm larm = (SeKyuRobotArm)root.add(new SeKyuRobotArm(name + "_left_arm", -50, -35, 80, 20));
		
		SeKyuRobotArm rarm = (SeKyuRobotArm)root.add(new SeKyuRobotArm(name + "_right_arm", 50, -35, 80, 20));
		
		SeKyuRobotHead head = (SeKyuRobotHead)root.add(new SeKyuRobotHead(name + "_head", 0, -80, 60));
		
		SeKyuRobotArm lleg = (SeKyuRobotArm)root.add(new SeKyuRobotArm(name + "_left_leg", -30, 50, 100, 20));
		
		SeKyuRobotArm rleg = (SeKyuRobotArm)root.add(new SeKyuRobotArm(name + "_right_leg", 30, 50, 100, 20));
		
		SeKyuRobotArm larm_arm1 = (SeKyuRobotArm)larm.add(new SeKyuRobotArm(name + "_left_armarm", 70, 0, 20, 20));
		
		SeKyuRobotArm rarm_arm1 = (SeKyuRobotArm)rarm.add(new SeKyuRobotArm(name + "_right_armarm", 70, 0, 20, 20));
		
		reset();
	}
	
	/**
	 * Reset current robot's motion state into default.
	 */
	public void reset()
	{
		// Construct DEFAULT_STATE only once.
		if(DEFAULT_STATE == null)
		{
			DEFAULT_STATE = new ArrayList <Instruction> (1);
			
			DEFAULT_STATE.add(new Instruction(0, 0, 0));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
			DEFAULT_STATE.add(new Instruction(0, 0, 0));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
			DEFAULT_STATE.add(new Instruction(0, 0, 90));
		}
		
		applyInstruction(DEFAULT_STATE);
	}
	
	public void musicStarted(BGM bgm)
	{
		if(root instanceof BGMListener)
		{
			((BGMListener)root).musicStarted(bgm);
		}
	}
	
	public void musicStopped(BGM bgm)
	{
		if(root instanceof BGMListener)
		{
			((BGMListener)root).musicStopped(bgm);
		}
	}
	
	public void musicChanged(BGM bgm)
	{
		if(root instanceof BGMListener)
		{
			((BGMListener)root).musicChanged(bgm);
		}
	}
}
