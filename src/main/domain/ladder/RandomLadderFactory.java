package main.domain.ladder;

import main.domain.line.Line;

import java.util.Random;

public class RandomLadderFactory implements LadderFactory {

    private static final Random random = new Random();

    @Override
    public Ladder createLadder(String[] players, int height) {
        return makeRandomLadder(players, height);
    }

    private Ladder makeRandomLadder(String[] players, int height) {
        Ladder ladder = new Ladder(players, height);

        for (int i = 0; i < ladder.getWidth() - 1; i++) {
            connectLine(ladder.getLine(i), ladder.getLine(i + 1));
        }

        return ladder;
    }

    private void connectLine(Line prevLine, Line nextLine) {
        for (int i = 0; i < prevLine.getHeight(); i++) {
            connect(prevLine, nextLine, i);
        }
    }

    private void connect(Line prevLine, Line nextLine, int position) {
        if (random.nextBoolean()) {
            prevLine.connect(nextLine, position);
        }
    }
}
