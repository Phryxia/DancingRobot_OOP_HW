package Temporary_Taein;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class option_list_2 extends JPanel {
	public DefaultListModel <String> listMode_2   = new DefaultListModel <String>();
	public JList            <String> frame_list_2 = new JList            <String>(listMode_2);
	public JScrollPane               scroll_pan_2;
	
	public option_list_2 () {
		//setLayout(new GridLayout(1, 1, 0, 0));
		scroll_pan_2 = new JScrollPane(frame_list_2);
		frame_list_2.setPreferredSize(new Dimension(90, 150));
		scroll_pan_2.setPreferredSize(new Dimension(110, 170));
		add(scroll_pan_2);
	}
}