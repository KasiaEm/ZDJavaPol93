package sda.ex.ex28;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ImageEditor ie = new ImageEditor();
        ie.loadImage("myImg.jpg");
        //operacje i cofanie
        ie.perform(new DrawFrame(Color.WHITE, 30));
        ie.perform(new AddCenteredText(
                "Hello World!",
                Color.WHITE,
                new Font("Calibri Light", Font.ITALIC, 60)));
        //ie.undo();
        ie.saveImage();
    }
}
