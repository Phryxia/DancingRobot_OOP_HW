/**
 * Text_Field_2.java
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

public class Text_Field_2 extends JPanel {
	
	private Color     background = new Color(50, 50, 50);
	private Color     tf_back    = new Color(30, 30, 30);
	private Color     textcolor  = new Color(220, 220, 220);
	
	public JTextField neck_2;
	public JTextField larm_2;
	public JTextField rarm_2;
	public JTextField lleg_2;
	public JTextField rleg_2;
	
	public JLabel     neck   = new JLabel("Neck : ");
	public JLabel     larm   = new JLabel("Left Arm : ");
	public JLabel     rarm   = new JLabel("Right Arm : ");
	public JLabel     lleg   = new JLabel("Left Leg : ");
	public JLabel     rleg   = new JLabel("Right leg : ");
	public JLabel     title2 = new JLabel("<ROBOT 2>");
	
	public JButton    addbtn = new JButton("Add");
	public JButton    rembtn = new JButton("Remove");
	
	public Text_Field_2 () {
		setBackground(new Color(50, 50, 50));
		setLayout(new GridLayout(4, 4, 5, 5));
		neck_2 = new JTextField(3);
		larm_2 = new JTextField(3);
		rarm_2 = new JTextField(3);
		lleg_2 = new JTextField(3);
		rleg_2 = new JTextField(3);
		
		neck_2.setSelectionColor(new Color(255, 210, 0));
		neck_2.setSelectedTextColor(tf_back);
		neck_2.setForeground(textcolor);
		neck_2.setBackground(tf_back);
		
		larm_2.setSelectionColor(new Color(255, 210, 0));
		larm_2.setSelectedTextColor(tf_back);
		larm_2.setForeground(textcolor);
		larm_2.setBackground(tf_back);
		
		rarm_2.setBackground(tf_back);
		rarm_2.setSelectionColor(new Color(255, 210, 0));
		rarm_2.setSelectedTextColor(tf_back);
		rarm_2.setForeground(textcolor);
		
		lleg_2.setSelectionColor(new Color(255, 210, 0));
		lleg_2.setSelectedTextColor(tf_back);
		lleg_2.setForeground(textcolor);
		lleg_2.setBackground(tf_back);
		
		rleg_2.setSelectionColor(new Color(255, 210, 0));
		rleg_2.setSelectedTextColor(tf_back);
		rleg_2.setForeground(textcolor);
		rleg_2.setBackground(tf_back);
		
		neck.  setForeground(textcolor);
		larm.  setForeground(textcolor);
		rarm.  setForeground(textcolor);
		lleg.  setForeground(textcolor);
		rleg.  setForeground(textcolor);
		title2.setForeground(textcolor);
		
		addbtn.setBackground(new Color(0, 100, 147));
		addbtn.setForeground(new Color(255, 255, 255));
		
		rembtn.setBackground(new Color(0, 100, 147));
		rembtn.setForeground(new Color(255, 255, 255));
		
		add(title2);
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