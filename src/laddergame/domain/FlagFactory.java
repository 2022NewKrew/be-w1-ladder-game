package laddergame.domain;

public class FlagFactory {
    private FlagFactory() {
    }

    public static Flag create(Boolean previous) {
        if (previous)
            return new Flag(false);

        return new Flag(RandomFlag.getRandomFlag());
    }
}
