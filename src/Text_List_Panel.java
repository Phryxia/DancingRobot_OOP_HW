import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Text_List_Panel extends JPanel {
	private String aa;
	private int index = 1;
	
	ArrayList<Integer> val_n = new ArrayList<Integer>();
	ArrayList<Integer> val_la = new ArrayList<Integer>();
	ArrayList<Integer> val_ra = new ArrayList<Integer>();
	ArrayList<Integer> val_ll = new ArrayList<Integer>();
	ArrayList<Integer> val_rl = new ArrayList<Integer>();

	List_Panel lp;
	Text_Panel tp;
	
	public Text_List_Panel (String test) {
		this.aa = test;
		setLayout(new FlowLayout());
		generate_Panel();
		
	}
	
	public void generate_Panel () {
		lp = new List_Panel();
		tp = new Text_Panel(aa);
		
		tp.add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(load_Anchors()) {
					lp.listModel.addElement("KeyFrame");
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Input. Check All Values.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		tp.delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lp.option_list.getSelectedIndex() >= 0) {
					remove_KeyFrame(lp.option_list.getSelectedIndex());
					lp.listModel.remove(lp.option_list.getSelectedIndex());
				} else {
					JOptionPane.showMessageDialog(null, "Select the KeyFrame.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(lp);
		add(tp);
	}
	
	// Method for Load Anchor Values.
	public boolean load_Anchors() {
		return tp.return_val(val_n, val_la, val_ra, val_ll, val_rl);
	}
	
	// Remove Object from ArrayList
	public void remove_KeyFrame(int index) {
		
	}
	
	public int return_value(int index) {
		return 0;
	}
}
