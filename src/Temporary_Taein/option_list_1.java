/**
 * Option_List_1.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Option_List_1 extends JPanel {
	public DefaultListModel <String> listMode_1   = new DefaultListModel <String>();
	public JList            <String> frame_list_1 = new JList            <String>(listMode_1);
	public JScrollPane               scroll_pan_1;
	
	/**
	 * Constructor
	 * 
	 * Initial the Scroll Pane and Add to Panel.
	 * 
	 * @author Taein Kim
	 */
	public Option_List_1 () {
		scroll_pan_1 = new JScrollPane(frame_list_1);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		scroll_pan_1.setForeground(new Color(40, 40, 40));
		frame_list_1.setForeground(new Color(170, 170, 170));
		frame_list_1.setBackground(new Color(40, 40, 40));
		frame_list_1.setPreferredSize(new Dimension(70, 120));
		scroll_pan_1.setPreferredSize(new Dimension(90, 120));
		add(scroll_pan_1);
	}
}