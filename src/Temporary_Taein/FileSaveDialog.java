/**
 * FileSaveDialog.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import java.awt.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
public class FileSaveDialog {
	File file;
	String imsi2;
	JFrame parentFrame = new JFrame();
	JFileChooser fileChooser = new JFileChooser();
	FileFilter filter = new FileNameExtensionFilter("DancingRobot File", "iwbtr");
	
	public FileSaveDialog () {
		showDialog ();
	}
	
	public String showDialog () {
		fileChooser.setFileFilter(filter);
		Component parent = null;
		if(fileChooser.showSaveDialog(null) == 1)
			return null;
		else {
			return fileChooser.getSelectedFile().getAbsolutePath();
		}
	}

}