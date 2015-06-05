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
	private JLabel       title     = new JLabel("<ROBOT 1>");
	private JButton      addbtn    = new JButton("추가");
	private JButton      rembtn    = new JButton("제거");
	
	/**
	 * Create an OptionListEditor.
	 * 
	 * Invariant : You must link listReference.
	 * Otherwise NullPointerException will be occurred.
	 */
	public OptionListEditor (OptionList listReference) {
		// Assign Link
		if(listReference == null)
		{
			throw new NullPointerException("[OptionListEditor : Constructor] Null reference is not allowed");
		}
		this.listReference = listReference;
		
		// Define this panel's layout style.
		setLayout(new GridLayout(4, 4, 5, 5));
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
		add(new JLabel());
		add(new JLabel());
		
		// Assign Label & Number Fields
		for(int i=0; i<numberField.length; ++i)
		{
			// Add PtName First
			add(ptNameField[i]);
			
			// Then add 
			add(numberField[i]);
		}
		
		// Add Buttons
		add(addbtn);
		add(rembtn);
		
		// Initialize Event
		eventInit();
	}
	
	/**
	 * Grouping function for title initialization
	 */
	public void titleInit()
	{
		title.setForeground(textcolor);
	}

	/**
	 * Grouping function for Part Name Labels initialization
	 */
	private void ptNameFieldInit()
	{
		// Construct the ptNameFields
		ptNameField = new JLabel[6];
				
		ptNameField[BODY]      = new JLabel("Body : ");
		ptNameField[ARM_LEFT]  = new JLabel("Left Arm : ");
		ptNameField[ARM_RIGHT] = new JLabel("Rigth Arm : ");
		ptNameField[HEAD]      = new JLabel("Head : ");
		ptNameField[LEG_LEFT]  = new JLabel("Left Leg: ");
		ptNameField[LEG_RIGHT] = new JLabel("Right Leg : ");
				
		// Set the style & design of ptNameField
		for(int i=0; i<ptNameField.length; ++i)
		{
			ptNameField[i].setForeground(textcolor);
		}
	}
	
	/**
	 * Grouping function for Number Fields initialization
	 */
	private void numberFieldInit()
	{
		// Construct the numberFields
		numberField = new JTextField[6];
		for(int i=0; i<numberField.length; ++i)
		{
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
	private void buttonInit()
	{
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
	public ArrayList <Integer> getCurrentValues()
	{
		ArrayList <Integer> list = new ArrayList <Integer> (6);
		
		for(int i=0; i<numberField.length; ++i)
		{
			list.add(Integer.parseInt(numberField[i].getText()));
		}
		
		return list;
	}
	
	/**
	 * Load angle values to current editor, because of modification.
	 * 
	 * @param angleList
	 */
	public void setCurrentValues(ArrayList <Integer> angleList)
	{
		for(int i=0; i<numberField.length; ++i)
		{
			numberField[i].setText(Integer.toString(angleList.get(i)));
		}
	}
	
	/**
	 * Grouping function to assign some event handler to this system.
	 */
	private void eventInit()
	{
		/**
		 * Button Listener for Add Button
		 */
		addbtn.addActionListener(new ActionListener()
		{
			/**
			 * This will extract data from this editor's JTextLabels
			 * and then add it to the OptionList.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				String motionName = JOptionPane.showInputDialog("키프레임 이름을 입력하십시오.", "키프레임 이름 입력");
				listReference.addMotion(motionName, getCurrentValues());
				
				// Debug
				System.out.println("[OptionListEditor : addbtn] New motion key has been added");
			}
		});
		
		/**
		 * Button Listener for Remove Button
		 */
		rembtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				if(i_size > 0)
				{
					int pos = (cur_index) * 5;
					System.out.println("pos : " + pos);
					for(int i = 0; i < 5; i++) {
						robot_1.remove(pos + 0);
					}
					System.out.println("Removed.");
					anim1.ol1.listMode_1.removeElementAt(cur_index);
				} else {
					JOptionPane.showMessageDialog(null, "제거할 키프레임이 존재하지 않습니다.", "제거 오류", JOptionPane.ERROR_MESSAGE, null);
				}
				
				//Debug
				System.out.println("---Romoved(Robot_1)---");
				for(int i = 0; i < robot_1.size(); i++) {
					System.out.println(robot_1.get(i));
				}
				System.out.println("----------------------");
				*/
				
				listReference.removeMotion();
			}
		});
	}
}