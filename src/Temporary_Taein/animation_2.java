package Temporary_Taein;
import java.awt.*;
import javax.swing.*;

public class animation_2 extends JPanel {
	public option_list_2 ol2;
	public text_field_2  tf2;
	
	public animation_2 () {
		setLayout(new FlowLayout());
		ol2 = new option_list_2 ();
		tf2 = new text_field_2  ();
		add(ol2);
		add(tf2);
	}
}
