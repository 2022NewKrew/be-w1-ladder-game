package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderController {
    private static final String DOWN = "| ";
    private static final String RIGHT = "|-";
    private static final Random random = new Random();

    public static void main(String[] args) {
        ResultView.printLadder(generateLadder(InputView.enterPlayers(), InputView.enterHeight()));
    }

    private static List<List<String>> generateLadder(int playerNum, int height) {
        List<List<String>> ladder = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            ladder.add(generateLine(playerNum));
        }
        return ladder;
    }

    private static List<String> generateLine(int playerNum) {
        List<String> line = new ArrayList<>();
        for(int i = 1; i < playerNum; i++) {
            line.add(generatePoint());
        }
        line.add(DOWN);
        return line;
    }

    private static String generatePoint() {
        return random.nextBoolean() ? RIGHT : DOWN;
    }
}
