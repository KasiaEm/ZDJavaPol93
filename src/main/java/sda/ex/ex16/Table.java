package sda.ex.ex16;

public class Table extends Furniture{
    private double height;
    private double width;
    private double length;

    protected Table(double price, double height, double width, double length) {
        super(price);
        this.height = height;
        this.length = length;
        this.width = width;
    }

    @Override
    public Double area() {
        return width*length;
    }

    @Override
    public String show() {
        return "Table";
    }
}
