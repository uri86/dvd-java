package main;

import java.awt.*;
import java.util.Random;

public class Dvd {
	private int x, y, height, width, xSpeed, ySpeed;
	private Color color;
	private Image img;
	private static final Random random = new Random();
	
	public Dvd(int x, int y, int height, int width, int xSpeed, int ySpeed, Color c) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.color = c;
		this.img = Toolkit.getDefaultToolkit().getImage("./src/logo/dvd-logo.png");
		
	}
	public void setRandomColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // Set the color field to a new random color
        this.setColor(new Color(red, green, blue));
    }
	public void draw(Graphics g) {
		g.drawImage(this.img, this.x, this.y, this.width, this.height, this.color, null);
	}
	public void move() {
		x += xSpeed;
		y += ySpeed;
	}
	
	public void bounceOffVertical() {
		this.ySpeed = -this.ySpeed;
	}

	public void bounceOffHorizontal() {
		this.xSpeed = -this.xSpeed;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
}
