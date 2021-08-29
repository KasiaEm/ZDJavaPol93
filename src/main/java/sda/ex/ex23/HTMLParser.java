package sda.ex.ex23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HTMLParser {
    public static void main(String[] args) {
        parseHTML();
    }

    public static void parseHTML(){
        try {
            List<String> lines = Files.readAllLines(
                    Path.of(
                            HTMLParser.class
                                    .getClassLoader()
                                    .getResource("News.html")
                                    .toURI()
                    ));

            
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
