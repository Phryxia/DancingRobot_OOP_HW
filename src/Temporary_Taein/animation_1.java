package Temporary_Taein;
import java.awt.*;
import javax.swing.*;

public class animation_1 extends JPanel {
	public option_list_1 ol1;
	public text_field_1  tf1;
	
	public animation_1 () {
		setLayout(new FlowLayout());
		ol1 = new option_list_1 ();
		tf1 = new text_field_1  ();
		add(ol1);
		add(tf1);
	}
}
