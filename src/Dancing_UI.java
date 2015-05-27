import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

// Testing Picture Open
@SuppressWarnings("serial")
public class Dancing_UI extends JFrame {
	Container contentPane;
	JScrollPane scpane;
	ImageIcon bg;
	JButton play_btn;
	JButton stop_btn;
	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu("File");
	public Dancing_UI () {
		bg = new ImageIcon("C:\\Users\\Administrator\\Documents\\GitHub\\DancingRobot_OOP_HW\\image\\moodae.jpg");
		play_btn = new JButton("в║");
		stop_btn = new JButton("бс");
		
		JPanel play_panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
            	g.drawImage(bg.getImage(), 590, 80, d.width-600, d.height-400, null);
            	setOpaque(false);
            	super.paintComponent(g);
			}
		};

		//Print Image
		scpane = new JScrollPane(play_panel);
		setContentPane(scpane);
		
		//Buttons
		add(play_btn);
		add(stop_btn);
		play_btn.setBounds(720, 350, 50, 30);
		stop_btn.setBounds(815, 350, 50, 30);
	
		setResizable(false);
		setSize(1000, 700);
		
		//Menu Bar Construct
		setJMenuBar(bar);
		bar.add(menu);
		menu.add(new JMenuItem("Student Info"));
		menu.add(new JSeparator());
		menu.add(new JMenuItem("Exit"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Dancing_UI();
	}

}