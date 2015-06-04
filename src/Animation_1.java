/**
 * Animation_1.java
 * You can add or remove key frames by entering value in the text field.
 * 
 *  @author Ulnamsong
 */

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Animation_1 extends JPanel {
	public  Option_List_1 ol1;
	public  Text_Field_1  tf1;
	public  int           v_neck1;
	public  int           v_larm1;
	public  int           v_rarm1;
	public  int           v_lleg1;
	public  int           v_rleg1;
	
	/**
	 * Animation_1 Contructor
	 */
	public Animation_1 () {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		setBackground(new Color(50, 50, 50));
		ol1 = new Option_List_1 ();
		tf1 = new Text_Field_1  ();
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