import java.util.Random;

public class SadariMaker {

    private final Random random = new Random();
    private final SadariMap sadariMap;

    public SadariMaker(SadariMap sadariMap) {
        this.sadariMap = sadariMap;
    }

    public void makeSadariGame() {
        for (int i = 0; i < sadariMap.getNumberOfRow(); i++) {
            makeRow(i);
        }
    }

    private void makeRow(int rowNumber) {
        for (int i = 0; i < sadariMap.getNumberOfColumn(); i++) {
            makeLine(rowNumber, i);
        }

        sadariMap.storeLine(rowNumber, SadariMapStatus.END);
    }

    private void makeLine(int rowNumber, int columnNumberOfRow) {
        if (SadariMapStatus.isBorder(columnNumberOfRow)) {
            sadariMap.storeLine(rowNumber,SadariMapStatus.SADARI_BORDER);
            return;
        }

        makeSadariLine(rowNumber, columnNumberOfRow);
    }

    private void makeSadariLine(int rowNumber, int columnNumberOfRow) {
        if (canMakeSadariLine(rowNumber, columnNumberOfRow)) {
            sadariMap.storeLine(rowNumber, SadariMapStatus.SADARI_LINE);
            return;
        }

        sadariMap.storeLine(rowNumber, SadariMapStatus.EMPTY);
    }

    private boolean canMakeSadariLine(int rowNumber, int columnNumberOfRow) {
        if (sadariMap.isFirstSadariLineOfRow(columnNumberOfRow)) {
            return random.nextBoolean();
        }

        if (sadariMap.isExistSadariLineCloseBy(rowNumber, columnNumberOfRow)) {
            return random.nextBoolean();
        }

        return false;
    }
}
