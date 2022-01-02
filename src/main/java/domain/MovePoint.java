package domain;

import domain.sadari.SadariMap;

public class MovePoint {

    private int rowNumber;
    private int columnNumberOfRow;
    private final SadariMap sadariMap;

    public MovePoint(int startUserNumber, SadariMap sadariMap) {
        this.rowNumber = 0;
        this.columnNumberOfRow = startUserNumber * 2 - 2;
        this.sadariMap = sadariMap;
    }

    public void move() {
        if (sadariMap.isLeftConnected(rowNumber, columnNumberOfRow)) {
            moveLeftDown();
            return;
        }

        if (sadariMap.isRightConnected(rowNumber, columnNumberOfRow)) {
            moveRightDown();
            return;
        }

        rowNumber++;
    }

    private void moveLeftDown() {
        columnNumberOfRow -= 2;
        rowNumber++;
    }

    private void moveRightDown() {
        columnNumberOfRow += 2;
        rowNumber++;
    }

    public int getNumber() {
        return columnNumberOfRow / 2 + 1;
    }

}
