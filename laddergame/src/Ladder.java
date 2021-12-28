package laddergame;

public class Ladder {
    int person;
    int height;
    int width;
    char[][] ladder;

    Ladder(int person, int height) {
        this.person = person;
        this.height = height;
        this.width = 2 * person - 1;
        ladder = new char[height][width];
    }

    void setLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ladder[i][j] = decideLadderPiece(j);
            }
        }
    }

    char decideLadderPiece(int j) {
        if (j % 2 == 0) return '|';
        return Math.random() < 0.5 ? ' ' : '-';
    }

    void printLadder() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }
}

