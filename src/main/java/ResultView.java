package main.java;

import java.util.List;

public class ResultView {
    private ResultView() {
    }
    public static void printLadder(List<List<String>> ladder) {
        System.out.println();
        ladder.forEach(ResultView::printLine);
    }
    private static void printLine(List<String> line) {
        line.forEach(System.out::print);
        System.out.println();
    }
}
