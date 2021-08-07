package sda.characters;

import sda.Spell;
import sda.model.enums.Race;

import java.util.Set;
import java.util.TreeSet;

public class Sorcerer extends Hero {
    private int damageResistancePoints;
    private Set<Spell> spells = new TreeSet<>();

    public Sorcerer(String name, Race race, int damageResistancePoints) {
        super(name, race);
        this.damageResistancePoints = damageResistancePoints;
    }
}
