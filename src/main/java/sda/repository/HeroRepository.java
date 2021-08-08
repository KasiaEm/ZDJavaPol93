package sda.repository;

import sda.Spell;
import sda.exceptions.InvalidTypeException;
import sda.exceptions.NoEmptySlotException;
import sda.model.ArmorPart;
import sda.model.Food;
import sda.model.Weapon;
import sda.model.characters.Hero;
import sda.model.characters.Sorcerer;
import sda.model.characters.Warrior;
import sda.model.enums.BodyPart;
import sda.model.enums.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroRepository {
    private Map<String, Hero> heroes = new HashMap<>();

    public HeroRepository() {
        loadData();
    }

    private void loadData() {
        try {
            Hero hero = new Hero("Bazyl", Race.HUMAN);
            hero.addToInventory(new Food("Apple", 0.1, 1, 30));
            hero.addToInventory(new Food("Banana", 0.2, 1, 32));
            heroes.put("STANDARDOWY_BAZYL", hero);

            Warrior warrior = new Warrior("Harry", Race.GHOUL);
            warrior.addToInventory(new Food("Apple", 0.1, 1, 30));
            warrior.addToInventory(new Food("Blood", 0.5, 2, 50));
            warrior.addToInventory(new Weapon("Shotgun", 5, 1, 45));
            warrior.assignWeapon(2);
            warrior.addToInventory(new ArmorPart("Chest Piece", 5, 1, 40, BodyPart.TORSO));
            warrior.assignArmorPart(2);
            heroes.put("DZIKI_HARRY", warrior);

            Sorcerer sorcerer = new Sorcerer("Andrzej", Race.DEMON, 50);
            sorcerer.addSpell(new Spell("Twardy jak skała", 10, 1, 10));
            heroes.put("MROCZNY_ANDRZEJ", sorcerer);

        } catch (NoEmptySlotException | InvalidTypeException e) {
            System.out.println("Could not load repository.");
        }
    }

    public Map<String, Hero> getHeroes() {
        return heroes;
    }

    private List<Hero> filterByName(String txt) {
        return heroes.values().stream()
                .filter(h -> h.getName().startsWith(txt))
                .collect(Collectors.toList());
    }

    private List<Hero> filterByRace(Race race) {
        return heroes.values().stream()
                .filter(h -> h.getRace().equals(race))
                .collect(Collectors.toList());
    }

    
}
