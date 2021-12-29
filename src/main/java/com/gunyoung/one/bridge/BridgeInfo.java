package com.gunyoung.one.bridge;

import com.gunyoung.one.ladder.Ladder;

import java.util.ArrayList;
import java.util.List;

public class BridgeInfo {
    private final Bridge[][] bridges;
    private final BridgeMakeStrategy makeStrategy;

    public BridgeInfo(Ladder ladder) {
        this(ladder, new RandomBridgeStrategy());
    }

    public BridgeInfo(Ladder ladder, BridgeMakeStrategy makeStrategy) {
        int ladderHeight = ladder.getLadderHeight();
        int maxNumOfBridgesForEachRow = ladder.getNumOfUser() - 1;
        this.bridges = new Bridge[ladderHeight][maxNumOfBridgesForEachRow];
        this.makeStrategy = makeStrategy;
    }

    public void makeBridges() {
        makeStrategy.makeBridges(bridges);
    }

    public List<Boolean> getIsExistOfRow(int row) {
        List<Boolean> isExistOfRow = new ArrayList<>(bridges[row].length);
        for(Bridge bridge: bridges[row]) {
            isExistOfRow.add(bridge.isExist());
        }
        return isExistOfRow;
    }
}
