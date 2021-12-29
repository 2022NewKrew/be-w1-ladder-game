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
        for (int col = 0; col < bridges[row].length; col++) {
            boolean isExist = random.nextBoolean();
            bridges[row][col] = Bridge.of(isExist);
        }
    }

}
