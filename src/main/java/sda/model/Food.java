package sda.model;

public class Food extends InventoryObject {
    private int healthPointsRegeneration;

    public Food(String name, double weight, int count, int healthPointsRegeneration) {
        super(name, weight, count);
        this.healthPointsRegeneration = healthPointsRegeneration;
    }

    public int getHealthPointsRegeneration() {
        return healthPointsRegeneration;
    }
}
