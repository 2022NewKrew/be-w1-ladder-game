package com.gunyoung.one.boot;

import com.gunyoung.one.exceptions.NonInilizationException;

import java.util.Random;

public final class Ladder {

    private static Ladder INSTANCE;

    private int numOfUser;
    private int ladderHeight;
    private boolean[][] bridges;

    public static Ladder getInstance() {
        if (INSTANCE == null)
            throw new NonInilizationException("Ladder is not initialized");
        return INSTANCE;
    }

    static void init(int numOfUser, int ladderHeight) {
        INSTANCE = new Ladder(numOfUser, ladderHeight);
    }

    private Ladder(int numOfUser, int ladderHeight) {
        this.numOfUser = numOfUser;
        this.ladderHeight = ladderHeight;
        makeBridge();
    }

    private void makeBridge() {
        bridges = new boolean[ladderHeight][numOfUser - 1];
        Random random = new Random();
        for (int row = 0; row < ladderHeight; row++) {
            makeBridgesForEachRowRandomly(random, row);
        }
    }

    private void makeBridgesForEachRowRandomly(Random random, int row) {
         for(int j = 0; j < bridges[row].length ; j++) {
            bridges[row][j] = random.nextBoolean();
        }
    }

    String getShapeOfLadder() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < ladderHeight; row++) {
            getShapeForEachRow(sb, row);
        }
        return sb.toString();
    }

    private void getShapeForEachRow(StringBuilder sb, int row) {
        sb.append("|");
        for(int col = 1; col < numOfUser; col++) {
            sb.append(getSignatureOfBridge(row, col))
                    .append("|");
        }
        sb.append("\n");
    }

    private String getSignatureOfBridge(int row, int col) {
        if(bridges[row][col-1])
            return "-";
        return " ";
    }
}
