/**
 * Control_Panel.java
 * 
 * Control_Panel holds some buttons to control music & dancing.
 * Note that this class should be linked with RobotWindow.
 * 
 * @author Taein Kim
 * @comment Se-Kyu-Kwon (also did refactoring)
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
	public JLabel       cur_music;
	
	// Attribution & Style
	private Color C_BUTTON_BG   = new Color(0, 100, 147);   // Color of Button's Background
	private Color C_BUTTON_FG   = new Color(255, 255, 255); // Color of Button's Foreground
	private Color C_CHECKBOX_BG = new Color(50, 50, 50);    // Color of Checkbox's Background
	private Color C_CHECKBOX_FG = new Color(170, 170, 170); // Color of Checkbox's Foreground
	private Font  clear_gothic  = new Font("맑은 고딕", Font.BOLD, 12);
	
	// Play button flag
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
		 * Robot Activation Control Box
		 */
		add(new_RobotActCheckbox(0));
		add(new_RobotActCheckbox(1));
		
		/*
		 * Music Mode Toggle
		 */
		add(new_MusicModeCheckbox());
		
		/*
		 * Start Dancing
		 */
		add(new_DancingButton(true));
		add(new_DancingButton(false));
		
		/*
		 * Load TS Robot image to the left side of main UI
		 */
		add(new_LogoImage());
		
		/*
		 * Notice Label
		 */		
		add(new_InfoLabel("음악 삽입 : "));
		
		/*
		 * Music Load Button
		 */
		add(new_MusicLoadButton());
		
		/*
		 * Loaded Music's Name
		 */
		cur_music = new JLabel("파일명 : 추가된 파일 없음");
		cur_music.setPreferredSize(new Dimension(155, 15));
		cur_music.setBackground(C_CHECKBOX_BG);
		cur_music.setForeground(C_CHECKBOX_FG);
		cur_music.setFont(clear_gothic);
		add(cur_music);
	}
	
	/**
	 * Create a robot activation control box.
	 * 
	 * This doesn't add directly to this panel, so use it's
	 * return reference to the container.
	 * @return JCheckBox with activation function
	 */
	private JCheckBox new_RobotActCheckbox(int robotIndex)
	{
		/*
		 * Create JCheckBox and set it's attribution
		 */
		JCheckBox checkBox = new JCheckBox("  ROBOT" + (robotIndex+1) + " 활성화  ");
		checkBox.setBackground(C_CHECKBOX_BG);
		checkBox.setForeground(C_CHECKBOX_FG);
		checkBox.setFont(clear_gothic);
		
		/*
		 * Assign checkbox listener.
		 */
		checkBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(checkBox.isSelected())
				{
					System.out.println("[Control_Panel : Checkbox] Notice : ROBOT" + (robotIndex+1) + " activated.");
					robotMain.activeRobot(robotIndex);
				}
				else
				{
					System.out.println("[Control_Panel : Checkbox] Notice : ROBOT" + (robotIndex+1) + " deactivated.");
					robotMain.deactiveRobot(robotIndex);
				}
			}
		});
		
		return checkBox;
	}
	
	/**
	 * Create a music mode control checkbox.
	 * 
	 * This doesn't add directly to this panel, so use it's
	 * return reference to the container.
	 * @return JCheckBox with music control feature
	 */
	private JCheckBox new_MusicModeCheckbox()
	{
		JCheckBox checkBox = new JCheckBox("  음악 모드 활성화 ");
		checkBox.setBackground(C_CHECKBOX_BG);
		checkBox.setForeground(C_CHECKBOX_FG);
		checkBox.setFont(clear_gothic);
		
		checkBox.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(checkBox.isSelected()) 
				{
					robotMain.setMode(true);
					System.out.println("[Control Panel : Checkbox] Notice : Music Mode On");
				} 
				else
				{
					robotMain.setMode(false);
					System.out.println("[Control Panel : Checkbox] Notice : Music Mode Off");
				}
			}
		});
		
		return checkBox;
	}
	
	/**
	 * Create a playing-button.
	 * 
	 * This doesn't add directly to this panel, so use it's
	 * return reference to the container.
	 * @return JButton with proper action
	 */
	private JButton new_DancingButton(boolean play)
	{
		JButton button;
		if(play)
		{
			button = new JButton("    재생 (PLAY)    ");
		}
		else
		{
			button = new JButton("    정지 (STOP)    ");
		}
		button.setBackground(C_BUTTON_BG);
		button.setForeground(C_BUTTON_FG);
		button .setFont(clear_gothic);
		
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// To protect from duplicated play call
				if(isPlay ^ play)
				{
					if(play)
					{
						System.out.println("[Control_Panel : Button] Start dancing.");
						robotMain.startDancing();
					}
					else
					{
						System.out.println("[Control_Panel : Button] Stop dancing.");
						robotMain.stopDancing();
					}
					isPlay = !isPlay;
				}
			}
		});
		
		return button;
	}
	
	/**
	 * Create a logo image.
	 * 
	 * This doesn't add directly to this panel, so use it's
	 * return reference to the container.
	 * @return JLabel with logo image.
	 */
	private JLabel new_LogoImage()
	{
		JLabel logoImage = new JLabel(new ImageIcon(RelativePath.getAbsolutePath("image\\icon_noname.jpg")));
    	logoImage.setPreferredSize(new Dimension(150, 150));
		logoImage.setBackground(C_CHECKBOX_FG);
		logoImage.setForeground(C_CHECKBOX_FG);
		
		return logoImage;
	}
	
	/**
	 * Create a music loading button.
	 * 
	 * This doesn't add directly to this panel, so use it's
	 * return reference to the container.
	 * @return JButton with music loading event
	 */
	private JButton new_MusicLoadButton()
	{
		JButton load_music = new JButton("음악 선택");
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
				String music_name = FileOpenDialog.openFile("Select MP3 file to use", "Music File", "mp3");
				robotMain.setBGM(music_name);
				if(music_name == null)
				{
					cur_music.setText("파일명 :  " + "추가된 파일 없음");
				} 
				else 
				{
					cur_music.setText("파일명 :  " + music_name);
				}
			}
		});
		
		return load_music;
	}
	
	/**
	 * Create a info giving label. Not that special.
	 * 
	 * This doesn't add directly to this panel, so use it's
	 * return reference to the container.
	 * @param content
	 * @return
	 */
	private JLabel new_InfoLabel(String content)
	{
		JLabel infoLabel = new JLabel(content);
		infoLabel.setBackground(C_CHECKBOX_BG);
		infoLabel.setForeground(C_CHECKBOX_FG);
		infoLabel.setFont(clear_gothic);
		
		return infoLabel;
	}
}