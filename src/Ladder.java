public class Ladder {
    private int person;
    private final int height;
    private final int width;
    private final char[][] ladder;

    Ladder(int person, int height) {
        this.person = person;
        this.height = height;
        this.width = 2 * person - 1;
        ladder = new char[height][width];
    }

    public void makeLadder() {
        for (int row = 0; row < height; row++) {
            makeLadderRow(row);
        }
    }

    private void makeLadderRow(int row) {
        for (int col = 0; col < width; col++) {
            ladder[row][col] = decideLadderCell(col);
        }
    }

    private char decideLadderCell(int col) {
        char AXIS_VER = '|';
        char AXIS_VOID = ' ';
        char AXIS_HOR = '-';
        if (col % 2 == 0) return AXIS_VER;
        return Math.random() < 0.5 ? AXIS_VOID : AXIS_HOR;
    }

    public void printLadder() {
        for (int row = 0; row < height; row++) {
            printLadderRow(row);
            System.out.println();
        }
    }

    private void printLadderRow(int row) {
        for (int col = 0; col < width; col++) {
            System.out.print(ladder[row][col]);
        }
    }
}

