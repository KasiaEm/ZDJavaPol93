package sda.ex.ex16;

import java.util.LinkedList;
import java.util.List;

public class RectangularRoom implements Measurable {
    private double length;
    private double width;
    private List<Furniture> furnitures = new LinkedList<>();

    @Override
    public Double area() {
        return length * width;
    }

    @Override
    public String show() {
        return "Room";
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }


}
