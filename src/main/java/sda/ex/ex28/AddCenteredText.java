package sda.ex.ex28;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AddCenteredText implements Operation{
    private String text;
    private Color color;
    private Font font;

    public AddCenteredText(String text, Color color, Font font) {
        this.text = text;
        this.color = color;
        this.font = font;
    }

    @Override
    public void execute(BufferedImage image) {
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        int stringWidth = fontMetrics.stringWidth(text);
        g.drawString(text, image.getWidth()/2-stringWidth/2, image.getHeight()/2);
        g.dispose();
    }

    @Override
    public String toString() {
        return "AddCenteredText{" +
                "text='" + text + '\'' +
                ", color=" + color +
                ", font=" + font +
                '}';
    }
}
