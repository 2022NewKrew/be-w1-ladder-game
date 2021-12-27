package main.java;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final static String DOWN = "| ";
    private final static String RIGHT = "|-";

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
            line.add(getPoint());
        }
        line.add(DOWN);
        return line;
    }

    private static String getPoint() {
        Random rand = new Random();
        return rand.nextBoolean() ? RIGHT : DOWN;
    }
}
