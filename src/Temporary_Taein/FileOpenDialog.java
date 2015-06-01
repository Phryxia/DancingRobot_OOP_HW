/**
 * FileOpenDialog.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class FileOpenDialog extends JFrame {
	FileFilter filter = new FileNameExtensionFilter("DancingRobot File","iwbtr");
	JFileChooser chooser = new JFileChooser();
	private String filename;
	private int returnVal;
	
	public FileOpenDialog () {
			System.out.println(openFile());
		
	}
	
	public String getAddress() {
		return chooser.getSelectedFile().getAbsolutePath();
	}
	
	/**
	 * Method Open File
	 * 
	 * @return Absolute Path of File or null.
	 */
	public String openFile () {
		chooser.setFileFilter(filter);
		if(chooser.showOpenDialog(null) == 1)
			return null;
		else {
			return chooser.getSelectedFile().getAbsolutePath();
		}
	}

}
