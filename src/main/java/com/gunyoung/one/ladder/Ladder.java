package com.gunyoung.one.ladder;

import com.gunyoung.one.precondition.Precondition;

public final class Ladder {

    private static Ladder INSTANCE;

    private final int numOfUser;
    private final int ladderHeight;
    private final Bridge bridge;

    public static Ladder getInstance() {
        Precondition.notNull(INSTANCE, "Ladder is not initialized");
        return INSTANCE;
    }

    public static void init(int numOfUser, int ladderHeight) {
        INSTANCE = new Ladder(numOfUser, ladderHeight);
    }

    private Ladder(int numOfUser, int ladderHeight) {
        Precondition.notLessThanInt(numOfUser, 1, "유저의 수는 한명 이상이여야 합니다.");
        Precondition.notLessThanInt(ladderHeight, 1, "사다리의 높이는 1 이상이여야 합니다.");

        this.numOfUser = numOfUser;
        this.ladderHeight = ladderHeight;
        this.bridge = new Bridge(this);
        this.bridge.makeBridges();
    }

    public int getNumOfUser() {
        return numOfUser;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public String getShapeOfLadder() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < ladderHeight; row++) {
            getShapeForEachRow(sb, row);
        }
        return sb.toString();
    }

    private void getShapeForEachRow(StringBuilder sb, int row) {
        sb.append("|");
        for(int col = 1; col < numOfUser; col++) {
            sb.append(
                    bridge.getSignatureOfBridge(row, col)
            ).append("|");
        }
        sb.append("\n");
    }

    private static class Bridge {
        private final boolean[][] bridges;
        private BridgeMakeStrategy makeStrategy;

        private Bridge(Ladder ladder) {
            this(ladder, new RandomBridgeStrategy());
        }

        private Bridge(Ladder ladder, BridgeMakeStrategy makeStrategy) {
            this.bridges = new boolean[ladder.getLadderHeight()][ladder.getNumOfUser()];
            this.makeStrategy = makeStrategy;
        }

        private void makeBridges() {
            makeStrategy.makeBridges(bridges);
        }

        private String getSignatureOfBridge(int row, int col) {
            if(bridges[row][col-1])
                return "-";
            return " ";
        }

    }
}
