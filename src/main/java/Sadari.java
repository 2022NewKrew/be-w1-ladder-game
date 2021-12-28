import java.util.Random;

public class Sadari {

    private final int numberOfColumn;
    private final int numberOfRow;

    public Sadari(int numberOfPeople, int numberOfLadder) {
        this.numberOfColumn = numberOfPeople * 2 - 1;
        this.numberOfRow = numberOfLadder;
    }

    public int getNumberOfColumn() {
        return numberOfColumn;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void printSadariGame() {
        for (int i = 0; i < getNumberOfRow(); i++)
            printRowLine();
    }

    private void printRowLine() {
        for (int i = 0; i < getNumberOfColumn(); i++)
            printSadariStatus(i);

        System.out.println();
    }

    private void printSadariStatus(int columnNumberOfRow) {
        if (SadariStatus.isBorder(columnNumberOfRow)) {
            SadariStatus.BORDER.printStatus();
            return;
        }

        printSadariLine();
    }

    private static void printSadariLine() {
        if (canPrintSadariLine()) {
            SadariStatus.LINE.printStatus();
            return;
        }

        SadariStatus.EMPTY.printStatus();
    }

    private static boolean canPrintSadariLine() {
        return new Random().nextBoolean();
    }

}
