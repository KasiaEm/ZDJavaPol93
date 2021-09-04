package sda.ex.ex23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class HTMLParser{

    public static void main(String[] args) {
        parseHTML();
    }

    public static List<Article> parseHTML() {
        try {
            List<String> lines = Files.readAllLines(
                    Path.of(
                            HTMLParser.class
                                    .getClassLoader()
                                    .getResource("News.html")
                                    .toURI()
                    ));

            List<Article> articles = new LinkedList<>();
            boolean isContentInProgress = false;
            
            for (String line : lines) {
                if (line.contains("<a") && line.contains("artTitle")) {
                    System.out.println(line.substring(line.indexOf(">") + 1, line.indexOf("</a>")));
                } else if (line.contains("datetime")) {
                    int beginIndex = line.indexOf("datetime=\"") + 10;
                    System.out.println(line.substring(beginIndex, beginIndex + 16));
                } else if (line.contains("<div") && line.contains("artContentShort")) {
                    if (line.contains("</div>")) {
                        System.out.println(line.substring(line.indexOf(">") + 1, line.indexOf("</div>")));
                    } else {
                        System.out.println(line.substring(line.indexOf(">") + 1));
                        isContentInProgress = true;
                    }
                } else if (isContentInProgress) {
                    if (line.contains("</div>")) {
                        System.out.println(line.trim().substring(0, line.indexOf("</div>")));
                        isContentInProgress = false;
                    } else {
                        System.out.println(line.trim());
                    }
                }
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
