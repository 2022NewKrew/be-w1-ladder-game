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

    public boolean isNotExistSadariLineCloseBy(int rowNumber, int columnNumberOfRow) {
        if (isFirstSadariLineOfRow(columnNumberOfRow)) {
            return true;
        }

        return sadariMap.get(rowNumber).getSadariMapStatus(columnNumberOfRow - 2) == SadariMapStatus.EMPTY;
    }

    private boolean isFirstSadariLineOfRow(int columnNumberOfRow) {
        return columnNumberOfRow == 1;
    }

    public void printSadari() {
        sadariMap.forEach(SadariRow::printSadariRow);
    }
}
