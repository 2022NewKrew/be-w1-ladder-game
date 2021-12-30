package Ladder3.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Drawer {

    private final int bridgeSize;
    private final String[] people;
    private final List<Line> ladderLines;

    public Drawer(List<Line> ladderLines, String[] people, int bridgeSize) {
        this.bridgeSize = bridgeSize;
        this.ladderLines = ladderLines;
        this.people = people;
    }

    public String drawNameRow() {
        return Arrays.asList(people).stream()
            .map(person -> getNameTag(person))
            .collect(Collectors.joining(" ", "", "\n"));
    }

    public String getNameTag(String name) {
        final int spaceCnt = bridgeSize - name.length();
        return name.length() >= bridgeSize
            ? name.substring(0, bridgeSize)
            : " ".repeat((spaceCnt + 1) / 2) + name + " ".repeat(spaceCnt / 2) ; // 중앙 정렬
    }

    public String drawLadder() {
        return ladderLines.stream()
            .map(line -> line.toString())
            .collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        // unit test
        final int SIZE = 5;
        Drawer drawer = new Drawer(new ArrayList<Line>(), new String[0], SIZE);
        System.out.println("5글자를 정확히 출력하는가" + (drawer.getNameTag("a").length() <= SIZE));
        System.out.println("5글자를 정확히 출력하는가" + (drawer.getNameTag("aA").length() <= SIZE));
        System.out.println("5글자를 정확히 출력하는가" + (drawer.getNameTag("aA1").length() <= SIZE));
        System.out.println("5글자를 정확히 출력하는가" + (drawer.getNameTag("aA1_").length() <= SIZE));
        System.out.println("5글자를 정확히 출력하는가" + (drawer.getNameTag("aA1_?").length() <= SIZE));
        System.out.println("5글자를 정확히 출력하는가" + (drawer.getNameTag("aA1_?/").length() <= SIZE));
    }
}
