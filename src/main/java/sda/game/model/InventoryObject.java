package sda.game.model;

import java.util.Objects;

public abstract class InventoryObject {
    private String name;
    private double weight;
    private int count;

    public InventoryObject(String name, double weight, int count) {
        this.name = name;
        this.weight = weight;
        this.count = count;
    }

    public InventoryObject(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.count = 1;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{"
                + name + " "
                + weight + " "
                + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryObject that = (InventoryObject) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(name, that.name);
    }
}
