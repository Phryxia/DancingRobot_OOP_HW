/**
 * Main_UI.java
 * 
 * Class for Main UI
 * Main Frame of Application
 * 
 * @author UlnamSong
 */


import javax.swing.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Main_UI extends JFrame {
	private  Container  contentPane;
	private  JRootPane  root_panel;
	public static boolean isPlay = false;
	
	private  ArrayList<Integer> robot1_anchor = new ArrayList<Integer>();
	private  ArrayList<Integer> robot2_anchor = new ArrayList<Integer>();
	
	@SuppressWarnings("unused")
	private  FileOpenDialog fod;
	Font clear_gothic = new Font("맑은 고딕", Font.BOLD, 12);

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
	private JMenuItem  saveItem1;
	private JMenuItem  loadItem1;
	private JMenuItem  exitItem;
	private JMenuItem  howToUse;
	
	JLabel label;
	FileSaveDialog     sf;
	Control_Panel      cp         = new Control_Panel ();
	keyframe           kf;
	Manual_Frame       mf;
	Program_Info       pi;
	Test_Add_Component tac;
	Toolkit            theKit     = getToolkit();
	Dimension          screenSize = theKit.getScreenSize();
	
	ImagePanel panel;
	RobotWindow rw1;
	
	/**
	 * Icon Images for icon which is in the MenuBar
	 * 
	 * @author UlnamSong
	 */
	ImageIcon htu_img  = new ImageIcon(RelativePath.getAbsolutePath("image\\icon_help.jpg"));
	ImageIcon exit_img = new ImageIcon(RelativePath.getAbsolutePath("image\\icon_exit.jpg"));
	ImageIcon load_img = new ImageIcon(RelativePath.getAbsolutePath("image\\icon_load.jpg"));
	ImageIcon info_img = new ImageIcon(RelativePath.getAbsolutePath("image\\icon_info.jpg"));
	ImageIcon save_img = new ImageIcon(RelativePath.getAbsolutePath("image\\icon_save.jpg"));
	
	/**
	 * Constructor
	 * 
	 *  - Ensure Capacity of Robot_1 & Robot_2 ArrayList
	 *  - Generate Panels & Split main panel.
	 *  - Assign events to checkBox & Button.
	 * 
	 * @author UlnamSong
	 */
	public Main_UI () {
		rw1 = new RobotWindow(741, 396);
		rw1.startDancing();
		
		
		kf  = new keyframe(rw1);
		
		robot1_anchor.ensureCapacity(100);
		robot2_anchor.ensureCapacity(100);
		
		generate_Menu ();
		generate_panel();
		chkBox_control();
		button_Control();
		
		panel.add(rw1);

		// Set this window's icon
		setIconImage((new ImageIcon(RelativePath.getAbsolutePath("image\\icon_main.jpg"))).getImage());
		setBackground(new Color(50, 50, 50));
		setSize(950, 600);
		setTitle("Dancing Robot (Taein & Sekyu)");
		
		setLocation((screenSize.width/2) - (this.getWidth() / 2), (screenSize.height/2) - (this.getHeight() / 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Animation Play & Stop Button Control
	 * 
	 * @author Taein Kim
	 */
	public void button_Control () {
		/*
		 * This button play BGM & RobotDance.
		 */
		cp.play_anim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isPlay) {
					System.out.println("[Main_UI] Notice : Play_Button is clicked");
					rw1.setBGM(cp.ret_music());
					rw1.setMode(false);
					rw1.startDancing();
					isPlay = true;
				}
			}
		});
		
		/*
		 * This button stop BGM & RobotDance.
		 */
		cp.stop_anim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isPlay) {
					System.out.println("[Main_UI] Notice : Stop_Button is clicked");
					rw1.stopDancing();
					isPlay = false;
				}
			}
		});
	}
	
	/**
	 * Robot Activation CheckBox Control
	 * 
	 * @author UlnamSong
	 */
	public void chkBox_control () {
		cp.r1_Active.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cp.r1_Active.isSelected()) {
					System.out.println("[Main UI] Notice : ROBOT1 activated.");
					rw1.activeRobot(0);
				} else {
					System.out.println("[Main UI] Notice : ROBOT1 deactivated.");
					rw1.deactiveRobot(0);
					
				}
			}
		});
		
		cp.r2_Active.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cp.r2_Active.isSelected()) {
					System.out.println("[Main UI] Notice : ROBOT2 activated.");
					rw1.activeRobot(1);
				} else {
					System.out.println("[Main UI] Notice : ROBOT2 deactivated.");
					rw1.deactiveRobot(1);
				}
			}
		});
		
		/**
		 * Decide whether Music Mode is Active.
		 * Print Log of Activation
		 */
		cp.music_Mode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cp.music_Mode.isSelected()) {
					System.out.println("[Control Panel] Music Mode On");
				} else {
					System.out.println("[Control Panel] Music Mode Off");
				}
			}
		});
	}
	
	/**
	 * Operating split root panel.
	 */
	public void generate_panel () {
		show_Background ();
		setBackground(new Color(50, 50, 50));
		root_panel  = this.getRootPane ();
		leftright   = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cp, panel);
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
	 * Load the stage image to the background.
	 */
	public void show_Background () {
		panel = new ImagePanel(new ImageIcon("image\\bg_stage.jpg").getImage());
		add(panel);
		
		/*
		bg = new ImageIcon(RelativePath.getAbsolutePath("image\\bg_stage.jpg"));
		play_panel = new JPanel() {
			public void paintComponent(Graphics g) {
				// Draw Image with Handling NullPointerException
				try
				{
					g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), null);
				}
				catch(NullPointerException e)
				{
					System.out.println("[Main_UI : show_background] No such image error");
				}
            	setOpaque(false);
            	super.paintComponent(g);
			}
		};
		*/
	}
	
	/**
	 * Generate Menu Bar & Events
	 * Add to Main UI Frame
	 * 
	 */
	public void generate_Menu() {
		MenuBar  menuBar    = new MenuBar ();
		JMenu    fileMenu   = new JMenu    ("파일(File)");
		JMenu    roboCtrl_1 = new JMenu    ("ROBO1 관리");
		JMenu    roboCtrl_2 = new JMenu    ("ROBO2 관리");
		JMenu    helpMenu   = new JMenu    ("도움말(Help)");
		
		fileMenu.setMnemonic (KeyEvent.VK_F);
		helpMenu.setMnemonic (KeyEvent.VK_H);
		menuBar.add (fileMenu);
		menuBar.add (roboCtrl_1);
		menuBar.add (roboCtrl_2);
		menuBar.add (helpMenu);
		
		howToUse     = new JMenuItem ("사용법(How to Use)", KeyEvent.VK_U);
		exitItem     = new JMenuItem ("종료(Exit)",  KeyEvent.VK_E);
		loadItem1    = new JMenuItem ("불러오기(Load)",  KeyEvent.VK_L);
		saveItem1    = new JMenuItem ("저장하기(Save)",  KeyEvent.VK_S);
		program_info = new JMenuItem ("프로그램 정보(About)", KeyEvent.VK_A);

		howToUse    .setIcon(htu_img);
		loadItem1   .setIcon(load_img);
		saveItem1   .setIcon(save_img);
		program_info.setIcon(info_img);
		exitItem    .setIcon(exit_img);
		
		fileMenu    .setFont(clear_gothic);
		helpMenu    .setFont(clear_gothic);
		roboCtrl_1  .setFont(clear_gothic);
		roboCtrl_2  .setFont(clear_gothic);
		exitItem    .setFont(clear_gothic);
		loadItem1   .setFont(clear_gothic);
		saveItem1   .setFont(clear_gothic);
		howToUse    .setFont(clear_gothic);
		program_info.setFont(clear_gothic);
		
		fileMenu    .setForeground(new Color(170, 170, 170));
		helpMenu    .setForeground(new Color(170, 170, 170));
		roboCtrl_1  .setForeground(new Color(170, 170, 170));
		roboCtrl_2  .setForeground(new Color(170, 170, 170));
		
		exitItem    .setBackground(new Color(50, 50, 50));
		saveItem1   .setBackground(new Color(50, 50, 50));
		loadItem1   .setBackground(new Color(50, 50, 50));
		howToUse    .setBackground(new Color(50, 50, 50));
		program_info.setBackground(new Color(50, 50, 50));
		
		exitItem    .setForeground(new Color(170, 170, 170));
		saveItem1   .setForeground(new Color(170, 170, 170));
		loadItem1   .setForeground(new Color(170, 170, 170));	
		howToUse    .setForeground(new Color(170, 170, 170));
		program_info.setForeground(new Color(170, 170, 170));
		
		/**
		 * Add Action Event to Each Menu Item.
		 */
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		loadItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 fod = new FileOpenDialog("Dancing Robot File", "iwbtr");
			}
		 });
		
		saveItem1.addActionListener(new ActionListener() {
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
		
		howToUse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mf = new Manual_Frame();
			}
		});
		
		menuBar.setColor(new Color(50, 50, 50));
		helpMenu  .add(howToUse);
		helpMenu  .add(program_info);
		roboCtrl_1.add(loadItem1);
		roboCtrl_1.add(saveItem1);
		fileMenu  .addSeparator();
		fileMenu  .add(exitItem);
		
		// Insert the menuBar to the top of the frame.
		setJMenuBar(menuBar);
	}
}