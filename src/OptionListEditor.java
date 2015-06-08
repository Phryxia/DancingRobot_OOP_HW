/**
 * optionListEditor contains some textField, JButtons
 * to modify the OptionList which holds InstructionIO.
 * 
 * Note that this doesn't change directly InstructionIO.
 * It only generate ArrayList to give & take with
 * OptionList.
 * 
 * @author Tae-In-Kim
 * @comment Se-Kyu-Kwon
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class OptionListEditor extends JPanel implements StandardPartName {
	// List Reference
	private OptionList listReference;
	@SuppressWarnings("unused")
	private int num;
	
	// Attribution
	private Color     c_selected = new Color(255, 210, 0);
	private Color     background = new Color(50, 50, 50);
	private Color     tf_back    = new Color(30, 30, 30);
	private Color     textcolor  = new Color(220, 220, 220);
	private Color     c_button   = new Color(0, 100, 147);
	
	private Font clear_gothic = new Font("맑은 고딕", Font.BOLD, 12);
	
	// Editor UI Components
	private JLabel[]     ptNameField; // Stores part name label
	private JTextField[] numberField; // Stores number editor
	private JLabel       title;
	private JButton      addbtn    = new JButton("Add");
	private JButton      rembtn    = new JButton("Remove");
	
	/**
	 * Create an OptionListEditor.
	 * 
	 * Invariant : You must link listReference.
	 * Otherwise NullPointerException will be occurred.
	 */
	@SuppressWarnings("deprecation")
	public OptionListEditor (OptionList listReference, int num) {
		this.num = num;
	    title = new JLabel("<ROBOT " + num + ">");
		
		// Assign Link
		if(listReference == null) {
			throw new NullPointerException("[OptionListEditor : Constructor] Null reference is not allowed");
		}
		this.listReference = listReference;
		this.listReference.setEditor(this);
		
		// Define this panel's layout style.
		setLayout(new GridLayout(5, 4, 5, 5));
		setPreferredSize(new Dimension(360, 140));
		
		setBackground(background);
		
		// Construct the title part
		titleInit();
		
		// Construct the part name label
		ptNameFieldInit();
		
		// Construct the number field
		numberFieldInit();		
		
		// Construct the button
		buttonInit();
		
		// Assign UI
		add(title);
		
		// Skip 3 cells
		add(new JLabel());
		//add(new JLabel());
		//add(new JLabel());

		// Add Buttons
				add(addbtn);
				add(rembtn);
		
		// Assign Label & Number Fields
		for(int i=0; i<numberField.length; ++i) {
			// Add PtName First
			add(ptNameField[i]);
			
			// Then add 
			add(numberField[i]);
		}
		
		
		
		// Initialize Event
		eventInit();
	}
	
	/**
	 * Grouping function for title initialization
	 */
	public void titleInit() {
		title.setForeground(textcolor);
	}

	/**
	 * Grouping function for Part Name Labels initialization
	 */
	private void ptNameFieldInit() {
		// Construct the ptNameFields
		ptNameField = new JLabel[6];
				
		ptNameField[BODY]      = new JLabel("   Body :");
		ptNameField[ARM_LEFT]  = new JLabel("   Left Arm :");
		ptNameField[ARM_RIGHT] = new JLabel("   Right Arm :");
		ptNameField[HEAD]      = new JLabel("   Head :");
		ptNameField[LEG_LEFT]  = new JLabel("   Left Leg :");
		ptNameField[LEG_RIGHT] = new JLabel("   Right Leg :");
				
		// Set the style & design of ptNameField
		for(int i=0; i<ptNameField.length; ++i) {
			ptNameField[i].setForeground(textcolor);
		}
	}
	
	/**
	 * Grouping function for Number Fields initialization
	 */
	private void numberFieldInit() {
		// Construct the numberFields
		numberField = new JTextField[6];
		for(int i=0; i<numberField.length; ++i) {
			// Construct new JTextField
			numberField[i] = new JTextField(3);
					
			// Setting the style & design
			numberField[i].setSelectionColor(c_selected);
			numberField[i].setSelectedTextColor(tf_back);
			numberField[i].setForeground(textcolor);
			numberField[i].setBackground(tf_back);
		}
	}
	
	/**
	 * Grouping function for Button initialization
	 */
	private void buttonInit() {
		// First Button : Add
		addbtn.setBackground(c_button);
		addbtn.setForeground(Color.WHITE);
		addbtn.setFont(clear_gothic);
		
		// Second Button : Remove
		rembtn.setBackground(c_button);
		rembtn.setForeground(Color.WHITE);
		rembtn.setFont(clear_gothic);
	}
	
	/**
	 * Return current values in numberField lists into ArrayList type.
	 * 
	 * @return List which has values from JTextFields.
	 */
	public ArrayList <Integer> getCurrentValues() {
		ArrayList <Integer> list = new ArrayList <Integer> (6);
		
		for(int i=0; i<numberField.length; ++i) {
			// Automatically fill as -1 if there is no valid value
			try {
				list.add(Integer.parseInt(numberField[i].getText()));
			} catch(NumberFormatException e) {
				list.add(-1);
			}
		}
		
		return list;
	}
	
	/**
	 * Load angle values to current editor, because of modification.
	 * 
	 * @param angleList
	 */
	public void setCurrentValues(ArrayList <Instruction> motion) {
		for(int i=0; i<numberField.length; ++i) {
			numberField[i].setText(Integer.toString(motion.get(i).angle));
		}
	}
	
	/**
	 * Grouping function to assign some event handler to this system.
	 */
	private void eventInit() {
		/**
		 * Button Listener for Add Button
		 */
		addbtn.addActionListener(new ActionListener() {
			/**
			 * This will extract data from this editor's JTextLabels
			 * and then add it to the OptionList.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane will return null if user press cancel button
				String motionName = JOptionPane.showInputDialog("키프레임 이름을 입력하십시오.", "키프레임 이름 입력");
				
				if(motionName != null) {
					listReference.addMotion(motionName, getCurrentValues());
					
					System.out.println("[OptionListEditor : addbtn] Log : New motion key has been added");
				} else {
					System.out.println("[OptionListEditor : addbtn] Log : Adding cancled.");
				}
				
			}
		});
		
		/**
		 * Button Listener for Remove Button
		 */
		rembtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				listReference.removeMotion();
			}
		});
	}
}