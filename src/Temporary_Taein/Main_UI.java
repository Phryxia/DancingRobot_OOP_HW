/**
 * Main_UI.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import javax.swing.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Main_UI extends JFrame {
	private  Container  contentPane;
	private  JRootPane  root_panel;
	private  ImageIcon  bg;
	private  JPanel     play_panel;
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
	private JMenuItem  saveItem;
	private JMenuItem  loadItem;
	private JMenuItem  exitItem;
	private JMenuItem  howToUse;
	
	FileSaveDialog     sf;
	Control_Panel      cp         = new Control_Panel ();
	keyframe           kf         = new keyframe      (robot1_anchor);
	Manual_Frame       mf;
	Program_Info       pi;
	Test_Add_Component tac;
	Toolkit            theKit     = getToolkit();
	Dimension          screenSize = theKit.getScreenSize();
	
	ImageIcon img      = new ImageIcon("C:\\icon.png");
	ImageIcon htu_img  = new ImageIcon("C:\\DancingRobot\\Images\\Use_Icon.png");
	ImageIcon exit_img = new ImageIcon("C:\\DancingRobot\\Images\\Exit_Icon.png");
	ImageIcon load_img = new ImageIcon("C:\\DancingRobot\\Images\\Load_Icon.png");
	ImageIcon info_img = new ImageIcon("C:\\DancingRobot\\Images\\Info_Icon.png");
	ImageIcon save_img = new ImageIcon("C:\\DancingRobot\\Images\\Save_Icon.png");
	
	/**
	 * Constructor
	 * 
	 * @author Taein Kim
	 */
	public Main_UI () {
		robot1_anchor.ensureCapacity(100);
		robot2_anchor.ensureCapacity(100);
		
		generate_Menu   ();
		generate_panel  ();
		chkBox_control();
		button_Control();
		
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
	 * Animation Play & Stop Button Control
	 * 
	 * @author Taein Kim
	 */
	public void button_Control () {
		cp.play_anim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isPlay) {
					System.out.println("Play_Button Clicked");
					isPlay = true;
				}
			}
		});
		
		cp.stop_anim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isPlay) {
					System.out.println("Stop_ButtonClicked");
					isPlay = false;
				}
			}
		});
	}
	
	/**
	 * Robot Activation CheckBox Control
	 * 
	 * @author Taein Kim
	 */
	public void chkBox_control () {
		cp.r1_Active.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cp.r1_Active.isSelected()) {
					System.out.println("chkbox1 Check true");
				} else {
					System.out.println("chkbox1 Check false");
				}
			}
		});
		
		cp.r2_Active.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cp.r2_Active.isSelected()) {
					System.out.println("chkbox2 Check true");
				} else {
					System.out.println("chkbox2 Check false");
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
		
		howToUse     = new JMenuItem ("사용법(How to Use)", KeyEvent.VK_U);
		exitItem     = new JMenuItem ("종료(Exit)",  KeyEvent.VK_E);
		loadItem     = new JMenuItem ("불러오기(Load)",  KeyEvent.VK_L);
		saveItem     = new JMenuItem ("저장하기(Save)",  KeyEvent.VK_S);
		program_info = new JMenuItem ("프로그램 정보(About)", KeyEvent.VK_A);

		howToUse    .setIcon(htu_img);
		loadItem    .setIcon(load_img);
		saveItem    .setIcon(save_img);
		program_info.setIcon(info_img);
		exitItem    .setIcon(exit_img);
		
		fileMenu    .setFont(clear_gothic);
		helpMenu    .setFont(clear_gothic);
		exitItem    .setFont(clear_gothic);
		loadItem    .setFont(clear_gothic);
		saveItem    .setFont(clear_gothic);
		howToUse    .setFont(clear_gothic);
		program_info.setFont(clear_gothic);
		
		fileMenu.setForeground(new Color(170, 170, 170));
		helpMenu.setForeground(new Color(170, 170, 170));
		
		exitItem.    setBackground(new Color(50, 50, 50));
		saveItem.    setBackground(new Color(50, 50, 50));
		loadItem.    setBackground(new Color(50, 50, 50));
		howToUse.    setBackground(new Color(50, 50, 50));
		program_info.setBackground(new Color(50, 50, 50));
		
		exitItem.    setForeground(new Color(170, 170, 170));
		saveItem.    setForeground(new Color(170, 170, 170));
		loadItem.    setForeground(new Color(170, 170, 170));	
		howToUse.    setForeground(new Color(170, 170, 170));
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
				 fod = new FileOpenDialog("Dancing Robot File", "iwbtr");
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
		
		howToUse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mf = new Manual_Frame();
			}
		});
		
		menuBar.setColor(new Color(50, 50, 50));
		helpMenu.add(howToUse);
		helpMenu.add(program_info);
		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		// Insert the menuBar to the top of the frame.
		setJMenuBar(menuBar);
	}
}