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
		
		updown.setDividerLocation(399);
		updown.setDividerSize(2);
		updown.setEnabled(false);
		
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

class control_Panel extends JPanel {
	public JCheckBox r1_Active;
	public JCheckBox r2_Active;
	
	public JButton   play_anim;
	public JButton   stop_anim;
	
	public control_Panel () {
		r1_Active = new JCheckBox(" ROBOT1 ACTIVE ");
		r2_Active = new JCheckBox(" ROBOT2 ACTIVE ");
		
		play_anim = new JButton("PLAY ANIMATION");
		stop_anim = new JButton("STOP ANIMATION");
		
		add(r1_Active);
		add(r2_Active);
		add(play_anim);
		add(stop_anim);
	}
}

class keyframe extends JPanel {
	public animation_1 anim1 = new animation_1 ();
	public animation_2 anim2 = new animation_2 ();
	
	public keyframe () {
		setLayout(new GridLayout(1, 2, 0, 0));
		add(anim1);
		add(anim2);
	}
}

class animation_1 extends JPanel {
	public option_list_1 ol1;
	public text_field_1  tf1;
	
	public animation_1 () {
		setLayout(new FlowLayout());
		ol1 = new option_list_1 ();
		tf1 = new text_field_1  ();
		add(ol1);
		add(tf1);
	}
}

class animation_2 extends JPanel {
	public option_list_2 ol2;
	public text_field_2  tf2;
	
	public animation_2 () {
		setLayout(new FlowLayout());
		ol2 = new option_list_2 ();
		tf2 = new text_field_2  ();
		add(ol2);
		add(tf2);
	}
}

class option_list_1 extends JPanel {
	public DefaultListModel <String> listMode_1   = new DefaultListModel <String>();
	public JList            <String> frame_list_1 = new JList            <String>(listMode_1);
	public JScrollPane               scroll_pan_1;
	
	public option_list_1 () {
		//setLayout(new GridLayout(1, 1, 0, 0));
		scroll_pan_1 = new JScrollPane(frame_list_1);
		frame_list_1.setPreferredSize(new Dimension(90, 150));
		scroll_pan_1.setPreferredSize(new Dimension(110, 170));
		add(scroll_pan_1);
	}
}

class option_list_2 extends JPanel {
	public DefaultListModel <String> listMode_2   = new DefaultListModel <String>();
	public JList            <String> frame_list_2 = new JList            <String>(listMode_2);
	public JScrollPane               scroll_pan_2;
	
	public option_list_2 () {
		//setLayout(new GridLayout(1, 1, 0, 0));
		scroll_pan_2 = new JScrollPane(frame_list_2);
		frame_list_2.setPreferredSize(new Dimension(90, 150));
		scroll_pan_2.setPreferredSize(new Dimension(110, 170));
		add(scroll_pan_2);
	}
}

class text_field_1 extends JPanel {
	
	public JTextField neck_1 = new JTextField(3);
	public JTextField larm_1 = new JTextField(3);
	public JTextField rarm_1 = new JTextField(3);
	public JTextField lleg_1 = new JTextField(3);
	public JTextField rleg_1 = new JTextField(3);
	
	public JLabel     neck   = new JLabel("Neck : ");
	public JLabel     larm   = new JLabel("Left Arm : ");
	public JLabel     rarm   = new JLabel("Right Arm : ");
	public JLabel     lleg   = new JLabel("Left Leg : ");
	public JLabel     rleg   = new JLabel("Right leg : ");
	
	public JButton    addbtn = new JButton("Add");
	public JButton    rembtn = new JButton("Remove");
	
	public text_field_1 () {

		setLayout(new GridLayout(4, 4, 5, 5));
		
		add(new JLabel("<ROBOT 1>"));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(neck);
		add(neck_1);
		
		add(larm);
		add(larm_1);
		
		add(rarm);
		add(rarm_1);
		
		add(lleg);
		add(lleg_1);
		
		add(rleg);
		add(rleg_1);
		
		add(addbtn);
		add(rembtn);
	}
}

class text_field_2 extends JPanel {
	
	public JTextField neck_2 = new JTextField(3);
	public JTextField larm_2 = new JTextField(3);
	public JTextField rarm_2 = new JTextField(3);
	public JTextField lleg_2 = new JTextField(3);
	public JTextField rleg_2 = new JTextField(3);
	
	public JLabel     neck   = new JLabel("Neck : ");
	public JLabel     larm   = new JLabel("Left Arm : ");
	public JLabel     rarm   = new JLabel("Right Arm : ");
	public JLabel     lleg   = new JLabel("Left Leg : ");
	public JLabel     rleg   = new JLabel("Right leg : ");
	
	public JButton    addbtn = new JButton("Add");
	public JButton    rembtn = new JButton("Remove");
	
	public text_field_2 () {

		setLayout(new GridLayout(4, 4, 5, 5));
		add(new JLabel("<ROBOT 2>"));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(neck);
		add(neck_2);
		
		add(larm);
		add(larm_2);
		
		add(rarm);
		add(rarm_2);
		
		add(lleg);
		add(lleg_2);
		
		add(rleg);
		add(rleg_2);
		
		add(addbtn);
		add(rembtn);
	}
}
