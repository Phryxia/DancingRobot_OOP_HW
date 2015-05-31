import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Robot_Option extends JPanel {
	// Temporary Variable for Testing
	private String aa;
	Text_List_Panel tlp;
	
	public Robot_Option (String test) {
		this.aa = test;
		setLayout(new FlowLayout(FlowLayout.CENTER));
		generate_Panel();
	}
	
	public void generate_Panel () {
		tlp = new Text_List_Panel(aa);
		add(tlp);
	}
}