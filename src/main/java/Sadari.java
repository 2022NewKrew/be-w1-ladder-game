import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sadari {

    private final Random random = new Random();
    private final List<List<LineStatus>> sadariGameMap = new ArrayList<>();
    private final int numberOfColumn;
    private final int numberOfRow;

    public Sadari(int numberOfPeople, int numberOfLadder) {
        initialSadariGameMap(numberOfLadder);
        this.numberOfColumn = numberOfPeople * 2 - 1;
        this.numberOfRow = numberOfLadder;
    }

    private void initialSadariGameMap(int numberOfLadder) {
        for (int i = 0; i < numberOfLadder; i++) {
            sadariGameMap.add(new ArrayList<>());
        }
    }

    public void makeSadariGame() {
        for (int i = 0; i < numberOfRow; i++) {
            makeRow(i);
        }
    }

    private void makeRow(int rowNumber) {
        for (int i = 0; i < numberOfColumn; i++) {
            makeLine(rowNumber,i);
        }

        sadariGameMap.get(rowNumber).add(LineStatus.END);
    }

    private void makeLine(int rowNumber, int columnNumberOfRow) {
        if (LineStatus.isBorder(columnNumberOfRow)) {
            sadariGameMap.get(rowNumber).add(LineStatus.BORDER);
            return;
        }

        makeSadariLine(rowNumber);
    }

    private void makeSadariLine(int rowNumber) {
        if (canMakeSadariLine()) {
            sadariGameMap.get(rowNumber).add(LineStatus.SADARI_LINE);
            return;
        }

        sadariGameMap.get(rowNumber).add(LineStatus.EMPTY);
    }

    private boolean canMakeSadariLine() {
        return random.nextBoolean();
    }

    public void printSadariGame() {
        for (List<LineStatus> lines : sadariGameMap) {
            lines.forEach(LineStatus::printStatus);
        }
    }
}
