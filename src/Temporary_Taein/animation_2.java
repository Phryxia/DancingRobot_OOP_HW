package Temporary_Taein;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class animation_2 extends JPanel {
	public  option_list_2 ol2;
	public  text_field_2  tf2;
	private double        v_neck2;
	private double        v_larm2;
	private double        v_rarm2;
	private double        v_lleg2;
	private double        v_rleg2;
	private String        keyname;
	
	public animation_2 () {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		setBackground(new Color(50, 50, 50));
		ol2 = new option_list_2 ();
		tf2 = new text_field_2  ();
		
		addEvent();
		add(ol2);
		add(tf2);
	}
	
	public void addEvent () {
		tf2.addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				keyname = JOptionPane.showInputDialog("Enter KeyFrame Name.", "Name Input");
				ol2.listMode_2.addElement(keyname);
			}
		});
		
		tf2.rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ol2.listMode_2.remove(ol2.frame_list_2.getSelectedIndex());
			}
		});
	}
	
}
