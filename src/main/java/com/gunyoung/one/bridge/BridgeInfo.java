package com.gunyoung.one.bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeInfo {
    private final List<BridgesInRow> bridges;
    private final BridgeMakeStrategy makeStrategy;

    public BridgeInfo(int ladderHeight, int maxNumOfBridgesForEachRow) {
        this(ladderHeight, maxNumOfBridgesForEachRow, new RandomBridgeStrategy());
    }

    public BridgeInfo(int ladderHeight, int maxNumOfBridgesForEachRow, BridgeMakeStrategy makeStrategy) {
        this.bridges = new ArrayList<>(ladderHeight);
        for(int i = 0; i < ladderHeight; i++) {
            this.bridges.add(BridgesInRow.ofCapacity(maxNumOfBridgesForEachRow));
        }
        this.makeStrategy = makeStrategy;
    }

    public void makeBridges() {
        makeStrategy.makeBridges(bridges);
    }

    public List<Boolean> getIsExistOfRow(int row) {
        return bridges.get(row).getIsExistOfRow();
    }
}
