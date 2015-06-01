package Temporary_Taein;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class option_list_2 extends JPanel {
	public DefaultListModel <String> listMode_2   = new DefaultListModel <String>();
	public JList            <String> frame_list_2 = new JList            <String>(listMode_2);
	public JScrollPane               scroll_pan_2;
	
	public option_list_2 () {
		scroll_pan_2 = new JScrollPane(frame_list_2);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		scroll_pan_2.setForeground(new Color(40, 40, 40));
		frame_list_2.setForeground(new Color(170, 170, 170));
		frame_list_2.setBackground(new Color(40, 40, 40));
		frame_list_2.setPreferredSize(new Dimension(70, 120));
		scroll_pan_2.setPreferredSize(new Dimension(90, 120));
		add(scroll_pan_2);
	}
}