package ladder.view;

import ladder.domain.Ladder;

public class Output {

    private Output() {};

    public static void printPlayerList(Ladder ladder) {
        System.out.println(ladder.playerListToString());
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.lineListToString());
    }
}