/**
 * My first robot in my life!!!!!
 * 
 * @author Se-Kyu-Kwon
 */
public class SeKyuRobot extends GRobot {

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
		larm.setCurrentAngle(Math.PI/2);
		
		SeKyuRobotArm rarm = (SeKyuRobotArm)root.add(new SeKyuRobotArm(name + "_right_arm", 50, -35, 80, 20));
		rarm.setCurrentAngle(Math.PI/2);
		
		SeKyuRobotHead head = (SeKyuRobotHead)root.add(new SeKyuRobotHead(name + "_head", 0, -80, 60));
		
		SeKyuRobotArm lleg = (SeKyuRobotArm)root.add(new SeKyuRobotArm(name + "_left_leg", -30, 50, 100, 20));
		lleg.setCurrentAngle(Math.PI/2);
		
		SeKyuRobotArm rleg = (SeKyuRobotArm)root.add(new SeKyuRobotArm(name + "_right_leg", 30, 50, 100, 20));
		rleg.setCurrentAngle(Math.PI/2);
	}
}
