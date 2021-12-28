package main.java;

import java.util.ArrayList;

public class ResultView {
    private ResultView() {
    }
    public static void printLadder(ArrayList<ArrayList<String>> ladder) {
        System.out.println();
        ladder.forEach(ResultView::printLine);
    }
    private static void printLine(ArrayList<String> line) {
        line.forEach(System.out::print);
        System.out.println();
    }
}
