package sda.model;

import sda.model.enums.BodyPart;

public class Armor {
    private ArmorPart head;
    private ArmorPart torso;
    private ArmorPart leftHand;
    private ArmorPart rightHand;
    private ArmorPart leftLeg;
    private ArmorPart rightLeg;

    public ArmorPart getHead() {
        return head;
    }

    public void setHead(ArmorPart head) {
        this.head = head;
    }

    public ArmorPart getTorso() {
        return torso;
    }

    public void setTorso(ArmorPart torso) {
        this.torso = torso;
    }

    public ArmorPart getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(ArmorPart leftHand) {
        this.leftHand = leftHand;
    }

    public ArmorPart getRightHand() {
        return rightHand;
    }

    public void setRightHand(ArmorPart rightHand) {
        this.rightHand = rightHand;
    }

    public ArmorPart getLeftLeg() {
        return leftLeg;
    }

    public void setLeftLeg(ArmorPart leftLeg) {
        this.leftLeg = leftLeg;
    }

    public ArmorPart getRightLeg() {
        return rightLeg;
    }

    public void setRightLeg(ArmorPart rightLeg) {
        this.rightLeg = rightLeg;
    }

    public ArmorPart assignPart(ArmorPart part) {
        ArmorPart toReturn = null;

        if (part.getBodyPart().equals(BodyPart.HEAD)) {
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
        }

        return toReturn;
    }

    public int countSumDamageResistance() {
        return ((head != null) ? head.getDamagePoints() : 0)
                + ((torso != null) ? torso.getDamagePoints() : 0)
                + ((leftHand != null) ? leftHand.getDamagePoints() : 0)
                + ((rightHand != null) ? rightHand.getDamagePoints() : 0)
                + ((leftLeg != null) ? leftLeg.getDamagePoints() : 0)
                + ((rightLeg != null) ? rightLeg.getDamagePoints() : 0);
    }
}
