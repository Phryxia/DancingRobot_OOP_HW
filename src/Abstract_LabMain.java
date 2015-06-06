import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;

public class Abstract_LabMain {

	public static void main(String[] args) {
		// Test for GRobotBody
		JFrame aFrame = new JFrame();
		aFrame.setSize(400, 400);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setResizable(false);
		
		//aFrame.add(new RobotDisplayer());
		RobotWindow rw = new RobotWindow(400, 400);
		aFrame.add(rw);
		
		//rw.setBGM("test.mp3");
		rw.setMode(false);
		rw.startDancing();
		rw.activeRobot(0);
		
		InstructionIO motionList = rw.getMotionList(0);
		motionList.add(new Instruction(0, 0, 0), new Instruction(0, 0, 270), null, null, null, null, new Instruction(0, 0, 360-30));
		motionList.add(new Instruction(0, 0, 0), new Instruction(0, 0, 280), null, null, null, null, new Instruction(0, 0, 30));
		
		aFrame.setVisible(true);
		
		System.out.println("Ignore Minim Libraries Error : Just internal error");
	}
}