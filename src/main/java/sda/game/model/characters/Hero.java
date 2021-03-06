package sda.game.model.characters;

import sda.game.exceptions.GameOverException;
import sda.game.exceptions.InvalidTypeException;
import sda.game.exceptions.NoEmptySlotException;
import sda.game.model.Food;
import sda.game.model.InventoryObject;
import sda.game.model.ProneToDamage;
import sda.game.model.enums.Race;

import java.util.Objects;
import java.util.stream.Stream;

public class Hero implements ProneToDamage {
    private String name;
    private Race race;
    private int health;
    private InventoryObject inventory[] = new InventoryObject[10];
    private boolean overloaded;
    private double maxWeight = 10.0;
    private int damage;

    public Hero(String name, Race race) {
        this.name = name;
        this.race = race;
        this.health = race.getHealth();
        this.damage = 5;
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

    public boolean isOverloaded() {
        return overloaded;
    }

    public InventoryObject[] getInventory() {
        return inventory;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void showInventory() {
        Stream.of(inventory)
                .forEach(i -> System.out.println(i != null ? i : "empty"));
    }

    public void addToInventory(InventoryObject toAdd) throws NoEmptySlotException {
        if (toAdd != null) {
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
                throw new NoEmptySlotException("Inventory full. Object cannot be added.");
            }
        }
    }

    @Override
    public void receiveDamage(int healthPoints) throws GameOverException {
        this.health -= healthPoints;
        if (this.health > 0) {
            System.out.println("Your health: " + this.health);
        } else {
            throw new GameOverException("You are dead.");
        }
    }

    public void eat(int slot) throws InvalidTypeException {
        if (slot >= 0 && slot < this.inventory.length) {
            InventoryObject obj = this.inventory[slot];
            if (obj != null && obj instanceof Food) {
                int healthPoints = ((Food) obj).getHealthPointsRegeneration();
                this.health += healthPoints;
                if (this.health > this.race.getHealth())
                    this.health = this.race.getHealth();
                System.out.println("Your health: " + this.health);
                if (obj.getCount() == 1) {
                    this.inventory[slot] = null;
                } else {
                    obj.setCount(obj.getCount() - 1);
                }
            } else {
                throw new InvalidTypeException("This is not food.");
            }
        }
    }

    private void countOverload() {
        this.overloaded = Stream.of(inventory)
                .filter(Objects::nonNull)
                .map(i -> i.getCount() * i.getWeight())
                .reduce((double) 0, Double::sum)
                > maxWeight;
    }
}
