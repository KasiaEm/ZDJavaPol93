package sda.model;

import sda.model.enums.Race;

public class Hero implements ProneToDamage {
    private String name;
    private Race race;
    private int health;
    private int maxHealth = 100;
    private InventoryObject inventory[] = new InventoryObject[10];
    private boolean overloaded;
    private double maxWeight = 10.0;

    public Hero(String name, Race race) {
        this.name = name;
        this.race = race;
        this.health = this.maxHealth;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isOverloaded() {
        return overloaded;
    }

    public InventoryObject[] getInventory() {
        return inventory;
    }

    public void showInventory() {
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("[" + i + "]" + (inventory[i] != null ? inventory[i] : "empty"));
        }
    }

    public void addToInventory(InventoryObject toAdd) {
        boolean added = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(toAdd)) {
                inventory[i].setCount(inventory[i].getCount() + toAdd.getCount());
                added = true;
                break;
            }
        }
        if (!added) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = toAdd;
                    added = true;
                    break;
                }
            }
        }
        if (added) {
            countOverload();
        } else {
            System.out.println("Inventory full. Object cannot be added.");
        }
    }

    @Override
    public void receiveDamage(int healthPoints) {
        this.health -= healthPoints;
        if (this.health > 0) {
            System.out.println("Your health: " + this.health);
        } else {
            System.out.println("You are dead.");
        }
    }

    public void eat(int slot) {
        if (slot >= 0 && slot < this.inventory.length) {
            InventoryObject obj = this.inventory[slot];
            if (obj != null && obj instanceof Food) {
                int healthPoints = ((Food) obj).getHealthPointsRegeneration();
                this.health += healthPoints;
                if (this.health > this.maxHealth)
                    this.health = this.maxHealth;
                System.out.println("Your health: " + this.health);
                if (obj.getCount() == 1) {
                    this.inventory[slot] = null;
                } else {
                    obj.setCount(obj.getCount() - 1);
                }
            } else {
                System.out.println("This is not food.");
            }
        }
    }

    private void countOverload() {
        double sum = 0.0;

        for (InventoryObject obj : inventory) {
            if (obj != null) {
                sum += obj.getCount() * obj.getWeight();
            }
        }
        this.overloaded = sum > maxWeight;
    }
}
