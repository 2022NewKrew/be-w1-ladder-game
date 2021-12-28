package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private static final String DOWN = "| ";
    private static final String RIGHT = "|-";
    private static final Random rand = new Random();

    public static void main(String[] args) {
        ResultView.printLadder(generateLadder(InputView.enterPlayers(), InputView.enterHeight()));
    }

    private static ArrayList<ArrayList<String>> generateLadder(int playerNum, int height) {
        ArrayList<ArrayList<String>> ladder = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            ladder.add(generateLine(playerNum));
        }
        return ladder;
    }

    private static ArrayList<String> generateLine(int playerNum) {
        ArrayList<String> line = new ArrayList<>();
        for(int i = 1; i < playerNum; i++) {
            line.add(generatePoint());
        }
        line.add(DOWN);
        return line;
    }

    private static String generatePoint() {
        return rand.nextBoolean() ? RIGHT : DOWN;
    }
}
