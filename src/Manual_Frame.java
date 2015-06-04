
import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class Manual_Frame extends JFrame {
	private JLabel sentence1;
	private JLabel sentence2;
	private JLabel sentence3;
	private JLabel sentence4;
	private JLabel sentence5;
	private JLabel sentence6;
	private JLabel sentence7;
	private JLabel sentence8;
	private JLabel sentence9;
	private JLabel sentence10;
	
	private Color  text         = new Color(170, 170, 170);
	private JPanel panel        = new JPanel();
	private Font   clear_gothic = new Font("���� ���", Font.BOLD, 12);
	
	Toolkit theKit = getToolkit();
	Dimension screenSize = theKit.getScreenSize();
	
	public Manual_Frame () {
		setTitle("���� (How to Use)");
		setSize(500, 270);
		setBackground(new Color(50, 50, 50));
		setLocation((screenSize.width/2) - (this.getWidth() / 2), (screenSize.height/2) - (this.getHeight() / 2));
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(new Color(50, 50, 50)); 
		showManual();
		add(panel);
		setResizable(false);
		setVisible(true);
	}
	
	public void showManual () {
		sentence1 = new JLabel("  �κ��� 5���� ������ �̷���� �ֽ��ϴ�.                                           ");
		sentence2 = new JLabel("  The Robot has 5 skeletons.                                         ");
		sentence3 = new JLabel("  �������� �κ��� �� ������ ȸ������ �Է��� �� �ֽ��ϴ�.");
		sentence4 = new JLabel("  You can enter the anchor value of each skeleton.");
		sentence5 = new JLabel("  �κ��� �������� �ϳ��� Ű������ ������ �̷���� �ֽ��ϴ�.");
		sentence6 = new JLabel("  Robot's motion consisted by KeyFrame unit.");
		sentence7 = new JLabel("  �������� ���� ���� Ű�������� �����Ͽ� �ִϸ��̼��� ������ �� �ֽ��ϴ�.");
		sentence8 = new JLabel("  You can make animation by adding Keyframes.");
		sentence9 = new JLabel("  ���� �ִϸ��̼��� ���̺����Ϸ� ������ �� �ֽ��ϴ�. ���� �ε嵵 �����մϴ�.");
		sentence10 = new JLabel("  You can save the animation and load.");
		
		sentence1.setForeground(text);
		sentence2.setForeground(text);
		sentence3.setForeground(text);
		sentence4.setForeground(text);
		sentence5.setForeground(text);
		sentence6.setForeground(text);
		sentence7.setForeground(text);
		sentence8.setForeground(text);
		sentence9.setForeground(text);
		sentence10.setForeground(text);
		
		sentence1.setFont(clear_gothic);
		sentence2.setFont(clear_gothic);
		sentence3.setFont(clear_gothic);
		sentence4.setFont(clear_gothic);
		sentence5.setFont(clear_gothic);
		sentence6.setFont(clear_gothic);
		sentence7.setFont(clear_gothic);
		sentence8.setFont(clear_gothic);
		sentence9.setFont(clear_gothic);
		sentence10.setFont(clear_gothic);
		
		panel.add(sentence1);
		panel.add(sentence2);
		panel.add(sentence3);
		panel.add(sentence4);
		panel.add(sentence5);
		panel.add(sentence6);
		panel.add(sentence7);
		panel.add(sentence8);
		panel.add(sentence9);
		panel.add(sentence10);
	}
}
