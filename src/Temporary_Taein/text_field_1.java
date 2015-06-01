/**
 * Text_Field_1.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Text_Field_1 extends JPanel {
	
	private Color     background = new Color(50, 50, 50);
	private Color     tf_back    = new Color(30, 30, 30);
	private Color     textcolor  = new Color(170, 170, 170);
	
	public  JTextField neck_1;
	public  JTextField larm_1;
	public  JTextField rarm_1;
	public  JTextField lleg_1;
	public  JTextField rleg_1;
	
	public  JLabel     neck      = new JLabel("Neck : ");
	public  JLabel     larm      = new JLabel("Left Arm : ");
	public  JLabel     rarm      = new JLabel("Right Arm : ");
	public  JLabel     lleg      = new JLabel("Left Leg : ");
	public  JLabel     rleg      = new JLabel("Right leg : ");
	public  JLabel     title1    = new JLabel("<ROBOT 1>");

	public  JButton    addbtn    = new JButton("Add");
	public  JButton    rembtn    = new JButton("Remove");
	
	public Text_Field_1 () {
		setLayout(new GridLayout(4, 4, 5, 5));
		neck_1    = new JTextField(3);
		larm_1    = new JTextField(3);
		rarm_1    = new JTextField(3);
		lleg_1    = new JTextField(3);
		rleg_1    = new JTextField(3);
		
		setBackground(background);
		
		neck_1.setSelectionColor(new Color(255, 210, 0));
		neck_1.setSelectedTextColor(tf_back);
		neck_1.setForeground(textcolor);
		neck_1.setBackground(tf_back);
		
		larm_1.setSelectionColor(new Color(255, 210, 0));
		larm_1.setSelectedTextColor(tf_back);
		larm_1.setForeground(textcolor);
		larm_1.setBackground(tf_back);
		
		rarm_1.setBackground(tf_back);
		rarm_1.setSelectionColor(new Color(255, 210, 0));
		rarm_1.setSelectedTextColor(tf_back);
		rarm_1.setForeground(textcolor);
		
		lleg_1.setSelectionColor(new Color(255, 210, 0));
		lleg_1.setSelectedTextColor(tf_back);
		lleg_1.setForeground(textcolor);
		lleg_1.setBackground(tf_back);
		
		rleg_1.setSelectionColor(new Color(255, 210, 0));
		rleg_1.setSelectedTextColor(tf_back);
		rleg_1.setForeground(textcolor);
		rleg_1.setBackground(tf_back);
		
		neck.setForeground(textcolor);
		larm.setForeground(textcolor);
		rarm.setForeground(textcolor);
		lleg.setForeground(textcolor);
		rleg.setForeground(textcolor);
		title1.setForeground(textcolor);
		
		addbtn.setBackground(new Color(0, 100, 147));
		addbtn.setForeground(new Color(255, 255, 255));
		
		rembtn.setBackground(new Color(0, 100, 147));
		rembtn.setForeground(new Color(255, 255, 255));
		
		add(title1);
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