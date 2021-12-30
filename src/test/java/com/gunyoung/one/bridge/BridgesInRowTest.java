package com.gunyoung.one.bridge;

import com.gunyoung.one.testutils.ReflectionTestUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgesInRowTest {

    private static final String BRIDGES_FIELD_NAME = "bridges";
    private static final int DEFAULT_CAPACITY = 10;

    @Test
    void 최대로_가능한_다리_개수_반환() {
        //Given
        int maxNumOfBridgesForEachRow = 10;
        BridgesInRow bridgesInRow = getBridgesInRowForTest(maxNumOfBridgesForEachRow);

        //When
        int result = bridgesInRow.getMaxNumOfBridges();

        //Then
        assertEquals(maxNumOfBridgesForEachRow, result);
    }

    @Test
    void 다리들의_존재여부_반환_최초에는_하나도없음() {
        //Given
        BridgesInRow bridgesInRow = getBridgesInRowForTest();

        //When
        List<Boolean> result = bridgesInRow.getIsExistOfRow();

        //Then
        assertAllFalse(result);
    }

    private void assertAllFalse(List<Boolean> result) {
        for (Boolean isExist : result) {
            assertFalse(isExist);
        }
    }

    @Test
    void 다리들의_존재여부_반환_몇개는존재() {
        //Given
        BridgesInRow bridgesInRow = getBridgesInRowForTest();
        List<Integer> existIndexes = List.of(0, DEFAULT_CAPACITY / 2, DEFAULT_CAPACITY - 1);
        addBridgesForIndexes(bridgesInRow, existIndexes);

        //When
        List<Boolean> result = bridgesInRow.getIsExistOfRow();

        //Then
        assertTrueForIndexes(result, existIndexes);
    }

    private void addBridgesForIndexes(BridgesInRow bridgesInRow, List<Integer> existIndexes) {
        for(int index: existIndexes) {
            bridgesInRow.addBridge(index);
        }
    }

    private void assertTrueForIndexes(List<Boolean> result, List<Integer> indexes) {
        for(int i = 0; i < result.size(); i++) {
            if(indexes.contains(i)) {
                assertTrue(result.get(i));
            } else {
                assertFalse(result.get(i));
            }
        }
    }

    @Test
    void 특정_위치에_다리_추가() {
        //Given
        int indexWhereAddBridge = DEFAULT_CAPACITY / 2;
        BridgesInRow bridgesInRow = getBridgesInRowForTest();

        //When
        bridgesInRow.addBridge(indexWhereAddBridge);

        //Then
        assertTrue(isExistIn(bridgesInRow, indexWhereAddBridge));
    }

    private BridgesInRow getBridgesInRowForTest() {
        return getBridgesInRowForTest(DEFAULT_CAPACITY);
    }

    private BridgesInRow getBridgesInRowForTest(int maxNumOfBridgesForEachRow) {
        return BridgesInRow.ofCapacity(maxNumOfBridgesForEachRow);
    }

    private List<Bridge> getBridges(BridgesInRow bridgesInRow) {
        return (List<Bridge>) ReflectionTestUtils.getField(bridgesInRow, BRIDGES_FIELD_NAME);
    }

    private boolean isExistIn(BridgesInRow bridgesInRow, int index) {
        List<Bridge> bridges = getBridges(bridgesInRow);
        return bridges.get(index).isExist();
    }
}