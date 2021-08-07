package sda;

import java.util.Objects;

public class Spell implements Comparable{
    private String name;
    private int modHealthPoints;
    private int modDamagePoints;
    private int modDamageResistancePoints;

    public Spell(String name, int modHealthPoints, int modDamagePoints, int modDamageResistancePoints) {
        this.name = name;
        this.modHealthPoints = modHealthPoints;
        this.modDamagePoints = modDamagePoints;
        this.modDamageResistancePoints = modDamageResistancePoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return modHealthPoints == spell.modHealthPoints && modDamagePoints == spell.modDamagePoints && modDamageResistancePoints == spell.modDamageResistancePoints && Objects.equals(name, spell.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, modHealthPoints, modDamagePoints, modDamageResistancePoints);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Spell){
            return this.name.compareTo(((Spell)o).name);
        }
        return 1;
    }
}
