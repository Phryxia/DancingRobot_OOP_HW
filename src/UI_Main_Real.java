import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Class UI_Main_Real
 * 
 * This class is about Main UI of the Dancing Robot Program.
 * 
 * @author Tae-in Kim
 * Soongsil University, Seoul, Korea
 *
 */
@SuppressWarnings("serial")
public class UI_Main_Real extends JFrame {
	private Container contentPane;
	private JRootPane root;
	
	/**
	 * Components of Program UI
	 * 
	 * @author Tae-in Kim
	 */
	JFrame frame;
	JTabbedPane tabPan;
	DefaultListModel<String> listModel_1;
	DefaultListModel<String> listModel_2;
	JList<String> list_r1;
	JList<String> list_r2;
	
	JLabel leftLabel_1;
	JLabel leftLabel_2;

	JButton play;
	JButton stop;
	
	JMenuItem stuinfoItem;
	JMenuItem exitItem;
	JMenuItem proinfoItem;
	JMenuItem saveItem;
	
	JPanel treeList;
	JPanel Player;
	JPanel KeyFrame;
	JPanel play_panel;
	
	JSplitPane updown;
	JSplitPane leftright;
	JScrollPane scpane;
	ImageIcon bg;
	JFileChooser fc;
	
	/**
	 * Constructor
	 * Construct the Frame with many Components
	 * 
	 * @author Tae-in Kim
	 */
	public UI_Main_Real() {
		Initialize();
		generate_Panel();
		generate_Menu();
		setSize(800, 600);
		setTitle("Dancing Robot (Taein & Sekyu)");
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Initialize the Variables
	 * - JComponents
	 * 
	 * @author Tae-in Kim
	 */
	public void Initialize() {
		play = new JButton("Play");
		stop = new JButton("Stop");
	}	
	/**
	 * Print Stage Image
	 * - By ContentPane
	 * 
	 * @author Tae-in Kim
	 */
	public void show_Stage() {
		bg = new ImageIcon("C:\\Users\\Ulnamsong\\Documents\\GitHub\\DancingRobot_OOP_HW\\image\\moodae.jpg");
		play_panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
            	g.drawImage(bg.getImage(), 0, 0, d.width, d.height, null);
            	setOpaque(false);
            	super.paintComponent(g);
			}
		};

	}
	
	/**
	 * Generate Tab_Panel
	 * - Robot1 OptionTab, Robot2 OptionTab
	 * 
	 * @author Tae-in Kim
	 */
	public void generate_TabPanel() {
		Robot_Option ro1 = new Robot_Option("111");
		Robot_Option ro2 = new Robot_Option("222");
		
		tabPan = new JTabbedPane();
		tabPan.add("Anim : Robot1", ro1);
		tabPan.add("Anim : Robot2", ro2);

		KeyFrame = new JPanel();
		KeyFrame.setLayout(new BorderLayout());
		KeyFrame.add(tabPan);
	}
	
	/**
	 * Generate List_Panel
	 * - Custom Options in List
	 */
	public void generate_ListPanel() {
		listModel_1 = new DefaultListModel<String>();
		listModel_2 = new DefaultListModel<String>();
		JScrollPane l_r1;
		JScrollPane l_r2;
		
		list_r1 = new JList<String>();
		list_r1.setSize(90, 300);
		
		list_r2 = new JList<String>();
		list_r2.setSize(90, 300);
		
		l_r1 = new JScrollPane(list_r1);
		l_r2 = new JScrollPane(list_r2);
		l_r1.setSize(90, 300);
		l_r2.setSize(90, 300);
		
		JPanel lists = new JPanel();
		lists.setLayout(new FlowLayout());
		lists.add(l_r1);
		lists.add(l_r2);
		
		JPanel btns = new JPanel();
		btns.setLayout(new FlowLayout());
		btns.add(play);
		btns.add(stop);
		
		treeList = new JPanel();
		treeList.setLayout(new FlowLayout());
		treeList.add(lists);
		treeList.add(btns);
	}
	
	// File Open Dialog
	@SuppressWarnings("unused")
	private String promptForFile(){
		fc=new JFileChooser();
		int returnVal=fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    return fc.getSelectedFile().getName();
		} else {
		    return null;
		}
	}
	
	/**
	 * Generate Split_Panel	 * - Top&Bottom, Left&Right, 3 Parts
	 * 
	 * @author Tae-in Kim
	 */
	public void generate_Panel() {
		show_Stage();
		generate_TabPanel();
		generate_ListPanel();
		root = this.getRootPane();
		leftright = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeList, play_panel);
		updown = new JSplitPane(JSplitPane.VERTICAL_SPLIT, leftright, KeyFrame);		
		contentPane = root.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		leftright.setDividerLocation(200);
		leftright.setDividerSize(2);
		leftright.setEnabled(false);
		
		updown.setDividerLocation(350);
		updown.setDividerSize(0);
		updown.setEnabled(false);
		
		contentPane.add("Center",updown);
	}
	
	/**
	 * Generate MenuBar
	 * - Student Info, Program Info, Program Exit
	 * 
	 * @author Tae-in Kim
	 */
	public void generate_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();

		// File Menu & Set Mnemonic 'F'
		// Help Menu & Set Mnemonic 'H'
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_E);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		// File->Item(Mnemonic : E)
		// Help->Items(Mnemonic : S, P)
		stuinfoItem = new JMenuItem("About Student..", KeyEvent.VK_S);
		exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
		saveItem = new JMenuItem("Save to File", KeyEvent.VK_V);
		proinfoItem = new JMenuItem("About Program..", KeyEvent.VK_P);

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		//saveItem.addActionListener
		
		//stuinfoItem.addActionListener
		
		//proinfoItem.addActionListener
		
		helpMenu.add(stuinfoItem);
		helpMenu.add(proinfoItem);
		fileMenu.add(exitItem);
		editMenu.add(saveItem);

		setJMenuBar(menuBar);
	}
}