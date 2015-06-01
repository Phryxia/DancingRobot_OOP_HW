/**
 * keyframe.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class keyframe extends JPanel {
	public  Animation_1 anim1 = new Animation_1 ();
	public  Animation_2 anim2 = new Animation_2 ();
	public  ArrayList<Integer> robot_1 = new ArrayList<Integer> ();
	public  ArrayList<Integer> robot_2 = new ArrayList<Integer> ();
	
	public  ArrayList<Integer> debug1 = new ArrayList<Integer> ();
	public  ArrayList<Integer> debug2 = new ArrayList<Integer> ();
	
	private String      keyname;
	
	public keyframe (ArrayList<Integer> para) {
		setLayout(new GridLayout(1, 2, 0, 0));
		robot_1.ensureCapacity(100);
		robot_2.ensureCapacity(100);
		this.robot_1 = para;
		addEvent_1();
		addEvent_2();
		add(anim1);
		add(anim2);
	}
	
	/**
	 * Add Event to Animation_1 (Robot_1)
	 */
	public void addEvent_1 () {
		anim1.tf1.addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				keyname = JOptionPane.showInputDialog("Enter KeyFrame Name.", "Name Input");
				int size = anim1.ol1.frame_list_1.getModel().getSize();
				int cur_index = anim1.ol1.frame_list_1.getSelectedIndex();
				if(cur_index == -1) {
					anim1.setData(robot_1, size);
					anim1.ol1.listMode_1.addElement(keyname);
				} else {
					anim1.setData(robot_1, cur_index);
					anim1.ol1.listMode_1.add(cur_index, keyname);
				}
				//Debug
				System.out.println("Save test(Robot 1)");
				System.out.println("Index : " + size);
				
				getData(debug1, robot_1, size);
				System.out.println(debug1.get(size + 0));
				System.out.println(debug1.get(size + 1));
				System.out.println(debug1.get(size + 2));
				System.out.println(debug1.get(size + 3));
				System.out.println(debug1.get(size + 4));
			}
		});
		
		anim1.tf1.rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anim1.ol1.frame_list_1.getModel().getSize() > 0) {
					anim1.ol1.listMode_1.remove(anim1.ol1.frame_list_1.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "There are no Keys to remove.", "Remove Error", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
	}
	
	/**
	 * Add Event to Animation Panel_2 (Robot_2)
	 */
	public void addEvent_2 () {
		anim2.tf2.addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				keyname = JOptionPane.showInputDialog("Enter KeyFrame Name.", "Name Input");
				int size = anim2.ol2.frame_list_2.getModel().getSize();
				int cur_index = anim2.ol2.frame_list_2.getSelectedIndex();
				if(cur_index == -1) {
					anim2.setData(robot_2, size);
					anim2.ol2.listMode_2.addElement(keyname);
				} else {
					anim2.setData(robot_2, cur_index);
					anim2.ol2.listMode_2.add(cur_index, keyname);
				}
				
				
				//Debug
				System.out.println("Save test(Robot 2)");
				System.out.println("Index : " + size);
				
				getData(debug2, robot_2, size);
				System.out.println(debug2.get(size + 0));
				System.out.println(debug2.get(size + 1));
				System.out.println(debug2.get(size + 2));
				System.out.println(debug2.get(size + 3));
				System.out.println(debug2.get(size + 4));
			}
		});
		
		anim2.tf2.rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anim2.ol2.frame_list_2.getModel().getSize() > 0) {
					anim2.ol2.listMode_2.remove(anim2.ol2.frame_list_2.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "There are no Keys to remove.", "Remove Error", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
	}
	
	/**
	 * Copy the List for Debugging.
	 * para1 : Debug ArrayList.
	 * para2 : Target ArrayList.
	 * 
	 * @param para1
	 * @param para2
	 * @param index
	 */
	public void getData(ArrayList<Integer> para1, ArrayList<Integer> para2, int index) {
		int pos = index * 5;
		para1.add(pos + 0, para2.get(pos + 0));
		para1.add(pos + 1, para2.get(pos + 1));
		para1.add(pos + 2, para2.get(pos + 2));
		para1.add(pos + 3, para2.get(pos + 3));
		para1.add(pos + 4, para2.get(pos + 4));
	}
	
	/**
	 * Export ArrayList Method.
	 * 
	 * if option value is 1, return Robot 1 ArrayList.
	 * else return Robot 2 ArrayList.
	 * 
	 * @param option
	 * @return
	 */
	public ArrayList<Integer> export_list (int option) {
		if(option == 1) {
			return robot_1;
		} else if(option == 2) {
			return robot_2;
		}
		return null;
	}
	
}