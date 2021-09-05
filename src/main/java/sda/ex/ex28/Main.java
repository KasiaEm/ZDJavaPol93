package sda.ex.ex28;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ImageEditor ie = new ImageEditor();
        ie.loadImage("myImg.jpg");
        //operacje i cofanie
        ie.perform(new DrawFrame(Color.MAGENTA, 30));
        //ie.undo();
        ie.saveImage();
    }
}
