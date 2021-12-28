package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final int height;
    private final int width;

    public Ladder(int people, int height) {
        this.height = height;
        width = people * 2 - 1;
    }

    private List<Character> buildRow() {
        List<Character> row = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            if (i % 2 == 0) {
                row.add('|');
            } else {
                row.add(fillLine());
            }
        }
        return row;
    }

    private Character fillLine() {
        List<Character> rndLine = Arrays.asList(' ', '-');
        return rndLine.get(new Random().nextInt(rndLine.size()));
    }

    private List<List<Character>> buildLadder() {
        List<List<Character>> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(buildRow());
        }
        return ladder;
    }

    public void printLadder() {
        List<List<Character>> ladder = buildLadder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(ladder.get(i).get(j));
            }
            System.out.println();
        }
    }
}
