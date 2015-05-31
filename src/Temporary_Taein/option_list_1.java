package Temporary_Taein;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class option_list_1 extends JPanel {
	public DefaultListModel <String> listMode_1   = new DefaultListModel <String>();
	public JList            <String> frame_list_1 = new JList            <String>(listMode_1);
	public JScrollPane               scroll_pan_1;
	
	public option_list_1 () {
		scroll_pan_1 = new JScrollPane(frame_list_1);
		frame_list_1.setPreferredSize(new Dimension(70, 120));
		scroll_pan_1.setPreferredSize(new Dimension(90, 120));
		add(scroll_pan_1);
	}
}