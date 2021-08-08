package sda.model.characters;

import sda.exceptions.GameOverException;
import sda.exceptions.InvalidTypeException;
import sda.exceptions.NoEmptySlotException;
import sda.model.Armor;
import sda.model.ArmorPart;
import sda.model.InventoryObject;
import sda.model.Weapon;
import sda.model.enums.Race;

public class Warrior extends Hero {
    private Weapon weapon;
    private Armor armor;

    public Warrior(String name, Race race) {
        super(name, race);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void assignWeapon(int slot) throws InvalidTypeException, NoEmptySlotException {
        if (slot >= 0 && slot < super.getInventory().length) {
            InventoryObject obj = super.getInventory()[slot];
            if (obj != null && obj instanceof Weapon) {
                Weapon toReturn = this.weapon;
                this.weapon = (Weapon) obj;

                if (toReturn != null) {
                    addToInventory(toReturn);
                }
            } else {
                throw new InvalidTypeException("This is not a weapon.");
            }
        }
    }

    public void assignArmorPart(int slot) throws InvalidTypeException, NoEmptySlotException {
        if (slot >= 0 && slot < super.getInventory().length) {
            InventoryObject obj = super.getInventory()[slot];
            if (obj != null && obj instanceof ArmorPart) {
                ArmorPart toReturn = this.armor.assignPart((ArmorPart) obj);

                if (toReturn != null) {
                    addToInventory(toReturn);
                }
            } else {
                throw new InvalidTypeException("This is not an armor part.");
            }
        }
    }

    @Override
    public void receiveDamage(int healthPoints) throws GameOverException {
        int sumDamageResistance = armor.countSumDamageResistance();
        if (sumDamageResistance < healthPoints)
            super.receiveDamage(healthPoints - sumDamageResistance);
    }
}