package main.java.view;

import main.java.domain.Ladder;
import main.java.domain.Line;
import main.java.domain.Point;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String LEFT = "-----|";
    private static final String DOWN = "     |";
    private static final String MESSAGE_EXECUTION_RESULT = "실행 결과";
    private static final String MESSAGE_LADDER_RESULT = "사다리 결과";
    private final static int singleSize = 1;
    private final static int firstIndex = 0;

    private ResultView() {
    }

    private static void print6s(String s) {
        System.out.print(String.format("%6s", s));
    }

    public static void printPlayers(List<String> players){
        System.out.println();
        System.out.println(MESSAGE_LADDER_RESULT);
        System.out.println();
        players.forEach(ResultView::print6s);
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        System.out.println();
        ladder.lines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        line.points()
                .forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(Point point) {
        if(point == Point.LEFT) {
            print6s(LEFT);
            return;
        }
        print6s(DOWN);
    }

    public static void printResult(List<String> executionResults) {
        executionResults.forEach(ResultView::print6s);
        System.out.println();
    }

    public static void printExecutionResult(Map<String, String> result){
        System.out.println();
        System.out.println(MESSAGE_EXECUTION_RESULT);
        if(result.size() == singleSize){
            System.out.println(result.values().toArray()[firstIndex]);
            return;
        }
        for(String player : result.keySet()) {
            System.out.println(String.format("%s : %s", player, result.get(player)));
        }
    }
}
