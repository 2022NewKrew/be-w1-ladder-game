package com.gunyoung.one.bridge;

import com.gunyoung.one.utils.RandomMaker;

import java.util.List;

public class RandomBridgeStrategy implements BridgeMakeStrategy {

    private RandomMaker randomMaker;

    public RandomBridgeStrategy() {
        this(new RandomMaker());
    }

    public RandomBridgeStrategy(RandomMaker randomMaker) {
        this.randomMaker = randomMaker;
    }

    @Override
    public void makeBridges(List<BridgesInRow> bridges) {
        for (int row = 0; row < bridges.size(); row++) {
            makeBridgesForEachRowRandomly(bridges, row);
        }
    }

    private void makeBridgesForEachRowRandomly(List<BridgesInRow> bridges, int row) {
        int maxNumOfBridgesInOneRow = bridges.get(row).getMaxNumOfBridges();
        boolean[] isExist = getIsExistByRandom(maxNumOfBridgesInOneRow);
        removeConsecutiveTrueRandomly(isExist);
        makeBridgesOfRowByIsExist(bridges, row, isExist);
    }

    private boolean[] getIsExistByRandom(int maxNumOfBridgesInOneRow) {
        boolean[] isExist = new boolean[maxNumOfBridgesInOneRow];
        for (int i = 0; i < isExist.length; i++) {
            isExist[i] = randomMaker.getRandomBoolean();
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
        if (randomMaker.getRandomBoolean())
            return index;
        return index + 1;
    }

    private void makeBridgesOfRowByIsExist(List<BridgesInRow> bridges, int row, boolean[] isExist) {
        for (int i = 0; i < isExist.length; i++) {
            if(isExist[i])
                bridges.get(row).addBridge(i);
        }
    }
}
