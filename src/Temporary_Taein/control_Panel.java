/**
 * Control_Panel.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import javax.swing.*;

import java.awt.*;

public class Control_Panel extends JPanel {
	public JCheckBox r1_Active;
	public JCheckBox r2_Active;
	
	public JButton   play_anim;
	public JButton   stop_anim;
	
	public Control_Panel () {
		r1_Active = new JCheckBox(" ROBOT1 ACTIVE ");
		r2_Active = new JCheckBox(" ROBOT2 ACTIVE ");
		
		play_anim = new JButton("PLAY ANIMATION");
		stop_anim = new JButton("STOP ANIMATION");
		
		setBackground(new Color(50, 50, 50));
		r1_Active.setBackground(new Color(50, 50, 50));
		r1_Active.setForeground(new Color(170, 170, 170));
		
		r2_Active.setBackground(new Color(50, 50, 50));
		r2_Active.setForeground(new Color(170, 170, 170));
		
		
		play_anim.setBackground(new Color(0, 100, 147));
		play_anim.setForeground(new Color(255, 255, 255));
		
		stop_anim.setBackground(new Color(0, 100, 147));
		stop_anim.setForeground(new Color(255, 255, 255));
		
		add(r1_Active);
		add(r2_Active);
		add(play_anim);
		add(stop_anim);
	}
	
	public void paint_guide_picture () {
		
	}
}