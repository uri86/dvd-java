package main;

import java.awt.Color;

public class Main {
	public static void main(String[] args) {
		Dvd d = new Dvd(661, 375, 50, 100, 2, 2, Color.blue);
		DvdPanel p = new DvdPanel(d, Color.BLACK);
		Screen.createAndShowGUI(p);
	}
}
