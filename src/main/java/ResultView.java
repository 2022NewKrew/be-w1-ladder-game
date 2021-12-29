package main.java;

import java.util.List;

public class ResultView {
    private static final String LEFT = "-----|";
    private static final String DOWN = "     |";
    private final static String MESSAGE_RESULT = "실행결과";

    private ResultView() {
    }

    private static void print6s(String s) {
        System.out.print(String.format("%6s", s));
    }

    public static void printPlayers(List<String> players){
        System.out.println();
        System.out.println(MESSAGE_RESULT);
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
}
