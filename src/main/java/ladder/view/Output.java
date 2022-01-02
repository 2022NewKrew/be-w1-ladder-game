package ladder.view;

import ladder.domain.Ladder;

import java.util.Objects;

public class Output {

    private Output() {}
    
    public static void printTotal(Ladder ladder) {
        System.out.println("사다리 결과");
        printPlayerList(ladder);
        printLadder(ladder);
        printResult(ladder);
    }

    public static void printPlayerList(Ladder ladder) {
        System.out.println(ladder.playerListToString());
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.lineListToString());
    }
    
    public static void printResult(Ladder ladder) {
        System.out.println(ladder.resultListToString());
    }

    public static void printEndGame() {
        System.out.println("게임을 종료합니다.");
    }

    public static boolean printPlayerResult(Ladder ladder, String playerName) {
        if (Objects.equals(playerName, "춘식이")) return false;
        System.out.println("실행 결과");
        if (Objects.equals(playerName, "all")) {
            printAllPlayerResult(ladder);
            return true;
        }
        System.out.println(ladder.playerResultToString(playerName));
        return true;
    }

    private static void printAllPlayerResult(Ladder ladder) {
        for (String playerResult : ladder.allPlayerResultToString()) {
            System.out.println(playerResult);
        }
    }
}