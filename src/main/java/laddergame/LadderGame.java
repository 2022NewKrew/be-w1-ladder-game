package laddergame;

import java.util.ArrayList;
import java.util.Random;

public class LadderGame {
    private static final Random random = new Random();
    private final int numberOfGamer;
    private final int maxHeight;
    private final ArrayList<String> ladder = new ArrayList<>();

    public LadderGame(int numberOfGamer, int maxHeight) {
        this.numberOfGamer = numberOfGamer;
        this.maxHeight = maxHeight;
        makeLadder();
    }

    private void makeLadder() {
        for (int i = 0; i < maxHeight; i++) {
            ladder.add(makeLine(numberOfGamer));
        }
    }

    private static String makeLine(int numberOfGamer) {
        StringBuilder line = new StringBuilder("|");
        for (int i = 0; i < numberOfGamer - 1; i++) {
            line.append(random.nextBoolean() ? "-" : " ");
            line.append("|");
        }
        return line.toString();
    }

    public void printLadder() {
        for (String line : ladder) {
            System.out.println(line);
        }
    }
}
