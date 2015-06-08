/**
 * keyframe.java
 * 
 * @author Taein Kim
 */

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

@SuppressWarnings("serial")
public class keyframe extends JPanel {
	/**
	 * Animation : Robot Option Setting Panel
	 * ArrayList<Integer> robot_1 / robot_2 : Store the data of Robot Setting.
	 * ArrayList<Integer> debug : Temporary ArrayList for Debugging
	 */
	private Animation[] motionEditor;

	// Attribution
	private Color back    = new Color(50, 50, 50);
	private Color btn     = new Color(0, 100, 147);
	private Color btn_txt = new Color(255, 255, 255);
	private Color msg_txt = new Color(170, 170,170);
	Font    clear_gothic  = new Font("¸¼Àº °íµñ", Font.BOLD, 12);

	/**
	 * Create group panel that contains several motionEditor panels.
	 * 
	 * @param robotWindow
	 */
	public keyframe (RobotWindow robotWindow) {	
		setLayout(new GridLayout(1, 2, 0, 0));
		optionpanel_Setting ();
		
		// Create Editor List
		motionEditor = new Animation[2];
		for(int i=0; i<motionEditor.length; ++i) {
			motionEditor[i] = new Animation(robotWindow.getMotionList(i), i+1);
			add(motionEditor[i]);
		}
	}
	
	public void refresh(int index) {
		motionEditor[index].refresh();
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
	 * @author UlnamSong(Taein Kim)
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
}