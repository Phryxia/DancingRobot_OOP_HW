package Temporary_Taein;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class animation_1 extends JPanel {
	public  option_list_1 ol1;
	public  text_field_1  tf1;
	private double        v_neck2;
	private double        v_larm2;
	private double        v_rarm2;
	private double        v_lleg2;
	private double        v_rleg2;
	private String        keyname;
	
	public animation_1 () {
		setLayout(new FlowLayout());
		ol1 = new option_list_1 ();
		tf1 = new text_field_1  ();
		
		addEvent();
		add(ol1);
		add(tf1);
	}
	
	public void addEvent () {
		tf1.addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				keyname = JOptionPane.showInputDialog("Enter KeyFrame Name.", "Name Input");
				ol1.listMode_1.addElement(keyname);
			}
		});
		
		tf1.rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ol1.listMode_1.remove(ol1.frame_list_1.getSelectedIndex());
			}
		});
	}
	
}