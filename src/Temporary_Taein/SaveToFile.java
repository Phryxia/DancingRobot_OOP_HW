package Temporary_Taein;
import java.awt.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
public class SaveToFile {
	File file;
	String imsi2;
	JFrame parentFrame = new JFrame();
	JFileChooser fileChooser = new JFileChooser();
	FileFilter filter = new FileNameExtensionFilter("DancingRobot File", "iwbtr");
	
	public SaveToFile () {
		showDialog ();
	}
	
	public void showDialog () {
		fileChooser.setFileFilter(filter);
		Component parent = null;
		int imsi = fileChooser.showSaveDialog(parentFrame);
		imsi2 = fileChooser.getSelectedFile().getAbsolutePath();
	}
	
	public String getPath () {
		return imsi2;
	}
	
}

/*
 * String filename = ~~~;
 * 
 * filename.matches("(.)*\\.mp3")
 */