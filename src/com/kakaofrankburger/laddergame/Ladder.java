package com.kakaofrankburger.laddergame;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ladder {
    private static final Random random = new Random();
    private final int width, height;
    private List<String> stateAsListOfString;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void generateSimpleRandom() {
        stateAsListOfString = new ArrayList<>();
        for (int lineNo = 0; lineNo < height; lineNo++) {
            stateAsListOfString.add(Stream.generate(() -> random.nextBoolean() ? "-" : " ").limit(width - 1).collect(Collectors.joining("|", "|", "|")));
        }
    }

    public String toPrettyString() {
        return String.join(System.lineSeparator(), stateAsListOfString);
    }

    @Override
    public String toString() {
        return getClass().getName() + "("
                + "width=" + width + ", "
                + "height=" + height + ")";
    }
}
