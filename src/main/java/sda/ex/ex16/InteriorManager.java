package sda.ex.ex16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InteriorManager {
    private List<Measurable> resources = new LinkedList<>();

    public void addRoomWithFurniture(RectangularRoom room, Furniture... furnitures) throws ExceededRoomAreaException {
        double sumArea = 0.0;
        for (Furniture f : furnitures) {
            sumArea += f.area();
        }

        if (sumArea <= room.area()) {
            room.setFurnitures(new ArrayList<>(Arrays.asList(furnitures)));
            resources.add(room);

            double sumPrice = 0.0;
            for (Furniture f : furnitures) {
                sumPrice += f.getPrice();
            }
            /*double sumPrice = Stream.of(furnitures)
                    .map(Furniture::getPrice)
                    .reduce(0.0, Double::sum);*/
            System.out.println("Sum price: " + sumPrice);
        } else {
            throw new ExceededRoomAreaException("Furniture area exceedes room area.");
        }
    }

    public double countRoomsTotalArea() {
        /*double sumArea = 0.0;
        for (Measurable m : resources) {
            if (m instanceof RectangularRoom) {
                sumArea += m.area();
            }
        }*/

        double sumArea = resources.stream()
                .filter(m -> m instanceof RectangularRoom)
                .map(Measurable::area)
                .reduce(0.0, Double::sum);

        return sumArea;
    }
}
