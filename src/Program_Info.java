
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Program_Info.java
 * 
 * Show the Program information 
 * @author Taein Kim
 */
@SuppressWarnings("serial")
public class Program_Info extends JFrame {
	// Components which is construct frame.
	private JLabel  version;
	private JLabel  date;
	private JLabel  name1;
	private JLabel  name2;
	private JLabel  info1;
	private JLabel  info2;
	private JLabel  license;
	private JButton button; 
	
	// Style Options.
	private Color  text         = new Color(170, 170, 170);
	private JPanel panel        = new JPanel();
	private Font   clear_gothic = new Font("맑은 고딕", Font.BOLD, 12);

	Toolkit theKit = getToolkit();
	Dimension screenSize = theKit.getScreenSize();
	
	BufferedImage img = null;
	ImageIcon icon = new ImageIcon("C:\\icon.png");
	
	/**
	 * Constructor
	 * 
	 * @author Taein Kim
	 */
	public Program_Info () {
		
		setTitle("프로그램 정보");
		setSize(350, 250);
		setLocation((screenSize.width/2) - (this.getWidth() / 2), (screenSize.height/2) - (this.getHeight() / 2));
		setIconImage(icon.getImage());
		
		addLabel();
		addButton();
		
		// Process Exception
		try {
			show_icon();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Set the Frame Style.
		panel.setBackground(new Color(50, 50, 50));
		panel.setLayout(null);
		
		add(panel);
		
		setResizable(false);
		setVisible(true);
	}
	
	/**
	 * Load the icon image and set Font to all Components.
	 * 
	 * @throws IOException
	 */
	public void show_icon () throws IOException {
		String path = "C:\\icon_bg.png";
        File file = new File(path);
        img = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(225, 70, 110, 150);
        
        version.setFont(clear_gothic);
        date.setFont(clear_gothic);
        name1.setFont(clear_gothic);
        name2.setFont(clear_gothic);
        info1.setFont(clear_gothic);
        info2.setFont(clear_gothic);
        license.setFont(clear_gothic);
        
        panel.add(label);

	}
	
	/**
	 * Set the content of all label.
	 * 
	 * @author Taein Kim
	 */
	public void addLabel () {
		version = new JLabel("Dancing Robot (버전 : 0.9.1)");
		date    = new JLabel("2015. 06");
		name1   = new JLabel("20142329 Taein Kim");
		name2   = new JLabel("20142302 Sekyu Kwon");
		info1   = new JLabel("2015 숭실대학교 컴퓨터학부");
		info2   = new JLabel("객체지향 프로그래밍 프로젝트");
		license = new JLabel("Copyright (c) 2015 TS Company");
		
		version.setBounds(20, 20,  200, 20);
		date   .setBounds(20, 40,  200, 20);
		name1  .setBounds(20, 80, 300, 20);
		name2  .setBounds(20, 95, 300, 20);
		info1  .setBounds(20, 120, 400, 20);
		info2  .setBounds(20, 135, 400, 20);
		license.setBounds(20, 165, 400, 20);
		
		version.setForeground(text);
		date   .setForeground(text);
		name1  .setForeground(text);
		name2  .setForeground(text);
		info1  .setForeground(text);
		info2  .setForeground(text);
		license.setForeground(text);
		
		panel  .add(version);
		panel  .add(date);
		panel  .add(name1);
		panel  .add(name2);
		panel  .add(info1);
		panel  .add(info2);
		panel  .add(license);
	}
	
	/**
	 * Add the OK Button.
	 */
	public void addButton () {
		button = new JButton("확인");
		button.setBackground(new Color(0, 100, 147));
		button.setForeground(new Color(255, 255, 255));
		button.setBounds(240, 30, 90, 25);
		button.setFont(clear_gothic);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		panel  .add(button);
	}
}
