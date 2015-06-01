package Temporary_Taein;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class animation_1 extends JPanel {
	public  option_list_1 ol1;
	public  text_field_1  tf1;
	public  int           v_neck1;
	public  int           v_larm1;
	public  int           v_rarm1;
	public  int           v_lleg1;
	public  int           v_rleg1;
	
	public animation_1 () {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		setBackground(new Color(50, 50, 50));
		ol1 = new option_list_1 ();
		tf1 = new text_field_1  ();
		add(ol1);
		add(tf1);
	}
	
	public void saveToVal () {
		v_neck1 = Integer.parseInt(tf1.neck_1.getText());
		v_larm1 = Integer.parseInt(tf1.larm_1.getText());
		v_rarm1 = Integer.parseInt(tf1.rarm_1.getText());
		v_lleg1 = Integer.parseInt(tf1.lleg_1.getText());
		v_rleg1 = Integer.parseInt(tf1.rleg_1.getText());
	}
	
	public void setData (ArrayList<Integer> para, int index) {
		int pos = index * 5;
		saveToVal();
		para.add(pos + 0, v_neck1);
		para.add(pos + 1, v_larm1);
		para.add(pos + 2, v_rarm1);
		para.add(pos + 3, v_lleg1);
		para.add(pos + 4, v_rleg1);
	}
	
	
	
}