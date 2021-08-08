package sda.model;

import sda.model.enums.BodyPart;

import java.util.HashMap;
import java.util.Map;

public class Armor {
    private Map<BodyPart, ArmorPart> parts = new HashMap<>();

    public ArmorPart assignPart(ArmorPart part) {
        ArmorPart toReturn = null;

        /*if (part.getBodyPart().equals(BodyPart.HEAD)) {
            toReturn = this.head;
            this.head = part;
        } else if (part.getBodyPart().equals(BodyPart.TORSO)) {
            toReturn = this.torso;
            this.torso = part;
        } else if (part.getBodyPart().equals(BodyPart.LEFT_HAND)) {
            toReturn = this.leftHand;
            this.leftHand = part;
        } else if (part.getBodyPart().equals(BodyPart.RIGHT_HAND)) {
            toReturn = this.rightHand;
            this.rightHand = part;
        } else if (part.getBodyPart().equals(BodyPart.LEFT_LEG)) {
            toReturn = this.leftLeg;
            this.leftLeg = part;
        } else if (part.getBodyPart().equals(BodyPart.RIGHT_LEG)) {
            toReturn = this.rightLeg;
            this.rightLeg = part;
        }*/

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
