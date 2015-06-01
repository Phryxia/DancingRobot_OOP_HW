/**
 * Main_UI.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import javax.swing.*;
import javax.swing.filechooser.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

public class Main_UI extends JFrame{
	private Container  contentPane;
	private JRootPane  root_panel;
	private ImageIcon  bg;
	private JPanel     play_panel;
	private JPanel     image_panel;
	
	private  ArrayList<Integer> robot1_anchor = new ArrayList<Integer>();
	private  ArrayList<Integer> robot2_anchor = new ArrayList<Integer>();
	
	private  FileOpenDialog fod;
	
	/**
	 * JSplitPane : split root panel for 3 panels.
	 * control_panel, player_panel, Keyframe_panel
	 */
	private  JSplitPane updown;
	private  JSplitPane leftright;
	
	/**
	 * Variables for MenuBar, JMenu
	 */
	private JMenuItem  program_info;
	private JMenuItem  saveItem;
	private JMenuItem  loadItem;
	private JMenuItem  exitItem;
	
	FileSaveDialog sf;
	Control_Panel  cp = new Control_Panel ();
	keyframe       kf = new keyframe      (robot1_anchor);
	Program_Info   pi;
	Toolkit theKit = getToolkit();
	Dimension screenSize = theKit.getScreenSize();
	ImageIcon img = new ImageIcon("C:\\icon.png");
	/**
	 * Constructor
	 * 
	 * @author Taein Kim
	 */
	public Main_UI () {
		robot1_anchor.ensureCapacity(100);
		robot2_anchor.ensureCapacity(100);
		
		generate_Menu ();
		generate_panel ();
		
		setIconImage(img.getImage());
		setBackground(new Color(50, 50, 50));
		setSize(950, 600);
		setTitle("Dancing Robot (Taein & Sekyu)");
		
		setLocation((screenSize.width/2) - (this.getWidth() / 2), (screenSize.height/2) - (this.getHeight() / 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Operating split root panel.
	 */
	public void generate_panel () {
		show_Background ();
		setBackground(new Color(50, 50, 50));
		root_panel  = this.getRootPane ();
		leftright   = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cp, play_panel);
		updown      = new JSplitPane(JSplitPane.VERTICAL_SPLIT, leftright, kf);
		contentPane = root_panel.getContentPane();
		contentPane.setLayout ( new BorderLayout ());
		
		leftright.setDividerLocation(200);
		leftright.setDividerSize(0);
		leftright.setEnabled(false);
		updown.   setDividerLocation(399);
		updown.   setDividerSize(0);
		updown.   setEnabled(false);
		
		contentPane.add("Center", updown);
	}
	
	/**
	 * Load the stage image, set the background of player_panel.
	 */
	public void show_Background () {
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
	 * Generate Menu Bar & Events
	 * Add to Main UI Frame
	 * 
	 */
	public void generate_Menu() {
		MenuBar menuBar  = new MenuBar ();
		JMenu    fileMenu = new JMenu    ("파일(File)");
		JMenu    helpMenu = new JMenu    ("도움말(Help)");
		
		fileMenu.setMnemonic (KeyEvent.VK_F);
		helpMenu.setMnemonic (KeyEvent.VK_H);
		menuBar.add (fileMenu);
		menuBar.add (helpMenu);
		
		exitItem     = new JMenuItem ("종료(Exit)",  KeyEvent.VK_E);
		loadItem     = new JMenuItem ("불러오기(Load)",  KeyEvent.VK_L);
		saveItem     = new JMenuItem ("저장하기(Save)",  KeyEvent.VK_S);
		program_info = new JMenuItem ("프로그램 정보(About)", KeyEvent.VK_A);
		
		fileMenu.setForeground(new Color(170, 170, 170));
		helpMenu.setForeground(new Color(170, 170, 170));
		
		exitItem.    setBackground(new Color(50, 50, 50));
		saveItem.    setBackground(new Color(50, 50, 50));
		loadItem.    setBackground(new Color(50, 50, 50));
		program_info.setBackground(new Color(50, 50, 50));
		
		exitItem.    setForeground(new Color(170, 170, 170));
		saveItem.    setForeground(new Color(170, 170, 170));
		loadItem.    setForeground(new Color(170, 170, 170));		
		program_info.setForeground(new Color(170, 170, 170));
		
		/**
		 * Add Action Event to Each Menu Item.
		 */
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		loadItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 fod = new FileOpenDialog();
			}
		 });
		
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sf = new FileSaveDialog ();
			}
		});
		
		program_info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pi = new Program_Info();
			}
		});
		
		menuBar.setColor(new Color(50, 50, 50));
		helpMenu.add(program_info);
		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		// Insert the menuBar to the top of the frame.
		setJMenuBar(menuBar);
	}
}