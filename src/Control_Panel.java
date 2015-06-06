/**
 * Control_Panel.java
 * 
 * Control_Panel holds some buttons to control music & dancing.
 * Note that this class should be linked with RobotWindow.
 * 
 * @author Taein Kim
 * @comment Se-Kyu-Kwon
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SuppressWarnings("serial")
public class Control_Panel extends JPanel {
	private RobotWindow robotMain;
	
	public JCheckBox r1_Active;
	public JCheckBox r2_Active;
	public JCheckBox music_Mode;
	
	public JButton   play_anim;
	public JButton   stop_anim;
	public JButton   load_music;
	
	public JLabel    logoImage;
	public JLabel    cur_music;
	
	public String    music_name = "추가된 파일 없음";
	
	// Attribution & Style
	private Color C_BUTTON_BG   = new Color(0, 100, 147);   // Color of Button's Background
	private Color C_BUTTON_FG   = new Color(255, 255, 255); // Color of Button's Foreground
	private Color C_CHECKBOX_BG = new Color(50, 50, 50);    // Color of Checkbox's Background
	private Color C_CHECKBOX_FG = new Color(170, 170, 170); // Color of Checkbox's Foreground
	private Font  clear_gothic  = new Font("맑은 고딕", Font.BOLD, 12);
	
	private boolean isPlay = false;
	
	//MP3 File Name which is loaded.
	String file_name;
	
	/**
	 * Create an Control_Panel with specified design.
	 * Checkout then below comment
	 *
	 * @author Taein Kim
	 */
	public Control_Panel (RobotWindow robotMain) {
		if(robotMain == null)
		{
			throw new NullPointerException("[ControlPanel : Constructor] Null robotMain reference is now allowed");
		}
		this.robotMain = robotMain;
		
		setBackground(C_CHECKBOX_BG);
		
		/*
		 * < Design Preview >
		 * 
		 *   [ ] Robot 1     <--- If you check this, robot 1 should be activated
		 *   [ ] Robot 2     <--- If you check this, robot 2 should be activated
		 *   [ ] Music Mode  <--- If you check this, robot mode shold be set as music mode.
		 *   
		 *   [    PLAY    ]  <--- Start dancing
		 *   [    STOP    ]  <--- Stop dancing
		 *   
		 *   #############
		 *   #           #
  		 *   #           #
		 *   # I M A G E #
		 *   #           #
  		 *   #           #
		 *   #############
		 *   
		 *   Music : [ ADD ] <--- Load music file
		 *   Name : ~~~~~~   <--- Display loaded file's name
		 */
		
		/*
		 * Robot 1 Activation
		 */
		r1_Active = new JCheckBox("  ROBOT1 활성화  ");
		r1_Active.setBackground(C_CHECKBOX_BG);
		r1_Active.setForeground(C_CHECKBOX_FG);
		r1_Active .setFont(clear_gothic);
		add(r1_Active);
		
		/*
		 * Robot 2 Activation
		 */
		r2_Active = new JCheckBox("  ROBOT2 활성화  ");
		r2_Active.setBackground(C_CHECKBOX_BG);
		r2_Active.setForeground(C_CHECKBOX_FG);
		r2_Active .setFont(clear_gothic);
		add(r2_Active);
		
		/*
		 * Music Mode Toggle
		 */
		music_Mode = new JCheckBox("  음악 모드 활성화 ");
		music_Mode.setBackground(C_CHECKBOX_BG);
		music_Mode.setForeground(C_CHECKBOX_FG);
		music_Mode.setFont(clear_gothic);
		add(music_Mode);
		
		/*
		 * Start Dancing
		 */
		play_anim = new JButton("    재생 (PLAY)    ");
		play_anim.setBackground(C_BUTTON_BG);
		play_anim.setForeground(C_BUTTON_FG);
		play_anim .setFont(clear_gothic);
		add(play_anim);
		
		play_anim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isPlay) {
					System.out.println("[Control_Panel] Notice : Play_Button is clicked");
					robotMain.setMode(false);
					robotMain.startDancing();
					isPlay = true;
				}
			}
		});
		
		/*
		 * Stop Dancing
		 */
		stop_anim = new JButton("    정지 (STOP)    ");
		stop_anim.setBackground(C_BUTTON_BG);
		stop_anim.setForeground(C_BUTTON_FG);
		stop_anim .setFont(clear_gothic);
		add(stop_anim);
		
		stop_anim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isPlay) {
					System.out.println("[Control_Panel] Notice : Stop_Button is clicked");
					robotMain.stopDancing();
					isPlay = false;
				}
			}
		});
		
		/*
		 * Load TS Robot image to the left side of main UI
		 */
		logoImage = new JLabel(new ImageIcon(RelativePath.getAbsolutePath("image\\icon_noname.jpg")));
    	logoImage.setPreferredSize(new Dimension(150, 150));
		logoImage.setBackground(C_CHECKBOX_FG);
		logoImage.setForeground(C_CHECKBOX_FG);
		add(logoImage);
		
		/*
		 * Notice Label
		 */
		JLabel infoLabel = new JLabel("음악 삽입 : ");
		infoLabel.setBackground(C_CHECKBOX_BG);
		infoLabel.setForeground(C_CHECKBOX_FG);
		infoLabel.setFont(clear_gothic);
		add(infoLabel);
		
		/*
		 * Music Load Button
		 */
		load_music = new JButton("음악 추가");
		load_music.setBackground(C_BUTTON_BG);
		load_music.setForeground(C_BUTTON_FG);
		load_music.setFont(clear_gothic);
		add(load_music);
		
		load_music.addActionListener(new ActionListener()
		{
			/**
			 * This will open the dialog which get music file's
			 * absolute path. Then, make RobotWindow to load
			 * that file and change the label as this loaded.
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				music_name = FileOpenDialog.openFile("Select MP3 file to use", "mp3");
				robotMain.setBGM(music_name);
				cur_music.setText("파일명 :  " + music_name);
			}
		});
		
		/*
		 * Loaded Music's Name
		 */
		cur_music = new JLabel("파일명 :  " + music_name);
		cur_music.setPreferredSize(new Dimension(155, 15));
		cur_music.setBackground(C_CHECKBOX_BG);
		cur_music.setForeground(C_CHECKBOX_FG);
		cur_music.setFont(clear_gothic);
		add(cur_music);
	}
}