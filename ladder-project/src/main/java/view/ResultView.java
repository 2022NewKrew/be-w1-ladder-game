package view;


import java.util.Map;

public final class ResultView {

    public static void printResultAll(String input, Map<String, String> gameResult) {
        if (input.equals("all")) {
            printMap(gameResult);
        }
    }

    public static void printResult(String input, Map<String, String> gameResult) {
        if (!input.equals("all")) {
            System.out.println(gameResult.get(input));
        }
    }

    private static void printMap(Map<String, String> gameResult) {
        for (String key : gameResult.keySet()) {
            System.out.println(key + " : " + gameResult.get(key));
        }
    }
}
