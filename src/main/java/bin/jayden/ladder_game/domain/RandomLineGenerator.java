package bin.jayden.ladder_game.domain;

import java.util.Random;

public class RandomLineGenerator implements LineGenerator {
    private static final Random random = new Random();

    @Override
    public boolean lineGenerate() {
        return random.nextBoolean();
    }
}
