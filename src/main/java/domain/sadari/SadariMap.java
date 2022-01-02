package domain.sadari;

import java.util.ArrayList;
import java.util.List;

public class SadariMap {

    private final int numberOfColumn;
    private final int numberOfRow;
    private final List<SadariRow> sadariMap = new ArrayList<>();

    public SadariMap(int numberOfPeople, int numberOfLadder) {
        initialSadariMap(numberOfLadder);
        this.numberOfColumn = numberOfPeople * 2 - 1;
        this.numberOfRow = numberOfLadder;
    }

    private void initialSadariMap(int numberOfLadder) {
        for (int i = 0; i < numberOfLadder; i++) {
            sadariMap.add(new SadariRow());
        }
    }

    public int getNumberOfColumn() {
        return numberOfColumn;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void storeSadariMapStatus(int rowNumber, SadariMapStatus sadariMapStatus) {
        sadariMap.get(rowNumber).addSadariMapStatus(sadariMapStatus);
    }

    public boolean isBorder(int columnNumberOfRow) {
        return columnNumberOfRow % 2 == 0;
    }

    public void printSadari() {
        sadariMap.forEach(SadariRow::printSadariRow);
    }

    public boolean isNotExistPreviousSadariLine(int rowNumber, int columnNumberOfRow) {
        if (isFirstSadariLineOfRow(columnNumberOfRow)) {
            return true;
        }

        return sadariMap.get(rowNumber).getSadariMapStatus(columnNumberOfRow - 2) == SadariMapStatus.EMPTY;
    }

    public boolean isLeftConnected(int rowNumber, int columnNumberOfRow) {
        if (isFirstSadariMapStatusOfRow(columnNumberOfRow)) {
            return false;
        }

        return sadariMap.get(rowNumber).getSadariMapStatus(columnNumberOfRow - 1) == SadariMapStatus.SADARI_LINE;
    }

    public boolean isRightConnected(int rowNumber, int columnNumberOfRow) {
        if (isLastSadariMapStatusOfRow(columnNumberOfRow)) {
            return false;
        }

        return sadariMap.get(rowNumber).getSadariMapStatus(columnNumberOfRow + 1) == SadariMapStatus.SADARI_LINE;
    }

    private boolean isFirstSadariLineOfRow(int columnNumberOfRow) {
        return columnNumberOfRow == 1;
    }

    private boolean isFirstSadariMapStatusOfRow(int columnNumberOfRow) {
        return columnNumberOfRow == 0;
    }

    private boolean isLastSadariMapStatusOfRow(int columnNumberOfRow) {
        return columnNumberOfRow == numberOfColumn - 1;
    }

    private boolean isLastSadariLineOfRow(int columnNumberOfRow) {
        return columnNumberOfRow == numberOfColumn - 2;
    }
}
