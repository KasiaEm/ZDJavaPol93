package sda.model;

import sda.model.enums.BodyPart;

import java.util.HashMap;
import java.util.Map;

public class Armor {
    private Map<BodyPart, ArmorPart> parts = new HashMap<>();

    public ArmorPart assignPart(ArmorPart part) {
        ArmorPart toReturn = parts.get(part.getBodyPart());
        parts.put(part.getBodyPart(), part);
        return toReturn;
    }

    public int countSumDamageResistance() {
        int sum = 0;
        for (BodyPart k : parts.keySet()) {
            sum += parts.get(k).getDamagePoints();
        }
        return sum;
    }
}
