/**
 * Option_List_1.java
 * 
 * @author Taein Kim
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;

/**
 * OptionList is a container class which has instruction list.
 * This must be synced with InstructionIO.
 * 
 * @author Tae-In-Kim
 * @comment Se-Kyu-Kwon
 *
 */
@SuppressWarnings("serial")
public class OptionList extends JPanel {
	/*
	 * DefaultListModel is an abstract container of MotionList.
	 * JList is just graphical representation of it.
	 * If you want to modify some significant values, then you
	 * must access to the DefaultListModel.
	 */
	private InstructionIO             motionList;
	private DefaultListModel <String> motionNameList;
	private JList            <String> motionNameDisplayer;
	private JScrollPane               scrollbar;
	private int currentSelected = -1;
	
	/**
	 * Constructor
	 * 
	 * Initial the Scroll Pane and Add to Panel.
	 * Please offer him proper InstructionIO.
	 * Do NOT create a new InstructionIO when you
	 * construct this object.
	 * 
	 * Invariant : InstructionIO must be linked (= cannot be null)
	 * 
	 * @author Taein Kim
	 * @comment Se-Kyu-Kwon
	 */
	public OptionList (InstructionIO iReference) {
		// NullPointerHandling
		if(iReference == null)
		{
			throw new NullPointerException();
		}
		
		// Set attribution
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		// Construction partial things
		motionList = iReference;
		motionNameListInit();
		motionNameDisplayerInit();		
		scrollbarInit();
	}
	
	/**
	 * Grouping function for initializing MotionNameList
	 */
	private void motionNameListInit()
	{
		motionNameList = new DefaultListModel <String>();
	}
	
	/**
	 * Grouping function for initializing MotionNameDisplayer
	 * You MUST call motionListInit() first before you call this
	 */
	private void motionNameDisplayerInit()
	{
		motionNameDisplayer = new JList <String> (motionNameList);
		motionNameDisplayer.setForeground(new Color(170, 170, 170));
		motionNameDisplayer.setBackground(new Color(40, 40, 40));
		motionNameDisplayer.setPreferredSize(new Dimension(70, 120));
	}
	
	/**
	 * Grouping function for initializing scrollbar.
	 * You must call motionNameDisplayerInit() first before you call this.
	 */
	private void scrollbarInit()
	{
		scrollbar = new JScrollPane(motionNameDisplayer);
		scrollbar.setForeground(new Color(40, 40, 40));
		scrollbar.setPreferredSize(new Dimension(90, 120));
		add(scrollbar);
	}
	
	/**
	 * Add new Motion(=InstructionList) to this list system.
	 * Both it's name and contents will be added simultaneously.
	 * 
	 * @param motionName
	 * @param angleList
	 */
	public void addMotion(String motionName, ArrayList <Integer> angleList)
	{
		// Create Instruction List
		ArrayList <Instruction> insList = new ArrayList <Instruction> (6);
		for(Integer i : angleList)
		{
			Instruction ins = new Instruction(0, 0, i);
			insList.add(ins);
		}
		
		// Insert to the InstructionIO.
		if(0 <= currentSelected && currentSelected < motionList.size())
		{
			// Valid position. Insert it at this point.
			motionList.add(currentSelected, insList);
			motionNameList.add(currentSelected, motionName);
		}
		else
		{
			// Pointer state is out of range.
			currentSelected = -1;
			motionList.add(insList);
			motionNameList.addElement(motionName);
		}
	}
	
	/**
	 * Remove current pointed Motion from this list system.
	 * Both name & contents will be removed simultaneously.
	 */
	public void removeMotion()
	{
		if(0 <= currentSelected && currentSelected < motionList.size())
		{
			// Valid position. Remove it.
			motionList.remove(currentSelected);
			motionNameList.remove(currentSelected);
		}
		else
		{
			// Pointer state is out of range. Just Ignore.
			currentSelected = -1;
		}
	}
	
	/**
	 * Grouping function to assign some event handler to this object.
	 */
	private void eventInit()
	{
		/*
		 * Event Handler to update current pointer from motionNameDisplayer.
		 */
		motionNameDisplayer.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				if (!e.getValueIsAdjusting())
				{
					// Update values
					currentSelected = motionNameDisplayer.getSelectedIndex();
					
					System.out.println("[OptionList : eventInit]" +
							"Log : currentSelected = " + currentSelected);
	            }
			}
		});
	}
}