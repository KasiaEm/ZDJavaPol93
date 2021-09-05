package sda.ex.ex28;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawStripes implements Operation {
    private Color color;
    private int width;
    private int count;

    public DrawStripes(Color color, int width, int count) {
        this.color = color;
        this.width = width;
        this.count = count;
    }

    @Override
    public void execute(BufferedImage image) {
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.setStroke(new BasicStroke(width));

        int gap = image.getWidth() / count;

        for (int i = 0; i <= image.getWidth(); i += gap) {
            g.drawLine(i, 0, i, image.getHeight());
        }

        g.dispose();
        System.out.println("Performing operation: " + this);
    }

    @Override
    public String toString() {
        return "DrawStripes{" +
                "color=" + color +
                ", width=" + width +
                ", count=" + count +
                '}';
    }
}
