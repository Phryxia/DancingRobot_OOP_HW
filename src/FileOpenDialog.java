/**
 * FileOpenDialog.java
 * 
 * @author Taein Kim
 */

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
		if(openFile() == 0) {
			filename = getFile(1);
			filepath = getFile(2);
			System.out.println(getFileInfo(1));
			System.out.println(getFileInfo(2));
		}
	}
	
	/**
	 * Method Open File
	 * 
	 * @return Absolute Path of File or null.
	 */
	public int openFile () {
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
