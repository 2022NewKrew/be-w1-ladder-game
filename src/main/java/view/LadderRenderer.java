package view;

import DTO.OutputDTO;
import domain.LadderLine;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LadderRenderer {
    private static final Scanner scanner = new Scanner(System.in);

    private final String VERTICAL_LINE = "|";
    private final int nameLength = 5;
    private final String BAR = "-".repeat(nameLength);
    private final String BLANK = " ".repeat(nameLength);

    private final String PRINT_ALL_CODE = "all";
    private final String PRINT_TERM_CODE = "춘식이";

    private final List<String> people;
    private final HashMap<String, String> matchedResult;
    private final List<String> results;
    private final List<LadderLine> ladderLines;

    public LadderRenderer(OutputDTO outputDTO) {
        this.people = outputDTO.getPeople();
        this.matchedResult = outputDTO.getMatchedResult();
        this.results = outputDTO.getResults();
        this.ladderLines = outputDTO.getLadderLines();
    }

    public void printResult() {
        printLadder();
        printQuery();
    }

    public void printLadder() {
        System.out.println("사다리 결과");
        System.out.println();
        System.out.println(printItems(people));
        for(LadderLine ladderLine: ladderLines) {
            System.out.println(printLine(ladderLine));
        }
        System.out.println(printItems(results));
    }

    public void printQuery() {
        System.out.println("결과를 보고 싶은 사람은?");
        String query = scanner.next();
        while (!query.equals(PRINT_TERM_CODE)) {
            printQueryNotTerminated(query);
            System.out.println("결과를 보고 싶은 사람은?");
            query = scanner.next();
        }
        System.out.println();
        System.out.println("게임을 종료합니다.");
    }

    public void printQueryNotTerminated(String query) {
        if (query.equals(PRINT_ALL_CODE)) {
            printAllMatchedResult();
            return;
        }
        printSpecifiedMatchedResult(query);
    }

    public void printAllMatchedResult() {
        System.out.println();
        System.out.println("실행 결과");
        for (String person : people) {
            System.out.println(person + " : " + matchedResult.get(person));
        }
        System.out.println();
    }

    public void printSpecifiedMatchedResult(String query) {
        if (matchedResult.containsKey(query)) {
            System.out.println(matchedResult.get(query));
            System.out.println();
            return;
        }
        nameNotFound(query);
    }

    public void nameNotFound(String query) {
        System.out.println(query + "는 없는 이름입니다. 다시 입력해주세요.");
        System.out.println();
    }

    private String printItems(List<String> items) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item: items) {
            stringBuilder.append(printItem(item)).append(" ");
        }
        return stringBuilder.toString();
    }

    private String printItem(String item) {
        int nameLength = item.length();
        if (nameLength >= 5) {
            return item.substring(0,5);
        }
        return " ".repeat((6-nameLength)/2) + item + " ".repeat((5-nameLength)/2);
    }

    public String printLine(LadderLine ladderLine) {
        StringBuilder stringBuilder = new StringBuilder("  ");
        List<Boolean> points = ladderLine.getPoints();
        stringBuilder.append(VERTICAL_LINE);
        for (int i = 0 ; i < people.size() - 1 ; i++) {
            stringBuilder.append(printBarOrBlank(points.get(i)));
            stringBuilder.append(VERTICAL_LINE);
        }
        return stringBuilder.toString();
    }

    private String printBarOrBlank(Boolean point) {
        if (point) {
            return BAR;
        }
        return BLANK;
    }
}
