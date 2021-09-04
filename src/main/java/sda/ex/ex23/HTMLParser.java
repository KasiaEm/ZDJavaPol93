package sda.ex.ex23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParser {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static Pattern pTitle = Pattern.compile("<a.*artTitle.*>(.*)</a>");
    private static Pattern pDate = Pattern.compile("datetime=\"(.*)\"");
    private static Pattern pContent = Pattern.compile("<div.*artContentShort.*>(.*)</div>");

    public static void main(String[] args) {
        final List<Article> articles = parseHTMLSimple();
        articles.forEach(System.out::println);
    }

    public static List<Article> parseHTML() {
        List<Article> articles = new LinkedList<>();
        try {
            List<String> lines = Files.readAllLines(
                    Path.of(
                            HTMLParser.class
                                    .getClassLoader()
                                    .getResource("News.html")
                                    .toURI()
                    ));

            boolean isContentInProgress = false;

            Article a = new Article();

            for (String line : lines) {
                if (line.contains("<a") && line.contains("artTitle")) {
                    String title = line.substring(line.indexOf(">") + 1, line.indexOf("</a>"));
                    a.setTitle(title);
                } else if (line.contains("datetime")) {
                    int beginIndex = line.indexOf("datetime=\"") + 10;
                    String dateStr = line.substring(beginIndex, beginIndex + 16);
                    a.setDate(LocalDateTime.parse(dateStr, DTF));
                } else if (line.contains("<div") && line.contains("artContentShort")) {
                    if (line.contains("</div>")) {
                        String contentWhole = line.substring(line.indexOf(">") + 1, line.indexOf("</div>"));
                        a.setContent(contentWhole);
                        articles.add(a);
                        a = new Article();
                    } else {
                        String contentStart = line.substring(line.indexOf(">") + 1);
                        isContentInProgress = true;
                        a.setContent(contentStart);
                    }
                } else if (isContentInProgress) {
                    if (line.contains("</div>")) {
                        String contentEnd = line.trim().substring(0, line.indexOf("</div>"));
                        isContentInProgress = false;
                        a.setContent(a.getContent() + contentEnd);
                        articles.add(a);
                        a = new Article();
                    } else {
                        String contentProgress = line.trim();
                        a.setContent(a.getContent() + contentProgress);
                    }
                }
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public static List<Article> parseHTMLSimple() {
        List<Article> articles = new LinkedList<>();
        try {
            List<String> lines = Files.readAllLines(
                    Path.of(
                            HTMLParser.class
                                    .getClassLoader()
                                    .getResource("News2.html")
                                    .toURI()
                    ));

            Article a = new Article();

            for (String line : lines) {
                Matcher mTitle = pTitle.matcher(line);
                Matcher mDate = pDate.matcher(line);
                Matcher mContent = pContent.matcher(line);

                if (mTitle.find()) {
                    a.setTitle(mTitle.group(1));
                } else if (mDate.find()) {
                    a.setDate(LocalDateTime.parse(mDate.group(1), DTF));
                } else if (mContent.find()) {
                    a.setContent(mContent.group(1));
                    articles.add(a);
                    a = new Article();
                }
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return articles;
    }


}
