package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {

    private static final Random random = new Random();

    public static Ladder buildLadder(int peopleSize, int height) {
        List<Layer> layers = new ArrayList<>();

        for (int heightCounter = 0 ; heightCounter < height ; heightCounter++) {
            layers.add(buildLayer(peopleSize));
        }

        return new Ladder(layers);
    }

    private static Layer buildLayer(int peopleSize) {
        List<Boolean> horizontalLines = new ArrayList<>();

        boolean previousHorizontalLine = false;

        for (int peopleCounter = 0; peopleCounter < peopleSize - 1 ; peopleCounter++) {
            boolean currentHorizontalLine = resolveDivergence(previousHorizontalLine, random.nextBoolean());
            horizontalLines.add(currentHorizontalLine);
            previousHorizontalLine = currentHorizontalLine;
        }

        return new Layer(horizontalLines);
    }

    private static boolean resolveDivergence(boolean previous, boolean candidate) {
        return !previous && candidate;
    }
}
