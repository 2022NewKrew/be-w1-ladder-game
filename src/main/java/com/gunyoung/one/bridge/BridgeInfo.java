package com.gunyoung.one.bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeInfo {
    private final Bridge[][] bridges;
    private final BridgeMakeStrategy makeStrategy;

    public BridgeInfo(int ladderHeight, int maxNumOfBridgesForEachRow) {
        this(ladderHeight, maxNumOfBridgesForEachRow, new RandomBridgeStrategy());
    }

    public BridgeInfo(int ladderHeight, int maxNumOfBridgesForEachRow, BridgeMakeStrategy makeStrategy) {
        this.bridges = new Bridge[ladderHeight][maxNumOfBridgesForEachRow];
        this.makeStrategy = makeStrategy;
    }

    public void makeBridges() {
        makeStrategy.makeBridges(bridges);
    }

    public List<Boolean> getIsExistOfRow(int row) {
        List<Boolean> isExistOfRow = new ArrayList<>(bridges[row].length);
        for (Bridge bridge : bridges[row]) {
            isExistOfRow.add(bridge.isExist());
        }
        return isExistOfRow;
    }
}
