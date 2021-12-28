public class LadderGame {
    public static final char VERTICAL_LINE = '|';
    public static final char HORIZONTAL_LINE = '-';
    public static final char EMPTY_SPACE = ' ';

    private final int numberOfPeople;
    private final int height;
    private boolean[][] isHorizontalLines;

    public LadderGame(int numberOfPeople, int height) {
        this.numberOfPeople = numberOfPeople;
        this.height = height;
        setCells();
    }

    /**
     * 사다리 상태를 세팅한다.
     */
    private void setCells() {
        this.isHorizontalLines = new boolean[height][numberOfPeople - 1];
        for (int i = 0; i < this.isHorizontalLines.length; i++) {
            for (int j = 0; j < this.isHorizontalLines[i].length; j++) {
                this.isHorizontalLines[i][j] = generateRandomBoolean();
            }
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
     * 사다리 상태를 반환한다.
     */
    public String getLadderStatus() {
        StringBuilder gameStatus = new StringBuilder();
        for (boolean[] isHorizontalLine : isHorizontalLines) {
            for (int j = 0; j < numberOfPeople * 2 - 1; j++) {
                gameStatus.append(j % 2 == 0 ? VERTICAL_LINE : parseHorizontalLineChar(isHorizontalLine[j / 2]));
            }
            gameStatus.append("\n");
        }
        return gameStatus.toString();
    }
}
