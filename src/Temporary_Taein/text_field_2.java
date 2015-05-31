package Temporary_Taein;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class text_field_2 extends JPanel {
	
	public JTextField neck_2 = new JTextField(3);
	public JTextField larm_2 = new JTextField(3);
	public JTextField rarm_2 = new JTextField(3);
	public JTextField lleg_2 = new JTextField(3);
	public JTextField rleg_2 = new JTextField(3);
	
	public JLabel     neck   = new JLabel("Neck : ");
	public JLabel     larm   = new JLabel("Left Arm : ");
	public JLabel     rarm   = new JLabel("Right Arm : ");
	public JLabel     lleg   = new JLabel("Left Leg : ");
	public JLabel     rleg   = new JLabel("Right leg : ");
	
	public JButton    addbtn = new JButton("Add");
	public JButton    rembtn = new JButton("Remove");
	
	public text_field_2 () {

		setLayout(new GridLayout(4, 4, 5, 5));
		add(new JLabel("<ROBOT 2>"));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(neck);
		add(neck_2);
		
		add(larm);
		add(larm_2);
		
		add(rarm);
		add(rarm_2);
		
		add(lleg);
		add(lleg_2);
		
		add(rleg);
		add(rleg_2);
		
		add(addbtn);
		add(rembtn);
	}
}