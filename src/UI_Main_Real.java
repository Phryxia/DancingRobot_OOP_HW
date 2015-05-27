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
	private String[] list_test = {
			"Saved 1 : Test 1",
			"Saved 2 : Test 2",
			"Saved 3 : Test 3"
	};
	
	/**
	 * Components of Program UI
	 * 
	 * @author Tae-in Kim
	 */
	JFrame frame;
	JTabbedPane tabPan;
	JList<String> list;
	
	JLabel leftLabel;
	
	JButton addFile;
	JButton removeFile;
	JButton play;
	JButton stop;
	
	JMenuItem stuinfoItem;
	JMenuItem exitItem;
	JMenuItem proinfoItem;
	
	JPanel treeList;
	JPanel Player;
	JPanel KeyFrame;
	JPanel play_panel;
	
	JSplitPane updown;
	JSplitPane leftright;
	JScrollPane scpane;
	ImageIcon bg;
	
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
		addFile = new JButton("Add");
		removeFile = new JButton("Remove");
		play.setFont(new Font("Arial", Font.PLAIN, 15));
		stop.setFont(new Font("Arial", Font.PLAIN, 15));
		addFile.setFont(new Font("Arial", Font.PLAIN, 15));
		removeFile.setFont(new Font("Arial", Font.PLAIN, 15));
	}
	
	/**
	 * Print Stage Image
	 * - By ContentPane
	 * 
	 * @author Tae-in Kim
	 */
	public void show_Stage() {
		bg = new ImageIcon("C:\\Users\\Administrator\\Documents\\GitHub\\DancingRobot_OOP_HW\\image\\moodae.jpg");
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
	 * Generate List_Panel
	 * - Custom Options in List
	 * 
	 * @author Tae-in Kim
	 */
	public void generate_ListPanel() {
		leftLabel = new JLabel("Saved Options.");
		
		list = new JList<String>(list_test);
		list.setSize(200, 300);
		
		JPanel btns = new JPanel();
		btns.setLayout(new GridLayout(2, 2, 1, 1));
		
		
		addFile.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e){
				promptForFile();
				/*
				 * Testing Mouse Double Click
				 
					if(e.getClickCount() == 2) {
						promptForFile();
					}
				*/
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		removeFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btns.add(play);
		btns.add(stop);
		btns.add(addFile);
		btns.add(removeFile);
		
		treeList = new JPanel();
		treeList.setLayout(new BorderLayout());
		treeList.add(leftLabel, BorderLayout.NORTH);
		treeList.add(list, BorderLayout.CENTER);
		treeList.add(btns, BorderLayout.SOUTH);
	}
	
	private String promptForFile(){
		JFileChooser fc=new JFileChooser();
		int returnVal=fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    return fc.getSelectedFile().getAbsolutePath();
		} else {
		    return null;
		}
	}
	
	/**
	 * Generate Tab_Panel
	 * - Robot1 OptionTab, Robot2 OptionTab
	 * 
	 * @author Tae-in Kim
	 */
	public void generate_TabPanel() {
		tabPan = new JTabbedPane();
		tabPan.add("Anim : Robot1", null);
		tabPan.add("Anim : Robot2", null);
		
		KeyFrame = new JPanel();
		KeyFrame.setLayout(new BorderLayout());
		KeyFrame.add(tabPan);
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

		// File Menu
		// Help Menu
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		helpMenu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		// File->Item(E)
		// Help->Items(S, P)
		stuinfoItem = new JMenuItem("About Student..", KeyEvent.VK_S);
		exitItem = new JMenuItem("Exit", KeyEvent.VK_E);
		proinfoItem = new JMenuItem("About Program..", KeyEvent.VK_P);

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		    	
		});
		    
		helpMenu.add(stuinfoItem);
		helpMenu.add(proinfoItem);
		fileMenu.add(exitItem);

		setJMenuBar(menuBar);
	}
}