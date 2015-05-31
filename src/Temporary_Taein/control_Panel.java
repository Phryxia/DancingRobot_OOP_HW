package Temporary_Taein;
import javax.swing.*;
import java.awt.*;

public class control_Panel extends JPanel {
	public JCheckBox r1_Active;
	public JCheckBox r2_Active;
	
	public JButton   play_anim;
	public JButton   stop_anim;
	
	public control_Panel () {
		r1_Active = new JCheckBox(" ROBOT1 ACTIVE ");
		r2_Active = new JCheckBox(" ROBOT2 ACTIVE ");
		
		play_anim = new JButton("PLAY ANIMATION");
		stop_anim = new JButton("STOP ANIMATION");
		
		add(r1_Active);
		add(r2_Active);
		add(play_anim);
		add(stop_anim);
	}
	
	public void paint_guide_picture () {
		
	}
}
