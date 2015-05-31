package Temporary_Taein;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class text_field_1 extends JPanel {
	
	public  JTextField neck_1 = new JTextField(3);
	public  JTextField larm_1 = new JTextField(3);
	public  JTextField rarm_1 = new JTextField(3);
	public  JTextField lleg_1 = new JTextField(3);
	public  JTextField rleg_1 = new JTextField(3);
	
	public  JLabel     neck   = new JLabel("Neck : ");
	public  JLabel     larm   = new JLabel("Left Arm : ");
	public  JLabel     rarm   = new JLabel("Right Arm : ");
	public  JLabel     lleg   = new JLabel("Left Leg : ");
	public  JLabel     rleg   = new JLabel("Right leg : ");
	
	public  JButton    addbtn = new JButton("Add");
	public  JButton    rembtn = new JButton("Remove");
	
	public text_field_1 () {

		setLayout(new GridLayout(4, 4, 5, 5));
		
		add(new JLabel("<ROBOT 1>"));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(neck);
		add(neck_1);
		
		add(larm);
		add(larm_1);
		
		add(rarm);
		add(rarm_1);
		
		add(lleg);
		add(lleg_1);
		
		add(rleg);
		add(rleg_1);
		
		add(addbtn);
		add(rembtn);
	}

}