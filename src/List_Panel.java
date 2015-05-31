import java.awt.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class List_Panel extends JPanel {
	JList<String> option_list;
	DefaultListModel<String> listModel;
	
	public List_Panel () {
		setLayout(new FlowLayout());
		generate_list();
	}
	
	public void generate_list () {
		option_list = new JList<String>();
		listModel = new DefaultListModel<String>();
		
		option_list = new JList<String>(listModel);
		option_list.setSize(100, 150);
		
		add(option_list);
	}
	
}