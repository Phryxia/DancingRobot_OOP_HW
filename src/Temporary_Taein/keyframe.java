/**
 * keyframe.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

@SuppressWarnings("serial")
public class keyframe extends JPanel {
	/**
	 * Animation : Robot Option Setting Panel
	 * ArrayList<Integer> robot_1 / robot_2 : Store the data of Robot Setting.
	 * ArrayList<Integer> debug : Temporary ArrayList for Debugging
	 */
	private  Animation_1 anim1 = new Animation_1 ();
	private  Animation_2 anim2 = new Animation_2 ();
	private  ArrayList<Integer> robot_1 = new ArrayList<Integer> ();
	private  ArrayList<Integer> robot_2 = new ArrayList<Integer> ();
	
	private  ArrayList<Integer> debug1 = new ArrayList<Integer> ();
	private  ArrayList<Integer> debug2 = new ArrayList<Integer> ();
	
	private int index;
	private int pos;
	private int size;
	private int cur_index;
	
	private Color back    = new Color(50, 50, 50);
	private Color btn     = new Color(0, 100, 147);
	private Color btn_txt = new Color(255, 255, 255);
	private Color msg_txt = new Color(170, 170,170);
	Font    clear_gothic  = new Font("맑은 고딕", Font.BOLD, 12);
	
	// Item Name which is added in the JList.
	private  String      keyname;
	
	public keyframe (ArrayList<Integer> para) {
		setLayout(new GridLayout(1, 2, 0, 0));
		optionpanel_Setting ();
		robot_1.ensureCapacity(100);
		robot_2.ensureCapacity(100);
		this.robot_1 = para;
		addEvent_1();
		addEvent_2();
		add(anim1);
		add(anim2);
	}
	
	@SuppressWarnings("static-access")
	public void optionpanel_Setting () {
		UIManager UI = new UIManager();
		
		UI.put("OptionPane.background", back);
		UI.put("OptionPane.foreground", msg_txt);
		UI.put("OptionPane.messageForeground", msg_txt);
		UI.put("OptionPane.foreground", msg_txt);
		UI.put("OptionPane.errorDialog.border.background",back);
		UI.put("OptionPane.font", clear_gothic);
		
		UI.put("Button.background", btn);
		UI.put("Button.foreground", btn_txt);
		
		UI.put("Panel.background", back);
		UI.put("Panel.font", clear_gothic);
	}
	
	/**
	 * Add Event to Animation_1 (Robot_1)
	 */
	public void addEvent_1 () {
		
		anim1.ol1.frame_list_1.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					index = anim1.ol1.frame_list_1.getSelectedIndex();
					pos = index * 5;
	                  anim1.tf1.neck_1.setText(
	                		  debug1.get(pos + 0).toString());
	                  anim1.tf1.larm_1.setText(
	                		  debug1.get(pos + 1).toString());
	                  anim1.tf1.rarm_1.setText(
	                		  debug1.get(pos + 2).toString());
	                  anim1.tf1.lleg_1.setText(
	                		  debug1.get(pos + 3).toString());
	                  anim1.tf1.rleg_1.setText(
	                		  debug1.get(pos + 4).toString());
	              }
			}
		});
		
		anim1.tf1.addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				size = anim1.ol1.frame_list_1.getModel().getSize();
				cur_index = anim1.ol1.frame_list_1.getSelectedIndex();
				if(anim1.tf1.neck_1.getText().length() == 0 || anim1.tf1.larm_1.getText().length() == 0 || anim1.tf1.rarm_1.getText().length() == 0 || anim1.tf1.lleg_1.getText().length() == 0 || anim1.tf1.rleg_1.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "입력공간을 모두 채우십시오.", "입력 오류", JOptionPane.ERROR_MESSAGE, null);
				} else {
					keyname = JOptionPane.showInputDialog("키프레임 이름을 입력하십시오.", "키프레임 이름 입력");
					if(keyname != null) {
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
						int pos_i = size * 5;
						System.out.println(debug1.get(pos_i + 0));
						System.out.println(debug1.get(pos_i + 1));
						System.out.println(debug1.get(pos_i + 2));
						System.out.println(debug1.get(pos_i + 3));
						System.out.println(debug1.get(pos_i + 4));
					}
				}
			
			}
		});
		
		anim1.tf1.rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anim1.ol1.frame_list_1.getModel().getSize() > 0) {
					anim1.ol1.listMode_1.remove(anim1.ol1.frame_list_1.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "제거할 키프레임이 존재하지 않습니다.", "제거 오류", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
	}
	
	/**
	 * Add Event to Animation Panel_2 (Robot_2)
	 */
	public void addEvent_2 () {
		
		anim2.ol2.frame_list_2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int index = anim2.ol2.frame_list_2.getSelectedIndex();
					int pos = index * 5;
	                  anim2.tf2.neck_2.setText(
	                		  debug2.get(pos + 0).toString());
	                  anim2.tf2.larm_2.setText(
	                		  debug2.get(pos + 1).toString());
	                  anim2.tf2.rarm_2.setText(
	                		  debug2.get(pos + 2).toString());
	                  anim2.tf2.lleg_2.setText(
	                		  debug2.get(pos + 3).toString());
	                  anim2.tf2.rleg_2.setText(
	                		  debug2.get(pos + 4).toString());
	              }
			}
		});
		
		anim2.tf2.addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * size : The number of list elements
				 * cur_index : selected list element's index
				 */
				
				size = anim2.ol2.frame_list_2.getModel().getSize();
				cur_index = anim2.ol2.frame_list_2.getSelectedIndex();
				
				/**
				 * Check whether all TextFields is filled.
				 */
				if(anim1.tf1.neck_1.getText().length() == 0 || anim1.tf1.larm_1.getText().length() == 0 || anim1.tf1.rarm_1.getText().length() == 0 || anim1.tf1.lleg_1.getText().length() == 0 || anim1.tf1.rleg_1.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "입력공간을 모두 채우십시오.", "입력 오류", JOptionPane.ERROR_MESSAGE, null);
				} else {
					// Print Error Message
					keyname = JOptionPane.showInputDialog("키프레임 이름을 입력하십시오.", "키프레임 이름 입력");
					if(keyname != null) {
						if(cur_index == -1) {
							anim2.setData(robot_2, size);
							anim2.ol2.listMode_2.addElement(keyname);
						} else {
							anim2.setData(robot_2, cur_index);
							anim2.ol2.listMode_2.add(cur_index, keyname);
						}
				
						/**
						 * Debugging Code.
						 * If you want to view the value, you can use code below.
						 */
						System.out.println("Save test(Robot 2)");
						System.out.println("Index : " + size);
				
						getData(debug2, robot_2, size);
						int pos_i = size * 5;
						System.out.println(debug2.get(pos_i + 0));
						System.out.println(debug2.get(pos_i + 1));
						System.out.println(debug2.get(pos_i + 2));
						System.out.println(debug2.get(pos_i + 3));
						System.out.println(debug2.get(pos_i + 4));
					}
				}
			}
		});
		
		anim2.tf2.rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anim2.ol2.frame_list_2.getModel().getSize() > 0) {
					anim2.ol2.listMode_2.remove(anim2.ol2.frame_list_2.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "제거할 키프레임이 존재하지 않습니다.", "제거 오류", JOptionPane.ERROR_MESSAGE, null);
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
		int pos_g = index * 5;
		para1.add(pos_g + 0, para2.get(pos_g + 0));
		para1.add(pos_g + 1, para2.get(pos_g + 1));
		para1.add(pos_g + 2, para2.get(pos_g + 2));
		para1.add(pos_g + 3, para2.get(pos_g + 3));
		para1.add(pos_g + 4, para2.get(pos_g + 4));
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