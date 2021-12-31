package domain;

public class User {
    private final String name;
    private int row;
    private int col;

    public User(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public int getResultOfMovingOnLadder(Ladder ladder) {
        if (row == ladder.getLadderHeight()) {
            return col;
        }
        if (ladder.canMoveLeft(row, col)) {
            moveLeft();
            return getResultOfMovingOnLadder(ladder);
        }
        if (ladder.canMoveRight(row, col)) {
            moveRight();
            return getResultOfMovingOnLadder(ladder);
        }
        moveDown();
        return getResultOfMovingOnLadder(ladder);
    }

    private void moveDown() {
        row++;
    }

    private void moveRight() {
        col++;
        row++;
    }

    private void moveLeft() {
        col--;
        row++;
    }
}
