package sda;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Game {

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        try {
            List<String> lines = Files.readAllLines(
                    Path.of(
                            Game.class
                                    .getClassLoader()
                                    .getResource("map.txt")
                                    .toURI()
                    ));
            lines.forEach(System.out::println);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
