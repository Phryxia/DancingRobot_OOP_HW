package Temporary_Taein;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class Program_Info extends JFrame {
	private JLabel  version;
	private JLabel  date;
	private JLabel  name1;
	private JLabel  name2;
	private JLabel  info1;
	private JLabel  info2;
	private JLabel  license;
	
	private JButton button; 
	
	private Color  text  = new Color(170, 170, 170);
	private JPanel panel = new JPanel();
	Toolkit theKit = getToolkit();
	Dimension screenSize = theKit.getScreenSize();
	BufferedImage img = null;
	ImageIcon icon = new ImageIcon("C:\\icon.png");
	
	public Program_Info () {
		
		setTitle("���α׷� ����");
		setSize(350, 250);
		setLocation((screenSize.width/2) - (this.getWidth() / 2), (screenSize.height/2) - (this.getHeight() / 2));
		setIconImage(icon.getImage());
		
		addLabel();
		addButton();
		try {
			show_icon();
		} catch (IOException e) {
		}
		
		panel.setBackground(new Color(50, 50, 50));
		panel.setLayout(null);
		
		add(panel);
		
		setResizable(false);
		setVisible(true);
	}
	
	public void show_icon () throws IOException {
		String path = "C:\\icon.png";
        File file = new File(path);
        img = ImageIO.read(file);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(225, 70, 110, 150);
        panel.add(label);

	}
	
	public void addLabel () {
		version = new JLabel("Dancing Robot (���� : 0.9.1)");
		date    = new JLabel("2015. 06");
		name1   = new JLabel("20142329 Taein Kim");
		name2   = new JLabel("20142302 Sekyu Kwon");
		info1   = new JLabel("2015 ���Ǵ��б� ��ǻ���к�");
		info2   = new JLabel("��ü���� ���α׷��� ������Ʈ");
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
	
	public void addButton () {
		button = new JButton("Ȯ��");
		button.setBackground(new Color(0, 100, 147));
		button.setForeground(new Color(255, 255, 255));
		button.setBounds(240, 30, 90, 25);
		
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
