/**
 * Control_Panel.java
 * 
 * @author Taein Kim
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class Control_Panel extends JPanel {
	public JCheckBox r1_Active;
	public JCheckBox r2_Active;
	
	public JButton   play_anim;
	public JButton   stop_anim;
	public JButton   load_music;
	
	public JLabel    what_name;
	public JLabel    cur_music;
	public JLabel    empty_space;
	public String    music_name = "추가된 파일 없음";
	
	FileOpenDialog     fod;
	Font               clear_gothic = new Font("맑은 고딕", Font.BOLD, 12);
	Color              btn_bg       = new Color(0, 100, 147);
	Color              btn_txt      = new Color(255, 255, 255);
	BufferedImage      img;
	ImageIcon          pic          = new ImageIcon("C:\\icon_bg.png");
	
	//MP3 File Name which is loaded.
	String file_name;
	
	public Control_Panel () {
		r1_Active = new JCheckBox("  ROBOT1 활성화  ");
		r2_Active = new JCheckBox("  ROBOT2 활성화  ");
		
		play_anim = new JButton("    재생 (PLAY)    ");
		stop_anim = new JButton("    정지 (STOP)    ");
		
		setBackground(new Color(50, 50, 50));
		r1_Active.setBackground(new Color(50, 50, 50));
		r1_Active.setForeground(new Color(170, 170, 170));
		
		r2_Active.setBackground(new Color(50, 50, 50));
		r2_Active.setForeground(new Color(170, 170, 170));
		
		play_anim.setBackground(new Color(0, 100, 147));
		play_anim.setForeground(new Color(255, 255, 255));
		
		stop_anim.setBackground(new Color(0, 100, 147));
		stop_anim.setForeground(new Color(255, 255, 255));
		
		r1_Active.setFont(clear_gothic);
		r2_Active.setFont(clear_gothic);
		play_anim.setFont(clear_gothic);
		stop_anim.setFont(clear_gothic);
		
		try {
			music_Control();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		add(r1_Active);
		add(r2_Active);
		
		add(play_anim);
		add(stop_anim);
		
		add(empty_space);
		add(what_name);
		add(load_music);
		add(cur_music);
	}
	
	public String ret_music () {
		return music_name;
	}
	
	/*
	 * This part will draw UIs about playing & stop music.
	 */
	public void music_Control () throws IOException {
		what_name = new JLabel("음악 삽입 : ");
		what_name.setFont(clear_gothic);
		what_name.setForeground(new Color(170, 170, 170));
		what_name.setBackground(new Color(50, 50, 50));
		
		cur_music = new JLabel("파일명 :  " + music_name);
		cur_music.setFont(clear_gothic);
		cur_music.setPreferredSize(new Dimension(155, 15));
		cur_music.setBackground(new Color(50, 50, 50));
		cur_music.setForeground(new Color(170, 170, 170));
		
		/*
		 * This button change music file.
		 */
		load_music = new JButton("음악 추가");
		load_music.setFont(clear_gothic);
		load_music.setBackground(btn_bg);
		load_music.setForeground(btn_txt);
		load_music.addActionListener(new ActionListener() {
			/**
			 * This will open the dialog which get music file's
			 * absolute path.
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fod = new FileOpenDialog("MP3 File", "mp3");
				music_name = fod.getFile(2);
				cur_music.setText("파일명 :  " + fod.getFileInfo(2));
			}
		});
		
		Dimension space_size = new Dimension(150, 200);

		/*
		 * Load TS Robot image to the left side of main UI
		 */
		empty_space = new JLabel(new ImageIcon(RelativePath.getAbsolutePath("image\\icon_noname.jpg")));
    	empty_space.setPreferredSize(space_size);
		empty_space.setBackground(new Color(50, 50, 50));
		empty_space.setForeground(new Color(170, 170, 170));
	}

}