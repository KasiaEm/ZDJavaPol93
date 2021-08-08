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
        /*return ((head != null) ? head.getDamagePoints() : 0)
                + ((torso != null) ? torso.getDamagePoints() : 0)
                + ((leftHand != null) ? leftHand.getDamagePoints() : 0)
                + ((rightHand != null) ? rightHand.getDamagePoints() : 0)
                + ((leftLeg != null) ? leftLeg.getDamagePoints() : 0)
                + ((rightLeg != null) ? rightLeg.getDamagePoints() : 0);*/
        return 0;
    }
}
