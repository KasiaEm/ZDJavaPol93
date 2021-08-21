package sda;

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
        }
    }

    private static void move(String input) {
        Position newPosition = null;
        switch (input) {
            case "w":
                newPosition = new Position(heroPosition.getX() - 1, heroPosition.getY());
                break;
            case "d":
                newPosition = new Position(heroPosition.getX(), heroPosition.getY() + 1);
                break;
            case "a":
                newPosition = new Position(heroPosition.getX(), heroPosition.getY() - 1);
                break;
            case "s":
                newPosition = new Position(heroPosition.getX() + 1, heroPosition.getY());
                break;
        }
        //TODO
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
        return new Monster("Bear", 150, 30, "Horryfying bear.");
    }
}
