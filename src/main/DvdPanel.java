package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DvdPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Dvd dvd;
	private Timer timer;
	
	public DvdPanel(Dvd d, Color backgroundColor) {
		this.dvd = d;
		
		setPreferredSize(new Dimension(1423, 800));
		setBackground(backgroundColor);

		this.timer = new Timer(10, this);
		this.timer.start();	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.dvd.draw(g);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dvd.move();
		this.checkBounds();
		this.repaint();
		
	}
	public void checkBounds() {
		Rectangle dvdBounds = this.dvd.getBounds();
		if(dvdBounds.getMinX() < 0 || dvdBounds.getMaxX() > this.getWidth()) {
			this.dvd.bounceOffHorizontal();
			this.dvd.setRandomColor();
		}
		if (dvdBounds.getMinY() < 0 || dvdBounds.getMaxY() > this.getHeight()) {
			this.dvd.bounceOffVertical();
			this.dvd.setRandomColor();
		}
	}
	
}
