package sda.game.model;

import sda.game.model.enums.BodyPart;

public class ArmorPart extends InventoryObject{
    private int damagePoints;
    private BodyPart bodyPart;

    public ArmorPart(String name, double weight, int count, int damagePoints, BodyPart bodyPart) {
        super(name, weight, count);
        this.damagePoints = damagePoints;
        this.bodyPart = bodyPart;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }
}
