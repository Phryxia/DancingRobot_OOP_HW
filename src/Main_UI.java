import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class Main_UI extends JFrame {
	
	protected JSplitPane split;
	JPanel tree = new JPanel();
	JPanel dancing = new JPanel();
	JPanel tab = new JPanel();
	JTabbedPane tabpan = new JTabbedPane();
	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu();
	
	public Main_UI () {
	    super("Main UI");
	    dancing.add(new Dancing_UI());
	    tab.add(tabpan);
	    setSize(1000, 700);
	    getContentPane().setLayout(new BorderLayout());

	    JSplitPane spLeft = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tree, dancing);
	    spLeft.setDividerSize(8);
	    spLeft.setContinuousLayout(true);

	    split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spLeft, tab);
	    split.setContinuousLayout(false);

	    getContentPane().add(split, BorderLayout.CENTER);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}

}
