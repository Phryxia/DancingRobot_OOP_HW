package Temporary_Taein;
import javax.swing.*;
import java.awt.*;

public class keyframe extends JPanel {
	public animation_1 anim1 = new animation_1 ();
	public animation_2 anim2 = new animation_2 ();
	
	public keyframe () {
		setLayout(new GridLayout(1, 2, 0, 0));
		add(anim1);
		add(anim2);
	}
}