package domain;

import java.util.ArrayList;
import java.util.Random;

public class LadderRowData {
    private final ArrayList<Boolean> ladderRowData;

    public LadderRowData(ArrayList<Boolean> ladderRowData) {
        this.ladderRowData = ladderRowData;
    }

    public static LadderRowData generateByRandom(int cols) {
        if (cols == 0) {
            return new LadderRowData(new ArrayList<>());
        }
        ArrayList<Boolean> booleanList = generateNonAdjacentTrueBooleanList(cols);
        return new LadderRowData(booleanList);
    }

    private static ArrayList<Boolean> generateNonAdjacentTrueBooleanList(int cols) {
        Random random = new Random();
        ArrayList<Boolean> randomBooleanList = new ArrayList<>();
        Boolean prevBoolean = generateOneThirdRandomBoolean(random);
        randomBooleanList.add(prevBoolean);
        for (int i = 1; i < cols; ++i) {
            Boolean randomBoolean = generateRandomBoolean(prevBoolean, random);
            randomBooleanList.add(randomBoolean);
            prevBoolean = randomBoolean;
        }
        return randomBooleanList;
    }

    // To make the probability of all data equal (1/3)
    private static Boolean generateOneThirdRandomBoolean(Random random) {
        return random.nextInt(2) == 0;
    }

    private static Boolean generateRandomBoolean(Boolean prevBoolean, Random random) {
        return !prevBoolean && random.nextBoolean();
    }

    public StringBuilder toStringBuilder(int ladderLength) {
        StringBuilder ladderRowStringBuilder = new StringBuilder();
        for (Boolean ladderExist : ladderRowData) {
            ladderRowStringBuilder.append("|");
            ladderRowStringBuilder.append(getLadderString(ladderExist, ladderLength));
        }
        ladderRowStringBuilder.append("|");
        return ladderRowStringBuilder;
    }

    private String getLadderString(Boolean ladderExist, int ladderLength) {
        if (ladderExist) {
            return "-".repeat(ladderLength);
        }
        return " ".repeat(ladderLength);
    }
}
