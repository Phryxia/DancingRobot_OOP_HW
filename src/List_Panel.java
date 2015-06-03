import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class List_Panel extends JPanel {
	JList<String> option_list;
	DefaultListModel<String> listModel;
	JScrollPane list_pan;
	
	public List_Panel () {
		setLayout(new FlowLayout());
		generate_list();
	}
	
	public void generate_list () {
		option_list = new JList<String>();
		listModel = new DefaultListModel<String>();
		
		option_list = new JList<String>(listModel);
		list_pan = new JScrollPane(option_list);
		list_pan.setSize(100, 150);
		add(list_pan);
	}
	
}