package sda.model;

public class Monster extends Enemy{
    private String description;

    public Monster(String name, int health, int damage, String description) {
        super(name, health, damage);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
