package sda;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Game {
    private static char map[][];
    private static Position heroPosition;
    private static Position finishPosition;

    public static void main(String[] args) {
        initMap();
        showMap();
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
            finishPosition = findPositionOf('F');
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error loading map: " + e.getMessage());
        }

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
}
