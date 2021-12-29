import java.util.ArrayList;

public class Ladder {
    private final String DEFAULT_LADDER_LINE = "|";
    private final String RANDOM_LADDER_LINE = "-";
    private final String NO_LADDER_LINE = " ";

    private final int RANDOM_FLAG_THRESHOLD = 40;

    private int width;
    private int height;
    private ArrayList<StringBuilder> ladderMap;

    Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        this.ladderMap = new ArrayList<StringBuilder>();
    }

    void makeLadderMap() {
        for (int i = 0; i < height; i++)
            this.ladderMap.add(makeLadderRow());
    }

    private StringBuilder makeLadderRow() {
        StringBuilder ladderRow = new StringBuilder();
        for (int i = 0; i < width; i++)
            ladderRow.append(makeLadderLine(i));

        return ladderRow;
    }

    private String makeLadderLine(int idx) {
        Boolean isEven = idx % 2 == 0;
        if (isEven)
            return DEFAULT_LADDER_LINE;

        return getRandomLadderLine();
    }

    private String getRandomLadderLine() {
        if (getRandomFlag())
            return RANDOM_LADDER_LINE;

        return NO_LADDER_LINE;
    }

    private boolean getRandomFlag() {
        int randomValue = (int) (Math.random() * 100);
        return randomValue <= RANDOM_FLAG_THRESHOLD;
    }

    void printLadder() {
        for (int i = 0; i < height; i++)
            System.out.println(ladderMap.get(i));
    }
}