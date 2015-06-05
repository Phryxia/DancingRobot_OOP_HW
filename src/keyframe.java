/**
 * keyframe.java
 * 
 * @author Taein Kim
 */

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
	private Animation anim1;
	private Animation anim2;
	private ArrayList <Integer> robot_1 = new ArrayList<Integer> ();
	private ArrayList <Integer> robot_2 = new ArrayList<Integer> ();
	
	private ArrayList <Integer> debug1 = new ArrayList<Integer> ();
	private ArrayList <Integer> debug2 = new ArrayList<Integer> ();
	
	private int index;
	private int pos;
	private int size;
	private int i_size;
	private int cur_index;
	
	// Attribution
	private Color back    = new Color(50, 50, 50);
	private Color btn     = new Color(0, 100, 147);
	private Color btn_txt = new Color(255, 255, 255);
	private Color msg_txt = new Color(170, 170,170);
	Font    clear_gothic  = new Font("¸¼Àº °íµñ", Font.BOLD, 12);
	
	// Item Name which is added in the JList.
	private  String      keyname;
	
	public keyframe (InstructionIO iReference) {
		setLayout(new GridLayout(1, 2, 0, 0));
		optionpanel_Setting ();
		
		robot_1.ensureCapacity(100);
		robot_2.ensureCapacity(100);

		add(anim1);
		add(anim2);
	}
	
	/**
	 * UI Setting for Frame.
	 * 
	 * Label : Background, Foreground
	 * OptionPane : Background, Foreground
	 * Button : Background, Foreground
	 * ToggleButton : Background
	 * Panel : Background
	 * 
	 * All Fonts to Clear Gothic
	 * 
	 * @author UlnamSong
	 */
	@SuppressWarnings("static-access")
	public void optionpanel_Setting () {
		UIManager UI = new UIManager();
		UI.put("Label.background", back);
		UI.put("Label.foreground", msg_txt);
		UI.put("Label.font", clear_gothic);
		
		UI.put("OptionPane.background", back);
		UI.put("OptionPane.foreground", msg_txt);
		UI.put("OptionPane.messageForeground", msg_txt);
		UI.put("OptionPane.foreground", msg_txt);
		UI.put("OptionPane.errorDialog.border.background",back);
		UI.put("OptionPane.font", clear_gothic);
		
		UI.put("Button.background", btn);
		UI.put("Button.foreground", btn_txt);
		UI.put("Button.font", clear_gothic);
		
		UI.put("ToggleButton.Background", btn_txt);
		UI.put("Panel.background", back);
		UI.put("Panel.font", clear_gothic);
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