import java.util.ArrayList;
import java.util.List;

public class SadariMap {

    private final int numberOfColumn;
    private final int numberOfRow;
    private final List<List<SadariMapStatus>> sadariMap = new ArrayList<>();

    public SadariMap(int numberOfPeople, int numberOfLadder) {
        initialSadariMap(numberOfLadder);
        this.numberOfColumn = numberOfPeople * 2 - 1;
        this.numberOfRow = numberOfLadder;
    }

    private void initialSadariMap(int numberOfLadder) {
        for (int i = 0; i < numberOfLadder; i++) {
            sadariMap.add(new ArrayList<>());
        }
    }

    public int getNumberOfColumn() {
        return numberOfColumn;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void storeLine(int rowNumber, SadariMapStatus sadariMapStatus) {
        sadariMap.get(rowNumber).add(sadariMapStatus);
    }

    public boolean isFirstSadariLineOfRow(int columnNumberOfRow) {
        return columnNumberOfRow == 1;
    }

    public boolean isExistSadariLineCloseBy(int rowNumber, int columnNumberOfRow) {
        return sadariMap.get(rowNumber).get(columnNumberOfRow - 2) == SadariMapStatus.EMPTY;
    }

    public List<List<SadariMapStatus>> getSadariMap() {
        return sadariMap;
    }
}
