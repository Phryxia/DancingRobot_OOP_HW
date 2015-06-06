import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import ddf.minim.*;
import ddf.minim.analysis.FFT;

/**
 * This class manage dancing robot's bgm.
 * It can be played using some public method.
 * 
 * This is also designed for Observer Pattern.
 * 
 * @author Se-Kyu-Kwon
 */
public class BGM
{
	private Minim minim;
	private AudioPlayer player;
	private FileInputStream fs;
	
	private ArrayList <BGMListener> bgmListener;
	
	/**
	 * Constructor.
	 */
	public BGM()
	{
		minim  = new Minim(this);
		player = null;
		fs     = null;
		
		bgmListener = new ArrayList <BGMListener> (16);
	}
	
	/**
	 * Load MP3 File. If format is not valid, nothing change.
	 * 
	 * @param filename
	 */
	public void loadMP3(String filename)
	{
		// Check the extension
		if(filename.matches("(.)*\\.mp3"))
		{
			// Close AudioPlayer before load new one.
			if(player != null)
			{
				player.close();
			}
			
			// Load new mp3 to the audioFactory
			player = minim.loadFile(filename);
			
			// Call musicChanged Handler.
			for(BGMListener bl : bgmListener)
			{
				bl.musicChanged(this);
			}
		}
		else
		{
			System.out.println("[BGM : loadMP3] Warning : Invalid input file willi be ignored : " + filename);
		}
	}
	
	/**
	 * Add bgmListener to handle music event.
	 * 
	 * @param b
	 */
	public void addBGMListener(BGMListener b)
	{
		if(b != null)
		{
			bgmListener.add(b);
		}
		else
		{
			System.out.println("[BGM : addBGMListener] Warning : Null listener will be ignored");
		}
	}
	
	/**
	 * Play current loaded music.
	 */
	public void play()
	{
		if(player != null)
		{
			player.play();
			
			// Call musicStarted Handler.
			for(BGMListener bl : bgmListener)
			{
				bl.musicStarted(this);
			}
		}
	}
	
	/**
	 * Stop current playing music.
	 */
	public void stop()
	{
		if(player != null)
		{
			player.pause();
			player.rewind();
			
			// Call musicStopped Handler.
			for(BGMListener bl : bgmListener)
			{
				bl.musicStopped(this);
			}			
		}
	}
	
	/**
	 * Return current audio player's buffer size
	 * @return
	 */
	public int getBufferSize()
	{
		if(player != null)
		{
			return player.left.size();
		}
		else
		{
			return 0;
		}
	}
	
	public AudioPlayer getPlayer()
	{
		return player;
	}
	
	public FFT getFFT()
	{
		if(player != null)
		{
			return new FFT(player.bufferSize(), player.sampleRate());
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * To handle minim properly, we have to provide sketchPath method.
	 * The original sketchPath method is in PApplet, yet we don't
	 * use PApplet in this project. That's why minim make us provide
	 * such method.
	 * 
	 * This code takes reference from here:
	 * https://github.com/processing/processing/blob/master/core/src/processing/core/PApplet.java
	 * at line 6899. Thank you for kind comments and open-source.
	 * 
	 * @param where
	 * @return
	 */
	public String sketchPath(String where)
	{
		/*
		 * There are some different cases to handle.
		 * 
		 * i) Where is "Absolute Path". This can be examined by checking ~~:\~~
		 * ii) Otherwise where is "Relative Path". (We're not gonna provide URL based loading)
		 */
		String folder = null;
		
		// Check Null Exception
		if(where == null)
		{
			throw new NullPointerException("[BGM : sketchPath] Null argument error");
		}
		
		// Check whether the path starts C:\ kinds name...
		if(where.matches("[A-Z]:(.)*"))
		{
			return where;
		}
		else
		{
			// If it's not absolute path, then you have to add project path.
			try
			{
				folder = System.getProperty("user.dir");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			return folder +".\\" + where;
		}
	}
	
	/**
	 * Imitation method of PApplet.createInput.
	 * This will return 
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public InputStream createInput(String filename) throws FileNotFoundException
	{
		fs = new FileInputStream(sketchPath(filename));
		return fs;
	}
	
	/**
	 * You MUST run this code at the end of main method!!
	 * This will release every file resource
	 * 
	 * @throws IOException
	 */
	public void shutdown() throws IOException
	{
		if(player != null)
		{
			player.close();
		}
		
		if(fs != null)
		{
			fs.close();
		}
	}
}
