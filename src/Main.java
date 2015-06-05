import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Test for GRobotBody
		JFrame aFrame = new JFrame();
		aFrame.setSize(400, 400);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setResizable(false);
		
		//aFrame.add(new RobotDisplayer());
		RobotWindow rw = new RobotWindow(400, 400);
		aFrame.add(rw);
		
		rw.setBGM("test.mp3");
		rw.setMode(true);
		rw.startDancing();
		
		aFrame.setVisible(true);
		
		System.out.println("Ignore Minim Libraries Error : Just internal error");
	}
}