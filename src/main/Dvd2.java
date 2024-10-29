package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Dvd2 {
    private int x, y, xSpeed, ySpeed;
    private Color color;
    private BufferedImage img;
    private BufferedImage coloredImg;
    private static final Random random = new Random();

    public Dvd2(int x, int y, int height, int width, int xSpeed, int ySpeed, Color color) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = color;

        loadImage("./src/logo/dvd-logo.png");
        coloredImg = createColoredImage(img, width, height, color);
    }

    private void loadImage(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage createColoredImage(BufferedImage original, int width, int height, Color color) {
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(original, 0, 0, width, height, null);

        // Apply color overlay
        g2d.setComposite(AlphaComposite.SrcIn);
        g2d.setColor(color);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();

        return resized;
    }

    public void setRandomColor() {
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        coloredImg = createColoredImage(img, coloredImg.getWidth(), coloredImg.getHeight(), color);
    }

    public void draw(Graphics g) {
        if (coloredImg != null) {
            g.drawImage(coloredImg, x, y, null);
        }
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public void bounceOffVertical() {
        ySpeed = -ySpeed;
    }

    public void bounceOffHorizontal() {
        xSpeed = -xSpeed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, coloredImg.getWidth(), coloredImg.getHeight());
    }
}
