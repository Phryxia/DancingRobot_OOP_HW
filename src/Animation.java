/**
 * Animation class hold OptionList and OptionListEditor.
 * Inside the OptionList, there is InstructionIO.
 * 
 * OptionListEditor only read & write temporary values while
 * OptionList really change InstructionIO by obtaining ArrayList
 * from OptionListEditor.
 * 
 * @author Tae-In-Kim
 * @comment Se-Kyu-Kwon
 */
import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Animation extends JPanel implements StandardPartName {
	
	private Color c_background = new Color(50, 50, 50);
	@SuppressWarnings("unused")
	private int num;
	public  OptionList       optionList;
	public  OptionListEditor optionListEditor;
	
	/**
	 * Constructor.
	 * 
	 * You must pass valid iReference. Otherwise NullPointerException will
	 * be thrown.
	 */
	public Animation (InstructionIO iReference, int num) {
		this.num = num;
		// NullPointer Check
		if(iReference == null) {
			throw new NullPointerException("[Animatino : Constructor] Null reference is not allowed");
		}
		
		// Setting attribution
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		setBackground(c_background);
		
		// Construct OptionList
		optionList       = new OptionList(iReference);
		add(optionList);
		
		// Construct OptionListEditor
		optionListEditor = new OptionListEditor(optionList, num);
		add(optionListEditor);
	}
	
	public void refresh()
	{
		optionList.refreshList();
	}
}