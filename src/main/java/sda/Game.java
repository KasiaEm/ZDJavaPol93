package sda;

import sda.model.characters.Hero;
import sda.model.enums.Race;

public class Game {
    public static void main(String[] args) {
        Hero h = new Hero("Andrzej", Race.DEMON);
        h.showInventory();
    }
}
