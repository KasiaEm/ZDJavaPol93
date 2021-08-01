package sda.model;

import sda.model.enums.Race;

public class Warrior extends Hero {
    private Weapon weapon;
    private Armor armor;

    public Warrior(String name, Race race) {
        super(name, race);
    }

    public void assignWeapon(int slot) {
        if (slot >= 0 && slot < super.getInventory().length) {
            InventoryObject obj = super.getInventory()[slot];
            if (obj != null && obj instanceof Weapon) {
                Weapon toReturn = this.weapon;
                this.weapon = (Weapon) obj;

                if (toReturn != null) {
                    addToInventory(toReturn);
                }
            } else {
                System.out.println("This is not a weapon.");
            }
        }
    }
}
