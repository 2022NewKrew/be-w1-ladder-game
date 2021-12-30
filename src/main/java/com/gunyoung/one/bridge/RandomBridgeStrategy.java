package com.gunyoung.one.bridge;

import java.util.Random;

public class RandomBridgeStrategy implements BridgeMakeStrategy {

    private Random random = new Random();

    @Override
    public void makeBridges(Bridge[][] bridges) {
        for (int row = 0; row < bridges.length; row++) {
            makeBridgesForEachRowRandomly(bridges, row);
        }
    }

    private void makeBridgesForEachRowRandomly(Bridge[][] bridges, int row) {
        int maxNumOfBridgesInOneRow = bridges[row].length;
        boolean[] isExist = getIsExistByRandom(maxNumOfBridgesInOneRow);
        removeConsecutiveTrueRandomly(isExist);
        makeBridgesOfRowByIsExist(bridges, row, isExist);
    }

    private boolean[] getIsExistByRandom(int maxNumOfBridgesInOneRow) {
        boolean[] isExist = new boolean[maxNumOfBridgesInOneRow];
        for (int i = 0; i < isExist.length; i++) {
            isExist[i] = random.nextBoolean();
        }
        return isExist;
    }

    private void removeConsecutiveTrueRandomly(boolean[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            removeTrueIfCurrentAndNextBothTrue(arr, i);
        }
    }

    private void removeTrueIfCurrentAndNextBothTrue(boolean[] arr, int index) {
        if (!isBothCurrentAndNextTrue(arr, index))
            return;
        int removeIndex = getCurrentOrNextIndexRandomly(arr, index);
        arr[removeIndex] = false;
    }

    private boolean isBothCurrentAndNextTrue(boolean[] arr, int index) {
        return arr[index] && arr[index + 1];
    }

    private int getCurrentOrNextIndexRandomly(boolean[] arr, int index) {
        if (random.nextBoolean())
            return index;
        return index + 1;
    }

    private void makeBridgesOfRowByIsExist(Bridge[][] bridges, int row, boolean[] isExist) {
        for (int i = 0; i < isExist.length; i++) {
            bridges[row][i] = Bridge.of(isExist[i]);
        }
    }
}
