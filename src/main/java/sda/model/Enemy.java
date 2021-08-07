package sda.model;

public abstract class Enemy implements ProneToDamage{
    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void receiveDamage(int healthPoints) {
        this.health -= healthPoints;
    }
}
