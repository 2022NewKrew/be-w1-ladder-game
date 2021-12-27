package main.java;

import java.util.List;

public class ResultView {
    private ResultView() {
    }
    public static void printResult(List<String> lines) {
        lines
                .stream()
                .map(result -> String.format("%2s", result))
                .forEach(System.out::print);
        System.out.println();
    }
}
