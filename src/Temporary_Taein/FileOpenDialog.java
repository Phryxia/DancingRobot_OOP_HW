/**
 * FileOpenDialog.java
 * 
 * @author Taein Kim
 */
package Temporary_Taein;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class FileOpenDialog extends JFrame {
	FileFilter filter;
	String filename;
	String filepath;
	JFileChooser chooser = new JFileChooser();
	
	public FileOpenDialog (String input1, String input2) {
		filter = new FileNameExtensionFilter(input1, input2);
		filepath = openFile(1);
		filename = openFile(2);
	}
	
	/**
	 * Method Open File
	 * 
	 * @return Absolute Path of File or null.
	 */
	public String openFile (int option) {
		chooser.setFileFilter(filter);
		if(chooser.showOpenDialog(null) == 1)
			return null;
		else {
			if(option == 1) {
				return chooser.getSelectedFile().getAbsolutePath();
			} else if(option == 2) {
				return chooser.getSelectedFile().getName();
			}
		}
		
		return null;
	}
	
	public String getFileInfo (int option) {
		if(option == 1)
			return filepath;
		else if(option == 2)
			return filename;
		return null;
	}

}
