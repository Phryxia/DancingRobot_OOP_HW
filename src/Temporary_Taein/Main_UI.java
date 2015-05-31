package Temporary_Taein;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Main_UI extends JFrame{
	private Container  contentPane;
	private JRootPane  root_panel;
	private ImageIcon  bg;
	private JPanel     play_panel;
	private JPanel     image_panel;
	public  JSplitPane updown;
	public  JSplitPane leftright;
	private JMenuItem  program_info;
	private JMenuItem  saveItem;
	private JMenuItem  exitItem;
	
	control_Panel cp = new control_Panel ();
	keyframe      kf = new keyframe      ();
	
	public Main_UI () {
		generate_Menu ();
		generate_panel ();
		setSize(1000, 650);
		setTitle("Dancing Robot (Taein & Sekyu)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public void generate_panel () {
		show_Background ();
		root_panel  = this.getRootPane ();
		leftright   = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cp, play_panel);
		updown      = new JSplitPane(JSplitPane.VERTICAL_SPLIT, leftright, kf);
		contentPane = root_panel.getContentPane();
		contentPane.setLayout ( new BorderLayout ());
		
		leftright.setDividerLocation(300);
		leftright.setDividerSize(2);
		leftright.setEnabled(false);
		updown.   setDividerLocation(399);
		updown.   setDividerSize(2);
		updown.   setEnabled(false);
		
		contentPane.add("Center", updown);
	}
	
	public void show_Background () {
		bg = new ImageIcon("C:\\Users\\GAMMARU_2\\Documents\\GitHub\\DancingRobot_OOP_HW\\image\\moodae.jpg");
		play_panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
            	g.drawImage(bg.getImage(), 0, 0, d.width, d.height, null);
            	setOpaque(false);
            	super.paintComponent(g);
			}
		};
	}
	
	public void generate_Menu() {

		JMenuBar menuBar  = new JMenuBar ();
		JMenu    fileMenu = new JMenu    ("File");
		JMenu    editMenu = new JMenu    ("Edit");
		JMenu    helpMenu = new JMenu    ("Help");
		
		fileMenu.setMnemonic (KeyEvent.VK_F);
		editMenu.setMnemonic (KeyEvent.VK_E);
		helpMenu.setMnemonic (KeyEvent.VK_H);
		menuBar.add (fileMenu);
		menuBar.add (editMenu);
		menuBar.add (helpMenu);
		
		exitItem     = new JMenuItem ("Exit",          KeyEvent.VK_X);
		saveItem     = new JMenuItem ("Save to File",  KeyEvent.VK_V);
		program_info = new JMenuItem ("About Program", KeyEvent.VK_P);

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		helpMenu.add(program_info);
		fileMenu.add(exitItem);
		editMenu.add(saveItem);
		setJMenuBar(menuBar);
	}
}