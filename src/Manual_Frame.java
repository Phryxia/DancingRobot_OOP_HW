
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
	private Font   clear_gothic = new Font("맑은 고딕", Font.BOLD, 12);
	
	Toolkit theKit = getToolkit();
	Dimension screenSize = theKit.getScreenSize();
	
	public Manual_Frame () {
		setTitle("사용법 (How to Use)");
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
		sentence1 = new JLabel("  로봇은 5개의 관절로 이루어져 있습니다.                                           ");
		sentence2 = new JLabel("  The Robot has 5 skeletons.                                         ");
		sentence3 = new JLabel("  여러분은 로봇의 각 관절의 회전각을 입력할 수 있습니다.");
		sentence4 = new JLabel("  You can enter the anchor value of each skeleton.");
		sentence5 = new JLabel("  로봇의 움직임은 하나의 키프레임 단위로 이루어져 있습니다.");
		sentence6 = new JLabel("  Robot's motion consisted by KeyFrame unit.");
		sentence7 = new JLabel("  여러분은 여러 개의 키프레임을 생성하여 애니메이션을 구현할 수 있습니다.");
		sentence8 = new JLabel("  You can make animation by adding Keyframes.");
		sentence9 = new JLabel("  만든 애니메이션을 세이브파일로 저장할 수 있습니다. 물론 로드도 가능합니다.");
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
