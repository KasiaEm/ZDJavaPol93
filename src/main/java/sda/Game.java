package sda;

import sda.exceptions.GameOverException;
import sda.exceptions.NoEmptySlotException;
import sda.mode.FightMode;
import sda.model.Food;
import sda.model.characters.Enemy;
import sda.model.characters.Hero;
import sda.model.characters.Monster;
import sda.repository.HeroRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static char map[][];
    private static Position heroPosition;
    private static Position finishPosition;
    private static char under = '_';
    private static Hero hero;
    private static int kills = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //---init
        initMap();
        showHelp();
        showMap();

        //---game
        while (!heroPosition.equals(finishPosition)) {
            try {
                String input = scanner.nextLine();
                switch (input) {
                    case "w":
                    case "s":
                    case "a":
                    case "d":
                        move(input);
                        break;
                    default:
                        System.out.println("Unknown command.");
                }

                switch (under) {
                    case '~':
                        hero.receiveDamage(1);
                        break;
                    case '.':
                        hero.receiveDamage(5);
                        break;
                    case '?':
                        hero.addToInventory(new Food("Apple", 0.1, 1, 30));
                        break;
                    case 'E':
                        FightMode fightMode = new FightMode(hero, giveMeDefaultEnemy());
                        fightMode.fight();
                        kills++;
                        under = '_';
                        break;
                }

                showMap();
            } catch (GameOverException e) {
                System.out.println("Game over.");
            } catch (NoEmptySlotException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void move(String input) {
        Position newPos = null;
        switch (input) {
            case "w":
                newPos = new Position(heroPosition.getX() - 1, heroPosition.getY());
                break;
            case "d":
                newPos = new Position(heroPosition.getX(), heroPosition.getY() + 1);
                break;
            case "a":
                newPos = new Position(heroPosition.getX(), heroPosition.getY() - 1);
                break;
            case "s":
                newPos = new Position(heroPosition.getX() + 1, heroPosition.getY());
                break;
        }
        if (newPos != null && newPos.getX() >= 0 && newPos.getX() < 10 && newPos.getY() >= 0 && newPos.getY() < 30) {
            map[heroPosition.getX()][heroPosition.getY()] = under;
            under = map[newPos.getX()][newPos.getY()];
            map[newPos.getX()][newPos.getY()] = 'H';
            heroPosition = newPos;
        } else {
            System.out.println("End of map.");
        }
    }

    private static void showMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void initMap() {
        map = new char[10][];
        try {
            List<String> lines = Files.readAllLines(
                    Path.of(
                            Game.class
                                    .getClassLoader()
                                    .getResource("map.txt")
                                    .toURI()
                    ));

            int i = 0;
            for (String line : lines) {
                map[i++] = line.toCharArray();
            }
            heroPosition = findPositionOf('H');
            System.out.println("Hero position: " + heroPosition);
            finishPosition = findPositionOf('F');
            System.out.println("Finish position: " + finishPosition);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error loading map: " + e.getMessage());
        }
        HeroRepository repository = new HeroRepository();
        repository.getHeroes().keySet()
                .forEach(System.out::println);
        System.out.println("Choose your character");
        hero = repository.getHeroes().get(scanner.nextLine());
    }

    private static Position findPositionOf(char c) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == c) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    private static void showHelp() {
        System.out.println("Use wasd to move.");
        System.out.println("Use \'help\' to print help.");
        System.out.println("Use \'inventory\' to show inventory.");
        System.out.println("Use \'weapon\' to assign weapon.");
        System.out.println("Use \'eat\' to eat.");
    }

    private static Enemy giveMeDefaultEnemy() {
        return new Monster("Bear", 150, 40, "Horryfying bear.");
    }
}
