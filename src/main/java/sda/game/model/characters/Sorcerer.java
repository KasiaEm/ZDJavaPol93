package sda.game.model.characters;

import sda.game.Spell;
import sda.game.exceptions.GameOverException;
import sda.game.model.enums.Race;

import java.util.Set;
import java.util.TreeSet;

public class Sorcerer extends Hero {
    private int damageResistance;
    private Set<Spell> spells = new TreeSet<>();

    public Sorcerer(String name, Race race, int damageResistance) {
        super(name, race);
        this.damageResistance = damageResistance;
        setDamage(getDamage() * 2);
    }

    @Override
    public void receiveDamage(int healthPoints) throws GameOverException {
        if (damageResistance < healthPoints)
            super.receiveDamage(healthPoints - damageResistance);
    }

    public void showSpells() {
        spells.forEach(System.out::println);
    }

    public void addSpell(Spell spell) {
        if (spells.add(spell)) {
            damageResistance += spell.getModDamageResistancePoints();
            setDamage(getDamage() + spell.getModDamagePoints());
            setHealth(getHealth() + spell.getModHealthPoints());
        } else {
            System.out.println("You already have this spell.");
        }
    }
}
