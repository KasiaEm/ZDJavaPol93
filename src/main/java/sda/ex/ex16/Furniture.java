package sda.ex.ex16;

public abstract class Furniture implements Measurable {
    private final double price;

    protected Furniture(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
