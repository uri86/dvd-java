package main;

import javax.swing.*;

public class Screen {
	public static void createAndShowGUI(DvdPanel panel) {
		// Create the frame (the window)
		JFrame frame = new JFrame("DVD Player Screen Saver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set the size of the window
		frame.setSize(1423, 800);
		// Add Panel to Frame
		frame.add(panel);
		// Center the window on the screen
		frame.setLocationRelativeTo(null);
		// Make the window visible
		frame.setVisible(true);
	}
}
