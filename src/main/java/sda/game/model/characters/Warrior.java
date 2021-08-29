package sda.game.model.characters;

import sda.game.exceptions.GameOverException;
import sda.game.exceptions.InvalidTypeException;
import sda.game.exceptions.NoEmptySlotException;
import sda.game.model.Armor;
import sda.game.model.ArmorPart;
import sda.game.model.InventoryObject;
import sda.game.model.Weapon;
import sda.game.model.enums.Race;

public class Warrior extends Hero {
    private Weapon weapon;
    private Armor armor = new Armor();

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
