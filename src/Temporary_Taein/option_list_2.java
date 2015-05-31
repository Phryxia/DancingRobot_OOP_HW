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
		scroll_pan_2 = new JScrollPane(frame_list_2);
		frame_list_2.setPreferredSize(new Dimension(70, 120));
		scroll_pan_2.setPreferredSize(new Dimension(90, 120));
		add(scroll_pan_2);
	}
}