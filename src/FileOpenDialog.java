/**
 * FileOpenDialog.java
 * 
 * This class provides users to get absolute path using JFileChooser.
 * 
 * @author Taein Kim (did Main Implementation)
 * @comment Se-Kyu-Kwon (also did refactoring)
 */

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class FileOpenDialog extends JFrame {
	/**
	 * Generate absolute path to load any file.
	 * If user press cancel button, then null would be returned.
	 * 
	 * @param comment
	 * @param description
	 * @param extension
	 * @return
	 */
	public static String openFile(String comment, String description, String extension) {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(description, extension);
		
		fileChooser.setDialogTitle(comment);
		fileChooser.setFileFilter(filter);
		switch(fileChooser.showOpenDialog(null)) {
		case JFileChooser.APPROVE_OPTION:
			return fileChooser.getSelectedFile().getAbsolutePath();
		default:
			return null;
		}
	}
	
	/**
	 * Generate absolutepath to save any file.
	 * If you don't extension to string then it'll automatically
	 * concatenate it.
	 *
	 * If user press cancel button, then null would be returned.
	 * 
	 * @param comment
	 * @param description
	 * @param extension
	 * @return
	 */
	public static String saveFile(String comment, String description, String extension) {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(description, extension);
		
		fileChooser.setDialogTitle(comment);    
		fileChooser.setFileFilter(filter);
		switch(fileChooser.showSaveDialog(null)) {
		case JFileChooser.APPROVE_OPTION:
			String temp = fileChooser.getSelectedFile().getAbsolutePath();
			if(!temp.matches("(.)*\\." + extension)) {
				temp += "." + extension;
			}
			return temp;
		default:
			return null;
		}
	}
}
