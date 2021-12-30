package com.gunyoung.one.bridge;

import com.gunyoung.one.utils.RandomMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class RandomBridgeStrategyTest {

    private RandomMaker mockRandomMaker;

    @BeforeEach
    void setUp() {
        mockRandomMaker = mock(RandomMaker.class);
    }

    @Test
    void BridgesInfo_리스트에_다리들_생성_RandomMaker_항상true반환() {
        //Given
        RandomBridgeStrategy randomBridgeStrategy = new RandomBridgeStrategy(mockRandomMaker);
        given(mockRandomMaker.getRandomBoolean()).willReturn(true);

        int ladderHeight = 10;
        int maxNumOfBridgesForEachRow = 10;
        List<BridgesInRow> bridgesInRowList = getListOFBridgesInRow(ladderHeight, maxNumOfBridgesForEachRow);

        //When
        randomBridgeStrategy.makeBridges(bridgesInRowList);

        //Then
        assertThereIsNoConsecutiveBridge(bridgesInRowList);
    }

    private List<BridgesInRow> getListOFBridgesInRow(int ladderHeight, int maxNumOfBridgesForEachRow) {
        List<BridgesInRow> list = new ArrayList<>();
        for(int i = 0; i < ladderHeight; i++) {
            list.add(BridgesInRow.ofCapacity(maxNumOfBridgesForEachRow));
        }
        return list;
    }

    private void assertThereIsNoConsecutiveBridge(List<BridgesInRow> bridgesInRowList) {
        for(BridgesInRow bridgesInRow: bridgesInRowList) {
            assertThereIsNoConsecutiveBridgeInOneRow(bridgesInRow);
        }
    }

    private void assertThereIsNoConsecutiveBridgeInOneRow(BridgesInRow bridgesInRow) {
        List<Boolean> isExistOfRow = bridgesInRow.getIsExistOfRow();
        for(int i = 0; i < isExistOfRow.size() - 1; i++) {
            assertThatNoTrueAndTrue(isExistOfRow.get(i), isExistOfRow.get(i+1));
        }
    }

    private void assertThatNoTrueAndTrue(Boolean first, Boolean second) {
        assertFalse(first && second);
    }
}