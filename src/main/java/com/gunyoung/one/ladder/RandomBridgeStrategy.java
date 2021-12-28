package com.gunyoung.one.ladder;

import java.util.Random;

public class RandomBridgeStrategy implements BridgeMakeStrategy {

    private Random random = new Random();

    @Override
    public void makeBridges(boolean[][] bridges) {
        for (int row = 0; row < bridges.length; row++) {
            makeBridgesForEachRowRandomly(bridges, row);
        }
    }

    private void makeBridgesForEachRowRandomly(boolean[][] bridges, int row) {
        for (int col = 0; col < bridges[row].length; col++) {
            bridges[row][col] = random.nextBoolean();
        }
    }
}
