package Temporary_Taein;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class animation_2 extends JPanel {
	public  option_list_2 ol2;
	public  text_field_2  tf2;
	private int           v_neck2;
	private int           v_larm2;
	private int           v_rarm2;
	private int           v_lleg2;
	private int           v_rleg2;
	
	public animation_2 () {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		setBackground(new Color(50, 50, 50));
		ol2 = new option_list_2 ();
		tf2 = new text_field_2  ();
		add(ol2);
		add(tf2);
	}
	
	public void saveToVal () {
		v_neck2 = Integer.parseInt(tf2.neck_2.getText());
		v_larm2 = Integer.parseInt(tf2.larm_2.getText());
		v_rarm2 = Integer.parseInt(tf2.rarm_2.getText());
		v_lleg2 = Integer.parseInt(tf2.lleg_2.getText());
		v_rleg2 = Integer.parseInt(tf2.rleg_2.getText());
	}
	
	public void setData (ArrayList<Integer> para, int index) {
		int pos = index * 5;
		saveToVal();
		para.add(pos + 0, v_neck2);
		para.add(pos + 1, v_larm2);
		para.add(pos + 2, v_rarm2);
		para.add(pos + 3, v_lleg2);
		para.add(pos + 4, v_rleg2);
	}
}
