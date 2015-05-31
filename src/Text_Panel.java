import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Text_Panel extends JPanel {
	
	/**
	 * Variables for constructing Text_Panel
	 * & Values of each Anchors;
	 */
	private int v_neck;
	private int v_larm;
	private int v_rarm;
	private int v_lleg;
	private int v_rleg;
	
	JTextField anchor_neck;
	JTextField anchor_larm;
	JTextField anchor_rarm;
	JTextField anchor_lleg;
	JTextField anchor_rleg;
	
	JLabel neck;
	JLabel larm;
	JLabel rarm;
	JLabel lleg;
	JLabel rleg;
	
	JButton add;
	JButton delete;

	// Temporary Variables for Testing
	private String test;

	public Text_Panel(String test) {
		this.test = test;
		setLayout(new GridLayout(2, 6, 10, 10));
		generate_TField();
	}
	
	public void return_val(ArrayList<Integer> para1, ArrayList<Integer> para2, ArrayList<Integer> para3, ArrayList<Integer> para4, ArrayList<Integer> para5) {
		v_neck = Integer.parseInt(anchor_neck.getText());
		v_larm = Integer.parseInt(anchor_larm.getText());
		v_rarm = Integer.parseInt(anchor_rarm.getText());
		v_lleg = Integer.parseInt(anchor_lleg.getText());
		v_rleg = Integer.parseInt(anchor_rleg.getText());
		
		para1.add(v_neck);
		para2.add(v_larm);
		para3.add(v_rarm);
		para4.add(v_lleg);
		para5.add(v_rleg);
	}
	
	public void generate_TField () {
		add = new JButton("Add");
		delete = new JButton("delete");
		
		neck = new JLabel("Neck : ");
		larm = new JLabel("Left Arm : ");
		rarm = new JLabel("Right Arm : ");
		lleg = new JLabel("Left Leg : ");
		rleg = new JLabel("Right leg : ");
		
		anchor_neck = new JTextField(5);
		anchor_larm = new JTextField(5);
		anchor_rarm = new JTextField(5);
		anchor_lleg = new JTextField(5);
		anchor_rleg = new JTextField(5);

		anchor_neck.setText(test);
		anchor_larm.setText(test);
		anchor_rarm.setText(test);
		anchor_lleg.setText(test);
		anchor_rleg.setText(test);
		
		add(neck);
		add(anchor_neck);
		add(larm);
		add(anchor_larm);
		add(rarm);
		add(anchor_rarm);
		add(lleg);
		add(anchor_lleg);
		add(rleg);
		add(anchor_rleg);
		add(add);
		add(delete);
	}
}