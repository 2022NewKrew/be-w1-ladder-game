package be.w1.ladder_game.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final Random random = new Random();

    private final int width;
    private final int height;

    private final List<List<Boolean>> ladder = new ArrayList<>();

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;

        for (int i = 0; i < height; ++i) {
            Boolean[] boolList = new Boolean[width];
            Arrays.fill(boolList, false);

            ladder.add(Arrays.asList(boolList));
        }

        createLadder();
    }

    public List<List<Boolean>> getLadderArray() {
        return this.ladder;
    }

    private void createLadder() {
        for (int row = 0; row < height; ++row) {
            createBridgeByRow(row);
        }
    }

    private void createBridgeByRow(int row) {
        for (int bridgeIndex = 0; bridgeIndex < width; ++bridgeIndex) {
            if (bridgeIndex > 0 && ladder.get(row).get(bridgeIndex - 1)) {
                continue;
            }
            ladder.get(row).set(bridgeIndex, random.nextBoolean());
        }
    }
}

