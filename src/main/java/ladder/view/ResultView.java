package ladder.view;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ResultView {
    static final String SIDE_RAIL = "|";
    static final String RUNG = "-----";
    static final String SPACE = "     ";

    /**
     * 사다리의 한 줄을 출력하는 메서드
     *
     * @param line 출력할 한 줄
     */
    private static void printLine(ArrayList<Boolean> line) {
        System.out.printf("%s%s", SPACE, SIDE_RAIL);

        for (Boolean aBoolean : line) {
            System.out.printf("%s", aBoolean ? RUNG : SPACE);
            System.out.printf("%s", SIDE_RAIL);
        }
    }

    /**
     * 사다리를 출력하는 메서드
     *
     * @param lines 출력할 줄 리스트
     */
    public static void printLadder(ArrayList<Line> lines) {
        for (Line line : lines) {
            printLine(line.getLine());
            System.out.println();
        }
    }

    /**
     * 이름 사이의 공백을 출력하는 메서드
     *
     * @param beforeName 공백 이전 이름
     * @param afterName  공백 이후 이름
     */
    private static void printSpaceBetweenNames(String beforeName, String afterName) {
        int beforeNameLength = beforeName.length() == 0 ? 0 : (beforeName.length() + 1) / 2 - 1;
        int afterNameLength = afterName.length() / 2;
        int spaceCount = SPACE.length() - beforeNameLength - afterNameLength;

        Stream.generate(() -> " ")
                .limit(spaceCount)
                .forEach(System.out::print);
    }

    /**
     * 사다리타기의 맨 윗줄 이름을 출력하는 메서드
     *
     * @param names 출력할 이름 리스트
     */
    public static void printName(ArrayList<String> names) {
        printSpaceBetweenNames("", names.get(0));
        System.out.printf("%s", names.get(0));
        IntStream.range(1, names.size())
                .forEachOrdered(i -> {
                    printSpaceBetweenNames(names.get(i - 1), names.get(i));
                    System.out.printf("%s", names.get(i));
                });
        System.out.println();
    }
}
