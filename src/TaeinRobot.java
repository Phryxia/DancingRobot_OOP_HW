/**
 * Strange Robot for Me.
 * 
 * @author Ulnamsong (Taein Kim)
 */
public class TaeinRobot extends GRobot {

	public TaeinRobot(String name) {
		super(name);
	}

	@Override
	public void setAppearance(String name) {
		// Null Pointer Check
		if(name == null) {
			name = "null";
		}
		root = new TaeinRobotBody(name + "_body", 0, 0, 100, 100);
		
		TaeinRobotArm larm = (TaeinRobotArm)root.add(new TaeinRobotArm(name + "_left_arm", -50, -35, 70, 10));
		larm.setCurrentAngle(Math.PI/2);
		
		TaeinRobotArm rarm = (TaeinRobotArm)root.add(new TaeinRobotArm(name + "_right_arm", 50, -35, 70, 10));
		rarm.setCurrentAngle(Math.PI/2);
		
		TaeinRobotHead head = (TaeinRobotHead)root.add(new TaeinRobotHead(name + "_head", 0, -80, 60));
		
		TaeinRobotArm lleg = (TaeinRobotArm)root.add(new TaeinRobotArm(name + "_left_leg", -30, 50, 70, 10));
		lleg.setCurrentAngle(Math.PI/2);
		
		TaeinRobotArm rleg = (TaeinRobotArm)root.add(new TaeinRobotArm(name + "_right_leg", 30, 50, 70, 10));
		rleg.setCurrentAngle(Math.PI/2);
	}
}
