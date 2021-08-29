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
}
