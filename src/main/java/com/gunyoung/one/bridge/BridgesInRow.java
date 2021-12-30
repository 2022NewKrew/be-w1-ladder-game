package com.gunyoung.one.bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgesInRow {
    private List<Bridge> bridges;

    private BridgesInRow(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static BridgesInRow ofCapacity(int maxNumOfBridgesForEachRow) {
        List<Bridge> newBridges = getEmptyBridges(maxNumOfBridgesForEachRow);
        return new BridgesInRow(newBridges);
    }

    private static List<Bridge> getEmptyBridges(int maxNumOfBridgesForEachRow) {
        List<Bridge> bridges = new ArrayList<>(maxNumOfBridgesForEachRow);
        for(int i = 0; i < maxNumOfBridgesForEachRow; i++) {
            bridges.add(Bridge.of(false));
        }
        return bridges;
    }

    public int getMaxNumOfBridges() {
        return bridges.size();
    }

    public List<Boolean> getIsExistOfRow() {
        List<Boolean> isExistOfRow = new ArrayList<>(getMaxNumOfBridges());
        for (Bridge bridge : bridges) {
            isExistOfRow.add(bridge.isExist());
        }
        return isExistOfRow;
    }

    public void addBridge(int index) {
        Bridge bridge = bridges.get(index);
        bridge.addBridge();
    }
}
