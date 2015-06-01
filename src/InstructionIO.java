import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * This class can save & load instruction list.
 * InstructionIO also store instruction list.
 * 
 * File Format:
 * [Sequence Length]
 * [Sequence 0 Length] [Instruction 0] [Instruction 1] ...
 * [Sequence 1 Length] [Instruction 0] [Instruction 1] ...
 * ...
 * 
 * @author Se-Kyu-Kwon
 */
@SuppressWarnings("serial")
public class InstructionIO extends ArrayList <ArrayList <Instruction>> {
	/**
	 * Much easier method to add multiple things
	 * Null elements would be considered as new Instruction(0, 0, -1)
	 * 
	 * @param iList
	 */
	public void add(Instruction ... iList) {
		if(iList.length > 0) {
			ArrayList <Instruction> temp = new ArrayList <Instruction> (iList.length);
		
			for(Instruction i : iList) {
				// Null Check
				if(i != null)
				{
					temp.add(i);
				}
				else
				{
					temp.add(new Instruction(Instruction.NO_CHANGE));
				}
			}
		
			add(temp);
		}
	}
	
	/**
	 * Save current InstructionIO sequence.
	 * Null filename will terminate saving sequence.
	 * 
	 * @param filename
	 */
	public void save(String filename) {
		// Check null filename or empty filename
		if(filename == null || filename.equals("")) {
			System.out.println("[InstructionIO : save] Null filename Argument. User might canceled to save it");
			
			return;
		}
		
		// Save file
		try {
			// Initialize File
			PrintStream oStream = new PrintStream(filename);
			
			// Print Total Sequence Length
			oStream.println(size());
			
			// Iterate every sequence
			for(ArrayList <Instruction> iList : this) {
				oStream.print(iList.size());
				
				for(Instruction ins : iList) {
					oStream.print(" "+ins.angle);
				}
				
				oStream.println();
			}
			
			// Close File
			oStream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load File! Null filename will terminate loading sequence.
	 * 
	 * @param filename
	 */
	public void load(String filename) {
		// Check null filename or empty filename
		if(filename == null || filename.equals("")) {
			System.out.println("[InstructionIO : load] Null filename Argument. User might canceled to load it");
			
			return;
		}
		
		// Try loading
		try {
			// Open File
			Scanner iStream = new Scanner(new FileInputStream(filename));
			
			// Initialize this list
			clear();
			int sequenceSize = iStream.nextInt();
			
			// Read each line
			ArrayList <Instruction> tempLine;
			for(int i=0; i<sequenceSize; ++i) {
				// Initialize line list
				tempLine = new ArrayList <Instruction> (6);
				
				// Read Line Size
				int iSize = iStream.nextInt();
				
				// Iterate
				for(int j=0; j<iSize; ++j) {
					tempLine.add(new Instruction(0, 0, iStream.nextInt()));
				}
				
				add(tempLine);
			}
			
			// Close File
			iStream.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("[InstructionIO : load] There is no such file : " + filename);
		}
		catch(IllegalArgumentException e) {
			System.out.println("[InstructionIO : load] The file is corrupted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * For Debugging Purpose.
	 * Print out it's contents.
	 */
	public void print() {
		for(ArrayList <Instruction> iList : this) {
			for(Instruction i : iList) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
