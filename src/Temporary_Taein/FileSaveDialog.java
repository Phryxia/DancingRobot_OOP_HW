/**
 * FileSaveDialog.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import java.io.*;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
public class FileSaveDialog {
	File file;
	String imsi2;
	String filename;
	String filepath;
	JFrame parentFrame = new JFrame();
	JFileChooser chooser = new JFileChooser();
	FileFilter filter = new FileNameExtensionFilter("DancingRobot File", "iwbtr");
	
	public FileSaveDialog () {
		if(saveFile() == 0) {
			filename = getFile(1);
			filepath = getFile(2);
			System.out.println(getFileInfo(1));
			System.out.println(getFileInfo(2));
		}
	}
	
	public int saveFile () {
		chooser.setFileFilter(filter);
		if(chooser.showOpenDialog(null) == 1)
			return 1;
		return 0;
	}
	
	public String getFile(int option) {
		if(option == 1) {
			return chooser.getSelectedFile().getName();
		} else {
			return chooser.getSelectedFile().getAbsolutePath();
		}
	}
	
	public String getFileInfo (int option) {
		if(option == 1)
			return filepath;
		else if(option == 2)
			return filename;
		return null;
	}

}