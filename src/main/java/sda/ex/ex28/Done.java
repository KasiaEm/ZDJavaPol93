package sda.ex.ex28;

import java.awt.image.BufferedImage;

public class Done {
    private BufferedImage previousImage;
    private Operation operation;

    public Done(BufferedImage previousImage, Operation operation) {
        this.previousImage = previousImage;
        this.operation = operation;
    }

    public BufferedImage getPreviousImage() {
        return previousImage;
    }

    public Operation getOperation() {
        return operation;
    }
}
