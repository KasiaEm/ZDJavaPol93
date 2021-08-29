package sda.ex.ex16;

public class SquareCabinet extends Furniture {
    private double length;

    protected SquareCabinet(double price, double length) {
        super(price);
        this.length = length;
    }


    @Override
    public Double area() {
        return length * length;
    }

    @Override
    public String show() {
        return "Square Cabinet";
    }
}
