package service;

import domain.sadari.SadariMap;
import domain.sadari.SadariMapStatus;

import java.util.Random;

public class SadariMakerImpl implements SadariMaker {

    private final Random random = new Random();
    private final SadariMap sadariMap;

    public SadariMakerImpl(SadariMap sadariMap) {
        this.sadariMap = sadariMap;
    }

    @Override
    public void makeSadariGame() {
        for (int i = 0; i < sadariMap.getNumberOfRow(); i++) {
            makeRow(i);
        }
    }

    private void makeRow(int rowNumber) {
        for (int i = 0; i < sadariMap.getNumberOfColumn(); i++) {
            makeSadariMapStatus(rowNumber, i);
        }

        sadariMap.storeSadariMapStatus(rowNumber, SadariMapStatus.END);
    }

    private void makeSadariMapStatus(int rowNumber, int columnNumberOfRow) {
        if (sadariMap.isBorder(columnNumberOfRow)) {
            sadariMap.storeSadariMapStatus(rowNumber,SadariMapStatus.SADARI_BORDER);
            return;
        }

        makeSadariLine(rowNumber, columnNumberOfRow);
    }

    private void makeSadariLine(int rowNumber, int columnNumberOfRow) {
        if (canMakeSadariLine(rowNumber, columnNumberOfRow)) {
            sadariMap.storeSadariMapStatus(rowNumber, SadariMapStatus.SADARI_LINE);
            return;
        }

        sadariMap.storeSadariMapStatus(rowNumber, SadariMapStatus.EMPTY);
    }

    private boolean canMakeSadariLine(int rowNumber, int columnNumberOfRow) {
        if (sadariMap.isNotExistPreviousSadariLine(rowNumber, columnNumberOfRow)) {
            return random.nextBoolean();
        }

        return false;
    }
}
