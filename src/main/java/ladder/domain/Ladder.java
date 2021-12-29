package ladder.domain;

import java.util.Random;

public class Ladder {
    private final char[][] lines;
    private final Random random = new Random();

    public Ladder(int rowCount, int columnCount){
        lines = new char[rowCount][columnCount];
        makeLadder(rowCount, columnCount);
    }

    private void makeLadder(int rowCount, int columnCount) {
        for (int i = 0; i < rowCount; i++) {
            makeLine(lines[i], columnCount);
        }
    }

    private void makeLine(char[] line, int columnCount){
        for (int j = 0; j < columnCount; j++) {
            line[j] = (j % 2 == 0) ? '|' : makeBridge();
        }
    }

    private char makeBridge() {
        return random.nextBoolean() ? '-' : ' ';
    }

    public char[][] getLines(){
        return this.lines;
    }
}
