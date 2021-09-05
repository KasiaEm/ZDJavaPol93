package sda.ex.ex28;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawFrame implements Operation {
    private Color color;
    private int width;

    public DrawFrame(Color color, int width) {
        this.color = color;
        this.width = width;
    }

    @Override
    public void execute(BufferedImage image) {
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.setStroke(new BasicStroke(width));
        g.drawRect(width/2, width/2, image.getWidth()-width, image.getHeight()-width);
        g.dispose();
        System.out.println("Performing operation: " + this);
    }

    @Override
    public String toString() {
        return "DrawFrame{" +
                "color=" + color +
                ", width=" + width +
                '}';
    }
}
