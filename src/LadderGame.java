import java.util.Arrays;
import java.util.stream.Collectors;

public class LadderGame {
    public static final char VERTICAL_LINE = '|';
    public static final char HORIZONTAL_LINE = '-';
    public static final char EMPTY_SPACE = ' ';

    private final int numberOfPeople;
    private final int height;
    private boolean[][] cells;

    public LadderGame(int numberOfPeople, int height) {
        this.numberOfPeople = numberOfPeople;
        this.height = height;
        setCells();
    }

    /**
     * 사다리 상태를 세팅한다.
     */
    private void setCells() {
        boolean[][] cells = new boolean[height][numberOfPeople - 1];
        for (boolean[] row : cells) {
            setRow(row);
        }
        this.cells = cells;
    }

    /**
     * 사다리 Row를 세팅한다.
     */
    private void setRow(boolean[] ladderRow) {
        for (int i = 0; i < ladderRow.length; i++) {
            ladderRow[i] = generateRandomBoolean();
        }
    }

    /**
     * 랜덤으로 true 또는 false 를 생성한다.
     */
    private boolean generateRandomBoolean() {
        return (int) (Math.random() * 2) % 2 == 0;
    }

    /**
     * 전달하는 파라미터가 true 라면 '-', false 라면 ' '(공백)을 반환한다.
     */
    private char parseHorizontalLineChar(boolean isHorizontalLine) {
        return isHorizontalLine ? HORIZONTAL_LINE : EMPTY_SPACE;
    }

    /**
     * 사다리 상태를 문자열로 반환한다.
     */
    public String getLadderStatus() {
        return Arrays.stream(cells)
                .map(this::parseLadderRowStatus)
                .collect(Collectors.joining());
    }

    /**
     * 사다리 Row 상태를 문자열로 변환한다.
     */
    private String parseLadderRowStatus(boolean[] ladderRow) {
        StringBuilder ladderLine = new StringBuilder();
        for (int i = 0; i < numberOfPeople * 2 - 1; i++) {
            ladderLine.append(i % 2 == 0 ? VERTICAL_LINE : parseHorizontalLineChar(ladderRow[i / 2]));
        }
        ladderLine.append("\n");
        return ladderLine.toString();
    }
}
