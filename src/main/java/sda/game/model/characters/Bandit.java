package sda.game.model.characters;

import sda.game.model.Weapon;

public class Bandit extends Enemy{
    private Weapon weapon;

    public Bandit(String name, int health, int damage, Weapon weapon) {
        super(name, health, damage);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
