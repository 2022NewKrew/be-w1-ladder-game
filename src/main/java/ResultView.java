package main.java;

import java.util.ArrayList;

public class ResultView {
    private ResultView() {
    }
    public static void printLadder(ArrayList<ArrayList<String>> ladder) {
        System.out.println();
        ladder
                .stream()
                .forEach(ResultView::printLine);
    }
    private static void printLine(ArrayList<String> line) {
        line
                .stream()
                .forEach(System.out::print);
        System.out.println();
    }
}
