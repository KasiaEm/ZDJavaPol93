package sda.ex.ex28;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class ImageEditor {
    private BufferedImage currentImage;
    private Stack<Done> imageHistory;

    public void loadImage(String filename) {
        try {
            currentImage = ImageIO.read(new File("C:\\Users\\WC94UD\\workspace\\SDA\\ZDJavaPol93\\src\\main\\resources\\" + filename));
            System.out.println("Image loaded successfully.");
            imageHistory = new Stack<>();
        } catch (IOException e) {
            System.out.println("Couldn't load image.");
            e.printStackTrace();
        }
    }

    public void saveImage(){
        try {
            ImageIO.write(currentImage, "jpg", new File("C:\\Users\\WC94UD\\workspace\\SDA\\ZDJavaPol93\\src\\main\\resources\\tmp.jpg"));
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            System.out.println("Couldn't save image.");
            e.printStackTrace();
        }
    }

    public void undo(){
        Done previous = imageHistory.pop();
        currentImage = previous.getPreviousImage();
        System.out.println("Undoing operation: " + previous.getOperation());
    }

    public void perform(Operation operation){
        //1 skopiowanie stanu obrazka
        ColorModel cm = currentImage.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = currentImage.copyData(null);
        BufferedImage copy = new BufferedImage(cm, raster,
                isAlphaPremultiplied, null);
        //2 odłożenie wszystkiego na stos
        imageHistory.push(new Done(copy, operation));
        //3 wykonanie operacji
        operation.execute(currentImage);
    }
}